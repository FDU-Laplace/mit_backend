package com.missiongroup.starring.core.util;

import com.missiongroup.starring.config.properties.StarringProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     *
     * @author mission
     * @Date 2017/5/23 22:34
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(StarringProperties.class).getKaptchaOpen();
    }
}