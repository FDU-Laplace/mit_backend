package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 日志的字典
 *
 * @author mission
 * @date 2017-05-06 15:01
 */
public class LevelConfigDict extends AbstractDictMap {

    @Override
    public void init() {
        put("ids","等级配置列表");
        put("id","等级配置id");
        put("color","字体颜色");
        put("faultLevel","故障等级");
        put("levelName","等级名称");
        put("twinkle","是否闪烁");
        put("voice","是否有声音");
    }

    @Override
    protected void initBeWrapped() {

    }
}
