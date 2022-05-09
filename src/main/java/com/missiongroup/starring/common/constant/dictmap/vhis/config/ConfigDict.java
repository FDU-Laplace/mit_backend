package com.missiongroup.starring.common.constant.dictmap.vhis.config;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: ConfigDict
 * @Description: 配置管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class ConfigDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "vhis配置ID");
		put("ids", "vhis配置ID列表");
		put("configCode", "配置键值对CODE");
		put("configValue", "配置键值对VALUE");
		put("remark", "备注");
		put("isCache", "是否需要缓存");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
