package com.missiongroup.starring.core.vehicleData;

import com.alibaba.fastjson.JSONObject;
import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.Fault;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IOSDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        try {
            List IOS = CIOSdata();
            List<String> port = new ArrayList<>();
            port.add("port0x124");
            port.add("port0x125");
            LinkedList AckIOS = CAckIOSdata(port);
            data.put("IOS", IOS);
            data.put("AckIOS", AckIOS);
            Map mvbStatus = mapStatus();
            data.put("mvbStatus", mvbStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private static synchronized List CIOSdata() {
        List<String> data = new ArrayList<>();
        LinkedList faults = new LinkedList();
        LinkedList faultHistorys = new LinkedList();
        Long mpu_cTrainNumber = getValue("port0x101", "MPU_CTrainNumber");
        Long current_station = getValue("port0x121", "DD_CCurrentStation");
        Long next_station = getValue("port0x127", "DD_CNextStation");
        Long destination = getValue("port0x127", "DD_CFinalDestination");

        Map port0x124 = (Map) dataAll.get("port0x124");
        if(port0x124 == null)
            return getFaultInfo(data);
        Iterator iterator = port0x124.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, PortModel> next = (Map.Entry<String, PortModel>) iterator.next();
            PortModel value = next.getValue();
            Long value1 = value.getValue();
            String signalName = value.getSignalName();
            boolean matches = matchesCIOS(signalName);
            if (matches && value1 == 1) {
                String num = getNum(signalName);
                data.add(num);
                Fault fault = buildFault(mpu_cTrainNumber, current_station, next_station, num);
                faults.add(fault);
            }
        }
        String faultsJson = JSONObject.toJSONString(faults);
        String codes = data.stream().collect(Collectors.joining(","));
        faultService.updateFaultCodes(codes);
        faultService.updateFaultData(faultsJson);
        return getFaultInfo(data);
    }

    private static List<FaultConfig> getFaultInfo(List<String> data) {
        List<FaultConfig> re = new ArrayList<>();
        List<FaultConfig> faultConfigs = iCaches.get("CONSTANT", "faultConfigs");
        for (FaultConfig faultConfig : faultConfigs) {
            String faultCode = faultConfig.getFaultCode();
            if (data.contains(faultCode)) {
                re.add(faultConfig);
            }
        }
        Collections.sort(re, Comparator.comparing(FaultConfig::getFaultLevel));
        return re;
    }

    private static Fault buildFault(Long mpu_cTrainNumber, Long current_station, Long next_station, String faultNum) {
        Fault fault = new Fault();
        List<FaultConfig> faultConfigs = iCaches.get("CONSTANT", "faultConfigs");
        for (FaultConfig faultConfig : faultConfigs) {
            String faultCode = faultConfig.getFaultCode();
            if (faultNum.contains(faultCode)) {
                fault.setRelationLin("7");
                fault.setRelationTrain(String.valueOf(mpu_cTrainNumber));
                fault.setRelationCarriage(faultConfig.getCarriage());
                fault.setFaultCode(faultNum);
                fault.setFaultSys(faultConfig.getFaultSys());
                fault.setFaultName(faultConfig.getFaultName());
                fault.setFaultLevel(faultConfig.getFaultLevel());
                fault.setIsFault("1");
                fault.setConfirmFault("0");
                Date date = new Date();
                fault.setOccurrenceTime(date);
//                fault.setRemarks(faultConfig.getFaultName());
                fault.setNextStation(String.valueOf(next_station));
                fault.setReleaseStatus("0");
                fault.setPushStatus("0");
                fault.setTrainType("1");
                //fault.setFaultType("1");
                fault.setCurrentStation(String.valueOf(current_station));
                fault.setTrainPosition(faultConfig.getCarriage());
            }
        }
        return fault;
    }

    private static synchronized LinkedList CAckIOSdata(List data) {
        LinkedList<String> res = new LinkedList<>();
        for (Object datum : data) {
            Map port = (Map) dataAll.get(datum);
            if(port ==null)
                continue;
            Iterator iterator = port.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, PortModel> next = (Map.Entry<String, PortModel>) iterator.next();
                PortModel value = next.getValue();
                Long value1 = value.getValue();
                String signalName = value.getSignalName();
                boolean matches = matchesCAckIOS(signalName);
                if (matches && value1 == 1) {
                    String num = getNum(signalName);
                    res.add(num);
                }
            }
        }
        return res;
    }

    private static boolean matchesCIOS(String name) {
        String reg = "^[DD_CIOS]{7}\\d+$";
        boolean matches = name.matches(reg);
        return matches;
    }

    private static boolean matchesCAckIOS(String name) {
        String reg = "^[DD_CAckIOS]{10}\\d+$";
        boolean matches = name.matches(reg);
        return matches;
    }

    private static String getNum(String name) {
        String reg = "\\D+(\\d+)$";
        Pattern p2 = Pattern.compile(reg);
        Matcher m2 = p2.matcher(name);
        if (m2.find()) {
            return m2.group(1);
        }
        return null;
    }

    /**
     * mvb网络状态
     *
     * @return
     */
    private static Map mapStatus() {
        Map mvb = new HashMap();
        Long mvbA = getValue("port0x840", "PISi_IMedium1OK");
        Long mvbb = getValue("port0x840", "PISi_IMedium2OK");
        mvb.put("mvbA", mvbA);
        mvb.put("mvbb", mvbb);
        return mvb;
    }
}
