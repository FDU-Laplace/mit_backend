package com.missiongroup.starring.core.springtask;


import com.missiongroup.starring.core.cache.service.PortModel;

import java.util.HashMap;
import java.util.Map;

public class DatatFactory {
    public static Map dataAll;
    public DatatFactory() {}

    public DatatFactory(Map dataAll) {
        this.dataAll=dataAll;
        /*Iterator iterator = dataAll.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map> next = (Map.Entry<String, Map>) iterator.next();
            Map<String, PortModel> value = next.getValue();
            for (Map.Entry<String, PortModel> entry : value.entrySet()) {
                this.dataAll.put(entry.getKey(),entry.getValue().getValue());
            }
        }*/
    }

    public static Long getValue(String portName ,String propertyName){
       Map data = (Map)dataAll.get(portName);
        PortModel portModel = (PortModel)data.get(propertyName);
        Long value =  portModel.getValue();
        return value;
    }
    public Map createTotalData(){
        Map totalData=new HashMap();
        //common
        Map head = CommonDataFactory.createData();
        totalData.put("top",head);
        //maintainability
        Map maintainability = MainTrainSynopticDataFactory.createData();
        totalData.put("MainTrainSynoptic",maintainability);
        //preparationScreen
        Map preparationScreen = PreparationScreenDataFactory.createData();
        totalData.put("preparationScreen",preparationScreen);
        //Operation
        Map Operation = OperationDataFactory.createData();
        totalData.put("Operation",Operation);
        //HV
        Map hv = HVDataFactory.createData();
        totalData.put("hv",hv);
        //HVAC
        Map HVAC = HVACDataFactory.createData();
        totalData.put("HVAC",HVAC);
        //ATC
        Map atc = ATCDataFactory.createData();
        totalData.put("atc",atc);
        //papis
        Map papis = PAPISDataFactory.createData();
        totalData.put("papis",papis);
        //bmsdata
        Map bmsdata = BMSDataFactory.createData();
        totalData.put("bmsdata",bmsdata);
        //BypassSwith
        Map bypassswith = BypassSwithDataFactory.createData();
        totalData.put("bypassswith",bypassswith);
        //PECU
        Map pecu = PECUDataFactory.createData();
        totalData.put("pecu",pecu);
        //FSD
        Map FSD = FSDDataFactory.createData();
        totalData.put("FSD",FSD);
        //EB
        Map EB = EBDataFactory.createData();
        totalData.put("EB",EB);
        //EmergencyHandle
        Map emergencyhandle = EmergencyHandleDataFactory.createData();
        totalData.put("emergencyhandle",emergencyhandle);
        //IOS
        Map IOS = IOSDataFactory.createData();
        totalData.put("IOS",IOS);
        //HAVCFault
        Map HAVCFault = HAVCFaultDataFactory.createData();
        totalData.put("HAVCFault",HAVCFault);
        //coverStatus
        Map coverStatus = CoverStatusDataFactory.createData();
        totalData.put("coverStatus",coverStatus);
        //CB
        Map cb = CBDataFactory.createData();
        totalData.put("CB",cb);
        return totalData;
    }
}
