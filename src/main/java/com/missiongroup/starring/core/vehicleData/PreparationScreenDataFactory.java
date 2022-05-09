package com.missiongroup.starring.core.vehicleData;

import java.util.HashMap;
import java.util.Map;

public class PreparationScreenDataFactory extends DatatFactory {

    public static Map createData() {
        Map<String,Object> data = new HashMap<>();
        Map<String, Object> auxConData = createAuxConData();
        data.put("auxConData", auxConData);
        Map<String, Object> batteryData = createBatteryData();
        data.put("batteryData", batteryData);
        Map<String, Object> tskData = createTSKData();
        data.put("tskData", tskData);
        Map<String, Object> kAuxData = createKAuxData();
        data.put("kAuxData", kAuxData);
        Map<String, Object> mvkData = createMVKData();
        data.put("mvkData", mvkData);
        Map<String, Object> hvacData = createHVACData();
        data.put("hvacData", hvacData);
        return data;
    }

    /**
     * 辅助变流器数据
     */
    private static Map<String, Object> createAuxConData() {

        Map<String,Object> auxConData = new HashMap<>();
        String ACE1Status;


        Long dd_cace1Isolated = getValue("port0x136", "DD_CACE1Isolated");
        Long dd_cace1Failure = getValue("port0x126", "DD_CACE1Failure");
        Long dd_cace1NormMode = getValue("port0x126", "DD_CACE1NormMode");
        Long dd_cace1StopMode = getValue("port0x126", "DD_CACE1StopMode");
        if (dd_cace1Isolated == 1) {
            ACE1Status = "Isolated";
        } else if (dd_cace1NormMode == 1) {
            ACE1Status = "Norm";
        } else if (dd_cace1StopMode == 1) {
            ACE1Status = "Stop";
        } else if (dd_cace1Failure == 1) {
            ACE1Status = "Failure";
        } else {
            ACE1Status = "Unknown";
        }
        auxConData.put("ACE1", ACE1Status);

        String ACE2Status ;
        Long dd_cace2StopMode = getValue("port0x126", "DD_CACE2StopMode");
        Long dd_cace2Isolated = getValue("port0x136", "DD_CACE2Isolated");
        Long dd_cace2Failure = getValue("port0x126", "DD_CACE2Failure");
        Long dd_cace2NormMode = getValue("port0x126", "DD_CACE2NormMode");
        if (dd_cace2Isolated == 1) {
            ACE2Status = "Isolated";
        } else if (dd_cace2NormMode == 1) {
            ACE2Status = "Norm";
        } else if (dd_cace2StopMode == 1) {
            ACE2Status = "Stop";
        } else if (dd_cace2Failure == 1) {
            ACE2Status = "Failure";
        } else {
            ACE2Status = "Unknown";
        }
        auxConData.put("ACE2", ACE2Status);
        String ACE3Status;
        Long dd_cace3StopMode = getValue("port0x126", "DD_CACE3StopMode");
        Long dd_cace3Isolated = getValue("port0x136", "DD_CACE3Isolated");
        Long dd_cace3Failure = getValue("port0x126", "DD_CACE3Failure");
        Long dd_cace3NormMode = getValue("port0x126", "DD_CACE3NormMode");
        if (dd_cace3Isolated == 1) {
            ACE3Status = "Isolated";
        } else if (dd_cace3NormMode == 1) {
            ACE3Status = "Norm";
        } else if (dd_cace3StopMode == 1) {
            ACE3Status = "Stop";
        } else if (dd_cace3Failure == 1) {
            ACE3Status = "Failure";
        } else {
            ACE3Status = "Unknown";
        }
        auxConData.put("ACE3", ACE3Status);
        return auxConData;
    }

