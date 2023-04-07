package com.yujianyou.socket;

/**
 * @author yujianyou
 * @date 2023/4/7 22:45
 * @email 597907730@qq.com
 */
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.corundumstudio.socketio.SocketIOClient;

@Path("/myWebSocket")
public class WebSocketResource {
    // 注入WebSocket服务器

    @Inject
    WebSocketServer webSocketServer;

    @GET
    @Path("/start")
    public String startWebSocket() {
        webSocketServer.start(); // 启动WebSocket服务器
        return "WebSocket server started!";
    }

    @GET
    @Path("/stop")
    public String stopWebSocket() {
        webSocketServer.stop(); // 停止WebSocket服务器
        return "WebSocket server stopped!";
    }

    @Path("/sendMessage")
    @GET
    public String sendMessage() {
        // 获取所有连接的WebSocket客户端
        for (SocketIOClient client : webSocketServer.getServer().getAllClients()) {
            // 向客户端发送消息
            client.sendEvent("message", "Hello from Quarkus with Netty-SocketIO!");
        }
        return "Message sent!";
    }
}

