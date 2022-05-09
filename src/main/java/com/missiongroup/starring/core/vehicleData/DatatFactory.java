package com.missiongroup.starring.core.vehicleData;


import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.modular.vhis.config.service.impl.FaultConfigServiceImpl;
import com.missiongroup.starring.modular.vhis.fault.service.impl.FaultHistoryServiceImpl;
import com.missiongroup.starring.modular.vhis.fault.service.impl.FaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class DatatFactory {
    static Map dataAll;
    //private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    static FaultServiceImpl faultService = SpringContextHolder.getBean(FaultServiceImpl.class);
    static FaultHistoryServiceImpl faultHistoryService = SpringContextHolder.getBean(FaultHistoryServiceImpl.class);
    static FaultConfigServiceImpl faultConfigService = SpringContextHolder.getBean(FaultConfigServiceImpl.class);
    static ICache iCaches = SpringContextHolder.getBean(ICache.class);

    public DatatFactory() {
    }


    public DatatFactory(Map dataAll) {
        DatatFactory.dataAll = dataAll;
        /*Iterator iterator = dataAll.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map> next = (Map.Entry<String, Map>) iterator.next();
            Map<String, PortModel> value = next.getValue();
            for (Map.Entry<String, PortModel> entry : value.entrySet()) {
                this.dataAll.put(entry.getKey(),entry.getValue().getValue());
            }
        }*/
    }

    public static Long getValue(String portName, String propertyName) {
        Map data = (Map) dataAll.get(portName);
        if (data == null) {
            return 0l;
        }
        PortModel portModel = (PortModel) data.get(propertyName);
        return portModel.getValue();
    }

    public Map createTotalData() {
        Map<String, Object> totalData = new HashMap<>();
        //common
        Map head = CommonDataFactory.createData();
        totalData.put("top", head);
        //maintainability
        Map maintainability = MainTrainSynopticDataFactory.createData();
        totalData.put("MainTrainSynoptic", maintainability);
        //preparationScreen
        Map preparationScreen = PreparationScreenDataFactory.createData();
        totalData.put("preparationScreen", preparationScreen);
        //Operation
        Map Operation = OperationDataFactory.createData();
        totalData.put("Operation", Operation);
        //HV
        Map hv = HVDataFactory.createData();
        totalData.put("hv", hv);
        //HVAC
        Map HVAC = HVACDataFactory.createData();
        totalData.put("HVAC", HVAC);
        //ATC
        Map atc = ATCDataFactory.createData();
        totalData.put("atc", atc);
        //papis
        Map papis = PAPISDataFactory.createData();
        totalData.put("papis", papis);
        //bmsdata
        Map bmsdata = BMSDataFactory.createData();
        totalData.put("bmsdata", bmsdata);
        //BypassSwith
        Map bypassswith = BypassSwithDataFactory.createData();
        totalData.put("bypassswith", bypassswith);
        //PECU
        Map pecu = PECUDataFactory.createData();
        totalData.put("pecu", pecu);
        //FSD
        Map FSD = FSDDataFactory.createData();
        totalData.put("FSD", FSD);
        //EB
        Map EB = EBDataFactory.createData();
        totalData.put("EB", EB);
        //EmergencyHandle
        Map emergencyhandle = EmergencyHandleDataFactory.createData();
        totalData.put("emergencyhandle", emergencyhandle);
        //IOS
        Map IOS = IOSDataFactory.createData();
        totalData.put("IOS", IOS);
        //HAVCFault
        Map HAVCFault = HAVCFaultDataFactory.createData();
        totalData.put("HAVCFault", HAVCFault);
        //coverStatus
        Map coverStatus = CoverStatusDataFactory.createData();
        totalData.put("coverStatus", coverStatus);
        //CB
        Map cb = CBDataFactory.createData();
        totalData.put("CB", cb);
        Map maintenance = MaintenanceDataFactory.createData();
        totalData.put("maintenance", maintenance);
        return totalData;
    }

    /* public static void buildDataFactory(List<Map<String,Object>> configData) {
        Map data=new HashMap<>();
        for (Map configDatum : configData) {
            Object locationName = configDatum.get("locationName");
            Object number = configDatum.get("number");
            Object type = configDatum.get("type");
            Object path = configDatum.get("path");
            if(type.equals("1")){
                data.put(locationName,path);
            }else if(type.equals("2")){
                List<Map<String,Object>> statuses = (List)configDatum.get("statuses");
                for (Map<String,Object> status : statuses) {
                    String logicalFormula = (String) status.get("logicalFormula");
                    List<Map<String,Object>> fields = (List)status.get("fields");
                    logicalFormula = logicalFormula.replaceAll("[or,OR]", "||");
                    logicalFormula = logicalFormula.replaceAll("[and,AND]", "&&");
                    Object[] params=new Object[fields.size()];
                    for (Map<String,Object> field : fields) {
                        String port = (String)field.get("port");
                        String name = (String)field.get("name");
                        int order = (int)field.get("order");
                        Long value = getValue(port,name);
                        params[order]=(value==1?true:false);
                    }
                    try {
                        logicalFormula= MessageFormat.format(logicalFormula, params);
                        boolean result = (boolean) jse.eval(logicalFormula);
                        if(result){
                            String value = (String) status.get("value");
                            data.put(locationName,value);
                        }
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }*/
}
