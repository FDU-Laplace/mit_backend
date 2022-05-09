package com.missiongroup.starring.core.springtask;

import com.missiongroup.starring.core.cache.service.PortModel;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOSDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        try {
            LinkedList IOS = CIOSdata();
            List port=new ArrayList();
            port.add("port0x124");
            port.add("port0x125");
            LinkedList AckIOS = CAckIOSdata(port);
            data.put("IOS",IOS);
            data.put("AckIOS",AckIOS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private static synchronized  LinkedList CIOSdata() throws Exception{
        LinkedList data = new LinkedList();
        Map port0x124 = (Map) dataAll.get("port0x124");
        Iterator iterator = port0x124.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, PortModel> next = (Map.Entry<String, PortModel>) iterator.next();
            PortModel value =  next.getValue();
            Long value1 = value.getValue();
            data.add(value1);
        }
        /*Class<? extends Port0x124> aClass = DatatFactory.port0x124.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String fieldName = declaredField.getName();
            Long value = (Long) declaredField.get(DatatFactory.port0x124);
            boolean matches = matchesCIOS(fieldName);
            if (matches&&value==1) {
                String num = getNum(fieldName);
                data.add(num);
            }
        }*/
        return data;
    }
    private static synchronized LinkedList CAckIOSdata(List data) throws Exception{
        LinkedList res = new LinkedList();
        for (Object datum : data) {
            Map port = (Map) dataAll.get(datum);
            Iterator iterator = port.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, PortModel> next = (Map.Entry<String, PortModel>) iterator.next();
                PortModel value =  next.getValue();
                Long value1 = value.getValue();
                res.add(value1);
            }
           /* Class aClass = datum.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                String fieldName = declaredField.getName();
                Long value = (Long) declaredField.get(datum);
                boolean matches = matchesCAckIOS(fieldName);
                if (matches&&value==1) {
                    String num = getNum(fieldName);
                    res.add(num);
                }
            }*/
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
}
