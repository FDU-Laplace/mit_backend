package com.missiongroup.starring.core.base.warpper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BaseWarpper
 * @Description: 控制器查询结果的包装类基类
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:22:54
 *
 */
public abstract class BaseWarpper {
	public Object obj = null;

	public BaseWarpper(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public Object warp() {
		if (this.obj instanceof List) {
			List<Object> resultList = new ArrayList<Object>();
			List<Object> list = (List<Object>) this.obj;
			if (null != list && list.size() > 0) {
				for (Object entity : list) {
					resultList.add(warpTheEntity(entity));
				}
			}
			return resultList;
		} else if (this.obj instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) this.obj;
			warpTheMap(map);
			return map;
		} else {
			return this.obj;
		}
	}

	protected abstract Object warpTheEntity(Object entity);

	protected abstract void warpTheMap(Map<String, Object> map);
}
