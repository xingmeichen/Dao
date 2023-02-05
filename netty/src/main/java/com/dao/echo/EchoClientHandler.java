package com.dao.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

/**
 * @project: Dao
 * @description:
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 * @author: Mabel.Chen
 * @create: 2021-04-10 16:48
 **/
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf firstMessage;
    private final ByteBuf consoleInput;

    /**
     * Creates a client-side handler.
     */
    public EchoClientHandler() {
        this.firstMessage = Unpooled.buffer(EchoClient.SIZE);
        for (int i = 0; i < this.firstMessage.capacity(); i++) {
            this.firstMessage.writeByte((byte) i);
        }
        this.consoleInput = Unpooled.buffer(EchoClient.SIZE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            this.consoleInput.writeBytes(next.getBytes());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(firstMessage);
        ctx.writeAndFlush(consoleInput);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
