package com.missiongroup.starring.modular.vhis.data.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.data.domain.Iscs;
import com.missiongroup.starring.modular.vhis.data.domain.dto.IscsDto;

/**
 * 
 * @ClassName: IscsWarpper
 * @Description: Iscs的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class IscsWarpper extends BaseWarpper {
	public IscsWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Iscs) {
			IscsDto iscsDto = new IscsDto();
			Iscs iscs = (Iscs) entity;
			iscsDto.setId(iscs.getUuid());
			iscsDto.setTrainnum(iscs.getTrainnum());
			iscsDto.setMvbdata(iscs.getMvbdata());
			iscsDto.setRecordtime(iscs.getRecordtime());
			iscsDto.setCreateTime(iscs.getCreateTime());
			iscsDto.setUpdateTime(iscs.getUpdateTime());
			iscsDto.setCreateUserName(ConstantFactory.me().getUserNameById(iscs.getCreateUserId()));
			iscsDto.setUpdateUserName(ConstantFactory.me().getUserNameById(iscs.getUpdateUserId()));
			return iscsDto;
		}
		return null;
	}
}
