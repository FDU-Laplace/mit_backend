package com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.metro.domain.Line;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.LineDto;

/**
 * 
 * @ClassName: LineWarpper
 * @Description: Line的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class LineWarpper extends BaseWarpper {
	public LineWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Line) {
			LineDto lineDto = new LineDto();
			Line line = (Line) entity;
			lineDto.setId(line.getUuid());
			lineDto.setLineId(line.getLineId());
			lineDto.setLineType(line.getLineType());
			lineDto.setLineColor(line.getLineColor());
			lineDto.setLineName(line.getLineName());
			lineDto.setLineNameEn(line.getLineNameEn());
			lineDto.setLineNum(line.getLineNum());
			lineDto.setLineCode(line.getLineCode());
			lineDto.setIsRun(line.getIsRun());
			lineDto.setCompany(line.getCompany());
			lineDto.setTrains(line.getTrains());
			lineDto.setCreateTime(line.getCreateTime());
			lineDto.setUpdateTime(line.getUpdateTime());
			lineDto.setCreateUserName(ConstantFactory.me().getUserNameById(line.getCreateUserId()));
			lineDto.setUpdateUserName(ConstantFactory.me().getUserNameById(line.getUpdateUserId()));
			return lineDto;
		}
		return null;
	}
}
