package com.missiongroup.starring.core.springtask;


import java.util.HashMap;
import java.util.Map;

public class CBDataFactory extends DatatFactory {
    public static Map createData() {
        Map data = new HashMap();
        Map A1 = createCBA1();
        Map A2 = createCBA2();
        Map B1 = createCBB1();
        Map B2 = createCBB2();
        Map C1 = createCBC1();
        Map C2 = createCBC2();
        data.put("A1",A1);
        data.put("A2",A2);
        data.put("B1",B1);
        data.put("B2",B2);
        data.put("C1",C1);
        data.put("C2",C2);
        return data;
    }

    /**
     * A1
     *
     * @param
     * @return
     */
    private static Map createCBA1() {
        Map data = new HashMap();
        Long LI_PANTCB_A1 = getValue("port0x364", "LI_PANTCB_A1");
        data.put("PANTCB", LI_PANTCB_A1 == 1 ? "true" : "false");
        Long LI_PECB_A1 = getValue("port0x364", "LI_PECB_A1");
        data.put("PECB", LI_PECB_A1 == 1 ? "true" : "false");
        Long LI_MACB_A1 = getValue("port0x364", "LI_MACB_A1");
        data.put("MACB", LI_MACB_A1 == 1 ? "true" : "false");
        Long LI_HVACCB_A1 = getValue("port0x364", "LI_HVACCB_A1");
        data.put("HVACCB", LI_HVACCB_A1 == 1 ? "true" : "false");
        Long LI_FCUCB_A1 = getValue("port0x374", "LI_FCUCB_A1");
        data.put("FCUCB", LI_FCUCB_A1 == 1 ? "true" : "false");
        Long LI_DDOCB_A1 = getValue("port0x344", "LI_DDOCB_A1");
        data.put("DDOCB", LI_DDOCB_A1 == 1 ? "true" : "false");
        Long LI_EEDCB_A1 = getValue("port0x364", "LI_EEDCB_A1");
        data.put("EEDCB", LI_EEDCB_A1 == 1 ? "true" : "false");
        Long LI_DRTLRCB_A1 = getValue("port0x344", "LI_DRTLRCB_A1");
        data.put("DRTLRCB", LI_DRTLRCB_A1 == 1 ? "true" : "false");
        Long LI_DOTLRCB_A1 = getValue("port0x364", "LI_DOTLRCB_A1");
        data.put("DOTLRCB", LI_DOTLRCB_A1 == 1 ? "true" : "false");
        Long LI_DCLRCB_A1 = getValue("port0x354", "LI_DCLRCB_A1");
        data.put("DCLRCB", LI_DCLRCB_A1 == 1 ? "true" : "false");
        Long LI_HDLRCB_A1 = getValue("port0x354", "LI_HDLRCB_A1");
        data.put("HDLRCB", LI_HDLRCB_A1 == 1 ? "true" : "false");
        Long LI_EBTLCB_A1 = getValue("port0x364", "LI_EBTLCB_A1");
        data.put("EBTLCB", LI_EBTLCB_A1 == 1 ? "true" : "false");
        Long LI_EBTLCB1_A1 = getValue("port0x364", "LI_EBTLCB1_A1");
        data.put("EBTLCB1", LI_EBTLCB1_A1 == 1 ? "true" : "false");
        Long LI_EBCB_A1 = getValue("port0x364", "LI_EBCB_A1");
        data.put("EBCB", LI_EBCB_A1 == 1 ? "true" : "false");
        Long LI_HLDBHLI_A1 = getValue("port0x364", "LI_HLDBHLI_A1");
        data.put("HLDBHLI", LI_HLDBHLI_A1 == 1 ? "true" : "false");
        Long LI_RHCB_A1 = getValue("port0x354", "LI_RHCB_A1");
        data.put("RHCB", LI_RHCB_A1 == 1 ? "true" : "false");
        Long LI_MCCB_A1 = getValue("port0x364", "LI_MCCB_A1");
        data.put("MCCB", LI_MCCB_A1 == 1 ? "true" : "false");
        Long LI_MCPERCB_A1 = getValue("port0x344", "LI_MCPERCB_A1");
        data.put("MCPERCB", LI_MCPERCB_A1 == 1 ? "true" : "false");
        Long LI_EMTCB_A1 = getValue("port0x344", "LI_EMTCB_A1");
        data.put("EMTCB", LI_EMTCB_A1 == 1 ? "true" : "false");
        Long LI_WUSLCB_A1 = getValue("port0x354", "LI_WUSLCB_A1");
        data.put("WUSLCB", LI_WUSLCB_A1 == 1 ? "true" : "false");
        Long LI_CORCB_A1 = getValue("port0x364", "LI_CORCB_A1");
        data.put("CORCB", LI_CORCB_A1 == 1 ? "true" : "false");
        Long LI_CMCCB_A1 = getValue("port0x384", "LI_CMCCB_A1");
        data.put("CMCCB", LI_CMCCB_A1 == 1 ? "true" : "false");
        Long LI_ZVRCB_A1 = getValue("port0x374", "LI_ZVRCB_A1");
        data.put("ZVRCB", LI_ZVRCB_A1 == 1 ? "true" : "false");
        Long LI_ELCB_A1 = getValue("port0x374", "LI_ELCB_A1");
        data.put("ELCB", LI_ELCB_A1 == 1 ? "true" : "false");
        Long LI_FLICB_A1 = getValue("port0x364", "LI_FLICB_A1");
        data.put("FLICB", LI_FLICB_A1 == 1 ? "true" : "false");
        Long LI_DZVRCB12_A1 = getValue("port0x364", "LI_DZVRCB12_A1");
        data.put("DZVRCB12", LI_DZVRCB12_A1 == 1 ? "true" : "false");
        Long LI_BSCB_A1 = getValue("port0x374", "LI_BSCB_A1");
        data.put("BSCB", LI_BSCB_A1 == 1 ? "true" : "false");
        Long LI_PBCB_A1 = getValue("port0x354", "LI_PBCB_A1");
        data.put("PBCB", LI_PBCB_A1 == 1 ? "true" : "false");
        Long LI_TSKCB_A1 = getValue("port0x354", "LI_TSKCB_A1");
        data.put("TSKCB", LI_TSKCB_A1 == 1 ? "true" : "false");
        Long LI_PCUCB_A1 = getValue("port0x354", "LI_PCUCB_A1");
        data.put("PCUCB", LI_PCUCB_A1 == 1 ? "true" : "false");
        Long LI_TLICB_A1 = getValue("port0x344", "LI_TLICB_A1");
        data.put("TLICB", LI_TLICB_A1 == 1 ? "true" : "false");
        Long LI_BCECB1_A1 = getValue("port0x374", "LI_BCECB1_A1");
        data.put("BCECB1", LI_BCECB1_A1 == 1 ? "true" : "false");
        Long LI_BCECB2_A1 = getValue("port0x374", "LI_BCECB2_A1");
        data.put("BCECB2", LI_BCECB2_A1 == 1 ? "true" : "false");
        Long LI_SCUCB12_A1 = getValue("port0x354", "LI_SCUCB12_A1");
        data.put("SCUCB12", LI_SCUCB12_A1 == 1 ? "true" : "false");
        Long LI_BATCB_A1 = getValue("port0x354", "LI_BATCB_A1");
        data.put("BATCB", LI_BATCB_A1 == 1 ? "true" : "false");
        Long LI_AICB_A1 = getValue("port0x374", "LI_AICB_A1");
        data.put("AICB", LI_AICB_A1 == 1 ? "true" : "false");
        Long LI_ISCB_A1 = getValue("port0x354", "LI_ISCB_A1");
        data.put("ISCB", LI_ISCB_A1 == 1 ? "true" : "false");


        return data;
    }

