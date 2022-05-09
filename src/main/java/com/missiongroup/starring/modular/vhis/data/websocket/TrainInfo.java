package com.missiongroup.starring.modular.vhis.data.websocket;

import org.springframework.data.annotation.Id;

import javax.persistence.IdClass;


public class TrainInfo {
    @Id
    private String uploadData; //数据上传时间

    private String data;

    public TrainInfo(String uploadData, String data) {
        this.uploadData = uploadData;
        this.data = data;
    }

    public String getUploadData() {
        return uploadData;
    }

    public void setUploadData(String uploadData) {
        this.uploadData = uploadData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}