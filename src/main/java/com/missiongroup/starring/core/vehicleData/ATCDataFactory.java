package com.missiongroup.starring.core.vehicleData;


import java.util.HashMap;
import java.util.Map;

public class ATCDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map ventilationSubModes = createVentilationSubModes();
        data.put("ventilationSubModes", ventilationSubModes);
        return data;
    }

    /**
     * Ventilation Sub-Modes
     */
    private static Map createVentilationSubModes() {
        Map<String, Object> data = new HashMap<>();
        Long dd_catc1Flt = getValue("port0x120", "DD_CATC1Flt");
        Long dd_catc1NOK = getValue("port0x120", "DD_CATC1NOK");
        Long dd_catc1OK = getValue("port0x120", "DD_CATC1OK");
        Long dd_catc1Master = getValue("port0x126", "DD_CATC1Master");
        Long dd_cnatc1Isol = getValue("port0x120", "DD_CNATC1Isol");
        Long dd_atcIsol = getValue("port0x120", "DD_CATCIsol");

        String ATC1 = getAtcStatus(dd_catc1Flt, dd_catc1OK, dd_catc1Master, dd_cnatc1Isol,dd_atcIsol);
        data.put("ATC1", ATC1);
        Long dd_catc2Flt = getValue("port0x120", "DD_CATC2Flt");
        Long dd_catc2NOK = getValue("port0x120", "DD_CATC2NOK");
        Long dd_catc2OK = getValue("port0x120", "DD_CATC2OK");
        Long dd_catc2Master = getValue("port0x126", "DD_CATC2Master");
        Long dd_cnatc2Isol = getValue("port0x120", "DD_CNATC2Isol");
        String ATC2 = getAtcStatus(dd_catc2Flt, dd_catc2OK, dd_catc2Master, dd_cnatc2Isol,dd_atcIsol);
        data.put("ATC2", ATC2);

        return data;
    }
//todo
    private static String getAtcStatus(Long dd_catcFlt, Long dd_catc1OK, Long dd_catc1Master, Long dd_cnatc1Isol,Long dd_atcIsol) {
        String ATC;
        if(dd_atcIsol == 1L && dd_cnatc1Isol == 0L){
            ATC = "isolated";
        }
        else if (dd_catcFlt == 1) {
            ATC = "ATC_communication_not_ok";
        }
        else if (dd_catc1OK == 1 && dd_catc1Master == 0) {
            ATC = "ATC communication_ok_and_not_communicating_with_TCMS";
        }
        else if (dd_catc1OK == 1 && dd_catc1Master == 1) {
            ATC = "Active";
        }  else {
            ATC = "unknown";
        }
        return ATC;
    }

}
