package com.missiongroup.starring.modular.vhis.fault.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/1
 */
@Entity
@Table(name = "vhis_fault_dict")
public class FaultDict implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识UUID
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length = 32, columnDefinition="varchar(32) COMMENT '主键,唯一标识UUID'")
    private String uuid;

    /**
     * 端口名称
     */
    private String portName;

    /**
     * 字段名称
     */
    private String signalName;

    /**
     * 专业名称
     */
    private String specName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
