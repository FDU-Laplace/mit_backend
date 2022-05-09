package com.missiongroup.starring.common.annotion;

import java.lang.annotation.*;

/**
 *
 *
 * @example @Permission({roleID1,roleID2})
 * @example @Permission
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Describe {
    String type() default "";
}