    /**
     * 电池数据
     */
    private static Map<String, Object> createBatteryData() {
        Map<String,Object> batteryData = new HashMap<>();
        String battery1Status;


        Long dd_cbis_a1 = getValue("port0x134", "DD_CBIS_A1");
        Long dd_cBatOverVolt_a1 = getValue("port0x134", "DD_CBatOverVolt_A1");
        Long dd_cBatUnderVolt_a1 = getValue("port0x134", "DD_CBatUnderVolt_A1");
        Long dd_cBatChKO_a1 = getValue("port0x134", "DD_CBatChKO_A1");
        Long dd_cace1Oper = getValue("port0x127", "DD_CACE1Oper");
        Long dd_cace2Oper = getValue("port0x127", "DD_CACE2Oper");

        if (dd_cbis_a1 == 1) {
            battery1Status = "Isolated";
        } else if (dd_cace1Oper == 1 && (dd_cBatOverVolt_a1 == 1 || dd_cBatUnderVolt_a1 == 1) && dd_cbis_a1 == 0) {
            battery1Status = "OverVolt";
        } else if (dd_cace1Oper == 1 && (dd_cBatOverVolt_a1 == 0 && dd_cBatUnderVolt_a1 == 0) && dd_cbis_a1 == 0 && dd_cBatChKO_a1 == 1) {
            battery1Status = "UnderVolt";
        } else if (dd_cace1Oper == 1 && (dd_cBatOverVolt_a1 == 0 && dd_cBatUnderVolt_a1 == 0) && dd_cbis_a1 == 0 && dd_cBatChKO_a1 == 0) {
            battery1Status = "ChKO";
        } else {
            battery1Status = "Unknown";
        }
        batteryData.put("battery1", battery1Status);

        String battery2Status;
        Long dd_cbis_a2 = getValue("port0x134", "DD_CBIS_A2");
        Long dd_cBatOverVolt_a2 = getValue("port0x134", "DD_CBatOverVolt_A2");
        Long dd_cBatUnderVolt_a2 = getValue("port0x134", "DD_CBatUnderVolt_A2");
        Long dd_cBatChKO_a2 = getValue("port0x134", "DD_CBatChKO_A2");
        if (dd_cbis_a2 == 1) {
            battery2Status = "Isolated";
        } else if (dd_cace2Oper == 1 && (dd_cBatOverVolt_a2 == 1 || dd_cBatUnderVolt_a2 == 1) && dd_cbis_a2 == 0) {
            battery2Status = "OverVolt";
        } else if (dd_cace2Oper == 1 && (dd_cBatOverVolt_a2 == 0 && dd_cBatUnderVolt_a2 == 0) && dd_cbis_a2 == 0 && dd_cBatChKO_a2 == 1) {
            battery2Status = "UnderVolt";
        } else if (dd_cace2Oper == 1 && (dd_cBatOverVolt_a2 == 0 && dd_cBatUnderVolt_a2 == 0) && dd_cbis_a2 == 0 && dd_cBatChKO_a2 == 0) {
            battery2Status = "ChKO";
        } else {
            battery2Status = "Unknown";
        }
        batteryData.put("battery2", battery2Status);
        return batteryData;
    }

    /**
     * 列车电源接触器状态
     */
    private static Map<String, Object> createTSKData() {
        Map<String,Object> TSKData = new HashMap<>();


        Long dd_ctsk_a1 = getValue("port0x126", "DD_CTSK_A1");
        //Long dd_ctsk_c2 = getValue("port0x126", "DD_CTSK_C2");
        Long dd_ctsk_a2 = getValue("port0x126", "DD_CTSK_A2");
        TSKData.put("tsk_a1", dd_ctsk_a1 == 1 ? "open" : "closed");
        //TSKData.put("tsk_c2", dd_ctsk_c2==1?"open":"closed");
        TSKData.put("tsk_a2", dd_ctsk_a2 == 1 ? "open" : "closed");
        return TSKData;
    }

    /**
     * K-AUX Status
     * <p>
     * 少一个状态
     */
    private static Map<String, Object> createKAuxData() {
        Map<String,Object> TSKData = new HashMap<>();
        String aux1Status;
        Long dd_cauxk1Close = getValue("port0x126", "DD_CAUXK1Close");
        Long dd_cauxk1CloseFault = getValue("port0x126", "DD_CAUXK1CloseFault");
        Long dd_cauxk1OpenFault = getValue("port0x126", "DD_CAUXK1OpenFault");
        Long li_cauxk1Open = getValue("port0x3d4", "LI_Aux1Open_C2");
        if (dd_cauxk1Close == 1L && dd_cauxk1CloseFault==0L && dd_cauxk1OpenFault ==0L && li_cauxk1Open==0L) {
            aux1Status = "Close";
        } else if (dd_cauxk1CloseFault == 1L && dd_cauxk1OpenFault == 0L) {
            aux1Status = "CloseFault";
        } else if (dd_cauxk1OpenFault == 1L) {
            aux1Status = "OpenFault";
        }else if (li_cauxk1Open == 1 && dd_cauxk1Close == 0L && dd_cauxk1CloseFault==0L && dd_cauxk1OpenFault ==0L) {
            aux1Status = "Open";
        } else {
            aux1Status = "Unknown";
        }

        TSKData.put("aux1StatusC2", aux1Status);
        String aux2Status;
        Long dd_cauxk2Close = getValue("port0x126", "DD_CAUXK2Close");
        Long dd_cauxk2CloseFault = getValue("port0x126", "DD_CAUXK2CloseFault");
        Long dd_cauxk2OpenFault = getValue("port0x126", "DD_CAUXK2OpenFault");
        Long li_cauxk2Open = getValue("port0x3e4", "LI_Aux2Open_C2");
        if (dd_cauxk2Close == 1L && dd_cauxk2CloseFault==0L && dd_cauxk2OpenFault ==0L && li_cauxk2Open==0L) {
            aux2Status = "Close";
        } else if (dd_cauxk2CloseFault == 1L  && dd_cauxk2OpenFault == 0L) {
            aux2Status = "CloseFault";
        } else if (dd_cauxk2OpenFault == 1L) {
            aux2Status = "OpenFault";
        }else if (li_cauxk2Open == 1L && dd_cauxk2Close == 0L && dd_cauxk2CloseFault==0L && dd_cauxk2OpenFault ==0L) {
            aux2Status = "Open";
        }  else {
            aux2Status = "Unknown";
        }
        TSKData.put("aux2StatusC2", aux2Status);
        return TSKData;
    }


