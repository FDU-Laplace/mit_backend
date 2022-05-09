package com.missiongroup.starring.modular.system.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.domain.dto.UserDto;

/**
 * 用户管理的包装类
 *
 * @author mission
 * @date 2017年2月13日 下午10:47:03
 */
public class UserWarpper extends BaseWarpper {
	public UserWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof User) {
			User user = (User) entity;
			UserDto userDto = new UserDto();
			userDto.setId(user.getUuid());
			userDto.setName(user.getName());
			userDto.setAccount(user.getAccount());
			userDto.setSex(user.getSex());
			userDto.setPhone(user.getPhone());
			userDto.setEmail(user.getEmail());
			userDto.setStatus(user.getStatus());
			if(user.getDepartId()!=null){
				userDto.setDepartName(ConstantFactory.me().getDepartName(user.getDepartId()));
			}
			userDto.setCreateTime(user.getCreateTime());
			userDto.setCreateUserName(ConstantFactory.me().getUserNameById(user.getCreateUserId()));
			userDto.setUpdateTime(user.getUpdateTime());
			userDto.setUpdateUserName(ConstantFactory.me().getUserAccountById(user.getUpdateUserId()));
			userDto.setRoleNames(ConstantFactory.me().getRoleNames(user.getRoleIds()));
			return userDto;
		}
		return null;
	}
}
