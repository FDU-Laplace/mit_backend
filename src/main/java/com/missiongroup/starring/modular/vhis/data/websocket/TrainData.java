package com.missiongroup.starring.modular.vhis.data.websocket;

public class TrainData {
    private int id;
    private int trainId;
    private String trainData;

    public TrainData(int id, int trainId, String trainData) {
        this.id = id;
        this.trainId = trainId;
        this.trainData = trainData;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainData() {
        return trainData;
    }

    public void setTrainData(String trainData) {
        this.trainData = trainData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
