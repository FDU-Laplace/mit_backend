package com.missiongroup.starring.core.nettyserver.handler;


import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.nettyserver.service.coder.IOMessageDecoder;
import com.missiongroup.starring.core.nettyserver.service.coder.IOMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TCPChildChannelHandler extends ChannelInitializer<SocketChannel> {
    protected final static Logger logger = LoggerFactory.getLogger(TCPChildChannelHandler.class);
    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        ChannelPipeline p = e.pipeline();
        p.addLast(new IOMessageDecoder());
        p.addLast(new IOMessageEncoder());
        p.addLast(new TCPControlServerHandler());
        checkTimeOut();
    }

    private void checkTimeOut() throws Exception {
        new Thread(() -> {
            while (true) {
                for (Map.Entry<String, Long> entry : map.entrySet()) {
                    if (System.currentTimeMillis() - entry.getValue() > (1000 * 60 * 10)) {
                        try {
                            ConstantFactory.me().sendDisconnectData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        logger.info("[server]断开连接，发送无信号数据");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}