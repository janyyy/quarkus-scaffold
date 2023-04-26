package com.yujianyou.socket;

/**
 * @author yujianyou
 * @date 2023/4/7 22:24
 * @email 597907730@qq.com
 */

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import io.quarkus.runtime.annotations.RegisterForReflection;

// 注册类以支持Quarkus的反射
@RegisterForReflection
public class WebSocketHandler implements ConnectListener, DataListener<String> {

    @Override
    public void onConnect(SocketIOClient client) {
        // 处理WebSocket连接事件
    }

    @Override
    public void onData(SocketIOClient client, String data, AckRequest ackSender) {
        // 处理WebSocket消息事件
    }

}