    /**
     * B1
     *
     * @param
     * @return
     */
    private static Map createCBB1() {
        Map data = new HashMap();
        Long LI_HVACCB_B1 = getValue("port0x394", "LI_HVACCB_B1");
        data.put("HVACCB", LI_HVACCB_B1 == 1 ? "true" : "false");
        Long LI_EBTLCB_B1 = getValue("port0x3a4", "LI_EBTLCB_B1");
        data.put("EBTLCB", LI_EBTLCB_B1 == 1 ? "true" : "false");
        Long LI_ELCB_B1 = getValue("port0x394", "LI_ELCB_B1");
        data.put("ELCB", LI_ELCB_B1 == 1 ? "true" : "false");
        Long LI_BCECB1_B1 = getValue("port0x3a4", "LI_BCECB1_B1");
        data.put("BCECB1", LI_BCECB1_B1 == 1 ? "true" : "false");
        Long LI_BCECB2_B1 = getValue("port0x3a4", "LI_BCECB2_B1");
        data.put("BCECB2", LI_BCECB2_B1 == 1 ? "true" : "false");
        Long LI_SCUCB12_B1 = getValue("port0x3a4", "LI_SCUCB12_B1");
        data.put("SCUCB12", LI_SCUCB12_B1 == 1 ? "true" : "false");
        Long LI_LPTCB_B1 = getValue("port0x394", "LI_LPTCB_B1");
        data.put("LPTCB", LI_LPTCB_B1 == 1 ? "true" : "false");
        Long LI_PCECB1_B1 = getValue("port0x394", "LI_PCECB1_B1");
        data.put("PCECB1", LI_PCECB1_B1 == 1 ? "true" : "false");
        Long LI_PCECB2_B1 = getValue("port0x3a4", "LI_PCECB2_B1");
        data.put("PCECB2", LI_PCECB2_B1 == 1 ? "true" : "false");
        Long LI_PTCB_B1 = getValue("port0x394", "LI_PTCB_B1");
        data.put("PTCB", LI_PTCB_B1 == 1 ? "true" : "false");
        Long LI_RPTCB_B1 = getValue("port0x394", "LI_RPTCB_B1");
        data.put("RPTCB", LI_RPTCB_B1 == 1 ? "true" : "false");
        Long LI_ELDKCB_B1 = getValue("port0x394", "LI_ELDKCB_B1");
        data.put("ELDKCB", LI_ELDKCB_B1 == 1 ? "true" : "false");


        return data;
    }

