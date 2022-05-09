package com.missiongroup.starring.modular.system.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.system.domain.Depart;
import com.missiongroup.starring.modular.system.domain.dto.DepartDto;

/**
 * 
 * @ClassName: DepartWarpper
 * @Description: 部门列表的包装
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午2:27:08
 *
 */
public class DepartWarpper extends BaseWarpper {
	public DepartWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Depart) {
			DepartDto departDto = new DepartDto();
			Depart depart = (Depart) entity;
			departDto.setId(depart.getUuid());
			departDto.setSort(depart.getSort());
			departDto.setParentId(depart.getParentId());
			departDto.setParentIds(depart.getParentIds());
			departDto.setName(depart.getName());
			departDto.setCreateTime(depart.getCreateTime());
			departDto.setUpdateTime(depart.getUpdateTime());
			departDto.setCreateUserId(depart.getCreateUserId());
			departDto.setUpdateUserId(depart.getUpdateUserId());
			departDto.setLabel(depart.getName());
			departDto.setValue(depart.getUuid());
			return departDto;
		}
		return null;
	}
}
