package com.missiongroup.starring.core.springtask;

import java.util.HashMap;
import java.util.Map;

public class HAVCFaultDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map overTempFlt = createOverTempFlt();
        data.put("overTempFlt", overTempFlt);
        Map overLoadFlt = createOverLoadFlt();
        data.put("overLoadFlt", overLoadFlt);
        Map condFlt = createCondFlt();
        data.put("condFlt", condFlt);
        Map freshAirDamperFlt = createFreshAirDamperFlt();
        data.put("freshAirDamperFlt", freshAirDamperFlt);
        Map freshAirSensFlt = createFreshAirSensFlt();
        data.put("freshAirSensFlt", freshAirSensFlt);
        Map heaterFlt = createHeaterFlt();
        data.put("heaterFlt", heaterFlt);
        Map highPressFlt = createHighPressFlt();
        data.put("highPressFlt", highPressFlt);
        Map lowPress = createLowPress();
        data.put("lowPress", lowPress);
        Map iMajorFlt = createIMajorFlt();
        data.put("iMajorFlt", iMajorFlt);
        Map iMediumFlt = createIMediumFlt();
        data.put("iMediumFlt", iMediumFlt);
        Map mediumVoltFlt = createMediumVoltFlt();
        data.put("mediumVoltFlt", mediumVoltFlt);
        Map iMinorFlt = createIMinorFlt();
        data.put("iMinorFlt", iMinorFlt);
        Map returnAirDamp = createReturnAirDamp();
        data.put("returnAirDamp", returnAirDamp);
        Map returnAirTempSensFlt = createReturnAirTempSensFlt();
        data.put("returnAirTempSensFlt", returnAirTempSensFlt);
        Map iVentFlt = createIVentFlt();
        data.put("iVentFlt", iVentFlt);
        Map supplyAirTemperatureSensorFailure = createSupplyAirTemperatureSensorFailure();
        data.put("supplyAirTemperature", supplyAirTemperatureSensorFailure);
        return data;
    }

    /**
     * OverTempFlt
     *
     * @param
     * @return
     */
    private static Map createOverTempFlt() {
        Map data = new HashMap();
        String iu1Comp1OverTempFlt = "IU1Comp1OverTempFlt";
        String iu1Comp2OverTempFlt = "IU1Comp2OverTempFlt";
        String iu2Comp1OverTempFlt = "IU2Comp1OverTempFlt";
        String iu2Comp2OverTempFlt = "IU2Comp2OverTempFlt";

        Long iu1comp1OverTempFltA0 = getValue("port0x8a0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltA0 = getValue("port0x8a0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltA0 = getValue("port0x8a0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltA0 = getValue("port0x8a0", iu2Comp2OverTempFlt);
        String overTempFlt1_A1 = getStatus(iu1comp1OverTempFltA0, iu1comp2OverTempFltA0);
        String overTempFlt2_A1 = getStatus(iu2comp1OverTempFltA0, iu2comp2OverTempFltA0);
        data.put("OverTempFlt1_A1", overTempFlt1_A1);
        data.put("OverTempFlt2_A1", overTempFlt2_A1);
        Long iu1comp1OverTempFltB0 = getValue("port0x8b0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltB0 = getValue("port0x8b0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltB0 = getValue("port0x8b0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltB0 = getValue("port0x8b0", iu2Comp2OverTempFlt);
        String overTempFlt1_B1 = getStatus(iu1comp1OverTempFltB0, iu1comp2OverTempFltB0);
        String overTempFlt2_B1 = getStatus(iu2comp1OverTempFltB0, iu2comp2OverTempFltB0);
        data.put("OverTempFlt1_B1", overTempFlt1_B1);
        data.put("OverTempFlt2_B1", overTempFlt2_B1);


        Long iu1comp1OverTempFltC0 = getValue("port0x8c0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltC0 = getValue("port0x8c0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltC0 = getValue("port0x8c0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltC0 = getValue("port0x8c0", iu2Comp2OverTempFlt);
        String overTempFlt1_C1 = getStatus(iu1comp1OverTempFltC0, iu1comp2OverTempFltC0);
        String overTempFlt2_C1 = getStatus(iu2comp1OverTempFltC0, iu2comp2OverTempFltC0);
        data.put("OverTempFlt1_C1", overTempFlt1_C1);
        data.put("OverTempFlt2_C1", overTempFlt2_C1);

        Long iu1comp1OverTempFltD0 = getValue("port0x8d0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltD0 = getValue("port0x8d0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltD0 = getValue("port0x8d0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltD0 = getValue("port0x8d0", iu2Comp2OverTempFlt);
        String overTempFlt1_C2 = getStatus(iu1comp1OverTempFltD0, iu1comp2OverTempFltD0);
        String overTempFlt2_C2 = getStatus(iu2comp1OverTempFltD0, iu2comp2OverTempFltD0);
        data.put("OverTempFlt1_C2", overTempFlt1_C2);
        data.put("OverTempFlt2_C2", overTempFlt2_C2);

        Long iu1comp1OverTempFltE0 = getValue("port0x8e0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltE0 = getValue("port0x8e0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltE0 = getValue("port0x8e0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltE0 = getValue("port0x8e0", iu2Comp2OverTempFlt);
        String overTempFlt1_B2 = getStatus(iu1comp1OverTempFltE0, iu1comp2OverTempFltE0);
        String overTempFlt2_B2 = getStatus(iu2comp1OverTempFltE0, iu2comp2OverTempFltE0);
        data.put("OverTempFlt1_B2", overTempFlt1_B2);
        data.put("OverTempFlt2_B2", overTempFlt2_B2);

        Long iu1comp1OverTempFltF0 = getValue("port0x8f0", iu1Comp1OverTempFlt);
        Long iu1comp2OverTempFltF0 = getValue("port0x8f0", iu1Comp2OverTempFlt);
        Long iu2comp1OverTempFltF0 = getValue("port0x8f0", iu2Comp1OverTempFlt);
        Long iu2comp2OverTempFltF0 = getValue("port0x8f0", iu2Comp2OverTempFlt);
        String overTempFlt1_A2 = getStatus(iu1comp1OverTempFltF0, iu1comp2OverTempFltF0);
        String overTempFlt2_A2 = getStatus(iu2comp1OverTempFltF0, iu2comp2OverTempFltF0);
        data.put("OverTempFlt1_A2", overTempFlt1_A2);
        data.put("OverTempFlt2_A2", overTempFlt2_A2);

        return data;
    }

    /**
     * OverLoadFlt
     *
     * @param
     * @return
     */
    private static Map createOverLoadFlt() {
        Map data = new HashMap();
        String iu1Comp1OverLoadFlt = "IU1Comp1OverLoadFlt";
        String iu1Comp2OverLoadFlt = "IU1Comp2OverLoadFlt";
        String iu2Comp1OverLoadFlt = "IU2Comp1OverLoadFlt";
        String iu2Comp2OverLoadFlt = "IU2Comp2OverLoadFlt";
        Long iU1Comp1OverLoadFltA0 = getValue("port0x8a0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltA0 = getValue("port0x8a0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltA0 = getValue("port0x8a0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltA0 = getValue("port0x8a0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_A1 = getStatus(iU1Comp1OverLoadFltA0, iU1Comp2OverLoadFltA0);
        String OverLoadFlt2_A1 = getStatus(iU2Comp1OverLoadFltA0, iU2Comp2OverLoadFltA0);
        data.put("OverLoadFlt1_A1", OverLoadFlt1_A1);
        data.put("OverLoadFlt2_A1", OverLoadFlt2_A1);

        Long iU1Comp1OverLoadFltB0 = getValue("port0x8b0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltB0 = getValue("port0x8b0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltB0 = getValue("port0x8b0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltB0 = getValue("port0x8b0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_B1 = getStatus(iU1Comp1OverLoadFltB0, iU1Comp2OverLoadFltB0);
        String OverLoadFlt2_B1 = getStatus(iU2Comp1OverLoadFltB0, iU2Comp2OverLoadFltB0);
        data.put("OverLoadFlt1_B1", OverLoadFlt1_B1);
        data.put("OverLoadFlt2_B1", OverLoadFlt2_B1);


        Long iU1Comp1OverLoadFltC0 = getValue("port0x8c0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltC0 = getValue("port0x8c0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltC0 = getValue("port0x8c0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltC0 = getValue("port0x8c0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_C1 = getStatus(iU1Comp1OverLoadFltC0, iU1Comp2OverLoadFltC0);
        String OverLoadFlt2_C1 = getStatus(iU2Comp1OverLoadFltC0, iU2Comp2OverLoadFltC0);
        data.put("OverLoadFlt1_C1", OverLoadFlt1_C1);
        data.put("OverLoadFlt2_C1", OverLoadFlt2_C1);


        Long iU1Comp1OverLoadFltD0 = getValue("port0x8d0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltD0 = getValue("port0x8d0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltD0 = getValue("port0x8d0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltD0 = getValue("port0x8d0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_C2 = getStatus(iU1Comp1OverLoadFltD0, iU1Comp2OverLoadFltD0);
        String OverLoadFlt2_C2 = getStatus(iU2Comp1OverLoadFltD0, iU2Comp2OverLoadFltD0);
        data.put("OverLoadFlt1_C2", OverLoadFlt1_C2);
        data.put("OverLoadFlt2_C2", OverLoadFlt2_C2);


        Long iU1Comp1OverLoadFltE0 = getValue("port0x8e0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltE0 = getValue("port0x8e0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltE0 = getValue("port0x8e0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltE0 = getValue("port0x8e0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_B2 = getStatus(iU1Comp1OverLoadFltE0, iU1Comp2OverLoadFltE0);
        String OverLoadFlt2_B2 = getStatus(iU2Comp1OverLoadFltE0, iU2Comp2OverLoadFltE0);
        data.put("OverLoadFlt1_B2", OverLoadFlt1_B2);
        data.put("OverLoadFlt2_B2", OverLoadFlt2_B2);


        Long iU1Comp1OverLoadFltF0 = getValue("port0x8f0", iu1Comp1OverLoadFlt);
        Long iU1Comp2OverLoadFltF0 = getValue("port0x8f0", iu1Comp2OverLoadFlt);
        Long iU2Comp1OverLoadFltF0 = getValue("port0x8f0", iu2Comp1OverLoadFlt);
        Long iU2Comp2OverLoadFltF0 = getValue("port0x8f0", iu2Comp2OverLoadFlt);
        String OverLoadFlt1_A2 = getStatus(iU1Comp1OverLoadFltF0, iU1Comp2OverLoadFltF0);
        String OverLoadFlt2_A2 = getStatus(iU2Comp1OverLoadFltF0, iU2Comp2OverLoadFltF0);
        data.put("OverLoadFlt1_A2", OverLoadFlt1_A2);
        data.put("OverLoadFlt2_A2", OverLoadFlt2_A2);
        return data;
    }

    /**
     * CondFlt
     *
     * @param
     * @return
     */
    private static Map createCondFlt() {
        Map data = new HashMap();
        String iu1Cond1Flt = "IU1Cond1Flt";
        String iu1Cond2Flt = "IU1Cond2Flt";
        String iu2Cond1Flt = "IU2Cond1Flt";
        String iu2Cond2Flt = "IU2Cond2Flt";
        Long iu1Cond1FltA0 = getValue("port0x8a0", iu1Cond1Flt);
        Long iu1Cond2FltA0 = getValue("port0x8a0", iu1Cond2Flt);
        Long iu2Cond1FltA0 = getValue("port0x8a0", iu2Cond1Flt);
        Long iu2Cond2FltA0 = getValue("port0x8a0", iu2Cond2Flt);
        String CondFlt1_A1 = getStatus(iu1Cond1FltA0, iu1Cond2FltA0);
        String CondFlt2_A1 = getStatus(iu2Cond1FltA0, iu2Cond2FltA0);
        data.put("CondFlt1_A1", CondFlt1_A1);
        data.put("CondFlt2_A1", CondFlt2_A1);


        Long iu1Cond1FltB0 = getValue("port0x8b0", iu1Cond1Flt);
        Long iu1Cond2FltB0 = getValue("port0x8b0", iu1Cond2Flt);
        Long iu2Cond1FltB0 = getValue("port0x8b0", iu2Cond1Flt);
        Long iu2Cond2FltB0 = getValue("port0x8b0", iu2Cond2Flt);
        String CondFlt1_B1 = getStatus(iu1Cond1FltB0, iu1Cond2FltB0);
        String CondFlt2_B1 = getStatus(iu2Cond1FltB0, iu2Cond2FltB0);
        data.put("CondFlt1_B1", CondFlt1_B1);
        data.put("CondFlt2_B1", CondFlt2_B1);

        Long iu1Cond1FltC0 = getValue("port0x8c0", iu1Cond1Flt);
        Long iu1Cond2FltC0 = getValue("port0x8c0", iu1Cond2Flt);
        Long iu2Cond1FltC0 = getValue("port0x8c0", iu2Cond1Flt);
        Long iu2Cond2FltC0 = getValue("port0x8c0", iu2Cond2Flt);
        String CondFlt1_C1 = getStatus(iu1Cond1FltC0, iu1Cond2FltC0);
        String CondFlt2_C1 = getStatus(iu2Cond1FltC0, iu2Cond2FltC0);
        data.put("CondFlt1_C1", CondFlt1_C1);
        data.put("CondFlt2_C1", CondFlt2_C1);


        Long iu1Cond1FltD0 = getValue("port0x8d0", iu1Cond1Flt);
        Long iu1Cond2FltD0 = getValue("port0x8d0", iu1Cond2Flt);
        Long iu2Cond1FltD0 = getValue("port0x8d0", iu2Cond1Flt);
        Long iu2Cond2FltD0 = getValue("port0x8d0", iu2Cond2Flt);
        String CondFlt1_C2 = getStatus(iu1Cond1FltD0, iu1Cond2FltD0);
        String CondFlt2_C2 = getStatus(iu2Cond1FltD0, iu2Cond2FltD0);
        data.put("CondFlt1_C2", CondFlt1_C2);
        data.put("CondFlt2_C2", CondFlt2_C2);

        Long iu1Cond1FltE0 = getValue("port0x8e0", iu1Cond1Flt);
        Long iu1Cond2FltE0 = getValue("port0x8e0", iu1Cond2Flt);
        Long iu2Cond1FltE0 = getValue("port0x8e0", iu2Cond1Flt);
        Long iu2Cond2FltE0 = getValue("port0x8e0", iu2Cond2Flt);
        String CondFlt1_B2 = getStatus(iu1Cond1FltE0, iu1Cond2FltE0);
        String CondFlt2_B2 = getStatus(iu2Cond1FltE0, iu2Cond2FltE0);
        data.put("CondFlt1_B2", CondFlt1_B2);
        data.put("CondFlt2_B2", CondFlt2_B2);

        Long iu1Cond1FltF0 = getValue("port0x8f0", iu1Cond1Flt);
        Long iu1Cond2FltF0 = getValue("port0x8f0", iu1Cond2Flt);
        Long iu2Cond1FltF0 = getValue("port0x8f0", iu2Cond1Flt);
        Long iu2Cond2FltF0 = getValue("port0x8f0", iu2Cond2Flt);
        String CondFlt1_A2 = getStatus(iu1Cond1FltF0, iu1Cond2FltF0);
        String CondFlt2_A2 = getStatus(iu2Cond1FltF0, iu2Cond2FltF0);
        data.put("CondFlt1_A2", CondFlt1_A2);
        data.put("CondFlt2_A2", CondFlt2_A2);
        return data;
    }

    /**
     * FreshAirDamperFlt
     *
     * @param
     * @return
     */
    private static Map createFreshAirDamperFlt() {
        Map data = new HashMap();
        String iu1FreshAirDamp1Flt = "IU1FreshAirDamp1Flt";
        String iu1FreshAirDamp2Flt = "IU1FreshAirDamp2Flt";
        String iu2FreshAirDamp1Flt = "IU2FreshAirDamp1Flt";
        String iu2FreshAirDamp2Flt = "IU2FreshAirDamp2Flt";
        Long iu1FreshAirDamp1FltA0 = getValue("port0x8a0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltA0 = getValue("port0x8a0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltA0 = getValue("port0x8a0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltA0 = getValue("port0x8a0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_A1 = getStatus(iu1FreshAirDamp1FltA0, iu1FreshAirDamp2FltA0);
        String FreshAirDamperFlt2_A1 = getStatus(iu2FreshAirDamp1FltA0, iu2FreshAirDamp2FltA0);
        data.put("FreshAirDamperFlt1_A1", FreshAirDamperFlt1_A1);
        data.put("FreshAirDamperFlt2_A1", FreshAirDamperFlt2_A1);
        Long iu1FreshAirDamp1FltB0 = getValue("port0x8b0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltB0 = getValue("port0x8b0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltB0 = getValue("port0x8b0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltB0 = getValue("port0x8b0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_B1 = getStatus(iu1FreshAirDamp1FltB0, iu1FreshAirDamp2FltB0);
        String FreshAirDamperFlt2_B1 = getStatus(iu2FreshAirDamp1FltB0, iu2FreshAirDamp2FltB0);
        data.put("FreshAirDamperFlt1_B1", FreshAirDamperFlt1_B1);
        data.put("FreshAirDamperFlt2_B1", FreshAirDamperFlt2_B1);


        Long iu1FreshAirDamp1FltC0 = getValue("port0x8c0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltC0 = getValue("port0x8c0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltC0 = getValue("port0x8c0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltC0 = getValue("port0x8c0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_C1 = getStatus(iu1FreshAirDamp1FltC0, iu1FreshAirDamp2FltC0);
        String FreshAirDamperFlt2_C1 = getStatus(iu2FreshAirDamp1FltC0, iu2FreshAirDamp2FltC0);
        data.put("FreshAirDamperFlt1_C1", FreshAirDamperFlt1_C1);
        data.put("FreshAirDamperFlt2_C1", FreshAirDamperFlt2_C1);


        Long iu1FreshAirDamp1FltD0 = getValue("port0x8d0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltD0 = getValue("port0x8d0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltD0 = getValue("port0x8d0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltD0 = getValue("port0x8d0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_C2 = getStatus(iu1FreshAirDamp1FltD0, iu1FreshAirDamp2FltD0);
        String FreshAirDamperFlt2_C2 = getStatus(iu2FreshAirDamp1FltD0, iu2FreshAirDamp2FltD0);
        data.put("FreshAirDamperFlt1_C2", FreshAirDamperFlt1_C2);
        data.put("FreshAirDamperFlt2_C2", FreshAirDamperFlt2_C2);

        Long iu1FreshAirDamp1FltE0 = getValue("port0x8e0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltE0 = getValue("port0x8e0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltE0 = getValue("port0x8e0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltE0 = getValue("port0x8e0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_B2 = getStatus(iu1FreshAirDamp1FltE0, iu1FreshAirDamp2FltE0);
        String FreshAirDamperFlt2_B2 = getStatus(iu2FreshAirDamp1FltE0, iu2FreshAirDamp2FltE0);
        data.put("FreshAirDamperFlt1_B2", FreshAirDamperFlt1_B2);
        data.put("FreshAirDamperFlt2_B2", FreshAirDamperFlt2_B2);
        Long iu1FreshAirDamp1FltF0 = getValue("port0x8f0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltF0 = getValue("port0x8f0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltF0 = getValue("port0x8f0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltF0 = getValue("port0x8f0", iu2FreshAirDamp2Flt);
        String FreshAirDamperFlt1_A2 = getStatus(iu1FreshAirDamp1FltF0, iu1FreshAirDamp2FltF0);
        String FreshAirDamperFlt2_A2 = getStatus(iu2FreshAirDamp1FltF0, iu2FreshAirDamp2FltF0);
        data.put("FreshAirDamperFlt1_A2", FreshAirDamperFlt1_A2);
        data.put("FreshAirDamperFlt2_A2", FreshAirDamperFlt2_A2);
        return data;
    }

    /**
     * FreshAirSensFlt
     *
     * @param
     * @return
     */
    private static Map createFreshAirSensFlt() {
        Map data = new HashMap();
        String iu1FreshAirDamp1Flt = "IU1FreshAirDamp1Flt";
        String iu1FreshAirDamp2Flt = "IU1FreshAirDamp2Flt";
        String iu2FreshAirDamp1Flt = "IU2FreshAirDamp1Flt";
        String iu2FreshAirDamp2Flt = "IU2FreshAirDamp2Flt";
        Long iu1FreshAirDamp1FltA0 = getValue("port0x8a0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltA0 = getValue("port0x8a0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltA0 = getValue("port0x8a0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltA0 = getValue("port0x8a0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_A1 = getStatus(iu1FreshAirDamp1FltA0, iu1FreshAirDamp2FltA0);
        String FreshAirSensFlt2_A1 = getStatus(iu2FreshAirDamp1FltA0, iu2FreshAirDamp2FltA0);
        data.put("FreshAirSensFlt1_A1", FreshAirSensFlt1_A1);
        data.put("FreshAirSensFlt2_A1", FreshAirSensFlt2_A1);

        Long iu1FreshAirDamp1FltB0 = getValue("port0x8b0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltB0 = getValue("port0x8b0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltB0 = getValue("port0x8b0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltB0 = getValue("port0x8b0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_B1 = getStatus(iu1FreshAirDamp1FltB0, iu1FreshAirDamp2FltB0);
        String FreshAirSensFlt2_B1 = getStatus(iu2FreshAirDamp1FltB0, iu2FreshAirDamp2FltB0);
        data.put("FreshAirSensFlt1_B1", FreshAirSensFlt1_B1);
        data.put("FreshAirSensFlt2_B1", FreshAirSensFlt2_B1);

        Long iu1FreshAirDamp1FltC0 = getValue("port0x8c0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltC0 = getValue("port0x8c0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltC0 = getValue("port0x8c0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltC0 = getValue("port0x8c0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_C1 = getStatus(iu1FreshAirDamp1FltC0, iu1FreshAirDamp2FltC0);
        String FreshAirSensFlt2_C1 = getStatus(iu2FreshAirDamp1FltC0, iu2FreshAirDamp2FltC0);
        data.put("FreshAirSensFlt1_C1", FreshAirSensFlt1_C1);
        data.put("FreshAirSensFlt2_C1", FreshAirSensFlt2_C1);


        Long iu1FreshAirDamp1FltD0 = getValue("port0x8d0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltD0 = getValue("port0x8d0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltD0 = getValue("port0x8d0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltD0 = getValue("port0x8d0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_C2 = getStatus(iu1FreshAirDamp1FltD0, iu1FreshAirDamp2FltD0);
        String FreshAirSensFlt2_C2 = getStatus(iu2FreshAirDamp1FltD0, iu2FreshAirDamp2FltD0);
        data.put("FreshAirSensFlt1_C2", FreshAirSensFlt1_C2);
        data.put("FreshAirSensFlt2_C2", FreshAirSensFlt2_C2);

        Long iu1FreshAirDamp1FltE0 = getValue("port0x8e0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltE0 = getValue("port0x8e0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltE0 = getValue("port0x8e0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltE0 = getValue("port0x8e0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_B2 = getStatus(iu1FreshAirDamp1FltE0, iu1FreshAirDamp2FltE0);
        String FreshAirSensFlt2_B2 = getStatus(iu2FreshAirDamp1FltE0, iu2FreshAirDamp2FltE0);
        data.put("FreshAirSensFlt1_B2", FreshAirSensFlt1_B2);
        data.put("FreshAirSensFlt2_B2", FreshAirSensFlt2_B2);

        Long iu1FreshAirDamp1FltF0 = getValue("port0x8f0", iu1FreshAirDamp1Flt);
        Long iu1FreshAirDamp2FltF0 = getValue("port0x8f0", iu1FreshAirDamp2Flt);
        Long iu2FreshAirDamp1FltF0 = getValue("port0x8f0", iu2FreshAirDamp1Flt);
        Long iu2FreshAirDamp2FltF0 = getValue("port0x8f0", iu2FreshAirDamp2Flt);
        String FreshAirSensFlt1_A2 = getStatus(iu1FreshAirDamp1FltF0, iu1FreshAirDamp2FltF0);
        String FreshAirSensFlt2_A2 = getStatus(iu2FreshAirDamp1FltF0, iu2FreshAirDamp2FltF0);
        data.put("FreshAirSensFlt1_A2", FreshAirSensFlt1_A2);
        data.put("FreshAirSensFlt2_A2", FreshAirSensFlt2_A2);
        return data;
    }

    /**
     * HeaterFlt
     *
     * @param
     * @return
     */
    private static Map createHeaterFlt() {
        Map data = new HashMap();
        String IU1HeaterFlt = "IU1HeaterFlt";
        String IU2HeaterFlt = "IU2HeaterFlt";
        Long IU1HeaterFltA0 = getValue("port0x8a0", IU1HeaterFlt);
        Long IU2HeaterFltA0 = getValue("port0x8a0", IU2HeaterFlt);
        String HeaterFlt_A1 = getStatus(IU1HeaterFltA0, IU2HeaterFltA0);
        data.put("HeaterFlt_A1", HeaterFlt_A1);

        Long IU1HeaterFltB0 = getValue("port0x8b0", IU1HeaterFlt);
        Long IU2HeaterFltB0 = getValue("port0x8b0", IU2HeaterFlt);
        String HeaterFlt_B1 = getStatus(IU1HeaterFltB0, IU2HeaterFltB0);
        data.put("HeaterFlt_B1", HeaterFlt_B1);

        Long IU1HeaterFltC0 = getValue("port0x8c0", IU1HeaterFlt);
        Long IU2HeaterFltC0 = getValue("port0x8c0", IU2HeaterFlt);
        String HeaterFlt_C1 = getStatus(IU1HeaterFltC0, IU2HeaterFltC0);
        data.put("HeaterFlt_C1", HeaterFlt_C1);


        Long IU1HeaterFltD0 = getValue("port0x8d0", IU1HeaterFlt);
        Long IU2HeaterFltD0 = getValue("port0x8d0", IU2HeaterFlt);
        String HeaterFlt_C2 = getStatus(IU1HeaterFltD0, IU2HeaterFltD0);
        data.put("HeaterFlt_C2", HeaterFlt_C2);

        Long IU1HeaterFltE0 = getValue("port0x8e0", IU1HeaterFlt);
        Long IU2HeaterFltE0 = getValue("port0x8e0", IU2HeaterFlt);
        String HeaterFlt_B2 = getStatus(IU1HeaterFltE0, IU2HeaterFltE0);
        data.put("HeaterFlt_B2", HeaterFlt_B2);

        Long IU1HeaterFltF0 = getValue("port0x8f0", IU1HeaterFlt);
        Long IU2HeaterFltF0 = getValue("port0x8f0", IU2HeaterFlt);
        String HeaterFlt_A2 = getStatus(IU1HeaterFltF0, IU2HeaterFltF0);
        data.put("HeaterFlt_A2", HeaterFlt_A2);
        return data;
    }

    /**
     * HighPressFlt
     *
     * @param
     * @return
     */
    private static Map createHighPressFlt() {
        Map data = new HashMap();
        String IU1Comp1HighPress = "IU1Comp1HighPress";
        String IU1Comp2HighPress = "IU1Comp2HighPress";
        String IU2Comp1HighPress = "IU2Comp1HighPress";
        String IU2Comp2HighPress = "IU2Comp2HighPress";
        Long IU1Comp1HighPressA0 = getValue("port0x8a0", IU1Comp1HighPress);
        Long IU1Comp2HighPressA0 = getValue("port0x8a0", IU1Comp2HighPress);
        Long IU2Comp1HighPressA0 = getValue("port0x8a0", IU2Comp1HighPress);
        Long IU2Comp2HighPressA0 = getValue("port0x8a0", IU2Comp2HighPress);
        String HighPressFlt1_A1 = getStatus(IU1Comp1HighPressA0, IU1Comp2HighPressA0);
        String HighPressFlt2_A1 = getStatus(IU2Comp1HighPressA0, IU2Comp2HighPressA0);
        data.put("HighPressFlt1_A1", HighPressFlt1_A1);
        data.put("HighPressFlt2_A1", HighPressFlt2_A1);

        Long IU1Comp1HighPressB0 = getValue("port0x8b0", IU1Comp1HighPress);
        Long IU1Comp2HighPressB0 = getValue("port0x8b0", IU1Comp2HighPress);
        Long IU2Comp1HighPressB0 = getValue("port0x8b0", IU2Comp1HighPress);
        Long IU2Comp2HighPressB0 = getValue("port0x8b0", IU2Comp2HighPress);
        String HighPressFlt1_B1 = getStatus(IU1Comp1HighPressB0, IU1Comp2HighPressB0);
        String HighPressFlt2_B1 = getStatus(IU2Comp1HighPressB0, IU2Comp2HighPressB0);
        data.put("HighPressFlt1_B1", HighPressFlt1_B1);
        data.put("HighPressFlt2_B1", HighPressFlt2_B1);

        Long IU1Comp1HighPressC0 = getValue("port0x8c0", IU1Comp1HighPress);
        Long IU1Comp2HighPressC0 = getValue("port0x8c0", IU1Comp2HighPress);
        Long IU2Comp1HighPressC0 = getValue("port0x8c0", IU2Comp1HighPress);
        Long IU2Comp2HighPressC0 = getValue("port0x8c0", IU2Comp2HighPress);
        String HighPressFlt1_C1 = getStatus(IU1Comp1HighPressC0, IU1Comp2HighPressC0);
        String HighPressFlt2_C1 = getStatus(IU2Comp1HighPressC0, IU2Comp2HighPressC0);
        data.put("HighPressFlt1_C1", HighPressFlt1_C1);
        data.put("HighPressFlt2_C1", HighPressFlt2_C1);


        Long IU1Comp1HighPressD0 = getValue("port0x8d0", IU1Comp1HighPress);
        Long IU1Comp2HighPressD0 = getValue("port0x8d0", IU1Comp2HighPress);
        Long IU2Comp1HighPressD0 = getValue("port0x8d0", IU2Comp1HighPress);
        Long IU2Comp2HighPressD0 = getValue("port0x8d0", IU2Comp2HighPress);
        String HighPressFlt1_C2 = getStatus(IU1Comp1HighPressD0, IU1Comp2HighPressD0);
        String HighPressFlt2_C2 = getStatus(IU2Comp1HighPressD0, IU2Comp2HighPressD0);
        data.put("HighPressFlt1_C2", HighPressFlt1_C2);
        data.put("HighPressFlt2_C2", HighPressFlt2_C2);

        Long IU1Comp1HighPressE0 = getValue("port0x8e0", IU1Comp1HighPress);
        Long IU1Comp2HighPressE0 = getValue("port0x8e0", IU1Comp2HighPress);
        Long IU2Comp1HighPressE0 = getValue("port0x8e0", IU2Comp1HighPress);
        Long IU2Comp2HighPressE0 = getValue("port0x8e0", IU2Comp2HighPress);
        String HighPressFlt1_B2 = getStatus(IU1Comp1HighPressE0, IU1Comp2HighPressE0);
        String HighPressFlt2_B2 = getStatus(IU2Comp1HighPressE0, IU2Comp2HighPressE0);
        data.put("HighPressFlt1_B2", HighPressFlt1_B2);
        data.put("HighPressFlt2_B2", HighPressFlt2_B2);

        Long IU1Comp1HighPressF0 = getValue("port0x8f0", IU1Comp1HighPress);
        Long IU1Comp2HighPressF0 = getValue("port0x8f0", IU1Comp2HighPress);
        Long IU2Comp1HighPressF0 = getValue("port0x8f0", IU2Comp1HighPress);
        Long IU2Comp2HighPressF0 = getValue("port0x8f0", IU2Comp2HighPress);
        String HighPressFlt1_A2 = getStatus(IU1Comp1HighPressF0, IU1Comp2HighPressF0);
        String HighPressFlt2_A2 = getStatus(IU2Comp1HighPressF0, IU2Comp2HighPressF0);
        data.put("HighPressFlt1_A2", HighPressFlt1_A2);
        data.put("HighPressFlt2_A2", HighPressFlt2_A2);
        return data;
    }


    /**
     * LowPress
     *
     * @param
     * @return
     */
    private static Map createLowPress() {
        Map data = new HashMap();
        String IU1Comp1LowPress = "IU1Comp1LowPress";
        String IU1Comp2LowPress = "IU1Comp2LowPress";
        String IU2Comp1LowPress = "IU2Comp1LowPress";
        String IU2Comp2LowPress = "IU2Comp2LowPress";
        Long IU1Comp1LowPressA0 = getValue("port0x8a0", IU1Comp1LowPress);
        Long IU1Comp2LowPressA0 = getValue("port0x8a0", IU1Comp2LowPress);
        Long IU2Comp1LowPressA0 = getValue("port0x8a0", IU2Comp1LowPress);
        Long IU2Comp2LowPressA0 = getValue("port0x8a0", IU2Comp2LowPress);
        String LowPressFlt1_A1 = getStatus(IU1Comp1LowPressA0, IU1Comp2LowPressA0);
        String LowPressFlt2_A1 = getStatus(IU2Comp1LowPressA0, IU2Comp2LowPressA0);
        data.put("LowPressFlt1_A1", LowPressFlt1_A1);
        data.put("LowPressFlt2_A1", LowPressFlt2_A1);

        Long IU1Comp1LowPressB0 = getValue("port0x8b0", IU1Comp1LowPress);
        Long IU1Comp2LowPressB0 = getValue("port0x8b0", IU1Comp2LowPress);
        Long IU2Comp1LowPressB0 = getValue("port0x8b0", IU2Comp1LowPress);
        Long IU2Comp2LowPressB0 = getValue("port0x8b0", IU2Comp2LowPress);
        String LowPressFlt1_B1 = getStatus(IU1Comp1LowPressB0, IU1Comp2LowPressB0);
        String LowPressFlt2_B1 = getStatus(IU2Comp1LowPressB0, IU2Comp2LowPressB0);
        data.put("LowPressFlt1_B1", LowPressFlt1_B1);
        data.put("LowPressFlt2_B1", LowPressFlt2_B1);

        Long IU1Comp1LowPressC0 = getValue("port0x8c0", IU1Comp1LowPress);
        Long IU1Comp2LowPressC0 = getValue("port0x8c0", IU1Comp2LowPress);
        Long IU2Comp1LowPressC0 = getValue("port0x8c0", IU2Comp1LowPress);
        Long IU2Comp2LowPressC0 = getValue("port0x8c0", IU2Comp2LowPress);
        String LowPressFlt1_C1 = getStatus(IU1Comp1LowPressC0, IU1Comp2LowPressC0);
        String LowPressFlt2_C1 = getStatus(IU2Comp1LowPressC0, IU2Comp2LowPressC0);
        data.put("LowPressFlt1_C1", LowPressFlt1_C1);
        data.put("LowPressFlt2_C1", LowPressFlt2_C1);


        Long IU1Comp1LowPressD0 = getValue("port0x8d0", IU1Comp1LowPress);
        Long IU1Comp2LowPressD0 = getValue("port0x8d0", IU1Comp2LowPress);
        Long IU2Comp1LowPressD0 = getValue("port0x8d0", IU2Comp1LowPress);
        Long IU2Comp2LowPressD0 = getValue("port0x8d0", IU2Comp2LowPress);
        String LowPressFlt1_C2 = getStatus(IU1Comp1LowPressD0, IU1Comp2LowPressD0);
        String LowPressFlt2_C2 = getStatus(IU2Comp1LowPressD0, IU2Comp2LowPressD0);
        data.put("LowPressFlt1_C2", LowPressFlt1_C2);
        data.put("LowPressFlt2_C2", LowPressFlt2_C2);

        Long IU1Comp1LowPressE0 = getValue("port0x8e0", IU1Comp1LowPress);
        Long IU1Comp2LowPressE0 = getValue("port0x8e0", IU1Comp2LowPress);
        Long IU2Comp1LowPressE0 = getValue("port0x8e0", IU2Comp1LowPress);
        Long IU2Comp2LowPressE0 = getValue("port0x8e0", IU2Comp2LowPress);
        String LowPressFlt1_B2 = getStatus(IU1Comp1LowPressE0, IU1Comp2LowPressE0);
        String LowPressFlt2_B2 = getStatus(IU2Comp1LowPressE0, IU2Comp2LowPressE0);
        data.put("LowPressFlt1_B2", LowPressFlt1_B2);
        data.put("LowPressFlt2_B2", LowPressFlt2_B2);

        Long IU1Comp1LowPressF0 = getValue("port0x8f0", IU1Comp1LowPress);
        Long IU1Comp2LowPressF0 = getValue("port0x8f0", IU1Comp2LowPress);
        Long IU2Comp1LowPressF0 = getValue("port0x8f0", IU2Comp1LowPress);
        Long IU2Comp2LowPressF0 = getValue("port0x8f0", IU2Comp2LowPress);
        String LowPressFlt1_A2 = getStatus(IU1Comp1LowPressF0, IU1Comp2LowPressF0);
        String LowPressFlt2_A2 = getStatus(IU2Comp1LowPressF0, IU2Comp2LowPressF0);
        data.put("LowPressFlt1_A2", LowPressFlt1_A2);
        data.put("LowPressFlt2_A2", LowPressFlt2_A2);
        return data;
    }


    /**
     * IMajorFlt
     *
     * @param
     * @return
     */
    private static Map createIMajorFlt() {
        Map data = new HashMap();
        String IMajorFlt = "IMajorFlt";
        Long IMajorFltA0 = getValue("port0x8a0", IMajorFlt);
        data.put("IMajorFlt_A1", IMajorFltA0 == 1 ? "true" : "false");

        Long IMajorFltB0 = getValue("port0x8b0", IMajorFlt);
        data.put("IMajorFlt_B1", IMajorFltB0 == 1 ? "true" : "false");

        Long IMajorFltC0 = getValue("port0x8c0", IMajorFlt);
        data.put("IMajorFlt_C1", IMajorFltC0 == 1 ? "true" : "false");


        Long IMajorFltD0 = getValue("port0x8d0", IMajorFlt);
        data.put("IMajorFlt_C2", IMajorFltD0 == 1 ? "true" : "false");

        Long IMajorFltE0 = getValue("port0x8e0", IMajorFlt);
        data.put("IMajorFlt_B2", IMajorFltE0 == 1 ? "true" : "false");

        Long IMajorFltF0 = getValue("port0x8f0", IMajorFlt);
        data.put("IMajorFlt_A2", IMajorFltF0 == 1 ? "true" : "false");
        return data;
    }

    /**
     * IMediumFlt
     *
     * @param
     * @return
     */
    private static Map createIMediumFlt() {
        Map data = new HashMap();
        String IMediumFlt = "IMediumFlt";
        Long IMediumFltA0 = getValue("port0x8a0", IMediumFlt);
        data.put("IMediumFlt_A1", IMediumFltA0 == 1 ? "true" : "false");

        Long IMediumFltB0 = getValue("port0x8b0", IMediumFlt);
        data.put("IMediumFlt_B1", IMediumFltB0 == 1 ? "true" : "false");

        Long IMediumFltC0 = getValue("port0x8c0", IMediumFlt);
        data.put("IMediumFlt_C1", IMediumFltC0 == 1 ? "true" : "false");


        Long IMediumFltD0 = getValue("port0x8d0", IMediumFlt);
        data.put("IMediumFlt_C2", IMediumFltD0 == 1 ? "true" : "false");

        Long IMediumFltE0 = getValue("port0x8e0", IMediumFlt);
        data.put("IMediumFlt_B2", IMediumFltE0 == 1 ? "true" : "false");

        Long IMediumFltF0 = getValue("port0x8f0", IMediumFlt);
        data.put("IMediumFlt_A2", IMediumFltF0 == 1 ? "true" : "false");
        return data;
    }

    /**
     * MediumVoltFlt
     *
     * @param
     * @return
     */
    private static Map createMediumVoltFlt() {
        Map data = new HashMap();
        String IU1MediumVoltFlt = "IU1MediumVoltFlt";
        String IU2MediumVoltFlt = "IU2MediumVoltFlt";
        Long IU1MediumVoltFltA0 = getValue("port0x8a0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltA0 = getValue("port0x8a0", IU2MediumVoltFlt);
        String MediumVoltFlt_A1 = getStatus(IU1MediumVoltFltA0, IU2MediumVoltFltA0);
        data.put("MediumVoltFlt_A1", MediumVoltFlt_A1);

        Long IU1MediumVoltFltB0 = getValue("port0x8b0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltB0 = getValue("port0x8b0", IU2MediumVoltFlt);
        String MediumVoltFlt_B1 = getStatus(IU1MediumVoltFltB0, IU2MediumVoltFltB0);
        data.put("MediumVoltFlt_B1", MediumVoltFlt_B1);
        Long IU1MediumVoltFltC0 = getValue("port0x8c0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltC0 = getValue("port0x8c0", IU2MediumVoltFlt);
        String MediumVoltFlt_C1 = getStatus(IU1MediumVoltFltC0, IU2MediumVoltFltC0);
        data.put("MediumVoltFlt_C1", MediumVoltFlt_C1);


        Long IU1MediumVoltFltD0 = getValue("port0x8d0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltD0 = getValue("port0x8d0", IU2MediumVoltFlt);
        String MediumVoltFlt_C2 = getStatus(IU1MediumVoltFltD0, IU2MediumVoltFltD0);
        data.put("MediumVoltFlt_C2", MediumVoltFlt_C2);

        Long IU1MediumVoltFltE0 = getValue("port0x8e0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltE0 = getValue("port0x8e0", IU2MediumVoltFlt);
        String MediumVoltFlt_B2 = getStatus(IU1MediumVoltFltE0, IU2MediumVoltFltE0);
        data.put("MediumVoltFlt_B2", MediumVoltFlt_B2);

        Long IU1MediumVoltFltF0 = getValue("port0x8f0", IU1MediumVoltFlt);
        Long IU2MediumVoltFltF0 = getValue("port0x8f0", IU2MediumVoltFlt);
        String MediumVoltFlt_A2 = getStatus(IU1MediumVoltFltF0, IU2MediumVoltFltF0);
        data.put("MediumVoltFlt_A2", MediumVoltFlt_A2);
        return data;
    }


    /**
     * IMinorFlt
     *
     * @param
     * @return
     */
    private static Map createIMinorFlt() {
        Map data = new HashMap();
        String IMinorFlt = "IMinorFlt";
        Long IMinorFltA0 = getValue("port0x8a0", IMinorFlt);
        data.put("IMinorFlt_A1", IMinorFltA0 == 1 ? "true" : "false");

        Long IMinorFltB0 = getValue("port0x8b0", IMinorFlt);
        data.put("IMinorFlt_B1", IMinorFltB0 == 1 ? "true" : "false");

        Long IMinorFltC0 = getValue("port0x8c0", IMinorFlt);
        data.put("IMinorFlt_C1", IMinorFltC0 == 1 ? "true" : "false");


        Long IMinorFltD0 = getValue("port0x8d0", IMinorFlt);
        data.put("IMinorFlt_C2", IMinorFltD0 == 1 ? "true" : "false");

        Long IMinorFltE0 = getValue("port0x8e0", IMinorFlt);
        data.put("IMinorFlt_B2", IMinorFltE0 == 1 ? "true" : "false");

        Long IMinorFltF0 = getValue("port0x8f0", IMinorFlt);
        data.put("IMinorFlt_A2", IMinorFltF0 == 1 ? "true" : "false");
        return data;
    }


    /**
     * ReturnAirDamp
     *
     * @param
     * @return
     */
    private static Map createReturnAirDamp() {
        Map data = new HashMap();
        String IU1ReturnAirDamp1Flt = "IU1ReturnAirDamp1Flt";
        String IU1ReturnAirDamp2Flt = "IU1ReturnAirDamp2Flt";
        String IU1ReturnAirDamp3Flt = "IU1ReturnAirDamp3Flt";
        String IU1ReturnAirDamp4Flt = "IU1ReturnAirDamp4Flt";
        String IU2ReturnAirDamp1Flt = "IU2ReturnAirDamp1Flt";
        String IU2ReturnAirDamp2Flt = "IU2ReturnAirDamp2Flt";
        String IU2ReturnAirDamp3Flt = "IU2ReturnAirDamp3Flt";
        String IU2ReturnAirDamp4Flt = "IU2ReturnAirDamp4Flt";
        Long IU1ReturnAirDamp1FltA0 = getValue("port0x8a0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltA0 = getValue("port0x8a0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltA0 = getValue("port0x8a0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltA0 = getValue("port0x8a0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltA0 = getValue("port0x8a0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltA0 = getValue("port0x8a0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltA0 = getValue("port0x8a0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltA0 = getValue("port0x8a0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_A1 = getStatus(IU1ReturnAirDamp1FltA0, IU1ReturnAirDamp2FltA0, IU1ReturnAirDamp3FltA0, IU1ReturnAirDamp4FltA0);
        String ReturnAirDamp1Flt2_A1 = getStatus(IU2ReturnAirDamp1FltA0, IU2ReturnAirDamp2FltA0, IU2ReturnAirDamp3FltA0, IU2ReturnAirDamp4FltA0);
        data.put("ReturnAirDamp1Flt_A1", ReturnAirDamp1Flt_A1);
        data.put("ReturnAirDamp1Flt2_A1", ReturnAirDamp1Flt2_A1);

        Long IU1ReturnAirDamp1FltB0 = getValue("port0x8b0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltB0 = getValue("port0x8b0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltB0 = getValue("port0x8b0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltB0 = getValue("port0x8b0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltB0 = getValue("port0x8b0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltB0 = getValue("port0x8b0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltB0 = getValue("port0x8b0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltB0 = getValue("port0x8b0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_B1 = getStatus(IU1ReturnAirDamp1FltB0, IU1ReturnAirDamp2FltB0, IU1ReturnAirDamp3FltB0, IU1ReturnAirDamp4FltB0);
        String ReturnAirDamp1Flt2_B1 = getStatus(IU2ReturnAirDamp1FltB0, IU2ReturnAirDamp2FltB0, IU2ReturnAirDamp3FltB0, IU2ReturnAirDamp4FltB0);
        data.put("ReturnAirDamp1Flt_B1", ReturnAirDamp1Flt_B1);
        data.put("ReturnAirDamp1Flt2_B1", ReturnAirDamp1Flt2_B1);

        Long IU1ReturnAirDamp1FltC0 = getValue("port0x8c0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltC0 = getValue("port0x8c0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltC0 = getValue("port0x8c0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltC0 = getValue("port0x8c0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltC0 = getValue("port0x8c0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltC0 = getValue("port0x8c0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltC0 = getValue("port0x8c0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltC0 = getValue("port0x8c0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_C1 = getStatus(IU1ReturnAirDamp1FltC0, IU1ReturnAirDamp2FltC0, IU1ReturnAirDamp3FltC0, IU1ReturnAirDamp4FltC0);
        String ReturnAirDamp1Flt2_C1 = getStatus(IU2ReturnAirDamp1FltC0, IU2ReturnAirDamp2FltC0, IU2ReturnAirDamp3FltC0, IU2ReturnAirDamp4FltC0);
        data.put("ReturnAirDamp1Flt_C1", ReturnAirDamp1Flt_C1);
        data.put("ReturnAirDamp1Flt2_C1", ReturnAirDamp1Flt2_C1);


        Long IU1ReturnAirDamp1FltD0 = getValue("port0x8d0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltD0 = getValue("port0x8d0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltD0 = getValue("port0x8d0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltD0 = getValue("port0x8d0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltD0 = getValue("port0x8d0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltD0 = getValue("port0x8d0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltD0 = getValue("port0x8d0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltD0 = getValue("port0x8d0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_C2 = getStatus(IU1ReturnAirDamp1FltD0, IU1ReturnAirDamp2FltD0, IU1ReturnAirDamp3FltD0, IU1ReturnAirDamp4FltD0);
        String ReturnAirDamp1Flt2_C2 = getStatus(IU2ReturnAirDamp1FltD0, IU2ReturnAirDamp2FltD0, IU2ReturnAirDamp3FltD0, IU2ReturnAirDamp4FltD0);
        data.put("ReturnAirDamp1Flt_C2", ReturnAirDamp1Flt_C2);
        data.put("ReturnAirDamp1Flt2_C2", ReturnAirDamp1Flt2_C2);

        Long IU1ReturnAirDamp1FltE0 = getValue("port0x8e0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltE0 = getValue("port0x8e0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltE0 = getValue("port0x8e0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltE0 = getValue("port0x8e0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltE0 = getValue("port0x8e0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltE0 = getValue("port0x8e0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltE0 = getValue("port0x8e0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltE0 = getValue("port0x8e0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_B2 = getStatus(IU1ReturnAirDamp1FltE0, IU1ReturnAirDamp2FltE0, IU1ReturnAirDamp3FltE0, IU1ReturnAirDamp4FltE0);
        String ReturnAirDamp1Flt2_B2 = getStatus(IU2ReturnAirDamp1FltE0, IU2ReturnAirDamp2FltE0, IU2ReturnAirDamp3FltE0, IU2ReturnAirDamp4FltE0);
        data.put("ReturnAirDamp1Flt_B2", ReturnAirDamp1Flt_B2);
        data.put("ReturnAirDamp1Flt2_B2", ReturnAirDamp1Flt2_B2);

        Long IU1ReturnAirDamp1FltF0 = getValue("port0x8f0", IU1ReturnAirDamp1Flt);
        Long IU1ReturnAirDamp2FltF0 = getValue("port0x8f0", IU1ReturnAirDamp2Flt);
        Long IU1ReturnAirDamp3FltF0 = getValue("port0x8f0", IU1ReturnAirDamp3Flt);
        Long IU1ReturnAirDamp4FltF0 = getValue("port0x8f0", IU1ReturnAirDamp4Flt);
        Long IU2ReturnAirDamp1FltF0 = getValue("port0x8f0", IU2ReturnAirDamp1Flt);
        Long IU2ReturnAirDamp2FltF0 = getValue("port0x8f0", IU2ReturnAirDamp2Flt);
        Long IU2ReturnAirDamp3FltF0 = getValue("port0x8f0", IU2ReturnAirDamp3Flt);
        Long IU2ReturnAirDamp4FltF0 = getValue("port0x8f0", IU2ReturnAirDamp4Flt);
        String ReturnAirDamp1Flt_A2 = getStatus(IU1ReturnAirDamp1FltF0, IU1ReturnAirDamp2FltF0, IU1ReturnAirDamp3FltF0, IU1ReturnAirDamp4FltF0);
        String ReturnAirDamp1Flt2_A2 = getStatus(IU2ReturnAirDamp1FltF0, IU2ReturnAirDamp2FltF0, IU2ReturnAirDamp3FltF0, IU2ReturnAirDamp4FltF0);
        data.put("ReturnAirDamp1Flt_A2", ReturnAirDamp1Flt_A2);
        data.put("ReturnAirDamp1Flt2_A2", ReturnAirDamp1Flt2_A2);
        return data;
    }

    /**
     * ReturnAirTempSensFlt
     *
     * @param
     * @return
     */
    private static Map createReturnAirTempSensFlt() {
        Map data = new HashMap();
        String IU1ReturnAirTempSensFlt = "IU1ReturnAirTempSensFlt";
        String IU2ReturnAirTempSensFlt = "IU2ReturnAirTempSensFlt";
        Long IU1ReturnAirTempSensFltA0 = getValue("port0x8a0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltA0 = getValue("port0x8a0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt_A1 = getStatus(IU1ReturnAirTempSensFltA0, IU2ReturnAirTempSensFltA0);
        data.put("ReturnAirTempSensFlt_A1", ReturnAirTempSensFlt_A1);
        Long IU1ReturnAirTempSensFltB0 = getValue("port0x8b0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltB0 = getValue("port0x8b0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt1_B1 = getStatus(IU1ReturnAirTempSensFltB0, IU2ReturnAirTempSensFltB0);
        data.put("ReturnAirTempSensFlt_B1", ReturnAirTempSensFlt1_B1);

        Long IU1ReturnAirTempSensFltC0 = getValue("port0x8c0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltC0 = getValue("port0x8c0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt_C1 = getStatus(IU1ReturnAirTempSensFltC0, IU2ReturnAirTempSensFltC0);
        data.put("ReturnAirTempSensFlt_C1", ReturnAirTempSensFlt_C1);


        Long IU1ReturnAirTempSensFltD0 = getValue("port0x8d0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltD0 = getValue("port0x8d0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt_C2 = getStatus(IU1ReturnAirTempSensFltD0, IU2ReturnAirTempSensFltD0);
        data.put("ReturnAirTempSensFlt_C2", ReturnAirTempSensFlt_C2);

        Long IU1ReturnAirTempSensFltE0 = getValue("port0x8e0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltE0 = getValue("port0x8e0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt_B2 = getStatus(IU1ReturnAirTempSensFltE0, IU2ReturnAirTempSensFltE0);
        data.put("ReturnAirTempSensFlt_B2", ReturnAirTempSensFlt_B2);
        Long IU1ReturnAirTempSensFltF0 = getValue("port0x8f0", IU1ReturnAirTempSensFlt);
        Long IU2ReturnAirTempSensFltF0 = getValue("port0x8f0", IU2ReturnAirTempSensFlt);
        String ReturnAirTempSensFlt_A2 = getStatus(IU1ReturnAirTempSensFltF0, IU2ReturnAirTempSensFltF0);
        data.put("ReturnAirTempSensFlt_A2", ReturnAirTempSensFlt_A2);
        return data;
    }

    /**
     * IVentFlt
     *
     * @param
     * @return
     */
    private static Map createIVentFlt() {
        Map data = new HashMap();
        String IU1Vent1Flt = "IU1Vent1Flt";
        String IU1Vent2Flt = "IU1Vent2Flt";
        String IU2Vent1Flt = "IU2Vent1Flt";
        String IU2Vent2Flt = "IU2Vent2Flt";
        Long IU1Vent1FltA0 = getValue("port0x8a0", IU1Vent1Flt);
        Long IU1Vent2FltA0 = getValue("port0x8a0", IU1Vent2Flt);
        Long IU2Vent1FltA0 = getValue("port0x8a0", IU2Vent1Flt);
        Long IU2Vent2FltA0 = getValue("port0x8a0", IU2Vent2Flt);
        String Vent1Flt_A1 = getStatus(IU1Vent1FltA0, IU1Vent2FltA0);
        String Vent2Flt_A1 = getStatus(IU2Vent1FltA0, IU2Vent2FltA0);
        data.put("Vent1Flt_A1", Vent1Flt_A1);
        data.put("Vent2Flt_A1", Vent2Flt_A1);

        Long IU1Vent1FltB0 = getValue("port0x8b0", IU1Vent1Flt);
        Long IU1Vent2FltB0 = getValue("port0x8b0", IU1Vent2Flt);
        Long IU2Vent1FltB0 = getValue("port0x8b0", IU2Vent1Flt);
        Long IU2Vent2FltB0 = getValue("port0x8b0", IU2Vent2Flt);
        String Vent1Flt_B1 = getStatus(IU1Vent1FltB0, IU1Vent2FltB0);
        String Vent2Flt_B1 = getStatus(IU2Vent1FltB0, IU2Vent2FltB0);
        data.put("Vent1Flt_B1", Vent1Flt_B1);
        data.put("Vent2Flt_B1", Vent2Flt_B1);

        Long IU1Vent1FltC0 = getValue("port0x8c0", IU1Vent1Flt);
        Long IU1Vent2FltC0 = getValue("port0x8c0", IU1Vent2Flt);
        Long IU2Vent1FltC0 = getValue("port0x8c0", IU2Vent1Flt);
        Long IU2Vent2FltC0 = getValue("port0x8c0", IU2Vent2Flt);
        String Vent1Flt_C1 = getStatus(IU1Vent1FltC0, IU1Vent2FltC0);
        String Vent2Flt_C1 = getStatus(IU2Vent1FltC0, IU2Vent2FltC0);
        data.put("Vent1Flt_C1", Vent1Flt_C1);
        data.put("Vent2Flt_C1", Vent2Flt_C1);


        Long IU1Vent1FltD0 = getValue("port0x8d0", IU1Vent1Flt);
        Long IU1Vent2FltD0 = getValue("port0x8d0", IU1Vent2Flt);
        Long IU2Vent1FltD0 = getValue("port0x8d0", IU2Vent1Flt);
        Long IU2Vent2FltD0 = getValue("port0x8d0", IU2Vent2Flt);
        String Vent1Flt_C2 = getStatus(IU1Vent1FltD0, IU1Vent2FltD0);
        String Vent2Flt_C2 = getStatus(IU2Vent1FltD0, IU2Vent2FltD0);
        data.put("Vent1Flt_C2", Vent1Flt_C2);
        data.put("Vent2Flt_C2", Vent2Flt_C2);

        Long IU1Vent1FltE0 = getValue("port0x8e0", IU1Vent1Flt);
        Long IU1Vent2FltE0 = getValue("port0x8e0", IU1Vent2Flt);
        Long IU2Vent1FltE0 = getValue("port0x8e0", IU2Vent1Flt);
        Long IU2Vent2FltE0 = getValue("port0x8e0", IU2Vent2Flt);
        String Vent1Flt_B2 = getStatus(IU1Vent1FltE0, IU1Vent2FltE0);
        String Vent2Flt_B2 = getStatus(IU2Vent1FltE0, IU2Vent2FltE0);
        data.put("Vent1Flt_B2", Vent1Flt_B2);
        data.put("Vent2Flt_B2", Vent2Flt_B2);

        Long IU1Vent1FltF0 = getValue("port0x8f0", IU1Vent1Flt);
        Long IU1Vent2FltF0 = getValue("port0x8f0", IU1Vent2Flt);
        Long IU2Vent1FltF0 = getValue("port0x8f0", IU2Vent1Flt);
        Long IU2Vent2FltF0 = getValue("port0x8f0", IU2Vent2Flt);
        String Vent1Flt_A2 = getStatus(IU1Vent1FltF0, IU1Vent2FltF0);
        String Vent2Flt_A2 = getStatus(IU2Vent1FltF0, IU2Vent2FltF0);
        data.put("Vent1Flt_A2", Vent1Flt_A2);
        data.put("Vent2Flt_A2", Vent2Flt_A2);
        return data;


    }


    /**
     * supply air temperature sensor failure
     *
     * @param
     * @return
     */
    private static Map createSupplyAirTemperatureSensorFailure() {
        Map data = new HashMap();
        String IU1AirTempSensorFlt = "IU1AirTempSensorFlt";
        String IU2AirTempSensorFlt = "IU2AirTempSensorFlt";
        Long IU1AirTempSensorFltA0 = getValue("port0x8a0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltA0 = getValue("port0x8a0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_A1", IU1AirTempSensorFltA0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_A1", IU2AirTempSensorFltA0 == 1 ? "true" : "false");

        Long IU1AirTempSensorFltB0 = getValue("port0x8b0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltB0 = getValue("port0x8b0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_B1", IU1AirTempSensorFltB0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_B1", IU2AirTempSensorFltB0 == 1 ? "true" : "false");

        Long IU1AirTempSensorFltC0 = getValue("port0x8c0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltC0 = getValue("port0x8c0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_C1", IU1AirTempSensorFltC0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_C1", IU2AirTempSensorFltC0 == 1 ? "true" : "false");


        Long IU1AirTempSensorFltD0 = getValue("port0x8d0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltD0 = getValue("port0x8d0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_C2", IU1AirTempSensorFltD0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_C2", IU2AirTempSensorFltD0 == 1 ? "true" : "false");

        Long IU1AirTempSensorFltE0 = getValue("port0x8e0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltE0 = getValue("port0x8e0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_B2", IU1AirTempSensorFltE0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_B2", IU2AirTempSensorFltE0 == 1 ? "true" : "false");

        Long IU1AirTempSensorFltF0 = getValue("port0x8f0", IU1AirTempSensorFlt);
        Long IU2AirTempSensorFltF0 = getValue("port0x8f0", IU2AirTempSensorFlt);
        data.put("AirTempSensorFlt1_A2", IU1AirTempSensorFltF0 == 1 ? "true" : "false");
        data.put("AirTempSensorFlt2_A2", IU2AirTempSensorFltF0 == 1 ? "true" : "false");
        return data;


    }

    private static String getStatus(Long val1, Long val2) {
        String status = "false";
        if (val1 == 1 || val2 == 1) {
            status = "true";
        }
        return status;
    }

    private static String getStatus(Long val1, Long val2, Long val3, Long val4) {
        String status = "false";
        if (val1 == 1 || val2 == 1 || val3 == 1 || val4 == 1) {
            status = "true";
        }
        return status;
    }
}
