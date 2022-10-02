package com.nettychat.websocket;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理消息的handler
 * TextWebSocketFrame 在netty中，使用于websocket专门处理文本对象的，frame是消息的载体
 */
@Slf4j
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * ChannelGroup: 包含所有channel线程安全的集合，在此包含我们所有的客户端
     */
    private static final ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 获取客户端消息的载体
        String content = msg.text();
        log.info("接收到消息： {}", content);

        for (Channel client : clients) {
            client.writeAndFlush(new TextWebSocketFrame("[服务器接收到消息]" + LocalDateTime.now() + " - " + content));
        }

        // clients.writeAndFlush(new TextWebSocketFrame(content));

    }

    /**
     * 新增客户端
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
        log.info("客户端连接: {}", ctx.channel().id());
    }

    /**
     * 移除客户端
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved时候，ChannelGroup会自动移除对应客户端的Channel
        // clients.remove(ctx.channel());
        log.info("客户端关闭连接: {}", ctx.channel().id());
    }
}
