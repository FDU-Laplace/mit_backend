package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class MainTrainSynopticDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map doorStatusA1Data = DoorStatusA1Data();
        data.put("doorStatusA1Data", doorStatusA1Data);
        Map doorStatusA2Data = DoorStatusA2Data();
        data.put("doorStatusA2Data", doorStatusA2Data);
        Map doorStatusB1Data = DoorStatusB1Data();
        data.put("doorStatusB1Data", doorStatusB1Data);
        Map doorStatusB2Data = DoorStatusB2Data();
        data.put("doorStatusB2Data", doorStatusB2Data);
        Map doorStatusC1Data = DoorStatusC1Data();
        data.put("doorStatusC1Data", doorStatusC1Data);
        Map doorStatusC2Data = DoorStatusC2Data();
        data.put("doorStatusC2Data", doorStatusC2Data);
        Map cabinStatusData = cabinStatusData();
        data.put("cabinStatusData", cabinStatusData);
        Map detrainmentDoorStatus = detrainmentDoorStatus();
        data.put("detrainmentDoorStatus", detrainmentDoorStatus);
        Map drivingDirection = drivingDirection();
        data.put("drivingDirection", drivingDirection);
        Map keyData = keyData();
        data.put("keyData", keyData);
        Map pmsdata = pmsdata();
        data.put("pmsdata", pmsdata);
        Map pantographStatus = PantographStatus();
        data.put("pantographStatus", pantographStatus);
        return data;
    }


    private static Map PantographStatus() {
        Map data = new HashMap();

        Long dd_chvsPantoUpFlt_b1 = getValue("port0x127", "DD_CHVSPantoUpFlt_B1");
        Long dd_chvsPantoDownFlt_b1 = getValue("port0x127", "DD_CHVSPantoDownFlt_B1");
        Long dd_chvsPantoLoweringFlt_b1 = getValue("port0x126", "DD_CHVSPantoLoweringFlt_B1");
        Long dd_chvsPantoRisingFlt_b1 = getValue("port0x126", "DD_CHVSPantoRisingFlt_B1");
        Long dd_chvsPantoRaisedHV_b1 = getValue("port0x127", "DD_CHVSPantoRaisedHV_B1");
        Long dd_chvsPantoRaised_b1 = getValue("port0x127", "DD_CHVSPantoRaised_B1");
        Long dd_chvsPantoLoweredSts_b1 = getValue("port0x127", "DD_CHVSPantoLoweredSts_B1");
        Long dd_chvsPantoRisingSts_b1 = getValue("port0x127", "DD_CHVSPantoRisingSts_B1");
        Long dd_chvsPantoLoweringSts_b1 = getValue("port0x127", "DD_CHVSPantoLoweringSts_B1");
        String pantograph_b1 = getCHVSStatus(dd_chvsPantoUpFlt_b1, dd_chvsPantoDownFlt_b1, dd_chvsPantoLoweringFlt_b1, dd_chvsPantoRisingFlt_b1, dd_chvsPantoRaisedHV_b1, dd_chvsPantoRaised_b1, dd_chvsPantoLoweredSts_b1, dd_chvsPantoRisingSts_b1, dd_chvsPantoLoweringSts_b1);


        Long dd_chvsPantoUpFlt_b2 = getValue("port0x127", "DD_CHVSPantoUpFlt_B2");
        Long dd_chvsPantoDownFlt_b2 = getValue("port0x127", "DD_CHVSPantoDownFlt_B2");
        Long dd_chvsPantoLoweringFlt_b2 = getValue("port0x126", "DD_CHVSPantoLoweringFlt_B2");
        Long dd_chvsPantoRisingFlt_b2 = getValue("port0x126", "DD_CHVSPantoRisingFlt_B2");
        Long dd_chvsPantoRaisedHV_b2 = getValue("port0x127", "DD_CHVSPantoRaisedHV_B2");
        Long dd_chvsPantoRaised_b2 = getValue("port0x127", "DD_CHVSPantoRaised_B2");
        Long dd_chvsPantoLoweredSts_b2 = getValue("port0x127", "DD_CHVSPantoLoweredSts_B2");
        Long dd_chvsPantoRisingSts_b2 = getValue("port0x127", "DD_CHVSPantoRisingSts_B2");
        Long dd_chvsPantoLoweringSts_b2 = getValue("port0x127", "DD_CHVSPantoLoweringSts_B2");
        String pantograph_b2 = getCHVSStatus(dd_chvsPantoUpFlt_b2, dd_chvsPantoDownFlt_b2, dd_chvsPantoLoweringFlt_b2, dd_chvsPantoRisingFlt_b2, dd_chvsPantoRaisedHV_b2, dd_chvsPantoRaised_b2, dd_chvsPantoLoweredSts_b2, dd_chvsPantoRisingSts_b2, dd_chvsPantoLoweringSts_b2);
        data.put("pantograph_b1", pantograph_b1);
        data.put("pantograph_b2", pantograph_b2);

        return data;
    }

    private static String getCHVSStatus(Long dd_chvsPantoUpFlt_, Long dd_chvsPantoDownFlt_, Long dd_chvsPantoLoweringFlt_, Long dd_chvsPantoRisingFlt_, Long dd_chvsPantoRaisedHV_, Long dd_chvsPantoRaised_, Long dd_chvsPantoLoweredSts_, Long dd_chvsPantoRisingSts_, Long dd_chvsPantoLoweringSts_) {
        String pantograph_ = "";
        if (dd_chvsPantoLoweringFlt_ == 1 && dd_chvsPantoDownFlt_ == 0) {
            pantograph_ = "Pantograph_Lowering_faulty";
        } else if (dd_chvsPantoLoweringFlt_ == 1 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_is_in_DOWN_position_and_is_Faulty";
        } else if (dd_chvsPantoRisingFlt_ == 1 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_Raising_Faulty";
        } else if (dd_chvsPantoRaisedHV_ == 1 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_in_UP_position_and_HV_is_connected";
        } else if (dd_chvsPantoRaised_ == 1 &&
                dd_chvsPantoRaisedHV_ == 0 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_in_UP_Position";
        } else if (dd_chvsPantoLoweredSts_ == 1 && dd_chvsPantoRaised_ == 0 &&
                dd_chvsPantoRaisedHV_ == 0 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_in_DOWN_position";
        } else if (dd_chvsPantoRisingSts_ == 1 && dd_chvsPantoLoweredSts_ == 0 && dd_chvsPantoRaised_ == 0 &&
                dd_chvsPantoRaisedHV_ == 0 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_is_raising";
        } else if (dd_chvsPantoLoweringSts_ == 1 && dd_chvsPantoRisingSts_ == 0 && dd_chvsPantoLoweredSts_ == 0 && dd_chvsPantoRaised_ == 0 &&
                dd_chvsPantoRaisedHV_ == 0 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_is_Lowering";
        } else if (dd_chvsPantoLoweringSts_ == 0 && dd_chvsPantoRisingSts_ == 0 && dd_chvsPantoLoweredSts_ == 0 && dd_chvsPantoRaised_ == 0 &&
                dd_chvsPantoRaisedHV_ == 0 && dd_chvsPantoRisingFlt_ == 0 && dd_chvsPantoLoweringFlt_ == 0 && dd_chvsPantoDownFlt_ == 0 && dd_chvsPantoUpFlt_ == 0) {
            pantograph_ = "Pantograph_status_unknown";
        }
        return pantograph_;
    }

    /**
     * PMS
     */
    private static Map pmsdata() {
        Map data = new HashMap();
        Long dd_cpmsCamLightStatus = getValue("port0x128", "DD_CPMSCamLightStatus");
        Long dd_cpmsPresentB1 = getValue("port0x128", "DD_CPMSPresentB1");
        Long dd_cpmsPresentB2 = getValue("port0x128", "DD_CPMSPresentB2");
        String b1 = "ON";
        if (dd_cpmsPresentB1 == 1L) {
            if (dd_cpmsCamLightStatus == 1) {
                b1 = "ON";
            } else {
                b1 = "OFF";
            }
            data.put("b1", b1);
        }
        String b2 = "ON";
        if (dd_cpmsPresentB2 == 1L) {
            if (dd_cpmsCamLightStatus == 1) {
                b2 = "ON";
            } else {
                b2 = "OFF";
            }
            data.put("b2", b2);
        }
        return data;
    }

    /**
     * key
     */
    private static Map keyData() {
        Map data = new HashMap();
        String key = "";
        Long dd_cCab1Active = getValue("port0x123", "DD_CCab1Active");
        Long dd_cCab2Active = getValue("port0x123", "DD_CCab2Active");
        Long dd_cKeySw_a1 = getValue("port0x120", "DD_CKeySw_A1");
        Long dd_cKeySw_a2 = getValue("port0x120", "DD_CKeySw_A2");
        if (dd_cCab1Active == 1 && dd_cKeySw_a1 == 1) {
            key = "a1";
        } else if (dd_cCab2Active == 1 && dd_cKeySw_a2 == 1) {
            key = "a2";
        } else if ((dd_cCab1Active == 1 && dd_cCab2Active == 1) || (dd_cCab1Active == 0 && dd_cCab2Active == 0)) {
            key = "a2_a1";
        }
        data.put("key", key);
        return data;
    }

    /**
     * Driving direction
     */
    private static Map drivingDirection() {
        Map data = new HashMap();
        Long dd_cDirFwd = getValue("port0x120", "DD_CDirFwd");
        Long dd_cCab1Active = getValue("port0x123", "DD_CCab1Active");
        Long dd_cCab2Active = getValue("port0x123", "DD_CCab2Active");
        Long dd_cDirRev = getValue("port0x120", "DD_CDirRev");
        String drivingDirection = "1";
        if ((dd_cDirFwd == 1 && dd_cCab1Active == 1) || (dd_cCab2Active == 1 && dd_cDirRev == 1)) {
            drivingDirection = "1";
        }
        if ((dd_cDirFwd == 1 && dd_cCab2Active == 1) || (dd_cCab1Active == 1 && dd_cDirRev == 1)) {
            drivingDirection = "2";
        }
        data.put("drivingDirection", drivingDirection);
        return data;
    }

    /**
     * Door Active status
     */
    private static Map doorActiveStatus() {
        Map data = new HashMap();
        //Long dd_cDrsActiveStsSide_a1 = (Long) port0x131.getDD_CDrsActiveStsSide_A1();
        //Long dd_cDrsActiveStsSide_a2 = (Long) port0x131.getDD_CDrsActiveStsSide_A2();
        return data;
    }

    /**
     * Detrainment Door Status  已验证
     */
    private static Map detrainmentDoorStatus() {
        Map data = new HashMap();

        Long dd_cDrsDDClosed_a1 = getValue("port0x120", "DD_CDrsDDClosed_A1");
        Long dd_cDrsDDUnlocked_a1 = getValue("port0x120", "DD_CDrsDDUnlocked_A1");
        Long dd_cDrsURSOperated_a1 = getValue("port0x120", "DD_CDrsURSOperated_A1");
        Long dd_cDrsURSCOpened_a1 = getValue("port0x120", "DD_CDrsURSCOpened_A1");
        String detrainmentDoor_a1 = getDetrsinment(dd_cDrsDDClosed_a1, dd_cDrsDDUnlocked_a1, dd_cDrsURSOperated_a1, dd_cDrsURSCOpened_a1);
        data.put("detrainmentDoor_a1", detrainmentDoor_a1);
        Long dd_cDrsDDClosed_a2 = getValue("port0x120", "DD_CDrsDDClosed_A2");
        Long dd_cDrsDDUnlocked_a2 = getValue("port0x120", "DD_CDrsDDUnlocked_A2");
        Long dd_cDrsURSOperated_a2 = getValue("port0x120", "DD_CDrsURSOperated_A2");
        Long dd_cDrsURSCOpened_a2 = getValue("port0x120", "DD_CDrsURSCOpened_A2");

        String detrainmentDoor_a2 = getDetrsinment(dd_cDrsDDClosed_a2, dd_cDrsDDUnlocked_a2, dd_cDrsURSOperated_a2, dd_cDrsURSCOpened_a2);
        data.put("detrainmentDoor_a2", detrainmentDoor_a2);
        return data;
    }

    private static String getDetrsinment(Long dd_cDrsDDClosed, Long dd_cDrsDDUnlocked, Long dd_cDrsURSOperated, Long dd_cDrsURSCOpened) {
        String detrainmentDoor = "closed";
        if (dd_cDrsDDClosed == 0) {
            detrainmentDoor = "open_unlocked_Blinking";
        } else if (dd_cDrsDDClosed == 1 &&
                dd_cDrsDDUnlocked == 1) {
            detrainmentDoor = "open_unlocked_Fixed";
        } else if (dd_cDrsURSOperated == 1 &&
                dd_cDrsDDClosed == 1 &&
                dd_cDrsDDUnlocked == 0) {
            detrainmentDoor = "request_Switch_Blinking";
        } else if (dd_cDrsURSCOpened == 1 &&
                dd_cDrsURSOperated == 0 &&
                dd_cDrsDDUnlocked == 0 &&
                dd_cDrsDDClosed == 1) {
            detrainmentDoor = "request_Switch_Fixed";
        } else if (dd_cDrsDDClosed == 1 &&
                dd_cDrsURSCOpened == 0 &&
                dd_cDrsURSOperated == 0 &&
                dd_cDrsDDUnlocked == 0) {
            detrainmentDoor = "closed";
        }
        return detrainmentDoor;
    }

    /**
     * Cabin Status 客舱状态
     */

    private static Map cabinStatusData() {
        Map data = new HashMap();
        Long dd_cCab1Active = getValue("port0x123", "DD_CCab1Active");
        Long dd_cCab2Active = getValue("port0x123", "DD_CCab2Active");
        if (dd_cCab1Active == 1) {
            data.put("A1", "Single Cabin Active");
        } else {
            data.put("A1", "Single Cabin Not Active");
        }
        if (dd_cCab2Active == 1) {
            data.put("A2", "Single Cabin Active");
        } else {
            data.put("A2", "Single Cabin Not Active");
        }
        if (dd_cCab1Active == 1 && dd_cCab2Active == 1) {
            data.put("A1", "Both Cabin Active");
            data.put("A2", "Both Cabin Active");
        } else if (dd_cCab1Active == 0 && dd_cCab2Active == 0) {
            data.put("A1", "Both Cabin Not active");
            data.put("A2", "Both Cabin Not active");
        }
        return data;
    }

    /**
     * DoorStatusA1Data
     */
    private static Map DoorStatusA1Data() {
        Map data = new HashMap();
            Long dd_cDrsFault1_a1 =     getValue("port0x121", "DD_CDrsFault1_A1");
            Long dd_cDrsIsol1_a1 =      getValue("port0x122", "DD_CDrsIsol1_A1");
            Long dd_cDrsCommOk1_a1 =    getValue("port0x122", "DD_CDrsCommOk1_A1");
            Long dd_cDrsObstr1_a1 =     getValue("port0x121", "DD_CDrsObstr1_A1");
            Long dd_cDrsOpened1_a1 =    getValue("port0x121", "DD_CDrsOpened1_A1");
        Long dd_cDrsClosedAndLckd1_a1 = getValue("port0x121", "DD_CDrsClosedAndLckd1_A1");
        Long dd_cDrsIsolEle1_a1 =       getValue("port0x122", "DD_CDrsIsolEle1_A1");
        Long dd_cDrsEmHand1_a1 =        getValue("port0x122", "DD_CDrsEmHand1_A1");
        Map door_1 = getDoorData(dd_cDrsFault1_a1, dd_cDrsIsol1_a1, dd_cDrsCommOk1_a1, dd_cDrsObstr1_a1, dd_cDrsOpened1_a1, dd_cDrsClosedAndLckd1_a1, dd_cDrsIsolEle1_a1, dd_cDrsEmHand1_a1);
        data.put("door_1", door_1);
        Long dd_cDrsFault2_a1 =             getValue("port0x121", "DD_CDrsFault2_A1");
        Long dd_cDrsIsol2_a1 =              getValue("port0x122", "DD_CDrsIsol2_A1");
        Long dd_cDrsCommOk2_a1 =            getValue("port0x122", "DD_CDrsCommOk2_A1");
        Long dd_cDrsObstr2_a1 =             getValue("port0x121", "DD_CDrsObstr2_A1");
        Long dd_cDrsOpened2_a1 =            getValue("port0x121", "DD_CDrsOpened2_A1");
        Long dd_cDrsClosedAndLckd2_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd2_A1");
        Long dd_cDrsIsolEle2_a1 =           getValue("port0x122", "DD_CDrsIsolEle2_A1");
        Long dd_cDrsEmHand2_a1 =            getValue("port0x122", "DD_CDrsEmHand2_A1");
        Map door_2 = getDoorData(dd_cDrsFault2_a1, dd_cDrsIsol2_a1, dd_cDrsCommOk2_a1, dd_cDrsObstr2_a1, dd_cDrsOpened2_a1, dd_cDrsClosedAndLckd2_a1, dd_cDrsIsolEle2_a1, dd_cDrsEmHand2_a1);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_a1 =             getValue("port0x121", "DD_CDrsFault3_A1");
        Long dd_cDrsIsol3_a1 =              getValue("port0x122", "DD_CDrsIsol3_A1");
        Long dd_cDrsCommOk3_a1 =            getValue("port0x122", "DD_CDrsCommOk3_A1");
        Long dd_cDrsObstr3_a1 =             getValue("port0x121", "DD_CDrsObstr3_A1");
        Long dd_cDrsOpened3_a1 =            getValue("port0x121", "DD_CDrsOpened3_A1");
        Long dd_cDrsClosedAndLckd3_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd3_A1");
        Long dd_cDrsIsolEle3_a1 =           getValue("port0x122", "DD_CDrsIsolEle3_A1");
        Long dd_cDrsEmHand3_a1 =            getValue("port0x122", "DD_CDrsEmHand3_A1");
        Map door_3 = getDoorData(dd_cDrsFault3_a1, dd_cDrsIsol3_a1, dd_cDrsCommOk3_a1, dd_cDrsObstr3_a1, dd_cDrsOpened3_a1, dd_cDrsClosedAndLckd3_a1, dd_cDrsIsolEle3_a1, dd_cDrsEmHand3_a1);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_a1 =             getValue("port0x121", "DD_CDrsFault4_A1");
        Long dd_cDrsIsol4_a1 =              getValue("port0x122", "DD_CDrsIsol4_A1");
        Long dd_cDrsCommOk4_a1 =            getValue("port0x122", "DD_CDrsCommOk4_A1");
        Long dd_cDrsObstr4_a1 =             getValue("port0x121", "DD_CDrsObstr4_A1");
        Long dd_cDrsOpened4_a1 =            getValue("port0x121", "DD_CDrsOpened4_A1");
        Long dd_cDrsClosedAndLckd4_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd4_A1");
        Long dd_cDrsIsolEle4_a1 =           getValue("port0x122", "DD_CDrsIsolEle4_A1");
        Long dd_cDrsEmHand4_a1 =            getValue("port0x122", "DD_CDrsEmHand4_A1");
        Map door_4 = getDoorData(dd_cDrsFault4_a1, dd_cDrsIsol4_a1, dd_cDrsCommOk4_a1, dd_cDrsObstr4_a1, dd_cDrsOpened4_a1, dd_cDrsClosedAndLckd4_a1, dd_cDrsIsolEle4_a1, dd_cDrsEmHand4_a1);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_a1 =             getValue("port0x121", "DD_CDrsFault5_A1");
        Long dd_cDrsIsol5_a1 =              getValue("port0x122", "DD_CDrsIsol5_A1");
        Long dd_cDrsCommOk5_a1 =            getValue("port0x122", "DD_CDrsCommOk5_A1");
        Long dd_cDrsObstr5_a1 =             getValue("port0x121", "DD_CDrsObstr5_A1");
        Long dd_cDrsOpened5_a1 =            getValue("port0x121", "DD_CDrsOpened5_A1");
        Long dd_cDrsClosedAndLckd5_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd5_A1");
        Long dd_cDrsIsolEle5_a1 =           getValue("port0x122", "DD_CDrsIsolEle5_A1");
        Long dd_cDrsEmHand5_a1 =            getValue("port0x122", "DD_CDrsEmHand5_A1");
        Map door_5 = getDoorData(dd_cDrsFault5_a1, dd_cDrsIsol5_a1, dd_cDrsCommOk5_a1, dd_cDrsObstr5_a1, dd_cDrsOpened5_a1, dd_cDrsClosedAndLckd5_a1, dd_cDrsIsolEle5_a1, dd_cDrsEmHand5_a1);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_a1 =             getValue("port0x121", "DD_CDrsFault6_A1");
        Long dd_cDrsIsol6_a1 =              getValue("port0x122", "DD_CDrsIsol6_A1");
        Long dd_cDrsCommOk6_a1 =            getValue("port0x122", "DD_CDrsCommOk6_A1");
        Long dd_cDrsObstr6_a1 =             getValue("port0x121", "DD_CDrsObstr6_A1");
        Long dd_cDrsOpened6_a1 =            getValue("port0x121", "DD_CDrsOpened6_A1");
        Long dd_cDrsClosedAndLckd6_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd6_A1");
        Long dd_cDrsIsolEle6_a1 =           getValue("port0x122", "DD_CDrsIsolEle6_A1");
        Long dd_cDrsEmHand6_a1 =            getValue("port0x122", "DD_CDrsEmHand6_A1");
        Map door_6 = getDoorData(dd_cDrsFault6_a1, dd_cDrsIsol6_a1, dd_cDrsCommOk6_a1, dd_cDrsObstr6_a1, dd_cDrsOpened6_a1, dd_cDrsClosedAndLckd6_a1, dd_cDrsIsolEle6_a1, dd_cDrsEmHand6_a1);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_a1 =             getValue("port0x121", "DD_CDrsFault7_A1");
        Long dd_cDrsIsol7_a1 =              getValue("port0x122", "DD_CDrsIsol7_A1");
        Long dd_cDrsCommOk7_a1 =            getValue("port0x122", "DD_CDrsCommOk7_A1");
        Long dd_cDrsObstr7_a1 =             getValue("port0x121", "DD_CDrsObstr7_A1");
        Long dd_cDrsOpened7_a1 =            getValue("port0x121", "DD_CDrsOpened7_A1");
        Long dd_cDrsClosedAndLckd7_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd7_A1");
        Long dd_cDrsIsolEle7_a1 =           getValue("port0x122", "DD_CDrsIsolEle7_A1");
        Long dd_cDrsEmHand7_a1 =            getValue("port0x122", "DD_CDrsEmHand7_A1");
        Map door_7 = getDoorData(dd_cDrsFault7_a1, dd_cDrsIsol7_a1, dd_cDrsCommOk7_a1, dd_cDrsObstr7_a1, dd_cDrsOpened7_a1, dd_cDrsClosedAndLckd7_a1, dd_cDrsIsolEle7_a1, dd_cDrsEmHand7_a1);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_a1 =             getValue("port0x121", "DD_CDrsFault8_A1");
        Long dd_cDrsIsol8_a1 =              getValue("port0x122", "DD_CDrsIsol8_A1");
        Long dd_cDrsCommOk8_a1 =            getValue("port0x122", "DD_CDrsCommOk8_A1");
        Long dd_cDrsObstr8_a1 =             getValue("port0x121", "DD_CDrsObstr8_A1");
        Long dd_cDrsOpened8_a1 =            getValue("port0x121", "DD_CDrsOpened8_A1");
        Long dd_cDrsClosedAndLckd8_a1 =     getValue("port0x121", "DD_CDrsClosedAndLckd8_A1");
        Long dd_cDrsIsolEle8_a1 =           getValue("port0x122", "DD_CDrsIsolEle8_A1");
        Long dd_cDrsEmHand8_a1 =            getValue("port0x122", "DD_CDrsEmHand8_A1");
        Map door_8 = getDoorData(dd_cDrsFault8_a1, dd_cDrsIsol8_a1, dd_cDrsCommOk8_a1, dd_cDrsObstr8_a1, dd_cDrsOpened8_a1, dd_cDrsClosedAndLckd8_a1, dd_cDrsIsolEle8_a1, dd_cDrsEmHand8_a1);
        data.put("door_8", door_8);

        return data;
    }

    private static Map getDoorData(Long dd_cDrsFault1_a1, Long dd_cDrsIsol1_a1, Long dd_cDrsCommOk1_a1, Long dd_cDrsObstr1_a1, Long dd_cDrsOpened1_a1, Long dd_cDrsClosedAndLckd1_a1, Long dd_cDrsIsolEle1_a1, Long dd_cDrsEmHand1_a1) {
        Map DEHEIS = new HashMap();
        String Electrically = "false";
        String Emergencyhandleactivated = "false";
        if (dd_cDrsIsolEle1_a1 == 1) {
            Electrically = "true";
        } else if (dd_cDrsEmHand1_a1 == 1 && dd_cDrsIsolEle1_a1 == 0) {
            Emergencyhandleactivated = "true";
        }
        String door_1 = getDoorStatus(dd_cDrsFault1_a1, dd_cDrsIsol1_a1, dd_cDrsCommOk1_a1, dd_cDrsObstr1_a1, dd_cDrsOpened1_a1, dd_cDrsClosedAndLckd1_a1);
        DEHEIS.put("Electrically", Electrically);
        DEHEIS.put("Emergencyhandleactivated", Emergencyhandleactivated);
        DEHEIS.put("stauts", door_1);
        return DEHEIS;
    }

    /**
     * DoorStatusA2Data
     */
    private static Map DoorStatusA2Data() {
        Map data = new HashMap();
        Long dd_cDrsFault1_a2 =         getValue("port0x121", "DD_CDrsFault1_A2");
        Long dd_cDrsIsol1_a2 =          getValue("port0x122", "DD_CDrsIsol1_A2");
        Long dd_cDrsCommOk1_a2 =        getValue("port0x122", "DD_CDrsCommOk1_A2");
        Long dd_cDrsObstr1_a2 =         getValue("port0x121", "DD_CDrsObstr1_A2");
        Long dd_cDrsOpened1_a2 =        getValue("port0x121", "DD_CDrsOpened1_A2");
        Long dd_cDrsClosedAndLckd1_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd1_A2");
        Long dd_cDrsIsolEle1_a2 = getValue("port0x122", "DD_CDrsIsolEle1_A2");
        Long dd_cDrsIsolEle2_a2 = getValue("port0x122", "DD_CDrsIsolEle2_A2");
        Long dd_cDrsIsolEle3_a2 = getValue("port0x122", "DD_CDrsIsolEle3_A2");
        Long dd_cDrsIsolEle4_a2 = getValue("port0x122", "DD_CDrsIsolEle4_A2");
        Long dd_cDrsIsolEle5_a2 = getValue("port0x122", "DD_CDrsIsolEle5_A2");
        Long dd_cDrsIsolEle6_a2 = getValue("port0x122", "DD_CDrsIsolEle6_A2");
        Long dd_cDrsIsolEle7_a2 = getValue("port0x122", "DD_CDrsIsolEle7_A2");
        Long dd_cDrsIsolEle8_a2 = getValue("port0x122", "DD_CDrsIsolEle8_A2");
        
        Long dd_cDrsEmHand1_a2 = getValue("port0x122", "DD_CDrsEmHand1_A2");
        Long dd_cDrsEmHand2_a2 = getValue("port0x122", "DD_CDrsEmHand2_A2");
        Long dd_cDrsEmHand3_a2 = getValue("port0x122", "DD_CDrsEmHand3_A2");
        Long dd_cDrsEmHand4_a2 = getValue("port0x122", "DD_CDrsEmHand4_A2");
        Long dd_cDrsEmHand5_a2 = getValue("port0x122", "DD_CDrsEmHand5_A2");
        Long dd_cDrsEmHand6_a2 = getValue("port0x122", "DD_CDrsEmHand6_A2");
        Long dd_cDrsEmHand7_a2 = getValue("port0x122", "DD_CDrsEmHand7_A2");
        Long dd_cDrsEmHand8_a2 = getValue("port0x122", "DD_CDrsEmHand8_A2");
        Map door_1 = getDoorData(dd_cDrsFault1_a2, dd_cDrsIsol1_a2, dd_cDrsCommOk1_a2, dd_cDrsObstr1_a2, dd_cDrsOpened1_a2, dd_cDrsClosedAndLckd1_a2, dd_cDrsIsolEle1_a2, dd_cDrsEmHand1_a2);
        data.put("door_1", door_1);

        Long dd_cDrsFault2_a2 =         getValue("port0x121", "DD_CDrsFault2_A2");
        Long dd_cDrsIsol2_a2 =          getValue("port0x122", "DD_CDrsIsol2_A2");
        Long dd_cDrsCommOk2_a2 =        getValue("port0x122", "DD_CDrsCommOk2_A2");
        Long dd_cDrsObstr2_a2 =         getValue("port0x121", "DD_CDrsObstr2_A2");
        Long dd_cDrsOpened2_a2 =        getValue("port0x121", "DD_CDrsOpened2_A2");
        Long dd_cDrsClosedAndLckd2_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd2_A2");
        Map door_2 = getDoorData(dd_cDrsFault2_a2, dd_cDrsIsol2_a2, dd_cDrsCommOk2_a2, dd_cDrsObstr2_a2, dd_cDrsOpened2_a2, dd_cDrsClosedAndLckd2_a2, dd_cDrsIsolEle2_a2, dd_cDrsEmHand2_a2);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_a2 =         getValue("port0x121", "DD_CDrsFault3_A2");
        Long dd_cDrsIsol3_a2 =          getValue("port0x122", "DD_CDrsIsol3_A2");
        Long dd_cDrsCommOk3_a2 =        getValue("port0x122", "DD_CDrsCommOk3_A2");
        Long dd_cDrsObstr3_a2 =         getValue("port0x121", "DD_CDrsObstr3_A2");
        Long dd_cDrsOpened3_a2 =        getValue("port0x121", "DD_CDrsOpened3_A2");
        Long dd_cDrsClosedAndLckd3_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd3_A2");
        Map door_3 = getDoorData(dd_cDrsFault3_a2, dd_cDrsIsol3_a2, dd_cDrsCommOk3_a2, dd_cDrsObstr3_a2, dd_cDrsOpened3_a2, dd_cDrsClosedAndLckd3_a2, dd_cDrsIsolEle3_a2, dd_cDrsEmHand3_a2);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_a2 =         getValue("port0x121", "DD_CDrsFault4_A2");
        Long dd_cDrsIsol4_a2 =          getValue("port0x122", "DD_CDrsIsol4_A2");
        Long dd_cDrsCommOk4_a2 =        getValue("port0x122", "DD_CDrsCommOk4_A2");
        Long dd_cDrsObstr4_a2 =         getValue("port0x121", "DD_CDrsObstr4_A2");
        Long dd_cDrsOpened4_a2 =        getValue("port0x121", "DD_CDrsOpened4_A2");
        Long dd_cDrsClosedAndLckd4_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd4_A2");
        Map door_4 = getDoorData(dd_cDrsFault4_a2, dd_cDrsIsol4_a2, dd_cDrsCommOk4_a2, dd_cDrsObstr4_a2, dd_cDrsOpened4_a2, dd_cDrsClosedAndLckd4_a2, dd_cDrsIsolEle4_a2, dd_cDrsEmHand4_a2);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_a2 =         getValue("port0x121", "DD_CDrsFault5_A2");
        Long dd_cDrsIsol5_a2 =          getValue("port0x122", "DD_CDrsIsol5_A2");
        Long dd_cDrsCommOk5_a2 =        getValue("port0x122", "DD_CDrsCommOk5_A2");
        Long dd_cDrsObstr5_a2 =         getValue("port0x121", "DD_CDrsObstr5_A2");
        Long dd_cDrsOpened5_a2 =        getValue("port0x121", "DD_CDrsOpened5_A2");
        Long dd_cDrsClosedAndLckd5_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd5_A2");
        Map door_5 = getDoorData(dd_cDrsFault5_a2, dd_cDrsIsol5_a2, dd_cDrsCommOk5_a2, dd_cDrsObstr5_a2, dd_cDrsOpened5_a2, dd_cDrsClosedAndLckd5_a2, dd_cDrsIsolEle5_a2, dd_cDrsEmHand5_a2);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_a2 =         getValue("port0x121", "DD_CDrsFault6_A2");
        Long dd_cDrsIsol6_a2 =          getValue("port0x122", "DD_CDrsIsol6_A2");
        Long dd_cDrsCommOk6_a2 =        getValue("port0x122", "DD_CDrsCommOk6_A2");
        Long dd_cDrsObstr6_a2 =         getValue("port0x121", "DD_CDrsObstr6_A2");
        Long dd_cDrsOpened6_a2 =        getValue("port0x121", "DD_CDrsOpened6_A2");
        Long dd_cDrsClosedAndLckd6_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd6_A2");
        Map door_6 = getDoorData(dd_cDrsFault6_a2, dd_cDrsIsol6_a2, dd_cDrsCommOk6_a2, dd_cDrsObstr6_a2, dd_cDrsOpened6_a2, dd_cDrsClosedAndLckd6_a2, dd_cDrsIsolEle6_a2, dd_cDrsEmHand6_a2);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_a2 =         getValue("port0x121", "DD_CDrsFault7_A2");
        Long dd_cDrsIsol7_a2 =          getValue("port0x122", "DD_CDrsIsol7_A2");
        Long dd_cDrsCommOk7_a2 =        getValue("port0x122", "DD_CDrsCommOk7_A2");
        Long dd_cDrsObstr7_a2 =         getValue("port0x121", "DD_CDrsObstr7_A2");
        Long dd_cDrsOpened7_a2 =        getValue("port0x121", "DD_CDrsOpened7_A2");
        Long dd_cDrsClosedAndLckd7_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd7_A2");
        Map door_7 = getDoorData(dd_cDrsFault7_a2, dd_cDrsIsol7_a2, dd_cDrsCommOk7_a2, dd_cDrsObstr7_a2, dd_cDrsOpened7_a2, dd_cDrsClosedAndLckd7_a2, dd_cDrsIsolEle7_a2, dd_cDrsEmHand7_a2);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_a2 =         getValue("port0x121", "DD_CDrsFault8_A2");
        Long dd_cDrsIsol8_a2 =          getValue("port0x122", "DD_CDrsIsol8_A2");
        Long dd_cDrsCommOk8_a2 =        getValue("port0x122", "DD_CDrsCommOk8_A2");
        Long dd_cDrsObstr8_a2 =         getValue("port0x121", "DD_CDrsObstr8_A2");
        Long dd_cDrsOpened8_a2 =        getValue("port0x121", "DD_CDrsOpened8_A2");
        Long dd_cDrsClosedAndLckd8_a2 = getValue("port0x121", "DD_CDrsClosedAndLckd8_A2");
        Map door_8 = getDoorData(dd_cDrsFault8_a2, dd_cDrsIsol8_a2, dd_cDrsCommOk8_a2, dd_cDrsObstr8_a2, dd_cDrsOpened8_a2, dd_cDrsClosedAndLckd8_a2, dd_cDrsIsolEle8_a2, dd_cDrsEmHand8_a2);
        data.put("door_8", door_8);

        return data;
    }

    /**
     * DoorStatusB1Data
     */
    private static Map DoorStatusB1Data() {
        Map data = new HashMap();
        Long dd_cDrsIsolEle1_b1 = getValue("port0x122", "DD_CDrsIsolEle1_B1");
        Long dd_cDrsIsolEle2_b1 = getValue("port0x122", "DD_CDrsIsolEle2_B1");
        Long dd_cDrsIsolEle3_b1 = getValue("port0x122", "DD_CDrsIsolEle3_B1");
        Long dd_cDrsIsolEle4_b1 = getValue("port0x122", "DD_CDrsIsolEle4_B1");
        Long dd_cDrsIsolEle5_b1 = getValue("port0x122", "DD_CDrsIsolEle5_B1");
        Long dd_cDrsIsolEle6_b1 = getValue("port0x122", "DD_CDrsIsolEle6_B1");
        Long dd_cDrsIsolEle7_b1 = getValue("port0x122", "DD_CDrsIsolEle7_B1");
        Long dd_cDrsIsolEle8_b1 = getValue("port0x122", "DD_CDrsIsolEle8_B1");

        Long dd_cDrsEmHand1_b1= getValue("port0x122", "DD_CDrsEmHand1_B1");
        Long dd_cDrsEmHand2_b1= getValue("port0x122", "DD_CDrsEmHand2_B1");
        Long dd_cDrsEmHand3_b1= getValue("port0x122", "DD_CDrsEmHand3_B1");
        Long dd_cDrsEmHand4_b1= getValue("port0x122", "DD_CDrsEmHand4_B1");
        Long dd_cDrsEmHand5_b1= getValue("port0x122", "DD_CDrsEmHand5_B1");
        Long dd_cDrsEmHand6_b1= getValue("port0x122", "DD_CDrsEmHand6_B1");
        Long dd_cDrsEmHand7_b1= getValue("port0x122", "DD_CDrsEmHand7_B1");
        Long dd_cDrsEmHand8_b1= getValue("port0x122", "DD_CDrsEmHand8_B1");

        Long dd_cDrsFault1_b1 =         getValue("port0x121", "DD_CDrsFault1_B1");
        Long dd_cDrsIsol1_b1 =          getValue("port0x122", "DD_CDrsIsol1_B1");
        Long dd_cDrsCommOk1_b1 =        getValue("port0x122", "DD_CDrsCommOk1_B1");
        Long dd_cDrsObstr1_b1 =         getValue("port0x121", "DD_CDrsObstr1_B1");
        Long dd_cDrsOpened1_b1 =        getValue("port0x121", "DD_CDrsOpened1_B1");
        Long dd_cDrsClosedAndLckd1_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd1_B1");
        Map door_1 = getDoorData(dd_cDrsFault1_b1, dd_cDrsIsol1_b1, dd_cDrsCommOk1_b1, dd_cDrsObstr1_b1, dd_cDrsOpened1_b1, dd_cDrsClosedAndLckd1_b1, dd_cDrsIsolEle1_b1, dd_cDrsEmHand1_b1);
        data.put("door_1", door_1);
        Long dd_cDrsFault2_b1 =         getValue("port0x121", "DD_CDrsFault2_B1");
        Long dd_cDrsIsol2_b1 =          getValue("port0x122", "DD_CDrsIsol2_B1");
        Long dd_cDrsCommOk2_b1 =        getValue("port0x122", "DD_CDrsCommOk2_B1");
        Long dd_cDrsObstr2_b1 =         getValue("port0x121", "DD_CDrsObstr2_B1");
        Long dd_cDrsOpened2_b1 =        getValue("port0x121", "DD_CDrsOpened2_B1");
        Long dd_cDrsClosedAndLckd2_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd2_B1");
        Map door_2 = getDoorData(dd_cDrsFault2_b1, dd_cDrsIsol2_b1, dd_cDrsCommOk2_b1, dd_cDrsObstr2_b1, dd_cDrsOpened2_b1, dd_cDrsClosedAndLckd2_b1, dd_cDrsIsolEle2_b1, dd_cDrsEmHand2_b1);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_b1 =         getValue("port0x121", "DD_CDrsFault3_B1");
        Long dd_cDrsIsol3_b1 =          getValue("port0x122", "DD_CDrsIsol3_B1");
        Long dd_cDrsCommOk3_b1 =        getValue("port0x122", "DD_CDrsCommOk3_B1");
        Long dd_cDrsObstr3_b1 =         getValue("port0x121", "DD_CDrsObstr3_B1");
        Long dd_cDrsOpened3_b1 =        getValue("port0x121", "DD_CDrsOpened3_B1");
        Long dd_cDrsClosedAndLckd3_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd3_B1");
        Map door_3 = getDoorData(dd_cDrsFault3_b1, dd_cDrsIsol3_b1, dd_cDrsCommOk3_b1, dd_cDrsObstr3_b1, dd_cDrsOpened3_b1, dd_cDrsClosedAndLckd3_b1, dd_cDrsIsolEle3_b1, dd_cDrsEmHand3_b1);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_b1 =         getValue("port0x121", "DD_CDrsFault4_B1");
        Long dd_cDrsIsol4_b1 =          getValue("port0x122", "DD_CDrsIsol4_B1");
        Long dd_cDrsCommOk4_b1 =        getValue("port0x122", "DD_CDrsCommOk4_B1");
        Long dd_cDrsObstr4_b1 =         getValue("port0x121", "DD_CDrsObstr4_B1");
        Long dd_cDrsOpened4_b1 =        getValue("port0x121", "DD_CDrsOpened4_B1");
        Long dd_cDrsClosedAndLckd4_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd4_B1");
        Map door_4 = getDoorData(dd_cDrsFault4_b1, dd_cDrsIsol4_b1, dd_cDrsCommOk4_b1, dd_cDrsObstr4_b1, dd_cDrsOpened4_b1, dd_cDrsClosedAndLckd4_b1, dd_cDrsIsolEle4_b1, dd_cDrsEmHand4_b1);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_b1 =         getValue("port0x121", "DD_CDrsFault5_B1");
        Long dd_cDrsIsol5_b1 =          getValue("port0x122", "DD_CDrsIsol5_B1");
        Long dd_cDrsCommOk5_b1 =        getValue("port0x122", "DD_CDrsCommOk5_B1");
        Long dd_cDrsObstr5_b1 =         getValue("port0x121", "DD_CDrsObstr5_B1");
        Long dd_cDrsOpened5_b1 =        getValue("port0x121", "DD_CDrsOpened5_B1");
        Long dd_cDrsClosedAndLckd5_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd5_B1");
        Map door_5 = getDoorData(dd_cDrsFault5_b1, dd_cDrsIsol5_b1, dd_cDrsCommOk5_b1, dd_cDrsObstr5_b1, dd_cDrsOpened5_b1, dd_cDrsClosedAndLckd5_b1, dd_cDrsIsolEle5_b1, dd_cDrsEmHand5_b1);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_b1 =         getValue("port0x121", "DD_CDrsFault6_B1");
        Long dd_cDrsIsol6_b1 =          getValue("port0x122", "DD_CDrsIsol6_B1");
        Long dd_cDrsCommOk6_b1 =        getValue("port0x122", "DD_CDrsCommOk6_B1");
        Long dd_cDrsObstr6_b1 =         getValue("port0x121", "DD_CDrsObstr6_B1");
        Long dd_cDrsOpened6_b1 =        getValue("port0x121", "DD_CDrsOpened6_B1");
        Long dd_cDrsClosedAndLckd6_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd6_B1");
        Map door_6 = getDoorData(dd_cDrsFault6_b1, dd_cDrsIsol6_b1, dd_cDrsCommOk6_b1, dd_cDrsObstr6_b1, dd_cDrsOpened6_b1, dd_cDrsClosedAndLckd6_b1, dd_cDrsIsolEle6_b1, dd_cDrsEmHand6_b1);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_b1 =         getValue("port0x121", "DD_CDrsFault7_B1");
        Long dd_cDrsIsol7_b1 =          getValue("port0x122", "DD_CDrsIsol7_B1");
        Long dd_cDrsCommOk7_b1 =        getValue("port0x122", "DD_CDrsCommOk7_B1");
        Long dd_cDrsObstr7_b1 =         getValue("port0x121", "DD_CDrsObstr7_B1");
        Long dd_cDrsOpened7_b1 =        getValue("port0x121", "DD_CDrsOpened7_B1");
        Long dd_cDrsClosedAndLckd7_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd7_B1");
        Map door_7 = getDoorData(dd_cDrsFault7_b1, dd_cDrsIsol7_b1, dd_cDrsCommOk7_b1, dd_cDrsObstr7_b1, dd_cDrsOpened7_b1, dd_cDrsClosedAndLckd7_b1, dd_cDrsIsolEle7_b1, dd_cDrsEmHand7_b1);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_b1 =         getValue("port0x121", "DD_CDrsFault8_B1");
        Long dd_cDrsIsol8_b1 =          getValue("port0x122", "DD_CDrsIsol8_B1");
        Long dd_cDrsCommOk8_b1 =        getValue("port0x122", "DD_CDrsCommOk8_B1");
        Long dd_cDrsObstr8_b1 =         getValue("port0x121", "DD_CDrsObstr8_B1");
        Long dd_cDrsOpened8_b1 =        getValue("port0x121", "DD_CDrsOpened8_B1");
        Long dd_cDrsClosedAndLckd8_b1 = getValue("port0x121", "DD_CDrsClosedAndLckd8_B1");
        Map door_8 = getDoorData(dd_cDrsFault8_b1, dd_cDrsIsol8_b1, dd_cDrsCommOk8_b1, dd_cDrsObstr8_b1, dd_cDrsOpened8_b1, dd_cDrsClosedAndLckd8_b1, dd_cDrsIsolEle8_b1, dd_cDrsEmHand8_b1);
        data.put("door_8", door_8);

        return data;
    }

    /**
     * DoorStatusB2Data
     */
    private static Map DoorStatusB2Data() {
        Map data = new HashMap();
        Long dd_cDrsIsolEle1_b2 = getValue("port0x122", "DD_CDrsIsolEle1_B2");
        Long dd_cDrsIsolEle2_b2 = getValue("port0x122", "DD_CDrsIsolEle2_B2");
        Long dd_cDrsIsolEle3_b2 = getValue("port0x122", "DD_CDrsIsolEle3_B2");
        Long dd_cDrsIsolEle4_b2 = getValue("port0x122", "DD_CDrsIsolEle4_B2");
        Long dd_cDrsIsolEle5_b2 = getValue("port0x122", "DD_CDrsIsolEle5_B2");
        Long dd_cDrsIsolEle6_b2 = getValue("port0x122", "DD_CDrsIsolEle6_B2");
        Long dd_cDrsIsolEle7_b2 = getValue("port0x122", "DD_CDrsIsolEle7_B2");
        Long dd_cDrsIsolEle8_b2 = getValue("port0x122", "DD_CDrsIsolEle8_B2");

        Long dd_cDrsEmHand1_b2= getValue("port0x122", "DD_CDrsEmHand1_B2");
        Long dd_cDrsEmHand2_b2= getValue("port0x122", "DD_CDrsEmHand2_B2");
        Long dd_cDrsEmHand3_b2= getValue("port0x122", "DD_CDrsEmHand3_B2");
        Long dd_cDrsEmHand4_b2= getValue("port0x122", "DD_CDrsEmHand4_B2");
        Long dd_cDrsEmHand5_b2= getValue("port0x122", "DD_CDrsEmHand5_B2");
        Long dd_cDrsEmHand6_b2= getValue("port0x122", "DD_CDrsEmHand6_B2");
        Long dd_cDrsEmHand7_b2= getValue("port0x122", "DD_CDrsEmHand7_B2");
        Long dd_cDrsEmHand8_b2= getValue("port0x122", "DD_CDrsEmHand8_B2");

        Long dd_cDrsFault1_b2 =         getValue("port0x121", "DD_CDrsFault1_B2");
        Long dd_cDrsIsol1_b2 =          getValue("port0x122", "DD_CDrsIsol1_B2");
        Long dd_cDrsCommOk1_b2 =        getValue("port0x122", "DD_CDrsCommOk1_B2");
        Long dd_cDrsObstr1_b2 =         getValue("port0x121", "DD_CDrsObstr1_B2");
        Long dd_cDrsOpened1_b2 =        getValue("port0x121", "DD_CDrsOpened1_B2");
        Long dd_cDrsClosedAndLckd1_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd1_B2");
        Map door_1 = getDoorData(dd_cDrsFault1_b2, dd_cDrsIsol1_b2, dd_cDrsCommOk1_b2, dd_cDrsObstr1_b2, dd_cDrsOpened1_b2, dd_cDrsClosedAndLckd1_b2, dd_cDrsIsolEle1_b2, dd_cDrsEmHand1_b2);
        data.put("door_1", door_1);
        Long dd_cDrsFault2_b2 =         getValue("port0x121", "DD_CDrsFault2_B2");
        Long dd_cDrsIsol2_b2 =          getValue("port0x122", "DD_CDrsIsol2_B2");
        Long dd_cDrsCommOk2_b2 =        getValue("port0x122", "DD_CDrsCommOk2_B2");
        Long dd_cDrsObstr2_b2 =         getValue("port0x121", "DD_CDrsObstr2_B2");
        Long dd_cDrsOpened2_b2 =        getValue("port0x121", "DD_CDrsOpened2_B2");
        Long dd_cDrsClosedAndLckd2_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd2_B2");
        Map door_2 = getDoorData(dd_cDrsFault2_b2, dd_cDrsIsol2_b2, dd_cDrsCommOk2_b2, dd_cDrsObstr2_b2, dd_cDrsOpened2_b2, dd_cDrsClosedAndLckd2_b2, dd_cDrsIsolEle2_b2, dd_cDrsEmHand2_b2);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_b2 =         getValue("port0x121", "DD_CDrsFault3_B2");
        Long dd_cDrsIsol3_b2 =          getValue("port0x122", "DD_CDrsIsol3_B2");
        Long dd_cDrsCommOk3_b2 =        getValue("port0x122", "DD_CDrsCommOk3_B2");
        Long dd_cDrsObstr3_b2 =         getValue("port0x121", "DD_CDrsObstr3_B2");
        Long dd_cDrsOpened3_b2 =        getValue("port0x121", "DD_CDrsOpened3_B2");
        Long dd_cDrsClosedAndLckd3_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd3_B2");
        Map door_3 = getDoorData(dd_cDrsFault3_b2, dd_cDrsIsol3_b2, dd_cDrsCommOk3_b2, dd_cDrsObstr3_b2, dd_cDrsOpened3_b2, dd_cDrsClosedAndLckd3_b2, dd_cDrsIsolEle3_b2, dd_cDrsEmHand3_b2);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_b2 =         getValue("port0x121", "DD_CDrsFault4_B2");
        Long dd_cDrsIsol4_b2 =          getValue("port0x122", "DD_CDrsIsol4_B2");
        Long dd_cDrsCommOk4_b2 =        getValue("port0x122", "DD_CDrsCommOk4_B2");
        Long dd_cDrsObstr4_b2 =         getValue("port0x121", "DD_CDrsObstr4_B2");
        Long dd_cDrsOpened4_b2 =        getValue("port0x121", "DD_CDrsOpened4_B2");
        Long dd_cDrsClosedAndLckd4_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd4_B2");
        Map door_4 = getDoorData(dd_cDrsFault4_b2, dd_cDrsIsol4_b2, dd_cDrsCommOk4_b2, dd_cDrsObstr4_b2, dd_cDrsOpened4_b2, dd_cDrsClosedAndLckd4_b2, dd_cDrsIsolEle4_b2, dd_cDrsEmHand4_b2);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_b2 =         getValue("port0x121", "DD_CDrsFault5_B2");
        Long dd_cDrsIsol5_b2 =          getValue("port0x122", "DD_CDrsIsol5_B2");
        Long dd_cDrsCommOk5_b2 =        getValue("port0x122", "DD_CDrsCommOk5_B2");
        Long dd_cDrsObstr5_b2 =         getValue("port0x121", "DD_CDrsObstr5_B2");
        Long dd_cDrsOpened5_b2 =        getValue("port0x121", "DD_CDrsOpened5_B2");
        Long dd_cDrsClosedAndLckd5_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd5_B2");
        Map door_5 = getDoorData(dd_cDrsFault5_b2, dd_cDrsIsol5_b2, dd_cDrsCommOk5_b2, dd_cDrsObstr5_b2, dd_cDrsOpened5_b2, dd_cDrsClosedAndLckd5_b2, dd_cDrsIsolEle5_b2, dd_cDrsEmHand5_b2);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_b2 =         getValue("port0x121", "DD_CDrsFault6_B2");
        Long dd_cDrsIsol6_b2 =          getValue("port0x122", "DD_CDrsIsol6_B2");
        Long dd_cDrsCommOk6_b2 =        getValue("port0x122", "DD_CDrsCommOk6_B2");
        Long dd_cDrsObstr6_b2 =         getValue("port0x121", "DD_CDrsObstr6_B2");
        Long dd_cDrsOpened6_b2 =        getValue("port0x121", "DD_CDrsOpened6_B2");
        Long dd_cDrsClosedAndLckd6_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd6_B2");
        Map door_6 = getDoorData(dd_cDrsFault6_b2, dd_cDrsIsol6_b2, dd_cDrsCommOk6_b2, dd_cDrsObstr6_b2, dd_cDrsOpened6_b2, dd_cDrsClosedAndLckd6_b2, dd_cDrsIsolEle6_b2, dd_cDrsEmHand6_b2);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_b2 =         getValue("port0x121", "DD_CDrsFault7_B2");
        Long dd_cDrsIsol7_b2 =          getValue("port0x122", "DD_CDrsIsol7_B2");
        Long dd_cDrsCommOk7_b2 =        getValue("port0x122", "DD_CDrsCommOk7_B2");
        Long dd_cDrsObstr7_b2 =         getValue("port0x121", "DD_CDrsObstr7_B2");
        Long dd_cDrsOpened7_b2 =        getValue("port0x121", "DD_CDrsOpened7_B2");
        Long dd_cDrsClosedAndLckd7_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd7_B2");
        Map door_7 = getDoorData(dd_cDrsFault7_b2, dd_cDrsIsol7_b2, dd_cDrsCommOk7_b2, dd_cDrsObstr7_b2, dd_cDrsOpened7_b2, dd_cDrsClosedAndLckd7_b2, dd_cDrsIsolEle7_b2, dd_cDrsEmHand7_b2);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_b2 =         getValue("port0x121", "DD_CDrsFault8_B2");
        Long dd_cDrsIsol8_b2 =          getValue("port0x122", "DD_CDrsIsol8_B2");
        Long dd_cDrsCommOk8_b2 =        getValue("port0x122", "DD_CDrsCommOk8_B2");
        Long dd_cDrsObstr8_b2 =         getValue("port0x121", "DD_CDrsObstr8_B2");
        Long dd_cDrsOpened8_b2 =        getValue("port0x121", "DD_CDrsOpened8_B2");
        Long dd_cDrsClosedAndLckd8_b2 = getValue("port0x121", "DD_CDrsClosedAndLckd8_B2");
        Map door_8 = getDoorData(dd_cDrsFault8_b2, dd_cDrsIsol8_b2, dd_cDrsCommOk8_b2, dd_cDrsObstr8_b2, dd_cDrsOpened8_b2, dd_cDrsClosedAndLckd8_b2, dd_cDrsIsolEle8_b2, dd_cDrsEmHand8_b2);
        data.put("door_8", door_8);


        return data;
    }

    /**
     * DoorStatusC1Data
     */
    private static Map DoorStatusC1Data() {
        Map data = new HashMap();
        Long dd_cDrsIsolEle1_c1 = getValue("port0x122", "DD_CDrsIsolEle1_C1");
        Long dd_cDrsIsolEle2_c1 = getValue("port0x122", "DD_CDrsIsolEle2_C1");
        Long dd_cDrsIsolEle3_c1 = getValue("port0x122", "DD_CDrsIsolEle3_C1");
        Long dd_cDrsIsolEle4_c1 = getValue("port0x122", "DD_CDrsIsolEle4_C1");
        Long dd_cDrsIsolEle5_c1 = getValue("port0x122", "DD_CDrsIsolEle5_C1");
        Long dd_cDrsIsolEle6_c1 = getValue("port0x122", "DD_CDrsIsolEle6_C1");
        Long dd_cDrsIsolEle7_c1 = getValue("port0x122", "DD_CDrsIsolEle7_C1");
        Long dd_cDrsIsolEle8_c1 = getValue("port0x122", "DD_CDrsIsolEle8_C1");

        Long dd_cDrsEmHand1_c1= getValue("port0x122", "DD_CDrsEmHand1_C1");
        Long dd_cDrsEmHand2_c1= getValue("port0x122", "DD_CDrsEmHand2_C1");
        Long dd_cDrsEmHand3_c1= getValue("port0x122", "DD_CDrsEmHand3_C1");
        Long dd_cDrsEmHand4_c1= getValue("port0x122", "DD_CDrsEmHand4_C1");
        Long dd_cDrsEmHand5_c1= getValue("port0x122", "DD_CDrsEmHand5_C1");
        Long dd_cDrsEmHand6_c1= getValue("port0x122", "DD_CDrsEmHand6_C1");
        Long dd_cDrsEmHand7_c1= getValue("port0x122", "DD_CDrsEmHand7_C1");
        Long dd_cDrsEmHand8_c1= getValue("port0x122", "DD_CDrsEmHand8_C1");

        Long dd_cDrsFault1_c1 =         getValue("port0x121", "DD_CDrsFault1_C1");
        Long dd_cDrsIsol1_c1 =          getValue("port0x122", "DD_CDrsIsol1_C1");
        Long dd_cDrsCommOk1_c1 =        getValue("port0x122", "DD_CDrsCommOk1_C1");
        Long dd_cDrsObstr1_c1 =         getValue("port0x121", "DD_CDrsObstr1_C1");
        Long dd_cDrsOpened1_c1 =        getValue("port0x121", "DD_CDrsOpened1_C1");
        Long dd_cDrsClosedAndLckd1_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd1_C1");
        Map door_1 = getDoorData(dd_cDrsFault1_c1, dd_cDrsIsol1_c1, dd_cDrsCommOk1_c1, dd_cDrsObstr1_c1, dd_cDrsOpened1_c1, dd_cDrsClosedAndLckd1_c1, dd_cDrsIsolEle1_c1, dd_cDrsEmHand1_c1);
        data.put("door_1", door_1);
        Long dd_cDrsFault2_c1 =         getValue("port0x121", "DD_CDrsFault2_C1");
        Long dd_cDrsIsol2_c1 =          getValue("port0x122", "DD_CDrsIsol2_C1");
        Long dd_cDrsCommOk2_c1 =        getValue("port0x122", "DD_CDrsCommOk2_C1");
        Long dd_cDrsObstr2_c1 =         getValue("port0x121", "DD_CDrsObstr2_C1");
        Long dd_cDrsOpened2_c1 =        getValue("port0x121", "DD_CDrsOpened2_C1");
        Long dd_cDrsClosedAndLckd2_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd2_C1");
        Map door_2 = getDoorData(dd_cDrsFault2_c1, dd_cDrsIsol2_c1, dd_cDrsCommOk2_c1, dd_cDrsObstr2_c1, dd_cDrsOpened2_c1, dd_cDrsClosedAndLckd2_c1, dd_cDrsIsolEle2_c1, dd_cDrsEmHand2_c1);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_c1 =         getValue("port0x121", "DD_CDrsFault3_C1");
        Long dd_cDrsIsol3_c1 =          getValue("port0x122", "DD_CDrsIsol3_C1");
        Long dd_cDrsCommOk3_c1 =        getValue("port0x122", "DD_CDrsCommOk3_C1");
        Long dd_cDrsObstr3_c1 =         getValue("port0x121", "DD_CDrsObstr3_C1");
        Long dd_cDrsOpened3_c1 =        getValue("port0x121", "DD_CDrsOpened3_C1");
        Long dd_cDrsClosedAndLckd3_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd3_C1");
        Map door_3 = getDoorData(dd_cDrsFault3_c1, dd_cDrsIsol3_c1, dd_cDrsCommOk3_c1, dd_cDrsObstr3_c1, dd_cDrsOpened3_c1, dd_cDrsClosedAndLckd3_c1, dd_cDrsIsolEle3_c1, dd_cDrsEmHand3_c1);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_c1 =         getValue("port0x121", "DD_CDrsFault4_C1");
        Long dd_cDrsIsol4_c1 =          getValue("port0x122", "DD_CDrsIsol4_C1");
        Long dd_cDrsCommOk4_c1 =        getValue("port0x122", "DD_CDrsCommOk4_C1");
        Long dd_cDrsObstr4_c1 =         getValue("port0x121", "DD_CDrsObstr4_C1");
        Long dd_cDrsOpened4_c1 =        getValue("port0x121", "DD_CDrsOpened4_C1");
        Long dd_cDrsClosedAndLckd4_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd4_C1");
        Map door_4 = getDoorData(dd_cDrsFault4_c1, dd_cDrsIsol4_c1, dd_cDrsCommOk4_c1, dd_cDrsObstr4_c1, dd_cDrsOpened4_c1, dd_cDrsClosedAndLckd4_c1, dd_cDrsIsolEle4_c1, dd_cDrsEmHand4_c1);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_c1 =         getValue("port0x121", "DD_CDrsFault5_C1");
        Long dd_cDrsIsol5_c1 =          getValue("port0x122", "DD_CDrsIsol5_C1");
        Long dd_cDrsCommOk5_c1 =        getValue("port0x122", "DD_CDrsCommOk5_C1");
        Long dd_cDrsObstr5_c1 =         getValue("port0x121", "DD_CDrsObstr5_C1");
        Long dd_cDrsOpened5_c1 =        getValue("port0x121", "DD_CDrsOpened5_C1");
        Long dd_cDrsClosedAndLckd5_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd5_C1");
        Map door_5 = getDoorData(dd_cDrsFault5_c1, dd_cDrsIsol5_c1, dd_cDrsCommOk5_c1, dd_cDrsObstr5_c1, dd_cDrsOpened5_c1, dd_cDrsClosedAndLckd5_c1, dd_cDrsIsolEle5_c1, dd_cDrsEmHand5_c1);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_c1 =         getValue("port0x121", "DD_CDrsFault6_C1");
        Long dd_cDrsIsol6_c1 =          getValue("port0x122", "DD_CDrsIsol6_C1");
        Long dd_cDrsCommOk6_c1 =        getValue("port0x122", "DD_CDrsCommOk6_C1");
        Long dd_cDrsObstr6_c1 =         getValue("port0x121", "DD_CDrsObstr6_C1");
        Long dd_cDrsOpened6_c1 =        getValue("port0x121", "DD_CDrsOpened6_C1");
        Long dd_cDrsClosedAndLckd6_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd6_C1");
        Map door_6 = getDoorData(dd_cDrsFault6_c1, dd_cDrsIsol6_c1, dd_cDrsCommOk6_c1, dd_cDrsObstr6_c1, dd_cDrsOpened6_c1, dd_cDrsClosedAndLckd6_c1, dd_cDrsIsolEle6_c1, dd_cDrsEmHand6_c1);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_c1 =         getValue("port0x121", "DD_CDrsFault7_C1");
        Long dd_cDrsIsol7_c1 =          getValue("port0x122", "DD_CDrsIsol7_C1");
        Long dd_cDrsCommOk7_c1 =        getValue("port0x122", "DD_CDrsCommOk7_C1");
        Long dd_cDrsObstr7_c1 =         getValue("port0x121", "DD_CDrsObstr7_C1");
        Long dd_cDrsOpened7_c1 =        getValue("port0x121", "DD_CDrsOpened7_C1");
        Long dd_cDrsClosedAndLckd7_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd7_C1");
        Map door_7 = getDoorData(dd_cDrsFault7_c1, dd_cDrsIsol7_c1, dd_cDrsCommOk7_c1, dd_cDrsObstr7_c1, dd_cDrsOpened7_c1, dd_cDrsClosedAndLckd7_c1, dd_cDrsIsolEle7_c1, dd_cDrsEmHand7_c1);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_c1 =         getValue("port0x121", "DD_CDrsFault8_C1");
        Long dd_cDrsIsol8_c1 =          getValue("port0x122", "DD_CDrsIsol8_C1");
        Long dd_cDrsCommOk8_c1 =        getValue("port0x122", "DD_CDrsCommOk8_C1");
        Long dd_cDrsObstr8_c1 =         getValue("port0x121", "DD_CDrsObstr8_C1");
        Long dd_cDrsOpened8_c1 =        getValue("port0x121", "DD_CDrsOpened8_C1");
        Long dd_cDrsClosedAndLckd8_c1 = getValue("port0x121", "DD_CDrsClosedAndLckd8_C1");
        Map door_8 = getDoorData(dd_cDrsFault8_c1, dd_cDrsIsol8_c1, dd_cDrsCommOk8_c1, dd_cDrsObstr8_c1, dd_cDrsOpened8_c1, dd_cDrsClosedAndLckd8_c1, dd_cDrsIsolEle8_c1, dd_cDrsEmHand8_c1);
        data.put("door_8", door_8);


        return data;
    }

    /**
     * DoorStatusC2Data
     */
    private static Map DoorStatusC2Data() {
        Map data = new HashMap();
        Long dd_cDrsIsolEle1_c2 = getValue("port0x122", "DD_CDrsIsolEle1_C2");
        Long dd_cDrsIsolEle2_c2 = getValue("port0x122", "DD_CDrsIsolEle2_C2");
        Long dd_cDrsIsolEle3_c2 = getValue("port0x122", "DD_CDrsIsolEle3_C2");
        Long dd_cDrsIsolEle4_c2 = getValue("port0x122", "DD_CDrsIsolEle4_C2");
        Long dd_cDrsIsolEle5_c2 = getValue("port0x122", "DD_CDrsIsolEle5_C2");
        Long dd_cDrsIsolEle6_c2 = getValue("port0x122", "DD_CDrsIsolEle6_C2");
        Long dd_cDrsIsolEle7_c2 = getValue("port0x122", "DD_CDrsIsolEle7_C2");
        Long dd_cDrsIsolEle8_c2 = getValue("port0x122", "DD_CDrsIsolEle8_C2");

        Long dd_cDrsEmHand1_c2= getValue("port0x122", "DD_CDrsEmHand1_C2");
        Long dd_cDrsEmHand2_c2= getValue("port0x122", "DD_CDrsEmHand2_C2");
        Long dd_cDrsEmHand3_c2= getValue("port0x122", "DD_CDrsEmHand3_C2");
        Long dd_cDrsEmHand4_c2= getValue("port0x122", "DD_CDrsEmHand4_C2");
        Long dd_cDrsEmHand5_c2= getValue("port0x122", "DD_CDrsEmHand5_C2");
        Long dd_cDrsEmHand6_c2= getValue("port0x122", "DD_CDrsEmHand6_C2");
        Long dd_cDrsEmHand7_c2= getValue("port0x122", "DD_CDrsEmHand7_C2");
        Long dd_cDrsEmHand8_c2= getValue("port0x122", "DD_CDrsEmHand8_C2");

        Long dd_cDrsFault1_c2 =         getValue("port0x121", "DD_CDrsFault1_C2");
        Long dd_cDrsIsol1_c2 =          getValue("port0x122", "DD_CDrsIsol1_C2");
        Long dd_cDrsCommOk1_c2 =        getValue("port0x122", "DD_CDrsCommOk1_C2");
        Long dd_cDrsObstr1_c2 =         getValue("port0x121", "DD_CDrsObstr1_C2");
        Long dd_cDrsOpened1_c2 =        getValue("port0x121", "DD_CDrsOpened1_C2");
        Long dd_cDrsClosedAndLckd1_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd1_C2");
        Map door_1 = getDoorData(dd_cDrsFault1_c2, dd_cDrsIsol1_c2, dd_cDrsCommOk1_c2, dd_cDrsObstr1_c2, dd_cDrsOpened1_c2, dd_cDrsClosedAndLckd1_c2, dd_cDrsIsolEle1_c2, dd_cDrsEmHand1_c2);
        data.put("door_1", door_1);
        Long dd_cDrsFault2_c2 =         getValue("port0x121", "DD_CDrsFault2_C2");
        Long dd_cDrsIsol2_c2 =          getValue("port0x122", "DD_CDrsIsol2_C2");
        Long dd_cDrsCommOk2_c2 =        getValue("port0x122", "DD_CDrsCommOk2_C2");
        Long dd_cDrsObstr2_c2 =         getValue("port0x121", "DD_CDrsObstr2_C2");
        Long dd_cDrsOpened2_c2 =        getValue("port0x121", "DD_CDrsOpened2_C2");
        Long dd_cDrsClosedAndLckd2_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd2_C2");
        Map door_2 = getDoorData(dd_cDrsFault2_c2, dd_cDrsIsol2_c2, dd_cDrsCommOk2_c2, dd_cDrsObstr2_c2, dd_cDrsOpened2_c2, dd_cDrsClosedAndLckd2_c2, dd_cDrsIsolEle2_c2, dd_cDrsEmHand2_c2);
        data.put("door_2", door_2);
        Long dd_cDrsFault3_c2 =         getValue("port0x121", "DD_CDrsFault3_C2");
        Long dd_cDrsIsol3_c2 =          getValue("port0x122", "DD_CDrsIsol3_C2");
        Long dd_cDrsCommOk3_c2 =        getValue("port0x122", "DD_CDrsCommOk3_C2");
        Long dd_cDrsObstr3_c2 =         getValue("port0x121", "DD_CDrsObstr3_C2");
        Long dd_cDrsOpened3_c2 =        getValue("port0x121", "DD_CDrsOpened3_C2");
        Long dd_cDrsClosedAndLckd3_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd3_C2");
        Map door_3 = getDoorData(dd_cDrsFault3_c2, dd_cDrsIsol3_c2, dd_cDrsCommOk3_c2, dd_cDrsObstr3_c2, dd_cDrsOpened3_c2, dd_cDrsClosedAndLckd3_c2, dd_cDrsIsolEle3_c2, dd_cDrsEmHand3_c2);
        data.put("door_3", door_3);
        Long dd_cDrsFault4_c2 =         getValue("port0x121", "DD_CDrsFault4_C2");
        Long dd_cDrsIsol4_c2 =          getValue("port0x122", "DD_CDrsIsol4_C2");
        Long dd_cDrsCommOk4_c2 =        getValue("port0x122", "DD_CDrsCommOk4_C2");
        Long dd_cDrsObstr4_c2 =         getValue("port0x121", "DD_CDrsObstr4_C2");
        Long dd_cDrsOpened4_c2 =        getValue("port0x121", "DD_CDrsOpened4_C2");
        Long dd_cDrsClosedAndLckd4_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd4_C2");
        Map door_4 = getDoorData(dd_cDrsFault4_c2, dd_cDrsIsol4_c2, dd_cDrsCommOk4_c2, dd_cDrsObstr4_c2, dd_cDrsOpened4_c2, dd_cDrsClosedAndLckd4_c2, dd_cDrsIsolEle4_c2, dd_cDrsEmHand4_c2);
        data.put("door_4", door_4);
        Long dd_cDrsFault5_c2 =         getValue("port0x121", "DD_CDrsFault5_C2");
        Long dd_cDrsIsol5_c2 =          getValue("port0x122", "DD_CDrsIsol5_C2");
        Long dd_cDrsCommOk5_c2 =        getValue("port0x122", "DD_CDrsCommOk5_C2");
        Long dd_cDrsObstr5_c2 =         getValue("port0x121", "DD_CDrsObstr5_C2");
        Long dd_cDrsOpened5_c2 =        getValue("port0x121", "DD_CDrsOpened5_C2");
        Long dd_cDrsClosedAndLckd5_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd5_C2");
        Map door_5 = getDoorData(dd_cDrsFault5_c2, dd_cDrsIsol5_c2, dd_cDrsCommOk5_c2, dd_cDrsObstr5_c2, dd_cDrsOpened5_c2, dd_cDrsClosedAndLckd5_c2, dd_cDrsIsolEle5_c2, dd_cDrsEmHand5_c2);
        data.put("door_5", door_5);
        Long dd_cDrsFault6_c2 =         getValue("port0x121", "DD_CDrsFault6_C2");
        Long dd_cDrsIsol6_c2 =          getValue("port0x122", "DD_CDrsIsol6_C2");
        Long dd_cDrsCommOk6_c2 =        getValue("port0x122", "DD_CDrsCommOk6_C2");
        Long dd_cDrsObstr6_c2 =         getValue("port0x121", "DD_CDrsObstr6_C2");
        Long dd_cDrsOpened6_c2 =        getValue("port0x121", "DD_CDrsOpened6_C2");
        Long dd_cDrsClosedAndLckd6_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd6_C2");
        Map door_6 = getDoorData(dd_cDrsFault6_c2, dd_cDrsIsol6_c2, dd_cDrsCommOk6_c2, dd_cDrsObstr6_c2, dd_cDrsOpened6_c2, dd_cDrsClosedAndLckd6_c2, dd_cDrsIsolEle6_c2, dd_cDrsEmHand6_c2);
        data.put("door_6", door_6);
        Long dd_cDrsFault7_c2 =         getValue("port0x121", "DD_CDrsFault7_C2");
        Long dd_cDrsIsol7_c2 =          getValue("port0x122", "DD_CDrsIsol7_C2");
        Long dd_cDrsCommOk7_c2 =        getValue("port0x122", "DD_CDrsCommOk7_C2");
        Long dd_cDrsObstr7_c2 =         getValue("port0x121", "DD_CDrsObstr7_C2");
        Long dd_cDrsOpened7_c2 =        getValue("port0x121", "DD_CDrsOpened7_C2");
        Long dd_cDrsClosedAndLckd7_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd7_C2");
        Map door_7 = getDoorData(dd_cDrsFault7_c2, dd_cDrsIsol7_c2, dd_cDrsCommOk7_c2, dd_cDrsObstr7_c2, dd_cDrsOpened7_c2, dd_cDrsClosedAndLckd7_c2, dd_cDrsIsolEle7_c2, dd_cDrsEmHand7_c2);
        data.put("door_7", door_7);
        Long dd_cDrsFault8_c2 =         getValue("port0x121", "DD_CDrsFault8_C2");
        Long dd_cDrsIsol8_c2 =          getValue("port0x122", "DD_CDrsIsol8_C2");
        Long dd_cDrsCommOk8_c2 =        getValue("port0x122", "DD_CDrsCommOk8_C2");
        Long dd_cDrsObstr8_c2 =         getValue("port0x121", "DD_CDrsObstr8_C2");
        Long dd_cDrsOpened8_c2 =        getValue("port0x121", "DD_CDrsOpened8_C2");
        Long dd_cDrsClosedAndLckd8_c2 = getValue("port0x121", "DD_CDrsClosedAndLckd8_C2");
        Map door_8 = getDoorData(dd_cDrsFault8_c2, dd_cDrsIsol8_c2, dd_cDrsCommOk8_c2, dd_cDrsObstr8_c2, dd_cDrsOpened8_c2, dd_cDrsClosedAndLckd8_c2, dd_cDrsIsolEle8_c2, dd_cDrsEmHand8_c2);
        data.put("door_8", door_8);

        return data;
    }

    /**
     * @param dd_cDrsFault1_a1
     * @param dd_cDrsIsol1_a1
     * @param dd_cDrsCommOk1_a1
     * @param dd_cDrsObstr1_a1
     * @param dd_cDrsOpened1_a1
     * @param dd_cDrsClosedAndLckd1_a1
     * @return
     */

    private static String getDoorStatus(Long dd_cDrsFault1_a1, Long dd_cDrsIsol1_a1, Long dd_cDrsCommOk1_a1, Long dd_cDrsObstr1_a1, Long dd_cDrsOpened1_a1, Long dd_cDrsClosedAndLckd1_a1) {
        String door_1 = "open";
        if (dd_cDrsFault1_a1 == 1 &&
                dd_cDrsIsol1_a1 == 0 &&
                dd_cDrsCommOk1_a1 == 1) {
            door_1 = "fault";
            return door_1;
        }
        if (dd_cDrsObstr1_a1 == 1 &&
                dd_cDrsFault1_a1 == 0 &&
                dd_cDrsIsol1_a1 == 0 &&
                dd_cDrsCommOk1_a1 == 1) {
            door_1 = "obstruction";
            return door_1;
        }
        if (dd_cDrsOpened1_a1 == 1 &&
                dd_cDrsObstr1_a1 == 0 &&
                dd_cDrsFault1_a1 == 0 &&
                dd_cDrsIsol1_a1 == 0 &&
                dd_cDrsCommOk1_a1 == 1 &&
                dd_cDrsClosedAndLckd1_a1 == 0) {
            door_1 = "open";
            return door_1;
        }
        if (dd_cDrsOpened1_a1 == 0 &&
                dd_cDrsObstr1_a1 == 0 &&
                dd_cDrsFault1_a1 == 0 &&
                dd_cDrsIsol1_a1 == 0 &&
                dd_cDrsCommOk1_a1 == 1 &&
                dd_cDrsClosedAndLckd1_a1 == 1) {
            door_1 = "closed";
            return door_1;

        }
        if (dd_cDrsIsol1_a1 == 0 && dd_cDrsCommOk1_a1 == 1) {
            door_1 = "Isolated";
            return door_1;

        }
        if (dd_cDrsCommOk1_a1 == 0) {
            door_1 = "communication";
            return door_1;
        }
        return door_1;
    }
}
