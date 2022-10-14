package com.yujianyou.utils;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yujianyou.constant.SystemConstant;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.ConfigProvider;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
 * 字符串处理工具
 */
@Slf4j
@ApplicationScoped
public class StringUtil extends StrUtil {

    private static final String UNKNOWN = "unknown";


    public static Boolean ipLocal = ConfigProvider.getConfig().getValue("ip.local-parsing", Boolean.class);

    public static Resource ip2regionResource = ResourceUtil.getResourceObj("city/ip2region.db");


    public static String getBrowser(HttpServerRequest request) {
        UserAgent.ImmutableUserAgent userAgent = USER_AGENT_ANALYZER.parse(request.getHeader("User-Agent"));
        return userAgent.get(UserAgent.AGENT_NAME_VERSION).getValue();
    }


    /**
     * 获取ip地址
     */
    public static String getIp(HttpServerRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.remoteAddress().toString();
        }
        String comma = ",";
        String localhost = "127.0.0.1";
        if (ip.contains(comma)) {
            ip = ip.split(",")[0];
        }
        if (localhost.equals(ip)) {
            // 获取本机真正的ip地址
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.error(e.getMessage(), e);
            }
        }
        return ip;
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getCityInfo(String ip) throws URISyntaxException {
        if (ipLocal) {
            return getLocalCityInfo(ip);
        } else {
            return getHttpCityInfo(ip);
        }
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getHttpCityInfo(String ip) {
        String api = String.format(SystemConstant.IP_URL, ip);
        JSONObject object = JSONUtil.parseObj(HttpUtil.get(api));
        return object.get("addr", String.class);
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getLocalCityInfo(String ip) throws URISyntaxException {
        File file = new File(ip2regionResource.getUrl().toURI());
        if (!file.exists()) {
            log.error("Error: Invalid ip2region.db file");
        } else {
            //查询算法
            //B-tree, B树搜索（更快）
            int algorithm = DbSearcher.BTREE_ALGORITHM;

            //Binary,使用二分搜索
            //DbSearcher.BINARY_ALGORITHM

            //Memory,加载内存（最快）
            //DbSearcher.MEMORY_ALGORITYM
            try {
                DbConfig config = new DbConfig();
                DbSearcher searcher = new DbSearcher(config, file.getPath());

                //define the method
                Method method = null;
                switch (algorithm) {
                    case DbSearcher.BTREE_ALGORITHM:
                        method = searcher.getClass().getMethod("btreeSearch", String.class);
                        break;
                    case DbSearcher.BINARY_ALGORITHM:
                        method = searcher.getClass().getMethod("binarySearch", String.class);
                        break;
                    case DbSearcher.MEMORY_ALGORITYM:
                        method = searcher.getClass().getMethod("memorySearch", String.class);
                        break;
                }

                DataBlock dataBlock;
                if (!Util.isIpAddress(ip)) {
                    log.error("Error: Invalid ip address");
                }

                dataBlock = (DataBlock) method.invoke(searcher, ip);
                String ipInfo = dataBlock.getRegion();
                if (!StringUtils.isEmpty(ipInfo)) {
                    ipInfo = ipInfo.replace("|0", "");
                    ipInfo = ipInfo.replace("0|", "");
                }
                return ipInfo;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    private static final UserAgentAnalyzer USER_AGENT_ANALYZER = UserAgentAnalyzer
            .newBuilder()
            .hideMatcherLoadStats()
            .withCache(10000)
            .withField(UserAgent.AGENT_NAME_VERSION)
            .build();

}
