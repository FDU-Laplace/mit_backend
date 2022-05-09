package com.missiongroup.starring.core.springtask;

import java.util.HashMap;
import java.util.Map;

public class EmergencyHandleDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map ehA1 = createEHA1();
        Map ehA2 = createEHA2();
        Map ehB1 = createEHB1();
        Map ehB2 = createEHB2();
        Map ehC1 = createEHC1();
        Map ehC2 = createEHC2();
        data.put("ehA1",ehA1);
        data.put("ehA2",ehA2);
        data.put("ehB1",ehB1);
        data.put("ehB2",ehB2);
        data.put("ehC1",ehC1);
        data.put("ehC2",ehC2);
        return data;
    }


    private static Map createEHA1() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_a1 = getValue("port0x122","DD_CDrsEmHand1_A1");
        Long dd_cDrsEmUnlockRqst1_a1 = getValue("port0x122","DD_CDrsEmUnlockRqst1_A1");
        Long dd_cDrsEmNotActv1_a1 = getValue("port0x123","DD_CDrsEmNotActv1_A1");
        Long dd_cDrsEmHand2_a1 = getValue("port0x122","DD_CDrsEmHand2_A1");
        Long dd_cDrsEmUnlockRqst2_a1 =getValue("port0x122","DD_CDrsEmUnlockRqst2_A1");
        Long dd_cDrsEmNotActv2_a1 = getValue("port0x123","DD_CDrsEmNotActv2_A1");
        Long dd_cDrsEmHand3_a1 =getValue("port0x122","DD_CDrsEmHand3_A1");
        Long dd_cDrsEmUnlockRqst3_a1 = getValue("port0x124","DD_CDrsEmUnlockRqst3_A1");
        Long dd_cDrsEmNotActv3_a1 = getValue("port0x123","DD_CDrsEmNotActv3_A1");
        Long dd_cDrsEmHand4_a1 = getValue("port0x122","DD_CDrsEmHand4_A1");
        Long dd_cDrsEmUnlockRqst4_a1 = getValue("port0x124","DD_CDrsEmUnlockRqst4_A1");
        Long dd_cDrsEmNotActv4_a1 = getValue("port0x123","DD_CDrsEmNotActv4_A1");
        Long dd_cDrsEmHand5_a1 = getValue("port0x122","DD_CDrsEmHand5_A1");
        Long dd_cDrsEmUnlockRqst5_a1 = getValue("port0x124","DD_CDrsEmUnlockRqst5_A1");
        Long dd_cDrsEmNotActv5_a1 = getValue("port0x123","DD_CDrsEmNotActv5_A1");
        Long dd_cDrsEmHand6_a1 = getValue("port0x122","DD_CDrsEmHand6_A1");
        Long dd_cDrsEmUnlockRqst6_a1 = getValue("port0x124","DD_CDrsEmUnlockRqst6_A1");
        Long dd_cDrsEmNotActv6_a1 = getValue("port0x123","DD_CDrsEmNotActv6_A1");
        Long dd_cDrsEmHand7_a1 = getValue("port0x122","DD_CDrsEmHand7_A1");
        Long dd_cDrsEmUnlockRqst7_a1 = getValue("port0x124","DD_CDrsEmUnlockRqst7_A1");
        Long dd_cDrsEmNotActv7_a1 = getValue("port0x123","DD_CDrsEmNotActv7_A1");
        Long dd_cDrsEmHand8_a1 = getValue("port0x122","DD_CDrsEmHand8_A1");
        Long dd_cDrsEmUnlockRqst8_a1 =getValue("port0x125","DD_CDrsEmUnlockRqst8_A1");
        Long dd_cDrsEmNotActv8_a1 = getValue("port0x123","DD_CDrsEmNotActv8_A1");
        String EH1_a1 = getEhStatus(dd_cDrsEmHand1_a1, dd_cDrsEmUnlockRqst1_a1, dd_cDrsEmNotActv1_a1);
        String EH2_a1 = getEhStatus(dd_cDrsEmHand2_a1, dd_cDrsEmUnlockRqst2_a1, dd_cDrsEmNotActv2_a1);
        String EH3_a1 = getEhStatus(dd_cDrsEmHand3_a1, dd_cDrsEmUnlockRqst3_a1, dd_cDrsEmNotActv3_a1);
        String EH4_a1 = getEhStatus(dd_cDrsEmHand4_a1, dd_cDrsEmUnlockRqst4_a1, dd_cDrsEmNotActv4_a1);
        String EH5_a1 = getEhStatus(dd_cDrsEmHand5_a1, dd_cDrsEmUnlockRqst5_a1, dd_cDrsEmNotActv5_a1);
        String EH6_a1 = getEhStatus(dd_cDrsEmHand6_a1, dd_cDrsEmUnlockRqst6_a1, dd_cDrsEmNotActv6_a1);
        String EH7_a1 = getEhStatus(dd_cDrsEmHand7_a1, dd_cDrsEmUnlockRqst7_a1, dd_cDrsEmNotActv7_a1);
        String EH8_a1 = getEhStatus(dd_cDrsEmHand8_a1, dd_cDrsEmUnlockRqst8_a1, dd_cDrsEmNotActv8_a1);
        data.put("EH1_a1",EH1_a1);
        data.put("EH2_a1",EH2_a1);
        data.put("EH3_a1",EH3_a1);
        data.put("EH4_a1",EH4_a1);
        data.put("EH5_a1",EH5_a1);
        data.put("EH6_a1",EH6_a1);
        data.put("EH7_a1",EH7_a1);
        data.put("EH8_a1",EH8_a1);

        return data;
    }

    private static Map createEHA2() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_a2 = getValue("port0x122","DD_CDrsEmHand1_A2");
        Long dd_cDrsEmUnlockRqst1_a2 =  getValue("port0x122","DD_CDrsEmUnlockRqst1_A2");
        Long dd_cDrsEmNotActv1_a2 =  getValue("port0x123","DD_CDrsEmNotActv1_A2");
        Long dd_cDrsEmHand2_a2 = getValue("port0x122","DD_CDrsEmHand2_A2");
        Long dd_cDrsEmUnlockRqst2_a2 =getValue("port0x122","DD_CDrsEmUnlockRqst2_A2");
        Long dd_cDrsEmNotActv2_a2  = getValue("port0x123","DD_CDrsEmNotActv2_A2");
        Long dd_cDrsEmHand3_a2 =getValue("port0x122","DD_CDrsEmHand3_A2");
        Long dd_cDrsEmUnlockRqst3_a2  = getValue("port0x127","DD_CDrsEmUnlockRqst3_A2");
        Long dd_cDrsEmNotActv3_a2  = getValue("port0x123","DD_CDrsEmNotActv3_A2");
        Long dd_cDrsEmHand4_a2  = getValue("port0x122","DD_CDrsEmHand4_A2");
        Long dd_cDrsEmUnlockRqst4_a2  = getValue("port0x127","DD_CDrsEmUnlockRqst4_A2");
        Long dd_cDrsEmNotActv4_a2  = getValue("port0x123","DD_CDrsEmNotActv4_A2");
        Long dd_cDrsEmHand5_a2 = getValue("port0x122","DD_CDrsEmHand5_A2");
        Long dd_cDrsEmUnlockRqst5_a2  = getValue("port0x127","DD_CDrsEmUnlockRqst5_A2");
        Long dd_cDrsEmNotActv5_a2  = getValue("port0x123","DD_CDrsEmNotActv5_A2");
        Long dd_cDrsEmHand6_a2  = getValue("port0x122","DD_CDrsEmHand6_A2");
        Long dd_cDrsEmUnlockRqst6_a2= getValue("port0x127","DD_CDrsEmUnlockRqst6_A2");
        Long dd_cDrsEmNotActv6_a2  = getValue("port0x123","DD_CDrsEmNotActv6_A2");
        Long dd_cDrsEmHand7_a2  = getValue("port0x122","DD_CDrsEmHand7_A2");
        Long dd_cDrsEmUnlockRqst7_a2  = getValue("port0x127","DD_CDrsEmUnlockRqst7_A2");
        Long dd_cDrsEmNotActv7_a2  = getValue("port0x123","DD_CDrsEmNotActv7_A2");
        Long dd_cDrsEmHand8_a2= getValue("port0x122","DD_CDrsEmHand8_A2");
        Long dd_cDrsEmUnlockRqst8_a2  =getValue("port0x127","DD_CDrsEmUnlockRqst8_A2");
        Long dd_cDrsEmNotActv8_a2= getValue("port0x123","DD_CDrsEmNotActv8_A2");
        String EH1_a2 = getEhStatus(dd_cDrsEmHand1_a2, dd_cDrsEmUnlockRqst1_a2, dd_cDrsEmNotActv1_a2);
        String EH2_a2 = getEhStatus(dd_cDrsEmHand2_a2, dd_cDrsEmUnlockRqst2_a2, dd_cDrsEmNotActv2_a2);
        String EH3_a2 = getEhStatus(dd_cDrsEmHand3_a2, dd_cDrsEmUnlockRqst3_a2, dd_cDrsEmNotActv3_a2);
        String EH4_a2 = getEhStatus(dd_cDrsEmHand4_a2, dd_cDrsEmUnlockRqst4_a2, dd_cDrsEmNotActv4_a2);
        String EH5_a2 = getEhStatus(dd_cDrsEmHand5_a2, dd_cDrsEmUnlockRqst5_a2, dd_cDrsEmNotActv5_a2);
        String EH6_a2 = getEhStatus(dd_cDrsEmHand6_a2, dd_cDrsEmUnlockRqst6_a2, dd_cDrsEmNotActv6_a2);
        String EH7_a2 = getEhStatus(dd_cDrsEmHand7_a2, dd_cDrsEmUnlockRqst7_a2, dd_cDrsEmNotActv7_a2);
        String EH8_a2 = getEhStatus(dd_cDrsEmHand8_a2, dd_cDrsEmUnlockRqst8_a2, dd_cDrsEmNotActv8_a2);
        data.put("EH1_a2",EH1_a2);
        data.put("EH2_a2",EH2_a2);
        data.put("EH3_a2",EH3_a2);
        data.put("EH4_a2",EH4_a2);
        data.put("EH5_a2",EH5_a2);
        data.put("EH6_a2",EH6_a2);
        data.put("EH7_a2",EH7_a2);
        data.put("EH8_a2",EH8_a2);

        return data;
    }

    private static Map createEHB1() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_b1 = getValue("port0x122","DD_CDrsEmHand1_B1");
        Long dd_cDrsEmUnlockRqst1_b1 =  getValue("port0x122","DD_CDrsEmUnlockRqst1_B1");
        Long dd_cDrsEmNotActv1_b1 =  getValue("port0x123","DD_CDrsEmNotActv1_B1");
        
        Long dd_cDrsEmHand2_b1 = getValue("port0x122","DD_CDrsEmHand2_B1");
        Long dd_cDrsEmUnlockRqst2_b1 =getValue("port0x122","DD_CDrsEmUnlockRqst2_B1");
        Long dd_cDrsEmNotActv2_b1  = getValue("port0x123","DD_CDrsEmNotActv2_B1");
        
        Long dd_cDrsEmHand3_b1 =getValue("port0x122","DD_CDrsEmHand3_B1");
        Long dd_cDrsEmUnlockRqst3_b1  = getValue("port0x125","DD_CDrsEmUnlockRqst3_B1");
        Long dd_cDrsEmNotActv3_b1  = getValue("port0x123","DD_CDrsEmNotActv3_B1");
        
        Long dd_cDrsEmHand4_b1  = getValue("port0x122","DD_CDrsEmHand4_B1");
        Long dd_cDrsEmUnlockRqst4_b1  = getValue("port0x125","DD_CDrsEmUnlockRqst4_B1");
        Long dd_cDrsEmNotActv4_b1  = getValue("port0x123","DD_CDrsEmNotActv4_B1");
        
        Long dd_cDrsEmHand5_b1 = getValue("port0x122","DD_CDrsEmHand5_B1");
        Long dd_cDrsEmUnlockRqst5_b1  = getValue("port0x125","DD_CDrsEmUnlockRqst5_B1");
        Long dd_cDrsEmNotActv5_b1  = getValue("port0x123","DD_CDrsEmNotActv5_B1");
        
        Long dd_cDrsEmHand6_b1  = getValue("port0x122","DD_CDrsEmHand6_B1");
        Long dd_cDrsEmUnlockRqst6_b1= getValue("port0x125","DD_CDrsEmUnlockRqst6_B1");
        Long dd_cDrsEmNotActv6_b1  = getValue("port0x123","DD_CDrsEmNotActv6_B1");
        
        Long dd_cDrsEmHand7_b1  = getValue("port0x122","DD_CDrsEmHand7_B1");
        Long dd_cDrsEmUnlockRqst7_b1  = getValue("port0x126","DD_CDrsEmUnlockRqst7_B1");
        Long dd_cDrsEmNotActv7_b1  = getValue("port0x123","DD_CDrsEmNotActv7_B1");
        
        Long dd_cDrsEmHand8_b1= getValue("port0x122","DD_CDrsEmHand8_B1");
        Long dd_cDrsEmUnlockRqst8_b1  =getValue("port0x126","DD_CDrsEmUnlockRqst8_B1");
        Long dd_cDrsEmNotActv8_b1= getValue("port0x123","DD_CDrsEmNotActv8_B1");
        
        
        String EH1_b1 = getEhStatus(dd_cDrsEmHand1_b1, dd_cDrsEmUnlockRqst1_b1, dd_cDrsEmNotActv1_b1);
        String EH2_b1 = getEhStatus(dd_cDrsEmHand2_b1, dd_cDrsEmUnlockRqst2_b1, dd_cDrsEmNotActv2_b1);
        String EH3_b1 = getEhStatus(dd_cDrsEmHand3_b1, dd_cDrsEmUnlockRqst3_b1, dd_cDrsEmNotActv3_b1);
        String EH4_b1 = getEhStatus(dd_cDrsEmHand4_b1, dd_cDrsEmUnlockRqst4_b1, dd_cDrsEmNotActv4_b1);
        String EH5_b1 = getEhStatus(dd_cDrsEmHand5_b1, dd_cDrsEmUnlockRqst5_b1, dd_cDrsEmNotActv5_b1);
        String EH6_b1 = getEhStatus(dd_cDrsEmHand6_b1, dd_cDrsEmUnlockRqst6_b1, dd_cDrsEmNotActv6_b1);
        String EH7_b1 = getEhStatus(dd_cDrsEmHand7_b1, dd_cDrsEmUnlockRqst7_b1, dd_cDrsEmNotActv7_b1);
        String EH8_b1 = getEhStatus(dd_cDrsEmHand8_b1, dd_cDrsEmUnlockRqst8_b1, dd_cDrsEmNotActv8_b1);
        data.put("EH1_b1",EH1_b1);
        data.put("EH2_b1",EH2_b1);
        data.put("EH3_b1",EH3_b1);
        data.put("EH4_b1",EH4_b1);
        data.put("EH5_b1",EH5_b1);
        data.put("EH6_b1",EH6_b1);
        data.put("EH7_b1",EH7_b1);
        data.put("EH8_b1",EH8_b1);

        return data;
    }

    private static Map createEHB2() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_b2 = getValue("port0x122","DD_CDrsEmHand1_B2");
        Long dd_cDrsEmUnlockRqst1_b2 =  getValue("port0x122","DD_CDrsEmUnlockRqst1_B2");
        Long dd_cDrsEmNotActv1_b2 =  getValue("port0x123","DD_CDrsEmNotActv1_B2");

        Long dd_cDrsEmHand2_b2 = getValue("port0x122","DD_CDrsEmHand2_B2");
        Long dd_cDrsEmUnlockRqst2_b2 =getValue("port0x122","DD_CDrsEmUnlockRqst2_B2");
        Long dd_cDrsEmNotActv2_b2  = getValue("port0x123","DD_CDrsEmNotActv2_B2");

        Long dd_cDrsEmHand3_b2 =getValue("port0x122","DD_CDrsEmHand3_B2");
        Long dd_cDrsEmUnlockRqst3_b2  = getValue("port0x127","DD_CDrsEmUnlockRqst3_B2");
        Long dd_cDrsEmNotActv3_b2  = getValue("port0x123","DD_CDrsEmNotActv3_B2");

        Long dd_cDrsEmHand4_b2  = getValue("port0x122","DD_CDrsEmHand4_B2");
        Long dd_cDrsEmUnlockRqst4_b2  = getValue("port0x127","DD_CDrsEmUnlockRqst4_B2");
        Long dd_cDrsEmNotActv4_b2  = getValue("port0x123","DD_CDrsEmNotActv4_B2");

        Long dd_cDrsEmHand5_b2 = getValue("port0x122","DD_CDrsEmHand5_B2");
        Long dd_cDrsEmUnlockRqst5_b2  = getValue("port0x127","DD_CDrsEmUnlockRqst5_B2");
        Long dd_cDrsEmNotActv5_b2  = getValue("port0x123","DD_CDrsEmNotActv5_B2");

        Long dd_cDrsEmHand6_b2  = getValue("port0x122","DD_CDrsEmHand6_B2");
        Long dd_cDrsEmUnlockRqst6_b2= getValue("port0x127","DD_CDrsEmUnlockRqst6_B2");
        Long dd_cDrsEmNotActv6_b2  = getValue("port0x123","DD_CDrsEmNotActv6_B2");

        Long dd_cDrsEmHand7_b2  = getValue("port0x122","DD_CDrsEmHand7_B2");
        Long dd_cDrsEmUnlockRqst7_b2  = getValue("port0x127","DD_CDrsEmUnlockRqst7_B2");
        Long dd_cDrsEmNotActv7_b2  = getValue("port0x123","DD_CDrsEmNotActv7_B2");

        Long dd_cDrsEmHand8_b2= getValue("port0x122","DD_CDrsEmHand8_B2");
        Long dd_cDrsEmUnlockRqst8_b2  =getValue("port0x127","DD_CDrsEmUnlockRqst8_B2");
        Long dd_cDrsEmNotActv8_b2= getValue("port0x123","DD_CDrsEmNotActv8_B2");
        
        String EH1_b2 = getEhStatus(dd_cDrsEmHand1_b2, dd_cDrsEmUnlockRqst1_b2, dd_cDrsEmNotActv1_b2);
        String EH2_b2 = getEhStatus(dd_cDrsEmHand2_b2, dd_cDrsEmUnlockRqst2_b2, dd_cDrsEmNotActv2_b2);
        String EH3_b2 = getEhStatus(dd_cDrsEmHand3_b2, dd_cDrsEmUnlockRqst3_b2, dd_cDrsEmNotActv3_b2);
        String EH4_b2 = getEhStatus(dd_cDrsEmHand4_b2, dd_cDrsEmUnlockRqst4_b2, dd_cDrsEmNotActv4_b2);
        String EH5_b2 = getEhStatus(dd_cDrsEmHand5_b2, dd_cDrsEmUnlockRqst5_b2, dd_cDrsEmNotActv5_b2);
        String EH6_b2 = getEhStatus(dd_cDrsEmHand6_b2, dd_cDrsEmUnlockRqst6_b2, dd_cDrsEmNotActv6_b2);
        String EH7_b2 = getEhStatus(dd_cDrsEmHand7_b2, dd_cDrsEmUnlockRqst7_b2, dd_cDrsEmNotActv7_b2);
        String EH8_b2 = getEhStatus(dd_cDrsEmHand8_b2, dd_cDrsEmUnlockRqst8_b2, dd_cDrsEmNotActv8_b2);
        data.put("EH1_b2",EH1_b2);
        data.put("EH2_b2",EH2_b2);
        data.put("EH3_b2",EH3_b2);
        data.put("EH4_b2",EH4_b2);
        data.put("EH5_b2",EH5_b2);
        data.put("EH6_b2",EH6_b2);
        data.put("EH7_b2",EH7_b2);
        data.put("EH8_b2",EH8_b2);

        return data;
    }

    private static Map createEHC1() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_c1 = getValue("port0x122","DD_CDrsEmHand1_C1");
        Long dd_cDrsEmUnlockRqst1_c1 =  getValue("port0x122","DD_CDrsEmUnlockRqst1_C1");
        Long dd_cDrsEmNotActv1_c1 =  getValue("port0x123","DD_CDrsEmNotActv1_C1");

        Long dd_cDrsEmHand2_c1 = getValue("port0x122","DD_CDrsEmHand2_C1");
        Long dd_cDrsEmUnlockRqst2_c1 =getValue("port0x122","DD_CDrsEmUnlockRqst2_C1");
        Long dd_cDrsEmNotActv2_c1  = getValue("port0x123","DD_CDrsEmNotActv2_C1");

        Long dd_cDrsEmHand3_c1 =getValue("port0x122","DD_CDrsEmHand3_C1");
        Long dd_cDrsEmUnlockRqst3_c1  = getValue("port0x126","DD_CDrsEmUnlockRqst3_C1");
        Long dd_cDrsEmNotActv3_c1  = getValue("port0x123","DD_CDrsEmNotActv3_C1");

        Long dd_cDrsEmHand4_c1  = getValue("port0x122","DD_CDrsEmHand4_C1");
        Long dd_cDrsEmUnlockRqst4_c1  = getValue("port0x126","DD_CDrsEmUnlockRqst4_C1");
        Long dd_cDrsEmNotActv4_c1  = getValue("port0x123","DD_CDrsEmNotActv4_C1");

        Long dd_cDrsEmHand5_c1 = getValue("port0x122","DD_CDrsEmHand5_C1");
        Long dd_cDrsEmUnlockRqst5_c1  = getValue("port0x126","DD_CDrsEmUnlockRqst5_C1");
        Long dd_cDrsEmNotActv5_c1  = getValue("port0x123","DD_CDrsEmNotActv5_C1");

        Long dd_cDrsEmHand6_c1  = getValue("port0x122","DD_CDrsEmHand6_C1");
        Long dd_cDrsEmUnlockRqst6_c1= getValue("port0x126","DD_CDrsEmUnlockRqst6_C1");
        Long dd_cDrsEmNotActv6_c1  = getValue("port0x123","DD_CDrsEmNotActv6_C1");

        Long dd_cDrsEmHand7_c1  = getValue("port0x122","DD_CDrsEmHand7_C1");
        Long dd_cDrsEmUnlockRqst7_c1  = getValue("port0x126","DD_CDrsEmUnlockRqst7_C1");
        Long dd_cDrsEmNotActv7_c1  = getValue("port0x123","DD_CDrsEmNotActv7_C1");

        Long dd_cDrsEmHand8_c1= getValue("port0x122","DD_CDrsEmHand8_C1");
        Long dd_cDrsEmUnlockRqst8_c1  =getValue("port0x126","DD_CDrsEmUnlockRqst8_C1");
        Long dd_cDrsEmNotActv8_c1= getValue("port0x123","DD_CDrsEmNotActv8_C1");
        
        String EH1_c1 = getEhStatus(dd_cDrsEmHand1_c1, dd_cDrsEmUnlockRqst1_c1, dd_cDrsEmNotActv1_c1);
        String EH2_c1 = getEhStatus(dd_cDrsEmHand2_c1, dd_cDrsEmUnlockRqst2_c1, dd_cDrsEmNotActv2_c1);
        String EH3_c1 = getEhStatus(dd_cDrsEmHand3_c1, dd_cDrsEmUnlockRqst3_c1, dd_cDrsEmNotActv3_c1);
        String EH4_c1 = getEhStatus(dd_cDrsEmHand4_c1, dd_cDrsEmUnlockRqst4_c1, dd_cDrsEmNotActv4_c1);
        String EH5_c1 = getEhStatus(dd_cDrsEmHand5_c1, dd_cDrsEmUnlockRqst5_c1, dd_cDrsEmNotActv5_c1);
        String EH6_c1 = getEhStatus(dd_cDrsEmHand6_c1, dd_cDrsEmUnlockRqst6_c1, dd_cDrsEmNotActv6_c1);
        String EH7_c1 = getEhStatus(dd_cDrsEmHand7_c1, dd_cDrsEmUnlockRqst7_c1, dd_cDrsEmNotActv7_c1);
        String EH8_c1 = getEhStatus(dd_cDrsEmHand8_c1, dd_cDrsEmUnlockRqst8_c1, dd_cDrsEmNotActv8_c1);
        data.put("EH1_c1",EH1_c1);
        data.put("EH2_c1",EH2_c1);
        data.put("EH3_c1",EH3_c1);
        data.put("EH4_c1",EH4_c1);
        data.put("EH5_c1",EH5_c1);
        data.put("EH6_c1",EH6_c1);
        data.put("EH7_c1",EH7_c1);
        data.put("EH8_c1",EH8_c1);

        return data;
    }

    private static Map createEHC2() {
        Map data = new HashMap();
        Long dd_cDrsEmHand1_c2 = getValue("port0x122","DD_CDrsEmHand1_C2");
        Long dd_cDrsEmUnlockRqst1_c2 =  getValue("port0x122","DD_CDrsEmUnlockRqst1_C2");
        Long dd_cDrsEmNotActv1_c2 =  getValue("port0x123","DD_CDrsEmNotActv1_C2");

        Long dd_cDrsEmHand2_c2 = getValue("port0x122","DD_CDrsEmHand2_C2");
        Long dd_cDrsEmUnlockRqst2_c2 =getValue("port0x122","DD_CDrsEmUnlockRqst2_C2");
        Long dd_cDrsEmNotActv2_c2  = getValue("port0x123","DD_CDrsEmNotActv2_C2");

        Long dd_cDrsEmHand3_c2 =getValue("port0x122","DD_CDrsEmHand3_C2");
        Long dd_cDrsEmUnlockRqst3_c2  = getValue("port0x126","DD_CDrsEmUnlockRqst3_C2");
        Long dd_cDrsEmNotActv3_c2  = getValue("port0x123","DD_CDrsEmNotActv3_C2");

        Long dd_cDrsEmHand4_c2  = getValue("port0x122","DD_CDrsEmHand4_C2");
        Long dd_cDrsEmUnlockRqst4_c2  = getValue("port0x126","DD_CDrsEmUnlockRqst4_C2");
        Long dd_cDrsEmNotActv4_c2  = getValue("port0x123","DD_CDrsEmNotActv4_C2");

        Long dd_cDrsEmHand5_c2 = getValue("port0x122","DD_CDrsEmHand5_C2");
        Long dd_cDrsEmUnlockRqst5_c2  = getValue("port0x126","DD_CDrsEmUnlockRqst5_C2");
        Long dd_cDrsEmNotActv5_c2  = getValue("port0x123","DD_CDrsEmNotActv5_C2");

        Long dd_cDrsEmHand6_c2  = getValue("port0x122","DD_CDrsEmHand6_C2");
        Long dd_cDrsEmUnlockRqst6_c2= getValue("port0x126","DD_CDrsEmUnlockRqst6_C2");
        Long dd_cDrsEmNotActv6_c2  = getValue("port0x123","DD_CDrsEmNotActv6_C2");

        Long dd_cDrsEmHand7_c2  = getValue("port0x122","DD_CDrsEmHand7_C2");
        Long dd_cDrsEmUnlockRqst7_c2  = getValue("port0x127","DD_CDrsEmUnlockRqst7_C2");
        Long dd_cDrsEmNotActv7_c2  = getValue("port0x123","DD_CDrsEmNotActv7_C2");

        Long dd_cDrsEmHand8_c2= getValue("port0x122","DD_CDrsEmHand8_C2");
        Long dd_cDrsEmUnlockRqst8_c2  =getValue("port0x127","DD_CDrsEmUnlockRqst8_C2");
        Long dd_cDrsEmNotActv8_c2= getValue("port0x123","DD_CDrsEmNotActv8_C2");

        String EH1_c2 = getEhStatus(dd_cDrsEmHand1_c2, dd_cDrsEmUnlockRqst1_c2, dd_cDrsEmNotActv1_c2);
        String EH2_c2 = getEhStatus(dd_cDrsEmHand2_c2, dd_cDrsEmUnlockRqst2_c2, dd_cDrsEmNotActv2_c2);
        String EH3_c2 = getEhStatus(dd_cDrsEmHand3_c2, dd_cDrsEmUnlockRqst3_c2, dd_cDrsEmNotActv3_c2);
        String EH4_c2 = getEhStatus(dd_cDrsEmHand4_c2, dd_cDrsEmUnlockRqst4_c2, dd_cDrsEmNotActv4_c2);
        String EH5_c2 = getEhStatus(dd_cDrsEmHand5_c2, dd_cDrsEmUnlockRqst5_c2, dd_cDrsEmNotActv5_c2);
        String EH6_c2 = getEhStatus(dd_cDrsEmHand6_c2, dd_cDrsEmUnlockRqst6_c2, dd_cDrsEmNotActv6_c2);
        String EH7_c2 = getEhStatus(dd_cDrsEmHand7_c2, dd_cDrsEmUnlockRqst7_c2, dd_cDrsEmNotActv7_c2);
        String EH8_c2 = getEhStatus(dd_cDrsEmHand8_c2, dd_cDrsEmUnlockRqst8_c2, dd_cDrsEmNotActv8_c2);
        data.put("EH1_c2",EH1_c2);
        data.put("EH2_c2",EH2_c2);
        data.put("EH3_c2",EH3_c2);
        data.put("EH4_c2",EH4_c2);
        data.put("EH5_c2",EH5_c2);
        data.put("EH6_c2",EH6_c2);
        data.put("EH7_c2",EH7_c2);
        data.put("EH8_c2",EH8_c2);

        return data;
    }

    private static String getEhStatus(Long dd_cDrsEmHand, Long dd_cDrsEmUnlockRqst, Long dd_cDrsEmNotActv) {
        String EH="";
        if(dd_cDrsEmHand ==1&& dd_cDrsEmUnlockRqst ==0&&dd_cDrsEmNotActv==0){
            EH="unlocked";
        }else if(dd_cDrsEmNotActv==1){
            EH="activated";
        }else if(dd_cDrsEmHand ==0&& dd_cDrsEmUnlockRqst ==1&&dd_cDrsEmNotActv==0){
            EH="request";
        }
        return EH;
    }
}
