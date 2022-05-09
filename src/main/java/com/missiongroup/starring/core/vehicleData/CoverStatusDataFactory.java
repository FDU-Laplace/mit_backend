package com.missiongroup.starring.core.vehicleData;


import java.util.HashMap;
import java.util.Map;

public class CoverStatusDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map hVCover = HVCover();
        data.put("HVCover", hVCover);
        //Map emgCover = EMGCover();
        //data.put("emgCover",emgCover);

        Map driverDeskCover = driverDeskCover();
        data.put("driverDeskCover", driverDeskCover);

        Map tractionCover = tractionCover();
        data.put("tractionCover", tractionCover);

        Map saloonCabinetDoor = SaloonCabinetDoor();
        data.put("saloonCabinetDoor", saloonCabinetDoor);

        Map cabinCabinetDoor = cabinCabinetDoor();
        data.put("cabinCabinetDoor", cabinCabinetDoor);

        Map underSeatCover = underSeatCover();
        data.put("underSeatCover", underSeatCover);

        return data;
    }

    /**
     * HV Cover
     *
     */
    private static Map HVCover() {
        Map<String, Object> data = new HashMap<>();
        Long LI_CVSCover_A1 = getValue("port0x354", "LI_CVSCover_A1");
        Long LI_CVSCover_A1_D = getValue("port0x354", "LI_CVSCover_A1_D");
        Long LI_CVSCover_A2 = getValue("port0x424", "LI_CVSCover_A2");
        Long LI_CVSCover_A2_D = getValue("port0x424", "LI_CVSCover_A2_D");
        Long LI_CVSCover_C2 = getValue("port0x3d4", "LI_CVSCover_C2");
        Long LI_CVSCover_C2_D = getValue("port0x3d4", "LI_CVSCover_C2_D");
        String CVSCover_A1 = getStatus(LI_CVSCover_A1);
        String CVSCover_A2 = getStatus(LI_CVSCover_A2);
        String CVSCover_C2 = getStatus(LI_CVSCover_C2);
        data.put("A1", CVSCover_A1);
        data.put("A2", CVSCover_A2);
        data.put("C2", CVSCover_C2);
        return data;
    }

    /**
     * EMG Cover
     *
     */
    private static Map EMGCover() {
        Map<String, Object> data = new HashMap<>();
        Long LI_EGMCover_B1 = getValue("port0x394", "LI_EGMCover_B1");
        Long LI_EGMCover_B2 = getValue("port0x3f4", "LI_EGMCover_B2");
        String EGMCover_B1 = getStatus(LI_EGMCover_B1);
        String EGMCover_B2 = getStatus(LI_EGMCover_B2);
        data.put("B1", EGMCover_B1);
        data.put("B2", EGMCover_B2);
        return data;
    }

    /**
     * driverDeskCover
     *
     */
    private static Map driverDeskCover() {
        Map<String, Object> data = new HashMap<>();
        Long LI_CDCS1_A1 = getValue("port0x344", "LI_CDCS1_A1");
        Long LI_CDCS2_A1 = getValue("port0x344", "LI_CDCS2_A1");
        Long LI_CDCS1_A2 = getValue("port0x414", "LI_CDCS1_A2");
        Long LI_CDCS2_A2 = getValue("port0x414", "LI_CDCS2_A2");
        String a1_1 = getStatus(LI_CDCS1_A1);
        String a1_2 = getStatus(LI_CDCS2_A1);
        String a2_1 = getStatus(LI_CDCS1_A2);
        String a2_2 = getStatus(LI_CDCS2_A2);
        data.put("A1_1", a1_1);
        data.put("A1_2", a1_2);
        data.put("A2_1", a2_1);
        data.put("A2_2", a2_2);
        return data;
    }

    /**
     * Traction Cover
     *
     */
    private static Map tractionCover() {
        Map<String, Object> data = new HashMap<>();
        Long LI_PCECover_B1 = getValue("port0x394", "LI_PCECover_B1");
        Long LI_PCECover_C1 = getValue("port0x3b4", "LI_PCECover_C1");
        Long LI_PCECover_C2 = getValue("port0x3d4", "LI_PCECover_C2");
        Long LI_PCECover_B2 = getValue("port0x3f4", "LI_PCECover_B2");
        String B1 = getStatus(LI_PCECover_B1);
        String C1 = getStatus(LI_PCECover_C1);
        String C2 = getStatus(LI_PCECover_C2);
        String B2 = getStatus(LI_PCECover_B2);
        data.put("B1", B1);
        data.put("C1", C1);
        data.put("C2", C2);
        data.put("B2", B2);
        return data;
    }


    /**
     * Saloon Cabinet Door
     *
     */
    private static Map cabinCabinetDoor() {
        Map<String, Object> data = new HashMap<>();
        Long LI_CabinetDoor3_A1 = getValue("port0x344", "LI_CabinetDoor3_A1");
        Long LI_CabinetDoor3_A2 = getValue("port0x414", "LI_CabinetDoor3_A2");
        Long LI_CabinetDoor4_A1 = getValue("port0x344", "LI_CabinetDoor4_A1");
        Long LI_CabinetDoor4_A2 = getValue("port0x414", "LI_CabinetDoor4_A2");
        String A1_2 = getStatus(LI_CabinetDoor4_A1);
        String A2_2 = getStatus(LI_CabinetDoor4_A2);
        data.put("A1_2", A1_2);
        data.put("A2_2", A2_2);
        String A1_1 = getStatus(LI_CabinetDoor3_A1);
        String A2_1 = getStatus(LI_CabinetDoor3_A2);
        data.put("A1_1", A1_1);
        data.put("A2_1", A2_1);
        return data;
    }

    /**
     * Cabin Cabinet Door
     *
     */
    private static Map SaloonCabinetDoor() {
        Map<String, Object> data = new HashMap<>();
        Long LI_CabinetDoor1_A1 = getValue("port0x374", "LI_CabinetDoor1_A1");
        Long LI_CabinetDoor2_A1 = getValue("port0x384", "LI_CabinetDoor2_A1");
        String A1_1 = getStatus(LI_CabinetDoor1_A1);
        String A1_2 = getStatus(LI_CabinetDoor2_A1);
        data.put("A1_1", A1_1);
        data.put("A1_2", A1_2);
        Long LI_CabinetDoor1_B1 = getValue("port0x394", "LI_CabinetDoor1_B1");
        Long LI_CabinetDoor2_B1 = getValue("port0x394", "LI_CabinetDoor2_B1");
        String B1_1 = getStatus(LI_CabinetDoor1_B1);
        String B1_2 = getStatus(LI_CabinetDoor2_B1);
        data.put("B1_1", B1_1);
        data.put("B1_2", B1_2);
        Long LI_CabinetDoor1_C1 = getValue("port0x3b4", "LI_CabinetDoor1_C1");
        Long LI_CabinetDoor2_C1 = getValue("port0x3b4", "LI_CabinetDoor2_C1");
        String C1_1 = getStatus(LI_CabinetDoor1_C1);
        String C1_2 = getStatus(LI_CabinetDoor2_C1);
        data.put("C1_1", C1_1);
        data.put("C1_2", C1_2);
        Long LI_CabinetDoor1_C2 = getValue("port0x3d4", "LI_CabinetDoor1_C2");
        Long LI_CabinetDoor2_C2 = getValue("port0x3d4", "LI_CabinetDoor2_C2");
        String C2_1 = getStatus(LI_CabinetDoor1_C2);
        String C2_2 = getStatus(LI_CabinetDoor2_C2);
        data.put("C2_1", C2_1);
        data.put("C2_2", C2_2);
        Long LI_CabinetDoor1_B2 = getValue("port0x3f4", "LI_CabinetDoor1_B2");
        Long LI_CabinetDoor2_B2 = getValue("port0x3f4", "LI_CabinetDoor2_B2");
        String B2_1 = getStatus(LI_CabinetDoor1_B2);
        String B2_2 = getStatus(LI_CabinetDoor2_B2);
        data.put("B2_1", B2_1);
        data.put("B2_2", B2_2);
        Long LI_CabinetDoor1_A2 = getValue("port0x444", "LI_CabinetDoor1_A2");
        Long LI_CabinetDoor2_A2 = getValue("port0x454", "LI_CabinetDoor2_A2");
        String A2_1 = getStatus(LI_CabinetDoor1_A2);
        String A2_2 = getStatus(LI_CabinetDoor2_A2);

        data.put("A2_1", A2_1);
        data.put("A2_2", A2_2);
        return data;
    }


    /**
     * under seat Cover
     *
     */
    private static Map underSeatCover() {
        Map<String, Object> data = new HashMap<>();
        Long LI_SeatCoverRight_A1 = getValue("port0x364", "LI_SeatCoverRight_A1");
        Long LI_SeatCoverLeft_A1 = getValue("port0x364", "LI_SeatCoverLeft_A1");
        Long LI_SeatCoverRight_A2 = getValue("port0x434", "LI_SeatCoverRight_A2");
        Long LI_SeatCoverLeft_A2 = getValue("port0x434", "LI_SeatCoverLeft_A2");
        String Right_A1 = getStatus(LI_SeatCoverRight_A1);
        String Left_A1 = getStatus(LI_SeatCoverLeft_A1);
        String Right_A2 = getStatus(LI_SeatCoverRight_A2);
        String Left_A2 = getStatus(LI_SeatCoverLeft_A2);
        data.put("A1_2", Right_A1);
        data.put("A1_1", Left_A1);
        data.put("A2_2", Right_A2);
        data.put("A2_1", Left_A2);
        return data;
    }

    private static String getStatus(Long val1, Long val2) {
        String status = "false";
        if (val1 == 1 || val2 == 1) {
            status = "true";
        }
        return status;
    }

    private static String getStatus(Long val1) {
        String status = "false";
        if (val1 == 1) {
            status = "true";
        }
        return status;
    }
}
