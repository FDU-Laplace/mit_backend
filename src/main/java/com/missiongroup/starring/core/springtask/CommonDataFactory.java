package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class CommonDataFactory extends DatatFactory{

    public static Map createData() {
        Map data = new HashMap();
        Map driveModeData = createDriveModeData();
        data.put("drive_Mode_Data", driveModeData);
        Map atpStatusData = createATPStatusData();
        data.put("ATP_Status_Data", atpStatusData);
        Map otherInformationData = createOtherInformationData();
        data.put("otherInformationData", otherInformationData);
        Map detrainmentData = detrainmentData();
        data.put("detrainmentData", detrainmentData);
        Map hvacData = HVACData();
        data.put("hvacData", hvacData);
        Map bypassData = BypassData();
        data.put("bypassData", bypassData);
        Map emergencyBrakeData = EmergencyBrakeData();
        data.put("emergencyBrakeData", emergencyBrakeData);
        Map emergencyHandleData = EmergencyHandleData();
        data.put("emergencyHandleData", emergencyHandleData);
        Map fireData = fireData();
        data.put("fireData", fireData);
        Map circuitBreakerData = circuitBreakerData();
        data.put("circuitBreakerData", circuitBreakerData);
        Map pecuData = PECUData();
        data.put("pecuData", pecuData);
        return data;
    }

    /**
     * Driving Mode
     *
     * @param 
     * @return
     */
    private static Map createDriveModeData() {
        Map data = new HashMap();
        String mode = "";
        Long dd_coff = getValue("port0x120","DD_COFF");
        Long dd_cwma = getValue("port0x120","DD_CWMA");
        Long dd_crmfNoATP =getValue("port0x127","DD_CRMFNoATP");
        Long dd_csmNoATP = getValue("port0x127","DD_CSMNoATP");
        Long dd_crmra = getValue("port0x120","DD_CRMRA");
        Long dd_crmfa = getValue("port0x120","DD_CRMFA");
        Long dd_csma = getValue("port0x120","DD_CSMA");
        Long dd_catoma = getValue("port0x120","DD_CATOMA");
        Long dd_cSlowMode = getValue("port0x126","DD_CSlowMode");
        Long dd_crsrmOffline = getValue("port0x131","DD_CRSRMOffline");
        Long dd_cfamaOffline = getValue("port0x131","DD_CFAMAOffline");
        Long dd_crsrmOnline = getValue("port0x131","DD_CRSRMOnline");
        Long dd_cfamaOnline = getValue("port0x131","DD_CFAMAOnline");
        if (dd_coff == 1) {
            mode = "OFF";
        } else if (dd_cwma == 1&&dd_coff == 0) {
            mode = "WASH";
        } else if (dd_crmfNoATP == 1&&dd_cwma == 0&&dd_coff == 0) {
            mode = "RMF_NO_ATP";
        } else if (dd_csmNoATP == 1&&dd_crmfNoATP == 0&&dd_cwma == 0&&dd_coff == 0) {
            mode = "SM_NO_ATP";
        } else if (dd_crmra == 1&&dd_csmNoATP == 0&&dd_crmfNoATP == 0&&dd_cwma == 0&&dd_coff == 0) {
            mode = "RMR";
        } else if (dd_crmfa == 1&&dd_crmra == 0&&dd_csmNoATP == 0&&dd_crmfNoATP == 0&&dd_cwma == 0&&dd_coff == 0) {
            mode = "RMF_ATP";
        } else if (dd_csma == 1&&dd_crmfa == 0&&dd_crmra == 0&&dd_csmNoATP == 0&&dd_crmfNoATP == 0&&dd_cwma == 0&&dd_coff == 0) {
            mode = "SM_ATP";
        } else if (dd_catoma == 1) {
            mode = "ATO";
        } else if (dd_cSlowMode == 1) {
            mode = "FAM_SLOW";
        } else if (dd_crsrmOffline == 1) {
            mode = "RSRM_OFFLINE";
        } else if (dd_crsrmOnline == 1) {
            mode = "RSRM_ONLINE";
        } else if (dd_cfamaOnline == 1) {
            mode = "FAMA_ONLINE";
        } else if (dd_cfamaOffline == 1) {
            mode = "FAMA_OFFLINE";
        } else {
            mode = "Unknown";
        }
        data.put("DriveMode", mode);
        return data;
    }

    /**
     * ATP Status
     *
     * @param 
     * @return
     */
    private static Map createATPStatusData() {
        Map data = new HashMap();
        Long dd_catc1OK = getValue("port0x120","DD_CATC1OK");
        Long dd_cnatc1Isol = getValue("port0x120","DD_CNATC1Isol");
        Long dd_catcFlt = getValue("port0x120","DD_CATCFlt");
        String ATPStatus = "";
        if (dd_catc1OK == 1) {
            ATPStatus = "ATP_OK";
        } else if (dd_cnatc1Isol == 1) {
            ATPStatus = "ATP_isolated";
        } else if (dd_catcFlt == 1) {
            ATPStatus = "ATP_Fault";
        } else {
            ATPStatus = "unknown";
        }
        data.put("ATP_Status", ATPStatus);
        return data;
    }

    /**
     * Other Information
     *
     * @param 
     * @return
     */
    private static Map createOtherInformationData() {
        Map data = new HashMap();
        Long dd_cSpeedLimitVal = getValue("port0x120","DD_CSpeedLimitVal");
        Long mpu_cRefAbsSpeed = getValue("port0x100","MPU_CRefAbsSpeed");
        data.put("dd_cSpeedLimitVal", dd_cSpeedLimitVal);
        data.put("mpu_cRefAbsSpeed", mpu_cRefAbsSpeed);


        Long dd_cTrainHVVolt = getValue("port0x120","DD_CTrainHVVolt");
        Long dd_cTrainHVCurrent = getValue("port0x130","DD_CTrainHVCurrent");
        double dd_cValidMinMainResPres = getValue("port0x133","DD_CValidMinMainResPres")*0.1;
        data.put("dd_cTrainHVVolt", dd_cTrainHVVolt);
        data.put("dd_cTrainHVCurrent", dd_cTrainHVCurrent);
        data.put("dd_cValidMinMainResPres", String.format("%.1f", dd_cValidMinMainResPres));
        //外部温度
        Long dd_cExtTemp = getValue("port0x120","DD_CExtTemp");
        data.put("dd_cExtTemp", dd_cExtTemp);
        //列车编号
        Long mpu_cTrainNumber = getValue("port0x101","MPU_CTrainNumber");
        data.put("mpu_cTrainNumber", mpu_cTrainNumber);
        //时间
        Long mpu_cDateTimeSec = getValue("port0x101","MPU_CDateTimeSec");
        Long mpu_cDateTimeTick = getValue("port0x101","MPU_CDateTimeTick");
        data.put("mpu_cDateTimeSec", mpu_cDateTimeSec);

        //Mission Next Station
        Long dd_cNextStation = getValue("port0x127","DD_CNextStation");
        data.put("dd_cNextStation", dd_cNextStation);
        //Mission Destination
        Long dd_cFinalDestination = getValue("port0x127","DD_CFinalDestination");
        data.put("dd_cFinalDestination", dd_cFinalDestination);


        //No Cover is opened
        //Cover Screen is Selected without alaram
        //At least one cover is opened
        return data;
    }

    /**
     * Detrainment door 排气门
     *
     * @param 
     * @return
     */
    public static Map detrainmentData() {
        Map data = new HashMap();
        Long dd_cDrsDDUnlocked_a1 = getValue("port0x120","DD_CDrsDDUnlocked_A1");
        Long dd_cDrsDDClosed_a1 = getValue("port0x120","DD_CDrsDDClosed_A1");
        String detrainment_status_a1 = "";
        if (dd_cDrsDDUnlocked_a1 == 1) {
            detrainment_status_a1 = "Unlocked";
        } else if (dd_cDrsDDClosed_a1 == 1) {
            detrainment_status_a1 = "Closed";
        }
        data.put("detrainment_status_a1", detrainment_status_a1);
        Long dd_cDrsDDUnlocked_a2 = getValue("port0x120","DD_CDrsDDUnlocked_A2");
        Long dd_cDrsDDClosed_a2 = getValue("port0x120","DD_CDrsDDClosed_A2");
        String detrainment_status_a2 = "";
        if (dd_cDrsDDUnlocked_a2 == 1) {
            detrainment_status_a2 = "Unlocked";
        } else if (dd_cDrsDDClosed_a2 == 1) {
            detrainment_status_a2 = "Closed";
        }
        data.put("detrainment_status_a2", detrainment_status_a2);
        return data;
    }

    /**
     * HVAC
     *
     * @param 
     */
    private static Map HVACData() {
        Map data = new HashMap();
        Long dd_cClmDamperClosedHVAC_a1 = getValue("port0x128","DD_CClmDamperClosedHVAC_A1");
        Long dd_cClmStopModHVAC_a1 = getValue("port0x129","DD_CClmStopModHVAC_A1");
        String HVAC_a1 = getHVACStatus(dd_cClmDamperClosedHVAC_a1, dd_cClmStopModHVAC_a1);
        data.put("HVAC_a1", HVAC_a1);
        Long dd_cClmDamperClosedHVAC_a2 = getValue("port0x128","DD_CClmDamperClosedHVAC_A2");
        Long dd_cClmStopModHVAC_a2 = getValue("port0x129","DD_CClmStopModHVAC_A2");
        String HVAC_a2 = getHVACStatus(dd_cClmDamperClosedHVAC_a2, dd_cClmStopModHVAC_a2);
        data.put("HVAC_a2", HVAC_a2);

        Long dd_cClmDamperClosedHVAC_b1 = getValue("port0x128","DD_CClmDamperClosedHVAC_B1");
        Long dd_cClmStopModHVAC_b1 = getValue("port0x129","DD_CClmStopModHVAC_B1");
        String HVAC_b1 = getHVACStatus(dd_cClmDamperClosedHVAC_b1, dd_cClmStopModHVAC_b1);
        data.put("HVAC_b1", HVAC_b1);

        Long dd_cClmDamperClosedHVAC_b2 = getValue("port0x128","DD_CClmDamperClosedHVAC_B2");
        Long dd_cClmStopModHVAC_b2 = getValue("port0x129","DD_CClmStopModHVAC_B2");
        String HVAC_b2 = getHVACStatus(dd_cClmDamperClosedHVAC_b2, dd_cClmStopModHVAC_b2);
        data.put("HVAC_b2", HVAC_b2);
        Long dd_cClmDamperClosedHVAC_c1 = getValue("port0x128","DD_CClmDamperClosedHVAC_C1");
        Long dd_cClmStopModHVAC_c1 = getValue("port0x129","DD_CClmStopModHVAC_C1");
        String HVAC_c1 = getHVACStatus(dd_cClmDamperClosedHVAC_c1, dd_cClmStopModHVAC_c1);
        data.put("HVAC_c1", HVAC_c1);
        Long dd_cClmDamperClosedHVAC_c2 = getValue("port0x128","DD_CClmDamperClosedHVAC_C2");
        Long dd_cClmStopModHVAC_c2 = getValue("port0x129","DD_CClmStopModHVAC_C2");
        String HVAC_c2 = getHVACStatus(dd_cClmDamperClosedHVAC_c2, dd_cClmStopModHVAC_c2);
        data.put("HVAC_c2", HVAC_c2);
        return data;
    }

    private static String getHVACStatus(Long dd_cClmDamperClosedHVAC_, Long dd_cClmStopModHVAC_) {
        String HVAC_ = "";
        if (dd_cClmDamperClosedHVAC_ == 0 && dd_cClmStopModHVAC_ == 0) {
            HVAC_ = "false";
        } else {
            HVAC_ = "true";
        }
        return HVAC_;
    }

    /**
     * Bypass 旁路
     *
     * @param 
     * @return
     */
    private static Map BypassData() {
        Map data = new HashMap();
        //Bypass
        Long dd_cbpPrkBrk_a1 = getValue("port0x120","DD_CBPPrkBrk_A1");
        Long dd_cbpBrk_a1 =getValue("port0x120","DD_CBPBrk_A1");
        Long dd_cdirbps_a1 =getValue("port0x120","DD_CDIRBPS_A1");
        Long dd_cdebsa_a1 = getValue("port0x120","DD_CDEBSA_A1");
        Long dd_cdebsb_a1 = getValue("port0x120","DD_CDEBSB_A1");
        Long dd_cddbs_a1 = getValue("port0x120","DD_CDDBS_A1");
        Long dd_cbpDerailDet_a1 = getValue("port0x120","DD_CBPDerailDet_A1");
        Long dd_crgsbps_a1 = getValue("port0x120","DD_CRGSBPS_A1");
        Long dd_ccab1ByPassed = getValue("port0x120","DD_CCAB1ByPassed");

        String bypass_a1 = getBypassStatus(dd_cbpPrkBrk_a1, dd_cbpBrk_a1, dd_cdirbps_a1, dd_cdebsa_a1, dd_cdebsb_a1, dd_cddbs_a1, dd_cbpDerailDet_a1, dd_crgsbps_a1, dd_ccab1ByPassed);
        
        Long dd_cbpPrkBrk_a2 = getValue("port0x120","DD_CBPPrkBrk_A2");
        Long dd_cbpBrk_a2 =getValue("port0x120","DD_CBPBrk_A2");
        Long dd_cdirbps_a2 =getValue("port0x120","DD_CDIRBPS_A2");
        Long dd_cdebsa_a2 = getValue("port0x120","DD_CDEBSA_A2");
        Long dd_cdebsb_a2 = getValue("port0x120","DD_CDEBSB_A2");
        Long dd_cddbs_a2 = getValue("port0x120","DD_CDDBS_A2");
        Long dd_cbpDerailDet_a2 = getValue("port0x120","DD_CBPDerailDet_A2");
        Long dd_crgsbps_a2 = getValue("port0x120","DD_CRGSBPS_A2");
        Long dd_ccab2ByPassed = getValue("port0x120","DD_CCAB2ByPassed");
        
        String bypass_a2 = getBypassStatus(dd_cbpPrkBrk_a2, dd_cbpBrk_a2, dd_cdirbps_a2, dd_cdebsa_a2, dd_cdebsb_a2, dd_cddbs_a2, dd_cbpDerailDet_a2, dd_crgsbps_a2, dd_ccab2ByPassed);
       
        data.put("bypass_a2", bypass_a2);
        data.put("bypass_a1", bypass_a1);
        return data;
    }

    private static String getBypassStatus(Long dd_cbpPrkBrk_, Long dd_cbpBrk_, Long dd_cdirbps_, Long dd_cdebsa_, Long dd_cdebsb_, Long dd_cddbs_, Long dd_cbpDerailDet_, Long dd_crgsbps_, Long dd_ccab1ByPassed) {
        String bypass_ = "";
        if (dd_cbpPrkBrk_ + dd_cbpBrk_ + dd_cdirbps_ + dd_cdebsa_ + dd_cdebsb_ + dd_cddbs_ + dd_cbpDerailDet_ + dd_crgsbps_ + dd_ccab1ByPassed == 0) {
            bypass_ = "no_active";
        } else {
            bypass_ = "activated";
        }
        return bypass_;
    }

    /**
     * 紧急制动
     * Emergency brake
     */
    private static Map EmergencyBrakeData() {
        Map data = new HashMap();
        Long dd_cebDerail = getValue("port0x126","DD_CEBDerail");
        Long dd_ceblmrg = getValue("port0x126","DD_CEBLMRG");
        Long dd_cebOverSpeed = getValue("port0x126","DD_CEBOverSpeed");
        Long dd_cebatp = getValue("port0x126","DD_CEBATP");
        Long dd_cebNoCabAct = getValue("port0x126","DD_CEBNoCabAct");
        Long dd_cebApplFault = getValue("port0x126","DD_CEBApplFault");
        Long dd_cebRelFault = getValue("port0x126","DD_CEBRelFault");
        Long dd_cebCauseOther = getValue("port0x126","DD_CEBCauseOther");
        Long dd_cebBothCabAct = getValue("port0x126","DD_CEBBothCabAct");
        Long i = dd_cebDerail + dd_ceblmrg + dd_cebOverSpeed + dd_cebatp + dd_cebNoCabAct + dd_cebApplFault + dd_cebRelFault + dd_cebCauseOther + dd_cebBothCabAct;
        Long dd_cebpb_a1 = getValue("port0x126","DD_CEBPB_A1");
        Long dd_cebDeadMan_a1 = getValue("port0x126","DD_CEBDeadMan_A1");
        Long dd_cebDetObst_a1 = getValue("port0x126","DD_CEBDetObst_A1");
        Long dd_cebddOpen_a1 = getValue("port0x134","DD_CEBDDOpen_A1");
        String EmergencyBrake_a1 = "";
        if (i + dd_cebpb_a1 + dd_cebDeadMan_a1 + dd_cebDetObst_a1 + dd_cebddOpen_a1 == 0) {
            EmergencyBrake_a1 = "no_applied";
        }
        data.put("EmergencyBrake_a1", EmergencyBrake_a1);
        Long dd_cebddOpen_a2 = getValue("port0x134","DD_CEBDDOpen_A2");
        Long dd_cebDetObst_a2 = getValue("port0x126","DD_CEBDetObst_A2");
        Long dd_cebDeadMan_a2 = getValue("port0x126","DD_CEBDeadMan_A2");
        Long dd_cebpb_a2 = getValue("port0x126","DD_CEBPB_A2");
        String EmergencyBrake_a2 = "";
        if (i + dd_cebpb_a2 + dd_cebDeadMan_a2 + dd_cebDetObst_a2 + dd_cebddOpen_a2 == 0) {
            EmergencyBrake_a2 = "no_applied";
        }
        data.put("EmergencyBrake_a2", EmergencyBrake_a2);
        return null;
    }

    /**
     * 紧急手柄
     * Emergency Handle
     */
    private static Map EmergencyHandleData() {
        Map data = new HashMap();
        getValue("port0x122","DD_CDrsEmHand1_A1");
        return null;
    }

    /**
     * 火警
     * smoke detector or fire
     * detector activated and Fire
     * extinguisher in place
     */
    private static Map fireData() {
        Map data = new HashMap();

        Long dd_csdFlt_a1 = getValue("port0x123","DD_CSDFlt_A1");
        Long dd_csd_a1 = getValue("port0x123","DD_CSD_A1");
        Long dd_cFireExt1_a1 = getValue("port0x123","DD_CFireExt1_A1");
        Long dd_cFireFltCVS_a1 = getValue("port0x123","DD_CFireFltCVS_A1");
        Long dd_cFireFltBat_a1 = getValue("port0x123","DD_CFireFltBat_A1");
        Long dd_cFireFltLVBox_a1 = getValue("port0x123","DD_CFireFltLVBox_A1");
        Long dd_cFireBat_a1 =getValue("port0x123","DD_CFireBat_A1");
        Long dd_cFireCVS_a1 = getValue("port0x123","DD_CFireCVS_A1");
        String fire_alam_a1 = "";
        if (dd_csdFlt_a1 + dd_csd_a1 + dd_cFireExt1_a1 + dd_cFireFltCVS_a1 + dd_cFireFltBat_a1 + dd_cFireFltLVBox_a1 + dd_cFireBat_a1 + dd_cFireCVS_a1 == 0) {
            fire_alam_a1 = "no_active";
        } else if (dd_csdFlt_a1 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_a1 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_a1 = "red";
        }
        data.put("fire_alam_a1", fire_alam_a1);
        //////
        Long dd_csdFlt_a2 = getValue("port0x123","DD_CSDFlt_A2");
        Long dd_csd_a2 = getValue("port0x123","DD_CSD_A2");
        Long dd_cFireExt1_a2 = getValue("port0x123","DD_CFireExt1_A2");
        Long dd_cFireFltCVS_a2 = getValue("port0x123","DD_CFireFltCVS_A2");
        Long dd_cFireFltBat_a2 = getValue("port0x123","DD_CFireFltBat_A2");
        Long dd_cFireFltLVBox_a2 = getValue("port0x123","DD_CFireFltLVBox_A2");
        Long dd_cFireBat_a2 =getValue("port0x123","DD_CFireBat_A2");
        Long dd_cFireCVS_a2 = getValue("port0x123","DD_CFireCVS_A2");

        String fire_alam_a2 = "";
        if (dd_csdFlt_a2 + dd_csd_a2 + dd_cFireExt1_a2 + dd_cFireFltCVS_a2 + dd_cFireFltBat_a2 + dd_cFireFltLVBox_a2 + dd_cFireBat_a2 + dd_cFireCVS_a2 == 0) {
            fire_alam_a2 = "no_active";
        } else if (dd_csdFlt_a2 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_a2 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_a2 = "red";
        }
        data.put("fire_alam_a2", fire_alam_a2);
        ///
        Long dd_csdFlt_b1 =getValue("port0x123","DD_CSDFlt_B1");
        Long dd_csd_b1 = getValue("port0x123","DD_CSD_B1");
        Long dd_cFireExt1_b1 = getValue("port0x123","DD_CFireExt1_B1");
        Long dd_cFireFltTraction_b1 = getValue("port0x123","DD_CFireFltTraction_B1");
        Long dd_cFireFltLVBox_b1 = getValue("port0x123","DD_CFireFltLVBox_B1");
        Long dd_cFireFltHVBox_b1 = getValue("port0x123","DD_CFireFltHVBox_B1");
        Long dd_cFireInPCE_b1 = getValue("port0x123","DD_CFireInPCE_B1");
        Long dd_cFireLVBox_b1 = getValue("port0x120","DD_CFireLVBox_B1");
        Long dd_cFireHVBox_b1 = getValue("port0x120","DD_CFireHVBox_B1");
        String fire_alam_b1 = "";
        if (dd_csdFlt_b1 + dd_csd_b1 + dd_cFireExt1_b1 + dd_cFireFltTraction_b1 + dd_cFireFltLVBox_b1 + dd_cFireFltHVBox_b1 + dd_cFireInPCE_b1 + dd_cFireLVBox_b1 + dd_cFireHVBox_b1 == 0) {
            fire_alam_b1 = "no_active";
        } else if (dd_csdFlt_b1 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_b1 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_b1 = "red";
        }
        data.put("fire_alam_b1", fire_alam_b1);
        ///
        Long dd_csdFlt_b2 =getValue("port0x123","DD_CSDFlt_B2");
        Long dd_csd_b2 = getValue("port0x123","DD_CSD_B2");
        Long dd_cFireExt1_b2 = getValue("port0x123","DD_CFireExt1_B2");
        Long dd_cFireFltTraction_b2 = getValue("port0x123","DD_CFireFltTraction_B2");
        Long dd_cFireFltLVBox_b2 = getValue("port0x123","DD_CFireFltLVBox_B2");
        Long dd_cFireFltHVBox_b2 = getValue("port0x123","DD_CFireFltHVBox_B2");
        Long dd_cFireInPCE_b2 = getValue("port0x123","DD_CFireInPCE_B2");
        Long dd_cFireLVBox_b2 = getValue("port0x120","DD_CFireLVBox_B2");
        Long dd_cFireHVBox_b2 = getValue("port0x120","DD_CFireHVBox_B2");
        String fire_alam_b2 = "";
        if (dd_csdFlt_b2 + dd_csd_b2 + dd_cFireExt1_b2 + dd_cFireFltTraction_b2 + dd_cFireFltLVBox_b2 + dd_cFireFltHVBox_b2 +
                dd_cFireInPCE_b2 + dd_cFireLVBox_b2 + dd_cFireHVBox_b2 == 0) {
            fire_alam_b2 = "no_active";
        } else if (dd_csd_b2 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_b2 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_b2 = "red";
        }
        data.put("fire_alam_b2", fire_alam_b2);
        ////
        Long dd_csdFlt_c1 = getValue("port0x123","DD_CSDFlt_C1");
        Long dd_csd_c1 = getValue("port0x123","DD_CSD_C1");
        Long dd_cFireExt1_c1 =getValue("port0x123","DD_CFireExt1_C1");
        Long dd_cFireFltCVS_c1 = getValue("port0x123","DD_CFireFltCVS_C1");
        Long dd_cFireFltTraction_c1 = getValue("port0x123","DD_CFireFltTraction_C1");
        Long dd_cFireFltLVBox_c1 = getValue("port0x123","DD_CFireFltLVBox_C1");
        Long dd_cFireInPCE_c1 = getValue("port0x123","DD_CFireInPCE_C1");
        Long dd_cFireCVS_c1 = getValue("port0x123","DD_CFireCVS_C1");



        String fire_alam_c1 = "";
        if (dd_csdFlt_c1 + dd_csd_c1 + dd_cFireExt1_c1 + dd_cFireFltCVS_c1 + dd_cFireFltTraction_c1 + dd_cFireFltLVBox_c1 +
                dd_cFireInPCE_c1 + dd_cFireCVS_c1 == 0) {
            fire_alam_c1 = "no_active";
        } else if (dd_csdFlt_c1 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_c1 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_c1 = "red";
        }
        data.put("fire_alam_c1", fire_alam_c1);
        ///
        Long dd_csdFlt_c2 = getValue("port0x123","DD_CSDFlt_C2");
        Long dd_csd_c2 = getValue("port0x123","DD_CSD_C2");
        Long dd_cFireExt1_c2 = getValue("port0x123","DD_CFireExt1_C2");
        Long dd_cFireFltCVS_c2 = getValue("port0x123","DD_CFireFltCVS_C2");
        Long dd_cFireFltBat_c2 = getValue("port0x123","DD_CFireFltBat_C2");
        Long dd_cFireFltTraction_c2 = getValue("port0x123","DD_CFireFltTraction_C2");
        Long dd_cFireFltLVBox_c2 = getValue("port0x123","DD_CFireFltLVBox_C2");
        Long dd_cFireBat_c2 = getValue("port0x123","DD_CFireBat_C2");
        Long dd_cFireInPCE_c2 = getValue("port0x123","DD_CFireInPCE_C2");
        Long dd_cFireCVS_c2 = getValue("port0x123","DD_CFireCVS_C2");

        String fire_alam_c2 = "";
        if (dd_csdFlt_c2 + dd_csd_c2 + dd_cFireExt1_c2 + dd_cFireFltCVS_c2 + dd_cFireFltBat_c2 + dd_cFireFltTraction_c2 +
                dd_cFireFltLVBox_c2 + dd_cFireBat_c2 + dd_cFireInPCE_c2 + dd_cFireCVS_c2 == 0) {
            fire_alam_c2 = "no_active";
        } else if (dd_csdFlt_c2 == 1) {
            //At least one smoke detector or
            //fire detector faulty or fire
            //extinguisher active and no smoke
            //detector or fire detector activated
            fire_alam_c2 = "yellow";
        } else {
            //At least one smoke/fire detector is activated
            fire_alam_c2 = "red";
        }
        data.put("fire_alam_c2", fire_alam_c2);
        return data;
    }

    /**
     * 断路器
     * circuit breaker
     */
    private static Map circuitBreakerData() {

        return null;
    }

    /**
     * PECU
     */
    private static Map PECUData() {
        Map data = new HashMap();
        Long dd_cCallPECU1_a1 =    getValue("port0x123","DD_CCallPECU1_A1");
        Long dd_cCallPECU2_a1 =    getValue("port0x123","DD_CCallPECU2_A1");
        Long dd_cCallPECU3_a1 =    getValue("port0x123","DD_CCallPECU3_A1");
        Long dd_cCallPECU4_a1 =    getValue("port0x123","DD_CCallPECU4_A1");
        Long dd_cCallPECU5_a1 =    getValue("port0x123","DD_CCallPECU5_A1");
        Long dd_cCallPECU6_a1 =    getValue("port0x123","DD_CCallPECU6_A1");
        Long dd_cComPECU1Ok_a1 = getValue("port0x123","DD_CComPECU1Ok_A1");
        Long dd_cComPECU2Ok_a1 = getValue("port0x123","DD_CComPECU2Ok_A1");
        Long dd_cComPECU3Ok_a1 = getValue("port0x123","DD_CComPECU3Ok_A1");
        Long dd_cComPECU4Ok_a1 = getValue("port0x123","DD_CComPECU4Ok_A1");
        Long dd_cComPECU5Ok_a1 = getValue("port0x123","DD_CComPECU5Ok_A1");
        Long dd_cComPECU6Ok_a1 = getValue("port0x123","DD_CComPECU6Ok_A1");
        String call_a1 = "";
        Long call = dd_cCallPECU1_a1 + dd_cCallPECU2_a1 + dd_cCallPECU3_a1 + dd_cCallPECU4_a1 + dd_cCallPECU5_a1 + dd_cCallPECU6_a1;
        Long compecu = dd_cComPECU1Ok_a1 + +dd_cComPECU2Ok_a1 + dd_cComPECU3Ok_a1 + dd_cComPECU4Ok_a1 + dd_cComPECU5Ok_a1 + dd_cComPECU6Ok_a1;
        if (call+compecu == 0) {
            call_a1="no_active";
        } else if (call+compecu >=1) {
            call_a1="active";
        }
            data.put("call_a1",call_a1);

        Long dd_cCallPECU1_a2 =   getValue("port0x123","DD_CCallPECU1_A2");
        Long dd_cCallPECU2_a2 =   getValue("port0x123","DD_CCallPECU2_A2");
        Long dd_cCallPECU3_a2 =   getValue("port0x123","DD_CCallPECU3_A2");
        Long dd_cCallPECU4_a2 =   getValue("port0x123","DD_CCallPECU4_A2");
        Long dd_cCallPECU5_a2 =   getValue("port0x123","DD_CCallPECU5_A2");
        Long dd_cCallPECU6_a2 =   getValue("port0x123","DD_CCallPECU6_A2");
        Long dd_cComPECU1Ok_a2 =  getValue("port0x123","DD_CComPECU1Ok_A2");
        Long dd_cComPECU2Ok_a2 =  getValue("port0x123","DD_CComPECU2Ok_A2");
        Long dd_cComPECU3Ok_a2 =  getValue("port0x123","DD_CComPECU3Ok_A2");
        Long dd_cComPECU4Ok_a2 =  getValue("port0x123","DD_CComPECU4Ok_A2");
        Long dd_cComPECU5Ok_a2 =  getValue("port0x123","DD_CComPECU5Ok_A2");
        Long dd_cComPECU6Ok_a2 =  getValue("port0x123","DD_CComPECU6Ok_A2");
        String call_a2 = "";
        Long calla2 = dd_cCallPECU1_a2 + dd_cCallPECU2_a2 + dd_cCallPECU3_a2 + dd_cCallPECU4_a2 + dd_cCallPECU5_a2 + dd_cCallPECU6_a2;
        Long compecua2 = dd_cComPECU1Ok_a2 + +dd_cComPECU2Ok_a2 + dd_cComPECU3Ok_a2 + dd_cComPECU4Ok_a2 + dd_cComPECU5Ok_a2 + dd_cComPECU6Ok_a2;
        if (calla2+compecua2 == 0) {
            call_a2="no_active";
        } else if (call+compecu >= 1) {
            call_a2="active";
        }
        data.put("call_a2",call_a2);
        
        
        
        Long dd_cCallPECU1_b1 =  getValue("port0x123","DD_CCallPECU1_B1");
        Long dd_cCallPECU2_b1 =  getValue("port0x123","DD_CCallPECU2_B1");
        Long dd_cCallPECU3_b1 =  getValue("port0x123","DD_CCallPECU3_B1");
        Long dd_cCallPECU4_b1 =  getValue("port0x123","DD_CCallPECU4_B1");
        Long dd_cCallPECU5_b1 =  getValue("port0x123","DD_CCallPECU5_B1");
        Long dd_cComPECU1Ok_b1 =getValue("port0x123","DD_CComPECU1Ok_B1");
        Long dd_cComPECU2Ok_b1 =getValue("port0x123","DD_CComPECU2Ok_B1");
        Long dd_cComPECU3Ok_b1 =getValue("port0x123","DD_CComPECU3Ok_B1");
        Long dd_cComPECU4Ok_b1 =getValue("port0x123","DD_CComPECU4Ok_B1");
        Long dd_cComPECU5Ok_b1 =getValue("port0x123","DD_CComPECU5Ok_B1");
        String call_b1 = "";
        Long callb1 = dd_cCallPECU1_b1 + dd_cCallPECU2_b1 + dd_cCallPECU3_b1 + dd_cCallPECU4_b1 + dd_cCallPECU5_b1 ;
        Long compecub1 = dd_cComPECU1Ok_b1 + +dd_cComPECU2Ok_b1 + dd_cComPECU3Ok_b1 + dd_cComPECU4Ok_b1 + dd_cComPECU5Ok_b1 ;
        if (callb1+compecub1 == 0) {
            call_b1="no_active";
        } else if (call+compecu >= 1) {
            call_b1="active";
        }
        data.put("call_b1",call_b1);

        Long dd_cCallPECU1_b2 = getValue("port0x123","DD_CCallPECU1_B2");
        Long dd_cCallPECU2_b2 = getValue("port0x123","DD_CCallPECU2_B2");
        Long dd_cCallPECU3_b2 = getValue("port0x123","DD_CCallPECU3_B2");
        Long dd_cCallPECU4_b2 = getValue("port0x123","DD_CCallPECU4_B2");
        Long dd_cCallPECU5_b2 = getValue("port0x123","DD_CCallPECU5_B2");
        Long dd_cComPECU1Ok_b2 =getValue("port0x123","DD_CComPECU1Ok_B2");
        Long dd_cComPECU2Ok_b2 =getValue("port0x123","DD_CComPECU2Ok_B2");
        Long dd_cComPECU3Ok_b2 =getValue("port0x123","DD_CComPECU3Ok_B2");
        Long dd_cComPECU4Ok_b2 =getValue("port0x123","DD_CComPECU4Ok_B2");
        Long dd_cComPECU5Ok_b2 =getValue("port0x123","DD_CComPECU5Ok_B2");
        String call_b2 = "";
        Long callb2 = dd_cCallPECU1_b2 + dd_cCallPECU2_b2 + dd_cCallPECU3_b2 + dd_cCallPECU4_b2 + dd_cCallPECU5_b2 ;
        Long compecub2 = dd_cComPECU1Ok_b2 + +dd_cComPECU2Ok_b2 + dd_cComPECU3Ok_b2 + dd_cComPECU4Ok_b2 + dd_cComPECU5Ok_b2 ;
        if (callb2+compecub2 == 0) {
            call_b2="no_active";
        } else if (call+compecu >= 1) {
            call_b2="active";
        }
        data.put("call_b2",call_b2);

        Long dd_cCallPECU1_c1 =  getValue("port0x123","DD_CCallPECU1_C1");
        Long dd_cCallPECU2_c1 =  getValue("port0x123","DD_CCallPECU2_C1");
        Long dd_cCallPECU3_c1 =  getValue("port0x123","DD_CCallPECU3_C1");
        Long dd_cCallPECU4_c1 =  getValue("port0x123","DD_CCallPECU4_C1");
        Long dd_cCallPECU5_c1 =  getValue("port0x123","DD_CCallPECU5_C1");
        Long dd_cComPECU1Ok_c1 = getValue("port0x123","DD_CComPECU1Ok_C1");
        Long dd_cComPECU2Ok_c1 = getValue("port0x123","DD_CComPECU2Ok_C1");
        Long dd_cComPECU3Ok_c1 = getValue("port0x123","DD_CComPECU3Ok_C1");
        Long dd_cComPECU4Ok_c1 = getValue("port0x123","DD_CComPECU4Ok_C1");
        Long dd_cComPECU5Ok_c1 = getValue("port0x123","DD_CComPECU5Ok_C1");
        String call_c1 = "";
        Long callc1 = dd_cCallPECU1_c1 + dd_cCallPECU2_c1 + dd_cCallPECU3_c1 + dd_cCallPECU4_c1 + dd_cCallPECU5_c1 ;
        Long compecuc1 = dd_cComPECU1Ok_c1 + +dd_cComPECU2Ok_c1 + dd_cComPECU3Ok_c1 + dd_cComPECU4Ok_c1 + dd_cComPECU5Ok_c1 ;
        if (callc1+compecuc1 == 0) {
            call_c1="no_active";
        } else if (call+compecu >= 1) {
            call_c1="active";
        }
        data.put("call_c1",call_c1);

        Long dd_cCallPECU1_c2 = getValue("port0x123","DD_CCallPECU1_C2");
        Long dd_cCallPECU2_c2 = getValue("port0x123","DD_CCallPECU2_C2");
        Long dd_cCallPECU3_c2 = getValue("port0x123","DD_CCallPECU3_C2");
        Long dd_cCallPECU4_c2 = getValue("port0x123","DD_CCallPECU4_C2");
        Long dd_cCallPECU5_c2 = getValue("port0x123","DD_CCallPECU5_C2");
        Long dd_cComPECU1Ok_c2 =getValue("port0x123","DD_CComPECU1Ok_C2");
        Long dd_cComPECU2Ok_c2 =getValue("port0x123","DD_CComPECU2Ok_C2");
        Long dd_cComPECU3Ok_c2 =getValue("port0x123","DD_CComPECU3Ok_C2");
        Long dd_cComPECU4Ok_c2 =getValue("port0x123","DD_CComPECU4Ok_C2");
        Long dd_cComPECU5Ok_c2 =getValue("port0x123","DD_CComPECU5Ok_C2");
        String call_c2 = "";
        Long callc2 = dd_cCallPECU1_c2 + dd_cCallPECU2_c2 + dd_cCallPECU3_c2 + dd_cCallPECU4_c2 + dd_cCallPECU5_c2 ;
        Long compecuc2 = dd_cComPECU1Ok_c2 + +dd_cComPECU2Ok_c2 + dd_cComPECU3Ok_c2 + dd_cComPECU4Ok_c2 + dd_cComPECU5Ok_c2 ;
        if (callc2+compecuc2 == 0) {
            call_c2="no_active";
        } else if (call+compecu >= 1) {
            call_c2="active";
        }
        data.put("call_c2",call_c2);
        return data;
    }
}
