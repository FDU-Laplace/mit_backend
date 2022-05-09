package com.missiongroup.starring.core.vehicleData;


import java.util.HashMap;
import java.util.Map;

public class BypassSwithDataFactory extends DatatFactory {

    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map cab1 = createCab1();
        data.put("cab1", cab1);
        Map cab2 = createCab2();
        data.put("cab2", cab2);

        return data;
    }

    private static Map createCab1() {
        Map<String, Object> data = new HashMap<>();

        Long dd_cCab1Active = getValue("port0x123", "DD_CCab1Active");
        String cab1 = getStatus(dd_cCab1Active);
        data.put("cab1", cab1);

        Long dd_cbpBrk_a1 = getValue("port0x120", "DD_CBPBrk_A1");
        data.put("brake", dd_cbpBrk_a1);
        Long dd_ccab1ByPassed = getValue("port0x120", "DD_CCAB1ByPassed");
        data.put("key", dd_ccab1ByPassed);
        //data.put("atc",atc);
        Long dd_cdirbps_a2 = getValue("port0x120", "DD_CDIRBPS_A1");
        data.put("door_interlock", dd_cdirbps_a2);
        Long dd_cdebsa_a1 = getValue("port0x120", "DD_CDEBSA_A1");
        data.put("door_release_side_left", dd_cdebsa_a1);
        Long dd_cdebsb_a1 = getValue("port0x120", "DD_CDEBSB_A1");
        data.put("door_release_side_right", dd_cdebsb_a1);
        Long dd_cddbs_a1 = getValue("port0x120", "DD_CDDBS_A1");
        data.put("detrainment_door_bypass", dd_cddbs_a1);
        Long dd_cbpDerailDet_a1 = getValue("port0x120", "DD_CBPDerailDet_A1");
        data.put("derailment_detection", dd_cbpDerailDet_a1);
        Long dd_crgsbps_a1 = getValue("port0x120", "DD_CRGSBPS_A1");
        data.put("obstacle_detection", dd_crgsbps_a1);
        Long dd_cbpPrkBrk_a1 = getValue("port0x120", "DD_CBPPrkBrk_A1");
        data.put("mr_low_pressure", dd_cbpPrkBrk_a1);
        return data;
    }


    private static Map createCab2() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cCab2Active = getValue("port0x123", "DD_CCab2Active");
        String cab2 = getStatus(dd_cCab2Active);
        data.put("cab2", cab2);

        Long dd_cbpBrk_a2 = getValue("port0x120", "DD_CBPBrk_A2");
        data.put("brake", dd_cbpBrk_a2);
        Long dd_ccab2ByPassed = getValue("port0x120", "DD_CCAB2ByPassed");
        data.put("key", dd_ccab2ByPassed);
        //data.put("atc",atc);
        Long dd_cdirbps_a2 = getValue("port0x120","DD_CDIRBPS_A2");
        data.put("door_interlock",dd_cdirbps_a2);
        Long dd_cdebsa_a2 = getValue("port0x120","DD_CDEBSA_A2");
        data.put("door_release_side_left",dd_cdebsa_a2);
        Long dd_cdebsb_a2 = getValue("port0x120","DD_CDEBSB_A2");
        data.put("door_release_side_right",dd_cdebsb_a2);
        Long dd_cddbs_a2 = getValue("port0x120","DD_CDDBS_A2");
        data.put("detrainment_door_bypass",dd_cddbs_a2);
        Long dd_cbpDerailDet_a2 = getValue("port0x120","DD_CBPDerailDet_A2");
        data.put("derailment_detection",dd_cbpDerailDet_a2);
        Long dd_crgsbps_a2 = getValue("port0x120","DD_CRGSBPS_A2");
        data.put("obstacle_detection",dd_crgsbps_a2);
        Long dd_cbpPrkBrk_a2 = getValue("port0x120","DD_CBPPrkBrk_A2");
        data.put("mr_low_pressure",dd_cbpPrkBrk_a2);

        return data;
    }


    private static String getStatus(Long dd) {
        String c = "";
        if (dd == 1) {
            c = "true";
        } else if (dd == 0) {
            c = "false";
        }
        return c;
    }

}
