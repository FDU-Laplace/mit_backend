package com.missiongroup.starring.core.vehicleData;

import java.util.HashMap;
import java.util.Map;

public class FSDDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map smokeAlarm = createSmokeAlarm();
        Map fireExtinguisher = createFireExtinguisher();
        Map batteryFire = createBatteryFire();
        Map cvs = createCVS();
        Map traction = createTraction();
        Map hvBox = createHVBox();
        Map lvBox = createLVBox();
        Map saloon = createSaloon();
        data.put("smokeAlarm", smokeAlarm);
        data.put("fireExtinguisher", fireExtinguisher);
        data.put("batteryFire", batteryFire);
        data.put("cvs", cvs);
        data.put("traction", traction);
        data.put("hvBox", hvBox);
        data.put("lvBox", lvBox);
        data.put("saloon", saloon);
        return data;
    }

    /**
     * smoke alarm
     */
    private static Map createSmokeAlarm() {
        Map<String, Object> data = new HashMap<>();


        Long dd_csdFlt_a1 = getValue("port0x123", "DD_CSDFlt_A1");
        Long dd_csd_a1 = getValue("port0x123", "DD_CSD_A1");
        Long dd_csmoke_prealarm_a1 = getValue("port0x123", "DD_CSmokePreAlarm_A1");
        String smoke_a1 = getSmokeStatus(dd_csdFlt_a1, dd_csd_a1, dd_csmoke_prealarm_a1);
        data.put("smokeAlarm", smoke_a1);
        Long dd_csdFlt_a2 = getValue("port0x123", "DD_CSDFlt_A2");
        Long dd_csd_a2 = getValue("port0x123", "DD_CSD_A2");
        Long dd_csmoke_prealarm_a2 = getValue("port0x123", "DD_CSmokePreAlarm_A2");
        String smoke_a2 = getSmokeStatus(dd_csdFlt_a2, dd_csd_a2, dd_csmoke_prealarm_a2);
        data.put("smoke_a2", smoke_a2);
        Long dd_csdFlt_b1 = getValue("port0x123", "DD_CSDFlt_B1");
        Long dd_csd_b1 = getValue("port0x123", "DD_CSD_B1");
        Long dd_csmoke_prealarm_b1 = getValue("port0x123", "DD_CSmokePreAlarm_B1");
        String smoke_b1 = getSmokeStatus(dd_csdFlt_b1, dd_csd_b1, dd_csmoke_prealarm_b1);
        data.put("smoke_b1", smoke_b1);
        Long dd_csdFlt_b2 = getValue("port0x123", "DD_CSDFlt_B2");
        Long dd_csd_b2 = getValue("port0x123", "DD_CSD_B2");
        Long dd_csmoke_prealarm_b2 = getValue("port0x123", "DD_CSmokePreAlarm_B2");
        String smoke_b2 = getSmokeStatus(dd_csdFlt_b2, dd_csd_b2, dd_csmoke_prealarm_b2);
        data.put("smoke_b2", smoke_b2);

        Long dd_csdFlt_c1 = getValue("port0x123", "DD_CSDFlt_C1");
        Long dd_csd_c1 = getValue("port0x123", "DD_CSD_C1");
        Long dd_csmoke_prealarm_c1 = getValue("port0x123", "DD_CSmokePreAlarm_C1");
        String smoke_c1 = getSmokeStatus(dd_csdFlt_c1, dd_csd_c1, dd_csmoke_prealarm_c1);
        data.put("smoke_c1", smoke_c1);
        Long dd_csdFlt_c2 = getValue("port0x123", "DD_CSDFlt_C2");
        Long dd_csd_c2 = getValue("port0x123", "DD_CSD_C2");
        Long dd_csmoke_prealarm_c2 = getValue("port0x123", "DD_CSmokePreAlarm_C2");
        String smoke_c2 = getSmokeStatus(dd_csdFlt_c2, dd_csd_c2, dd_csmoke_prealarm_c2);
        data.put("smoke_c2", smoke_c2);


        return data;
    }

    private static String getSmokeStatus(Long dd_csdFlt_a1, Long dd_csd_a1, Long dd_csmoke_prealarm) {
        String smole = "";
        if (dd_csdFlt_a1 == 0 && dd_csd_a1 == 0) {
            smole = "inactive";
        }
        else if (dd_csdFlt_a1 == 0 && dd_csd_a1 == 1 && dd_csmoke_prealarm == 0) {
            smole = "active";
        }
        else if (dd_csdFlt_a1 == 0 && dd_csmoke_prealarm == 1) {
            smole = "pre-Alarm";
        }
        else if (dd_csdFlt_a1 == 1) {
            smole = "out_of_order";
        }
        return smole;
    }

    /**
     * fire extinguisher
     */
    private static Map createFireExtinguisher() {
        Map<String, Object> data = new HashMap<>();

        Long dd_cFireExt1_a1 = getValue("port0x123", "DD_CFireExt1_A1");
        Long dd_cFireExt2_a1 = getValue("port0x123", "DD_CFireExt2_A1");
        Long dd_cFireExt3_a1 = getValue("port0x123", "DD_CFireExt3_A1");
        Long dd_cFireExt4_a1 = getValue("port0x123", "DD_CFireExt4_A1");
        String fireExt1_a1 = getStatus(dd_cFireExt1_a1);
        String fireExt2_a1 = getStatus(dd_cFireExt2_a1);
        String fireExt3_a1 = getStatus(dd_cFireExt3_a1);
        String fireExt4_a1 = getStatus(dd_cFireExt4_a1);
        data.put("fireExt1_a1", fireExt1_a1);
        data.put("fireExt2_a1", fireExt2_a1);
        data.put("fireExt3_a1", fireExt3_a1);
        data.put("fireExt4_a1", fireExt4_a1);

        Long dd_cFireExt1_a2 = getValue("port0x123", "DD_CFireExt1_A2");
        Long dd_cFireExt2_a2 = getValue("port0x123", "DD_CFireExt2_A2");
        Long dd_cFireExt3_a2 = getValue("port0x123", "DD_CFireExt3_A2");
        Long dd_cFireExt4_a2 = getValue("port0x123", "DD_CFireExt4_A2");
        String fireExt1_a2 = getStatus(dd_cFireExt1_a2);
        String fireExt2_a2 = getStatus(dd_cFireExt2_a2);
        String fireExt3_a2 = getStatus(dd_cFireExt3_a2);
        String fireExt4_a2 = getStatus(dd_cFireExt4_a2);
        data.put("fireExt1_a2", fireExt1_a2);
        data.put("fireExt2_a2", fireExt2_a2);
        data.put("fireExt3_a2", fireExt3_a2);
        data.put("fireExt4_a2", fireExt4_a2);


        Long dd_cFireExt1_b1 = getValue("port0x123", "DD_CFireExt1_B1");
        Long dd_cFireExt2_b1 = getValue("port0x123", "DD_CFireExt2_B1");
        Long dd_cFireExt3_b1 = getValue("port0x123", "DD_CFireExt3_B1");
        Long dd_cFireExt4_b1 = getValue("port0x123", "DD_CFireExt4_B1");
        String fireExt1_b1 = getStatus(dd_cFireExt1_b1);
        String fireExt2_b1 = getStatus(dd_cFireExt2_b1);
        String fireExt3_b1 = getStatus(dd_cFireExt3_b1);
        String fireExt4_b1 = getStatus(dd_cFireExt4_b1);
        data.put("fireExt1_b1", fireExt1_b1);
        data.put("fireExt2_b1", fireExt2_b1);
        data.put("fireExt3_b1", fireExt3_b1);
        data.put("fireExt4_b1", fireExt4_b1);

        Long dd_cFireExt1_b2 = getValue("port0x123", "DD_CFireExt1_B2");
        Long dd_cFireExt2_b2 = getValue("port0x123", "DD_CFireExt2_B2");
        Long dd_cFireExt3_b2 = getValue("port0x123", "DD_CFireExt3_B2");
        Long dd_cFireExt4_b2 = getValue("port0x123", "DD_CFireExt4_B2");
        String fireExt1_b2 = getStatus(dd_cFireExt1_b2);
        String fireExt2_b2 = getStatus(dd_cFireExt2_b2);
        String fireExt3_b2 = getStatus(dd_cFireExt3_b2);
        String fireExt4_b2 = getStatus(dd_cFireExt4_b2);
        data.put("fireExt1_b2", fireExt1_b2);
        data.put("fireExt2_b2", fireExt2_b2);
        data.put("fireExt3_b2", fireExt3_b2);
        data.put("fireExt4_b2", fireExt4_b2);

        Long dd_cFireExt1_c1 = getValue("port0x123", "DD_CFireExt1_C1");
        Long dd_cFireExt2_c1 = getValue("port0x123", "DD_CFireExt2_C1");
        Long dd_cFireExt3_c1 = getValue("port0x123", "DD_CFireExt3_C1");
        String fireExt1_c1 = getStatus(dd_cFireExt1_c1);
        String fireExt2_c1 = getStatus(dd_cFireExt2_c1);
        String fireExt3_c1 = getStatus(dd_cFireExt3_c1);
        data.put("fireExt1_c1", fireExt1_c1);
        data.put("fireExt2_c1", fireExt2_c1);
        data.put("fireExt3_c1", fireExt3_c1);

        Long dd_cFireExt1_c2 = getValue("port0x123", "DD_CFireExt1_C2");
        Long dd_cFireExt2_c2 = getValue("port0x123", "DD_CFireExt2_C2");
        Long dd_cFireExt3_c2 = getValue("port0x123", "DD_CFireExt3_C2");
        Long dd_cFireExt4_c2 = getValue("port0x123", "DD_CFireExt4_C2");
        String fireExt1_c2 = getStatus(dd_cFireExt1_c2);
        String fireExt2_c2 = getStatus(dd_cFireExt2_c2);
        String fireExt3_c2 = getStatus(dd_cFireExt3_c2);
        String fireExt4_c2 = getStatus(dd_cFireExt4_c2);
        data.put("fireExt1_c2", fireExt1_c2);
        data.put("fireExt2_c2", fireExt2_c2);
        data.put("fireExt3_c2", fireExt3_c2);
        data.put("fireExt4_c2", fireExt4_c2);

        return data;
    }

    private static String getStatus(Long dd_cFireExt1_a1) {
        String fireExt1_al = "";
        if (dd_cFireExt1_a1 == 1) {
            fireExt1_al = "true";
        }
        else if (dd_cFireExt1_a1 == 0) {
            fireExt1_al = "false";
        }
        return fireExt1_al;
    }


    /**
     * battery fire
     */
    private static Map createBatteryFire() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireBat_a1 = getValue("port0x123", "DD_CFireBat_A1");
        Long dd_cFireFltBat_a1 = getValue("port0x123", "DD_CFireFltBat_A1");
        String bf = getBatteryFireStatus(dd_cFireBat_a1, dd_cFireFltBat_a1);
        data.put("a1", bf);
        Long dd_cFireBat_a2 = getValue("port0x123", "DD_CFireBat_A2");
        Long dd_cFireFltBat_a2 = getValue("port0x123", "DD_CFireFltBat_A2");
        String bf_a2 = getBatteryFireStatus(dd_cFireBat_a2, dd_cFireFltBat_a2);
        data.put("a2", bf_a2);
        Long dd_cFireBat_c2 = getValue("port0x123", "DD_CFireBat_C2");
        Long dd_cFireFltBat_c2 = getValue("port0x123", "DD_CFireFltBat_C2");
        String bf_c2 = getBatteryFireStatus(dd_cFireBat_c2, dd_cFireFltBat_c2);
        data.put("c2", bf_c2);
        return data;
    }

    private static String getBatteryFireStatus(Long dd_cFireBat, Long dd_cFireFltBat_a1) {
        String bf = "";
        if (dd_cFireBat == 0 && dd_cFireFltBat_a1 == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltBat_a1 == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireBat == 1 && dd_cFireFltBat_a1 == 0) {
            bf = "fire_detected";
        }
        return bf;
    }


    /**
     * CVS
     */
    private static Map createCVS() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireCVS_a1 = getValue("port0x123", "DD_CFireCVS_A1");
        Long dd_cFireFltCVS_a1 = getValue("port0x123", "DD_CFireFltCVS_A1");
        Long dd_cFireCVS_a2 = getValue("port0x123", "DD_CFireCVS_A2");
        Long dd_cFireFltCVS_a2 = getValue("port0x123", "DD_CFireFltCVS_A2");

        Long dd_cFireCVS_c1 = getValue("port0x123", "DD_CFireCVS_C1");
        Long dd_cFireFltCVS_c1 = getValue("port0x123", "DD_CFireFltCVS_C1");
        Long dd_cFireCVS_c2 = getValue("port0x123", "DD_CFireCVS_C2");
        Long dd_cFireFltCVS_c2 = getValue("port0x123", "DD_CFireFltCVS_C2");
        String a1 = getCVSStatus(dd_cFireCVS_a1, dd_cFireFltCVS_a1);
        String a2 = getCVSStatus(dd_cFireCVS_a2, dd_cFireFltCVS_a2);
        String c1 = getCVSStatus(dd_cFireCVS_c1, dd_cFireFltCVS_c1);
        String c2 = getCVSStatus(dd_cFireCVS_c2, dd_cFireFltCVS_c2);
        data.put("a1", a1);
        data.put("a2", a2);
        data.put("c1", c1);
        data.put("c2", c2);

        return data;
    }

    private static String getCVSStatus(Long dd_cFireCVS, Long dd_cFireFltCVS) {
        String bf = "";
        if (dd_cFireCVS == 0 && dd_cFireFltCVS == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltCVS == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireCVS == 1 && dd_cFireFltCVS == 0) {
            bf = "fire_detected";
        }
        return bf;
    }

    /**
     * traction
     */
    private static Map createTraction() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireInPCE_b1 = getValue("port0x123", "DD_CFireInPCE_B1");
        Long dd_cFireFltTraction_b1 = getValue("port0x123", "DD_CFireFltTraction_B1");
        Long dd_cFireInPCE_b2 = getValue("port0x123", "DD_CFireInPCE_B2");
        Long dd_cFireFltTraction_b2 = getValue("port0x123", "DD_CFireFltTraction_B2");

        Long dd_cFireInPCE_c1 = getValue("port0x123", "DD_CFireInPCE_C1");
        Long dd_cFireFltTraction_c1 = getValue("port0x123", "DD_CFireFltTraction_C1");
        Long dd_cFireInPCE_c2 = getValue("port0x123", "DD_CFireInPCE_C2");
        Long dd_cFireFltTraction_c2 = getValue("port0x123", "DD_CFireFltTraction_C2");
        String b1 = getTractionStatus(dd_cFireInPCE_b1, dd_cFireFltTraction_b1);
        String b2 = getTractionStatus(dd_cFireInPCE_b2, dd_cFireFltTraction_b2);
        String c1 = getTractionStatus(dd_cFireInPCE_c1, dd_cFireFltTraction_c1);
        String c2 = getTractionStatus(dd_cFireInPCE_c2, dd_cFireFltTraction_c2);
        data.put("b1", b1);
        data.put("b2", b2);
        data.put("c1", c1);
        data.put("c2", c2);
        return data;
    }

    private static String getTractionStatus(Long dd_cFireTraction, Long dd_cFireFltTraction) {
        String bf = "";
        if (dd_cFireTraction == 0 && dd_cFireFltTraction == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltTraction == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireTraction == 1 && dd_cFireFltTraction == 0) {
            bf = "fire_detected";
        }
        return bf;
    }

    /**
     * HV Box
     */
    private static Map createHVBox() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireFltHVBox_b1 = getValue("port0x120", "DD_CFireFltHV_B1");
        Long dd_cFireFltHVBox_b2 = getValue("port0x120", "DD_CFireFltHV_B2");
        Long dd_cFireHVBox_b1 = getValue("port0x120", "DD_CFireHVBox_B1");
        Long dd_cFireHVBox_b2 = getValue("port0x120", "DD_CFireHVBox_B2");
        String b1 = getHVBoxStatus(dd_cFireHVBox_b1, dd_cFireFltHVBox_b1);
        String b2 = getHVBoxStatus(dd_cFireHVBox_b2, dd_cFireFltHVBox_b2);
        data.put("b1", b1);
        data.put("b2", b2);
        return data;
    }

    private static String getHVBoxStatus(Long dd_cFireHVBox, Long dd_cFireFltHVBox) {
        String bf = "";
        if (dd_cFireHVBox == 0 && dd_cFireFltHVBox == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltHVBox == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireHVBox == 1 && dd_cFireFltHVBox == 0) {
            bf = "fire_detected";
        }
        return bf;
    }

    /**
     * LV Box
     */
    private static Map createLVBox() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireLVBox_b1 = getValue("port0x120", "DD_CFireLVBox_B1");
        Long dd_cFireLVBox_b2 = getValue("port0x120", "DD_CFireLVBox_B2");
        Long dd_cFireFltLV_b1 = getValue("port0x120", "DD_CFireFltLV_B1");
        Long dd_cFireFltLV_b2 = getValue("port0x120", "DD_CFireFltLV_B2");
        String b1 = getLVBoxStatus(dd_cFireLVBox_b1, dd_cFireFltLV_b1);
        String b2 = getLVBoxStatus(dd_cFireLVBox_b2, dd_cFireFltLV_b2);
        data.put("b1", b1);
        data.put("b2", b2);
        return data;
    }

    private static String getLVBoxStatus(Long dd_cFireLVBox, Long dd_cFireFltLVBox) {
        String bf = "";
        if (dd_cFireLVBox == 0 && dd_cFireFltLVBox == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltLVBox == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireLVBox == 1 && dd_cFireFltLVBox == 0) {
            bf = "fire_detected";
        }
        return bf;
    }

    /**
     * Saloon
     */
    private static Map createSaloon() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cFireSaloon_a1 = getValue("port0x120", "DD_CFireSaloon_A1");
        Long dd_cFireSaloon_a2 = getValue("port0x120", "DD_CFireSaloon_A2");
        Long dd_cFireSaloon_b1 = getValue("port0x120", "DD_CFireSaloon_B1");
        Long dd_cFireSaloon_b2 = getValue("port0x120", "DD_CFireSaloon_B2");
        Long dd_cFireSaloon_c1 = getValue("port0x120", "DD_CFireSaloon_C1");
        Long dd_cFireSaloon_c2 = getValue("port0x120", "DD_CFireSaloon_C2");
        Long dd_cFireFltSaloon_a1 = getValue("port0x120", "DD_CFireFltSaloon_A1");
        Long dd_cFireFltSaloon_a2 = getValue("port0x120", "DD_CFireFltSaloon_A2");
        Long dd_cFireFltSaloon_b1 = getValue("port0x120", "DD_CFireFltSaloon_B1");
        Long dd_cFireFltSaloon_b2 = getValue("port0x120", "DD_CFireFltSaloon_B2");
        Long dd_cFireFltSaloon_c1 = getValue("port0x120", "DD_CFireFltSaloon_C1");
        Long dd_cFireFltSaloon_c2 = getValue("port0x120", "DD_CFireFltSaloon_C2");
        String a1 = getSaloonStatus(dd_cFireSaloon_a1, dd_cFireFltSaloon_a1);
        String a2 = getSaloonStatus(dd_cFireSaloon_a2, dd_cFireFltSaloon_a2);
        String b1 = getSaloonStatus(dd_cFireSaloon_b1, dd_cFireFltSaloon_b1);
        String b2 = getSaloonStatus(dd_cFireSaloon_b2, dd_cFireFltSaloon_b2);
        String c1 = getSaloonStatus(dd_cFireSaloon_c1, dd_cFireFltSaloon_c1);
        String c2 = getSaloonStatus(dd_cFireSaloon_c2, dd_cFireFltSaloon_c2);
        data.put("a1", a1);
        data.put("a2", a2);
        data.put("b1", b1);
        data.put("b2", b2);
        data.put("c1", c1);
        data.put("c2", c2);
        return data;
    }

    private static String getSaloonStatus(Long dd_cFireSaloonBox, Long dd_cFireFltSaloonBox) {
        String bf = "";
        if (dd_cFireSaloonBox == 0 && dd_cFireFltSaloonBox == 0) {
            bf = "no_fire_detected";
        }
        else if (dd_cFireFltSaloonBox == 1) {
            bf = "lhd_cable_broken";
        }
        else if (dd_cFireSaloonBox == 1 && dd_cFireFltSaloonBox == 0) {
            bf = "fire_detected";
        }
        return bf;
    }

}
