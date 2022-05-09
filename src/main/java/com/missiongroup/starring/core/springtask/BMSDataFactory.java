package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class BMSDataFactory extends DatatFactory {


    public static Map createData() {
        Map data = new HashMap();
        Map sensorFault = createSensorFault();
        data.put("sensorFault", sensorFault);
        Map preProcessorFault = createPreProcessorFault();
        data.put("preProcessorFault", preProcessorFault);
        Map intrumentFault = createIntrumentFault();
        data.put("intrumentFault", intrumentFault);
        Map mainControlUnitMinorFault = createMainControlUnitMinorFault();
        data.put("mainControlUnitMinorFault", mainControlUnitMinorFault);
        Map mainControlUnitMediumFault = createMainControlUnitMediumFault();
        data.put("mainControlUnitMediumFault", mainControlUnitMediumFault);
        Map mainControlUnitCriticalFault = createMainControlUnitCriticalFault();
        data.put("mainControlUnitCriticalFault", mainControlUnitCriticalFault);
        Map temperaturePreWarning = createTemperaturePreWarning();
        data.put("temperaturePreWarning", temperaturePreWarning);
        Map temperatureWarning = createTemperatureWarning();
        data.put("temperatureWarning", temperatureWarning);
        Map bearingWarningLevel = createBearingWarningLevel();
        data.put("bearingWarningLevel", bearingWarningLevel);
        Map bearingWarningLevel2 = createBearingWarningLevel2();
        data.put("bearingWarningLevel2", bearingWarningLevel2);
        Map loadWeightLoadWeight = createLoadWeightLoadWeight();
        data.put("loadWeightLoadWeight", loadWeightLoadWeight);
        Map treadWarningLevel = createTreadWarningLevel();
        data.put("treadWarningLevel", treadWarningLevel);
        Map treadWarningLevel2 = createTreadWarningLevel2();
        data.put("treadWarningLevel2", treadWarningLevel2);
        return data;
    }

    /**
     * Sensor fault
     *
     * @param
     * @return
     */
    private static Map createSensorFault() {
        Map data = new HashMap();
        Long dd_cSensorFltBog1Axle1Left_a1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_A1");
        Long dd_cSensorFltBog1Axle1Right_a1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Right_A1");
        Long dd_cSensorFltBog1Axle2Left_a1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_A1");
        Long dd_cSensorFltBog1Axle2Right_a1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Right_A1");
        Long dd_cSensorFltBog2Axle1Left_a1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_A1");
        Long dd_cSensorFltBog2Axle1Right_a1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Right_A1");
        Long dd_cSensorFltBog2Axle2Right_a1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Right_A1");
        Long dd_cSensorFltBog2Axle2Left_a1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_A1");
        String a1 = getGeneral(dd_cSensorFltBog1Axle1Left_a1, dd_cSensorFltBog1Axle1Right_a1, dd_cSensorFltBog1Axle2Left_a1, dd_cSensorFltBog1Axle2Right_a1, dd_cSensorFltBog2Axle1Left_a1, dd_cSensorFltBog2Axle1Right_a1, dd_cSensorFltBog2Axle2Right_a1, dd_cSensorFltBog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cSensorFltBog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cSensorFltBog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cSensorFltBog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cSensorFltBog2Axle2Right_a1);
        Map SensorFlt_a1Right = new HashMap();
        SensorFlt_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        SensorFlt_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        SensorFlt_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        SensorFlt_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("SensorFlt_a1_Right", SensorFlt_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cSensorFltBog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cSensorFltBog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cSensorFltBog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cSensorFltBog2Axle2Left_a1);
        Map SensorFlt_a1Left = new HashMap();
        SensorFlt_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        SensorFlt_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        SensorFlt_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        SensorFlt_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("SensorFlt_a1_Left", SensorFlt_a1Left);


        Long dd_cSensorFltBog1Axle1Left_a2 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_A2");
        Long dd_cSensorFltBog1Axle1Right_a2 = getValue("port0x131", "DD_CSensorFltBog1Axle1Right_A2");
        Long dd_cSensorFltBog1Axle2Left_a2 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_A2");
        Long dd_cSensorFltBog1Axle2Right_a2 = getValue("port0x131", "DD_CSensorFltBog1Axle2Right_A2");
        Long dd_cSensorFltBog2Axle1Left_a2 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_A2");
        Long dd_cSensorFltBog2Axle1Right_a2 = getValue("port0x131", "DD_CSensorFltBog2Axle1Right_A2");
        Long dd_cSensorFltBog2Axle2Right_a2 = getValue("port0x131", "DD_CSensorFltBog2Axle2Right_A2");
        Long dd_cSensorFltBog2Axle2Left_a2 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_A2");
        String a2 = getGeneral(dd_cSensorFltBog1Axle1Left_a2, dd_cSensorFltBog1Axle1Right_a2, dd_cSensorFltBog1Axle2Left_a2, dd_cSensorFltBog1Axle2Right_a2, dd_cSensorFltBog2Axle1Left_a2, dd_cSensorFltBog2Axle1Right_a2, dd_cSensorFltBog2Axle2Right_a2, dd_cSensorFltBog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cSensorFltBog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cSensorFltBog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cSensorFltBog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cSensorFltBog2Axle2Right_a2);
        Map SensorFlt_a2Right = new HashMap();
        SensorFlt_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        SensorFlt_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        SensorFlt_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        SensorFlt_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("SensorFlt_a2_Right", SensorFlt_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cSensorFltBog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cSensorFltBog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cSensorFltBog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cSensorFltBog2Axle2Left_a2);
        Map SensorFlt_a2Left = new HashMap();
        SensorFlt_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        SensorFlt_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        SensorFlt_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        SensorFlt_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("SensorFlt_a2_Left", SensorFlt_a2Left);

        Long dd_cSensorFltBog1Axle1Left_b1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_B1");
        Long dd_cSensorFltBog1Axle1Right_b1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Right_B1");
        Long dd_cSensorFltBog1Axle2Left_b1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_B1");
        Long dd_cSensorFltBog1Axle2Right_b1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Right_B1");
        Long dd_cSensorFltBog2Axle1Left_b1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_B1");
        Long dd_cSensorFltBog2Axle1Right_b1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Right_B1");
        Long dd_cSensorFltBog2Axle2Right_b1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Right_B1");
        Long dd_cSensorFltBog2Axle2Left_b1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_B1");
        String b1 = getGeneral(dd_cSensorFltBog1Axle1Left_b1, dd_cSensorFltBog1Axle1Right_b1, dd_cSensorFltBog1Axle2Left_b1, dd_cSensorFltBog1Axle2Right_b1, dd_cSensorFltBog2Axle1Left_b1, dd_cSensorFltBog2Axle1Right_b1, dd_cSensorFltBog2Axle2Right_b1, dd_cSensorFltBog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cSensorFltBog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cSensorFltBog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cSensorFltBog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cSensorFltBog2Axle2Right_b1);
        Map SensorFlt_b1Right = new HashMap();
        SensorFlt_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        SensorFlt_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        SensorFlt_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        SensorFlt_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("SensorFlt_b1_Right", SensorFlt_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cSensorFltBog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cSensorFltBog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cSensorFltBog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cSensorFltBog2Axle2Left_b1);
        Map SensorFlt_b1Left = new HashMap();
        SensorFlt_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        SensorFlt_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        SensorFlt_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        SensorFlt_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("SensorFlt_b1_Left", SensorFlt_b1Left);


        Long dd_cSensorFltBog1Axle1Left_b2 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_B2");
        Long dd_cSensorFltBog1Axle1Right_b2 = getValue("port0x129", "DD_CSensorFltBog1Axle1Right_B2");
        Long dd_cSensorFltBog1Axle2Left_b2 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_B2");
        Long dd_cSensorFltBog1Axle2Right_b2 = getValue("port0x129", "DD_CSensorFltBog1Axle2Right_B2");
        Long dd_cSensorFltBog2Axle1Left_b2 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_B2");
        Long dd_cSensorFltBog2Axle1Right_b2 = getValue("port0x129", "DD_CSensorFltBog2Axle1Right_B2");
        Long dd_cSensorFltBog2Axle2Right_b2 = getValue("port0x131", "DD_CSensorFltBog2Axle2Right_B2");
        Long dd_cSensorFltBog2Axle2Left_b2 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_B2");
        String b2 = getGeneral(dd_cSensorFltBog1Axle1Left_b2, dd_cSensorFltBog1Axle1Right_b2, dd_cSensorFltBog1Axle2Left_b2, dd_cSensorFltBog1Axle2Right_b2, dd_cSensorFltBog2Axle1Left_b2, dd_cSensorFltBog2Axle1Right_b2, dd_cSensorFltBog2Axle2Right_b2, dd_cSensorFltBog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cSensorFltBog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cSensorFltBog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cSensorFltBog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cSensorFltBog2Axle2Right_b2);
        Map SensorFlt_b2Right = new HashMap();
        SensorFlt_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        SensorFlt_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        SensorFlt_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        SensorFlt_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("SensorFlt_b2_Right", SensorFlt_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cSensorFltBog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cSensorFltBog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cSensorFltBog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cSensorFltBog2Axle2Left_b2);
        Map SensorFlt_b2Left = new HashMap();
        SensorFlt_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        SensorFlt_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        SensorFlt_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        SensorFlt_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("SensorFlt_b2_Left", SensorFlt_b2Left);


        Long dd_cSensorFltBog1Axle1Left_c1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_C1");
        Long dd_cSensorFltBog1Axle1Right_c1 = getValue("port0x129", "DD_CSensorFltBog1Axle1Right_C1");
        Long dd_cSensorFltBog1Axle2Left_c1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_C1");
        Long dd_cSensorFltBog1Axle2Right_c1 = getValue("port0x129", "DD_CSensorFltBog1Axle2Right_C1");
        Long dd_cSensorFltBog2Axle1Left_c1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_C1");
        Long dd_cSensorFltBog2Axle1Right_c1 = getValue("port0x129", "DD_CSensorFltBog2Axle1Right_C1");
        Long dd_cSensorFltBog2Axle2Right_c1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Right_C1");
        Long dd_cSensorFltBog2Axle2Left_c1 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_C1");
        String c1 = getGeneral(dd_cSensorFltBog1Axle1Left_c1, dd_cSensorFltBog1Axle1Right_c1, dd_cSensorFltBog1Axle2Left_c1, dd_cSensorFltBog1Axle2Right_c1, dd_cSensorFltBog2Axle1Left_c1, dd_cSensorFltBog2Axle1Right_c1, dd_cSensorFltBog2Axle2Right_c1, dd_cSensorFltBog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cSensorFltBog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cSensorFltBog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cSensorFltBog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cSensorFltBog2Axle2Right_c1);
        Map SensorFlt_c1 = new HashMap();
        SensorFlt_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        SensorFlt_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        SensorFlt_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        SensorFlt_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("SensorFlt_c1_Right", SensorFlt_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cSensorFltBog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cSensorFltBog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cSensorFltBog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cSensorFltBog2Axle2Left_c1);
        Map SensorFlt_c1Left = new HashMap();
        SensorFlt_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        SensorFlt_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        SensorFlt_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        SensorFlt_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("SensorFlt_c1_Left", SensorFlt_c1Left);


        Long dd_cSensorFltBog1Axle1Left_c2 = getValue("port0x129", "DD_CSensorFltBog1Axle1Left_C2");
        Long dd_cSensorFltBog1Axle1Right_c2 = getValue("port0x129", "DD_CSensorFltBog1Axle1Right_C2");
        Long dd_cSensorFltBog1Axle2Left_c2 = getValue("port0x129", "DD_CSensorFltBog1Axle2Left_C2");
        Long dd_cSensorFltBog1Axle2Right_c2 = getValue("port0x129", "DD_CSensorFltBog1Axle2Right_C2");
        Long dd_cSensorFltBog2Axle1Left_c2 = getValue("port0x129", "DD_CSensorFltBog2Axle1Left_C2");
        Long dd_cSensorFltBog2Axle1Right_c2 = getValue("port0x129", "DD_CSensorFltBog2Axle1Right_C2");
        Long dd_cSensorFltBog2Axle2Right_c2 = getValue("port0x129", "DD_CSensorFltBog2Axle2Right_C2");
        Long dd_cSensorFltBog2Axle2Left_c2 = getValue("port0x129", "DD_CSensorFltBog2Axle2Left_C2");
        String c2 = getGeneral(dd_cSensorFltBog1Axle1Left_c2, dd_cSensorFltBog1Axle1Right_c2, dd_cSensorFltBog1Axle2Left_c2, dd_cSensorFltBog1Axle2Right_c2, dd_cSensorFltBog2Axle1Left_c2, dd_cSensorFltBog2Axle1Right_c2, dd_cSensorFltBog2Axle2Right_c2, dd_cSensorFltBog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cSensorFltBog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cSensorFltBog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cSensorFltBog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cSensorFltBog2Axle2Right_c2);
        Map SensorFlt_c2Right = new HashMap();
        SensorFlt_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        SensorFlt_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        SensorFlt_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        SensorFlt_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("SensorFlt_c2_Right", SensorFlt_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cSensorFltBog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cSensorFltBog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cSensorFltBog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cSensorFltBog2Axle2Left_c2);
        Map SensorFlt_c2Left = new HashMap();
        SensorFlt_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        SensorFlt_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        SensorFlt_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        SensorFlt_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("SensorFlt_c2_Left", SensorFlt_c2Left);
        return data;
    }

    private static String getGeneral(Long dd_cSensorFltBog1Axle1Left_, Long dd_cSensorFltBog1Axle1Right_, Long dd_cSensorFltBog1Axle2Left_, Long dd_cSensorFltBog1Axle2Right_, Long dd_cSensorFltBog2Axle1Left_, Long dd_cSensorFltBog2Axle1Right_, Long dd_cSensorFltBog2Axle2Right_, Long dd_cSensorFltBog2Axle2Left_) {
        String t = "false";
        if (dd_cSensorFltBog1Axle1Left_ == 1 ||
                dd_cSensorFltBog1Axle1Right_ == 1 ||
                dd_cSensorFltBog1Axle2Left_ == 1 ||
                dd_cSensorFltBog1Axle2Right_ == 1 ||
                dd_cSensorFltBog2Axle1Left_ == 1 ||
                dd_cSensorFltBog2Axle1Right_ == 1 ||
                dd_cSensorFltBog2Axle2Right_ == 1 ||
                dd_cSensorFltBog2Axle2Left_ == 1) {
            t = "true";
        }
        return t;
    }

    /**
     * Pre-Processor fault
     *
     * @param
     * @return
     */
    private static Map createPreProcessorFault() {
        Map data = new HashMap();
        Long dd_cPreProcessorFlt_a1 = getValue("port0x129", "DD_CPreProcessorFlt_A1");
        String a1 = getStatus(dd_cPreProcessorFlt_a1);
        data.put("a1", a1);
        Long dd_cPreProcessorFlt_a2 = getValue("port0x129", "DD_CPreProcessorFlt_A2");
        String a2 = getStatus(dd_cPreProcessorFlt_a2);
        data.put("a2", a2);
        Long dd_cPreProcessorFlt_b1 = getValue("port0x129", "DD_CPreProcessorFlt_B1");
        String b1 = getStatus(dd_cPreProcessorFlt_b1);
        data.put("b1", b1);
        Long dd_cPreProcessorFlt_b2 = getValue("port0x129", "DD_CPreProcessorFlt_B2");
        String b2 = getStatus(dd_cPreProcessorFlt_b2);
        data.put("b2", b2);
        Long dd_cPreProcessorFlt_c1 = getValue("port0x129", "DD_CPreProcessorFlt_C1");
        String c1 = getStatus(dd_cPreProcessorFlt_c1);
        data.put("c1", c1);
        Long dd_cPreProcessorFlt_c2 = getValue("port0x129", "DD_CPreProcessorFlt_C2");
        String c2 = getStatus(dd_cPreProcessorFlt_c2);
        data.put("c2", c2);
        return data;
    }


    /**
     * Instrument fault
     *
     * @param
     * @return
     */
    private static Map createIntrumentFault() {
        Map data = new HashMap();
        Long dd_cInstrumentFlt_a1 = getValue("port0x129", "DD_CInstrumentFlt_A1");
        Long dd_cInstrumentFlt_a2 = getValue("port0x129", "DD_CInstrumentFlt_A2");
        Long dd_cInstrumentFlt_b1 = getValue("port0x129", "DD_CInstrumentFlt_B1");
        Long dd_cInstrumentFlt_b2 = getValue("port0x129", "DD_CInstrumentFlt_B2");
        Long dd_cInstrumentFlt_c1 = getValue("port0x129", "DD_CInstrumentFlt_C1");
        Long dd_cInstrumentFlt_c2 = getValue("port0x129", "DD_CInstrumentFlt_C2");
        String a1 = getStatus(dd_cInstrumentFlt_a1);
        data.put("a1", a1);
        String a2 = getStatus(dd_cInstrumentFlt_a2);
        data.put("a2", a2);
        String b1 = getStatus(dd_cInstrumentFlt_b1);
        data.put("b1", b1);
        String b2 = getStatus(dd_cInstrumentFlt_b2);
        data.put("b2", b2);
        String c1 = getStatus(dd_cInstrumentFlt_c1);
        data.put("c1", c1);
        String c2 = getStatus(dd_cInstrumentFlt_c2);
        data.put("c2", c2);
        return data;
    }


    /**
     * Main Control unit minor fault
     *
     * @param
     * @return
     */
    private static Map createMainControlUnitMinorFault() {
        Map data = new HashMap();
        Long dd_cbms1MCUMinorFlt = getValue("port0x129", "DD_CBMS1MCUMinorFlt");
        Long dd_cbms2MCUMinorFlt = getValue("port0x129", "DD_CBMS2MCUMinorFlt");
        String bms1 = getStatus(dd_cbms1MCUMinorFlt);
        data.put("bms1", bms1);
        String bms2 = getStatus(dd_cbms2MCUMinorFlt);
        data.put("bms2", bms2);

        return data;
    }


    /**
     * Main control unit medium fault
     *
     * @param
     * @return
     */
    private static Map createMainControlUnitMediumFault() {
        Map data = new HashMap();
        Long dd_cbms1MCUMediumFlt = getValue("port0x129", "DD_CBMS1MCUMediumFlt");
        Long dd_cbms2MCUMediumFlt = getValue("port0x129", "DD_CBMS2MCUMediumFlt");

        String bms1 = getStatus(dd_cbms1MCUMediumFlt);
        data.put("bms1", bms1);
        String bms2 = getStatus(dd_cbms2MCUMediumFlt);
        data.put("bms2", bms2);

        return data;
    }


    /**
     * Main control unit critical fault
     *
     * @param
     * @return
     */
    private static Map createMainControlUnitCriticalFault() {
        Map data = new HashMap();
        Long dd_cbms1MCUCriticalFlt = getValue("port0x129", "DD_CBMS1MCUCriticalFlt");
        Long dd_cbms2MCUCriticalFlt = getValue("port0x129", "DD_CBMS2MCUCriticalFlt");

        String bms1 = getStatus(dd_cbms1MCUCriticalFlt);
        data.put("bms1", bms1);
        String bms2 = getStatus(dd_cbms2MCUCriticalFlt);
        data.put("bms2", bms2);

        return data;
    }

    private static String getStatus(Long dd) {
        String t = "false";
        if (dd == 1) {
            t = "true";
        }
        return t;
    }

    /**
     * Temperature pre-warning
     *
     * @return
     */
    private static Map createTemperaturePreWarning() {
        Map data = new HashMap();

        Long dd_cTempPreWarnBog1Axle1Left_a1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_A1");
        Long dd_cTempPreWarnBog1Axle1Right_a1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_A1");
        Long dd_cTempPreWarnBog1Axle2Left_a1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_A1");
        Long dd_cTempPreWarnBog1Axle2Right_a1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_A1");
        Long dd_cTempPreWarnBog2Axle1Left_a1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_A1");
        Long dd_cTempPreWarnBog2Axle1Right_a1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_A1");
        Long dd_cTempPreWarnBog2Axle2Right_a1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_A1");
        Long dd_cTempPreWarnBog2Axle2Left_a1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_A1");
        String a1 = getGeneral(dd_cTempPreWarnBog1Axle1Left_a1, dd_cTempPreWarnBog1Axle1Right_a1, dd_cTempPreWarnBog1Axle2Left_a1, dd_cTempPreWarnBog1Axle2Right_a1, dd_cTempPreWarnBog2Axle1Left_a1, dd_cTempPreWarnBog2Axle1Right_a1, dd_cTempPreWarnBog2Axle2Right_a1, dd_cTempPreWarnBog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cTempPreWarnBog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cTempPreWarnBog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cTempPreWarnBog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cTempPreWarnBog2Axle2Right_a1);
        Map TempPreWarn_a1Right = new HashMap();
        TempPreWarn_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        TempPreWarn_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        TempPreWarn_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        TempPreWarn_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("TempPreWarn_a1_Right", TempPreWarn_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cTempPreWarnBog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cTempPreWarnBog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cTempPreWarnBog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cTempPreWarnBog2Axle2Left_a1);
        Map TempPreWarn_a1Left = new HashMap();
        TempPreWarn_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        TempPreWarn_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        TempPreWarn_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        TempPreWarn_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("TempPreWarn_a1_Left", TempPreWarn_a1Left);


        Long dd_cTempPreWarnBog1Axle1Left_a2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_A2");
        Long dd_cTempPreWarnBog1Axle1Right_a2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_A2");
        Long dd_cTempPreWarnBog1Axle2Left_a2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_A2");
        Long dd_cTempPreWarnBog1Axle2Right_a2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_A2");
        Long dd_cTempPreWarnBog2Axle1Left_a2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_A2");
        Long dd_cTempPreWarnBog2Axle1Right_a2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_A2");
        Long dd_cTempPreWarnBog2Axle2Right_a2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_A2");
        Long dd_cTempPreWarnBog2Axle2Left_a2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_A2");
        String a2 = getGeneral(dd_cTempPreWarnBog1Axle1Left_a2, dd_cTempPreWarnBog1Axle1Right_a2, dd_cTempPreWarnBog1Axle2Left_a2, dd_cTempPreWarnBog1Axle2Right_a2, dd_cTempPreWarnBog2Axle1Left_a2, dd_cTempPreWarnBog2Axle1Right_a2, dd_cTempPreWarnBog2Axle2Right_a2, dd_cTempPreWarnBog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cTempPreWarnBog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cTempPreWarnBog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cTempPreWarnBog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cTempPreWarnBog2Axle2Right_a2);
        Map TempPreWarn_a2Right = new HashMap();
        TempPreWarn_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        TempPreWarn_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        TempPreWarn_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        TempPreWarn_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("TempPreWarn_a2_Right", TempPreWarn_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cTempPreWarnBog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cTempPreWarnBog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cTempPreWarnBog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cTempPreWarnBog2Axle2Left_a2);
        Map TempPreWarn_a2Left = new HashMap();
        TempPreWarn_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        TempPreWarn_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        TempPreWarn_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        TempPreWarn_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("TempPreWarn_a2_Left", TempPreWarn_a2Left);


        Long dd_cTempPreWarnBog1Axle1Left_b1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_B1");
        Long dd_cTempPreWarnBog1Axle1Right_b1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_B1");
        Long dd_cTempPreWarnBog1Axle2Left_b1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_B1");
        Long dd_cTempPreWarnBog1Axle2Right_b1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_B1");
        Long dd_cTempPreWarnBog2Axle1Left_b1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_B1");
        Long dd_cTempPreWarnBog2Axle1Right_b1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_B1");
        Long dd_cTempPreWarnBog2Axle2Right_b1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_B1");
        Long dd_cTempPreWarnBog2Axle2Left_b1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_B1");
        String b1 = getGeneral(dd_cTempPreWarnBog1Axle1Left_b1, dd_cTempPreWarnBog1Axle1Right_b1, dd_cTempPreWarnBog1Axle2Left_b1, dd_cTempPreWarnBog1Axle2Right_b1, dd_cTempPreWarnBog2Axle1Left_b1, dd_cTempPreWarnBog2Axle1Right_b1, dd_cTempPreWarnBog2Axle2Right_b1, dd_cTempPreWarnBog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cTempPreWarnBog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cTempPreWarnBog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cTempPreWarnBog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cTempPreWarnBog2Axle2Right_b1);
        Map TempPreWarn_b1Right = new HashMap();
        TempPreWarn_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        TempPreWarn_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        TempPreWarn_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        TempPreWarn_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("TempPreWarn_b1_Right", TempPreWarn_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cTempPreWarnBog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cTempPreWarnBog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cTempPreWarnBog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cTempPreWarnBog2Axle2Left_b1);
        Map TempPreWarn_b1Left = new HashMap();
        TempPreWarn_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        TempPreWarn_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        TempPreWarn_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        TempPreWarn_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("TempPreWarn_b1_Left", TempPreWarn_b1Left);

        Long dd_cTempPreWarnBog1Axle1Left_b2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_B2");
        Long dd_cTempPreWarnBog1Axle1Right_b2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_B2");
        Long dd_cTempPreWarnBog1Axle2Left_b2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_B2");
        Long dd_cTempPreWarnBog1Axle2Right_b2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_B2");
        Long dd_cTempPreWarnBog2Axle1Left_b2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_B2");
        Long dd_cTempPreWarnBog2Axle1Right_b2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_B2");
        Long dd_cTempPreWarnBog2Axle2Right_b2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_B2");
        Long dd_cTempPreWarnBog2Axle2Left_b2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_B2");
        String b2 = getGeneral(dd_cTempPreWarnBog1Axle1Left_b2, dd_cTempPreWarnBog1Axle1Right_b2, dd_cTempPreWarnBog1Axle2Left_b2, dd_cTempPreWarnBog1Axle2Right_b2, dd_cTempPreWarnBog2Axle1Left_b2, dd_cTempPreWarnBog2Axle1Right_b2, dd_cTempPreWarnBog2Axle2Right_b2, dd_cTempPreWarnBog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cTempPreWarnBog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cTempPreWarnBog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cTempPreWarnBog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cTempPreWarnBog2Axle2Right_b2);
        Map TempPreWarn_b2Right = new HashMap();
        TempPreWarn_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        TempPreWarn_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        TempPreWarn_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        TempPreWarn_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("TempPreWarn_b2_Right", TempPreWarn_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cTempPreWarnBog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cTempPreWarnBog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cTempPreWarnBog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cTempPreWarnBog2Axle2Left_b2);
        Map TempPreWarn_b2Left = new HashMap();
        TempPreWarn_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        TempPreWarn_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        TempPreWarn_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        TempPreWarn_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("TempPreWarn_b2_Left", TempPreWarn_b2Left);


        Long dd_cTempPreWarnBog1Axle1Left_c1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_C1");
        Long dd_cTempPreWarnBog1Axle1Right_c1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_C1");
        Long dd_cTempPreWarnBog1Axle2Left_c1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_C1");
        Long dd_cTempPreWarnBog1Axle2Right_c1 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_C1");
        Long dd_cTempPreWarnBog2Axle1Left_c1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_C1");
        Long dd_cTempPreWarnBog2Axle1Right_c1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_C1");
        Long dd_cTempPreWarnBog2Axle2Right_c1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_C1");
        Long dd_cTempPreWarnBog2Axle2Left_c1 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_C1");
        String c1 = getGeneral(dd_cTempPreWarnBog1Axle1Left_c1, dd_cTempPreWarnBog1Axle1Right_c1, dd_cTempPreWarnBog1Axle2Left_c1, dd_cTempPreWarnBog1Axle2Right_c1, dd_cTempPreWarnBog2Axle1Left_c1, dd_cTempPreWarnBog2Axle1Right_c1, dd_cTempPreWarnBog2Axle2Right_c1, dd_cTempPreWarnBog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cTempPreWarnBog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cTempPreWarnBog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cTempPreWarnBog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cTempPreWarnBog2Axle2Right_c1);
        Map TempPreWarn_c1 = new HashMap();
        TempPreWarn_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        TempPreWarn_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        TempPreWarn_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        TempPreWarn_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("TempPreWarn_c1_Right", TempPreWarn_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cTempPreWarnBog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cTempPreWarnBog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cTempPreWarnBog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cTempPreWarnBog2Axle2Left_c1);
        Map TempPreWarn_c1Left = new HashMap();
        TempPreWarn_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        TempPreWarn_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        TempPreWarn_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        TempPreWarn_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("TempPreWarn_c1_Left", TempPreWarn_c1Left);

        Long dd_cTempPreWarnBog1Axle1Left_c2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Left_C2");
        Long dd_cTempPreWarnBog1Axle1Right_c2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle1Right_C2");
        Long dd_cTempPreWarnBog1Axle2Left_c2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Left_C2");
        Long dd_cTempPreWarnBog1Axle2Right_c2 = getValue("port0x131", "DD_CTempPreWarnBog1Axle2Right_C2");
        Long dd_cTempPreWarnBog2Axle1Left_c2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Left_C2");
        Long dd_cTempPreWarnBog2Axle1Right_c2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle1Right_C2");
        Long dd_cTempPreWarnBog2Axle2Right_c2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Right_C2");
        Long dd_cTempPreWarnBog2Axle2Left_c2 = getValue("port0x131", "DD_CTempPreWarnBog2Axle2Left_C2");
        String c2 = getGeneral(dd_cTempPreWarnBog1Axle1Left_c2, dd_cTempPreWarnBog1Axle1Right_c2, dd_cTempPreWarnBog1Axle2Left_c2, dd_cTempPreWarnBog1Axle2Right_c2, dd_cTempPreWarnBog2Axle1Left_c2, dd_cTempPreWarnBog2Axle1Right_c2, dd_cTempPreWarnBog2Axle2Right_c2, dd_cTempPreWarnBog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cTempPreWarnBog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cTempPreWarnBog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cTempPreWarnBog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cTempPreWarnBog2Axle2Right_c2);
        Map TempPreWarn_c2Right = new HashMap();
        TempPreWarn_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        TempPreWarn_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        TempPreWarn_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        TempPreWarn_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("TempPreWarn_c2_Right", TempPreWarn_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cTempPreWarnBog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cTempPreWarnBog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cTempPreWarnBog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cTempPreWarnBog2Axle2Left_c2);
        Map TempPreWarn_c2Left = new HashMap();
        TempPreWarn_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        TempPreWarn_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        TempPreWarn_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        TempPreWarn_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("TempPreWarn_c2_Left", TempPreWarn_c2Left);
        return data;
    }


    /**
     * TemperatureWarning
     *
     * @return
     */
    private static Map createTemperatureWarning() {

        Map data = new HashMap();


        Long dd_cTempWarnBog1Axle1Left_a1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_A1");
        Long dd_cTempWarnBog1Axle1Right_a1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_A1");
        Long dd_cTempWarnBog1Axle2Left_a1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_A1");
        Long dd_cTempWarnBog1Axle2Right_a1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_A1");
        Long dd_cTempWarnBog2Axle1Left_a1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_A1");
        Long dd_cTempWarnBog2Axle1Right_a1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_A1");
        Long dd_cTempWarnBog2Axle2Right_a1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_A1");
        Long dd_cTempWarnBog2Axle2Left_a1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_A1");
        String a1 = getGeneral(dd_cTempWarnBog1Axle1Left_a1, dd_cTempWarnBog1Axle1Right_a1, dd_cTempWarnBog1Axle2Left_a1, dd_cTempWarnBog1Axle2Right_a1, dd_cTempWarnBog2Axle1Left_a1, dd_cTempWarnBog2Axle1Right_a1, dd_cTempWarnBog2Axle2Right_a1, dd_cTempWarnBog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cTempWarnBog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cTempWarnBog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cTempWarnBog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cTempWarnBog2Axle2Right_a1);
        Map TempWarn_a1Right = new HashMap();
        TempWarn_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        TempWarn_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        TempWarn_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        TempWarn_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("TempWarn_a1_Right", TempWarn_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cTempWarnBog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cTempWarnBog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cTempWarnBog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cTempWarnBog2Axle2Left_a1);
        Map TempWarn_a1Left = new HashMap();
        TempWarn_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        TempWarn_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        TempWarn_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        TempWarn_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("TempWarn_a1_Left", TempWarn_a1Left);

        Long dd_cTempWarnBog1Axle1Left_a2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_A2");
        Long dd_cTempWarnBog1Axle1Right_a2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_A2");
        Long dd_cTempWarnBog1Axle2Left_a2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_A2");
        Long dd_cTempWarnBog1Axle2Right_a2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_A2");
        Long dd_cTempWarnBog2Axle1Left_a2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_A2");
        Long dd_cTempWarnBog2Axle1Right_a2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_A2");
        Long dd_cTempWarnBog2Axle2Right_a2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_A2");
        Long dd_cTempWarnBog2Axle2Left_a2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_A2");
        String a2 = getGeneral(dd_cTempWarnBog1Axle1Left_a2, dd_cTempWarnBog1Axle1Right_a2, dd_cTempWarnBog1Axle2Left_a2, dd_cTempWarnBog1Axle2Right_a2, dd_cTempWarnBog2Axle1Left_a2, dd_cTempWarnBog2Axle1Right_a2, dd_cTempWarnBog2Axle2Right_a2, dd_cTempWarnBog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cTempWarnBog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cTempWarnBog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cTempWarnBog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cTempWarnBog2Axle2Right_a2);
        Map TempWarn_a2Right = new HashMap();
        TempWarn_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        TempWarn_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        TempWarn_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        TempWarn_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("TempWarn_a2_Right", TempWarn_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cTempWarnBog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cTempWarnBog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cTempWarnBog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cTempWarnBog2Axle2Left_a2);
        Map TempWarn_a2Left = new HashMap();
        TempWarn_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        TempWarn_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        TempWarn_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        TempWarn_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("TempWarn_a2_Left", TempWarn_a2Left);


        Long dd_cTempWarnBog1Axle1Left_b1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_B1");
        Long dd_cTempWarnBog1Axle1Right_b1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_B1");
        Long dd_cTempWarnBog1Axle2Left_b1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_B1");
        Long dd_cTempWarnBog1Axle2Right_b1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_B1");
        Long dd_cTempWarnBog2Axle1Left_b1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_B1");
        Long dd_cTempWarnBog2Axle1Right_b1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_B1");
        Long dd_cTempWarnBog2Axle2Right_b1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_B1");
        Long dd_cTempWarnBog2Axle2Left_b1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_B1");
        String b1 = getGeneral(dd_cTempWarnBog1Axle1Left_b1, dd_cTempWarnBog1Axle1Right_b1, dd_cTempWarnBog1Axle2Left_b1, dd_cTempWarnBog1Axle2Right_b1, dd_cTempWarnBog2Axle1Left_b1, dd_cTempWarnBog2Axle1Right_b1, dd_cTempWarnBog2Axle2Right_b1, dd_cTempWarnBog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cTempWarnBog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cTempWarnBog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cTempWarnBog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cTempWarnBog2Axle2Right_b1);
        Map TempWarn_b1Right = new HashMap();
        TempWarn_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        TempWarn_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        TempWarn_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        TempWarn_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("TempWarn_b1_Right", TempWarn_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cTempWarnBog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cTempWarnBog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cTempWarnBog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cTempWarnBog2Axle2Left_b1);
        Map TempWarn_b1Left = new HashMap();
        TempWarn_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        TempWarn_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        TempWarn_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        TempWarn_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("TempWarn_b1_Left", TempWarn_b1Left);


        Long dd_cTempWarnBog1Axle1Left_b2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_B2");
        Long dd_cTempWarnBog1Axle1Right_b2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_B2");
        Long dd_cTempWarnBog1Axle2Left_b2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_B2");
        Long dd_cTempWarnBog1Axle2Right_b2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_B2");
        Long dd_cTempWarnBog2Axle1Left_b2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_B2");
        Long dd_cTempWarnBog2Axle1Right_b2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_B2");
        Long dd_cTempWarnBog2Axle2Right_b2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_B2");
        Long dd_cTempWarnBog2Axle2Left_b2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_B2");
        String b2 = getGeneral(dd_cTempWarnBog1Axle1Left_b2, dd_cTempWarnBog1Axle1Right_b2, dd_cTempWarnBog1Axle2Left_b2, dd_cTempWarnBog1Axle2Right_b2, dd_cTempWarnBog2Axle1Left_b2, dd_cTempWarnBog2Axle1Right_b2, dd_cTempWarnBog2Axle2Right_b2, dd_cTempWarnBog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cTempWarnBog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cTempWarnBog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cTempWarnBog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cTempWarnBog2Axle2Right_b2);
        Map TempWarn_b2Right = new HashMap();
        TempWarn_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        TempWarn_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        TempWarn_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        TempWarn_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("TempWarn_b2_Right", TempWarn_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cTempWarnBog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cTempWarnBog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cTempWarnBog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cTempWarnBog2Axle2Left_b2);
        Map TempWarn_b2Left = new HashMap();
        TempWarn_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        TempWarn_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        TempWarn_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        TempWarn_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("TempWarn_b2_Left", TempWarn_b2Left);


        Long dd_cTempWarnBog1Axle1Left_c1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_C1");
        Long dd_cTempWarnBog1Axle1Right_c1 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_C1");
        Long dd_cTempWarnBog1Axle2Left_c1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_C1");
        Long dd_cTempWarnBog1Axle2Right_c1 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_C1");
        Long dd_cTempWarnBog2Axle1Left_c1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_C1");
        Long dd_cTempWarnBog2Axle1Right_c1 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_C1");
        Long dd_cTempWarnBog2Axle2Right_c1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_C1");
        Long dd_cTempWarnBog2Axle2Left_c1 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_C1");
        String c1 = getGeneral(dd_cTempWarnBog1Axle1Left_c1, dd_cTempWarnBog1Axle1Right_c1, dd_cTempWarnBog1Axle2Left_c1, dd_cTempWarnBog1Axle2Right_c1, dd_cTempWarnBog2Axle1Left_c1, dd_cTempWarnBog2Axle1Right_c1, dd_cTempWarnBog2Axle2Right_c1, dd_cTempWarnBog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cTempWarnBog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cTempWarnBog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cTempWarnBog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cTempWarnBog2Axle2Right_c1);
        Map TempWarn_c1 = new HashMap();
        TempWarn_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        TempWarn_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        TempWarn_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        TempWarn_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("TempWarn_c1_Right", TempWarn_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cTempWarnBog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cTempWarnBog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cTempWarnBog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cTempWarnBog2Axle2Left_c1);
        Map TempWarn_c1Left = new HashMap();
        TempWarn_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        TempWarn_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        TempWarn_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        TempWarn_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("TempWarn_c1_Left", TempWarn_c1Left);

        Long dd_cTempWarnBog1Axle1Left_c2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Left_C2");
        Long dd_cTempWarnBog1Axle1Right_c2 = getValue("port0x131", "DD_CTempWarnBog1Axle1Right_C2");
        Long dd_cTempWarnBog1Axle2Left_c2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Left_C2");
        Long dd_cTempWarnBog1Axle2Right_c2 = getValue("port0x131", "DD_CTempWarnBog1Axle2Right_C2");
        Long dd_cTempWarnBog2Axle1Left_c2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Left_C2");
        Long dd_cTempWarnBog2Axle1Right_c2 = getValue("port0x131", "DD_CTempWarnBog2Axle1Right_C2");
        Long dd_cTempWarnBog2Axle2Right_c2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Right_C2");
        Long dd_cTempWarnBog2Axle2Left_c2 = getValue("port0x131", "DD_CTempWarnBog2Axle2Left_C2");
        String c2 = getGeneral(dd_cTempWarnBog1Axle1Left_c2, dd_cTempWarnBog1Axle1Right_c2, dd_cTempWarnBog1Axle2Left_c2, dd_cTempWarnBog1Axle2Right_c2, dd_cTempWarnBog2Axle1Left_c2, dd_cTempWarnBog2Axle1Right_c2, dd_cTempWarnBog2Axle2Right_c2, dd_cTempWarnBog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cTempWarnBog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cTempWarnBog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cTempWarnBog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cTempWarnBog2Axle2Right_c2);
        Map TempWarn_c2Right = new HashMap();
        TempWarn_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        TempWarn_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        TempWarn_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        TempWarn_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("TempWarn_c2_Right", TempWarn_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cTempWarnBog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cTempWarnBog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cTempWarnBog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cTempWarnBog2Axle2Left_c2);
        Map TempWarn_c2Left = new HashMap();
        TempWarn_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        TempWarn_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        TempWarn_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        TempWarn_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("TempWarn_c2_Left", TempWarn_c2Left);
        return data;
    }


    /**
     * Bearing warning level
     *
     * @return
     */
    private static Map createBearingWarningLevel() {

        Map data = new HashMap();

        Long dd_cBearingWarnLvl1Bog1Axle1Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_A1");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_A1");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_A1");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_A1");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_A1");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_A1");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_A1");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_A1");
        String a1 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_a1, dd_cBearingWarnLvl1Bog1Axle1Right_a1, dd_cBearingWarnLvl1Bog1Axle2Left_a1, dd_cBearingWarnLvl1Bog1Axle2Right_a1, dd_cBearingWarnLvl1Bog2Axle1Left_a1, dd_cBearingWarnLvl1Bog2Axle1Right_a1, dd_cBearingWarnLvl1Bog2Axle2Right_a1, dd_cBearingWarnLvl1Bog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_a1);
        Map BearingWarnLvl1_a1Right = new HashMap();
        BearingWarnLvl1_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        BearingWarnLvl1_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        BearingWarnLvl1_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        BearingWarnLvl1_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("BearingWarnLvl1_a1_Right", BearingWarnLvl1_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_a1);
        Map BearingWarnLvl1_a1Left = new HashMap();
        BearingWarnLvl1_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        BearingWarnLvl1_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        BearingWarnLvl1_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        BearingWarnLvl1_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("BearingWarnLvl1_a1_Left", BearingWarnLvl1_a1Left);
        Long dd_cBearingWarnLvl1Bog1Axle1Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_A2");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_A2");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_A2");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_A2");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_A2");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_A2");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_A2");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_A2");
        String a2 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_a2, dd_cBearingWarnLvl1Bog1Axle1Right_a2, dd_cBearingWarnLvl1Bog1Axle2Left_a2, dd_cBearingWarnLvl1Bog1Axle2Right_a2, dd_cBearingWarnLvl1Bog2Axle1Left_a2, dd_cBearingWarnLvl1Bog2Axle1Right_a2, dd_cBearingWarnLvl1Bog2Axle2Right_a2, dd_cBearingWarnLvl1Bog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_a2);
        Map BearingWarnLvl1_a2Right = new HashMap();
        BearingWarnLvl1_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        BearingWarnLvl1_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        BearingWarnLvl1_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        BearingWarnLvl1_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("BearingWarnLvl1_a2_Right", BearingWarnLvl1_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_a2);
        Map BearingWarnLvl1_a2Left = new HashMap();
        BearingWarnLvl1_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        BearingWarnLvl1_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        BearingWarnLvl1_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        BearingWarnLvl1_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("BearingWarnLvl1_a2_Left", BearingWarnLvl1_a2Left);


        Long dd_cBearingWarnLvl1Bog1Axle1Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_B1");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_B1");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_B1");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_B1");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_B1");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_B1");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_B1");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_B1");
        String b1 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_b1, dd_cBearingWarnLvl1Bog1Axle1Right_b1, dd_cBearingWarnLvl1Bog1Axle2Left_b1, dd_cBearingWarnLvl1Bog1Axle2Right_b1, dd_cBearingWarnLvl1Bog2Axle1Left_b1, dd_cBearingWarnLvl1Bog2Axle1Right_b1, dd_cBearingWarnLvl1Bog2Axle2Right_b1, dd_cBearingWarnLvl1Bog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_b1);
        Map BearingWarnLvl1_b1Right = new HashMap();
        BearingWarnLvl1_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        BearingWarnLvl1_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        BearingWarnLvl1_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        BearingWarnLvl1_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("BearingWarnLvl1_b1_Right", BearingWarnLvl1_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_b1);
        Map BearingWarnLvl1_b1Left = new HashMap();
        BearingWarnLvl1_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        BearingWarnLvl1_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        BearingWarnLvl1_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        BearingWarnLvl1_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("BearingWarnLvl1_b1_Left", BearingWarnLvl1_b1Left);


        Long dd_cBearingWarnLvl1Bog1Axle1Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_B2");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_B2");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_B2");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_B2");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_B2");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_B2");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_B2");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_B2");
        String b2 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_b2, dd_cBearingWarnLvl1Bog1Axle1Right_b2, dd_cBearingWarnLvl1Bog1Axle2Left_b2, dd_cBearingWarnLvl1Bog1Axle2Right_b2, dd_cBearingWarnLvl1Bog2Axle1Left_b2, dd_cBearingWarnLvl1Bog2Axle1Right_b2, dd_cBearingWarnLvl1Bog2Axle2Right_b2, dd_cBearingWarnLvl1Bog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_b2);
        Map BearingWarnLvl1_b2Right = new HashMap();
        BearingWarnLvl1_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        BearingWarnLvl1_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        BearingWarnLvl1_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        BearingWarnLvl1_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("BearingWarnLvl1_b2_Right", BearingWarnLvl1_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_b2);
        Map BearingWarnLvl1_b2Left = new HashMap();
        BearingWarnLvl1_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        BearingWarnLvl1_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        BearingWarnLvl1_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        BearingWarnLvl1_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("BearingWarnLvl1_b2_Left", BearingWarnLvl1_b2Left);


        Long dd_cBearingWarnLvl1Bog1Axle1Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_C1");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_C1");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_C1");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_C1");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_C1");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_C1");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_C1");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_C1");
        String c1 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_c1, dd_cBearingWarnLvl1Bog1Axle1Right_c1, dd_cBearingWarnLvl1Bog1Axle2Left_c1, dd_cBearingWarnLvl1Bog1Axle2Right_c1, dd_cBearingWarnLvl1Bog2Axle1Left_c1, dd_cBearingWarnLvl1Bog2Axle1Right_c1, dd_cBearingWarnLvl1Bog2Axle2Right_c1, dd_cBearingWarnLvl1Bog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_c1);
        Map BearingWarnLvl1_c1 = new HashMap();
        BearingWarnLvl1_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        BearingWarnLvl1_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        BearingWarnLvl1_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        BearingWarnLvl1_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("BearingWarnLvl1_c1_Right", BearingWarnLvl1_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_c1);
        Map BearingWarnLvl1_c1Left = new HashMap();
        BearingWarnLvl1_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        BearingWarnLvl1_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        BearingWarnLvl1_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        BearingWarnLvl1_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("BearingWarnLvl1_c1_Left", BearingWarnLvl1_c1Left);

        Long dd_cBearingWarnLvl1Bog1Axle1Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Left_C2");
        Long dd_cBearingWarnLvl1Bog1Axle1Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle1Right_C2");
        Long dd_cBearingWarnLvl1Bog1Axle2Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Left_C2");
        Long dd_cBearingWarnLvl1Bog1Axle2Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog1Axle2Right_C2");
        Long dd_cBearingWarnLvl1Bog2Axle1Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Left_C2");
        Long dd_cBearingWarnLvl1Bog2Axle1Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle1Right_C2");
        Long dd_cBearingWarnLvl1Bog2Axle2Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Right_C2");
        Long dd_cBearingWarnLvl1Bog2Axle2Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl1Bog2Axle2Left_C2");
        String c2 = getGeneral(dd_cBearingWarnLvl1Bog1Axle1Left_c2, dd_cBearingWarnLvl1Bog1Axle1Right_c2, dd_cBearingWarnLvl1Bog1Axle2Left_c2, dd_cBearingWarnLvl1Bog1Axle2Right_c2, dd_cBearingWarnLvl1Bog2Axle1Left_c2, dd_cBearingWarnLvl1Bog2Axle1Right_c2, dd_cBearingWarnLvl1Bog2Axle2Right_c2, dd_cBearingWarnLvl1Bog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Right_c2);
        Map BearingWarnLvl1_c2Right = new HashMap();
        BearingWarnLvl1_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        BearingWarnLvl1_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        BearingWarnLvl1_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        BearingWarnLvl1_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("BearingWarnLvl1_c2_Right", BearingWarnLvl1_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cBearingWarnLvl1Bog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cBearingWarnLvl1Bog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cBearingWarnLvl1Bog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cBearingWarnLvl1Bog2Axle2Left_c2);
        Map BearingWarnLvl1_c2Left = new HashMap();
        BearingWarnLvl1_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        BearingWarnLvl1_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        BearingWarnLvl1_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        BearingWarnLvl1_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("BearingWarnLvl1_c2_Left", BearingWarnLvl1_c2Left);
        return data;
    }

    /**
     * Bearing warning level2
     *
     * @return
     */
    private static Map createBearingWarningLevel2() {

        Map data = new HashMap();
        Long dd_cBearingWarnLvl2Bog1Axle1Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_A1");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_A1");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_A1");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_A1");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_A1");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_A1");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_A1");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_a1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_A1");
        String a1 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_a1, dd_cBearingWarnLvl2Bog1Axle1Right_a1, dd_cBearingWarnLvl2Bog1Axle2Left_a1, dd_cBearingWarnLvl2Bog1Axle2Right_a1, dd_cBearingWarnLvl2Bog2Axle1Left_a1, dd_cBearingWarnLvl2Bog2Axle1Right_a1, dd_cBearingWarnLvl2Bog2Axle2Right_a1, dd_cBearingWarnLvl2Bog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_a1);
        Map BearingWarnLvl2_a1Right = new HashMap();
        BearingWarnLvl2_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        BearingWarnLvl2_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        BearingWarnLvl2_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        BearingWarnLvl2_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("BearingWarnLvl2_a1_Right", BearingWarnLvl2_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_a1);
        Map BearingWarnLvl2_a1Left = new HashMap();
        BearingWarnLvl2_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        BearingWarnLvl2_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        BearingWarnLvl2_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        BearingWarnLvl2_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("BearingWarnLvl2_a1_Left", BearingWarnLvl2_a1Left);


        Long dd_cBearingWarnLvl2Bog1Axle1Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_A2");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_A2");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_A2");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_A2");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_A2");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_A2");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_A2");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_a2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_A2");
        String a2 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_a2, dd_cBearingWarnLvl2Bog1Axle1Right_a2, dd_cBearingWarnLvl2Bog1Axle2Left_a2, dd_cBearingWarnLvl2Bog1Axle2Right_a2, dd_cBearingWarnLvl2Bog2Axle1Left_a2, dd_cBearingWarnLvl2Bog2Axle1Right_a2, dd_cBearingWarnLvl2Bog2Axle2Right_a2, dd_cBearingWarnLvl2Bog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_a2);
        Map BearingWarnLvl2_a2Right = new HashMap();
        BearingWarnLvl2_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        BearingWarnLvl2_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        BearingWarnLvl2_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        BearingWarnLvl2_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("BearingWarnLvl2_a2_Right", BearingWarnLvl2_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_a2);
        Map BearingWarnLvl2_a2Left = new HashMap();
        BearingWarnLvl2_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        BearingWarnLvl2_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        BearingWarnLvl2_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        BearingWarnLvl2_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("BearingWarnLvl2_a2_Left", BearingWarnLvl2_a2Left);


        Long dd_cBearingWarnLvl2Bog1Axle1Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_B1");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_B1");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_B1");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_B1");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_B1");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_B1");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_B1");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_b1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_B1");
        String b1 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_b1, dd_cBearingWarnLvl2Bog1Axle1Right_b1, dd_cBearingWarnLvl2Bog1Axle2Left_b1, dd_cBearingWarnLvl2Bog1Axle2Right_b1, dd_cBearingWarnLvl2Bog2Axle1Left_b1, dd_cBearingWarnLvl2Bog2Axle1Right_b1, dd_cBearingWarnLvl2Bog2Axle2Right_b1, dd_cBearingWarnLvl2Bog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_b1);
        Map BearingWarnLvl2_b1Right = new HashMap();
        BearingWarnLvl2_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        BearingWarnLvl2_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        BearingWarnLvl2_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        BearingWarnLvl2_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("BearingWarnLvl2_b1_Right", BearingWarnLvl2_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_b1);
        Map BearingWarnLvl2_b1Left = new HashMap();
        BearingWarnLvl2_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        BearingWarnLvl2_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        BearingWarnLvl2_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        BearingWarnLvl2_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("BearingWarnLvl2_b1_Left", BearingWarnLvl2_b1Left);


        Long dd_cBearingWarnLvl2Bog1Axle1Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_B2");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_B2");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_B2");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_B2");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_B2");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_B2");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_B2");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_b2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_B2");
        String b2 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_b2, dd_cBearingWarnLvl2Bog1Axle1Right_b2, dd_cBearingWarnLvl2Bog1Axle2Left_b2, dd_cBearingWarnLvl2Bog1Axle2Right_b2, dd_cBearingWarnLvl2Bog2Axle1Left_b2, dd_cBearingWarnLvl2Bog2Axle1Right_b2, dd_cBearingWarnLvl2Bog2Axle2Right_b2, dd_cBearingWarnLvl2Bog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_b2);
        Map BearingWarnLvl2_b2Right = new HashMap();
        BearingWarnLvl2_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        BearingWarnLvl2_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        BearingWarnLvl2_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        BearingWarnLvl2_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("BearingWarnLvl2_b2_Right", BearingWarnLvl2_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_b2);
        Map BearingWarnLvl2_b2Left = new HashMap();
        BearingWarnLvl2_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        BearingWarnLvl2_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        BearingWarnLvl2_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        BearingWarnLvl2_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("BearingWarnLvl2_b2_Left", BearingWarnLvl2_b2Left);


        Long dd_cBearingWarnLvl2Bog1Axle1Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_C1");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_C1");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_C1");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_C1");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_C1");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_C1");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_C1");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_c1 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_C1");
        String c1 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_c1, dd_cBearingWarnLvl2Bog1Axle1Right_c1, dd_cBearingWarnLvl2Bog1Axle2Left_c1, dd_cBearingWarnLvl2Bog1Axle2Right_c1, dd_cBearingWarnLvl2Bog2Axle1Left_c1, dd_cBearingWarnLvl2Bog2Axle1Right_c1, dd_cBearingWarnLvl2Bog2Axle2Right_c1, dd_cBearingWarnLvl2Bog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_c1);
        Map BearingWarnLvl2_c1 = new HashMap();
        BearingWarnLvl2_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        BearingWarnLvl2_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        BearingWarnLvl2_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        BearingWarnLvl2_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("BearingWarnLvl2_c1_Right", BearingWarnLvl2_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_c1);
        Map BearingWarnLvl2_c1Left = new HashMap();
        BearingWarnLvl2_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        BearingWarnLvl2_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        BearingWarnLvl2_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        BearingWarnLvl2_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("BearingWarnLvl2_c1_Left", BearingWarnLvl2_c1Left);


        Long dd_cBearingWarnLvl2Bog1Axle1Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Left_C2");
        Long dd_cBearingWarnLvl2Bog1Axle1Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle1Right_C2");
        Long dd_cBearingWarnLvl2Bog1Axle2Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Left_C2");
        Long dd_cBearingWarnLvl2Bog1Axle2Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog1Axle2Right_C2");
        Long dd_cBearingWarnLvl2Bog2Axle1Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Left_C2");
        Long dd_cBearingWarnLvl2Bog2Axle1Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle1Right_C2");
        Long dd_cBearingWarnLvl2Bog2Axle2Right_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Right_C2");
        Long dd_cBearingWarnLvl2Bog2Axle2Left_c2 = getValue("port0x131", "DD_CBearingWarnLvl2Bog2Axle2Left_C2");
        String c2 = getGeneral(dd_cBearingWarnLvl2Bog1Axle1Left_c2, dd_cBearingWarnLvl2Bog1Axle1Right_c2, dd_cBearingWarnLvl2Bog1Axle2Left_c2, dd_cBearingWarnLvl2Bog1Axle2Right_c2, dd_cBearingWarnLvl2Bog2Axle1Left_c2, dd_cBearingWarnLvl2Bog2Axle1Right_c2, dd_cBearingWarnLvl2Bog2Axle2Right_c2, dd_cBearingWarnLvl2Bog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Right_c2);
        Map BearingWarnLvl2_c2Right = new HashMap();
        BearingWarnLvl2_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        BearingWarnLvl2_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        BearingWarnLvl2_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        BearingWarnLvl2_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("BearingWarnLvl2_c2_Right", BearingWarnLvl2_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cBearingWarnLvl2Bog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cBearingWarnLvl2Bog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cBearingWarnLvl2Bog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cBearingWarnLvl2Bog2Axle2Left_c2);
        Map BearingWarnLvl2_c2Left = new HashMap();
        BearingWarnLvl2_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        BearingWarnLvl2_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        BearingWarnLvl2_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        BearingWarnLvl2_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("BearingWarnLvl2_c2_Left", BearingWarnLvl2_c2Left);
        return data;
    }


    /**
     * Tread warning level
     *
     * @return
     */
    private static Map createTreadWarningLevel() {

        Map data = new HashMap();

        Long dd_cTreadWarnLvl1Bog1Axle1Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_A1");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_a1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_A1");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_A1");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_a1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_A1");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_A1");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_a1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_A1");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_a1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_A1");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_A1");
        String a1 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_a1, dd_cTreadWarnLvl1Bog1Axle1Right_a1, dd_cTreadWarnLvl1Bog1Axle2Left_a1, dd_cTreadWarnLvl1Bog1Axle2Right_a1, dd_cTreadWarnLvl1Bog2Axle1Left_a1, dd_cTreadWarnLvl1Bog2Axle1Right_a1, dd_cTreadWarnLvl1Bog2Axle2Right_a1, dd_cTreadWarnLvl1Bog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_a1);
        Map TreadWarnLvl1_a1Right = new HashMap();
        TreadWarnLvl1_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        TreadWarnLvl1_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        TreadWarnLvl1_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        TreadWarnLvl1_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("TreadWarnLvl1_a1_Right", TreadWarnLvl1_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_a1);
        Map TreadWarnLvl1_a1Left = new HashMap();
        TreadWarnLvl1_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        TreadWarnLvl1_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        TreadWarnLvl1_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        TreadWarnLvl1_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("TreadWarnLvl1_a1_Left", TreadWarnLvl1_a1Left);


        Long dd_cTreadWarnLvl1Bog1Axle1Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_A2");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_a2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_A2");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_A2");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_a2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_A2");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_A2");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_a2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_A2");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_a2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_A2");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_A2");
        String a2 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_a2, dd_cTreadWarnLvl1Bog1Axle1Right_a2, dd_cTreadWarnLvl1Bog1Axle2Left_a2, dd_cTreadWarnLvl1Bog1Axle2Right_a2, dd_cTreadWarnLvl1Bog2Axle1Left_a2, dd_cTreadWarnLvl1Bog2Axle1Right_a2, dd_cTreadWarnLvl1Bog2Axle2Right_a2, dd_cTreadWarnLvl1Bog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_a2);
        Map TreadWarnLvl1_a2Right = new HashMap();
        TreadWarnLvl1_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        TreadWarnLvl1_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        TreadWarnLvl1_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        TreadWarnLvl1_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("TreadWarnLvl1_a2_Right", TreadWarnLvl1_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_a2);
        Map TreadWarnLvl1_a2Left = new HashMap();
        TreadWarnLvl1_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        TreadWarnLvl1_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        TreadWarnLvl1_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        TreadWarnLvl1_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("TreadWarnLvl1_a2_Left", TreadWarnLvl1_a2Left);


        Long dd_cTreadWarnLvl1Bog1Axle1Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_B1");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_b1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_B1");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_B1");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_b1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_B1");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_B1");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_b1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_B1");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_b1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_B1");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_B1");
        String b1 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_b1, dd_cTreadWarnLvl1Bog1Axle1Right_b1, dd_cTreadWarnLvl1Bog1Axle2Left_b1, dd_cTreadWarnLvl1Bog1Axle2Right_b1, dd_cTreadWarnLvl1Bog2Axle1Left_b1, dd_cTreadWarnLvl1Bog2Axle1Right_b1, dd_cTreadWarnLvl1Bog2Axle2Right_b1, dd_cTreadWarnLvl1Bog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_b1);
        Map TreadWarnLvl1_b1Right = new HashMap();
        TreadWarnLvl1_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        TreadWarnLvl1_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        TreadWarnLvl1_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        TreadWarnLvl1_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("TreadWarnLvl1_b1_Right", TreadWarnLvl1_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_b1);
        Map TreadWarnLvl1_b1Left = new HashMap();
        TreadWarnLvl1_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        TreadWarnLvl1_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        TreadWarnLvl1_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        TreadWarnLvl1_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("TreadWarnLvl1_b1_Left", TreadWarnLvl1_b1Left);


        Long dd_cTreadWarnLvl1Bog1Axle1Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_B2");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_b2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_B2");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_B2");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_b2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_B2");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_B2");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_b2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_B2");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_b2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_B2");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_B2");
        String b2 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_b2, dd_cTreadWarnLvl1Bog1Axle1Right_b2, dd_cTreadWarnLvl1Bog1Axle2Left_b2, dd_cTreadWarnLvl1Bog1Axle2Right_b2, dd_cTreadWarnLvl1Bog2Axle1Left_b2, dd_cTreadWarnLvl1Bog2Axle1Right_b2, dd_cTreadWarnLvl1Bog2Axle2Right_b2, dd_cTreadWarnLvl1Bog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_b2);
        Map TreadWarnLvl1_b2Right = new HashMap();
        TreadWarnLvl1_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        TreadWarnLvl1_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        TreadWarnLvl1_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        TreadWarnLvl1_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("TreadWarnLvl1_b2_Right", TreadWarnLvl1_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_b2);
        Map TreadWarnLvl1_b2Left = new HashMap();
        TreadWarnLvl1_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        TreadWarnLvl1_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        TreadWarnLvl1_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        TreadWarnLvl1_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("TreadWarnLvl1_b2_Left", TreadWarnLvl1_b2Left);


        Long dd_cTreadWarnLvl1Bog1Axle1Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_C1");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_c1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_C1");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_C1");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_c1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_C1");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_C1");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_c1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_C1");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_c1 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_C1");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_C1");
        String c1 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_c1, dd_cTreadWarnLvl1Bog1Axle1Right_c1, dd_cTreadWarnLvl1Bog1Axle2Left_c1, dd_cTreadWarnLvl1Bog1Axle2Right_c1, dd_cTreadWarnLvl1Bog2Axle1Left_c1, dd_cTreadWarnLvl1Bog2Axle1Right_c1, dd_cTreadWarnLvl1Bog2Axle2Right_c1, dd_cTreadWarnLvl1Bog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_c1);
        Map TreadWarnLvl1_c1 = new HashMap();
        TreadWarnLvl1_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        TreadWarnLvl1_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        TreadWarnLvl1_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        TreadWarnLvl1_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("TreadWarnLvl1_c1_Right", TreadWarnLvl1_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_c1);
        Map TreadWarnLvl1_c1Left = new HashMap();
        TreadWarnLvl1_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        TreadWarnLvl1_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        TreadWarnLvl1_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        TreadWarnLvl1_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("TreadWarnLvl1_c1_Left", TreadWarnLvl1_c1Left);


        Long dd_cTreadWarnLvl1Bog1Axle1Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle1Left_C2");
        Long dd_cTreadWarnLvl1Bog1Axle1Right_c2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle1Right_C2");
        Long dd_cTreadWarnLvl1Bog1Axle2Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog1Axle2Left_C2");
        Long dd_cTreadWarnLvl1Bog1Axle2Right_c2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog1Axle2Right_C2");
        Long dd_cTreadWarnLvl1Bog2Axle1Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle1Left_C2");
        Long dd_cTreadWarnLvl1Bog2Axle1Right_c2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle1Right_C2");
        Long dd_cTreadWarnLvl1Bog2Axle2Right_c2 = getValue("port0x131", "DD_CTreadWarnLvl1Bog2Axle2Right_C2");
        Long dd_cTreadWarnLvl1Bog2Axle2Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl1Bog2Axle2Left_C2");
        String c2 = getGeneral(dd_cTreadWarnLvl1Bog1Axle1Left_c2, dd_cTreadWarnLvl1Bog1Axle1Right_c2, dd_cTreadWarnLvl1Bog1Axle2Left_c2, dd_cTreadWarnLvl1Bog1Axle2Right_c2, dd_cTreadWarnLvl1Bog2Axle1Left_c2, dd_cTreadWarnLvl1Bog2Axle1Right_c2, dd_cTreadWarnLvl1Bog2Axle2Right_c2, dd_cTreadWarnLvl1Bog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Right_c2);
        Map TreadWarnLvl1_c2Right = new HashMap();
        TreadWarnLvl1_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        TreadWarnLvl1_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        TreadWarnLvl1_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        TreadWarnLvl1_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("TreadWarnLvl1_c2_Right", TreadWarnLvl1_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cTreadWarnLvl1Bog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cTreadWarnLvl1Bog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cTreadWarnLvl1Bog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cTreadWarnLvl1Bog2Axle2Left_c2);
        Map TreadWarnLvl1_c2Left = new HashMap();
        TreadWarnLvl1_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        TreadWarnLvl1_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        TreadWarnLvl1_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        TreadWarnLvl1_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("TreadWarnLvl1_c2_Left", TreadWarnLvl1_c2Left);
        return data;
    }


    /**
     * Tread warning level2
     *
     * @return
     */
    private static Map createTreadWarningLevel2() {

        Map data = new HashMap();


        
        
        
        
        
        
        
        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_A1");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_a1 =getValue("port0x131", "DD_CTreadWarnLvl2Bog1Axle1Right_A1");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_A1");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_a1 =getValue("port0x131", "DD_CTreadWarnLvl2Bog1Axle2Right_A1");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_A1");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_a1 =getValue("port0x131", "DD_CTreadWarnLvl2Bog2Axle1Right_A1");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_a1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_A1");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_a1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_A1");
        String a1 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_a1, dd_cTreadWarnLvl2Bog1Axle1Right_a1, dd_cTreadWarnLvl2Bog1Axle2Left_a1, dd_cTreadWarnLvl2Bog1Axle2Right_a1, dd_cTreadWarnLvl2Bog2Axle1Left_a1, dd_cTreadWarnLvl2Bog2Axle1Right_a1, dd_cTreadWarnLvl2Bog2Axle2Right_a1, dd_cTreadWarnLvl2Bog2Axle2Left_a1);
        data.put("a1", a1);
        String Bog1Axle1Right_a1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_a1);
        String Bog1Axle2Right_a1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_a1);
        String Bog2Axle1Right_a1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_a1);
        String Bog2Axle2Right_a1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_a1);
        Map TreadWarnLvl2_a1Right = new HashMap();
        TreadWarnLvl2_a1Right.put("Bog1Axle1Right_a1", Bog1Axle1Right_a1);
        TreadWarnLvl2_a1Right.put("Bog1Axle2Right_a1", Bog1Axle2Right_a1);
        TreadWarnLvl2_a1Right.put("Bog2Axle1Right_a1", Bog2Axle1Right_a1);
        TreadWarnLvl2_a1Right.put("Bog2Axle2Right_a1", Bog2Axle2Right_a1);
        data.put("TreadWarnLvl2_a1_Right", TreadWarnLvl2_a1Right);
        String Bog1Axle1Left_a1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_a1);
        String Bog1Axle2Left_a1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_a1);
        String Bog2Axle1Left_a1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_a1);
        String Bog2Axle2Left_a1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_a1);
        Map TreadWarnLvl2_a1Left = new HashMap();
        TreadWarnLvl2_a1Left.put("Bog1Axle1Left_a1", Bog1Axle1Left_a1);
        TreadWarnLvl2_a1Left.put("Bog1Axle2Left_a1", Bog1Axle2Left_a1);
        TreadWarnLvl2_a1Left.put("Bog2Axle1Left_a1", Bog2Axle1Left_a1);
        TreadWarnLvl2_a1Left.put("Bog2Axle2Left_a1", Bog2Axle2Left_a1);
        data.put("TreadWarnLvl2_a1_Left", TreadWarnLvl2_a1Left);

        
        
        
        
        
        
        
        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_A2");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_a2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Right_A2");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_A2");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_a2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Right_A2");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_A2");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_a2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Right_A2");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_a2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_A2");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_a2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_A2");
        String a2 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_a2, dd_cTreadWarnLvl2Bog1Axle1Right_a2, dd_cTreadWarnLvl2Bog1Axle2Left_a2, dd_cTreadWarnLvl2Bog1Axle2Right_a2, dd_cTreadWarnLvl2Bog2Axle1Left_a2, dd_cTreadWarnLvl2Bog2Axle1Right_a2, dd_cTreadWarnLvl2Bog2Axle2Right_a2, dd_cTreadWarnLvl2Bog2Axle2Left_a2);
        data.put("a2", a2);
        String Bog1Axle1Right_a2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_a2);
        String Bog1Axle2Right_a2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_a2);
        String Bog2Axle1Right_a2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_a2);
        String Bog2Axle2Right_a2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_a2);
        Map TreadWarnLvl2_a2Right = new HashMap();
        TreadWarnLvl2_a2Right.put("Bog1Axle1Right_a2", Bog1Axle1Right_a2);
        TreadWarnLvl2_a2Right.put("Bog1Axle2Right_a2", Bog1Axle2Right_a2);
        TreadWarnLvl2_a2Right.put("Bog2Axle1Right_a2", Bog2Axle1Right_a2);
        TreadWarnLvl2_a2Right.put("Bog2Axle2Right_a2", Bog2Axle2Right_a2);
        data.put("TreadWarnLvl2_a2_Right", TreadWarnLvl2_a2Right);

        String Bog1Axle1Left_a2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_a2);
        String Bog1Axle2Left_a2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_a2);
        String Bog2Axle1Left_a2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_a2);
        String Bog2Axle2Left_a2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_a2);
        Map TreadWarnLvl2_a2Left = new HashMap();
        TreadWarnLvl2_a2Left.put("Bog1Axle1Left_a2", Bog1Axle1Left_a2);
        TreadWarnLvl2_a2Left.put("Bog1Axle2Left_a2", Bog1Axle2Left_a2);
        TreadWarnLvl2_a2Left.put("Bog2Axle1Left_a2", Bog2Axle1Left_a2);
        TreadWarnLvl2_a2Left.put("Bog2Axle2Left_a2", Bog2Axle2Left_a2);
        data.put("TreadWarnLvl2_a2_Left", TreadWarnLvl2_a2Left);


        
        
        
        
        
        
        
        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_B1");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_b1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Right_B1");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_B1");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_b1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Right_B1");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_B1");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_b1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Right_B1");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_b1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_B1");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_b1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_B1");
        String b1 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_b1, dd_cTreadWarnLvl2Bog1Axle1Right_b1, dd_cTreadWarnLvl2Bog1Axle2Left_b1, dd_cTreadWarnLvl2Bog1Axle2Right_b1, dd_cTreadWarnLvl2Bog2Axle1Left_b1, dd_cTreadWarnLvl2Bog2Axle1Right_b1, dd_cTreadWarnLvl2Bog2Axle2Right_b1, dd_cTreadWarnLvl2Bog2Axle2Left_b1);
        data.put("b1", b1);
        String Bog1Axle1Right_b1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_b1);
        String Bog1Axle2Right_b1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_b1);
        String Bog2Axle1Right_b1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_b1);
        String Bog2Axle2Right_b1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_b1);
        Map TreadWarnLvl2_b1Right = new HashMap();
        TreadWarnLvl2_b1Right.put("Bog1Axle1Right_b1", Bog1Axle1Right_b1);
        TreadWarnLvl2_b1Right.put("Bog1Axle2Right_b1", Bog1Axle2Right_b1);
        TreadWarnLvl2_b1Right.put("Bog2Axle1Right_b1", Bog2Axle1Right_b1);
        TreadWarnLvl2_b1Right.put("Bog2Axle2Right_b1", Bog2Axle2Right_b1);
        data.put("TreadWarnLvl2_b1_Right", TreadWarnLvl2_b1Right);
        String Bog1Axle1Left_b1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_b1);
        String Bog1Axle2Left_b1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_b1);
        String Bog2Axle1Left_b1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_b1);
        String Bog2Axle2Left_b1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_b1);
        Map TreadWarnLvl2_b1Left = new HashMap();
        TreadWarnLvl2_b1Left.put("Bog1Axle1Left_b1", Bog1Axle1Left_b1);
        TreadWarnLvl2_b1Left.put("Bog1Axle2Left_b1", Bog1Axle2Left_b1);
        TreadWarnLvl2_b1Left.put("Bog2Axle1Left_b1", Bog2Axle1Left_b1);
        TreadWarnLvl2_b1Left.put("Bog2Axle2Left_b1", Bog2Axle2Left_b1);
        data.put("TreadWarnLvl2_b1_Left", TreadWarnLvl2_b1Left);


        
        
        
        
        
        
        
        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_B2");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_b2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Right_B2");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_B2");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_b2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Right_B2");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_B2");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_b2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Right_B2");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_b2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_B2");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_b2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_B2");
        String b2 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_b2, dd_cTreadWarnLvl2Bog1Axle1Right_b2, dd_cTreadWarnLvl2Bog1Axle2Left_b2, dd_cTreadWarnLvl2Bog1Axle2Right_b2, dd_cTreadWarnLvl2Bog2Axle1Left_b2, dd_cTreadWarnLvl2Bog2Axle1Right_b2, dd_cTreadWarnLvl2Bog2Axle2Right_b2, dd_cTreadWarnLvl2Bog2Axle2Left_b2);
        data.put("b2", b2);
        String Bog1Axle1Right_b2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_b2);
        String Bog1Axle2Right_b2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_b2);
        String Bog2Axle1Right_b2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_b2);
        String Bog2Axle2Right_b2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_b2);
        Map TreadWarnLvl2_b2Right = new HashMap();
        TreadWarnLvl2_b2Right.put("Bog1Axle1Right_b2", Bog1Axle1Right_b2);
        TreadWarnLvl2_b2Right.put("Bog1Axle2Right_b2", Bog1Axle2Right_b2);
        TreadWarnLvl2_b2Right.put("Bog2Axle1Right_b2", Bog2Axle1Right_b2);
        TreadWarnLvl2_b2Right.put("Bog2Axle2Right_b2", Bog2Axle2Right_b2);
        data.put("TreadWarnLvl2_b2_Right", TreadWarnLvl2_b2Right);
        String Bog1Axle1Left_b2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_b2);
        String Bog1Axle2Left_b2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_b2);
        String Bog2Axle1Left_b2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_b2);
        String Bog2Axle2Left_b2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_b2);
        Map TreadWarnLvl2_b2Left = new HashMap();
        TreadWarnLvl2_b2Left.put("Bog1Axle1Left_b2", Bog1Axle1Left_b2);
        TreadWarnLvl2_b2Left.put("Bog1Axle2Left_b2", Bog1Axle2Left_b2);
        TreadWarnLvl2_b2Left.put("Bog2Axle1Left_b2", Bog2Axle1Left_b2);
        TreadWarnLvl2_b2Left.put("Bog2Axle2Left_b2", Bog2Axle2Left_b2);
        data.put("TreadWarnLvl2_b2_Left", TreadWarnLvl2_b2Left);


        
        
        
        
        
        
        
        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_C1");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_c1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Right_C1");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_C1");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_c1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Right_C1");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_C1");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_c1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Right_C1");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_c1 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_C1");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_c1 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_C1");
        String c1 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_c1, dd_cTreadWarnLvl2Bog1Axle1Right_c1, dd_cTreadWarnLvl2Bog1Axle2Left_c1, dd_cTreadWarnLvl2Bog1Axle2Right_c1, dd_cTreadWarnLvl2Bog2Axle1Left_c1, dd_cTreadWarnLvl2Bog2Axle1Right_c1, dd_cTreadWarnLvl2Bog2Axle2Right_c1, dd_cTreadWarnLvl2Bog2Axle2Left_c1);
        data.put("c1", c1);
        String Bog1Axle1Right_c1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_c1);
        String Bog1Axle2Right_c1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_c1);
        String Bog2Axle1Right_c1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_c1);
        String Bog2Axle2Right_c1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_c1);
        Map TreadWarnLvl2_c1 = new HashMap();
        TreadWarnLvl2_c1.put("Bog1Axle1Right_c1", Bog1Axle1Right_c1);
        TreadWarnLvl2_c1.put("Bog1Axle2Right_c1", Bog1Axle2Right_c1);
        TreadWarnLvl2_c1.put("Bog2Axle1Right_c1", Bog2Axle1Right_c1);
        TreadWarnLvl2_c1.put("Bog2Axle2Right_c1", Bog2Axle2Right_c1);
        data.put("TreadWarnLvl2_c1_Right", TreadWarnLvl2_c1);
        String Bog1Axle1Left_c1 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_c1);
        String Bog1Axle2Left_c1 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_c1);
        String Bog2Axle1Left_c1 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_c1);
        String Bog2Axle2Left_c1 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_c1);
        Map TreadWarnLvl2_c1Left = new HashMap();
        TreadWarnLvl2_c1Left.put("Bog1Axle1Left_c1", Bog1Axle1Left_c1);
        TreadWarnLvl2_c1Left.put("Bog1Axle2Left_c1", Bog1Axle2Left_c1);
        TreadWarnLvl2_c1Left.put("Bog2Axle1Left_c1", Bog2Axle1Left_c1);
        TreadWarnLvl2_c1Left.put("Bog2Axle2Left_c1", Bog2Axle2Left_c1);
        data.put("TreadWarnLvl2_c1_Left", TreadWarnLvl2_c1Left);









        
        Long dd_cTreadWarnLvl2Bog1Axle1Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Left_C2");
        Long dd_cTreadWarnLvl2Bog1Axle1Right_c2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle1Right_C2");
        Long dd_cTreadWarnLvl2Bog1Axle2Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Left_C2");
        Long dd_cTreadWarnLvl2Bog1Axle2Right_c2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog1Axle2Right_C2");
        Long dd_cTreadWarnLvl2Bog2Axle1Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Left_C2");
        Long dd_cTreadWarnLvl2Bog2Axle1Right_c2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle1Right_C2");
        Long dd_cTreadWarnLvl2Bog2Axle2Right_c2 =getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Right_C2");
        Long dd_cTreadWarnLvl2Bog2Axle2Left_c2 = getValue("port0x132", "DD_CTreadWarnLvl2Bog2Axle2Left_C2");
        String c2 = getGeneral(dd_cTreadWarnLvl2Bog1Axle1Left_c2, dd_cTreadWarnLvl2Bog1Axle1Right_c2, dd_cTreadWarnLvl2Bog1Axle2Left_c2, dd_cTreadWarnLvl2Bog1Axle2Right_c2, dd_cTreadWarnLvl2Bog2Axle1Left_c2, dd_cTreadWarnLvl2Bog2Axle1Right_c2, dd_cTreadWarnLvl2Bog2Axle2Right_c2, dd_cTreadWarnLvl2Bog2Axle2Left_c2);
        data.put("c2", c2);
        String Bog1Axle1Right_c2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Right_c2);
        String Bog1Axle2Right_c2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Right_c2);
        String Bog2Axle1Right_c2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Right_c2);
        String Bog2Axle2Right_c2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Right_c2);
        Map TreadWarnLvl2_c2Right = new HashMap();
        TreadWarnLvl2_c2Right.put("Bog1Axle1Right_c2", Bog1Axle1Right_c2);
        TreadWarnLvl2_c2Right.put("Bog1Axle2Right_c2", Bog1Axle2Right_c2);
        TreadWarnLvl2_c2Right.put("Bog2Axle1Right_c2", Bog2Axle1Right_c2);
        TreadWarnLvl2_c2Right.put("Bog2Axle2Right_c2", Bog2Axle2Right_c2);
        data.put("TreadWarnLvl2_c2_Right", TreadWarnLvl2_c2Right);

        String Bog1Axle1Left_c2 = getStatus(dd_cTreadWarnLvl2Bog1Axle1Left_c2);
        String Bog1Axle2Left_c2 = getStatus(dd_cTreadWarnLvl2Bog1Axle2Left_c2);
        String Bog2Axle1Left_c2 = getStatus(dd_cTreadWarnLvl2Bog2Axle1Left_c2);
        String Bog2Axle2Left_c2 = getStatus(dd_cTreadWarnLvl2Bog2Axle2Left_c2);
        Map TreadWarnLvl2_c2Left = new HashMap();
        TreadWarnLvl2_c2Left.put("Bog1Axle1Left_c2", Bog1Axle1Left_c2);
        TreadWarnLvl2_c2Left.put("Bog1Axle2Left_c2", Bog1Axle2Left_c2);
        TreadWarnLvl2_c2Left.put("Bog2Axle1Left_c2", Bog2Axle1Left_c2);
        TreadWarnLvl2_c2Left.put("Bog2Axle2Left_c2", Bog2Axle2Left_c2);
        data.put("TreadWarnLvl2_c2_Left", TreadWarnLvl2_c2Left);
        return data;
    }

    /**
     * Load weightLoad weight
     *
     * @return
     */
    private static Map createLoadWeightLoadWeight() {
        Map data = new HashMap();
        Long dd_cbmsLoadweight_a1 = getValue("port0x137", "DD_CBMSLoadweight_A1");
        Long dd_cbmsLoadweight_a2 = getValue("port0x137", "DD_CBMSLoadweight_A2");
        Long dd_cbmsLoadweight_b1 = getValue("port0x137", "DD_CBMSLoadweight_B1");
        Long dd_cbmsLoadweight_b2 = getValue("port0x137", "DD_CBMSLoadweight_B2");
        Long dd_cbmsLoadweight_c1 = getValue("port0x137", "DD_CBMSLoadweight_C1");
        Long dd_cbmsLoadweight_c2 = getValue("port0x137", "DD_CBMSLoadweight_C2");
        data.put("a1", dd_cbmsLoadweight_a1);
        data.put("a2", dd_cbmsLoadweight_a2);
        data.put("b1", dd_cbmsLoadweight_b1);
        data.put("b2", dd_cbmsLoadweight_b2);
        data.put("c1", dd_cbmsLoadweight_c1);
        data.put("c2", dd_cbmsLoadweight_c2);
        return data;
    }
}


