package com.missiongroup.starring.core.cache.service;

import java.io.Serializable;

public class PortModel implements Serializable,Cloneable{
    private int id;
    private String signalName;
    private String complexNetworkType;
    private Long value=0l;
    public PortModel(int id, String signalName, String complexNetworkType) {
        this.id = id;
        this.signalName = signalName;
        this.complexNetworkType = complexNetworkType;
    }
    public PortModel() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getComplexNetworkType() {
        return complexNetworkType;
    }

    public void setComplexNetworkType(String complexNetworkType) {
        this.complexNetworkType = complexNetworkType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    protected PortModel clone() {
        PortModel portModel=null;
        try {
            portModel=(PortModel)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return portModel;
    }
}
