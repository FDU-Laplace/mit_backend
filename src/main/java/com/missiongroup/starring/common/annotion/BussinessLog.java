package com.missiongroup.starring.common.annotion;

import java.lang.annotation.*;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;
import com.missiongroup.starring.common.constant.dictmap.base.SystemDict;

/**
 * 标记需要做业务日志的方法
 *
 * @author mission
 * @date 2017-03-31 12:46
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {
    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "";

    /**
     * 字典(用于查找key的中文名称和字段的中文名称)
     */
    Class<? extends AbstractDictMap> dict() default SystemDict.class;
}
