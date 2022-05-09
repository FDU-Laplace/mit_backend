package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class OperationDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map departAndArrival = createDepartAndArrival();
        data.put("departAndArrival", departAndArrival);
        Map slipAndSlideStatus = createSlipAndSlideStatus();
        data.put("slipAndSlideStatus", slipAndSlideStatus);
        Map parkingBrakeStatus = createParkingBrakeStatus();
        data.put("parkingBrakeStatus", parkingBrakeStatus);
        Map brakeStatus = createBrakeStatus();
        data.put("brakeStatus", brakeStatus);

        Map tractionStatus = createTractionStatus();
        data.put("tractionStatus", tractionStatus);

        Map compressorStatus = createCompressorStatus();
        data.put("compressorStatus", compressorStatus);

        Map lightingStatus = createLightingStatus();
        data.put("lightingStatus", lightingStatus);

        Map havc = createHavc();
        data.put("havc", havc);

        Map papis = createPAPIS();
        data.put("papis", papis);

        Map airSuspensionPressure = createAirSuspensionPressure();
        data.put("airSuspensionPressure", airSuspensionPressure);

        Map wiperStatus = createWiperStatus();
        data.put("wiperStatus", wiperStatus);

        return data;
    }

    /**
     * Depart and Arrival
     *
     * @param 
     * @return
     */
    public static Map createDepartAndArrival() {
        Map data = new HashMap();
        
        Long ipbDeparture = getValue("port0x801", "_IPBDeparture");
        Long iPbArrival = getValue("port0x801", "_IPbArrival");
        data.put("depart", ipbDeparture);
        data.put("arrival", iPbArrival);
        return data;
    }

    /**
     * Slip and Slide Status
     *
     * @param 
     * @return
     */
    private static Map createSlipAndSlideStatus() {
        Map data = new HashMap();

        Long dd_cSlipSlideDetect = getValue("port0x127", "DD_CSlipSlideDetect");
        String slip = "false";
        if (dd_cSlipSlideDetect == 1) {
            slip = "true";
        }
        data.put("slip", slip);
        return data;
    }

    /**
     * Parking Brake Status
     *
     * @param 
     * @return
     */
    private static Map createParkingBrakeStatus() {
        Map data = new HashMap();
        
        
        
        Long dd_cParkBrkRel_a1 = getValue("port0x128", "DD_CParkBrkRel_A1");
        Long dd_cParkBrkApp_a1 = getValue("port0x128", "DD_CParkBrkApp_A1");
        Long dd_cParkBrkIso_a1 = getValue("port0x134", "DD_CParkBrkIso_A1");
        String parkingBrakeA1 = getParkingBrakeStatus(dd_cParkBrkRel_a1, dd_cParkBrkApp_a1, dd_cParkBrkIso_a1);

        Long dd_cParkBrkRel_a2 = getValue("port0x128", "DD_CParkBrkRel_A2");
        Long dd_cParkBrkApp_a2 = getValue("port0x128", "DD_CParkBrkApp_A2");
        Long dd_cParkBrkIso_a2 = getValue("port0x134", "DD_CParkBrkIso_A2");
        String parkingBrakeA2 = getParkingBrakeStatus(dd_cParkBrkRel_a2, dd_cParkBrkApp_a2, dd_cParkBrkIso_a2);
        Long dd_cParkBrkRel_b1 = getValue("port0x128", "DD_CParkBrkRel_B1");
        Long dd_cParkBrkApp_b1 = getValue("port0x128", "DD_CParkBrkApp_B1");
        Long dd_cParkBrkIso_b1 = getValue("port0x134", "DD_CParkBrkIso_B1");
        String parkingBrakeB1 = getParkingBrakeStatus(dd_cParkBrkRel_b1, dd_cParkBrkApp_b1, dd_cParkBrkIso_b1);


        Long dd_cParkBrkRel_b2 = getValue("port0x128", "DD_CParkBrkRel_B2");
        Long dd_cParkBrkApp_b2 = getValue("port0x128", "DD_CParkBrkApp_B2");
        Long dd_cParkBrkIso_b2 = getValue("port0x134", "DD_CParkBrkIso_B2");
        String parkingBrakeB2 = getParkingBrakeStatus(dd_cParkBrkRel_b2, dd_cParkBrkApp_b2, dd_cParkBrkIso_b2);


        Long dd_cParkBrkRel_c1 = getValue("port0x128", "DD_CParkBrkRel_C1");
        Long dd_cParkBrkApp_c1 = getValue("port0x128", "DD_CParkBrkApp_C1");
        Long dd_cParkBrkIso_c1 = getValue("port0x134", "DD_CParkBrkIso_C1");
        String parkingBrakeC1 = getParkingBrakeStatus(dd_cParkBrkRel_c1, dd_cParkBrkApp_c1, dd_cParkBrkIso_c1);

        Long dd_cParkBrkRel_c2 = getValue("port0x128", "DD_CParkBrkRel_C2");
        Long dd_cParkBrkApp_c2 = getValue("port0x128", "DD_CParkBrkApp_C2");
        Long dd_cParkBrkIso_c2 = getValue("port0x134", "DD_CParkBrkIso_C2");
        String parkingBrakeC2 = getParkingBrakeStatus(dd_cParkBrkRel_c2, dd_cParkBrkApp_c2, dd_cParkBrkIso_c2);

        data.put("a1", parkingBrakeA1);
        data.put("a2", parkingBrakeA2);
        data.put("b1", parkingBrakeB1);
        data.put("b2", parkingBrakeB2);
        data.put("c1", parkingBrakeC1);
        data.put("c2", parkingBrakeC2);
        return data;
    }

    private static String getParkingBrakeStatus(Long dd_cParkBrkRel_, Long dd_cParkBrkApp_, Long dd_cParkBrkIso_) {
        String parkingBrakeA1 = "";
        if (dd_cParkBrkRel_ == 1 && dd_cParkBrkApp_ == 0 && dd_cParkBrkIso_ == 0) {
            parkingBrakeA1 = "release";
        } else if (dd_cParkBrkRel_ == 0 && dd_cParkBrkApp_ == 1 && dd_cParkBrkIso_ == 0) {
            parkingBrakeA1 = "applied";
        } else if (dd_cParkBrkIso_ == 1) {
            parkingBrakeA1 = "isolated";
        } else if ((dd_cParkBrkRel_ == 0 && dd_cParkBrkApp_ == 0) ||
                (dd_cParkBrkRel_ == 1 && dd_cParkBrkApp_ == 1) ||
                dd_cParkBrkIso_ == 0) {
            parkingBrakeA1 = "unknown";
        }
        return parkingBrakeA1;
    }

    /**
     * Brake Status
     *
     * @param 
     * @return
     */
    private static Map createBrakeStatus() {
        Map data = new HashMap();
        Long dd_cFricBrkPresBog1_a1 = getValue("port0x134", "DD_CFricBrkPresBog1_A1");
        Long dd_cFricBrkPresBog2_a1 = getValue("port0x134", "DD_CFricBrkPresBog2_A1");
        Long dd_cFricBrkPresBog1_a2 = getValue("port0x134", "DD_CFricBrkPresBog1_A2");
        Long dd_cFricBrkPresBog2_a2 = getValue("port0x134", "DD_CFricBrkPresBog2_A2");
        Long dd_cFricBrkPresBog1_b1 = getValue("port0x134", "DD_CFricBrkPresBog1_B1");
        Long dd_cFricBrkPresBog2_b1 = getValue("port0x134", "DD_CFricBrkPresBog2_B1");
        Long dd_cFricBrkPresBog1_b2 = getValue("port0x134", "DD_CFricBrkPresBog1_B2");
        Long dd_cFricBrkPresBog2_b2 = getValue("port0x134", "DD_CFricBrkPresBog2_B2");
        Long dd_cFricBrkPresBog1_c1 = getValue("port0x134", "DD_CFricBrkPresBog1_C1");
        Long dd_cFricBrkPresBog2_c1 = getValue("port0x134", "DD_CFricBrkPresBog2_C1");
        Long dd_cFricBrkPresBog1_c2 = getValue("port0x134", "DD_CFricBrkPresBog1_C2");
        Long dd_cFricBrkPresBog2_c2 = getValue("port0x134", "DD_CFricBrkPresBog2_C1");


        
        
        
        
        
        
        
        
        
        
        
        Long dd_cbceAutoTestInProgress_a1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A1");
        Long dd_cBrkIsolatedB1_a1 = getValue("port0x134", "DD_CBrkIsolatedB1_A1");
        Long dd_cBrkMajFaultB1_a1 = getValue("port0x126", "DD_CBrkMajFaultB1_A1");
        Long dd_cBrkMinFaultB1_a1 = getValue("port0x126", "DD_CBrkMinFaultB1_A1");
        Long dd_cBrkAppliedB1_a1 =  getValue("port0x126", "DD_CBrkAppliedB1_A1");
        Long dd_cBrkRelB1_a1 =      getValue("port0x127", "DD_CBrkRelB1_A1");
        Long dd_cBrkIsolatedB2_a1 = getValue("port0x134", "DD_CBrkIsolatedB2_A1");
        Long dd_cBrkMajFaultB2_a1 = getValue("port0x126", "DD_CBrkMajFaultB2_A1");
        Long dd_cBrkMinFaultB2_a1 = getValue("port0x126", "DD_CBrkMinFaultB2_A1");
        Long dd_cBrkAppliedB2_a1 =  getValue("port0x126", "DD_CBrkAppliedB2_A1");
        Long dd_cBrkRelB2_a1 =      getValue("port0x127", "DD_CBrkRelB2_A1");
        
        String a1_1 = getBrakeStatus(dd_cBrkIsolatedB1_a1, dd_cBrkMajFaultB1_a1, dd_cBrkMinFaultB1_a1, dd_cBrkAppliedB1_a1, dd_cbceAutoTestInProgress_a1, dd_cBrkRelB1_a1);
        String a1_2 = getBrakeStatus(dd_cBrkIsolatedB2_a1, dd_cBrkMajFaultB2_a1, dd_cBrkMinFaultB2_a1, dd_cBrkAppliedB2_a1, dd_cbceAutoTestInProgress_a1, dd_cBrkRelB2_a1);
        Map a1 = new HashMap();
        a1.put("a1_1", a1_1);
        a1.put("a1_1_brake_pressure",dd_cFricBrkPresBog1_a1);
        a1.put("a1_2_brake_pressure",dd_cFricBrkPresBog2_a1);
        a1.put("a1_2", a1_2);
        data.put("a1", a1);

        Long dd_cbceAutoTestInProgress_a2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A2");
        Long dd_cBrkIsolatedB1_a2 = getValue("port0x134", "DD_CBrkIsolatedB1_A2");
        Long dd_cBrkMajFaultB1_a2 = getValue("port0x126", "DD_CBrkMajFaultB1_A2");
        Long dd_cBrkMinFaultB1_a2 = getValue("port0x126", "DD_CBrkMinFaultB1_A2");
        Long dd_cBrkAppliedB1_a2 =  getValue("port0x126", "DD_CBrkAppliedB1_A2");
        Long dd_cBrkRelB1_a2 =      getValue("port0x127", "DD_CBrkRelB1_A2");
        Long dd_cBrkIsolatedB2_a2 = getValue("port0x134", "DD_CBrkIsolatedB2_A2");
        Long dd_cBrkMajFaultB2_a2 = getValue("port0x126", "DD_CBrkMajFaultB2_A2");
        Long dd_cBrkMinFaultB2_a2 = getValue("port0x126", "DD_CBrkMinFaultB2_A2");
        Long dd_cBrkAppliedB2_a2 =  getValue("port0x126", "DD_CBrkAppliedB2_A2");
        Long dd_cBrkRelB2_a2 =      getValue("port0x127", "DD_CBrkRelB2_A2");
        
      
        
        String a2_1 = getBrakeStatus(dd_cBrkIsolatedB1_a2, dd_cBrkMajFaultB1_a2, dd_cBrkMinFaultB1_a2, dd_cBrkAppliedB1_a2, dd_cbceAutoTestInProgress_a2, dd_cBrkRelB1_a2);
        String a2_2 = getBrakeStatus(dd_cBrkIsolatedB2_a2, dd_cBrkMajFaultB2_a2, dd_cBrkMinFaultB2_a2, dd_cBrkAppliedB2_a2, dd_cbceAutoTestInProgress_a2, dd_cBrkRelB2_a2);
        Map a2 = new HashMap();
        a2.put("a2_1", a2_1);
        a2.put("a2_2", a2_2);
        a2.put("a2_1_brake_pressure",dd_cFricBrkPresBog1_a2);
        a2.put("a2_2_brake_pressure",dd_cFricBrkPresBog2_a2);
        data.put("a2", a2);

        Long dd_cBrkIsolatedB1_b1 = getValue("port0x134", "DD_CBrkIsolatedB1_B1");
        Long dd_cBrkMajFaultB1_b1 = getValue("port0x126", "DD_CBrkMajFaultB1_B1");
        Long dd_cBrkMinFaultB1_b1 = getValue("port0x126", "DD_CBrkMinFaultB1_B1");
        Long dd_cBrkAppliedB1_b1 =  getValue("port0x126", "DD_CBrkAppliedB1_B1");
        Long dd_cBrkRelB1_b1 =      getValue("port0x127", "DD_CBrkRelB1_B1");
        Long dd_cBrkIsolatedB2_b1 = getValue("port0x134", "DD_CBrkIsolatedB2_B1");
        Long dd_cBrkMajFaultB2_b1 = getValue("port0x126", "DD_CBrkMajFaultB2_B1");
        Long dd_cBrkMinFaultB2_b1 = getValue("port0x126", "DD_CBrkMinFaultB2_B1");
        Long dd_cBrkAppliedB2_b1 =  getValue("port0x126", "DD_CBrkAppliedB2_B1");
        Long dd_cBrkRelB2_b1 =      getValue("port0x127", "DD_CBrkRelB2_B1");
        
        
        String b1_1 = getBrakeStatus2(dd_cBrkIsolatedB1_b1, dd_cBrkMajFaultB1_b1, dd_cBrkMinFaultB1_b1, dd_cBrkAppliedB1_b1, dd_cBrkRelB1_b1);
        String b1_2 = getBrakeStatus2(dd_cBrkIsolatedB2_b1, dd_cBrkMajFaultB2_b1, dd_cBrkMinFaultB2_b1, dd_cBrkAppliedB2_b1, dd_cBrkRelB2_b1);
        Map b1 = new HashMap();
        b1.put("b1_1", b1_1);
        b1.put("b1_2", b1_2);
        b1.put("b1_1_brake_pressure",dd_cFricBrkPresBog1_b1);
        b1.put("b1_2_brake_pressure",dd_cFricBrkPresBog2_b1);
        data.put("b1", b1);

        Long dd_cBrkIsolatedB1_b2 = getValue("port0x134", "DD_CBrkIsolatedB1_B2");
        Long dd_cBrkMajFaultB1_b2 = getValue("port0x126", "DD_CBrkMajFaultB1_B2");
        Long dd_cBrkMinFaultB1_b2 = getValue("port0x126", "DD_CBrkMinFaultB1_B2");
        Long dd_cBrkAppliedB1_b2 =  getValue("port0x126", "DD_CBrkAppliedB1_B2");
        Long dd_cBrkRelB1_b2 =      getValue("port0x127", "DD_CBrkRelB1_B2");
        Long dd_cBrkIsolatedB2_b2 = getValue("port0x134", "DD_CBrkIsolatedB2_B2");
        Long dd_cBrkMajFaultB2_b2 = getValue("port0x126", "DD_CBrkMajFaultB2_B2");
        Long dd_cBrkMinFaultB2_b2 = getValue("port0x126", "DD_CBrkMinFaultB2_B2");
        Long dd_cBrkAppliedB2_b2 =  getValue("port0x126", "DD_CBrkAppliedB2_B2");
        Long dd_cBrkRelB2_b2 =      getValue("port0x127", "DD_CBrkRelB2_B2");
       

        String b2_1 = getBrakeStatus2(dd_cBrkIsolatedB1_b2, dd_cBrkMajFaultB1_b2, dd_cBrkMinFaultB1_b2, dd_cBrkAppliedB1_b2, dd_cBrkRelB1_b2);
        String b2_2 = getBrakeStatus2(dd_cBrkIsolatedB2_b2, dd_cBrkMajFaultB2_b2, dd_cBrkMinFaultB2_b2, dd_cBrkAppliedB2_b2, dd_cBrkRelB2_b2);
        Map b2 = new HashMap();
        b2.put("b2_1", b2_1);
        b2.put("b2_2", b2_2);
        b2.put("b2_1_brake_pressure",dd_cFricBrkPresBog1_b2);
        b2.put("b2_2_brake_pressure",dd_cFricBrkPresBog2_b2);
        data.put("b2", b2);
        Long dd_cbceAutoTestInProgress_c1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C1");
        Long dd_cBrkIsolatedB1_c1 = getValue("port0x134", "DD_CBrkIsolatedB1_C1");
        Long dd_cBrkMajFaultB1_c1 = getValue("port0x126", "DD_CBrkMajFaultB1_C1");
        Long dd_cBrkMinFaultB1_c1 = getValue("port0x126", "DD_CBrkMinFaultB1_C1");
        Long dd_cBrkAppliedB1_c1 =  getValue("port0x126", "DD_CBrkAppliedB1_C1");
        Long dd_cBrkRelB1_c1 =      getValue("port0x127", "DD_CBrkRelB1_C1");
        Long dd_cBrkIsolatedB2_c1 = getValue("port0x134", "DD_CBrkIsolatedB2_C1");
        Long dd_cBrkMajFaultB2_c1 = getValue("port0x126", "DD_CBrkMajFaultB2_C1");
        Long dd_cBrkMinFaultB2_c1 = getValue("port0x126", "DD_CBrkMinFaultB2_C1");
        Long dd_cBrkAppliedB2_c1 =  getValue("port0x126", "DD_CBrkAppliedB2_C1");
        Long dd_cBrkRelB2_c1 =      getValue("port0x127", "DD_CBrkRelB2_C1");
        
        String c1_1 = getBrakeStatus(dd_cBrkIsolatedB1_c1, dd_cBrkMajFaultB1_c1, dd_cBrkMinFaultB1_c1, dd_cBrkAppliedB1_c1, dd_cbceAutoTestInProgress_c1, dd_cBrkRelB1_c1);
        String c1_2 = getBrakeStatus(dd_cBrkIsolatedB2_c1, dd_cBrkMajFaultB2_c1, dd_cBrkMinFaultB2_c1, dd_cBrkAppliedB2_c1, dd_cbceAutoTestInProgress_c1, dd_cBrkRelB2_c1);
        Map c1 = new HashMap();
        c1.put("c1_1", c1_1);
        c1.put("c1_2", c1_2);
        c1.put("c1_1_brake_pressure",dd_cFricBrkPresBog1_c1);
        c1.put("c1_2_brake_pressure",dd_cFricBrkPresBog2_c1);
        data.put("c1", c1);
        Long dd_cbceAutoTestInProgress_c2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C2");
        Long dd_cBrkIsolatedB1_c2 = getValue("port0x134", "DD_CBrkIsolatedB1_C2");
        Long dd_cBrkMajFaultB1_c2 = getValue("port0x126", "DD_CBrkMajFaultB1_C2");
        Long dd_cBrkMinFaultB1_c2 = getValue("port0x126", "DD_CBrkMinFaultB1_C2");
        Long dd_cBrkAppliedB1_c2 =  getValue("port0x126", "DD_CBrkAppliedB1_C2");
        Long dd_cBrkRelB1_c2 =      getValue("port0x127", "DD_CBrkRelB1_C2");
        Long dd_cBrkIsolatedB2_c2 = getValue("port0x134", "DD_CBrkIsolatedB2_C2");
        Long dd_cBrkMajFaultB2_c2 = getValue("port0x126", "DD_CBrkMajFaultB2_C2");
        Long dd_cBrkMinFaultB2_c2 = getValue("port0x126", "DD_CBrkMinFaultB2_C2");
        Long dd_cBrkAppliedB2_c2 =  getValue("port0x126", "DD_CBrkAppliedB2_C2");
        Long dd_cBrkRelB2_c2 =      getValue("port0x127", "DD_CBrkRelB2_C2");
      
        
        String c2_1 = getBrakeStatus(dd_cBrkIsolatedB1_c2, dd_cBrkMajFaultB1_c2, dd_cBrkMinFaultB1_c2, dd_cBrkAppliedB1_c2, dd_cbceAutoTestInProgress_c2, dd_cBrkRelB1_c2);
        String c2_2 = getBrakeStatus(dd_cBrkIsolatedB2_c2, dd_cBrkMajFaultB2_c2, dd_cBrkMinFaultB2_c2, dd_cBrkAppliedB2_c2, dd_cbceAutoTestInProgress_c2, dd_cBrkRelB2_c2);
        Map c2 = new HashMap();
        c2.put("c2_1", c2_1);
        c2.put("c2_2", c2_2);
        c2.put("c2_1_brake_pressure",dd_cFricBrkPresBog1_c2);
        c2.put("c2_2_brake_pressure",dd_cFricBrkPresBog2_c2);
        data.put("c2", c2);
        return data;
    }

    private static String getBrakeStatus2(Long dd_cBrkIsolated_, Long dd_cBrkMajFaultB1_, Long dd_cBrkMinFaultB1_, Long dd_cBrkAppliedB1_, Long dd_cBrkRelB1_) {
        String BrakeStatus = "";
        if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0) {
            BrakeStatus = "auto";
        } else if (dd_cBrkIsolated_ == 1) {
            BrakeStatus = "isolated";
        } else if (dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 1) {
            BrakeStatus = "minor";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cBrkAppliedB1_ == 1) {
            BrakeStatus = "applied";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 1) {
            BrakeStatus = "major";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cBrkAppliedB1_ == 0 && dd_cBrkRelB1_ == 1) {
            BrakeStatus = "released";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cBrkAppliedB1_ == 0 && dd_cBrkRelB1_ == 0) {
            BrakeStatus = "unknown";
        }
        return BrakeStatus;
    }

    private static String getBrakeStatus(Long dd_cBrkIsolated_, Long dd_cBrkMajFaultB1_, Long dd_cBrkMinFaultB1_, Long dd_cBrkAppliedB1_, Long dd_cbceAutoTestInProgress_, Long dd_cBrkRelB1_) {
        String BrakeStatus = "";
        if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cbceAutoTestInProgress_ == 1) {
            BrakeStatus = "auto";
        } else if (dd_cBrkIsolated_ == 1) {
            BrakeStatus = "isolated";
        } else if (dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 1 && dd_cbceAutoTestInProgress_ == 0) {
            BrakeStatus = "minor";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cbceAutoTestInProgress_ == 0 && dd_cBrkAppliedB1_ == 1) {
            BrakeStatus = "applied";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 1) {
            BrakeStatus = "major";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cbceAutoTestInProgress_ == 0 && dd_cBrkAppliedB1_ == 0 && dd_cBrkRelB1_ == 1) {
            BrakeStatus = "released";
        } else if (dd_cBrkIsolated_ == 0 && dd_cBrkMajFaultB1_ == 0 && dd_cBrkMinFaultB1_ == 0 && dd_cbceAutoTestInProgress_ == 0 && dd_cBrkAppliedB1_ == 0 && dd_cBrkRelB1_ == 0) {
            BrakeStatus = "unknown";
        }
        return BrakeStatus;
    }

    /**
     * Traction and Compressor Status
     *
     * @param 
     * @return
     */
    private static Map createTractionStatus() {
        Map data = new HashMap();

        
        
        
        
        
        Long dd_cpceIsolFlt_b1 =   getValue("port0x127", "DD_CPCEIsolFlt_B1");
        Long dd_cPropOK_b1 =       getValue("port0x127", "DD_CPropOK_B1");
        Long dd_cedInProgress_b1 = getValue("port0x127", "DD_CEDInProgress_B1");
        Long dd_cpceFault_b1 =     getValue("port0x126", "DD_CPCEFault_B1");
        Long dd_cpce1Oper =        getValue("port0x127", "DD_CPCE1Oper");
        String tractionStatusB1 = getTractionStatus(dd_cpceIsolFlt_b1, dd_cPropOK_b1, dd_cedInProgress_b1, dd_cpceFault_b1, dd_cpce1Oper);
        data.put("B1", tractionStatusB1);
        Long dd_cpceIsolFlt_b2 =   getValue("port0x127", "DD_CPCEIsolFlt_B2");
        Long dd_cPropOK_b2 =       getValue("port0x127", "DD_CPropOK_B2");
        Long dd_cedInProgress_b2 = getValue("port0x127", "DD_CEDInProgress_B2");
        Long dd_cpceFault_b2 =     getValue("port0x126", "DD_CPCEFault_B2");
        Long dd_cpce2Oper =        getValue("port0x127", "DD_CPCE2Oper");
       
        String tractionStatusB2 = getTractionStatus(dd_cpceIsolFlt_b2, dd_cPropOK_b2, dd_cedInProgress_b2, dd_cpceFault_b2, dd_cpce2Oper);
        data.put("B2", tractionStatusB2);

        Long dd_cpceIsolFlt_c1 =   getValue("port0x127", "DD_CPCEIsolFlt_C1");
        Long dd_cPropOK_c1 =       getValue("port0x127", "DD_CPropOK_C1");
        Long dd_cedInProgress_c1 = getValue("port0x127", "DD_CEDInProgress_C1");
        Long dd_cpceFault_c1 =     getValue("port0x126", "DD_CPCEFault_C1");
        Long dd_cpce3Oper =        getValue("port0x127", "DD_CPCE3Oper");
       
        String tractionStatusC1 = getTractionStatus(dd_cpceIsolFlt_c1, dd_cPropOK_c1, dd_cedInProgress_c1, dd_cpceFault_c1, dd_cpce3Oper);
        data.put("C1", tractionStatusC1);
        Long dd_cpceIsolFlt_c2 =   getValue("port0x127", "DD_CPCEIsolFlt_C2");
        Long dd_cPropOK_c2 =       getValue("port0x127", "DD_CPropOK_C2");
        Long dd_cedInProgress_c2 = getValue("port0x127", "DD_CEDInProgress_C2");
        Long dd_cpceFault_c2 =     getValue("port0x126", "DD_CPCEFault_C2");
        Long dd_cpce4Oper =        getValue("port0x127", "DD_CPCE4Oper");
        
        String tractionStatusC2 = getTractionStatus(dd_cpceIsolFlt_c2, dd_cPropOK_c2, dd_cedInProgress_c2, dd_cpceFault_c2, dd_cpce4Oper);
        data.put("C2", tractionStatusC2);
        return data;
    }

    private static String getTractionStatus(Long dd_cpceIsolFlt_, Long dd_cPropOK_, Long dd_cedInProgress_, Long dd_cpceFault_, Long dd_cpce1Oper) {
        String tractionStatus = "";
        if (dd_cpceIsolFlt_ == 1) {
            tractionStatus = "isolated";
        } else if (dd_cPropOK_ == 1 && dd_cedInProgress_ == 0 && dd_cpceFault_ == 0 && dd_cpceIsolFlt_ == 0) {
            tractionStatus = "propok";
        } else if (dd_cpceFault_ == 1 && dd_cpceIsolFlt_ == 0) {
            tractionStatus = "fault";
        } else if (dd_cedInProgress_ == 1 && dd_cpceFault_ == 0 && dd_cpceIsolFlt_ == 0) {
            tractionStatus = "inprogress";
        } else if (dd_cpce1Oper == 1 && dd_cPropOK_ == 0 && dd_cedInProgress_ == 0 && dd_cpceFault_ == 0 && dd_cpceIsolFlt_ == 0) {
            tractionStatus = "ok";
        } else if (dd_cpce1Oper == 0 && dd_cPropOK_ == 0 && dd_cedInProgress_ == 0 && dd_cpceFault_ == 0 && dd_cpceIsolFlt_ == 0) {
            tractionStatus = "unknown";
        }
        return tractionStatus;
    }

    /**
     * Compressor Status
     *
     * @param 
     * @return
     */
    private static Map createCompressorStatus() {
        Map data = new HashMap();
        
        Long dd_cAirCompOK_a1 = getValue("port0x127", "DD_CAirCompOK_A1");
        Long dd_cAirCompFault_a1 = getValue("port0x127", "DD_CAirCompFault_A1");
        Long dd_cAirCompNotRunning_a1 = getValue("port0x127", "DD_CAirCompNotRunning_A1");
        String compressorA1 = getCompressorStatus(dd_cAirCompOK_a1, dd_cAirCompFault_a1, dd_cAirCompNotRunning_a1);
        data.put("A1", compressorA1);

        Long dd_cAirCompOK_a2 = getValue("port0x127", "DD_CAirCompOK_A2");
        Long dd_cAirCompFault_a2 = getValue("port0x127", "DD_CAirCompFault_A2");
        Long dd_cAirCompNotRunning_a2 = getValue("port0x127", "DD_CAirCompNotRunning_A2");
        String compressorA2 = getCompressorStatus(dd_cAirCompOK_a2, dd_cAirCompFault_a2, dd_cAirCompNotRunning_a2);
        data.put("A2", compressorA2);
        return data;
    }

    private static String getCompressorStatus(Long dd_cAirCompOK_, Long dd_cAirCompFault_, Long dd_cAirCompNotRunning_) {
        String compressor = "";
        if (dd_cAirCompOK_ == 1 && dd_cAirCompFault_ == 0 && dd_cAirCompNotRunning_ == 0) {
            compressor = "running";
        } else if (dd_cAirCompFault_ == 0 && dd_cAirCompNotRunning_ == 1) {
            compressor = "idle";
        } else if (dd_cAirCompFault_ == 1) {
            compressor = "fault";
        } else if (dd_cAirCompOK_ == 0 && dd_cAirCompFault_ == 0 && dd_cAirCompNotRunning_ == 0) {
            compressor = "unknown";
        }
        return compressor;
    }

    /**
     * Lighting Status
     *
     * @return
     */
    private static Map createLightingStatus() {
        Map data = new HashMap();
        Long dd_cLightOFF = getValue("port0x132", "DD_CLightOFF");
        Long dd_cEmgLight = getValue("port0x132", "DD_CEmgLight");


        Long dd_cCabLightOK_a1 = getValue("port0x126", "DD_CCabLightOK_A1");
        Long dd_cCabLightFlt_a1 =getValue("port0x126", "DD_CCabLightFlt_A1");
        String LightingA1 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_a1, dd_cCabLightFlt_a1);
        data.put("A1", LightingA1);

        Long dd_cCabLightOK_a2 = getValue("port0x126", "DD_CCabLightOK_A2");
        Long dd_cCabLightFlt_a2 =getValue("port0x126", "DD_CCabLightFlt_A2");
        String LightingA2 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_a2, dd_cCabLightFlt_a2);
        data.put("A2", LightingA2);

        Long dd_cCabLightOK_b1 = getValue("port0x126", "DD_CCabLightOK_B1");
        Long dd_cCabLightFlt_b1 =getValue("port0x126", "DD_CCabLightFlt_B1");
        String LightingB1 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_b1, dd_cCabLightFlt_b1);
        data.put("B1", LightingB1);

        Long dd_cCabLightOK_b2 = getValue("port0x126", "DD_CCabLightOK_B2");
        Long dd_cCabLightFlt_b2 =getValue("port0x126", "DD_CCabLightFlt_B2");
        String LightingB2 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_b2, dd_cCabLightFlt_b2);
        data.put("B2", LightingB2);

        Long dd_cCabLightOK_c1 = getValue("port0x126", "DD_CCabLightOK_C1");
        Long dd_cCabLightFlt_c1 =getValue("port0x126", "DD_CCabLightFlt_C1");
        String LightingC1 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_c1, dd_cCabLightFlt_c1);
        data.put("C1", LightingC1);

        Long dd_cCabLightOK_c2 = getValue("port0x126", "DD_CCabLightOK_C2");
        Long dd_cCabLightFlt_c2 = getValue("port0x126", "DD_CCabLightFlt_C2");
        String LightingC2 = getLightingStatus(dd_cLightOFF, dd_cEmgLight, dd_cCabLightOK_c2, dd_cCabLightFlt_c2);
        data.put("C2", LightingC2);
        return data;
    }

    private static String getLightingStatus(Long dd_cLightOFF, Long dd_cEmgLight, Long dd_cCabLightOK_, Long dd_cCabLightFlt_) {
        String LightingA1 = "";
        if (dd_cLightOFF == 1 && dd_cEmgLight == 0 && dd_cCabLightOK_ == 0 && dd_cCabLightFlt_ == 0) {
            LightingA1 = "ok";
        } else if (dd_cEmgLight == 1 && dd_cCabLightFlt_ == 0) {
            LightingA1 = "emergency";
        } else if (dd_cLightOFF == 1 && dd_cEmgLight == 0 && dd_cCabLightFlt_ == 0) {
            LightingA1 = "OFF";
        } else if (dd_cCabLightFlt_ == 0) {
            LightingA1 = "faulty";
        } else if (dd_cLightOFF == 0 && dd_cEmgLight == 0 && dd_cCabLightOK_ == 0 && dd_cCabLightFlt_ == 0) {
            LightingA1 = "unknown";
        }
        return LightingA1;
    }


    /**
     * @param 
     * @return
     */
    private static Map createHavc() {
        Map data = new HashMap();
        Long dd_cvac1Oper = getValue("port0x127", "DD_CVAC1Oper");
        Long dd_cClmFaultModHVAC1_a1 = getValue("port0x129", "DD_CClmFaultModHVAC1_A1");
        Long dd_cClmFaultModHVAC2_a1 = getValue("port0x129", "DD_CClmFaultModHVAC2_A1");
        String havcA1_1 = getHavcStatus(dd_cvac1Oper, dd_cClmFaultModHVAC1_a1);
        String havcA1_2 = getHavcStatus(dd_cvac1Oper, dd_cClmFaultModHVAC2_a1);

        Map a1 = new HashMap();
        a1.put("a1_1", havcA1_1);
        a1.put("a1_2", havcA1_2);
        data.put("a1", a1);

        Long dd_cvac2Oper = getValue("port0x127", "DD_CVAC2Oper");
        Long dd_cClmFaultModHVAC1_a2 = getValue("port0x129", "DD_CClmFaultModHVAC1_A2");
        Long dd_cClmFaultModHVAC2_a2 = getValue("port0x129", "DD_CClmFaultModHVAC2_A2");
        String havcA2_1 = getHavcStatus(dd_cvac2Oper, dd_cClmFaultModHVAC1_a2);
        String havcA2_2 = getHavcStatus(dd_cvac2Oper, dd_cClmFaultModHVAC2_a2);

        Map a2 = new HashMap();
        a2.put("a2_1", havcA2_1);
        a2.put("a2_2", havcA2_2);
        data.put("a2", a2);

        Long dd_cvac3Oper = getValue("port0x127", "DD_CVAC3Oper");
        Long dd_cClmFaultModHVAC1_b1 = getValue("port0x129", "DD_CClmFaultModHVAC1_B1");
        Long dd_cClmFaultModHVAC2_b1 = getValue("port0x129", "DD_CClmFaultModHVAC2_B1");
        String havcB1_1 = getHavcStatus(dd_cvac3Oper, dd_cClmFaultModHVAC1_b1);
        String havcB1_2 = getHavcStatus(dd_cvac3Oper, dd_cClmFaultModHVAC2_b1);

        Map b1 = new HashMap();
        b1.put("b1_1", havcB1_1);
        b1.put("b1_2", havcB1_2);
        data.put("b1", b1);

        Long dd_cvac4Oper = getValue("port0x127", "DD_CVAC4Oper");
        Long dd_cClmFaultModHVAC1_b2 = getValue("port0x129", "DD_CClmFaultModHVAC1_B2");
        Long dd_cClmFaultModHVAC2_b2 = getValue("port0x129", "DD_CClmFaultModHVAC2_B2");
        String havcB2_1 = getHavcStatus(dd_cvac4Oper, dd_cClmFaultModHVAC1_b2);
        String havcB2_2 = getHavcStatus(dd_cvac4Oper, dd_cClmFaultModHVAC2_b2);

        Map b2 = new HashMap();
        b2.put("b2_1", havcB2_1);
        b2.put("b2_2", havcB2_2);
        data.put("b2", b2);
        Long dd_cvac5Oper = getValue("port0x128", "DD_CVAC5Oper");
        Long dd_cClmFaultModHVAC1_c1 = getValue("port0x129", "DD_CClmFaultModHVAC1_C1");
        Long dd_cClmFaultModHVAC2_c1 = getValue("port0x129", "DD_CClmFaultModHVAC2_C1");
        String havcC1_1 = getHavcStatus(dd_cvac5Oper, dd_cClmFaultModHVAC1_c1);
        String havcC1_2 = getHavcStatus(dd_cvac5Oper, dd_cClmFaultModHVAC2_c1);

        Map c1 = new HashMap();
        c1.put("c1_1", havcC1_1);
        c1.put("c1_2", havcC1_2);
        data.put("c1", c1);
        Long dd_cvac6Oper = getValue("port0x128", "DD_CVAC6Oper");
        Long dd_cClmFaultModHVAC1_c2 = getValue("port0x129", "DD_CClmFaultModHVAC1_C2");
        Long dd_cClmFaultModHVAC2_c2 = getValue("port0x129", "DD_CClmFaultModHVAC2_C2");
        String havcC2_1 = getHavcStatus(dd_cvac6Oper, dd_cClmFaultModHVAC1_c2);
        String havcC2_2 = getHavcStatus(dd_cvac6Oper, dd_cClmFaultModHVAC2_c2);

        Map c2 = new HashMap();
        c2.put("c2_1", havcC2_1);
        c2.put("c2_2", havcC2_2);
        data.put("c2", c2);
        return data;
    }

    private static String getHavcStatus(Long dd_cvac1Oper, Long dd_cClmFaultModHVAC1_) {
        String havc = "";
        if (dd_cvac1Oper == 1 && dd_cClmFaultModHVAC1_ == 0) {
            havc = "ok";
        } else if (dd_cClmFaultModHVAC1_ == 1) {
            havc = "faulty";
        } else if (dd_cvac1Oper == 0 && dd_cClmFaultModHVAC1_ == 0) {
            havc = "unknown";
        }
        return havc;
    }

    /**
     * PAPIS
     *
     * @param 
     * @return
     */
    private static Map createPAPIS() {
        Map data = new HashMap();
        Long dd_cCabPAPISOK_a1 = getValue("port0x136", "DD_CCabPAPISOK_A1");
        Long dd_cAtleastOnePISFault_a1 = getValue("port0x123", "DD_CAtleastOnePISFault_A1");

        String papisA1 = getPAPISStatus(dd_cCabPAPISOK_a1, dd_cAtleastOnePISFault_a1);
        data.put("a1", papisA1);
        Long dd_cCabPAPISOK_a2 = getValue("port0x136", "DD_CCabPAPISOK_A2");
        Long dd_cAtleastOnePISFault_a2 = getValue("port0x123", "DD_CAtleastOnePISFault_A2");
        String papisA2 = getPAPISStatus(dd_cCabPAPISOK_a2, dd_cAtleastOnePISFault_a2);
        data.put("a2", papisA2);
        Long dd_cCabPAPISOK_b1 = getValue("port0x136", "DD_CCabPAPISOK_B1");
        Long dd_cAtleastOnePISFault_b1 = getValue("port0x123", "DD_CAtleastOnePISFault_B1");
        String papisB1 = getPAPISStatus(dd_cCabPAPISOK_b1, dd_cAtleastOnePISFault_b1);
        data.put("b1", papisB1);
        Long dd_cCabPAPISOK_b2 = getValue("port0x136", "DD_CCabPAPISOK_B2");
        Long dd_cAtleastOnePISFault_b2 = getValue("port0x123", "DD_CAtleastOnePISFault_B2");
        String papisB2 = getPAPISStatus(dd_cCabPAPISOK_b2, dd_cAtleastOnePISFault_b2);
        data.put("b2", papisB2);
        Long dd_cCabPAPISOK_c1 = getValue("port0x136", "DD_CCabPAPISOK_C1");
        Long dd_cAtleastOnePISFault_c1 = getValue("port0x123", "DD_CAtleastOnePISFault_C1");
        String papisC1 = getPAPISStatus(dd_cCabPAPISOK_c1, dd_cAtleastOnePISFault_c1);
        data.put("c1", papisC1);
        Long dd_cCabPAPISOK_c2 = getValue("port0x136", "DD_CCabPAPISOK_C2");
        Long dd_cAtleastOnePISFault_c2 = getValue("port0x123", "DD_CAtleastOnePISFault_C2");
        String papisC2 = getPAPISStatus(dd_cCabPAPISOK_c2, dd_cAtleastOnePISFault_c2);
        data.put("c2", papisC2);
        return data;
    }

    private static String getPAPISStatus(Long dd_cCabPAPISOK_, Long dd_cAtleastOnePISFault_) {
        String papis = "";
        if (dd_cCabPAPISOK_ == 1 && dd_cAtleastOnePISFault_ == 0) {
            papis = "ok";
        } else if (dd_cAtleastOnePISFault_ == 0) {
            papis = "faulty";
        } else if (dd_cCabPAPISOK_ == 0 && dd_cAtleastOnePISFault_ == 0) {
            papis = "unknown";
        }
        return papis;
    }

    /**
     * Air Suspension Pressure
     *
     * @param 
     * @return
     */
    private static Map createAirSuspensionPressure() {
        Map data = new HashMap();
        Long dd_cAirSpringPresB1_a1 = getValue("port0x132", "DD_CAirSpringPresB1_A1");
        Long dd_cAirSpringPresB2_a1 = getValue("port0x132", "DD_CAirSpringPresB2_A1");
        Long dd_cAirSpringPresB1_b1 = getValue("port0x132", "DD_CAirSpringPresB1_B1");
        Long dd_cAirSpringPresB2_b1 = getValue("port0x132", "DD_CAirSpringPresB2_B1");
        Long dd_cAirSpringPresB1_b2 = getValue("port0x132", "DD_CAirSpringPresB1_B2");
        Long dd_cAirSpringPresB2_b2 = getValue("port0x132", "DD_CAirSpringPresB2_B2");
        Long dd_cAirSpringPresB1_c1 = getValue("port0x132", "DD_CAirSpringPresB1_C1");
        Long dd_cAirSpringPresB2_c1 = getValue("port0x132", "DD_CAirSpringPresB2_C1");
        Long dd_cAirSpringPresB2_c2 = getValue("port0x132", "DD_CAirSpringPresB2_C2");
        Long dd_cAirSpringPresB1_c2 = getValue("port0x132", "DD_CAirSpringPresB1_C2");
        Long dd_cAirSpringPresB1_a2 = getValue("port0x129", "DD_CAirSpringPresB1_A2");
        Long dd_cAirSpringPresB2_a2 = getValue("port0x129", "DD_CAirSpringPresB2_A2");
        data.put("a1_1", dd_cAirSpringPresB1_a1);
        data.put("a1_2", dd_cAirSpringPresB2_a1);
        data.put("b1_1", dd_cAirSpringPresB1_b1);
        data.put("b1_2", dd_cAirSpringPresB2_b1);
        data.put("b2_1", dd_cAirSpringPresB1_b2);
        data.put("b2_2", dd_cAirSpringPresB2_b2);
        data.put("c1_1", dd_cAirSpringPresB1_c1);
        data.put("c1_2", dd_cAirSpringPresB2_c1);
        data.put("c2_2", dd_cAirSpringPresB2_c2);
        data.put("c2_1", dd_cAirSpringPresB1_c2);
        data.put("a2_1", dd_cAirSpringPresB1_a2);
        data.put("a2_2", dd_cAirSpringPresB2_a2);

        return data;
    }

    /**
     * Wiper Status
     *
     * @param 
     * @return
     */
    private static Map createWiperStatus() {
        Map data = new HashMap();
        Long dd_cWiperInhibit = getValue("port0x136", "DD_CWiperInhibit");
        Long dd_cWiperActMid = getValue("port0x129", "DD_CWiperActMid");
        String wiper = "";
        if (dd_cWiperInhibit == 0) {
            wiper = "nodisplayed";
        } else if (dd_cWiperInhibit == 1 && dd_cWiperActMid == 1) {
            wiper = "activated";
        } else if (dd_cWiperInhibit == 1 && dd_cWiperActMid == 0) {
            wiper = "nomiddle";
        }
        data.put("wiper", wiper);
        return data;
    }
}
