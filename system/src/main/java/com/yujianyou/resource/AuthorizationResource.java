package com.yujianyou.resource;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.wf.captcha.base.Captcha;
import com.yujianyou.config.login.LoginCodeEnum;
import com.yujianyou.config.login.LoginProperties;
import com.yujianyou.dto.AuthUserDto;
import com.yujianyou.dto.JwtUserDto;
import com.yujianyou.dto.UserDto;
import com.yujianyou.entity.User;
import com.yujianyou.rest.dto.RedisDto;
import com.yujianyou.rest.service.RedisRestClientService;
import com.yujianyou.service.MenuService;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.RsaUtils;
import com.yujianyou.utils.StringUtil;
import com.yujianyou.utils.TokenUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * @author yujianyou
 * @date 2021/11/29 17:47
 * @email 597907730@qq.com
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "AuthorizationResource", description = "登录相关接口")
public class AuthorizationResource {

    @ConfigProperty(name = "rsa.privateKey")
    String privateKey;

    @Inject
    RedisRestClientService redisService;

    @Inject
    LoginProperties loginProperties;

    @Inject
    UserService userService;

    @Inject
    MenuService menuService;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "jwt.duration")
    Long duration;

    @Inject
    JsonWebToken jwt;


    @GET
    @Path("/code")
    @Operation(summary = "获取验证码信息")
    public Response getCode() {
        // 获取运算的结果
        Captcha captcha = loginProperties.getCaptcha();
        String uuid = "login-code" + IdUtil.simpleUUID();
        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == LoginCodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        RedisDto redisDto = new RedisDto();
        redisDto.setKey(uuid);
        redisDto.setValue(captchaValue);
        redisDto.setTime(loginProperties.getLoginCode().getExpiration());
        redisService.set(redisDto);
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return Response.ok().entity(imgResult).build();
    }

    @POST
    @Path("/login")
    @Operation(summary = "登录授权")
    public Response login(@Valid @RequestBody AuthUserDto authUserDto) throws Exception {
        // 密码解密
        String password = RsaUtils.decryptByPrivateKey(privateKey, authUserDto.getPassword());
        // 查询验证码
        String code = redisService.get(authUserDto.getUuid());
        // 清除验证码
        redisService.delete(authUserDto.getUuid());

        if (StringUtil.isBlank(code)) {
            throw new BadRequestException("验证码不存在或已过期");
        }

        if (StringUtil.isBlank(authUserDto.getCode()) || !authUserDto.getCode().equalsIgnoreCase(code)) {
            throw new BadRequestException("验证码错误");
        }
        // 获取数据库用户信息
        User userInfo = userService.findByUserName(authUserDto.getUsername());
        if (ObjectUtil.isNull(userInfo)) {
            throw new BadRequestException("用户不存在！");
        }

        if (!SecureUtil.md5(password).equals(userInfo.getPassword())) {
            throw new BadRequestException("密码不正确！");
        }

        if (!userInfo.getEnabled()) {
            throw new BadRequestException("账号未激活！");
        }

        // 用户信息
        JwtUserDto jwtUserDto = new JwtUserDto();
        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(userInfo, userDto);

        jwtUserDto.setUser(userDto);
        Set<String> roles = new HashSet<>();
        if (userInfo.getIsAdmin()) {
            roles.add("admin");
        } else {
            roles.addAll(Convert.toSet(String.class, menuService.findCurrentUserPermission(userInfo.getId())));
        }
        jwtUserDto.setRoles(roles);
        // 返回出参封装
        Map<String, Object> resultMap = new LinkedHashMap<>(2);
        resultMap.put("user", jwtUserDto);
        // TOKEN有效期设置为7天
        resultMap.put("token", TokenUtils.generateToken(userInfo.getUsername(), roles, duration, issuer));

        return Response.ok(resultMap).build();
    }

    /**
     * 获取用户信息
     *
     * @return /
     */
    @GET
    @Path("/info")
    @Operation(summary = "获取用户信息")
    public Response getUserInfo() {
        Map<String, Object> map = new LinkedHashMap<>(2);
        User userInfo = userService.findCurrentUser(jwt.getName());
        map.put("user", userInfo);
        Set<String> roles = new HashSet<>();
        if (userInfo.getIsAdmin()) {
            roles.add("admin");
        } else {
            roles.addAll(Convert.toSet(String.class, menuService.findCurrentUserPermission(userInfo.getId())));
        }
        map.put("roles", roles);
        return Response.ok(map).build();
    }

    /**
     * 注销登录
     *
     * @return /
     */
    @DELETE
    @Path("/logout")
    @PermitAll
    public Response logout() {
        return Response.ok().build();
    }
}
