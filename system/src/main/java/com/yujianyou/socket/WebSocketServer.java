package com.yujianyou.socket;

/**
 * @author yujianyou
 * @date 2023/4/7 22:25
 * @email 597907730@qq.com
 */

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.inject.Singleton;

@Singleton
public class WebSocketServer {

    Integer port = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.port", Integer.class);

    String context = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.context", String.class);

    String hostname = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.hostname", String.class);

    Integer pingInterval = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.ping-interval", Integer.class);

    Integer pingTimeout = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.ping-timeout", Integer.class);

    Integer maxFramePayloadLength = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.max-frame-payload-length", Integer.class);

    Integer maxHttpContentLength = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.max-http-content-length", Integer.class);

    Integer bossthreads = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.boss-threads", Integer.class);

    Integer workerthreads = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.worker-threads", Integer.class);

    String origin = ConfigProvider.getConfig().getValue("quarkus.netty-socketio.origin", String.class);

    public SocketIOServer getServer() {
        return server;
    }

    private final SocketIOServer server;

    public WebSocketServer() {
        // 创建SocketIO配置
        Configuration configuration = new Configuration();
        // 设置端口
        configuration.setPort(port);
        // 设置路径
        configuration.setContext(context);
        configuration.setHostname(hostname);
        configuration.setMaxFramePayloadLength(maxFramePayloadLength);
        configuration.setMaxHttpContentLength(maxHttpContentLength);
        configuration.setBossThreads(bossthreads);
        configuration.setWorkerThreads(workerthreads);
        configuration.setOrigin(origin);
        configuration.setPingInterval(pingInterval);
        configuration.setPingTimeout(pingTimeout);

        // 创建SocketIO服务器
        server = new SocketIOServer(configuration);
        // 添加WebSocket处理器
        server.addConnectListener(new WebSocketHandler());
    }

    // 启动WebSocket服务器
    public void start() {
        server.start();
    }

    // 停止WebSocket服务器
    public void stop() {
        server.stop();
    }

}
