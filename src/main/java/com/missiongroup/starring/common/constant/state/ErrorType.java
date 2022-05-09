package com.missiongroup.starring.common.constant.state;

/**
 * 菜单的类型
 *
 * @author mission
 * @Date 2017年1月22日 下午12:14:59
 */
public enum ErrorType {

    NO_LOGIN("noLogin", "用户未登陆"),
    NO_PERMISSION("noPermission", "无权限访问");

    String code;
    String message;

    ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public static String getValue(String status) {
        if (status == null) {
            return "";
        } else {
            for (ErrorType s : ErrorType.values()) {
                if (s.getCode().equals(status) ) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }

}
