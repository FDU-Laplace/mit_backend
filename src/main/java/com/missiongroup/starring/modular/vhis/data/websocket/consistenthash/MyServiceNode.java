package com.missiongroup.starring.modular.vhis.data.websocket.consistenthash;

public class MyServiceNode implements Node{
    private final String ip;
    public MyServiceNode(String ip) {
        this.ip = ip;
    }
    @Override
    public String getKey() {
        return ip;
    }
}
