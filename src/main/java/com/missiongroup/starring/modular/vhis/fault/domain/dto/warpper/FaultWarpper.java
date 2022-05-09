package com.missiongroup.starring.modular.vhis.fault.domain.dto.warpper;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.fault.domain.Fault;
import com.missiongroup.starring.modular.vhis.fault.domain.FaultHistory;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;

import java.util.Map;

/**
 * 
 * @ClassName: FaultWarpper
 * @Description: Fault的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class FaultWarpper extends BaseWarpper {
	public FaultWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Fault) {
			FaultDto FaultDto = new FaultDto();
			Fault Fault = (Fault) entity;
			FaultDto.setId(Fault.getUuid());
			FaultDto.setRelationLin(Fault.getRelationLin());
			FaultDto.setRelationTrain(Fault.getRelationTrain());
			FaultDto.setRelationCarriage(Fault.getRelationCarriage());
			FaultDto.setFaultSys(Fault.getFaultSys());
			FaultDto.setFaultCode(Fault.getFaultCode());
			FaultDto.setFaultName(Fault.getFaultName());
			FaultDto.setFaultLevel(Fault.getFaultLevel());
			FaultDto.setIsFault(Fault.getIsFault());
			FaultDto.setConfirmFault(Fault.getConfirmFault());
			FaultDto.setOccurrenceTime(Fault.getOccurrenceTime());
			FaultDto.setConfirmTime(Fault.getConfirmTime());
			FaultDto.setRemarks(Fault.getRemarks());
			FaultDto.setDuration(Fault.getDuration());
			FaultDto.setNextStation(Fault.getNextStation());
			FaultDto.setReleaseStatus(Fault.getReleaseStatus());
			FaultDto.setPushStatus(Fault.getPushStatus());
			FaultDto.setTrainType(Fault.getTrainType());
			FaultDto.setFaultType(Fault.getFaultType());
			FaultDto.setCurrentStation(Fault.getCurrentStation());
			FaultDto.setTrainPosition(Fault.getTrainPosition());
			FaultDto.setCreateTime(Fault.getCreateTime());
			FaultDto.setUpdateTime(Fault.getUpdateTime());
			FaultDto.setReleaseTime(Fault.getReleaseTime());
			FaultDto.setCreateUserName(ConstantFactory.me().getUserNameById(Fault.getCreateUserId()));
			FaultDto.setUpdateUserName(ConstantFactory.me().getUserNameById(Fault.getUpdateUserId()));
			return FaultDto;
		}
		if (entity instanceof FaultHistory) {
			FaultDto FaultDto = new FaultDto();
			FaultHistory FaultH = (FaultHistory) entity;
			FaultDto.setId(FaultH.getUuid());
			FaultDto.setRelationLin(FaultH.getRelationLin());
			FaultDto.setRelationTrain(FaultH.getRelationTrain());
			FaultDto.setRelationCarriage(FaultH.getRelationCarriage());
			FaultDto.setFaultSys(FaultH.getFaultSys());
			FaultDto.setFaultCode(FaultH.getFaultCode());
			FaultDto.setFaultName(FaultH.getFaultName());
			FaultDto.setFaultLevel(FaultH.getFaultLevel());
			FaultDto.setIsFault(FaultH.getIsFault());
			FaultDto.setConfirmFault(FaultH.getConfirmFault());
			FaultDto.setOccurrenceTime(FaultH.getOccurrenceTime());
			FaultDto.setConfirmTime(FaultH.getConfirmTime());
			FaultDto.setRemarks(FaultH.getRemarks());
			FaultDto.setDuration(FaultH.getDuration());
			FaultDto.setNextStation(FaultH.getNextStation());
			FaultDto.setReleaseStatus(FaultH.getReleaseStatus());
			FaultDto.setPushStatus(FaultH.getPushStatus());
			FaultDto.setTrainType(FaultH.getTrainType());
			FaultDto.setFaultType(FaultH.getFaultType());
			FaultDto.setCurrentStation(FaultH.getCurrentStation());
			FaultDto.setTrainPosition(FaultH.getTrainPosition());
			FaultDto.setCreateTime(FaultH.getCreateTime());
			FaultDto.setUpdateTime(FaultH.getUpdateTime());
			FaultDto.setReleaseTime(FaultH.getReleaseTime());
			FaultDto.setCreateUserName(ConstantFactory.me().getUserNameById(FaultH.getCreateUserId()));
			FaultDto.setUpdateUserName(ConstantFactory.me().getUserNameById(FaultH.getUpdateUserId()));
			return FaultDto;
		}
		return null;
	}
}
