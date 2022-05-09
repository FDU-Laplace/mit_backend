package com.missiongroup.starring.common.constant.state;

/**
 * 菜单的类型
 *
 * @author mission
 * @Date 2017年1月22日 下午12:14:59
 */
public enum MenuType {

    BUTTON(1, "按钮"),
    MENU(0, "菜单");

    int code;
    String message;

    MenuType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (MenuType s : MenuType.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
