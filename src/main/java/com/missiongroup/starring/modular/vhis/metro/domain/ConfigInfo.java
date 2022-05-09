package com.missiongroup.starring.modular.vhis.metro.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vhis_config_info")
public class ConfigInfo implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '主键,唯一标识UUID'")
    private String uuid;


    @Column(columnDefinition = "VARCHAR(255) COMMENT '名称'")
    private String name;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '编号'")
    private String number;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '端口'")
    private String port;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '字段'")
    private String field;

    @Column(columnDefinition = "TEXT COMMENT '备注'")
    private String comment;

    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '创建用户ID'")
    private String createUserId;

    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '修改用户ID'")
    private String updateUserId;

    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date updateTime;


    public ConfigInfo(String name,String number,String port,String field,String comment) {
        this.name = name;
        this.number = number;
        this.port= port;
        this.field = field;
        this.comment = comment;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", port='" + port + '\'' +
                ", field='" + field + '\'' +
                ", comment='" + comment + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createTime=" + createTime +
                ", updateUserId='" + updateUserId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