    /**
     * C1
     *
     * @param
     * @return
     */
    private static Map createCBC1() {
        Map data = new HashMap();
        Long LI_HVACCB_B1 = getValue("port0x3b4", "LI_HVACCB_C1");
        data.put("HVACCB", LI_HVACCB_B1 == 1 ? "true" : "false");
        Long LI_ELCB_C1 = getValue("port0x3b4", "LI_ELCB_C1");
        data.put("ELCB", LI_ELCB_C1 == 1 ? "true" : "false");
        Long LI_BCECB1_C1 = getValue("port0x3c4", "LI_BCECB1_C1");
        data.put("BCECB1", LI_BCECB1_C1 == 1 ? "true" : "false");
        Long LI_BCECB2_C1 = getValue("port0x3c4", "LI_BCECB2_C1");
        data.put("BCECB2", LI_BCECB2_C1 == 1 ? "true" : "false");
        Long LI_SCUCB12_C1 = getValue("port0x3c4", "LI_SCUCB12_C1");
        data.put("SCUCB12", LI_SCUCB12_C1 == 1 ? "true" : "false");
        Long LI_PCECB1_C1 = getValue("port0x3b4", "LI_PCECB1_C1");
        data.put("PCECB1", LI_PCECB1_C1 == 1 ? "true" : "false");
        Long LI_PCECB2_C1 = getValue("port0x3c4", "LI_PCECB2_C1");
        data.put("PCECB2", LI_PCECB2_C1 == 1 ? "true" : "false");

        return data;
    }

