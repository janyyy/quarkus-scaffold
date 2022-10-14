package com.yujianyou.config;//package com.sengi.config;
//
//import io.quarkus.elasticsearch.restclient.lowlevel.ElasticsearchClientConfig;
//import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.apache.http.ssl.SSLContexts;
//import org.elasticsearch.client.RestClientBuilder;
//
//import javax.net.ssl.SSLContext;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.KeyStore;
//
///**
// * 在访问在 HTTP 层为 TLS 设置的 Elasticsearch 集群时，
// * 客户端需要信任 Elasticsearch 正在使用的证书。
// * 以下是设置客户端以信任已签署 Elasticsearch 正在使用的证书的 CA 的示例，
// * 当该 CA 证书在 PKCS#12 密钥库中可用时
// * @author yujianyou
// * @date 2021/12/31 17:05
// * @email 597907730@qq.com
// */
//@ElasticsearchClientConfig
//public class SSLContextConfigurator implements RestClientBuilder.HttpClientConfigCallback {
//    @Override
//    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
//        try {
//            String keyStorePass = "";
//            Path trustStorePath = Paths.get("D:\\IntelliJ IDEA Workspaces\\sengi-s1\\sengi-s1-elasticsearch\\src\\main\\resources\\elastic-certificates.p12");
//            KeyStore truststore = KeyStore.getInstance("pkcs12");
//            try (InputStream is = Files.newInputStream(trustStorePath)) {
//                truststore.load(is, keyStorePass.toCharArray());
//            }
//            SSLContextBuilder sslBuilder = SSLContexts.custom()
//                    .loadTrustMaterial(truststore, null);
//            SSLContext sslContext = sslBuilder.build();
//            httpAsyncClientBuilder.setSSLContext(sslContext);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return httpAsyncClientBuilder;
//    }
//}
