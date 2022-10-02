package com.nettychat;

import com.nettychat.websocket.WSServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class NettyBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private WSServer wsServer;

    /**
     * 初始化或刷新上下文触发的事件
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {
            wsServer.start();
        }
    }
}
