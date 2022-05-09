package com.missiongroup.starring.common.constant.state;

/**
 * 
 * 类型字节枚举
 *
 * @author mission
 * @date 2017年3月5日 上午10:15:02
 */
public enum TypeEnum {
    BOOL("BOOL", "TINYINT"),
    BOOLEAN1("BOOLEAN1","TINYINT"),

    UNSIGNED8("UNSIGNED8", "INT"),
    BYTE("BYTE", "INT"),
    INTEGER8("INTEGER8", "INT"),

    UNSIGNED16("UNSIGNED16", "INT"),
    WORD("WORD", "INT"),
    INTEGER16("INTEGER16", "INT"),
    INT("INT", "INT"),

    UNSIGNED32("UNSIGNED32", "BIGINT"),
    DWORD("DWORD", "BIGINT"),
    INTEGER32("INTEGER32", "BIGINT"),
    REAL32("REAL32", "BIGINT"),
    SINT("SINT", "INT"),
    CHAR("CHAR", "INT");
    String code;
    String taosType;

    TypeEnum(String code, String taosType) {
        this.code = code;
        this.taosType = taosType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTaosType() {
        return taosType;
    }

    public void setTaosType(String taosType) {
        this.taosType = taosType;
    }

    public static String getValue(String code) {
        if (code == null) {
            return "";
        } else {
            for (TypeEnum s : TypeEnum.values()) {
                if (s.getCode() .equals(code)) {
                    return s.getTaosType();
                }
            }
            return "";
        }
    }
}
