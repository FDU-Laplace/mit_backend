package com.missiongroup.starring.modular.system.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.domain.dto.RoleDto;

/**
 * 
 * @ClassName: RoleWarpper
 * @Description: 角色实体的包装类
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午9:44:05
 *
 */
public class RoleWarpper extends BaseWarpper {
	public RoleWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Role) {
			RoleDto roleDto = new RoleDto();
			Role role = (Role) entity;
			roleDto.setId(role.getUuid());
			roleDto.setSort(role.getSort());
			roleDto.setName(role.getName());
			if(role.getDepartId()!=null){
				roleDto.setDepartId(role.getDepartId());
			}
			roleDto.setRemark(role.getRemark());
			roleDto.setCreateTime(role.getCreateTime());
			roleDto.setUpdateTime(role.getUpdateTime());
			roleDto.setCreateUserId(role.getCreateUserId());
			roleDto.setUpdateUserId(role.getUpdateUserId());
			if(role.getDepartId()!=null){
				roleDto.setDepartName(ConstantFactory.me().getDepartName(role.getDepartId()));
			}
			return roleDto;
		}
		return null;
	}
}