    /**
     * C2
     *
     * @param
     * @return
     */
    private static Map createCBC2() {
        Map data = new HashMap();
        Long LI_HVACCB_B1 = getValue("port0x3d4", "LI_HVACCB_C2");
        data.put("HVACCB", LI_HVACCB_B1 == 1 ? "true" : "false");
        Long LI_EBTLCB_C2 = getValue("port0x3e4", "LI_EBTLCB_C2");
        data.put("EBTLCB", LI_EBTLCB_C2 == 1 ? "true" : "false");
        Long LI_ELCB_C2 = getValue("port0x3d4", "LI_ELCB_C2");
        data.put("ELCB", LI_ELCB_C2 == 1 ? "true" : "false");
        Long LI_BCECB1_C2 = getValue("port0x3e4", "LI_BCECB1_C2");
        data.put("BCECB1", LI_BCECB1_C2 == 1 ? "true" : "false");
        Long LI_BCECB2_C2 = getValue("port0x3e4", "LI_BCECB2_C2");
        data.put("BCECB2", LI_BCECB2_C2 == 1 ? "true" : "false");
        Long LI_SCUCB12_C2 = getValue("port0x3e4", "LI_SCUCB12_C2");
        data.put("SCUCB12", LI_SCUCB12_C2 == 1 ? "true" : "false");
        Long LI_BATCB_C2 = getValue("port0x3e4", "LI_BATCB_C2");
        data.put("BATCB", LI_BATCB_C2 == 1 ? "true" : "false");
        Long LI_AICB_C2 = getValue("port0x3d4", "LI_AICB_C2");
        data.put("AICB", LI_AICB_C2 == 1 ? "true" : "false");
        Long LI_PCECB1_C2 = getValue("port0x3d4", "LI_PCECB1_C2");
        data.put("PCECB1", LI_PCECB1_C2 == 1 ? "true" : "false");
        Long LI_PCECB2_C2 = getValue("port0x3e4", "LI_PCECB2_C2");
        data.put("PCECB2", LI_PCECB2_C2 == 1 ? "true" : "false");
        Long LI_PTCB_B2 = getValue("port0x3f4", "LI_PTCB_B2");
        data.put("PTCB", LI_PTCB_B2 == 1 ? "true" : "false");
        Long LI_RPTCB_B2 = getValue("port0x3f4", "LI_RPTCB_B2");
        data.put("RPTCB", LI_RPTCB_B2 == 1 ? "true" : "false");
        Long LI_ELDKCB_B2 = getValue("port0x3f4", "LI_ELDKCB_B2");
        data.put("ELDKCB", LI_ELDKCB_B2 == 1 ? "true" : "false");
        Long LI_KAUXCB1_C2 = getValue("port0x3d4", "LI_KAUXCB1_C2");
        data.put("KAUXCB1", LI_KAUXCB1_C2 == 1 ? "true" : "false");
        Long LI_KAUXCB2_C2 = getValue("port0x3e4", "LI_KAUXCB2_C2");
        data.put("KAUXCB2", LI_KAUXCB2_C2 == 1 ? "true" : "false");

        return data;
    }

    /**
     * B2
     *
     * @param
     * @return
     */
    private static Map createCBB2() {
        Map data = new HashMap();
        Long LI_HVACCB_B1 = getValue("port0x3f4", "LI_HVACCB_B2");
        data.put("HVACCB", LI_HVACCB_B1 == 1 ? "true" : "false");
        Long LI_EBTLCB_B2 = getValue("port0x404", "LI_EBTLCB_B2");
        data.put("EBTLCB", LI_EBTLCB_B2 == 1 ? "true" : "false");
        Long LI_ELCB_B2 = getValue("port0x3f4", "LI_ELCB_B2");
        data.put("ELCB", LI_ELCB_B2 == 1 ? "true" : "false");
        Long LI_BCECB1_B2 = getValue("port0x404", "LI_BCECB1_B2");
        data.put("BCECB1", LI_BCECB1_B2 == 1 ? "true" : "false");
        Long LI_BCECB2_B2 = getValue("port0x404", "LI_BCECB2_B2");
        data.put("BCECB2", LI_BCECB2_B2 == 1 ? "true" : "false");
        Long LI_SCUCB12_B2 = getValue("port0x404", "LI_SCUCB12_B2");
        data.put("SCUCB12", LI_SCUCB12_B2 == 1 ? "true" : "false");
        Long LI_LPTCB_B2 = getValue("port0x3f4", "LI_LPTCB_B2");
        data.put("LPTCB", LI_LPTCB_B2 == 1 ? "true" : "false");
        Long LI_PCECB1_B2 = getValue("port0x3f4", "LI_PCECB1_B2");
        data.put("PCECB1", LI_PCECB1_B2 == 1 ? "true" : "false");
        Long LI_PCECB2_B2 = getValue("port0x404", "LI_PCECB2_B2");
        data.put("PCECB2", LI_PCECB2_B2 == 1 ? "true" : "false");
        Long LI_PTCB_B2 = getValue("port0x3f4", "LI_PTCB_B2");
        data.put("PTCB", LI_PTCB_B2 == 1 ? "true" : "false");
        Long LI_RPTCB_B2 = getValue("port0x3f4", "LI_RPTCB_B2");
        data.put("RPTCB", LI_RPTCB_B2 == 1 ? "true" : "false");
        Long LI_ELDKCB_B2 = getValue("port0x3f4", "LI_ELDKCB_B2");
        data.put("ELDKCB", LI_ELDKCB_B2 == 1 ? "true" : "false");
        return data;
    }

