package com.missiongroup.starring.modular.vhis.pushDate.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.pushDate.TrainDataDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.pushDate.domain.TrainData;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.TrainDataDto;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.warpper.TrainDataWarpper;
import com.missiongroup.starring.modular.vhis.pushDate.service.TrainDataService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: TrainDataController
 * @Description: 列车数据控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/TrainDataCtl")
public class TrainDataController extends BaseController {
	@Autowired
	TrainDataService TrainDataService;

    @ApiOperation(value = "新增列车数据信息", notes = "新增列车数据信息")
	@ApiImplicitParam(name = "TrainData", value = "列车数据信息", required = true, dataType = "TrainData")
	@PostMapping(value = "/TrainData")
	@BussinessLog(value = "新增列车数据信息", key = "ts_timestamp,lineId,trainId,status,theoreticalReception,ctualReception,acceptanceRate,location,trian_speed,trian_net_voltage,trian_wind_pressure,trian_brake_pressure,trian_battery_voltage,trian_broadcast_mode,trian_run_mode,trian_control_mode,trian_unit_energy,trian_total_energy,trian_current_station,trian_next_station,trian_terminus,trian_RxLev,trian_delivery_channel,trian_commissioning,trian_main_line", dict = TrainDataDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody TrainData TrainData, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		TrainData.setCreateTime(new Date());
		TrainData.setCreateUserId(ShiroKit.getUser().getId());
		TrainData.setUpdateTime(new Date());
		TrainData.setUpdateUserId(ShiroKit.getUser().getId());
		TrainDataService.save(TrainData);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改列车数据信息", notes = "根据ID修改列车数据信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "TrainData", value = "列车数据信息", required = true, dataType = "TrainDataDto")//
	})
	@PutMapping(value = "/TrainData/{id}")
	@BussinessLog(value = "修改列车数据信息", key = "ts_timestamp,lineId,trainId,status,theoreticalReception,ctualReception,acceptanceRate,location,trian_speed,trian_net_voltage,trian_wind_pressure,trian_brake_pressure,trian_battery_voltage,trian_broadcast_mode,trian_run_mode,trian_control_mode,trian_unit_energy,trian_total_energy,trian_current_station,trian_next_station,trian_terminus,trian_RxLev,trian_delivery_channel,trian_commissioning,trian_main_line", dict = TrainDataDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody TrainData TrainData, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		TrainData.setUuid(id);
		TrainData cacheTrainData = (TrainData) LogObjectHolder.me().get();
		
		cacheTrainData.setTs_timestamp(TrainData.getTs_timestamp());
		cacheTrainData.setLineId(TrainData.getLineId());
		cacheTrainData.setTrainId(TrainData.getTrainId());
		cacheTrainData.setStatus(TrainData.getStatus());
		cacheTrainData.setTheoreticalReception(TrainData.getTheoreticalReception());
		cacheTrainData.setCtualReception(TrainData.getCtualReception());
		cacheTrainData.setAcceptanceRate(TrainData.getAcceptanceRate());
		cacheTrainData.setLocation(TrainData.getLocation());
		cacheTrainData.setTrian_speed(TrainData.getTrian_speed());
		cacheTrainData.setTrian_net_voltage(TrainData.getTrian_net_voltage());
		cacheTrainData.setTrian_wind_pressure(TrainData.getTrian_wind_pressure());
		cacheTrainData.setTrian_brake_pressure(TrainData.getTrian_brake_pressure());
		cacheTrainData.setTrian_battery_voltage(TrainData.getTrian_battery_voltage());
		cacheTrainData.setTrian_broadcast_mode(TrainData.getTrian_broadcast_mode());
		cacheTrainData.setTrian_run_mode(TrainData.getTrian_run_mode());
		cacheTrainData.setTrian_control_mode(TrainData.getTrian_control_mode());
		cacheTrainData.setTrian_unit_energy(TrainData.getTrian_unit_energy());
		cacheTrainData.setTrian_total_energy(TrainData.getTrian_total_energy());
		cacheTrainData.setTrian_current_station(TrainData.getTrian_current_station());
		cacheTrainData.setTrian_next_station(TrainData.getTrian_next_station());
		cacheTrainData.setTrian_terminus(TrainData.getTrian_terminus());
		cacheTrainData.setTrian_RxLev(TrainData.getTrian_RxLev());
		cacheTrainData.setTrian_delivery_channel(TrainData.getTrian_delivery_channel());
		cacheTrainData.setTrian_commissioning(TrainData.getTrian_commissioning());
		cacheTrainData.setTrian_main_line(TrainData.getTrian_main_line());
		cacheTrainData.setUpdateTime(new Date());
		cacheTrainData.setUpdateUserId(ShiroKit.getUser().getId());
		cacheTrainData = TrainDataService.save(cacheTrainData);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除列车数据信息", notes = "删除列车数据信息")
	@ApiImplicitParam(name = "ids", value = "列车数据ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/TrainData/{ids}")
	@BussinessLog(value = "删除列车数据信息", key = "ids", dict = TrainDataDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		TrainDataService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询列车数据信息", notes = "根据ID获取列车数据信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/TrainData/{id}")
	@ResponseBody
	public Object getTrainDataById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		TrainData TrainData = TrainDataService.findOneByUuid(id);
		LogObjectHolder.me().set(TrainData);
		return TrainData;
	}
	
	@ApiOperation(value = "查询列车数据列表", notes = "查询列车数据列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<TrainData> TrainDataList = TrainDataService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(TrainDataList);
		pageResult.setRows((List<TrainDataDto>) new TrainDataWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询列车数据所有列表", notes = "查询列车数据所有列表")
	@GetMapping(value = "/TrainDatas")
	@ResponseBody
	public Object findAll() {
		List<TrainData> TrainDataList = TrainDataService.findAll();
		return  new TrainDataWarpper(TrainDataList).warp();
	}
}
