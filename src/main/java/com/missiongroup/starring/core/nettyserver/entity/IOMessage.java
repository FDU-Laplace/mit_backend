package com.missiongroup.starring.core.nettyserver.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class IOMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 消息头
     */
    private int header;
    /**
     * 消息类型
     */
    private int type;
    /**
     * 消息id(递增) 4
     */
    private int messageId;
    /**
     * 通信协议类型
     */
    private int protocol;
    /**
     * 通信协议版本号
     */
    private int version;
    /**
     * 数据长度
     */
    private int dataLength;
    /**
     * 城市id
     */
    private int cityId;
    /**
     * 线路
     */
    private int line;
    /**
     * 编组
     */
    private short group;
    /**
     * 设备ID
     */
    private int deviceId;
    /**
     * 日期
     */
    private String time;
    /**
     * 端口数据类型
     */
    private int portDataType;
    /**
     * 预留
     */
    private byte[] reserve;
    /**
     * 端口数据
     */
    private Map portDatas;
    /**
     * 校验码
     */
    private byte[] check;
    /**
     * 消息尾
     */
    private int messageEnd;

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public short getGroup() {
        return group;
    }

    public void setGroup(short group) {
        this.group = group;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPortDataType() {
        return portDataType;
    }

    public void setPortDataType(int portDataType) {
        this.portDataType = portDataType;
    }

    public byte[] getReserve() {
        return reserve;
    }

    public void setReserve(byte[] reserve) {
        this.reserve = reserve;
    }

    public Map getPortDatas() {
        return portDatas;
    }

    public void setPortDatas(Map portDatas) {
        this.portDatas = portDatas;
    }

    public byte[] getCheck() {
        return check;
    }

    public void setCheck(byte[] check) {
        this.check = check;
    }

    public int getMessageEnd() {
        return messageEnd;
    }

    public void setMessageEnd(int messageEnd) {
        this.messageEnd = messageEnd;
    }
}