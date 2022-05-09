package com.missiongroup.starring.core.vehicleData;


import java.util.HashMap;
import java.util.Map;

public class HVDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map hvFuseStatus = createHVFuseStatus();
        data.put("hvFuseStatus", hvFuseStatus);
        Map circuitInterlockStatus = createCircuitInterlockStatus();
        data.put("circuitInterlockStatus", circuitInterlockStatus);

        Map hscbStatus = createHSCBStatus();
        data.put("hscbStatus", hscbStatus);

        Map<String, Object> converterStatus = createConverterStatus();
        data.put("converterStatus", converterStatus);

        Map motorStatus = createMotorStatus();
        data.put("motorStatus", motorStatus);

        Map groundStatus = createGroundStatus();
        data.put("groundStatus", groundStatus);

        Map workshopPowerSupplyStatus = createWorkshopPowerSupplyStatus();
        data.put("workshopPowerSupplyStatus", workshopPowerSupplyStatus);

        Map auxFuseStatus = createAUXFuseStatus();
        data.put("auxFuseStatus", auxFuseStatus);

        Map auxbusFuseStatus = createAUXBUSFuseStatus();
        data.put("auxbusFuseStatus", auxbusFuseStatus);

        return data;
    }

    /**
     * HV Fuse Status
     */
    private static Map createHVFuseStatus() {
        Map<String, Object> data = new HashMap<>();


        Long dd_chvmf1_b1 = getValue("port0x127", "DD_CHVMF1_B1");
        Long dd_chvmf1_b2 = getValue("port0x127", "DD_CHVMF1_B2");
        Long dd_chvmf2_b1 = getValue("port0x127", "DD_CHVMF2_B1");
        Long dd_chvmf2_b2 = getValue("port0x127", "DD_CHVMF2_B2");
        String hv1_b1 = getHVStatus(dd_chvmf1_b1);
        String hv1_b2 = getHVStatus(dd_chvmf1_b2);
        String hv2_b1 = getHVStatus(dd_chvmf2_b1);
        String hv2_b2 = getHVStatus(dd_chvmf2_b2);
        data.put("hv1_b1", hv1_b1);
        data.put("hv1_b2", hv1_b2);
        data.put("hv2_b1", hv2_b1);
        data.put("hv2_b2", hv2_b2);
        return data;
    }

    private static String getHVStatus(Long dd_chvmf1_) {
        String hv = "";
        if (dd_chvmf1_ == 0) {
            hv = "connected";
        } else if (dd_chvmf1_ == 1) {
            hv = "disconnected";
        }
        return hv;
    }

    /**
     * Circuit Interlock Status
     */
    private static Map createCircuitInterlockStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cieSinLockedPos_b1 = getValue("port0x133", "DD_CIESinLockedPos_B1");
        Long dd_cieSinLockedPos_b2 = getValue("port0x133", "DD_CIESinLockedPos_B2");
        //Long dd_cieSinLockedPos_c1 = (Long) port0x133.getDD_CIESinLockedPos_C1();
        //Long dd_cieSinLockedPos_c2 = (Long) port0x133.getDD_CIESinLockedPos_C2();

        String lockStatus1 = getLockStatus(dd_cieSinLockedPos_b1);
        String lockStatus2 = getLockStatus(dd_cieSinLockedPos_b2);
        data.put("lock_b1", lockStatus1);
        data.put("lock_b2", lockStatus2);
        return data;
    }

    private static String getLockStatus(Long dd_cieSinLockedPos_b1) {
        String lockStatus = "";
        if (dd_cieSinLockedPos_b1 == 1) {
            lockStatus = "locked";
        } else if (dd_cieSinLockedPos_b1 == 0) {
            lockStatus = "active";
        }
        return lockStatus;
    }

    /**
     * HSCB Status
     */
    private static Map createHSCBStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_chscbOpen_b1 = getValue("port0x127", "DD_CHSCBOpen_B1");
        Long dd_chscbOpen_c1 = getValue("port0x127", "DD_CHSCBOpen_C1");
        Long dd_chscbOpen_c2 = getValue("port0x127", "DD_CHSCBOpen_C2");
        Long dd_chscbOpen_b2 = getValue("port0x127", "DD_CHSCBOpen_B2");

        Long dd_chscbCloseFlt_b1 = getValue("port0x128", "DD_CHSCBCloseFlt_B1");
        Long dd_chscbCloseFlt_c1 = getValue("port0x128", "DD_CHSCBCloseFlt_C1");
        Long dd_chscbCloseFlt_c2 = getValue("port0x128", "DD_CHSCBCloseFlt_C2");
        Long dd_chscbCloseFlt_b2 = getValue("port0x128", "DD_CHSCBCloseFlt_B2");

        Long dd_chscbOpenFlt_b1 = getValue("port0x128", "DD_CHSCBOpenFlt_B1");
        Long dd_chscbOpenFlt_c1 = getValue("port0x128", "DD_CHSCBOpenFlt_C1");
        Long dd_chscbOpenFlt_c2 = getValue("port0x128", "DD_CHSCBOpenFlt_C2");
        Long dd_chscbOpenFlt_b2 = getValue("port0x128", "DD_CHSCBOpenFlt_B2");
        Long dd_cpce1Oper = getValue("port0x127", "DD_CPCE1Oper");
        String HSCBStatus1 = getHSCBStatus(dd_chscbOpen_b1, dd_chscbCloseFlt_b1, dd_chscbOpenFlt_b1, dd_cpce1Oper);
        data.put("HSCBStatus1", HSCBStatus1);
        Long dd_cpce2Oper = getValue("port0x127", "DD_CPCE2Oper");
        String HSCBStatus2 = getHSCBStatus(dd_chscbOpen_c1, dd_chscbCloseFlt_c1, dd_chscbOpenFlt_c1, dd_cpce2Oper);
        data.put("HSCBStatus2", HSCBStatus2);
        Long dd_cpce3Oper = getValue("port0x127", "DD_CPCE3Oper");
        String HSCBStatus3 = getHSCBStatus(dd_chscbOpen_c2, dd_chscbCloseFlt_c2, dd_chscbOpenFlt_c2, dd_cpce3Oper);
        data.put("HSCBStatus3", HSCBStatus3);
        Long dd_cpce4Oper = getValue("port0x127", "DD_CPCE4Oper");
        String HSCBStatus4 = getHSCBStatus(dd_chscbOpen_b2, dd_chscbCloseFlt_b2, dd_chscbOpenFlt_b2, dd_cpce4Oper);
        data.put("HSCBStatus4", HSCBStatus4);

        return data;
    }

    private static String getHSCBStatus(Long dd_chscbOpen_, Long dd_chscbCloseFlt_, Long dd_chscbOpenFlt_, Long dd_cpce1Oper) {
        String HSCBStatus = "";
        if (dd_chscbOpen_ == 0 && dd_chscbCloseFlt_ == 0 && dd_chscbOpenFlt_ == 0 && dd_cpce1Oper == 1) {
            HSCBStatus = "closed";
        } else if (dd_chscbOpen_ == 1 && dd_chscbCloseFlt_ == 0 && dd_chscbOpenFlt_ == 0 && dd_cpce1Oper == 1) {
            HSCBStatus = "open";
        } else if (dd_chscbOpenFlt_ == 1 && dd_cpce1Oper == 1) {
            HSCBStatus = "openfault";
        } else if (dd_chscbCloseFlt_ == 1 && dd_chscbOpenFlt_ == 0 && dd_cpce1Oper == 1) {
            HSCBStatus = "closefault";
        } else if (dd_cpce1Oper == 0) {
            HSCBStatus = "unknown";
        }
        return HSCBStatus;
    }

    /**
     * Converter Status
     */
    private static Map<String, Object> createConverterStatus() {

        Map<String, Object> auxConData = new HashMap<>();
        Long dd_cace1Failure = getValue("port0x126", "DD_CACE1Failure");
        Long dd_cace1NormMode = getValue("port0x126", "DD_CACE1NormMode");
        Long dd_cace1StopMode = getValue("port0x126", "DD_CACE1StopMode");
        String ACE1Status = getConvStatus(dd_cace1Failure, dd_cace1NormMode, dd_cace1StopMode);
        auxConData.put("ACE1", ACE1Status);

        Long dd_cace2Failure = getValue("port0x126", "DD_CACE2Failure");
        Long dd_cace2NormMode = getValue("port0x126", "DD_CACE2NormMode");
        Long dd_cace2StopMode = getValue("port0x126", "DD_CACE2StopMode");
        String ACE2Status = getConvStatus(dd_cace2Failure, dd_cace2NormMode, dd_cace2StopMode);
        auxConData.put("ACE2", ACE2Status);

        Long dd_cace3Failure = getValue("port0x126", "DD_CACE3Failure");
        Long dd_cace3NormMode = getValue("port0x126", "DD_CACE3NormMode");
        Long dd_cace3StopMode = getValue("port0x126", "DD_CACE3StopMode");
        String ACE3Status = getConvStatus(dd_cace3Failure, dd_cace3NormMode, dd_cace3StopMode);
        auxConData.put("ACE3", ACE3Status);
        return auxConData;
    }

    private static String getConvStatus(Long dd_cace1Failure, Long dd_cace1NormMode, Long dd_cace1StopMode) {
        String ACE1Status = "";
        if (dd_cace1Failure == 1) {
            ACE1Status = "failure";
        } else if (dd_cace1StopMode == 1 && dd_cace1Failure == 0) {
            ACE1Status = "stop";
        } else if (dd_cace1StopMode == 0 && dd_cace1Failure == 0 && dd_cace1NormMode == 1) {
            ACE1Status = "normal";

        } else if (dd_cace1StopMode == 0 && dd_cace1Failure == 0 && dd_cace1NormMode == 0) {
            ACE1Status = "unknown";
        }
        return ACE1Status;
    }

    /**
     * Motor Status
     */
    private static Map createMotorStatus() {
        Map<String, Object> data = new HashMap<>();


        Long dd_cpce1Oper = getValue("port0x127", "DD_CPCE1Oper");
        Long dd_cPropOK_b1 = getValue("port0x127", "DD_CPropOK_B1");
        Long dd_cedInProgress_b1 = getValue("port0x127", "DD_CEDInProgress_B1");
        Long dd_cpceFault_b1 = getValue("port0x126", "DD_CPCEFault_B1");
        Long dd_cpceIsolFlt_b1 = getValue("port0x127", "DD_CPCEIsolFlt_B1");
        String motorStatusb1 = getMotorStatus(dd_cpce1Oper, dd_cPropOK_b1, dd_cedInProgress_b1, dd_cpceFault_b1, dd_cpceIsolFlt_b1);
        data.put("motorStatusb1", motorStatusb1);


        Long dd_cpce2Oper = getValue("port0x127", "DD_CPCE2Oper");
        Long dd_cPropOK_c1 = getValue("port0x127", "DD_CPropOK_C1");
        Long dd_cedInProgress_c1 = getValue("port0x127", "DD_CEDInProgress_C1");
        Long dd_cpceFault_c1 = getValue("port0x126", "DD_CPCEFault_C1");
        Long dd_cpceIsolFlt_c1 = getValue("port0x127", "DD_CPCEIsolFlt_C1");
        String motorStatusc1 = getMotorStatus(dd_cpce2Oper, dd_cPropOK_c1, dd_cedInProgress_c1, dd_cpceFault_c1, dd_cpceIsolFlt_c1);
        data.put("motorStatusc1", motorStatusc1);


        Long dd_cpce3Oper = getValue("port0x127", "DD_CPCE3Oper");
        Long dd_cPropOK_c2 = getValue("port0x127", "DD_CPropOK_C2");
        Long dd_cedInProgress_c2 = getValue("port0x127", "DD_CEDInProgress_C2");
        Long dd_cpceFault_c2 = getValue("port0x126", "DD_CPCEFault_C2");
        Long dd_cpceIsolFlt_c2 = getValue("port0x127", "DD_CPCEIsolFlt_C2");
        String motorStatusc2 = getMotorStatus(dd_cpce3Oper, dd_cPropOK_c2, dd_cedInProgress_c2, dd_cpceFault_c2, dd_cpceIsolFlt_c2);
        data.put("motorStatusc2", motorStatusc2);


        Long dd_cpce4Oper = getValue("port0x127", "DD_CPCE4Oper");
        Long dd_cPropOK_b2 = getValue("port0x127", "DD_CPropOK_B2");
        Long dd_cedInProgress_b2 = getValue("port0x127", "DD_CEDInProgress_B2");
        Long dd_cpceFault_b2 = getValue("port0x126", "DD_CPCEFault_B2");
        Long dd_cpceIsolFlt_b2 = getValue("port0x127", "DD_CPCEIsolFlt_B2");
        String motorStatusb2 = getMotorStatus(dd_cpce4Oper, dd_cPropOK_b2, dd_cedInProgress_b2, dd_cpceFault_b2, dd_cpceIsolFlt_b2);
        data.put("motorStatusb2", motorStatusb2);
        return data;
    }

    private static String getMotorStatus(Long dd_cpce1Oper, Long dd_cPropOK_b1, Long dd_cedInProgress_b1, Long dd_cpceFault_b1, Long dd_cpceIsolFlt_b1) {
        String motorStatus = "";
        if (dd_cpceIsolFlt_b1 == 1) {
            motorStatus = "ioslated";
        } else if (dd_cpceFault_b1 == 1 && dd_cpceIsolFlt_b1 == 0) {
            motorStatus = "fault";
        } else if (dd_cedInProgress_b1 == 1 && dd_cpceFault_b1 == 0 && dd_cpceIsolFlt_b1 == 0) {
            motorStatus = "inprogress";
        } else if (dd_cPropOK_b1 == 1 && dd_cedInProgress_b1 == 0 && dd_cpceFault_b1 == 0 && dd_cpceIsolFlt_b1 == 0) {
            motorStatus = "done";
        } else if (dd_cpce1Oper == 1 && dd_cPropOK_b1 == 0 && dd_cedInProgress_b1 == 0 && dd_cpceFault_b1 == 0 && dd_cpceIsolFlt_b1 == 0) {
            motorStatus = "ok";
        } else if (dd_cpce1Oper == 0 && dd_cPropOK_b1 == 0 && dd_cedInProgress_b1 == 0 && dd_cpceFault_b1 == 0 && dd_cpceIsolFlt_b1 == 0) {
            motorStatus = "unknown";
        }
        return motorStatus;
    }

    /**
     * Ground Status
     */
    private static Map createGroundStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cieSinEarthPos_b1 = getValue("port0x133", "DD_CIESinEarthPos_B1");
        Long dd_cieSinEarthPos_b2 = getValue("port0x133", "DD_CIESinEarthPos_B2");
        Long dd_cieSinEarthPos_c1 = getValue("port0x133", "DD_CIESinEarthPos_C1");
        Long dd_cieSinEarthPos_c2 = getValue("port0x133", "DD_CIESinEarthPos_C2");
        String groupb1 = getGroupStatus(dd_cieSinEarthPos_b1);
        data.put("groupb1", groupb1);
        String groupb2 = getGroupStatus(dd_cieSinEarthPos_b2);
        data.put("groupb2", groupb2);
        String groupc1 = getGroupStatus(dd_cieSinEarthPos_c1);
        data.put("groupc1", groupc1);
        String groupc2 = getGroupStatus(dd_cieSinEarthPos_c2);
        data.put("groupc2", groupc2);
        return data;
    }

    private static String getGroupStatus(Long dd_cieSinEarthPos_) {
        String group = "";
        if (dd_cieSinEarthPos_ == 1) {
            group = "Connections";
        } else if (dd_cieSinEarthPos_ == 0) {
            group = "unknown";
        }
        return group;
    }

    /**
     * Workshop Power Supply Status
     */
    private static Map createWorkshopPowerSupplyStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_ciesInShoreSupply_b1 = getValue("port0x133", "DD_CIESInShoreSupply_B1");
        Long dd_ciesInShoreSupply_b2 = getValue("port0x133", "DD_CIESInShoreSupply_B2");
        String workshopb1 = getWorkshopStatus(dd_ciesInShoreSupply_b1);
        data.put("workshop_b1", workshopb1);
        String workshopb2 = getWorkshopStatus(dd_ciesInShoreSupply_b2);
        data.put("workshop_b2", workshopb2);
        return data;
    }

    private static String getWorkshopStatus(Long dd_ciesInShoreSupply_b1) {
        String workshop = "";
        if (dd_ciesInShoreSupply_b1 == 1) {
            workshop = "connected";
        } else if (dd_ciesInShoreSupply_b1 == 0) {
            workshop = "unknown";
        }
        return workshop;
    }


    /**
     * AUX Fuse Status
     */
    private static Map createAUXFuseStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cfauxStatus_a1 = getValue("port0x127", "DD_CFAUXStatus_A1");
        Long dd_cfauxStatus_a2 = getValue("port0x127", "DD_CFAUXStatus_A2");
        Long dd_cfauxStatus_c2 = getValue("port0x127", "DD_CFAUXStatus_C2");
        String AUXStatusA1 = getAuxStatus(dd_cfauxStatus_a1);
        String AUXStatusA2 = getAuxStatus(dd_cfauxStatus_a2);
        String AUXStatusC2 = getAuxStatus(dd_cfauxStatus_c2);
        data.put("AUXStatus_A1", AUXStatusA1);
        data.put("AUXStatus_A2", AUXStatusA2);
        data.put("AUXStatus_C2", AUXStatusC2);
        return data;
    }

    private static String getAuxStatus(Long dd_cfauxStatus_a1) {
        String AUXStatusA1 = "";
        if (dd_cfauxStatus_a1 == 0) {
            AUXStatusA1 = "disconnected";
        } else if (dd_cfauxStatus_a1 == 1) {
            AUXStatusA1 = "connected";
        }
        return AUXStatusA1;
    }

    /**
     * AUXBUS Fuse Status
     */
    private static Map createAUXBUSFuseStatus() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cfauxbus_b1 = getValue("port0x127", "DD_CFAUXBUS_B1");
        Long dd_cfauxbus_b2 = getValue("port0x127", "DD_CFAUXBUS_B2");
        String b1 = getAuxStatusBUSFuseStatus(dd_cfauxbus_b1);
        data.put("AUXBUSFuse_b1", b1);

        String b2 = getAuxStatusBUSFuseStatus(dd_cfauxbus_b2);
        data.put("AUXBUSFuse_b2", b2);

        return data;
    }

    private static String getAuxStatusBUSFuseStatus(Long dd_cfauxbus) {
        String AUXbus = "";
        if (dd_cfauxbus == 0) {
            AUXbus = "disconnected";
        } else if (dd_cfauxbus == 1) {
            AUXbus = "connected";
        }
        return AUXbus;
    }
}