package com.missiongroup.starring.common.constant.state;

/**
 * 类型字节枚举
 *
 * @author mission
 * @date 2017年3月5日 上午10:15:02
 */
public enum PortEnum {
    p0x100("3100","0x100"),
    p0x101("3101","0x101"),
    p0x120("4120","0x120"),

    p0x121("4121", "0x121"),
    p0x122("4122", "0x122"),
    p0x123("4123", "0x123"),
    p0x124("4124", "0x124"),
    p0x125("4125", "0x125"),
    p0x126("4126", "0x126"),
    p0x127("4127", "0x127"),
    p0x128("4128", "0x128"),
    p0x129("4129", "0x129"),
    p0x130("4130", "0x130"),
    p0x131("4131", "0x131"),
    p0x132("4132", "0x132"),
    p0x133("4133", "0x133"),
    p0x134("4134", "0x134"),
    p0x135("4135", "0x135"),
    p0x136("4136", "0x136"),
    p0x137("4137", "0x137"),
    p0x800("4800", "0x800"),
    p0x801("4801", "0x801"),
    p0x802("4802", "0x802"),
    p0x803("3803", "0x803");
    //p0x3a0("43a0", "0x3A0");
    //p0x880("4880", "0x880"),
    //p0x890("4890", "0x890");
    String code;
    String portName;

    PortEnum(String code, String portName) {
        this.code = code;
        this.portName = portName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public static String getValue(String code) {
        if (code == null) {
            return "";
        } else {
            for (PortEnum s : PortEnum.values()) {
                if (s.getCode().equals(code)) {
                    return s.getPortName();
                }
            }
            return "";
        }
    }
}
