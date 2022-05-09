package com.missiongroup.starring.core.nettyserver.handler;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.nettyserver.entity.Global;
import com.missiongroup.starring.core.nettyserver.entity.IOMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


@Component
@Sharable
public class TCPControlServerHandler extends ChannelInboundHandlerAdapter {
    protected final static Logger logger = LoggerFactory.getLogger(TCPControlServerHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        Global.group.add(ctx.channel());
        logger.info("MIT_IPIS_Client【RemoteAddress: " + ctx.channel().remoteAddress().toString() + "】 is Connected.");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        Global.group.remove(ctx.channel());
        String ip = ((InetSocketAddress) ctx.channel().remoteAddress()).getHostString();
        logger.info("MIT_IPIS_Client【RemoteAddress: " + ip + "】 is Disconnected.");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) {
        IOMessage receivedMessage = (IOMessage) obj;
        if ("alive".equals(obj)) {
            ctx.channel().writeAndFlush("");
        } else {
            String endPoint = ctx.channel().remoteAddress().toString();
            String ip = endPoint.substring(1, endPoint.indexOf(":"));
            String[] ips = ip.split("\\.");
            String ipStr = ips[0] + "." + ips[1] + "." + ips[2];
            TCPChildChannelHandler.map.put(ipStr, System.currentTimeMillis());
            try {
                ConstantFactory.me().sendVehicleData(receivedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.info("MIT_IPIS_Client【RemoteAddress: " + ip + "】 put data.");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        Channel channel = ctx.channel();
        if (!channel.isActive()) {
            logger.info("MIT_IPIS_Client【RemoteAddress: " + ctx.channel().remoteAddress().toString() + "】Forced Disconnected.");
            cause.printStackTrace();
        }
        ctx.close();
    }
}