    /**
     * A2
     *
     * @param
     * @return
     */
    private static Map createCBA2() {
        Map data = new HashMap();
        Long LI_PANTCB_A1 = getValue("port0x434", "LI_PANTCB_A2");
        data.put("PANTCB", LI_PANTCB_A1 == 1 ? "true" : "false");
        Long LI_PECB_A2 = getValue("port0x434", "LI_PECB_A2");
        data.put("PECB", LI_PECB_A2 == 1 ? "true" : "false");
        Long LI_MACB_A2 = getValue("port0x434", "LI_MACB_A2");
        data.put("MACB", LI_MACB_A2 == 1 ? "true" : "false");
        Long LI_HVACCB_A2 = getValue("port0x434", "LI_HVACCB_A2");
        data.put("HVACCB", LI_HVACCB_A2 == 1 ? "true" : "false");
        Long LI_FCUCB_A2 = getValue("port0x444", "LI_FCUCB_A2");
        data.put("FCUCB", LI_FCUCB_A2 == 1 ? "true" : "false");
        Long LI_DDOCB_A2 = getValue("port0x414", "LI_DDOCB_A2");
        data.put("DDOCB", LI_DDOCB_A2 == 1 ? "true" : "false");
        Long LI_EEDCB_A2 = getValue("port0x434", "LI_EEDCB_A2");
        data.put("EEDCB", LI_EEDCB_A2 == 1 ? "true" : "false");
        Long LI_DOTLRCB_A2 = getValue("port0x434", "LI_DOTLRCB_A2");
        data.put("DOTLRCB", LI_DOTLRCB_A2 == 1 ? "true" : "false");
        Long LI_DCLRCB_A2 = getValue("port0x424", "LI_DCLRCB_A2");
        data.put("DCLRCB", LI_DCLRCB_A2 == 1 ? "true" : "false");
        Long LI_HDLRCB_A2 = getValue("port0x424", "LI_HDLRCB_A2");
        data.put("HDLRCB", LI_HDLRCB_A2 == 1 ? "true" : "false");
        Long LI_EBTLCB_A2 = getValue("port0x434", "LI_EBTLCB_A2");
        data.put("EBTLCB", LI_EBTLCB_A2 == 1 ? "true" : "false");
        Long LI_EBTLCB1_A2 = getValue("port0x434", "LI_EBTLCB1_A2");
        data.put("EBTLCB1", LI_EBTLCB1_A2 == 1 ? "true" : "false");
        Long LI_EBCB_A2 = getValue("port0x434", "LI_EBCB_A2");
        data.put("EBCB", LI_EBCB_A2 == 1 ? "true" : "false");
        Long LI_HLDBHLI_A2 = getValue("port0x434", "LI_HLDBHLI_A2");
        data.put("HLDBHLI", LI_HLDBHLI_A2 == 1 ? "true" : "false");
        Long LI_RHCB_A2 = getValue("port0x424", "LI_RHCB_A2");
        data.put("RHCB", LI_RHCB_A2 == 1 ? "true" : "false");
        Long LI_MCCB_A2 = getValue("port0x434", "LI_MCCB_A2");
        data.put("MCCB", LI_MCCB_A2 == 1 ? "true" : "false");
        Long LI_MCPERCB_A2 = getValue("port0x414", "LI_MCPERCB_A2");
        data.put("MCPERCB", LI_MCPERCB_A2 == 1 ? "true" : "false");
        Long LI_EMTCB_A2 = getValue("port0x414", "LI_EMTCB_A2");
        data.put("EMTCB", LI_EMTCB_A2 == 1 ? "true" : "false");
        Long LI_WUSLCB_A2 = getValue("port0x424", "LI_WUSLCB_A2");
        data.put("WUSLCB", LI_WUSLCB_A2 == 1 ? "true" : "false");
        Long LI_CORCB_A2 = getValue("port0x434", "LI_CORCB_A2");
        data.put("CORCB", LI_CORCB_A2 == 1 ? "true" : "false");
        Long LI_CMCCB_A2 = getValue("port0x454", "LI_CMCCB_A2");
        data.put("CMCCB", LI_CMCCB_A2 == 1 ? "true" : "false");
        Long LI_ZVRCB_A2 = getValue("port0x444", "LI_ZVRCB_A2");
        data.put("ZVRCB", LI_ZVRCB_A2 == 1 ? "true" : "false");
        Long LI_ELCB_A2 = getValue("port0x444", "LI_ELCB_A2");
        data.put("ELCB", LI_ELCB_A2 == 1 ? "true" : "false");
        Long LI_FLICB_A2 = getValue("port0x434", "LI_FLICB_A2");
        data.put("FLICB", LI_FLICB_A2 == 1 ? "true" : "false");
        Long LI_DZVRCB12_A2 = getValue("port0x434", "LI_DZVRCB12_A2");
        data.put("DZVRCB12", LI_DZVRCB12_A2 == 1 ? "true" : "false");
        Long LI_BSCB_A2 = getValue("port0x444", "LI_BSCB_A2");
        data.put("BSCB", LI_BSCB_A2 == 1 ? "true" : "false");
        Long LI_PBCB_A2 = getValue("port0x424", "LI_PBCB_A2");
        data.put("PBCB", LI_PBCB_A2 == 1 ? "true" : "false");
        Long LI_TSKCB_A2 = getValue("port0x424", "LI_TSKCB_A2");
        data.put("TSKCB", LI_TSKCB_A2 == 1 ? "true" : "false");
        Long LI_PCUCB_A2 = getValue("port0x424", "LI_PCUCB_A2");
        data.put("PCUCB", LI_PCUCB_A2 == 1 ? "true" : "false");
        Long LI_TLICB_A2 = getValue("port0x414", "LI_TLICB_A2");
        data.put("TLICB", LI_TLICB_A2 == 1 ? "true" : "false");
        Long LI_BCECB1_A2 = getValue("port0x444", "LI_BCECB1_A2");
        data.put("BCECB1", LI_BCECB1_A2 == 1 ? "true" : "false");
        Long LI_BCECB2_A2 = getValue("port0x444", "LI_BCECB2_A2");
        data.put("BCECB2", LI_BCECB2_A2 == 1 ? "true" : "false");
        Long LI_SCUCB12_A2 = getValue("port0x424", "LI_SCUCB12_A2");
        data.put("SCUCB12", LI_SCUCB12_A2 == 1 ? "true" : "false");
        Long LI_BATCB_A2 = getValue("port0x424", "LI_BATCB_A2");
        data.put("BATCB", LI_BATCB_A2 == 1 ? "true" : "false");
        Long LI_AICB_A2 = getValue("port0x444", "LI_AICB_A2");
        data.put("AICB", LI_AICB_A2 == 1 ? "true" : "false");
        Long LI_ISCB_A2 = getValue("port0x424", "LI_ISCB_A2");
        data.put("ISCB", LI_ISCB_A2 == 1 ? "true" : "false");
        Long LI_DRTLRCB_A2 = getValue("port0x414", "LI_DRTLRCB_A2");
        data.put("DRTLRCB", LI_DRTLRCB_A2 == 1 ? "true" : "false");
        Long LI_DCTLRCB_A2 = getValue("port0x414", "LI_DCTLRCB_A2");
        data.put("DCTLRCB", LI_DCTLRCB_A2 == 1 ? "true" : "false");
        return data;
    }

}
