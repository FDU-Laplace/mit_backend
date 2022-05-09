package com.missiongroup.starring.core.vehicleData;

import java.util.HashMap;
import java.util.Map;

public class PECUDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String,Object> data = new HashMap<>();
        Map pecua1 = createPECUA1();
        Map pecua2 = createPECUA2();
        Map pecub1 = createPECUB1();
        Map pecub2 = createPECUB2();
        Map pecuc1 = createPECUC1();
        Map pecuc2 = createPECUC2();
        Map operation = createPECUOP();
        data.put("pecua1",pecua1);
        data.put("pecua2",pecua2);
        data.put("pecub1",pecub1);
        data.put("pecub2",pecub2);
        data.put("pecuc1",pecuc1);
        data.put("pecuc2",pecuc2);
        data.put("operation",operation);
        return data;
    }

    private static Map createPECUA1() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_a1 = getValue("port0x123", "DD_CCallPECU1_A1");
        Long dd_cComPECU1Ok_a1 =getValue("port0x123", "DD_CComPECU1Ok_A1");
        String a1_1 = getPECUStatus(dd_cCallPECU1_a1, dd_cComPECU1Ok_a1);
        data.put("a1_1",a1_1);
        Long dd_cCallPECU2_a1 = getValue("port0x123", "DD_CCallPECU2_A1");
        Long dd_cComPECU2Ok_a1 =getValue("port0x123", "DD_CComPECU2Ok_A1");
        String a1_2 = getPECUStatus(dd_cCallPECU2_a1, dd_cComPECU2Ok_a1);
        data.put("a1_2",a1_2);
        Long dd_cCallPECU3_a1 = getValue("port0x123", "DD_CCallPECU3_A1");
        Long dd_cComPECU3Ok_a1 =getValue("port0x123", "DD_CComPECU3Ok_A1");
        String a1_3 = getPECUStatus(dd_cCallPECU3_a1, dd_cComPECU3Ok_a1);
        data.put("a1_3",a1_3);
        Long dd_cCallPECU4_a1 = getValue("port0x123", "DD_CCallPECU4_A1");
        Long dd_cComPECU4Ok_a1 =getValue("port0x123", "DD_CComPECU4Ok_A1");
        String a1_4 = getPECUStatus(dd_cCallPECU4_a1, dd_cComPECU4Ok_a1);
        data.put("a1_4",a1_4);
        Long dd_cCallPECU5_a1 = getValue("port0x123", "DD_CCallPECU5_A1");
        Long dd_cComPECU5Ok_a1 =getValue("port0x123", "DD_CComPECU5Ok_A1");
        String a1_5 = getPECUStatus(dd_cCallPECU5_a1, dd_cComPECU5Ok_a1);
        data.put("a1_5",a1_5);
        Long dd_cCallPECU6_a1 = getValue("port0x123", "DD_CCallPECU6_A1");
        Long dd_cComPECU6Ok_a1 =getValue("port0x123", "DD_CComPECU6Ok_A1");
        String a1_6 = getPECUStatus(dd_cCallPECU6_a1, dd_cComPECU6Ok_a1);
        data.put("a1_6",a1_6);
        return data;
    }
    private static Map createPECUA2() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_a2 = getValue("port0x123", "DD_CCallPECU1_A2");
        Long dd_cComPECU1Ok_a2 =getValue("port0x123", "DD_CComPECU1Ok_A2");
        String a2_1 = getPECUStatus(dd_cCallPECU1_a2, dd_cComPECU1Ok_a2);
        data.put("a2_1",a2_1);
        Long dd_cCallPECU2_a2 = getValue("port0x123", "DD_CCallPECU2_A2");
        Long dd_cComPECU2Ok_a2 =getValue("port0x123", "DD_CComPECU2Ok_A2");
        String a2_2 = getPECUStatus(dd_cCallPECU2_a2, dd_cComPECU2Ok_a2);
        data.put("a2_2",a2_2);
        Long dd_cCallPECU3_a2 = getValue("port0x123", "DD_CCallPECU3_A2");
        Long dd_cComPECU3Ok_a2 =getValue("port0x123", "DD_CComPECU3Ok_A2");
        String a2_3 = getPECUStatus(dd_cCallPECU3_a2, dd_cComPECU3Ok_a2);
        data.put("a2_3",a2_3);
        Long dd_cCallPECU4_a2 = getValue("port0x123", "DD_CCallPECU4_A2");
        Long dd_cComPECU4Ok_a2 =getValue("port0x123", "DD_CComPECU4Ok_A2");
        String a2_4 = getPECUStatus(dd_cCallPECU4_a2, dd_cComPECU4Ok_a2);
        data.put("a2_4",a2_4);
        Long dd_cCallPECU5_a2 = getValue("port0x123", "DD_CCallPECU5_A2");
        Long dd_cComPECU5Ok_a2 =getValue("port0x123", "DD_CComPECU5Ok_A2");
        String a2_5 = getPECUStatus(dd_cCallPECU5_a2, dd_cComPECU5Ok_a2);
        data.put("a2_5",a2_5);
        Long dd_cCallPECU6_a2 = getValue("port0x123", "DD_CCallPECU6_A2");
        Long dd_cComPECU6Ok_a2 =getValue("port0x123", "DD_CComPECU6Ok_A2");
        String a2_6 = getPECUStatus(dd_cCallPECU6_a2, dd_cComPECU6Ok_a2);
        data.put("a2_6",a2_6);
        return data;
    }
    private static Map createPECUB1() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_b1 = getValue("port0x123", "DD_CCallPECU1_B1");
        Long dd_cComPECU1Ok_b1 =getValue("port0x123", "DD_CComPECU1Ok_B1");
        String b1_1 = getPECUStatus(dd_cCallPECU1_b1, dd_cComPECU1Ok_b1);
        data.put("b1_1",b1_1);
        Long dd_cCallPECU2_b1 = getValue("port0x123", "DD_CCallPECU2_B1");
        Long dd_cComPECU2Ok_b1 =getValue("port0x123", "DD_CComPECU2Ok_B1");
        String b1_2 = getPECUStatus(dd_cCallPECU2_b1, dd_cComPECU2Ok_b1);
        data.put("b1_2",b1_2);
        Long dd_cCallPECU3_b1 = getValue("port0x123", "DD_CCallPECU3_B1");
        Long dd_cComPECU3Ok_b1 =getValue("port0x123", "DD_CComPECU3Ok_B1");
        String b1_3 = getPECUStatus(dd_cCallPECU3_b1, dd_cComPECU3Ok_b1);
        data.put("b1_3",b1_3);
        Long dd_cCallPECU4_b1 = getValue("port0x123", "DD_CCallPECU4_B1");
        Long dd_cComPECU4Ok_b1 =getValue("port0x123", "DD_CComPECU4Ok_B1");
        String b1_4 = getPECUStatus(dd_cCallPECU4_b1, dd_cComPECU4Ok_b1);
        data.put("b1_4",b1_4);
        Long dd_cCallPECU5_b1 = getValue("port0x123", "DD_CCallPECU5_B1");
        Long dd_cComPECU5Ok_b1 =getValue("port0x123", "DD_CComPECU5Ok_B1");
        String b1_5 = getPECUStatus(dd_cCallPECU5_b1, dd_cComPECU5Ok_b1);
        data.put("b1_5",b1_5);
        return data;
    }
    private static Map createPECUB2() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_b2 = getValue("port0x123", "DD_CCallPECU1_B2");
        Long dd_cComPECU1Ok_b2 =getValue("port0x123", "DD_CComPECU1Ok_B2");
        String b2_1 = getPECUStatus(dd_cCallPECU1_b2, dd_cComPECU1Ok_b2);
        data.put("b2_1",b2_1);
        Long dd_cCallPECU2_b2 = getValue("port0x123", "DD_CCallPECU2_B2");
        Long dd_cComPECU2Ok_b2 =getValue("port0x123", "DD_CComPECU2Ok_B2");
        String b2_2 = getPECUStatus(dd_cCallPECU2_b2, dd_cComPECU2Ok_b2);
        data.put("b2_2",b2_2);
        Long dd_cCallPECU3_b2 = getValue("port0x123", "DD_CCallPECU3_B2");
        Long dd_cComPECU3Ok_b2 =getValue("port0x123", "DD_CComPECU3Ok_B2");
        String b2_3 = getPECUStatus(dd_cCallPECU3_b2, dd_cComPECU3Ok_b2);
        data.put("b2_3",b2_3);
        Long dd_cCallPECU4_b2 = getValue("port0x123", "DD_CCallPECU4_B2");
        Long dd_cComPECU4Ok_b2 =getValue("port0x123", "DD_CComPECU4Ok_B2");
        String b2_4 = getPECUStatus(dd_cCallPECU4_b2, dd_cComPECU4Ok_b2);
        data.put("b2_4",b2_4);
        Long dd_cCallPECU5_b2 = getValue("port0x123", "DD_CCallPECU5_B2");
        Long dd_cComPECU5Ok_b2 =getValue("port0x123", "DD_CComPECU5Ok_B2");
        String b2_5 = getPECUStatus(dd_cCallPECU5_b2, dd_cComPECU5Ok_b2);
        data.put("b2_5",b2_5);
        return data;
    }

    private static Map createPECUC1() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_c1 = getValue("port0x123", "DD_CCallPECU1_C1");
        Long dd_cComPECU1Ok_c1 =getValue("port0x123", "DD_CComPECU1Ok_C1");
        String c1_1 = getPECUStatus(dd_cCallPECU1_c1, dd_cComPECU1Ok_c1);
        data.put("c1_1",c1_1);
        Long dd_cCallPECU2_c1 = getValue("port0x123", "DD_CCallPECU2_C1");
        Long dd_cComPECU2Ok_c1 =getValue("port0x123", "DD_CComPECU2Ok_C1");
        String c1_2 = getPECUStatus(dd_cCallPECU2_c1, dd_cComPECU2Ok_c1);
        data.put("c1_2",c1_2);
        Long dd_cCallPECU3_c1 = getValue("port0x123", "DD_CCallPECU3_C1");
        Long dd_cComPECU3Ok_c1 =getValue("port0x123", "DD_CComPECU3Ok_C1");
        String c1_3 = getPECUStatus(dd_cCallPECU3_c1, dd_cComPECU3Ok_c1);
        data.put("c1_3",c1_3);
        Long dd_cCallPECU4_c1 = getValue("port0x123", "DD_CCallPECU4_C1");
        Long dd_cComPECU4Ok_c1 =getValue("port0x123", "DD_CComPECU4Ok_C1");
        String c1_4 = getPECUStatus(dd_cCallPECU4_c1, dd_cComPECU4Ok_c1);
        data.put("c1_4",c1_4);
        Long dd_cCallPECU5_c1 = getValue("port0x123", "DD_CCallPECU5_C1");
        Long dd_cComPECU5Ok_c1 =getValue("port0x123", "DD_CComPECU5Ok_C1");
        String c1_5 = getPECUStatus(dd_cCallPECU5_c1, dd_cComPECU5Ok_c1);
        data.put("c1_5",c1_5);
        return data;
    }
    private static Map createPECUC2() {
        Map<String,Object> data = new HashMap<>();
        Long dd_cCallPECU1_c2 = getValue("port0x123", "DD_CCallPECU1_C2");
        Long dd_cComPECU1Ok_c2 =getValue("port0x123", "DD_CComPECU1Ok_C2");
        String c2_1 = getPECUStatus(dd_cCallPECU1_c2, dd_cComPECU1Ok_c2);
        data.put("c2_1",c2_1);
        Long dd_cCallPECU2_c2 = getValue("port0x123", "DD_CCallPECU2_C2");
        Long dd_cComPECU2Ok_c2 =getValue("port0x123", "DD_CComPECU2Ok_C2");
        String c2_2 = getPECUStatus(dd_cCallPECU2_c2, dd_cComPECU2Ok_c2);
        data.put("c2_2",c2_2);
        Long dd_cCallPECU3_c2 = getValue("port0x123", "DD_CCallPECU3_C2");
        Long dd_cComPECU3Ok_c2 =getValue("port0x123", "DD_CComPECU3Ok_C2");
        String c2_3 = getPECUStatus(dd_cCallPECU3_c2, dd_cComPECU3Ok_c2);
        data.put("c2_3",c2_3);
        Long dd_cCallPECU4_c2 = getValue("port0x123", "DD_CCallPECU4_C2");
        Long dd_cComPECU4Ok_c2 =getValue("port0x123", "DD_CComPECU4Ok_C2");
        String c2_4 = getPECUStatus(dd_cCallPECU4_c2, dd_cComPECU4Ok_c2);
        data.put("c2_4",c2_4);
        Long dd_cCallPECU5_c2 = getValue("port0x123", "DD_CCallPECU5_C2");
        Long dd_cComPECU5Ok_c2 =getValue("port0x123", "DD_CComPECU5Ok_C2");
        String c2_5 = getPECUStatus(dd_cCallPECU5_c2, dd_cComPECU5Ok_c2);
        data.put("c2_5",c2_5);
        return data;
    }
    private static String getPECUStatus(Long dd_cCallPECU1, Long dd_cComPECU1Ok) {
        String s="";
        if(dd_cCallPECU1==0&&dd_cComPECU1Ok==0){
            s="inactive";
        }else if(dd_cCallPECU1==1&&dd_cComPECU1Ok==0){
            s="comm_requested";
        }else if(dd_cComPECU1Ok==1){
            s="comm_active";
        }/*else if(dd_cCallPECU1==1||dd_cComPECU1Ok==1){
            s="act_selected";
        }*/
        return s;
    }

    private static Map createPECUOP(){
        Map<String,Object> data=new HashMap<>();
        Long ipecuAck = getValue("port0x801", "_IPECUAck");
        data.put("ipecuAck",ipecuAck);
        Long ipecuReset = getValue("port0x801", "_IPECUReset");
        data.put("ipecuReset",ipecuReset);
        Long ipecuResetAll = getValue("port0x801", "_IPECUResetAll");
        data.put("ipecuResetAll",ipecuResetAll);
        Long ipecuSelectedCarNb = getValue("port0x800", "_IPECUSelectedCarNb");
        data.put("ipecuSelectedCarNb",ipecuSelectedCarNb);
        Long ipecuSelectedNb = getValue("port0x800", "_IPECUSelectedNb");
        data.put("ipecuSelectedNb",ipecuSelectedNb);

        return data;
    }
}
