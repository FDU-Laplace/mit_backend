package com.missiongroup.starring.common.constant.state;

/**
 * 类型字节枚举
 *
 * @author mission
 * @date 2017年3月5日 上午10:15:02
 */
public enum ByteEnum {
    b4("b4", 32),
    b3("b3",16),
    b2("b2", 8),
    b1("b1", 4),
    b0("b0", 0);

    String code;
    int length;

    ByteEnum(String code, int length) {
        this.code = code;
        this.length = length;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public static int getValue(String code) {
        if (code == null) {
            return 0;
        } else {
            for (ByteEnum s : ByteEnum.values()) {
                if (s.getCode() .equals(code)) {
                    return s.getLength();
                }
            }
            return 0;
        }
    }
}