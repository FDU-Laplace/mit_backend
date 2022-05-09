package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class ATCDataFactory extends DatatFactory{
    public static Map createData() {
        Map data = new HashMap();
        Map ventilationSubModes = createVentilationSubModes();
        data.put("ventilationSubModes",ventilationSubModes);
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
        Long dd_catcFlt = getValue("port0x120","DD_CATCFlt");
        Long dd_catc1NOK = getValue("port0x120","DD_CATC1NOK");
        Long dd_catc1Master = getValue("port0x126","DD_CATC1Master");
        Long dd_cnatc1Isol = getValue("port0x120","DD_CNATC1Isol");
        String ATC1 = getAtcStatus(dd_catcFlt, dd_catc1NOK, dd_catc1Master, dd_cnatc1Isol);
        data.put("ATC1", ATC1);


        Long dd_catc2NOK = getValue("port0x120","DD_CATC2NOK");
        Long dd_catc2Master = getValue("port0x126","DD_CATC2Master");
        Long dd_cnatc2Isol = getValue("port0x120","DD_CNATC2Isol");
        String ATC2 = getAtcStatus(dd_catcFlt, dd_catc2NOK, dd_catc2Master, dd_cnatc2Isol);
        data.put("ATC2", ATC2);

        return data;
    }

    private static String getAtcStatus(Long dd_catcFlt, Long dd_catc1NOK, Long dd_catc1Master, Long dd_cnatc1Isol) {
        String ATC = "";
        if (dd_catc1NOK == 1 && dd_catc1Master == 1) {
            ATC = "Active";
        } else if (dd_catc1NOK == 0 || dd_catcFlt == 0) {
            ATC = "ATC_communication_not_ok";
        } else if (dd_catc1NOK == 1 || dd_catc1Master == 0) {
            ATC = "ATC communication_ok_and_not_communicating_with_TCMS";
        } else if (dd_cnatc1Isol == 0) {
            ATC = "isolated";
        } else {
            ATC = "unknown";
        }
        return ATC;
    }

}
