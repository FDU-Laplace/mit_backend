package com.missiongroup.starring.core.vehicleData;


import com.missiongroup.starring.core.cache.service.PortModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaintenanceDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map networkScreen = createNetworkScreen();
        data.put("networkScreen", networkScreen);
        Map mvbMediumAStatus = MVBMediumAStatus();
        data.put("mvbMediumAStatus", mvbMediumAStatus);
        Map mvbMediumBStatus = MVBMediumBStatus();
        data.put("mvbMediumBStatus", mvbMediumBStatus);
        Map energyConsumptionData = energyConsumptionData();
        data.put("energyConsumptionData", energyConsumptionData);
        Map selfTestResult = SelfTestResult();
        data.put("selfTestResult", selfTestResult);
        Map brakeTest = brakeTest();
        data.put("brakeTest", brakeTest);
        Map softwareVersion = softwareVersion();
        data.put("softwareVersion", softwareVersion);
        Map riomData = riomData();
        data.put("riom", riomData);
        return data;
    }

    /**
     * NetworkScreen
     */
    private static Map createNetworkScreen() {
        Map<String, Object> data = new HashMap<>();
        Long MPU_CMPU1Oper = getValue("port0x100", "MPU_CMPU1Oper");
        data.put("A1_MPU", getStatus(MPU_CMPU1Oper));
        Long MPU_CMPU2Oper = getValue("port0x100", "MPU_CMPU2Oper");
        data.put("A2_MPU", getStatus(MPU_CMPU2Oper));
        Long DD_CDD1Oper = getValue("port0x127", "DD_CDD1Oper");
        data.put("A1_DDU", getStatus(DD_CDD1Oper));
        Long DD_CDD2Oper = getValue("port0x128", "DD_CDD2Oper");
        data.put("A2_DDU", getStatus(DD_CDD2Oper));
        Long DD_CACE1Oper = getValue("port0x127", "DD_CACE1Oper");
        data.put("A1_ACE", getStatus(DD_CACE1Oper));
        Long DD_CACE2Oper = getValue("port0x127", "DD_CACE2Oper");
        data.put("C2_ACE", getStatus(DD_CACE2Oper));
        Long DD_CACE3Oper = getValue("port0x128", "DD_CACE3Oper");
        data.put("A2_ACE", getStatus(DD_CACE3Oper));
        Long DD_CATC1OK = getValue("port0x120", "DD_CATC1OK");
        data.put("A1_ATC", getStatus(DD_CATC1OK));
        Long DD_CATC2OK = getValue("port0x120", "DD_CATC2OK");
        data.put("A2_ATC", getStatus(DD_CATC2OK));

        Long DD_CGW1ComOK = getValue("port0x128", "DD_CGW1ComOK");
        data.put("A1_NTW-GW", getStatus(DD_CGW1ComOK));
        Long DD_CGW2ComOK = getValue("port0x128", "DD_CGW2ComOK");
        data.put("A2_NTW-GW", getStatus(DD_CGW2ComOK));
        Long DD_CDCU7Oper_A1 = getValue("port0x127", "DD_CDCU7Oper_A1");
        Long DD_CDCU8Oper_A1 = getValue("port0x127", "DD_CDCU8Oper_A1");
        data.put("A1_DCU", getStatus(DD_CDCU8Oper_A1, DD_CDCU7Oper_A1));
        Long DD_CDCU7Oper_B1 = getValue("port0x127", "DD_CDCU7Oper_B1");
        Long DD_CDCU8Oper_B1 = getValue("port0x127", "DD_CDCU8Oper_B1");
        data.put("B1_DCU", getStatus(DD_CDCU7Oper_B1, DD_CDCU8Oper_B1));
        Long DD_CDCU7Oper_C1 = getValue("port0x127", "DD_CDCU7Oper_C1");
        Long DD_CDCU8Oper_C1 = getValue("port0x127", "DD_CDCU8Oper_C1");
        data.put("C1_DCU", getStatus(DD_CDCU7Oper_C1, DD_CDCU8Oper_C1));
        Long DD_CDCU7Oper_A2 = getValue("port0x128", "DD_CDCU7Oper_A2");
        Long DD_CDCU8Oper_A2 = getValue("port0x128", "DD_CDCU8Oper_A2");
        data.put("A2_DCU", getStatus(DD_CDCU8Oper_A2, DD_CDCU7Oper_A2));
        Long DD_CDCU7Oper_B2 = getValue("port0x127", "DD_CDCU7Oper_B2");
        Long DD_CDCU8Oper_B2 = getValue("port0x127", "DD_CDCU8Oper_B2");
        data.put("B2_DCU", getStatus(DD_CDCU7Oper_B2, DD_CDCU8Oper_B2));
        Long DD_CDCU7Oper_C2 = getValue("port0x127", "DD_CDCU7Oper_C2");
        Long DD_CDCU8Oper_C2 = getValue("port0x127", "DD_CDCU8Oper_C2");
        data.put("C2_DCU", getStatus(DD_CDCU7Oper_C2, DD_CDCU8Oper_C2));
        Long DD_CPIS1Oper = getValue("port0x127", "DD_CPIS1Oper");
        data.put("A1_PAPIS", getStatus(DD_CPIS1Oper));

        Long DD_CPIS2Oper = getValue("port0x128", "DD_CPIS2Oper");
        data.put("A2_PAPIS", getStatus(DD_CPIS2Oper));
        Long DD_CVAC1Oper = getValue("port0x127", "DD_CVAC1Oper");
        Long DD_CVAC2Oper = getValue("port0x127", "DD_CVAC2Oper");
        Long DD_CVAC3Oper = getValue("port0x127", "DD_CVAC3Oper");
        Long DD_CVAC4Oper = getValue("port0x127", "DD_CVAC4Oper");
        Long DD_CVAC5Oper = getValue("port0x128", "DD_CVAC5Oper");
        Long DD_CVAC6Oper = getValue("port0x128", "DD_CVAC6Oper");
        data.put("A1_HAVC", getStatus(DD_CVAC1Oper));
        data.put("B1_HAVC", getStatus(DD_CVAC2Oper));
        data.put("C1_HAVC", getStatus(DD_CVAC3Oper));
        data.put("A2_HAVC", getStatus(DD_CVAC4Oper));
        data.put("B2_HAVC", getStatus(DD_CVAC5Oper));
        data.put("C2_HAVC", getStatus(DD_CVAC6Oper));

        Long DD_CBMS1Oper = getValue("port0x127", "DD_CBMS1Oper");
        data.put("A1_BMS", getStatus(DD_CBMS1Oper));
        Long DD_CBMS2Oper = getValue("port0x128", "DD_CBMS2Oper");
        data.put("A2_BMS", getStatus(DD_CBMS2Oper));


        Long DD_CRIOM1Oper_A1 = getValue("port0x127", "DD_CRIOM1Oper_A1");
        data.put("A1_RIOM1", getStatus(DD_CRIOM1Oper_A1));
        Long DD_CRIOM2Oper_A1 = getValue("port0x127", "DD_CRIOM2Oper_A1");
        data.put("A1_RIOM2", getStatus(DD_CRIOM2Oper_A1));
        Long DD_CRIOM3Oper_A1 = getValue("port0x127", "DD_CRIOM3Oper_A1");
        data.put("A1_RIOM3", getStatus(DD_CRIOM3Oper_A1));
        Long DD_CRIOM4Oper_A1 = getValue("port0x127", "DD_CRIOM4Oper_A1");
        data.put("A1_RIOM4", getStatus(DD_CRIOM4Oper_A1));
        Long DD_CRIOM5Oper_A1 = getValue("port0x127", "DD_CRIOM5Oper_A1");
        data.put("A1_RIOM5", getStatus(DD_CRIOM5Oper_A1));

        Long DD_CRIOM1Oper_B1 = getValue("port0x127", "DD_CRIOM1Oper_B1");
        data.put("B1_RIOM1", getStatus(DD_CRIOM1Oper_B1));
        Long DD_CRIOM2Oper_B1 = getValue("port0x127", "DD_CRIOM2Oper_B1");
        data.put("B1_RIOM2", getStatus(DD_CRIOM2Oper_B1));

        Long DD_CRIOM1Oper_C1 = getValue("port0x127", "DD_CRIOM1Oper_C1");
        data.put("C1_RIOM1", getStatus(DD_CRIOM1Oper_C1));
        Long DD_CRIOM2Oper_C1 = getValue("port0x127", "DD_CRIOM2Oper_C1");
        data.put("C1_RIOM2", getStatus(DD_CRIOM2Oper_C1));

        Long DD_CRIOM1Oper_C2 = getValue("port0x127", "DD_CRIOM1Oper_C2");
        data.put("C2_RIOM1", getStatus(DD_CRIOM1Oper_C2));
        Long DD_CRIOM2Oper_C2 = getValue("port0x127", "DD_CRIOM2Oper_C2");
        data.put("C2_RIOM2", getStatus(DD_CRIOM2Oper_C2));

        Long DD_CRIOM1Oper_B2 = getValue("port0x127", "DD_CRIOM1Oper_B2");
        data.put("B2_RIOM1", getStatus(DD_CRIOM1Oper_B2));
        Long DD_CRIOM2Oper_B2 = getValue("port0x127", "DD_CRIOM2Oper_B2");
        data.put("B2_RIOM2", getStatus(DD_CRIOM2Oper_B2));


        Long DD_CRIOM1Oper_A2 = getValue("port0x128", "DD_CRIOM1Oper_A2");
        data.put("A2_RIOM1", getStatus(DD_CRIOM1Oper_A2));
        Long DD_CRIOM2Oper_A2 = getValue("port0x128", "DD_CRIOM2Oper_A2");
        data.put("A2_RIOM2", getStatus(DD_CRIOM2Oper_A2));
        Long DD_CRIOM3Oper_A2 = getValue("port0x128", "DD_CRIOM3Oper_A2");
        data.put("A2_RIOM3", getStatus(DD_CRIOM3Oper_A2));
        Long DD_CRIOM4Oper_A2 = getValue("port0x128", "DD_CRIOM4Oper_A2");
        data.put("A2_RIOM4", getStatus(DD_CRIOM4Oper_A2));
        Long DD_CRIOM5Oper_A2 = getValue("port0x128", "DD_CRIOM5Oper_A2");
        data.put("A2_RIOM5", getStatus(DD_CRIOM5Oper_A2));

        Long DD_CLCU1Oper = getValue("port0x127", "DD_CLCU1Oper");
        data.put("A1_LCU", getStatus(DD_CLCU1Oper));
        Long DD_CLCU2Oper = getValue("port0x128", "DD_CLCU2Oper");
        data.put("A2_LCU", getStatus(DD_CLCU2Oper));

        Long DD_CBBO1Oper = getValue("port0x127", "DD_CBBO1Oper");
        Long DD_CBBO2Oper = getValue("port0x128", "DD_CBBO2Oper");
        data.put("A1_BBO", getStatus(DD_CBBO1Oper));
        data.put("A2_BBO", getStatus(DD_CBBO2Oper));
        Long DD_CBCE1Oper = getValue("port0x127", "DD_CBCE1Oper");
        Long DD_CBCE2Oper = getValue("port0x127", "DD_CBCE2Oper");
        Long DD_CBCE3Oper = getValue("port0x127", "DD_CBCE3Oper");
        Long DD_CBCE4Oper = getValue("port0x128", "DD_CBCE4Oper");
        data.put("A1_BRK-GW", getStatus(DD_CBCE1Oper));
        data.put("C1_BRK-GW", getStatus(DD_CBCE2Oper));
        data.put("C2_BRK-GW", getStatus(DD_CBCE3Oper));
        data.put("A2_BRK-GW", getStatus(DD_CBCE4Oper));

        Long DD_CFSD1Oper = getValue("port0x127", "DD_CFSD1Oper");
        Long DD_CFSD2Oper = getValue("port0x128", "DD_CFSD2Oper");
        data.put("A1_FSD", getStatus(DD_CFSD1Oper));
        data.put("A2_FSD", getStatus(DD_CFSD2Oper));

        Long DD_CPCE1Oper = getValue("port0x127", "DD_CPCE1Oper");
        Long DD_CPCE2Oper = getValue("port0x127", "DD_CPCE2Oper");
        Long DD_CPCE3Oper = getValue("port0x127", "DD_CPCE3Oper");
        Long DD_CPCE4Oper = getValue("port0x127", "DD_CPCE4Oper");
        data.put("B1_PCE", getStatus(DD_CPCE1Oper));
        data.put("C1_PCE", getStatus(DD_CPCE2Oper));
        data.put("C2_PCE", getStatus(DD_CPCE3Oper));
        data.put("B2_PCE", getStatus(DD_CPCE4Oper));


        Long DD_CEGM1Oper = getValue("port0x127", "DD_CEGM1Oper");
        Long DD_CEGM2Oper = getValue("port0x128", "DD_CEGM2Oper");
        data.put("B1_EGM", getStatus(DD_CEGM1Oper));
        data.put("B2_EGM", getStatus(DD_CEGM2Oper));
        Long DD_CPMSOper = getValue("port0x127", "DD_CPMSOper");
        data.put("B1_PMS", getStatus(DD_CPMSOper));


        return data;
    }

    private static Map MVBMediumAStatus() {
        Map<String, Object> data = new HashMap<>();
        data.put("MPU1", getValue("port0xa30", "_IMPU1Medium1OK"));
        data.put("MPU2", getValue("port0xa30", "_IMPU2Medium1OK"));
        data.put("GTW1", getValue("port0xa30", "_IGTW1Medium1OK"));
        data.put("GTW2", getValue("port0xa30", "_IGTW2Medium1OK"));
        data.put("ATC1", getValue("port0xa30", "_IATC1Medium1OK"));
        data.put("ATC2", getValue("port0xa30", "_IATC2Medium1OK"));
        data.put("ACE1", getValue("port0xa30", "_IACE1Medium1OK"));
        data.put("ACE2", getValue("port0xa30", "_IACE2Medium1OK"));
        data.put("ACE3", getValue("port0xa30", "_IACE3Medium1OK"));
        data.put("BCE1", getValue("port0xa30", "_IBCE1Medium1OK"));
        data.put("BCE2", getValue("port0xa30", "_IBCE2Medium1OK"));
        data.put("BCE3", getValue("port0xa30", "_IBCE3Medium1OK"));
        data.put("BCE4", getValue("port0xa30", "_IBCE4Medium1OK"));
        data.put("PCE1", getValue("port0xa30", "_IPCE1Medium1OK"));
        data.put("PCE2", getValue("port0xa30", "_IPCE2Medium1OK"));
        data.put("PCE3", getValue("port0xa30", "_IPCE3Medium1OK"));
        data.put("PCE4", getValue("port0xa30", "_IPCE4Medium1OK"));
        data.put("PIS1", getValue("port0xa30", "_IPIS1Medium1OK"));
        data.put("PIS2", getValue("port0xa30", "_IPIS2Medium1OK"));
        data.put("VAC1", getValue("port0xa30", "_IVAC1Medium1OK"));
        data.put("VAC2", getValue("port0xa30", "_IVAC2Medium1OK"));
        data.put("VAC3", getValue("port0xa30", "_IVAC3Medium1OK"));
        data.put("VAC4", getValue("port0xa30", "_IVAC4Medium1OK"));
        data.put("VAC5", getValue("port0xa30", "_IVAC5Medium1OK"));
        data.put("VAC6", getValue("port0xa30", "_IVAC6Medium1OK"));
        data.put("PMS", getValue("port0xa30", "_IPMSMedium1OK"));
        data.put("BMS1", getValue("port0xa30", "_IBMS1Medium1OK"));
        data.put("BMS2", getValue("port0xa30", "_IBMS2Medium1OK"));
        data.put("BBO1", getValue("port0xa30", "_IBBO1Medium1OK"));
        data.put("BBO2", getValue("port0xa30", "_IBBO2Medium1OK"));
        data.put("EGM1", getValue("port0xa30", "_IEGM1Medium1OK"));
        data.put("EGM2", getValue("port0xa30", "_IEGM2Medium1OK"));
        data.put("DCU7_A1", getValue("port0xa30", "_IDCU7A1Medium1OK"));
        data.put("DCU8_A1", getValue("port0xa30", "_IDCU8A1Medium1OK"));
        data.put("DCU7_B1", getValue("port0xa30", "_IDCU7B1Medium1OK"));
        data.put("DCU8_B1", getValue("port0xa30", "_IDCU8B1Medium1OK"));
        data.put("DCU7_C1", getValue("port0xa30", "_IDCU7C1Medium1OK"));
        data.put("DCU8_C1", getValue("port0xa30", "_IDCU8C1Medium1OK"));
        data.put("DCU7_C2", getValue("port0xa30", "_IDCU7C2Medium1OK"));
        data.put("DCU8_C2", getValue("port0xa30", "_IDCU8C2Medium1OK"));
        data.put("DCU7_B2", getValue("port0xa30", "_IDCU7B2Medium1OK"));
        data.put("DCU8_B2", getValue("port0xa30", "_IDCU8B2Medium1OK"));
        data.put("DCU7_A2", getValue("port0xa30", "_IDCU7A2Medium1OK"));
        data.put("DCU8_A2", getValue("port0xa30", "_IDCU8A2Medium1OK"));
        data.put("DCM", getValue("port0xa30", "_IDCMMedium1OK"));
        data.put("ERM1", getValue("port0xa30", "_IERM1Medium1OK"));
        data.put("ERM2", getValue("port0xa30", "_IERM2Medium1OK"));


        data.put("RIOM3_A1", getValue("port0x128", "DD_CRIOM3Medium1OK_A1"));
        data.put("RIOM4_A1", getValue("port0x128", "DD_CRIOM4Medium1OK_A1"));
        data.put("RIOM1_A1", getValue("port0x128", "DD_CRIOM1Medium1OK_A1"));
        data.put("RIOM5_A1", getValue("port0x128", "DD_CRIOM5Medium1OK_A1"));
        data.put("RIOM2_A1", getValue("port0x128", "DD_CRIOM2Medium1OK_A1"));
        data.put("RIOM5_B1", getValue("port0x128", "DD_CRIOM1Medium1OK_B1"));
        data.put("RIOM2_B1", getValue("port0x128", "DD_CRIOM2Medium1OK_B1"));
        data.put("RIOM5_C1", getValue("port0x128", "DD_CRIOM1Medium1OK_C1"));
        data.put("RIOM2_C1", getValue("port0x128", "DD_CRIOM2Medium1OK_C1"));
        data.put("RIOM3_A2", getValue("port0x128", "DD_CRIOM3Medium1OK_A2"));
        data.put("RIOM4_A2", getValue("port0x128", "DD_CRIOM4Medium1OK_A2"));
        data.put("RIOM1_A2", getValue("port0x128", "DD_CRIOM1Medium1OK_A2"));
        data.put("RIOM5_A2", getValue("port0x128", "DD_CRIOM5Medium1OK_A2"));
        data.put("RIOM2_A2", getValue("port0x128", "DD_CRIOM2Medium1OK_A2"));
        data.put("RIOM5_B2", getValue("port0x128", "DD_CRIOM1Medium1OK_B2"));
        data.put("RIOM2_B2", getValue("port0x128", "DD_CRIOM2Medium1OK_B2"));
        data.put("RIOM5_C2", getValue("port0x128", "DD_CRIOM1Medium1OK_C2"));
        data.put("RIOM2_C2", getValue("port0x128", "DD_CRIOM2Medium1OK_C2"));
        return data;
    }

    private static Map MVBMediumBStatus() {
        Map<String, Object> data = new HashMap<>();
        data.put("MPU1", getValue("port0xa30", "_IMPU1Medium2OK"));
        data.put("MPU2", getValue("port0xa30", "_IMPU2Medium2OK"));
        data.put("GTW1", getValue("port0xa30", "_IGTW1Medium2OK"));
        data.put("GTW2", getValue("port0xa30", "_IGTW2Medium2OK"));
        data.put("ATC1", getValue("port0xa30", "_IATC1Medium2OK"));
        data.put("ATC2", getValue("port0xa30", "_IATC2Medium2OK"));
        data.put("ACE1", getValue("port0xa30", "_IACE1Medium2OK"));
        data.put("ACE2", getValue("port0xa30", "_IACE2Medium2OK"));
        data.put("ACE3", getValue("port0xa30", "_IACE3Medium2OK"));
        data.put("BCE1", getValue("port0xa30", "_IBCE1Medium2OK"));
        data.put("BCE2", getValue("port0xa30", "_IBCE2Medium2OK"));
        data.put("BCE3", getValue("port0xa30", "_IBCE3Medium2OK"));
        data.put("BCE4", getValue("port0xa30", "_IBCE4Medium2OK"));
        data.put("PCE1", getValue("port0xa30", "_IPCE1Medium2OK"));
        data.put("PCE2", getValue("port0xa30", "_IPCE2Medium2OK"));
        data.put("PCE3", getValue("port0xa30", "_IPCE3Medium2OK"));
        data.put("PCE4", getValue("port0xa30", "_IPCE4Medium2OK"));
        data.put("PIS1", getValue("port0xa30", "_IPIS1Medium2OK"));
        data.put("PIS2", getValue("port0xa30", "_IPIS2Medium2OK"));
        data.put("VAC1", getValue("port0xa30", "_IVAC1Medium2OK"));
        data.put("VAC2", getValue("port0xa30", "_IVAC2Medium2OK"));
        data.put("VAC3", getValue("port0xa30", "_IVAC3Medium2OK"));
        data.put("VAC4", getValue("port0xa30", "_IVAC4Medium2OK"));
        data.put("VAC5", getValue("port0xa30", "_IVAC5Medium2OK"));
        data.put("VAC6", getValue("port0xa30", "_IVAC6Medium2OK"));
        data.put("PMS", getValue("port0xa30", "_IPMSMedium2OK"));
        data.put("BMS1", getValue("port0xa30", "_IBMS1Medium2OK"));
        data.put("BMS2", getValue("port0xa30", "_IBMS2Medium2OK"));
        data.put("BBO1", getValue("port0xa30", "_IBBO1Medium2OK"));
        data.put("BBO2", getValue("port0xa30", "_IBBO2Medium2OK"));
        data.put("EGM1", getValue("port0xa30", "_IEGM1Medium2OK"));
        data.put("EGM2", getValue("port0xa30", "_IEGM2Medium2OK"));
        data.put("DCU7_A1", getValue("port0xa30", "_IDCU7A1Medium2OK"));
        data.put("DCU8_A1", getValue("port0xa30", "_IDCU8A1Medium2OK"));
        data.put("DCU7_B1", getValue("port0xa30", "_IDCU7B1Medium2OK"));
        data.put("DCU8_B1", getValue("port0xa30", "_IDCU8B1Medium2OK"));
        data.put("DCU7_C1", getValue("port0xa30", "_IDCU7C1Medium2OK"));
        data.put("DCU8_C1", getValue("port0xa30", "_IDCU8C1Medium2OK"));
        data.put("DCU7_C2", getValue("port0xa30", "_IDCU7C2Medium2OK"));
        data.put("DCU8_C2", getValue("port0xa30", "_IDCU8C2Medium2OK"));
        data.put("DCU7_B2", getValue("port0xa30", "_IDCU7B2Medium2OK"));
        data.put("DCU8_B2", getValue("port0xa30", "_IDCU8B2Medium2OK"));
        data.put("DCU7_A2", getValue("port0xa30", "_IDCU7A2Medium2OK"));
        data.put("DCU8_A2", getValue("port0xa30", "_IDCU8A2Medium2OK"));
        data.put("DCM", getValue("port0xa30", "_IDCMMedium2OK"));
        data.put("ERM1", getValue("port0xa30", "_IERM1Medium2OK"));
        data.put("ERM2", getValue("port0xa30", "_IERM2Medium2OK"));

        data.put("RIOM3_A1", getValue("port0x128", "DD_CRIOM3Medium2OK_A1"));
        data.put("RIOM4_A1", getValue("port0x128", "DD_CRIOM4Medium2OK_A1"));
        data.put("RIOM1_A1", getValue("port0x128", "DD_CRIOM1Medium2OK_A1"));
        data.put("RIOM5_A1", getValue("port0x128", "DD_CRIOM5Medium2OK_A1"));
        data.put("RIOM2_A1", getValue("port0x128", "DD_CRIOM2Medium2OK_A1"));
        data.put("RIOM5_B1", getValue("port0x128", "DD_CRIOM1Medium2OK_B1"));
        data.put("RIOM2_B1", getValue("port0x128", "DD_CRIOM2Medium2OK_B1"));
        data.put("RIOM5_C1", getValue("port0x128", "DD_CRIOM1Medium2OK_C1"));
        data.put("RIOM2_C1", getValue("port0x128", "DD_CRIOM2Medium2OK_C1"));

        data.put("RIOM3_A2", getValue("port0x128", "DD_CRIOM3Medium2OK_A2"));
        data.put("RIOM4_A2", getValue("port0x128", "DD_CRIOM4Medium2OK_A2"));
        data.put("RIOM1_A2", getValue("port0x128", "DD_CRIOM1Medium2OK_A2"));
        data.put("RIOM5_A2", getValue("port0x128", "DD_CRIOM5Medium2OK_A2"));
        data.put("RIOM2_A2", getValue("port0x128", "DD_CRIOM2Medium2OK_A2"));
        data.put("RIOM5_B2", getValue("port0x128", "DD_CRIOM1Medium2OK_B2"));
        data.put("RIOM2_B2", getValue("port0x128", "DD_CRIOM2Medium2OK_B2"));
        data.put("RIOM5_C2", getValue("port0x128", "DD_CRIOM1Medium2OK_C2"));
        data.put("RIOM2_C2", getValue("port0x128", "DD_CRIOM2Medium2OK_C2"));
        return data;
    }


    /**
     * energy Consumption Data
     */
    private static Map energyConsumptionData() {
        Map<String, Object> data = new HashMap<>();
        data.put("TractionConsumedEnergy", getValue("port0x133", "DD_CHVSEngyConsPCE"));
        data.put("BrakeResistorConsumedEnergy", getValue("port0x133", "DD_CHVSBrkRestEngy"));
        data.put("HVACConsumedEnergy", getValue("port0x133", "DD_CHVSEngyConsVAC"));
        data.put("CVSConsumedEnergy", getValue("port0x133", "DD_CHVSEngyConsACE"));
        data.put("TotalEnergyRegenerated", getValue("port0x133", "DD_CHVSEngyReg"));
        //data.put("TotalEnergyConsumed", getValue("port0x120", "DD_CHVSTotalEngyEMG"));
        data.put("TotalEnergyConsumed", 0);
        //Long dd_cKeySw_a2 = getValue("port0x961", "EGMi_ITotTracRegEngy");
        return data;
    }


    /**
     * Self-Test Result
     */
    private static Map SelfTestResult() {
        Map<String, Object> data = new HashMap<>();
        Long DD_CACE1SelfTestInProg = getValue("port0x132", "DD_CACE1SelfTestInProg");
        Long DD_CACE1SelfTestDone = getValue("port0x132", "DD_CACE1SelfTestDone");
        Long DD_CACE1SelfTesResults = getValue("port0x132", "DD_CACE1SelfTesResults");
        String ACE1 = getSelfStatus(DD_CACE1SelfTestInProg, DD_CACE1SelfTestDone, DD_CACE1SelfTesResults);
        data.put("ACE_A1", ACE1);
        Long DD_CACE2SelfTestInProg = getValue("port0x132", "DD_CACE2SelfTestInProg");
        Long DD_CACE2SelfTestDone = getValue("port0x132", "DD_CACE2SelfTestDone");
        Long DD_CACE2SelfTesResults = getValue("port0x132", "DD_CACE2SelfTesResults");
        String ACE2 = getSelfStatus(DD_CACE2SelfTestInProg, DD_CACE2SelfTestDone, DD_CACE2SelfTesResults);
        data.put("ACE_C2", ACE2);

        Long DD_CACE3SelfTestInProg = getValue("port0x132", "DD_CACE3SelfTestInProg");
        Long DD_CACE3SelfTestDone = getValue("port0x132", "DD_CACE3SelfTestDone");
        Long DD_CACE3SelfTesResults = getValue("port0x132", "DD_CACE3SelfTesResults");
        String ACE3 = getSelfStatus(DD_CACE3SelfTestInProg, DD_CACE3SelfTestDone, DD_CACE3SelfTesResults);
        data.put("ACE_A2", ACE3);

        Long DD_CATCSelfTestInProg = getValue("port0x132", "DD_CATCSelfTestInProg");
        Long DD_CATCSelfTestDone = getValue("port0x132", "DD_CATCSelfTestDone");
        Long DD_CATCSelfTesResults = getValue("port0x132", "DD_CATCSelfTesResults");
        String ATC1 = getSelfStatus(DD_CATCSelfTestInProg, DD_CATCSelfTestDone, DD_CATCSelfTesResults);
        data.put("ATC_A1", ATC1);
        data.put("ATC_A2", ATC1);

        Long DD_CBBO1SelfTestInProg = getValue("port0x132", "DD_CBBO1SelfTestInProg");
        Long DD_CBBO1SelfTestDone = getValue("port0x132", "DD_CBBO1SelfTestDone");
        Long DD_CBBO1SelfTesResults = getValue("port0x132", "DD_CBBO1SelfTesResults");
        String BBO1 = getSelfStatus(DD_CBBO1SelfTestInProg, DD_CBBO1SelfTestDone, DD_CBBO1SelfTesResults);
        data.put("BBO_A1", BBO1);

        Long DD_CBBO2SelfTestInProg = getValue("port0x132", "DD_CBBO2SelfTestInProg");
        Long DD_CBBO2SelfTestDone = getValue("port0x132", "DD_CBBO2SelfTestDone");
        Long DD_CBBO2SelfTesResults = getValue("port0x132", "DD_CBBO2SelfTesResults");
        String BBO2 = getSelfStatus(DD_CBBO2SelfTestInProg, DD_CBBO2SelfTestDone, DD_CBBO2SelfTesResults);
        data.put("BBO_A2", BBO2);
        Long DD_CDCU1SelfTestInProg_A1 = getValue("port0x132", "DD_CDCU1SelfTestInProg_A1");
        Long DD_CDCU1SelfTestDone_A1 = getValue("port0x132", "DD_CDCU1SelfTestDone_A1");
        Long DD_CDCU1SelfTesResults_A1 = getValue("port0x132", "DD_CDCU1SelfTesResults_A1");
        Long DD_CDCU2SelfTestInProg_A1 = getValue("port0x132", "DD_CDCU2SelfTestInProg_A1");
        Long DD_CDCU2SelfTestDone_A1 = getValue("port0x132", "DD_CDCU2SelfTestDone_A1");
        Long DD_CDCU2SelfTesResults_A1 = getValue("port0x133", "DD_CDCU2SelfTesResults_A1");
        String DCU1 = getSelfStatus(DD_CDCU1SelfTestInProg_A1, DD_CDCU1SelfTestDone_A1, DD_CDCU1SelfTesResults_A1, DD_CDCU2SelfTestInProg_A1, DD_CDCU2SelfTestDone_A1, DD_CDCU2SelfTesResults_A1);
        data.put("DCU_A1", DCU1);

        Long DD_CDCU1SelfTestInProg_B1 = getValue("port0x132", "DD_CDCU1SelfTestInProg_B1");
        Long DD_CDCU1SelfTestDone_B1 = getValue("port0x132", "DD_CDCU1SelfTestDone_B1");
        Long DD_CDCU1SelfTesResults_B1 = getValue("port0x133", "DD_CDCU1SelfTesResults_B1");
        Long DD_CDCU2SelfTestInProg_B1 = getValue("port0x132", "DD_CDCU2SelfTestInProg_B1");
        Long DD_CDCU2SelfTestDone_B1 = getValue("port0x132", "DD_CDCU2SelfTestDone_B1");
        Long DD_CDCU2SelfTesResults_B1 = getValue("port0x133", "DD_CDCU2SelfTesResults_B1");
        String DCU2 = getSelfStatus(DD_CDCU1SelfTestInProg_B1, DD_CDCU1SelfTestDone_B1, DD_CDCU1SelfTesResults_B1, DD_CDCU2SelfTestInProg_B1, DD_CDCU2SelfTestDone_B1, DD_CDCU2SelfTesResults_B1);
        data.put("DCU_B1", DCU2);

        Long DD_CDCU1SelfTestInProg_C1 = getValue("port0x132", "DD_CDCU1SelfTestInProg_C1");
        Long DD_CDCU1SelfTestDone_C1 = getValue("port0x132", "DD_CDCU1SelfTestDone_C1");
        Long DD_CDCU1SelfTesResults_C1 = getValue("port0x133", "DD_CDCU1SelfTesResults_C1");
        Long DD_CDCU2SelfTestInProg_C1 = getValue("port0x132", "DD_CDCU2SelfTestInProg_C1");
        Long DD_CDCU2SelfTestDone_C1 = getValue("port0x132", "DD_CDCU2SelfTestDone_C1");
        Long DD_CDCU2SelfTesResults_C1 = getValue("port0x133", "DD_CDCU2SelfTesResults_C1");
        String DCU3 = getSelfStatus(DD_CDCU1SelfTestInProg_C1, DD_CDCU1SelfTestDone_C1, DD_CDCU1SelfTesResults_C1, DD_CDCU2SelfTestInProg_C1, DD_CDCU2SelfTestDone_C1, DD_CDCU2SelfTesResults_C1);
        data.put("DCU_C1", DCU3);
        Long DD_CDCU1SelfTestInProg_C2 = getValue("port0x132", "DD_CDCU1SelfTestInProg_C2");
        Long DD_CDCU1SelfTestDone_C2 = getValue("port0x132", "DD_CDCU1SelfTestDone_C2");
        Long DD_CDCU1SelfTesResults_C2 = getValue("port0x133", "DD_CDCU1SelfTesResults_C2");
        Long DD_CDCU2SelfTestInProg_C2 = getValue("port0x132", "DD_CDCU2SelfTestInProg_C2");
        Long DD_CDCU2SelfTestDone_C2 = getValue("port0x132", "DD_CDCU2SelfTestDone_C2");
        Long DD_CDCU2SelfTesResults_C2 = getValue("port0x133", "DD_CDCU2SelfTesResults_C2");
        String DCU4 = getSelfStatus(DD_CDCU1SelfTestInProg_C2, DD_CDCU1SelfTestDone_C2, DD_CDCU1SelfTesResults_C2, DD_CDCU2SelfTestInProg_C2, DD_CDCU2SelfTestDone_C2, DD_CDCU2SelfTesResults_C2);
        data.put("DCU_C2", DCU4);

        Long DD_CDCU1SelfTestInProg_B2 = getValue("port0x132", "DD_CDCU1SelfTestInProg_B2");
        Long DD_CDCU1SelfTestDone_B2 = getValue("port0x132", "DD_CDCU1SelfTestDone_B2");
        Long DD_CDCU1SelfTesResults_B2 = getValue("port0x133", "DD_CDCU1SelfTesResults_B2");
        Long DD_CDCU2SelfTestInProg_B2 = getValue("port0x132", "DD_CDCU2SelfTestInProg_B2");
        Long DD_CDCU2SelfTestDone_B2 = getValue("port0x132", "DD_CDCU2SelfTestDone_B2");
        Long DD_CDCU2SelfTesResults_B2 = getValue("port0x133", "DD_CDCU2SelfTesResults_B2");
        String DCU5 = getSelfStatus(DD_CDCU1SelfTestInProg_B2, DD_CDCU1SelfTestDone_B2, DD_CDCU1SelfTesResults_B2, DD_CDCU2SelfTestInProg_B2, DD_CDCU2SelfTestDone_B2, DD_CDCU2SelfTesResults_B2);
        data.put("DCU_B2", DCU5);
        Long DD_CDCU1SelfTestInProg_A2 = getValue("port0x132", "DD_CDCU1SelfTestInProg_A2");
        Long DD_CDCU1SelfTestDone_A2 = getValue("port0x132", "DD_CDCU1SelfTestDone_A2");
        Long DD_CDCU1SelfTesResults_A2 = getValue("port0x133", "DD_CDCU1SelfTesResults_A2");
        Long DD_CDCU2SelfTestInProg_A2 = getValue("port0x132", "DD_CDCU2SelfTestInProg_A2");
        Long DD_CDCU2SelfTestDone_A2 = getValue("port0x132", "DD_CDCU2SelfTestDone_A2");
        Long DD_CDCU2SelfTesResults_A2 = getValue("port0x133", "DD_CDCU2SelfTesResults_A2");
        String DCU6 = getSelfStatus(DD_CDCU1SelfTestInProg_A2, DD_CDCU1SelfTestDone_A2, DD_CDCU1SelfTesResults_A2, DD_CDCU2SelfTestInProg_A2, DD_CDCU2SelfTestDone_A2, DD_CDCU2SelfTesResults_A2);
        data.put("DCU_A2", DCU6);
        Long DD_CPAPIS1SelfTestInProg = getValue("port0x132", "DD_CPAPIS1SelfTestInProg");
        Long DD_CPAPIS1SelfTestDone = getValue("port0x132", "DD_CPAPIS1SelfTestDone");
        Long DD_CPAPIS1SelfTesResults = getValue("port0x133", "DD_CPAPIS1SelfTesResults");
        String PAPI1 = getSelfStatus(DD_CPAPIS1SelfTestInProg, DD_CPAPIS1SelfTestDone, DD_CPAPIS1SelfTesResults);
        data.put("PAPI_A1", PAPI1);

        Long DD_CPAPIS2SelfTestInProg = getValue("port0x132", "DD_CPAPIS2SelfTestInProg");
        Long DD_CPAPIS2SelfTestDone = getValue("port0x132", "DD_CPAPIS2SelfTestDone");
        Long DD_CPAPIS2SelfTesResults = getValue("port0x133", "DD_CPAPIS2SelfTesResults");
        String PAPI2 = getSelfStatus(DD_CPAPIS2SelfTestInProg, DD_CPAPIS2SelfTestDone, DD_CPAPIS2SelfTesResults);
        data.put("PAPI_A2", PAPI2);

        Long DD_CLCU1SelfTestInProg = getValue("port0x132", "DD_CLCU1SelfTestInProg");
        Long DD_CLCU1SelfTestDone = getValue("port0x132", "DD_CLCU1SelfTestDone");
        Long DD_CLCU1SelfTesResults = getValue("port0x133", "DD_CLCU1SelfTesResults");
        String LCU1 = getSelfStatus(DD_CLCU1SelfTestInProg, DD_CLCU1SelfTestDone, DD_CLCU1SelfTesResults);
        data.put("LCU_A1", LCU1);


        Long DD_CLCU2SelfTestInProg = getValue("port0x132", "DD_CLCU2SelfTestInProg");
        Long DD_CLCU2SelfTestDone = getValue("port0x132", "DD_CLCU2SelfTestDone");
        Long DD_CLCU2SelfTesResults = getValue("port0x133", "DD_CLCU2SelfTesResults");
        String LCU2 = getSelfStatus(DD_CLCU2SelfTestInProg, DD_CLCU2SelfTestDone, DD_CLCU2SelfTesResults);
        data.put("LCU_A2", LCU2);

        Long DD_CVAC1SelfTestInProg = getValue("port0x132", "DD_CVAC1SelfTestInProg");
        Long DD_CVAC1SelfTestDone = getValue("port0x132", "DD_CVAC1SelfTestDone");
        Long DD_CVAC1SelfTesResults = getValue("port0x133", "DD_CVAC1SelfTesResults");
        String VAC1 = getSelfStatus(DD_CVAC1SelfTestInProg, DD_CVAC1SelfTestDone, DD_CVAC1SelfTesResults);
        data.put("HVAC_A1", VAC1);
        Long DD_CVAC2SelfTestInProg = getValue("port0x132", "DD_CVAC2SelfTestInProg");
        Long DD_CVAC2SelfTestDone = getValue("port0x132", "DD_CVAC2SelfTestDone");
        Long DD_CVAC2SelfTesResults = getValue("port0x133", "DD_CVAC2SelfTesResults");
        String VAC2 = getSelfStatus(DD_CVAC2SelfTestInProg, DD_CVAC2SelfTestDone, DD_CVAC2SelfTesResults);
        data.put("HVAC_B1", VAC2);
        Long DD_CVAC3SelfTestInProg = getValue("port0x132", "DD_CVAC3SelfTestInProg");
        Long DD_CVAC3SelfTestDone = getValue("port0x132", "DD_CVAC3SelfTestDone");
        Long DD_CVAC3SelfTesResults = getValue("port0x133", "DD_CVAC3SelfTesResults");
        String VAC3 = getSelfStatus(DD_CVAC3SelfTestInProg, DD_CVAC3SelfTestDone, DD_CVAC3SelfTesResults);
        data.put("HVAC_C1", VAC3);
        Long DD_CVAC4SelfTestInProg = getValue("port0x132", "DD_CVAC4SelfTestInProg");
        Long DD_CVAC4SelfTestDone = getValue("port0x132", "DD_CVAC4SelfTestDone");
        Long DD_CVAC4SelfTesResults = getValue("port0x133", "DD_CVAC4SelfTesResults");
        String VAC4 = getSelfStatus(DD_CVAC4SelfTestInProg, DD_CVAC4SelfTestDone, DD_CVAC4SelfTesResults);
        data.put("HVAC_C2", VAC4);

        Long DD_CVAC5SelfTestInProg = getValue("port0x132", "DD_CVAC5SelfTestInProg");
        Long DD_CVAC5SelfTestDone = getValue("port0x132", "DD_CVAC5SelfTestDone");
        Long DD_CVAC5SelfTesResults = getValue("port0x133", "DD_CVAC5SelfTesResults");
        String VAC5 = getSelfStatus(DD_CVAC5SelfTestInProg, DD_CVAC5SelfTestDone, DD_CVAC5SelfTesResults);
        data.put("HVAC_B2", VAC5);
        Long DD_CVAC6SelfTestInProg = getValue("port0x132", "DD_CVAC6SelfTestInProg");
        Long DD_CVAC6SelfTestDone = getValue("port0x132", "DD_CVAC6SelfTestDone");
        Long DD_CVAC6SelfTesResults = getValue("port0x133", "DD_CVAC6SelfTesResults");
        String VAC6 = getSelfStatus(DD_CVAC6SelfTestInProg, DD_CVAC6SelfTestDone, DD_CVAC6SelfTesResults);
        data.put("HVAC_A2", VAC6);

        Long DD_CBMS1SelfTestInProg = getValue("port0x132", "DD_CBMS1SelfTestInProg");
        Long DD_CBMS1SelfTestDone = getValue("port0x132", "DD_CBMS1SelfTestDone");
        Long DD_CBMS1SelfTesResults = getValue("port0x133", "DD_CBMS1SelfTesResults");
        String BMS1 = getSelfStatus(DD_CBMS1SelfTestInProg, DD_CBMS1SelfTestDone, DD_CBMS1SelfTesResults);
        data.put("BMS_A1", BMS1);

        Long DD_CBMS2SelfTestInProg = getValue("port0x132", "DD_CBMS2SelfTestInProg");
        Long DD_CBMS2SelfTestDone = getValue("port0x132", "DD_CBMS2SelfTestDone");
        Long DD_CBMS2SelfTesResults = getValue("port0x133", "DD_CBMS2SelfTesResults");
        String BMS2 = getSelfStatus(DD_CBMS2SelfTestInProg, DD_CBMS2SelfTestDone, DD_CBMS2SelfTesResults);
        data.put("BMS_A2", BMS2);
        Long DD_CFSD1SelfTestInProg = getValue("port0x132", "DD_CFSD1SelfTestInProg");
        Long DD_CFSD1SelfTestDone = getValue("port0x132", "DD_CFSD1SelfTestDone");
        Long DD_CFSD1SelfTesResults = getValue("port0x133", "DD_CFSD1SelfTesResults");
        String FSD1 = getSelfStatus(DD_CFSD1SelfTestInProg, DD_CFSD1SelfTestDone, DD_CFSD1SelfTesResults);
        data.put("FSD_A1", FSD1);


        Long DD_CFSD2SelfTestInProg = getValue("port0x132", "DD_CFSD2SelfTestInProg");
        Long DD_CFSD2SelfTestDone = getValue("port0x132", "DD_CFSD2SelfTestDone");
        Long DD_CFSD2SelfTesResults = getValue("port0x133", "DD_CFSD2SelfTesResults");
        String FSD2 = getSelfStatus(DD_CFSD2SelfTestInProg, DD_CFSD2SelfTestDone, DD_CFSD2SelfTesResults);
        data.put("FSD_A2", FSD2);
        Long DD_CPCE1SelfTestInProg = getValue("port0x132", "DD_CPCE1SelfTestInProg");
        Long DD_CPCE1SelfTestDone = getValue("port0x132", "DD_CPCE1SelfTestDone");
        Long DD_CPCE1SelfTesResults = getValue("port0x133", "DD_CPCE1SelfTesResults");
        String PCE1 = getSelfStatus(DD_CPCE1SelfTestInProg, DD_CPCE1SelfTestDone, DD_CPCE1SelfTesResults);
        data.put("PCE_B1", PCE1);
        Long DD_CPCE2SelfTestInProg = getValue("port0x132", "DD_CPCE2SelfTestInProg");
        Long DD_CPCE2SelfTestDone = getValue("port0x132", "DD_CPCE2SelfTestDone");
        Long DD_CPCE2SelfTesResults = getValue("port0x133", "DD_CPCE2SelfTesResults");
        String PCE2 = getSelfStatus(DD_CPCE2SelfTestInProg, DD_CPCE2SelfTestDone, DD_CPCE2SelfTesResults);
        data.put("PCE_C1", PCE2);
        Long DD_CPCE3SelfTestInProg = getValue("port0x132", "DD_CPCE3SelfTestInProg");
        Long DD_CPCE3SelfTestDone = getValue("port0x132", "DD_CPCE3SelfTestDone");
        Long DD_CPCE3SelfTesResults = getValue("port0x133", "DD_CPCE3SelfTesResults");
        String PCE3 = getSelfStatus(DD_CPCE3SelfTestInProg, DD_CPCE3SelfTestDone, DD_CPCE3SelfTesResults);
        data.put("PCE_C2", PCE3);
        Long DD_CPCE4SelfTestInProg = getValue("port0x132", "DD_CPCE4SelfTestInProg");
        Long DD_CPCE4SelfTestDone = getValue("port0x132", "DD_CPCE4SelfTestDone");
        Long DD_CPCE4SelfTesResults = getValue("port0x133", "DD_CPCE4SelfTesResults");
        String PCE4 = getSelfStatus(DD_CPCE4SelfTestInProg, DD_CPCE4SelfTestDone, DD_CPCE4SelfTesResults);
        data.put("PCE_B2", PCE4);
        Long DD_CERM1SelfTestInProg = getValue("port0x132", "DD_CERM1SelfTestInProg");
        Long DD_CERM1SelfTestDone = getValue("port0x132", "DD_CERM1SelfTestDone");
        Long DD_CERM1SelfTesResults = getValue("port0x133", "DD_CERM1SelfTesResults");
        String ERM1 = getSelfStatus(DD_CERM1SelfTestInProg, DD_CERM1SelfTestDone, DD_CERM1SelfTesResults);
        Long DD_CERM2SelfTestInProg = getValue("port0x132", "DD_CERM2SelfTestInProg");
        Long DD_CERM2SelfTestDone = getValue("port0x132", "DD_CERM2SelfTestDone");
        Long DD_CERM2SelfTesResults = getValue("port0x133", "DD_CERM2SelfTesResults");
        Long DD_CEGM1SelfTestInProg = getValue("port0x132", "DD_CEGM1SelfTestInProg");
        Long DD_CEGM1SelfTestDone = getValue("port0x132", "DD_CEGM1SelfTestDone");
        Long DD_CEGM1SelfTesResults = getValue("port0x133", "DD_CEGM1SelfTesResults");
        String EGM1 = getSelfStatus(DD_CEGM1SelfTestInProg, DD_CEGM1SelfTestDone, DD_CEGM1SelfTesResults);
        data.put("EGM_B1", EGM1);
        Long DD_CEGM2SelfTestInProg = getValue("port0x132", "DD_CEGM2SelfTestInProg");
        Long DD_CEGM2SelfTestDone = getValue("port0x132", "DD_CEGM2SelfTestDone");
        Long DD_CEGM2SelfTesResults = getValue("port0x133", "DD_CEGM2SelfTesResults");
        String EGM2 = getSelfStatus(DD_CEGM2SelfTestInProg, DD_CEGM2SelfTestDone, DD_CEGM2SelfTesResults);
        data.put("EGM_B2", EGM2);
        Long DD_CPMSSelfTestInProg = getValue("port0x132", "DD_CPMSSelfTestInProg");
        Long DD_CPMSSelfTestDone = getValue("port0x132", "DD_CPMSSelfTestDone");
        Long DD_CPMSSelfTesResults = getValue("port0x133", "DD_CPMSSelfTesResults");
        String PMS = getSelfStatus(DD_CPMSSelfTestInProg, DD_CPMSSelfTestDone, DD_CPMSSelfTesResults);
        data.put("PMS_B1", PMS);
        Long DD_CVAC1DySelfTestInProg = getValue("port0x134", "DD_CVAC1DySelfTestInProg");
        Long DD_CVAC1DySelfTestDone = getValue("port0x134", "DD_CVAC1DySelfTestDone");
        Long DD_CVAC1DySelfTesResults = getValue("port0x134", "DD_CVAC1DySelfTesResults");
        Long DD_CVAC2DySelfTestInProg = getValue("port0x134", "DD_CVAC2DySelfTestInProg");
        Long DD_CVAC2DySelfTestDone = getValue("port0x134", "DD_CVAC2DySelfTestDone");
        Long DD_CVAC2DySelfTesResults = getValue("port0x134", "DD_CVAC2DySelfTesResults");
        Long DD_CVAC3DySelfTestInProg = getValue("port0x134", "DD_CVAC3DySelfTestInProg");
        Long DD_CVAC3DySelfTestDone = getValue("port0x134", "DD_CVAC3DySelfTestDone");
        Long DD_CVAC3DySelfTesResults = getValue("port0x134", "DD_CVAC3DySelfTesResults");
        Long DD_CVAC4DySelfTestInProg = getValue("port0x134", "DD_CVAC4DySelfTestInProg");
        Long DD_CVAC4DySelfTestDone = getValue("port0x134", "DD_CVAC4DySelfTestDone");
        Long DD_CVAC4DySelfTesResults = getValue("port0x134", "DD_CVAC4DySelfTesResults");
        Long DD_CVAC5DySelfTestInProg = getValue("port0x134", "DD_CVAC5DySelfTestInProg");
        Long DD_CVAC5DySelfTestDone = getValue("port0x134", "DD_CVAC5DySelfTestDone");
        Long DD_CVAC5DySelfTesResults = getValue("port0x134", "DD_CVAC5DySelfTesResults");
        Long DD_CVAC6DySelfTestInProg = getValue("port0x134", "DD_CVAC6DySelfTestInProg");
        Long DD_CVAC6DySelfTestDone = getValue("port0x134", "DD_CVAC6DySelfTestDone");
        Long DD_CVAC6DySelfTesResults = getValue("port0x134", "DD_CVAC6DySelfTesResults");
        Long DD_CDCMSelfTestInProg = getValue("port0x134", "DD_CDCMSelfTestInProg");
        Long DD_CDCMSelfTestDone = getValue("port0x134", "DD_CDCMSelfTestDone");
        Long DD_CDCMSelfTesResults = getValue("port0x134", "DD_CDCMSelfTesResults");
        String DCM = getSelfStatus(DD_CDCMSelfTestInProg, DD_CDCMSelfTestDone, DD_CDCMSelfTesResults);
        //data.put("DCM", DCM);
        Long DD_CBCEAutoTestInProgress_A1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A1");
        Long DD_CBCE1SelfTestDone = getValue("port0x132", "DD_CBCE1SelfTestDone");
        Long DD_CBCE1SelfTesResults = getValue("port0x133", "DD_CBCE1SelfTesResults");
        String BCE1 = getSelfStatus(DD_CBCEAutoTestInProgress_A1, DD_CBCE1SelfTestDone, DD_CBCE1SelfTesResults);
        data.put("BRK_A1", BCE1);
        Long DD_CBCEAutoTestInProgress_A2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A2");
        Long DD_CBCE2SelfTestDone = getValue("port0x132", "DD_CBCE2SelfTestDone");
        Long DD_CBCE2SelfTesResults = getValue("port0x133", "DD_CBCE2SelfTesResults");
        String BCE2 = getSelfStatus(DD_CBCEAutoTestInProgress_A2, DD_CBCE2SelfTestDone, DD_CBCE2SelfTesResults);
        data.put("BRK_A2", BCE2);
        Long DD_CBCEAutoTestInProgress_C1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C1");
        Long DD_CBCE3SelfTestDone = getValue("port0x132", "DD_CBCE3SelfTestDone");
        Long DD_CBCE3SelfTesResults = getValue("port0x133", "DD_CBCE3SelfTesResults");
        String BCE3 = getSelfStatus(DD_CBCEAutoTestInProgress_C1, DD_CBCE3SelfTestDone, DD_CBCE3SelfTesResults);
        data.put("BRK_C1", BCE3);
        Long DD_CBCEAutoTestInProgress_C2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C2");
        Long DD_CBCE4SelfTestDone = getValue("port0x132", "DD_CBCE4SelfTestDone");
        Long DD_CBCE4SelfTesResults = getValue("port0x133", "DD_CBCE4SelfTesResults");
        String BCE4 = getSelfStatus(DD_CBCEAutoTestInProgress_C2, DD_CBCE4SelfTestDone, DD_CBCE4SelfTesResults);
        data.put("BRK_C2", BCE4);
        return data;
    }


    /**
     * brake test
     */
    private static Map brakeTest() {
        Map<String, Object> data = new HashMap<>();
        Long DD_CBCEAutoTestNotDone_A1 = getValue("port0x126", "DD_CBCEAutoTestNotDone_A1");
        Long DD_CAutoTestAbortedBCE1 = getValue("port0x134", "DD_CAutoTestAbortedBCE1");
        Long DD_CBCEAutoTestInProgress_A1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A1");
        Long DD_CBCE1SelfTestTimeout = getValue("port0x134", "DD_CBCE1SelfTestTimeout");
        Long DD_CBCEAutoTestStatNOk_A1 = getValue("port0x126", "DD_CBCEAutoTestStatNOk_A1");
        Long DD_CBCEAutoTestStatOk_A1 = getValue("port0x126", "DD_CBCEAutoTestStatOk_A1");
        String brakeTest = getBrakeTestStatus(DD_CBCEAutoTestNotDone_A1, DD_CAutoTestAbortedBCE1, DD_CBCEAutoTestInProgress_A1, DD_CBCE1SelfTestTimeout, DD_CBCEAutoTestStatNOk_A1, DD_CBCEAutoTestStatOk_A1);
        data.put("A1", brakeTest);

        Long DD_CBCEAutoTestNotDone_A2 = getValue("port0x126", "DD_CBCEAutoTestNotDone_A2");
        Long DD_CAutoTestAbortedBCE2 = getValue("port0x134", "DD_CAutoTestAbortedBCE2");
        Long DD_CBCEAutoTestInProgress_A2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_A2");
        Long DD_CBCE2SelfTestTimeout = getValue("port0x134", "DD_CBCE2SelfTestTimeout");
        Long DD_CBCEAutoTestStatNOk_A2 = getValue("port0x126", "DD_CBCEAutoTestStatNOk_A2");
        Long DD_CBCEAutoTestStatOk_A2 = getValue("port0x126", "DD_CBCEAutoTestStatOk_A2");
        String brakeTest2 = getBrakeTestStatus(DD_CBCEAutoTestNotDone_A2, DD_CAutoTestAbortedBCE2, DD_CBCEAutoTestInProgress_A2, DD_CBCE2SelfTestTimeout, DD_CBCEAutoTestStatNOk_A2, DD_CBCEAutoTestStatOk_A2);
        data.put("A2", brakeTest2);


        Long DD_CBCEAutoTestNotDone_C1 = getValue("port0x126", "DD_CBCEAutoTestNotDone_C1");
        Long DD_CAutoTestAbortedBCE3 = getValue("port0x134", "DD_CAutoTestAbortedBCE3");
        Long DD_CBCEAutoTestInProgress_C1 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C1");
        Long DD_CBCE3SelfTestTimeout = getValue("port0x134", "DD_CBCE3SelfTestTimeout");
        Long DD_CBCEAutoTestStatNOk_C1 = getValue("port0x126", "DD_CBCEAutoTestStatNOk_C1");
        Long DD_CBCEAutoTestStatOk_C1 = getValue("port0x126", "DD_CBCEAutoTestStatOk_C1");
        String brakeTest3 = getBrakeTestStatus(DD_CBCEAutoTestNotDone_C1, DD_CAutoTestAbortedBCE3, DD_CBCEAutoTestInProgress_C1, DD_CBCE3SelfTestTimeout, DD_CBCEAutoTestStatNOk_C1, DD_CBCEAutoTestStatOk_C1);
        data.put("C1", brakeTest3);


        Long DD_CBCEAutoTestNotDone_C2 = getValue("port0x126", "DD_CBCEAutoTestNotDone_C2");
        Long DD_CAutoTestAbortedBCE4 = getValue("port0x134", "DD_CAutoTestAbortedBCE4");
        Long DD_CBCEAutoTestInProgress_C2 = getValue("port0x132", "DD_CBCEAutoTestInProgress_C2");
        Long DD_CBCE4SelfTestTimeout = getValue("port0x134", "DD_CBCE4SelfTestTimeout");
        Long DD_CBCEAutoTestStatNOk_C2 = getValue("port0x126", "DD_CBCEAutoTestStatNOk_C2");
        Long DD_CBCEAutoTestStatOk_C2 = getValue("port0x126", "DD_CBCEAutoTestStatOk_C2");
        String brakeTest4 = getBrakeTestStatus(DD_CBCEAutoTestNotDone_C2, DD_CAutoTestAbortedBCE4, DD_CBCEAutoTestInProgress_C2, DD_CBCE4SelfTestTimeout, DD_CBCEAutoTestStatNOk_C2, DD_CBCEAutoTestStatOk_C2);
        data.put("C2", brakeTest4);


        String brakeTest5 = "";
        if (DD_CBCEAutoTestNotDone_A1 == 1 || DD_CBCEAutoTestNotDone_A2 == 1 || DD_CBCEAutoTestNotDone_C1 == 1 || DD_CBCEAutoTestNotDone_C2 == 1) {
            brakeTest5 = "BrakeTestNotDone";
        } else if (DD_CBCEAutoTestInProgress_A1 == 1 || DD_CBCEAutoTestInProgress_A2 == 1 || DD_CBCEAutoTestInProgress_C1 == 1 || DD_CBCEAutoTestInProgress_C2 == 1) {
            brakeTest5 = "BrakeTestInProgress";
        } else if (DD_CBCE1SelfTestTimeout == 1 ||
                DD_CBCE2SelfTestTimeout == 1 ||
                DD_CBCE3SelfTestTimeout == 1 ||
                DD_CBCE4SelfTestTimeout == 1 ||
                DD_CAutoTestAbortedBCE1 == 1 || DD_CAutoTestAbortedBCE2 == 1 || DD_CAutoTestAbortedBCE3 == 1 || DD_CAutoTestAbortedBCE4 == 1 || DD_CBCEAutoTestStatNOk_A1 == 1 || DD_CBCEAutoTestStatNOk_A2 == 1 || DD_CBCEAutoTestStatNOk_C1 == 1 || DD_CBCEAutoTestStatNOk_C2 == 1) {
            brakeTest5 = "BrakeTestFailed/TimeOut/Cancelled";
        } else if (DD_CBCEAutoTestStatOk_A1 == 1
                || DD_CBCEAutoTestStatOk_A2 == 1
                || DD_CBCEAutoTestStatOk_C1 == 1
                || DD_CBCEAutoTestStatOk_C2 == 1) {
            brakeTest5 = "BrakeTestPassed";
        }
        data.put("brakeTest", brakeTest5);


        return data;
    }


    private static Map softwareVersion() {
        Map<String, Object> data = new HashMap<>();
        Long DD_CMPU1Version0 = getValue("port0x135", "DD_CMPU1Version0");
        Long DD_CMPU1Version1 = getValue("port0x135", "DD_CMPU1Version1");
        Long DD_CMPU1Version2 = getValue("port0x135", "DD_CMPU1Version2");
        Long DD_CMPU1Version3 = getValue("port0x135", "DD_CMPU1Version3");
        data.put("MPU1", DD_CMPU1Version0 + "." + DD_CMPU1Version1 + "." + DD_CMPU1Version2 + "." + DD_CMPU1Version3);
        Long DD_CMPU2Version0 = getValue("port0x135", "DD_CMPU2Version0");
        Long DD_CMPU2Version1 = getValue("port0x135", "DD_CMPU2Version1");
        Long DD_CMPU2Version2 = getValue("port0x135", "DD_CMPU2Version2");
        Long DD_CMPU2Version3 = getValue("port0x135", "DD_CMPU2Version3");
        data.put("MPU2", DD_CMPU2Version0 + "." + DD_CMPU2Version1 + "." + DD_CMPU2Version2 + "." + DD_CMPU2Version3);
        Long DD_CFSD1Version0 = getValue("port0x135", "DD_CFSD1Version0");
        Long DD_CFSD1Version1 = getValue("port0x135", "DD_CFSD1Version1");
        Long DD_CFSD1Version2 = getValue("port0x135", "DD_CFSD1Version2");
        data.put("FSD1", DD_CFSD1Version0 + "." + DD_CFSD1Version1 + "." + DD_CFSD1Version2);
        Long DD_CFSD2Version0 = getValue("port0x135", "DD_CFSD2Version0");
        Long DD_CFSD2Version1 = getValue("port0x135", "DD_CFSD2Version1");
        Long DD_CFSD2Version2 = getValue("port0x135", "DD_CFSD2Version2");
        data.put("FSD2", DD_CFSD2Version0 + "." + DD_CFSD2Version1 + "." + DD_CFSD2Version2);
        Long DD_CDD1Version0 = getValue("port0x135", "DD_CDD1Version0");
        Long DD_CDD1Version1 = getValue("port0x135", "DD_CDD1Version1");
        Long DD_CDD1Version2 = getValue("port0x135", "DD_CDD1Version2");
        Long DD_CDD1Version3 = getValue("port0x135", "DD_CDD1Version3");
        data.put("DDU1", DD_CDD1Version0 + "." + DD_CDD1Version1 + "." + DD_CDD1Version2 + "." + DD_CDD1Version3);
        Long DD_CDD2Version0 = getValue("port0x135", "DD_CDD2Version0");
        Long DD_CDD2Version1 = getValue("port0x135", "DD_CDD2Version1");
        Long DD_CDD2Version2 = getValue("port0x135", "DD_CDD2Version2");
        Long DD_CDD2Version3 = getValue("port0x135", "DD_CDD2Version3");
        data.put("DDU2", DD_CDD2Version0 + "." + DD_CDD2Version1 + "." + DD_CDD2Version2 + "." + DD_CDD2Version3);
        Long DD_CGTW1Version0 = getValue("port0x135", "DD_CGTW1Version0");
        Long DD_CGTW1Version1 = getValue("port0x135", "DD_CGTW1Version1");
        Long DD_CGTW1Version2 = getValue("port0x135", "DD_CGTW1Version2");
        Long DD_CGTW1Version3 = getValue("port0x135", "DD_CGTW1Version3");
        data.put("GTW1", DD_CGTW1Version0 + "." + DD_CGTW1Version1 + "." + DD_CGTW1Version2 + "." + DD_CGTW1Version3);
        Long DD_CGTW2Version0 = getValue("port0x135", "DD_CGTW2Version0");
        Long DD_CGTW2Version1 = getValue("port0x135", "DD_CGTW2Version1");
        Long DD_CGTW2Version2 = getValue("port0x135", "DD_CGTW2Version2");
        Long DD_CGTW2Version3 = getValue("port0x135", "DD_CGTW2Version3");
        data.put("GTW2", DD_CGTW2Version0 + "." + DD_CGTW2Version1 + "." + DD_CGTW2Version2 + "." + DD_CGTW2Version3);
        Long ACEi_ISoftwVersion0 = getValue("port0x701", "ACEi_ISoftwVersion0");
        Long ACEi_ISoftwVersion1 = getValue("port0x701", "ACEi_ISoftwVersion1");
        Long ACEi_ISoftwVersion2 = getValue("port0x701", "ACEi_ISoftwVersion2");
        data.put("ACE1", ACEi_ISoftwVersion0 + "." + ACEi_ISoftwVersion1 + "." + ACEi_ISoftwVersion2);
        Long ACE2_ISoftwVersion0 = getValue("port0x721", "ACEi_ISoftwVersion0");
        Long ACE2_ISoftwVersion1 = getValue("port0x721", "ACEi_ISoftwVersion1");
        Long ACE2_ISoftwVersion2 = getValue("port0x721", "ACEi_ISoftwVersion2");
        data.put("ACE2", ACE2_ISoftwVersion0 + "." + ACE2_ISoftwVersion1 + "." + ACE2_ISoftwVersion2);
        Long ACE3_ISoftwVersion0 = getValue("port0x731", "ACEi_ISoftwVersion0");
        Long ACE3_ISoftwVersion1 = getValue("port0x731", "ACEi_ISoftwVersion1");
        Long ACE3_ISoftwVersion2 = getValue("port0x731", "ACEi_ISoftwVersion2");
        data.put("ACE3", ACE3_ISoftwVersion0 + "." + ACE3_ISoftwVersion1 + "." + ACE3_ISoftwVersion2);
        Long PCEi_ISoftwVersion0 = getValue("port0x502", "PCEi_ISoftwVersion0");
        Long PCEi_ISoftwVersion1 = getValue("port0x502", "PCEi_ISoftwVersion1");
        Long PCEi_ISoftwVersion2 = getValue("port0x502", "PCEi_ISoftwVersion2");
        data.put("PCE1", PCEi_ISoftwVersion0 + "." + PCEi_ISoftwVersion1 + "." + PCEi_ISoftwVersion2);
        Long PCE2_ISoftwVersion0 = getValue("port0x512", "PCEi_ISoftwVersion0");
        Long PCE2_ISoftwVersion1 = getValue("port0x512", "PCEi_ISoftwVersion1");
        Long PCE2_ISoftwVersion2 = getValue("port0x512", "PCEi_ISoftwVersion2");
        data.put("PCE2", PCE2_ISoftwVersion0 + "." + PCE2_ISoftwVersion1 + "." + PCE2_ISoftwVersion2);
        Long PCE3_ISoftwVersion0 = getValue("port0x522", "PCEi_ISoftwVersion0");
        Long PCE3_ISoftwVersion1 = getValue("port0x522", "PCEi_ISoftwVersion1");
        Long PCE3_ISoftwVersion2 = getValue("port0x522", "PCEi_ISoftwVersion2");
        data.put("PCE3", PCE3_ISoftwVersion0 + "." + PCE3_ISoftwVersion1 + "." + PCE3_ISoftwVersion2);
        Long PCE4_ISoftwVersion0 = getValue("port0x532", "PCEi_ISoftwVersion0");
        Long PCE4_ISoftwVersion1 = getValue("port0x532", "PCEi_ISoftwVersion1");
        Long PCE4_ISoftwVersion2 = getValue("port0x532", "PCEi_ISoftwVersion2");
        data.put("PCE4", PCE4_ISoftwVersion0 + "." + PCE4_ISoftwVersion1 + "." + PCE4_ISoftwVersion2);
        Long PISi_ISoftwVersion0 = getValue("port0x840", "PISi_ISoftwVersion0");
        Long PISi_ISoftwVersion1 = getValue("port0x840", "PISi_ISoftwVersion1");
        Long PISi_ISoftwVersion2 = getValue("port0x840", "PISi_ISoftwVersion2");
        data.put("PAPIS1", PISi_ISoftwVersion0 + "." + PISi_ISoftwVersion1 + "." + PISi_ISoftwVersion2);
        Long PIS2_ISoftwVersion0 = getValue("port0x860", "PISi_ISoftwVersion0");
        Long PIS2_ISoftwVersion1 = getValue("port0x860", "PISi_ISoftwVersion1");
        Long PIS2_ISoftwVersion2 = getValue("port0x860", "PISi_ISoftwVersion2");
        data.put("PAPIS2", PIS2_ISoftwVersion0 + "." + PIS2_ISoftwVersion1 + "." + PIS2_ISoftwVersion2);
        Long VACi_ISoftwVersion0 = getValue("port0x8a0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1 = getValue("port0x8a0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2 = getValue("port0x8a0", "ISoftwVersion2");
        data.put("HVAC", VACi_ISoftwVersion0 + "." + VACi_ISoftwVersion1 + "." + VACi_ISoftwVersion2);
        Long VACi_ISoftwVersion0b = getValue("port0x8b0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1b = getValue("port0x8b0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2b = getValue("port0x8b0", "ISoftwVersion2");
        data.put("HVAC2", VACi_ISoftwVersion0b + "." + VACi_ISoftwVersion1b + "." + VACi_ISoftwVersion2b);
        Long VACi_ISoftwVersion0c = getValue("port0x8c0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1c = getValue("port0x8c0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2c = getValue("port0x8c0", "ISoftwVersion2");
        data.put("HVAC3", VACi_ISoftwVersion0c + "." + VACi_ISoftwVersion1c + "." + VACi_ISoftwVersion2c);
        Long VACi_ISoftwVersion0d = getValue("port0x8d0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1d = getValue("port0x8d0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2d = getValue("port0x8d0", "ISoftwVersion2");
        data.put("HVAC4", VACi_ISoftwVersion0d + "." + VACi_ISoftwVersion1d + "." + VACi_ISoftwVersion2d);
        Long VACi_ISoftwVersion0e = getValue("port0x8e0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1e = getValue("port0x8e0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2e = getValue("port0x8e0", "ISoftwVersion2");
        data.put("HVAC5", VACi_ISoftwVersion0e + "." + VACi_ISoftwVersion1e + "." + VACi_ISoftwVersion2e);
        Long VACi_ISoftwVersion0f = getValue("port0x8f0", "ISoftwVersion0");
        Long VACi_ISoftwVersion1f = getValue("port0x8f0", "ISoftwVersion1");
        Long VACi_ISoftwVersion2f = getValue("port0x8f0", "ISoftwVersion2");
        data.put("HVAC6", VACi_ISoftwVersion0f + "." + VACi_ISoftwVersion1f + "." + VACi_ISoftwVersion2f);
        Long ERMi_ISoftwVersion0 = getValue("port0x880", "ERMi_ISoftwVersion0");
        Long ERMi_ISoftwVersion1 = getValue("port0x880", "ERMi_ISoftwVersion1");
        Long ERMi_ISoftwVersion2 = getValue("port0x880", "ERMi_ISoftwVersion2");
        data.put("ISCS1", ERMi_ISoftwVersion0 + "." + ERMi_ISoftwVersion1 + "." + ERMi_ISoftwVersion2);
        Long ERM2_ISoftwVersion0 = getValue("port0x890", "ERMi_ISoftwVersion0");
        Long ERM2_ISoftwVersion1 = getValue("port0x890", "ERMi_ISoftwVersion1");
        Long ERM2_ISoftwVersion2 = getValue("port0x890", "ERMi_ISoftwVersion2");
        data.put("ISCS2", ERM2_ISoftwVersion0 + "." + ERM2_ISoftwVersion1 + "." + ERM2_ISoftwVersion2);
        Long BBOi_ISoftwVersion0 = getValue("port0x940", "BBOi_ISoftwVersion0");
        Long BBOi_ISoftwVersion1 = getValue("port0x940", "BBOi_ISoftwVersion1");
        Long BBOi_ISoftwVersion2 = getValue("port0x940", "BBOi_ISoftwVersion2");
        data.put("BBO1", BBOi_ISoftwVersion0 + "." + BBOi_ISoftwVersion1 + "." + BBOi_ISoftwVersion2);
        Long BBO2_ISoftwVersion0 = getValue("port0x948", "BBOi_ISoftwVersion0");
        Long BBO2_ISoftwVersion1 = getValue("port0x948", "BBOi_ISoftwVersion1");
        Long BBO2_ISoftwVersion2 = getValue("port0x948", "BBOi_ISoftwVersion2");
        data.put("BBO2", BBO2_ISoftwVersion0 + "." + BBO2_ISoftwVersion1 + "." + BBO2_ISoftwVersion2);
        Long BMSi_ISoftwVersion0 = getValue("port0x920", "BMSi_ISoftwVersion0");
        Long BMSi_ISoftwVersion1 = getValue("port0x920", "BMSi_ISoftwVersion1");
        Long BMSi_ISoftwVersion2 = getValue("port0x920", "BMSi_ISoftwVersion2");
        data.put("BMS1", BMSi_ISoftwVersion0 + "." + BMSi_ISoftwVersion1 + "." + BMSi_ISoftwVersion2);
        Long BMS2_ISoftwVersion0 = getValue("port0x930", "BMSi_ISoftwVersion0");
        Long BMS2_ISoftwVersion1 = getValue("port0x930", "BMSi_ISoftwVersion1");
        Long BMS2_ISoftwVersion2 = getValue("port0x930", "BMSi_ISoftwVersion2");
        data.put("BMS2", BMS2_ISoftwVersion0 + "." + BMS2_ISoftwVersion1 + "." + BMS2_ISoftwVersion2);
        Long BCEi_ISoftwVersion0 = getValue("port0x601", "BCEi_ISoftwVersion0");
        Long BCEi_ISoftwVersion1 = getValue("port0x601", "BCEi_ISoftwVersion1");
        data.put("BCE1", BCEi_ISoftwVersion0 + "." + BCEi_ISoftwVersion1);
        Long BCE2_ISoftwVersion0 = getValue("port0x621", "BCEi_ISoftwVersion0");
        Long BCE2_ISoftwVersion1 = getValue("port0x621", "BCEi_ISoftwVersion1");
        data.put("BCE2", BCE2_ISoftwVersion0 + "." + BCE2_ISoftwVersion1);
        Long BCE3_ISoftwVersion0 = getValue("port0x641", "BCEi_ISoftwVersion0");
        Long BCE3_ISoftwVersion1 = getValue("port0x641", "BCEi_ISoftwVersion1");
        data.put("BCE3", BCE3_ISoftwVersion0 + "." + BCE3_ISoftwVersion1);
        Long BCE4_ISoftwVersion0 = getValue("port0x661", "BCEi_ISoftwVersion0");
        Long BCE4_ISoftwVersion1 = getValue("port0x661", "BCEi_ISoftwVersion1");
        data.put("BCE4", BCE4_ISoftwVersion0 + "." + BCE4_ISoftwVersion1);
        Long LCUi_ISoftwVersion0 = getValue("port0x9f0", "LCUi_ISoftwVersion0");
        Long LCUi_ISoftwVersion1 = getValue("port0x9f0", "LCUi_ISoftwVersion1");
        Long LCUi_ISoftwVersion2 = getValue("port0x9f0", "LCUi_ISoftwVersion2");
        data.put("LCU1", LCUi_ISoftwVersion0 + "." + LCUi_ISoftwVersion1 + "." + LCUi_ISoftwVersion2);
        Long LCU2_ISoftwVersion0 = getValue("port0x9f8", "LCUi_ISoftwVersion0");
        Long LCU2_ISoftwVersion1 = getValue("port0x9f8", "LCUi_ISoftwVersion1");
        Long LCU2_ISoftwVersion2 = getValue("port0x9f8", "LCUi_ISoftwVersion2");
        data.put("LCU2", LCU2_ISoftwVersion0 + "." + LCU2_ISoftwVersion1 + "." + LCU2_ISoftwVersion2);
        Long EGMi_ISoftwVersion0 = getValue("port0x960", "EGMi_ISoftwVersion0");
        Long EGMi_ISoftwVersion1 = getValue("port0x960", "EGMi_ISoftwVersion1");
        Long EGMi_ISoftwVersion2 = getValue("port0x960", "EGMi_ISoftwVersion2");
        data.put("EGM1", EGMi_ISoftwVersion0 + "." + EGMi_ISoftwVersion1 + "." + EGMi_ISoftwVersion2);
        Long EGM2_ISoftwVersion0 = getValue("port0x968", "EGMi_ISoftwVersion0");
        Long EGM2_ISoftwVersion1 = getValue("port0x968", "EGMi_ISoftwVersion1");
        Long EGM2_ISoftwVersion2 = getValue("port0x968", "EGMi_ISoftwVersion2");
        data.put("EGM2", EGM2_ISoftwVersion0 + "." + EGM2_ISoftwVersion1 + "." + EGM2_ISoftwVersion2);
        Long PMS_ISoftwVersion0 = getValue("port0x950", "PMS_ISoftwVersion0");
        Long PMS_ISoftwVersion1 = getValue("port0x950", "PMS_ISoftwVersion1");
        Long PMS_ISoftwVersion2 = getValue("port0x950", "PMS_ISoftwVersion2");
        data.put("PMS", PMS_ISoftwVersion0 + "." + PMS_ISoftwVersion1 + "." + PMS_ISoftwVersion2);
        Long DCUi_ISoftwVersion0_car = getValue("port0x990", "DCUi_ISoftwVersion0_car");
        Long DCUi_ISoftwVersion1_car = getValue("port0x990", "DCUi_ISoftwVersion1_car");
        Long DCUi_ISoftwVersion2_car = getValue("port0x990", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCUi_ISoftwVersion0_car + "." + DCUi_ISoftwVersion1_car + "." + DCUi_ISoftwVersion2_car);
        Long DCU2_ISoftwVersion0_car = getValue("port0x998", "DCUi_ISoftwVersion0_car");
        Long DCU2_ISoftwVersion1_car = getValue("port0x998", "DCUi_ISoftwVersion1_car");
        Long DCU2_ISoftwVersion2_car = getValue("port0x998", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU2_ISoftwVersion0_car + "." + DCU2_ISoftwVersion1_car + "." + DCU2_ISoftwVersion2_car);
        Long DCU3_ISoftwVersion0_car = getValue("port0x9a0", "DCUi_ISoftwVersion0_car");
        Long DCU3_ISoftwVersion1_car = getValue("port0x9a0", "DCUi_ISoftwVersion1_car");
        Long DCU3_ISoftwVersion2_car = getValue("port0x9a0", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU3_ISoftwVersion0_car + "." + DCU3_ISoftwVersion1_car + "." + DCU3_ISoftwVersion2_car);
        Long DCU4_ISoftwVersion0_car = getValue("port0x9a8", "DCUi_ISoftwVersion0_car");
        Long DCU4_ISoftwVersion1_car = getValue("port0x9a8", "DCUi_ISoftwVersion1_car");
        Long DCU4_ISoftwVersion2_car = getValue("port0x9a8", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU4_ISoftwVersion0_car + "." + DCU4_ISoftwVersion1_car + "." + DCU4_ISoftwVersion2_car);
        Long DCU5_ISoftwVersion0_car = getValue("port0x9b0", "DCUi_ISoftwVersion0_car");
        Long DCU5_ISoftwVersion1_car = getValue("port0x9b0", "DCUi_ISoftwVersion1_car");
        Long DCU5_ISoftwVersion2_car = getValue("port0x9b0", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU5_ISoftwVersion0_car + "." + DCU5_ISoftwVersion1_car + "." + DCU5_ISoftwVersion2_car);
        Long DCU6_ISoftwVersion0_car = getValue("port0x9b8", "DCUi_ISoftwVersion0_car");
        Long DCU6_ISoftwVersion1_car = getValue("port0x9b8", "DCUi_ISoftwVersion1_car");
        Long DCU6_ISoftwVersion2_car = getValue("port0x9b8", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU6_ISoftwVersion0_car + "." + DCU6_ISoftwVersion1_car + "." + DCU6_ISoftwVersion2_car);
        Long DCU7_ISoftwVersion0_car = getValue("port0x9c0", "DCUi_ISoftwVersion0_car");
        Long DCU7_ISoftwVersion1_car = getValue("port0x9c0", "DCUi_ISoftwVersion1_car");
        Long DCU7_ISoftwVersion2_car = getValue("port0x9c0", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU7_ISoftwVersion0_car + "." + DCU7_ISoftwVersion1_car + "." + DCU7_ISoftwVersion2_car);
        Long DCU8_ISoftwVersion0_car = getValue("port0x9c8", "DCUi_ISoftwVersion0_car");
        Long DCU8_ISoftwVersion1_car = getValue("port0x9c8", "DCUi_ISoftwVersion1_car");
        Long DCU8_ISoftwVersion2_car = getValue("port0x9c8", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU8_ISoftwVersion0_car + "." + DCU8_ISoftwVersion1_car + "." + DCU8_ISoftwVersion2_car);
        Long DCU9_ISoftwVersion0_car = getValue("port0x9d0", "DCUi_ISoftwVersion0_car");
        Long DCU9_ISoftwVersion1_car = getValue("port0x9d0", "DCUi_ISoftwVersion1_car");
        Long DCU9_ISoftwVersion2_car = getValue("port0x9d0", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU9_ISoftwVersion0_car + "." + DCU9_ISoftwVersion1_car + "." + DCU9_ISoftwVersion2_car);
        Long DCU10_ISoftwVersion0_car = getValue("port0x9d8", "DCUi_ISoftwVersion0_car");
        Long DCU10_ISoftwVersion1_car = getValue("port0x9d8", "DCUi_ISoftwVersion1_car");
        Long DCU10_ISoftwVersion2_car = getValue("port0x9d8", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU10_ISoftwVersion0_car + "." + DCU10_ISoftwVersion1_car + "." + DCU10_ISoftwVersion2_car);
        Long DCU11_ISoftwVersion0_car = getValue("port0x9e0", "DCUi_ISoftwVersion0_car");
        Long DCU11_ISoftwVersion1_car = getValue("port0x9e0", "DCUi_ISoftwVersion1_car");
        Long DCU11_ISoftwVersion2_car = getValue("port0x9e0", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU11_ISoftwVersion0_car + "." + DCU11_ISoftwVersion1_car + "." + DCU11_ISoftwVersion2_car);
        Long DCU12_ISoftwVersion0_car = getValue("port0x9e8", "DCUi_ISoftwVersion0_car");
        Long DCU12_ISoftwVersion1_car = getValue("port0x9e8", "DCUi_ISoftwVersion1_car");
        Long DCU12_ISoftwVersion2_car = getValue("port0x9e8", "DCUi_ISoftwVersion2_car");
        data.put("DCU", DCU12_ISoftwVersion0_car + "." + DCU12_ISoftwVersion1_car + "." + DCU12_ISoftwVersion2_car);
        return data;
    }

    /**
     * riom data
     *
     * @return
     */
    private static Map riomData() {
        Map<String, Object> data = new HashMap<>();

        data.put("R1_A1",R1_A1());
        data.put("R2_A1",R2_A1());
        data.put("R3_A1",R3_A1());
        data.put("R4_A1",R4_A1());
        data.put("R5_A1",R5_A1());
        data.put("R1_B1",R1_B1());
        data.put("R2_B1",R2_B1());
        data.put("R1_B2",R1_B2());
        data.put("R2_B2",R2_B2());
        data.put("R1_C1",R1_C1());
        data.put("R2_C1",R2_C1());
        data.put("R1_C2",R1_C2());
        data.put("R2_C2",R2_C2());
        data.put("R1_A2",R1_A2());
        data.put("R2_A2",R2_A2());
        data.put("R3_A2",R3_A2());
        data.put("R4_A2",R4_A2());
        data.put("R5_A2",R5_A2());
        return data;
    }

    private static Map R1_A1() {
        Map<String, Object> data = new HashMap<>();
        Long DD_CRIOM1Oper_A1 = getValue("port0x127", "DD_CRIOM1Oper_A1");
        Long DD_CRIOM2Oper_A1 = getValue("port0x127", "DD_CRIOM2Oper_A1");
        Long DD_CRIOM3Oper_A1 = getValue("port0x127", "DD_CRIOM3Oper_A1");
        Long DD_CRIOM4Oper_A1 = getValue("port0x127", "DD_CRIOM4Oper_A1");
        Long DD_CRIOM5Oper_A1 = getValue("port0x127", "DD_CRIOM5Oper_A1");
        getPortDataAll((Map) dataAll.get("port0x344"), data);
        getPortDataAll((Map) dataAll.get("port0x345"), data);
        getPortDataAll((Map) dataAll.get("port0x342"), data);
        getPortDataAll((Map) dataAll.get("port0x343"), data);
        return data;
    }

    private static Map R2_A1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x354"), data);
        getPortDataAll((Map) dataAll.get("port0x355"), data);
        getPortDataAll((Map) dataAll.get("port0x352"), data);
        getPortDataAll((Map) dataAll.get("port0x353"), data);
        return data;
    }
    private static Map R3_A1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x364"), data);
        getPortDataAll((Map) dataAll.get("port0x365"), data);
        getPortDataAll((Map) dataAll.get("port0x362"), data);
        getPortDataAll((Map) dataAll.get("port0x363"), data);
        return data;
    }
    private static Map R4_A1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x374"), data);
        getPortDataAll((Map) dataAll.get("port0x375"), data);
        getPortDataAll((Map) dataAll.get("port0x372"), data);
        getPortDataAll((Map) dataAll.get("port0x373"), data);
        return data;
    }
    private static Map R5_A1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x384"), data);
        getPortDataAll((Map) dataAll.get("port0x385"), data);
        getPortDataAll((Map) dataAll.get("port0x382"), data);
        getPortDataAll((Map) dataAll.get("port0x383"), data);
        return data;
    }
    private static Map R1_B1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x394"), data);
        getPortDataAll((Map) dataAll.get("port0x395"), data);
        getPortDataAll((Map) dataAll.get("port0x392"), data);
        getPortDataAll((Map) dataAll.get("port0x393"), data);
        return data;
    }
    private static Map R2_B1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3a4"), data);
        getPortDataAll((Map) dataAll.get("port0x3a5"), data);
        getPortDataAll((Map) dataAll.get("port0x3a2"), data);
        getPortDataAll((Map) dataAll.get("port0x3a3"), data);
        return data;
    }
    private static Map R1_C1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3b4"), data);
        getPortDataAll((Map) dataAll.get("port0x3b5"), data);
        getPortDataAll((Map) dataAll.get("port0x3b2"), data);
        getPortDataAll((Map) dataAll.get("port0x3b3"), data);
        return data;
    }
    private static Map R2_C1() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3c4"), data);
        getPortDataAll((Map) dataAll.get("port0x3c5"), data);
        getPortDataAll((Map) dataAll.get("port0x3c2"), data);
        getPortDataAll((Map) dataAll.get("port0x3c3"), data);
        return data;
    }
    private static Map R1_C2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3d4"), data);
        getPortDataAll((Map) dataAll.get("port0x3d5"), data);
        getPortDataAll((Map) dataAll.get("port0x3d2"), data);
        getPortDataAll((Map) dataAll.get("port0x3d3"), data);
        return data;
    }
    private static Map R2_C2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3e4"), data);
        getPortDataAll((Map) dataAll.get("port0x3e5"), data);
        getPortDataAll((Map) dataAll.get("port0x3e2"), data);
        getPortDataAll((Map) dataAll.get("port0x3e3"), data);
        return data;
    }
    private static Map R1_B2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x3f4"), data);
        getPortDataAll((Map) dataAll.get("port0x3f5"), data);
        getPortDataAll((Map) dataAll.get("port0x3f2"), data);
        getPortDataAll((Map) dataAll.get("port0x3f3"), data);
        return data;
    }
    private static Map R2_B2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x404"), data);
        getPortDataAll((Map) dataAll.get("port0x405"), data);
        getPortDataAll((Map) dataAll.get("port0x402"), data);
        getPortDataAll((Map) dataAll.get("port0x403"), data);
        return data;
    }
    private static Map R1_A2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x414"), data);
        getPortDataAll((Map) dataAll.get("port0x415"), data);
        getPortDataAll((Map) dataAll.get("port0x412"), data);
        getPortDataAll((Map) dataAll.get("port0x413"), data);
        return data;
    }
    private static Map R2_A2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x424"), data);
        getPortDataAll((Map) dataAll.get("port0x425"), data);
        getPortDataAll((Map) dataAll.get("port0x422"), data);
        getPortDataAll((Map) dataAll.get("port0x423"), data);
        return data;
    }
    private static Map R3_A2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x434"), data);
        getPortDataAll((Map) dataAll.get("port0x435"), data);
        getPortDataAll((Map) dataAll.get("port0x432"), data);
        getPortDataAll((Map) dataAll.get("port0x433"), data);
        return data;
    }
    private static Map R4_A2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x444"), data);
        getPortDataAll((Map) dataAll.get("port0x445"), data);
        getPortDataAll((Map) dataAll.get("port0x442"), data);
        getPortDataAll((Map) dataAll.get("port0x443"), data);
        return data;
    }

    private static Map R5_A2() {
        Map<String, Object> data = new HashMap<>();
        getPortDataAll((Map) dataAll.get("port0x454"), data);
        getPortDataAll((Map) dataAll.get("port0x455"), data);
        getPortDataAll((Map) dataAll.get("port0x452"), data);
        getPortDataAll((Map) dataAll.get("port0x453"), data);
        return data;
    }


    private static void getPortDataAll(Map portName, Map<String, Object> data) {
        if (portName != null) {
            Iterator<Map.Entry<String, PortModel>> iterator = portName.entrySet().iterator();
            while (iterator.hasNext()) {
                PortModel value = iterator.next().getValue();
                String signalName = value.getSignalName();
                Long value1 = value.getValue();
                data.put(signalName, value1);
            }
        }
    }

    private static String getBrakeTestStatus(Long DD_CBCEAutoTestNotDone_A1, Long DD_CAutoTestAbortedBCE1, Long DD_CBCEAutoTestInProgress_A1, Long DD_CBCE1SelfTestTimeout, Long DD_CBCEAutoTestStatNOk_A1, Long DD_CBCEAutoTestStatOk_A1) {
        String brakeTest = "";
        if (DD_CBCEAutoTestNotDone_A1 == 1 && DD_CAutoTestAbortedBCE1 == 0) {
            brakeTest = "AutoTestNotDone";
        } else if (DD_CBCEAutoTestNotDone_A1 == 0 && DD_CAutoTestAbortedBCE1 == 0 && DD_CBCEAutoTestInProgress_A1 == 1 && DD_CBCE1SelfTestTimeout == 0 && DD_CBCEAutoTestStatNOk_A1 == 0) {
            brakeTest = "AutoTestinProgress";
        } else if (DD_CBCEAutoTestStatOk_A1 == 0 && DD_CBCEAutoTestNotDone_A1 == 0 && DD_CAutoTestAbortedBCE1 == 0 && DD_CBCEAutoTestInProgress_A1 == 0 && DD_CBCE1SelfTestTimeout == 0 && DD_CBCEAutoTestStatNOk_A1 == 0) {
            brakeTest = "AutoTestStatusUnknown";
        } else if (DD_CBCEAutoTestStatOk_A1 == 1 && DD_CBCEAutoTestNotDone_A1 == 0 && DD_CAutoTestAbortedBCE1 == 0 && DD_CBCEAutoTestInProgress_A1 == 0 && DD_CBCE1SelfTestTimeout == 0 && DD_CBCEAutoTestStatNOk_A1 == 0) {
            brakeTest = "AutoTestStatusOK";
        } else if (DD_CBCEAutoTestNotDone_A1 == 0 && DD_CAutoTestAbortedBCE1 == 0 && DD_CBCEAutoTestStatNOk_A1 == 1) {
            brakeTest = "AutoTestStatusNotOK";
        } else if (DD_CAutoTestAbortedBCE1 == 0) {
            brakeTest = "cancelled";
        } else if (DD_CBCEAutoTestNotDone_A1 == 0 && DD_CAutoTestAbortedBCE1 == 0 && DD_CBCE1SelfTestTimeout == 1 && DD_CBCEAutoTestStatNOk_A1 == 0) {
            brakeTest = "timeout";
        }
        return brakeTest;
    }


    private static String getSelfStatus(Long DD_CSelfTestInProg, Long DD_CSelfTestDone, Long DD_CSelfTesResults) {
        String s = "failed";
        if (DD_CSelfTestInProg == 0 && DD_CSelfTestDone == 1 && DD_CSelfTesResults == 0) {
            s = "failed";
        } else if (DD_CSelfTestInProg == 0 && DD_CSelfTestDone == 1 && DD_CSelfTesResults == 1) {
            s = "done";
        } else if (DD_CSelfTestInProg == 1) {
            s = "inprogress";
        } else if (DD_CSelfTestInProg == 0 && DD_CSelfTestDone == 0) {
            s = "notdone";
        }
        return s;
    }

    private static String getSelfStatus(Long DD_CSelfTestInProg, Long DD_CSelfTestDone, Long DD_CSelfTesResults, Long DD_CSelfTestInProg2, Long DD_CSelfTestDone2, Long DD_CSelfTesResults2) {
        String s = "failed";
        if ((DD_CSelfTestInProg == 0 || DD_CSelfTestInProg2 == 0) &&
                (DD_CSelfTestDone == 1 && DD_CSelfTestDone2 == 1) &&
                (DD_CSelfTesResults == 0 || DD_CSelfTesResults2 == 0)) {
            s = "failed";
        } else if ((DD_CSelfTestInProg == 0 || DD_CSelfTestInProg2 == 0) &&
                (DD_CSelfTestDone == 1 && DD_CSelfTestDone2 == 1) &&
                (DD_CSelfTesResults == 1 && DD_CSelfTesResults2 == 1)) {
            s = "done";
        } else if (DD_CSelfTestInProg == 1 && DD_CSelfTestInProg2 == 1) {
            s = "inprogress";
        } else if ((DD_CSelfTestInProg == 0 || DD_CSelfTestInProg == 0) &&
                (DD_CSelfTestDone == 1 && DD_CSelfTestDone == 1)) {
            s = "notdone";
        }
        return s;
    }

    private static String getStatus(Long dd) {
        return dd == 1 ? "true" : "false";
    }

    private static String getStatus(Long dd, Long cc) {
        String re = "false";
        if (dd == 1 || cc == 1) {
            re = "true";
        }
        return re;
    }
}
