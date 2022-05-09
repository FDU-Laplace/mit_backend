package com.missiongroup.starring.core.vehicleData;

import java.util.HashMap;
import java.util.Map;

public class EBDataFactory extends DatatFactory {
    public static Map createData() {
        Map<String, Object> data = new HashMap<>();
        Map driver = createDriver();
        Map derailment = createDerailment();
        Map lmrg = createLMRG();
        Map atp = createATP();
        Map deadman = createDeadman();
        Map overSpeed = createOverSpeed();
        Map obstacleDetection = createObstacleDetection();
        Map detrainmentDoor = createDetrainmentDoor();
        Map otherReasons = createOtherReasons();
        Map bothCabActive = createBothCabActive();
        Map cabActive = createCabActive();
        data.put("driver", driver);
        data.put("derailment", derailment);
        data.put("lmrg", lmrg);
        data.put("atp", atp);
        data.put("deadman", deadman);
        data.put("overSpeed", overSpeed);
        data.put("obstacleDetection", obstacleDetection);
        data.put("detrainmentDoor", detrainmentDoor);
        data.put("otherReasons", otherReasons);
        data.put("bothCabActive", bothCabActive);
        data.put("cabActive", cabActive);
        return data;
    }

    /**
     * driver
     */
    private static Map createDriver() {
        Map<String, Object> data = new HashMap<>();


        Long dd_cebpb_a1 = getValue("port0x126", "DD_CEBPB_A1");
        Long dd_cebpb_a2 = getValue("port0x126", "DD_CEBPB_A2");
        String a1 = getStatus(dd_cebpb_a1);
        String a2 = getStatus(dd_cebpb_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Derailment
     */
    private static Map createDerailment() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebDerail = getValue("port0x126", "DD_CEBDerail");
        String Derailment = getStatus(dd_cebDerail);
        data.put("Derailment", Derailment);
        return data;
    }

    /**
     * LMRG
     */
    private static Map createLMRG() {
        Map<String, Object> data = new HashMap<>();
        Long dd_ceblmrg = getValue("port0x126", "DD_CEBLMRG");
        String lmrg = getStatus(dd_ceblmrg);
        data.put("lmrg", lmrg);
        return data;
    }

    /**
     * ATP
     */
    private static Map createATP() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebatp = getValue("port0x126", "DD_CEBATP");
        String atp = getStatus(dd_cebatp);
        data.put("atp", atp);
        return data;
    }

    /**
     * Deadman
     */
    private static Map createDeadman() {
        Map<String, Object> data = new HashMap<>();


        Long dd_cebDeadMan_a1 = getValue("port0x126", "DD_CEBDeadMan_A1");
        Long dd_cebDeadMan_a2 = getValue("port0x126", "DD_CEBDeadMan_A2");
        String a1 = getStatus(dd_cebDeadMan_a1);
        String a2 = getStatus(dd_cebDeadMan_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * overSpeed
     */
    private static Map createOverSpeed() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebOverSpeed = getValue("port0x126", "DD_CEBOverSpeed");
        String overSpeed = getStatus(dd_cebOverSpeed);
        data.put("overSpeed", overSpeed);
        return data;
    }

    /**
     * Obstacle
     * Detection
     */
    private static Map createObstacleDetection() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebDetObst_a1 = getValue("port0x126", "DD_CEBDetObst_A1");
        Long dd_cebDetObst_a2 = getValue("port0x126", "DD_CEBDetObst_A2");
        String a1 = getStatus(dd_cebDetObst_a1);
        String a2 = getStatus(dd_cebDetObst_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Detrainment Door
     */
    private static Map createDetrainmentDoor() {
        Map<String, Object> data = new HashMap<>();


        Long dd_cebddOpen_a1 = getValue("port0x134", "DD_CEBDDOpen_A1");
        Long dd_cebddUnlock_a1 = getValue("port0x123", "DD_CEBDDUnlock_A1");
        Long dd_cebddOpen_a2 = getValue("port0x134", "DD_CEBDDOpen_A2");
        Long dd_cebddUnlock_a2 = getValue("port0x123", "DD_CEBDDUnlock_A2");
        String a1 = getDoorStatus(dd_cebddOpen_a1, dd_cebddUnlock_a1);
        String a2 = getDoorStatus(dd_cebddOpen_a2, dd_cebddUnlock_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Other
     * Reasons
     */
    private static Map createOtherReasons() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebCauseOther = getValue("port0x126", "DD_CEBCauseOther");
        String causeOther = getStatus(dd_cebCauseOther);
        data.put("causeOther", causeOther);
        return data;
    }

    /**
     * EB due to both cab active
     */
    private static Map createBothCabActive() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebBothCabAct = getValue("port0x126", "DD_CEBBothCabAct");
        String bothcabact = getStatus(dd_cebBothCabAct);
        data.put("bothcabact", bothcabact);
        return data;
    }

    /**
     * EB due to No cab active
     */
    private static Map createCabActive() {
        Map<String, Object> data = new HashMap<>();
        Long dd_cebNoCabAct = getValue("port0x126", "DD_CEBNoCabAct");
        String NoCabAct = getStatus(dd_cebNoCabAct);
        data.put("noCabAct", NoCabAct);
        return data;
    }

    private static String getStatus(Long dd) {
        String c = "";
        if (dd == 1) {
            c = "true";
        } else if (dd == 0) {
            c = "false";
        }
        return c;
    }

    private static String getDoorStatus(Long dd_cebddOpen, Long dd_cebddUnlock) {
        String c = "";
        if (dd_cebddOpen == 1 || dd_cebddUnlock == 1) {
            c = "true";
        } else if (dd_cebddOpen == 0 && dd_cebddUnlock == 0) {
            c = "false";
        }
        return c;
    }
}
