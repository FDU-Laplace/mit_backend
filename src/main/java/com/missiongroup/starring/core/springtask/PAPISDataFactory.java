package com.missiongroup.starring.core.springtask;

import java.util.HashMap;
import java.util.Map;

public class PAPISDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map mode = createMode();
        data.put("mode",mode);
        Map stationInfo = createStationInfo();
        data.put("stationInfo",stationInfo);
        Map broadcast = createBroadcast();
        data.put("broadcast",broadcast);
        return data;
    }


    /**
     * Manual mode
     * @return
     */
    private static Map createMode(){
        Map data = new HashMap();
        Long ipbModeAuto = getValue("port0x801", "_IPBModeAuto");
        Long ipbModeManu = getValue("port0x801", "_IPBModeManu");
        Long ipbModeSemi = getValue("port0x801", "_IPBModeSemi");
        String mode="";
        if(ipbModeAuto==1){
            mode="auto";
        }else if(ipbModeManu==1){
            mode="manual";
        }else if(ipbModeSemi==1){
            mode="semi";
        }
        data.put("mode",mode);
        return data;
    }

    /**
     *Station Info
     * @return
     */
    private static Map createStationInfo(){
        Map data = new HashMap();
        Long mission_num = getValue("port0x800", "_IMissionNum");
        Long current_station = getValue("port0x121", "DD_CCurrentStation");
        Long next_station = getValue("port0x127", "DD_CNextStation");
        Long destination = getValue("port0x127", "DD_CFinalDestination");

        data.put("mission_num",mission_num);
        data.put("current_station",current_station);
        data.put("next_station",next_station);
        data.put("destination",destination);
        return data;
    }

    /**
     *
     * @return
     */
    private static Map createBroadcast(){
        Map data = new HashMap();
        Long iEmerMsgID = getValue("port0x802", "_IEmerMsgID");
        Long iEmerMsgInfinity = getValue("port0x801", "_IEmerMsgInfinity");
        Long iEmerMsgStop =getValue("port0x801", "_IEmerMsgStop");
        Long iEmerMsgonce = getValue("port0x801", "_IEmerMsgonce");


        data.put("iEmerMsgID",iEmerMsgID);
        data.put("iEmerMsgInfinity",iEmerMsgInfinity);
        data.put("iEmerMsgStop",iEmerMsgStop);
        data.put("iEmerMsgonce",iEmerMsgonce);
        return data;
    }
}
