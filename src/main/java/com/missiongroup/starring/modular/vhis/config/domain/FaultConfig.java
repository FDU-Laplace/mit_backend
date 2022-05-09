package com.missiongroup.starring.modular.vhis.config.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "vhis_faultconfig")
public class FaultConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识UUID
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '主键,唯一标识UUID'")
    private String uuid;

    /**
     * 故障代码
     */
    private String faultCode;

    /**
     * 故障名称
     */
    private String faultName;

    /**
     * 故障等级
     */
    private String faultLevel;

    /**
     * 等级配置
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "levelconf_uuid")
    @JsonIgnore
    private LevelConfig levelConfig;

    /**
     * 故障描述
     */
    private String faultDescribe;

    /**
     * 处理方式
     */
    private String faultDisposal;

    /**
     * 车厢
     */
    private String carriage;
    /**
     * 故障系统
     */
    private String faultSys;
    /**
     * 创建时间
     */
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date updateTime;

    /**
     * 创建用户ID
     */
    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '创建用户ID'")
    private String createUserId;

    /**
     * 修改用户ID
     */
    @Column(length = 32, columnDefinition = "varchar(32) COMMENT '修改用户ID'")
    private String updateUserId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultLevel() {
        return faultLevel;
    }

    public void setFaultLevel(String faultLevel) {
        this.faultLevel = faultLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getFaultDescribe() {
        return faultDescribe;
    }

    public void setFaultDescribe(String faultDescribe) {
        this.faultDescribe = faultDescribe;
    }

    public String getFaultDisposal() {
        return faultDisposal;
    }

    public void setFaultDisposal(String faultDisposal) {
        this.faultDisposal = faultDisposal;
    }

    public String getCarriage() {
        return carriage;
    }

    public void setCarriage(String carriage) {
        this.carriage = carriage;
    }

    public String getFaultSys() {
        return faultSys;
    }

    public void setFaultSys(String faultSys) {
        this.faultSys = faultSys;
    }

    public LevelConfig getLevelConfig() {
        return levelConfig;
    }

    public void setLevelConfig(LevelConfig levelConfig) {
        this.levelConfig = levelConfig;
    }
}
