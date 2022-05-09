package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 菜单的字典
 *
 * @author mission
 * @date 2017-05-06 15:01
 */
public class MenuDict extends AbstractDictMap {

    @Override
    public void init() {
        put("menuIds","菜单名称");
        put("id","菜单id");
        put("code","菜单编号");
        put("parentId","父菜单");
        put("name","菜单名称");
        put("icon","菜单图标");
        put("url","url地址");
        put("num","菜单排序号");
        put("levels","菜单层级");
        put("remark","备注");
        put("status","菜单状态");
        put("type","菜单类型");
        put("isopen","是否打开");
        put("sorts","菜单序号");
        put("","");
    }

    @Override
    protected void initBeWrapped() {
    	putFieldWrapperMethodName("status","getMenuStatusName");
    	putFieldWrapperMethodName("type","getMenuTypeName");
    	putFieldWrapperMethodName("menuIds","getMenuNames");
    }
}
