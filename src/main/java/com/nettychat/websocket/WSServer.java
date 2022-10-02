package com.nettychat.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * websocket配置
 */
@Component
@Slf4j
public class WSServer {

    @Value("${websocket.port}")
    private Integer port;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup ;
    private ServerBootstrap starter;
    private ChannelFuture future;

    public WSServer() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        starter = new ServerBootstrap();
        starter.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitializer());
        log.info("WebSocket服务器初始化成功。。。");
    }

    public void start() {
         this.future = starter.bind(port);
         log.info("netty websocket server started。。。");
    }

    public void stop() {
    }
}
