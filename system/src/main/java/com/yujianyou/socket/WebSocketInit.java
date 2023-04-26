package com.yujianyou.socket;

import com.corundumstudio.socketio.SocketIOServer;
import io.quarkus.arc.Priority;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

/**
 * @author yujianyou
 * @date 2023/4/7 22:30
 * @email 597907730@qq.com
 */
@ApplicationScoped
public class WebSocketInit {


    WebSocketServer socketIoServer = CDI.current().select(WebSocketServer.class).get();

    public void onStart(@Observes StartupEvent event) {
        // socket 启动
        socketIoServer.start();
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        // socket 关闭
        socketIoServer.stop();
    }

    // 在应用关闭时调用stop()方法
    @PreDestroy
    public void preDestroy() {
        socketIoServer.stop();
    }

}
