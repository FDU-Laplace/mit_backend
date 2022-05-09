package com.missiongroup.starring.core.springtask;

import java.util.HashMap;
import java.util.Map;

public class EBDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();

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
     *
     * @return
     */
    private static Map createDriver() {
        Map data = new HashMap();



        Long dd_cebpb_a1 = getValue("port0x126","DD_CEBPB_A1");
        Long dd_cebpb_a2 = getValue("port0x126","DD_CEBPB_A2");
        String a1 = getStatus(dd_cebpb_a1);
        String a2 = getStatus(dd_cebpb_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Derailment
     *
     * @return
     */
    private static Map createDerailment() {
        Map data = new HashMap();
        Long dd_cebDerail = getValue("port0x126","DD_CEBDerail");
        String Derailment = getStatus(dd_cebDerail);
        data.put("Derailment", Derailment);
        return data;
    }

    /**
     * LMRG
     *
     * @return
     */
    private static Map createLMRG() {
        Map data = new HashMap();
        Long dd_ceblmrg = getValue("port0x126","DD_CEBLMRG");
        String lmrg = getStatus(dd_ceblmrg);
        data.put("lmrg", lmrg);
        return data;
    }

    /**
     * ATP
     *
     * @return
     */
    private static Map createATP() {
        Map data = new HashMap();
        Long dd_cebatp = getValue("port0x126","DD_CEBATP");
        String atp = getStatus(dd_cebatp);
        data.put("atp", atp);
        return data;
    }

    /**
     * Deadman
     *
     * @return
     */
    private static Map createDeadman() {
        Map data = new HashMap();


        Long dd_cebDeadMan_a1 = getValue("port0x126","DD_CEBDeadMan_A1");
        Long dd_cebDeadMan_a2 = getValue("port0x126","DD_CEBDeadMan_A2");
        String a1 = getStatus(dd_cebDeadMan_a1);
        String a2 = getStatus(dd_cebDeadMan_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * overSpeed
     *
     * @return
     */
    private static Map createOverSpeed() {
        Map data = new HashMap();
        Long dd_cebOverSpeed = getValue("port0x126","DD_CEBOverSpeed");
        String overSpeed = getStatus(dd_cebOverSpeed);
        data.put("overSpeed", overSpeed);
        return data;
    }

    /**
     * Obstacle
     * Detection
     *
     * @return
     */
    private static Map createObstacleDetection() {
        Map data = new HashMap();
        Long dd_cebDetObst_a1 =getValue("port0x126","DD_CEBDetObst_A1");
        Long dd_cebDetObst_a2 =getValue("port0x126","DD_CEBDetObst_A2");
        String a1 = getStatus(dd_cebDetObst_a1);
        String a2 = getStatus(dd_cebDetObst_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Detrainment Door
     *
     * @return
     */
    private static Map createDetrainmentDoor() {
        Map data = new HashMap();


        Long dd_cebddOpen_a1 = getValue("port0x134","DD_CEBDDOpen_A1");
        Long dd_cebddOpen_a2 = getValue("port0x134","DD_CEBDDOpen_A2");
        String a1 = getStatus(dd_cebddOpen_a1);
        String a2 = getStatus(dd_cebddOpen_a2);
        data.put("a1", a1);
        data.put("a2", a2);
        return data;
    }

    /**
     * Other
     * Reasons
     *
     * @return
     */
    private static Map createOtherReasons() {
        Map data = new HashMap();
        Long dd_cebCauseOther = getValue("port0x126","DD_CEBCauseOther");
        String causeOther = getStatus(dd_cebCauseOther);
        data.put("causeOther", causeOther);
        return data;
    }

    /**
     * EB due to both cab active
     *
     * @return
     */
    private static Map createBothCabActive() {
        Map data = new HashMap();
        Long dd_cebBothCabAct = getValue("port0x126","DD_CEBBothCabAct");
        String bothcabact = getStatus(dd_cebBothCabAct);
        data.put("bothcabact", bothcabact);
        return data;
    }

    /**
     * EB due to No cab active
     *
     * @return
     */
    private static Map createCabActive() {
        Map data = new HashMap();
        Long dd_cebNoCabAct = getValue("port0x126","DD_CEBNoCabAct");
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
}
