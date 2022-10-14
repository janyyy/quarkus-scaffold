package com.yujianyou.utils;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yujianyou
 * @date 2021/12/6 17:17
 * @email 597907730@qq.com
 */
@Slf4j
public class TokenUtils {

    public static final String S_AUTHORIZATION = "Authorization";
    public static final String S_BEARER = "Bearer ";


    /**
     * JWT TOKEN生成
     *
     * @param username /
     * @param roles    /
     * @param duration /
     * @param issuer   /
     * @return /
     * @throws Exception /
     */

    public static String generateToken(String username, Set<String> roles, Long duration, String issuer) throws Exception {
        // 私钥
        String privateKeyLocation = "/privateKey.pem";

        PrivateKey privateKey = readPrivateKey(privateKeyLocation);

        JwtClaimsBuilder claimsBuilder = Jwt.claims();
        long currentTimeInSecs = currentTimeInSecs();
        // 权限信息
        Set<String> groups = new HashSet<>(roles);
        claimsBuilder.issuer(issuer);
        claimsBuilder.subject(username);
        claimsBuilder.issuedAt(currentTimeInSecs);
        claimsBuilder.expiresAt(currentTimeInSecs + duration);
        claimsBuilder.groups(groups);
        return S_BEARER + claimsBuilder.jws().keyId(privateKeyLocation).sign(privateKey);
    }

    public static PrivateKey readPrivateKey(final String pemResName) throws Exception {
        try (InputStream contentIs = TokenUtils.class.getResourceAsStream(pemResName)) {
            byte[] tmp = new byte[4096];
            assert contentIs != null;
            int length = contentIs.read(tmp);
            return decodePrivateKey(new String(tmp, 0, length, StandardCharsets.UTF_8));
        }
    }

    public static PrivateKey decodePrivateKey(final String pemEncoded) throws Exception {
        byte[] encodedBytes = toEncodedBytes(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

    public static byte[] toEncodedBytes(final String pemEncoded) {
        final String normalizedPem = removeBeginEnd(pemEncoded);
        return Base64.getDecoder().decode(normalizedPem);
    }

    public static String removeBeginEnd(String pem) {
        pem = pem.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        return pem.trim();
    }

    public static int currentTimeInSecs() {
        long currentTimeMs = System.currentTimeMillis();
        return (int) (currentTimeMs / 1000);
    }

    public static String getByRequest(HttpServerRequest request) {
        if (request == null) {
            return "";
        }
        String token = request.getHeader(S_AUTHORIZATION);
        if (StringUtil.isEmpty(token)) {
            return "";
        }
        token = StringUtil.subAfter(token, S_BEARER, true);
        return token;
    }

}