    /**
     * MVK Status
     */
    private static Map<String, Object> createMVKData() {
        Map<String,Object> MVKData = new HashMap<>();
        Long dd_cmvk1_a1 = getValue("port0x126", "DD_CMVK1_A1");
        Long dd_cmvk2_a1 = getValue("port0x126", "DD_CMVK2_A1");
        MVKData.put("mvk1_a1", dd_cmvk1_a1 == 1 ? "closed" : "open");
        MVKData.put("mvk2_a1", dd_cmvk2_a1 == 1 ? "closed" : "open");
        Long dd_cmvk1_b1 = getValue("port0x126", "DD_CMVK1_B1");
        Long dd_cmvk2_b1 = getValue("port0x126", "DD_CMVK2_B1");
        MVKData.put("mvk1_b1", dd_cmvk1_b1 == 1 ? "closed" : "open");
        MVKData.put("mvk2_b1", dd_cmvk2_b1 == 1 ? "closed" : "open");
        Long dd_cmvk1_c1 = getValue("port0x126", "DD_CMVK1_C1");
        Long dd_cmvk2_c1 = getValue("port0x126", "DD_CMVK2_C1");
        MVKData.put("mvk1_c1", dd_cmvk1_c1 == 1 ? "closed" : "open");
        MVKData.put("mvk2_c1", dd_cmvk2_c1 == 1 ? "closed" : "open");
        Long dd_cmvk1_c2 = getValue("port0x126", "DD_CMVK1_C2");
        Long dd_cmvk2_c2 = getValue("port0x126", "DD_CMVK2_C2");
        MVKData.put("mvk1_c2", dd_cmvk1_c2 == 1 ? "closed" : "open");
        MVKData.put("mvk2_c2", dd_cmvk2_c2 == 1 ? "closed" : "open");
        Long dd_cmvk1_b2 = getValue("port0x126", "DD_CMVK1_B2");
        Long dd_cmvk2_b2 = getValue("port0x126", "DD_CMVK2_B2");
        MVKData.put("mvk1_b2", dd_cmvk1_b2 == 1 ? "closed" : "open");
        MVKData.put("mvk2_b2", dd_cmvk2_b2 == 1 ? "closed" : "open");
        Long dd_cmvk1_a2 = getValue("port0x126", "DD_CMVK1_A2");
        Long dd_cmvk2_a2 = getValue("port0x126", "DD_CMVK2_A2");
        MVKData.put("mvk1_a2", dd_cmvk1_a2 == 1 ? "closed" : "open");
        MVKData.put("mvk2_a2", dd_cmvk2_a2 == 1 ? "closed" : "open");
        return MVKData;
    }

    /**
     * HVAC Temp of Cars
     */
    private static Map<String, Object> createHVACData() {
        Map<String,Object> HVACData = new HashMap<>();
        Long dd_cTrainSalTemp_a1 = getValue("port0x126", "DD_CTrainSalTemp_A1");
        Long dd_cTrainSalTemp_a2 = getValue("port0x126", "DD_CTrainSalTemp_A2");
        Long dd_cTrainSalTemp_b1 = getValue("port0x126", "DD_CTrainSalTemp_B1");
        Long dd_cTrainSalTemp_b2 = getValue("port0x126", "DD_CTrainSalTemp_B2");
        Long dd_cTrainSalTemp_c1 = getValue("port0x126", "DD_CTrainSalTemp_C1");
        Long dd_cTrainSalTemp_c2 = getValue("port0x126", "DD_CTrainSalTemp_C2");
        HVACData.put("A1", dd_cTrainSalTemp_a1 >= 127 ? "??" : dd_cTrainSalTemp_a1-30);
        HVACData.put("A2", dd_cTrainSalTemp_a2 >= 127 ? "??" : dd_cTrainSalTemp_a2-30);
        HVACData.put("B1", dd_cTrainSalTemp_b1 >= 127 ? "??" : dd_cTrainSalTemp_b1-30);
        HVACData.put("B2", dd_cTrainSalTemp_b2 >= 127 ? "??" : dd_cTrainSalTemp_b2-30);
        HVACData.put("C1", dd_cTrainSalTemp_c1 >= 127 ? "??" : dd_cTrainSalTemp_c1-30);
        HVACData.put("C2", dd_cTrainSalTemp_c2 >= 127 ? "??" : dd_cTrainSalTemp_c2-30);
        return HVACData;
    }
}
