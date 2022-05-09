package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class HVACDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map freshAirDamperStatus = createFreshAirDamperStatus();
        data.put("freshAirDamperStatus", freshAirDamperStatus);
        Map returnAirDamperStatus = createReturnAirDamperStatus();
        data.put("returnAirDamperStatus", returnAirDamperStatus);
        Map hvac = createHVAC();
        data.put("hvac", hvac);
        Map carCurrentTemperature = createCarCurrentTemperature();
        data.put("carCurrentTemperature", carCurrentTemperature);
        //Map carTargetTemperature = createCarTargetTemperature();
        Map carTargetTemperature = carCurrentTemperature;
        data.put("carTargetTemperature", carTargetTemperature);
        Map hvacModes = createHVACModes();
        data.put("hvacModes", hvacModes);
        Map ventilationSubModes = createVentilationSubModes();
        data.put("ventilationSubModes", ventilationSubModes);
        return data;
    }

    /**
     * Fresh Air Damper Status
     *
     * @param
     * @return
     */

    private static Map createFreshAirDamperStatus() {
        Map data = new HashMap();

        Long dd_cClmDamper100Open_a1 = getValue("port0x128", "DD_CClmDamper100Open_A1");
        Long dd_cClmDamperClosedHVAC_a1 = getValue("port0x128", "DD_CClmDamperClosedHVAC_A1");
        Long dd_cClmDamperFault_a1 = getValue("port0x126", "DD_CClmDamperFault_A1");
        Long dd_cClmDamper75Open_a1 = getValue("port0x134", "DD_CClmDamper75Open_A1");
        Long dd_cClmDamper50Open_a1 = getValue("port0x134", "DD_CClmDamper50Open_A1");
        Long dd_cClmDamper25Open_a1 = getValue("port0x134", "DD_CClmDamper25Open_A1");
        Long dd_cClmDamperUnknownstatus_a1 = getValue("port0x122", "DD_CClmDamperUnknownstatus_A1");
        String freshAirDamper_a1 = getFreshAirDamperStatus(dd_cClmDamper100Open_a1, dd_cClmDamperClosedHVAC_a1, dd_cClmDamperFault_a1, dd_cClmDamper75Open_a1, dd_cClmDamper50Open_a1, dd_cClmDamper25Open_a1, dd_cClmDamperUnknownstatus_a1);
        data.put("freshAirDamper_a1", freshAirDamper_a1);


        Long dd_cClmDamper100Open_a2 = getValue("port0x128", "DD_CClmDamper100Open_A2");
        Long dd_cClmDamperClosedHVAC_a2 = getValue("port0x128", "DD_CClmDamperClosedHVAC_A2");
        Long dd_cClmDamperFault_a2 = getValue("port0x126", "DD_CClmDamperFault_A2");
        Long dd_cClmDamper75Open_a2 = getValue("port0x134", "DD_CClmDamper75Open_A2");
        Long dd_cClmDamper50Open_a2 = getValue("port0x134", "DD_CClmDamper50Open_A2");
        Long dd_cClmDamper25Open_a2 = getValue("port0x134", "DD_CClmDamper25Open_A2");
        Long dd_cClmDamperUnknownstatus_a2 = getValue("port0x122", "DD_CClmDamperUnknownstatus_A2");


        String freshAirDamper_a2 = getFreshAirDamperStatus(dd_cClmDamper100Open_a2, dd_cClmDamperClosedHVAC_a2, dd_cClmDamperFault_a2, dd_cClmDamper75Open_a2, dd_cClmDamper50Open_a2, dd_cClmDamper25Open_a2, dd_cClmDamperUnknownstatus_a2);
        data.put("freshAirDamper_a2", freshAirDamper_a2);


        Long dd_cClmDamper100Open_b1 = getValue("port0x128", "DD_CClmDamper100Open_B1");
        Long dd_cClmDamperClosedHVAC_b1 = getValue("port0x128", "DD_CClmDamperClosedHVAC_B1");
        Long dd_cClmDamperFault_b1 = getValue("port0x126", "DD_CClmDamperFault_B1");
        Long dd_cClmDamper75Open_b1 = getValue("port0x134", "DD_CClmDamper75Open_B1");
        Long dd_cClmDamper50Open_b1 = getValue("port0x134", "DD_CClmDamper50Open_B1");
        Long dd_cClmDamper25Open_b1 = getValue("port0x134", "DD_CClmDamper25Open_B1");
        Long dd_cClmDamperUnknownstatus_b1 = getValue("port0x122", "DD_CClmDamperUnknownstatus_B1");


        String freshAirDamper_b1 = getFreshAirDamperStatus(dd_cClmDamper100Open_b1, dd_cClmDamperClosedHVAC_b1, dd_cClmDamperFault_b1, dd_cClmDamper75Open_b1, dd_cClmDamper50Open_b1, dd_cClmDamper25Open_b1, dd_cClmDamperUnknownstatus_b1);
        data.put("freshAirDamper_b1", freshAirDamper_b1);


        Long dd_cClmDamper100Open_b2 = getValue("port0x128", "DD_CClmDamper100Open_B2");
        Long dd_cClmDamperClosedHVAC_b2 = getValue("port0x128", "DD_CClmDamperClosedHVAC_B2");
        Long dd_cClmDamperFault_b2 = getValue("port0x126", "DD_CClmDamperFault_B2");
        Long dd_cClmDamper75Open_b2 = getValue("port0x134", "DD_CClmDamper75Open_B2");
        Long dd_cClmDamper50Open_b2 = getValue("port0x134", "DD_CClmDamper50Open_B2");
        Long dd_cClmDamper25Open_b2 = getValue("port0x134", "DD_CClmDamper25Open_B2");
        Long dd_cClmDamperUnknownstatus_b2 = getValue("port0x122", "DD_CClmDamperUnknownstatus_B2");


        String freshAirDamper_b2 = getFreshAirDamperStatus(dd_cClmDamper100Open_b2, dd_cClmDamperClosedHVAC_b2, dd_cClmDamperFault_b2, dd_cClmDamper75Open_b2, dd_cClmDamper50Open_b2, dd_cClmDamper25Open_b2, dd_cClmDamperUnknownstatus_b2);
        data.put("freshAirDamper_b2", freshAirDamper_b2);


        Long dd_cClmDamper100Open_c1 = getValue("port0x128", "DD_CClmDamper100Open_C1");
        Long dd_cClmDamperClosedHVAC_c1 = getValue("port0x128", "DD_CClmDamperClosedHVAC_C1");
        Long dd_cClmDamperFault_c1 = getValue("port0x126", "DD_CClmDamperFault_C1");
        Long dd_cClmDamper75Open_c1 = getValue("port0x134", "DD_CClmDamper75Open_C1");
        Long dd_cClmDamper50Open_c1 = getValue("port0x134", "DD_CClmDamper50Open_C1");
        Long dd_cClmDamper25Open_c1 = getValue("port0x134", "DD_CClmDamper25Open_C1");
        Long dd_cClmDamperUnknownstatus_c1 = getValue("port0x122", "DD_CClmDamperUnknownstatus_C1");

        String freshAirDamper_c1 = getFreshAirDamperStatus(dd_cClmDamper100Open_c1, dd_cClmDamperClosedHVAC_c1, dd_cClmDamperFault_c1, dd_cClmDamper75Open_c1, dd_cClmDamper50Open_c1, dd_cClmDamper25Open_c1, dd_cClmDamperUnknownstatus_c1);
        data.put("freshAirDamper_c1", freshAirDamper_c1);


        Long dd_cClmDamper100Open_c2 = getValue("port0x128", "DD_CClmDamper100Open_C2");
        Long dd_cClmDamperClosedHVAC_c2 = getValue("port0x128", "DD_CClmDamperClosedHVAC_C2");
        Long dd_cClmDamperFault_c2 = getValue("port0x126", "DD_CClmDamperFault_C2");
        Long dd_cClmDamper75Open_c2 = getValue("port0x134", "DD_CClmDamper75Open_C2");
        Long dd_cClmDamper50Open_c2 = getValue("port0x134", "DD_CClmDamper50Open_C2");
        Long dd_cClmDamper25Open_c2 = getValue("port0x134", "DD_CClmDamper25Open_C2");
        Long dd_cClmDamperUnknownstatus_c2 = getValue("port0x122", "DD_CClmDamperUnknownstatus_C2");


        String freshAirDamper_c2 = getFreshAirDamperStatus(dd_cClmDamper100Open_c2, dd_cClmDamperClosedHVAC_c2, dd_cClmDamperFault_c2, dd_cClmDamper75Open_c2, dd_cClmDamper50Open_c2, dd_cClmDamper25Open_c2, dd_cClmDamperUnknownstatus_c2);
        data.put("freshAirDamper_c2", freshAirDamper_c2);

        return data;
    }

    private static String getFreshAirDamperStatus(Long dd_cClmDamper100Open_, Long dd_cClmDamperClosedHVAC_, Long dd_cClmDamperFault_, Long dd_cClmDamper75Open_, Long dd_cClmDamper50Open_, Long dd_cClmDamper25Open_, Long dd_cClmDamperUnknownstatus_) {
        String freshAirDamper_ = "";
        if (dd_cClmDamper100Open_ == 1 && dd_cClmDamperClosedHVAC_ == 0 && dd_cClmDamperFault_ == 0) {
            freshAirDamper_ = "open";
        } else if (dd_cClmDamper100Open_ == 0 &&
                dd_cClmDamperClosedHVAC_ == 0 &&
                dd_cClmDamperFault_ == 0 && dd_cClmDamper75Open_ == 0 && dd_cClmDamper50Open_ == 0 && dd_cClmDamper25Open_ == 1) {
            freshAirDamper_ = "25%open";
        } else if (dd_cClmDamper100Open_ == 0 &&
                dd_cClmDamperClosedHVAC_ == 0 &&
                dd_cClmDamperFault_ == 0 && dd_cClmDamper75Open_ == 0 && dd_cClmDamper50Open_ == 1 && dd_cClmDamper25Open_ == 0) {
            freshAirDamper_ = "50%open";
        } else if (dd_cClmDamper100Open_ == 0 &&
                dd_cClmDamperClosedHVAC_ == 0 &&
                dd_cClmDamperFault_ == 0 && dd_cClmDamper75Open_ == 1 && dd_cClmDamper50Open_ == 0 && dd_cClmDamper25Open_ == 0) {
            freshAirDamper_ = "75%open";
        } else if (dd_cClmDamper100Open_ == 0 &&
                dd_cClmDamperClosedHVAC_ == 1 &&
                dd_cClmDamperFault_ == 0 &&
                dd_cClmDamper75Open_ == 0 &&
                dd_cClmDamper50Open_ == 0 &&
                dd_cClmDamper25Open_ == 0) {
            freshAirDamper_ = "closed";
        } else if (dd_cClmDamperUnknownstatus_ == 1) {
            freshAirDamper_ = "unknown";
        } else if (dd_cClmDamperFault_ == 1) {
            freshAirDamper_ = "faulty";
        }
        return freshAirDamper_;
    }


    /**
     * Return Air Damper Status
     *
     * @param
     * @return
     */
    private static Map createReturnAirDamperStatus() {
        Map data = new HashMap();


        Long dd_cClmRetrunDamperFault_a1 = getValue("port0x126", "DD_CClmRetrunDamperFault_A1");
        Long dd_cClmReturnDamperClosedHVAC_a1 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_A1");
        Long dd_cClmReturnDamperOpenHVAC_a1 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_A1");
        Long dd_cClmReturnDamperUnknownstatus_a1 = getValue("port0x122", "DD_CClmReturnDamperUnknownstatus_A1");

        String returnAirDamperStatus_a1 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_a1, dd_cClmReturnDamperClosedHVAC_a1, dd_cClmReturnDamperOpenHVAC_a1, dd_cClmReturnDamperUnknownstatus_a1);
        data.put("returnAirDamperStatus_a1", returnAirDamperStatus_a1);


        Long dd_cClmRetrunDamperFault_a2 = getValue("port0x126", "DD_CClmRetrunDamperFault_A2");
        Long dd_cClmReturnDamperClosedHVAC_a2 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_A2");
        Long dd_cClmReturnDamperOpenHVAC_a2 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_A2");
        Long dd_cClmReturnDamperUnknownstatus_a2 = getValue("port0x122", "DD_CClmReturnDamperUnknownstatus_A2");
        String returnAirDamperStatus_a2 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_a2, dd_cClmReturnDamperClosedHVAC_a2, dd_cClmReturnDamperOpenHVAC_a2, dd_cClmReturnDamperUnknownstatus_a2);
        data.put("returnAirDamperStatus_a2", returnAirDamperStatus_a2);


        Long dd_cClmRetrunDamperFault_b1 = getValue("port0x126", "DD_CClmRetrunDamperFault_B1");
        Long dd_cClmReturnDamperClosedHVAC_b1 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_B1");
        Long dd_cClmReturnDamperOpenHVAC_b1 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_B1");
        Long dd_cClmReturnDamperUnknownstatus_b1 = getValue("port0x123", "DD_CClmReturnDamperUnknownstatus_B1");
        String returnAirDamperStatus_b1 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_b1, dd_cClmReturnDamperClosedHVAC_b1, dd_cClmReturnDamperOpenHVAC_b1, dd_cClmReturnDamperUnknownstatus_b1);
        data.put("returnAirDamperStatus_b1", returnAirDamperStatus_b1);


        Long dd_cClmRetrunDamperFault_b2 = getValue("port0x126", "DD_CClmRetrunDamperFault_B2");
        Long dd_cClmReturnDamperClosedHVAC_b2 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_B2");
        Long dd_cClmReturnDamperOpenHVAC_b2 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_B2");
        Long dd_cClmReturnDamperUnknownstatus_b2 = getValue("port0x123", "DD_CClmReturnDamperUnknownstatus_B2");
        String returnAirDamperStatus_b2 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_b2, dd_cClmReturnDamperClosedHVAC_b2, dd_cClmReturnDamperOpenHVAC_b2, dd_cClmReturnDamperUnknownstatus_b2);
        data.put("returnAirDamperStatus_b2", returnAirDamperStatus_b2);


        Long dd_cClmRetrunDamperFault_c1 = getValue("port0x126", "DD_CClmRetrunDamperFault_C1");
        Long dd_cClmReturnDamperClosedHVAC_c1 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_C1");
        Long dd_cClmReturnDamperOpenHVAC_c1 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_C1");
        Long dd_cClmReturnDamperUnknownstatus_c1 = getValue("port0x123", "DD_CClmReturnDamperUnknownstatus_C1");
        String returnAirDamperStatus_c1 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_c1, dd_cClmReturnDamperClosedHVAC_c1, dd_cClmReturnDamperOpenHVAC_c1, dd_cClmReturnDamperUnknownstatus_c1);
        data.put("returnAirDamperStatus_c1", returnAirDamperStatus_c1);

        Long dd_cClmRetrunDamperFault_c2 = getValue("port0x126", "DD_CClmRetrunDamperFault_C2");
        Long dd_cClmReturnDamperClosedHVAC_c2 = getValue("port0x129", "DD_CClmReturnDamperClosedHVAC_C2");
        Long dd_cClmReturnDamperOpenHVAC_c2 = getValue("port0x129", "DD_CClmReturnDamperOpenHVAC_C2");
        Long dd_cClmReturnDamperUnknownstatus_c2 = getValue("port0x123", "DD_CClmReturnDamperUnknownstatus_C2");
        String returnAirDamperStatus_c2 = getReturnAirDamperStatus(dd_cClmRetrunDamperFault_c2, dd_cClmReturnDamperClosedHVAC_c2, dd_cClmReturnDamperOpenHVAC_c2, dd_cClmReturnDamperUnknownstatus_c2);
        data.put("returnAirDamperStatus_c2", returnAirDamperStatus_c2);
        return data;
    }

    private static String getReturnAirDamperStatus(Long dd_cClmRetrunDamperFault, Long dd_cClmReturnDamperClosedHVAC, Long dd_cClmReturnDamperOpenHVAC, Long dd_cClmReturnDamperUnknownstatus_a1) {
        String returnAirDamperStatus_a1 = "";
        if (dd_cClmReturnDamperOpenHVAC == 1 && dd_cClmReturnDamperClosedHVAC == 0 && dd_cClmRetrunDamperFault == 0) {
            returnAirDamperStatus_a1 = "open";
        } else if (dd_cClmReturnDamperOpenHVAC == 0 && dd_cClmReturnDamperClosedHVAC == 1 && dd_cClmRetrunDamperFault == 0) {
            returnAirDamperStatus_a1 = "closed";
        } else if (dd_cClmRetrunDamperFault == 1) {
            returnAirDamperStatus_a1 = "faulty";
        } else if (dd_cClmReturnDamperUnknownstatus_a1 == 1) {
            returnAirDamperStatus_a1 = "unknown";
        }
        return returnAirDamperStatus_a1;
    }

    /**
     * HVAC Status
     *
     * @param
     * @return
     */
    private static Map createHVAC() {
        Map data = new HashMap();


        Long dd_cClmFaultModHVAC1_a1 = getValue("port0x129", "DD_CClmFaultModHVAC1_A1");
        Long dd_cClmFaultModHVAC2_a1 = getValue("port0x129", "DD_CClmFaultModHVAC2_A1");
        Long dd_cClmStopModHVAC_a1 = getValue("port0x129", "DD_CClmStopModHVAC_A1");
        Long dd_cClmVentModHVAC_a1 = getValue("port0x128", "DD_CClmVentModHVAC_A1");
        Long dd_cClmHeatModHVAC_a1 = getValue("port0x128", "DD_CClmHeatModHVAC_A1");
        Long dd_cClmCoolModHVAC_a1 = getValue("port0x128", "DD_CClmCoolModHVAC_A1");
        String HVACA1_1 = getHvac(dd_cClmFaultModHVAC1_a1, dd_cClmStopModHVAC_a1, dd_cClmVentModHVAC_a1, dd_cClmHeatModHVAC_a1, dd_cClmCoolModHVAC_a1);
        String HVACA1_2 = getHvac(dd_cClmFaultModHVAC2_a1, dd_cClmStopModHVAC_a1, dd_cClmVentModHVAC_a1, dd_cClmHeatModHVAC_a1, dd_cClmCoolModHVAC_a1);

        data.put("HVACA1_1", HVACA1_1);
        data.put("HVACA1_2", HVACA1_2);


        Long dd_cClmFaultModHVAC1_a2 = getValue("port0x129", "DD_CClmFaultModHVAC1_A2");
        Long dd_cClmFaultModHVAC2_a2 = getValue("port0x129", "DD_CClmFaultModHVAC2_A2");
        Long dd_cClmStopModHVAC_a2 = getValue("port0x129", "DD_CClmStopModHVAC_A2");
        Long dd_cClmVentModHVAC_a2 = getValue("port0x128", "DD_CClmVentModHVAC_A2");
        Long dd_cClmHeatModHVAC_a2 = getValue("port0x128", "DD_CClmHeatModHVAC_A2");
        Long dd_cClmCoolModHVAC_a2 = getValue("port0x128", "DD_CClmCoolModHVAC_A2");
        String HVACA2_1 = getHvac(dd_cClmFaultModHVAC1_a2, dd_cClmStopModHVAC_a2, dd_cClmVentModHVAC_a2, dd_cClmHeatModHVAC_a2, dd_cClmCoolModHVAC_a2);
        String HVACA2_2 = getHvac(dd_cClmFaultModHVAC2_a2, dd_cClmStopModHVAC_a2, dd_cClmVentModHVAC_a2, dd_cClmHeatModHVAC_a2, dd_cClmCoolModHVAC_a2);

        data.put("HVACA2_1", HVACA2_1);
        data.put("HVACA2_2", HVACA2_2);


        Long dd_cClmFaultModHVAC1_b1 = getValue("port0x129", "DD_CClmFaultModHVAC1_B1");
        Long dd_cClmFaultModHVAC2_b1 = getValue("port0x129", "DD_CClmFaultModHVAC2_B1");
        Long dd_cClmStopModHVAC_b1 = getValue("port0x129", "DD_CClmStopModHVAC_B1");
        Long dd_cClmVentModHVAC_b1 = getValue("port0x128", "DD_CClmVentModHVAC_B1");
        Long dd_cClmHeatModHVAC_b1 = getValue("port0x128", "DD_CClmHeatModHVAC_B1");
        Long dd_cClmCoolModHVAC_b1 = getValue("port0x128", "DD_CClmCoolModHVAC_B1");
        String HVACb1_1 = getHvac(dd_cClmFaultModHVAC1_b1, dd_cClmStopModHVAC_b1, dd_cClmVentModHVAC_b1, dd_cClmHeatModHVAC_b1, dd_cClmCoolModHVAC_b1);
        String HVACb1_2 = getHvac(dd_cClmFaultModHVAC2_b1, dd_cClmStopModHVAC_b1, dd_cClmVentModHVAC_b1, dd_cClmHeatModHVAC_b1, dd_cClmCoolModHVAC_b1);

        data.put("HVACb1_1", HVACb1_1);
        data.put("HVACb1_2", HVACb1_2);

        Long dd_cClmFaultModHVAC1_b2 = getValue("port0x129", "DD_CClmFaultModHVAC1_B2");
        Long dd_cClmFaultModHVAC2_b2 = getValue("port0x129", "DD_CClmFaultModHVAC2_B2");
        Long dd_cClmStopModHVAC_b2 = getValue("port0x129", "DD_CClmStopModHVAC_B2");
        Long dd_cClmVentModHVAC_b2 = getValue("port0x128", "DD_CClmVentModHVAC_B2");
        Long dd_cClmHeatModHVAC_b2 = getValue("port0x128", "DD_CClmHeatModHVAC_B2");
        Long dd_cClmCoolModHVAC_b2 = getValue("port0x128", "DD_CClmCoolModHVAC_B2");
        String HVACb2_1 = getHvac(dd_cClmFaultModHVAC1_b2, dd_cClmStopModHVAC_b2, dd_cClmVentModHVAC_b2, dd_cClmHeatModHVAC_b2, dd_cClmCoolModHVAC_b2);
        String HVACb2_2 = getHvac(dd_cClmFaultModHVAC2_b2, dd_cClmStopModHVAC_b2, dd_cClmVentModHVAC_b2, dd_cClmHeatModHVAC_b2, dd_cClmCoolModHVAC_b2);

        data.put("HVACb2_1", HVACb2_1);
        data.put("HVACb2_2", HVACb2_2);

        Long dd_cClmFaultModHVAC1_c1 = getValue("port0x129", "DD_CClmFaultModHVAC1_C1");
        Long dd_cClmFaultModHVAC2_c1 = getValue("port0x129", "DD_CClmFaultModHVAC2_C1");
        Long dd_cClmStopModHVAC_c1 = getValue("port0x129", "DD_CClmStopModHVAC_C1");
        Long dd_cClmVentModHVAC_c1 = getValue("port0x128", "DD_CClmVentModHVAC_C1");
        Long dd_cClmHeatModHVAC_c1 = getValue("port0x128", "DD_CClmHeatModHVAC_C1");
        Long dd_cClmCoolModHVAC_c1 = getValue("port0x128", "DD_CClmCoolModHVAC_C1");
        String HVACC1_1 = getHvac(dd_cClmFaultModHVAC1_c1, dd_cClmStopModHVAC_c1, dd_cClmVentModHVAC_c1, dd_cClmHeatModHVAC_c1, dd_cClmCoolModHVAC_c1);
        String HVACC1_2 = getHvac(dd_cClmFaultModHVAC2_c1, dd_cClmStopModHVAC_c1, dd_cClmVentModHVAC_c1, dd_cClmHeatModHVAC_c1, dd_cClmCoolModHVAC_c1);

        data.put("HVACC1_1", HVACC1_1);
        data.put("HVACC1_2", HVACC1_2);


        Long dd_cClmFaultModHVAC1_c2 = getValue("port0x129", "DD_CClmFaultModHVAC1_C2");
        Long dd_cClmFaultModHVAC2_c2 = getValue("port0x129", "DD_CClmFaultModHVAC2_C2");
        Long dd_cClmStopModHVAC_c2 = getValue("port0x129", "DD_CClmStopModHVAC_C2");
        Long dd_cClmVentModHVAC_c2 = getValue("port0x128", "DD_CClmVentModHVAC_C2");
        Long dd_cClmHeatModHVAC_c2 = getValue("port0x128", "DD_CClmHeatModHVAC_C2");
        Long dd_cClmCoolModHVAC_c2 = getValue("port0x128", "DD_CClmCoolModHVAC_C2");
        String HVACC2_1 = getHvac(dd_cClmFaultModHVAC1_c2, dd_cClmStopModHVAC_c2, dd_cClmVentModHVAC_c2, dd_cClmHeatModHVAC_c2, dd_cClmCoolModHVAC_c2);
        String HVACC2_2 = getHvac(dd_cClmFaultModHVAC2_c2, dd_cClmStopModHVAC_c2, dd_cClmVentModHVAC_c2, dd_cClmHeatModHVAC_c2, dd_cClmCoolModHVAC_c2);

        data.put("HVACC2_1", HVACC2_1);
        data.put("HVACC2_2", HVACC2_2);
        return data;
    }

    private static String getHvac(Long dd_cClmFaultModHVAC1_, Long dd_cClmStopModHVAC_, Long dd_cClmVentModHVAC_, Long dd_cClmHeatModHVAC_, Long dd_cClmCoolModHVAC_) {
        String HVAC = "";
        if (dd_cClmFaultModHVAC1_ == 0 &&
                dd_cClmStopModHVAC_ == 0 &&
                dd_cClmVentModHVAC_ == 1 && dd_cClmHeatModHVAC_ == 0 && dd_cClmCoolModHVAC_ == 0) {
            HVAC = "ventilation";
        } else if (dd_cClmFaultModHVAC1_ == 0 &&
                dd_cClmStopModHVAC_ == 0 &&
                dd_cClmVentModHVAC_ == 1 && dd_cClmHeatModHVAC_ == 0 && dd_cClmCoolModHVAC_ == 0) {
            HVAC = "heating";
        } else if (dd_cClmFaultModHVAC1_ == 0 &&
                dd_cClmStopModHVAC_ == 0 &&
                dd_cClmVentModHVAC_ == 1 && dd_cClmHeatModHVAC_ == 0 && dd_cClmCoolModHVAC_ == 0) {
            HVAC = "cooling";
        } else if (dd_cClmFaultModHVAC1_ == 0 &&
                dd_cClmStopModHVAC_ == 1) {
            HVAC = "stopped";
        } else if (dd_cClmFaultModHVAC1_ == 1) {
            HVAC = "faulty";
        } else {
            HVAC = "unknown";
        }
        return HVAC;
    }

    /**
     * Car Current Temperature
     *
     * @param
     * @return
     */
    private static Map createCarCurrentTemperature() {
        Map data = new HashMap();






        Long dd_cTrainSalTemp_a1 = getValue("port0x126", "DD_CTrainSalTemp_A1");
        Long dd_cTrainSalTemp_a2 = getValue("port0x126", "DD_CTrainSalTemp_A2");
        Long dd_cTrainSalTemp_b1 = getValue("port0x126", "DD_CTrainSalTemp_B1");
        Long dd_cTrainSalTemp_b2 = getValue("port0x126", "DD_CTrainSalTemp_B2");
        Long dd_cTrainSalTemp_c1 = getValue("port0x126", "DD_CTrainSalTemp_C1");
        Long dd_cTrainSalTemp_c2 = getValue("port0x126", "DD_CTrainSalTemp_C2");


        dd_cTrainSalTemp_a1 = getDd_cTrainSalTemp(dd_cTrainSalTemp_a1);
        data.put("a1", dd_cTrainSalTemp_a1);
        dd_cTrainSalTemp_a2 = getDd_cTrainSalTemp(dd_cTrainSalTemp_a2);
        data.put("a2", dd_cTrainSalTemp_a2);
        dd_cTrainSalTemp_b1 = getDd_cTrainSalTemp(dd_cTrainSalTemp_b1);
        data.put("b1", dd_cTrainSalTemp_b1);
        dd_cTrainSalTemp_b2 = getDd_cTrainSalTemp(dd_cTrainSalTemp_b2);
        data.put("b2", dd_cTrainSalTemp_b2);
        dd_cTrainSalTemp_c1 = getDd_cTrainSalTemp(dd_cTrainSalTemp_c1);
        data.put("c1", dd_cTrainSalTemp_c1);
        dd_cTrainSalTemp_c2 = getDd_cTrainSalTemp(dd_cTrainSalTemp_c2);
        data.put("c2", dd_cTrainSalTemp_c2);

        return data;
    }

    private static Long getDd_cTrainSalTemp(Long dd_cTrainSalTemp_a1) {
        if (dd_cTrainSalTemp_a1 == 127) {
            dd_cTrainSalTemp_a1 = -1L;
        }
        return dd_cTrainSalTemp_a1;
    }

    /**
     * Car Target Temperature  没有数据
     *
     * @param
     * @return
     */
    private static Map createCarTargetTemperature() {
        Map data = new HashMap();
        return data;
    }

    /**
     * HVAC Modes
     *
     * @param
     * @return
     */
    private static Map createHVACModes() {
        Map data = new HashMap();
        Long dd_cClmAutoModeAck = getValue("port0x133", "DD_CClmAutoModeAck");
        Long dd_cClmManuModeAck = getValue("port0x133", "DD_CClmManuModeAck");
        Long dd_cClmStopModeAck = getValue("port0x133", "DD_CClmStopModeAck");
        Long dd_cClmVentModeAck = getValue("port0x133", "DD_CClmVentModeAck");
        String AutoModeAck = "false";
        if (dd_cClmAutoModeAck == 1) {
            AutoModeAck = "true";
        }
        String ManuModeAck = "false";
        if (dd_cClmManuModeAck == 1) {
            ManuModeAck = "true";
        }
        String StopModeAck = "false";
        if (dd_cClmStopModeAck == 1) {
            StopModeAck = "true";
        }
        String VentModeAck = "false";
        if (dd_cClmVentModeAck == 1) {
            VentModeAck = "true";
        }

        data.put("AutoModeAck", AutoModeAck);
        data.put("ManuModeAck", ManuModeAck);
        data.put("StopModeAck", StopModeAck);
        data.put("VentModeAck", VentModeAck);
        return data;
    }

    /**
     * Ventilation Sub-Modes
     *
     * @param
     * @return
     */
    private static Map createVentilationSubModes() {
        Map data = new HashMap();
        Long dd_cClmVentBlowAutoAck = getValue("port0x120", "DD_CClmVentBlowAutoAck");
        Long dd_cClmVentBlowNormalAck = getValue("port0x120", "DD_CClmVentBlowNormalAck");
        Long dd_cClmVentBlowLowAck = getValue("port0x120", "DD_CClmVentBlowLowAck");
        Long dd_cClmVentBlowStrongAck = getValue("port0x120", "DD_CClmVentBlowStrongAck");
        String VentBlowAutoAck = "false";
        if (dd_cClmVentBlowAutoAck == 1) {
            VentBlowAutoAck = "true";
        }
        data.put("VentBlowAutoAck", VentBlowAutoAck);

        String VentBlowNormalAck = "false";
        if (dd_cClmVentBlowNormalAck == 1) {
            VentBlowNormalAck = "true";
        }
        data.put("VentBlowNormalAck", VentBlowNormalAck);

        String VentBlowLowAck = "false";
        if (dd_cClmVentBlowLowAck == 1) {
            VentBlowLowAck = "true";
        }
        data.put("VentBlowLowAck", VentBlowLowAck);

        String VentBlowStrongAck = "false";
        if (dd_cClmVentBlowStrongAck == 1) {
            VentBlowStrongAck = "true";
        }
        data.put("VentBlowStrongAck", VentBlowStrongAck);
        return data;
    }

}



