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
import com.missiongroup.starring.common.constant.dictmap.pushDate.CarriageDataDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.pushDate.domain.CarriageData;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.CarriageDataDto;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.warpper.CarriageDataWarpper;
import com.missiongroup.starring.modular.vhis.pushDate.service.CarriageDataService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: CarriageDataController
 * @Description: 车厢数据控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/CarriageDataCtl")
public class CarriageDataController extends BaseController {
	@Autowired
	CarriageDataService CarriageDataService;

    @ApiOperation(value = "新增车厢数据信息", notes = "新增车厢数据信息")
	@ApiImplicitParam(name = "CarriageData", value = "车厢数据信息", required = true, dataType = "CarriageData")
	@PostMapping(value = "/CarriageData")
	@BussinessLog(value = "新增车厢数据信息", key = "ts_timestamp,carriageId,carriageNum,trianId,lineId,dricab_activate,dricab_wall_door,dricab_escape_door,riding_rate,brake_state,compartment_temperature,humidity,traction", dict = CarriageDataDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody CarriageData CarriageData, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageData.setCreateTime(new Date());
		CarriageData.setCreateUserId(ShiroKit.getUser().getId());
		CarriageData.setUpdateTime(new Date());
		CarriageData.setUpdateUserId(ShiroKit.getUser().getId());
		CarriageDataService.save(CarriageData);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改车厢数据信息", notes = "根据ID修改车厢数据信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "CarriageData", value = "车厢数据信息", required = true, dataType = "CarriageDataDto")//
	})
	@PutMapping(value = "/CarriageData/{id}")
	@BussinessLog(value = "修改车厢数据信息", key = "ts_timestamp,carriageId,carriageNum,trianId,lineId,dricab_activate,dricab_wall_door,dricab_escape_door,riding_rate,brake_state,compartment_temperature,humidity,traction", dict = CarriageDataDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody CarriageData CarriageData, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageData.setUuid(id);
		CarriageData cacheCarriageData = (CarriageData) LogObjectHolder.me().get();
		
		cacheCarriageData.setTs_timestamp(CarriageData.getTs_timestamp());
		cacheCarriageData.setCarriageId(CarriageData.getCarriageId());
		cacheCarriageData.setCarriageNum(CarriageData.getCarriageNum());
		cacheCarriageData.setTrianId(CarriageData.getTrianId());
		cacheCarriageData.setLineId(CarriageData.getLineId());
		cacheCarriageData.setDricab_activate(CarriageData.getDricab_activate());
		cacheCarriageData.setDricab_wall_door(CarriageData.getDricab_wall_door());
		cacheCarriageData.setDricab_escape_door(CarriageData.getDricab_escape_door());
		cacheCarriageData.setRiding_rate(CarriageData.getRiding_rate());
		cacheCarriageData.setBrake_state(CarriageData.getBrake_state());
		cacheCarriageData.setCompartment_temperature(CarriageData.getCompartment_temperature());
		cacheCarriageData.setHumidity(CarriageData.getHumidity());
		cacheCarriageData.setTraction(CarriageData.getTraction());
		cacheCarriageData.setUpdateTime(new Date());
		cacheCarriageData.setUpdateUserId(ShiroKit.getUser().getId());
		cacheCarriageData = CarriageDataService.save(cacheCarriageData);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除车厢数据信息", notes = "删除车厢数据信息")
	@ApiImplicitParam(name = "ids", value = "车厢数据ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/CarriageData/{ids}")
	@BussinessLog(value = "删除车厢数据信息", key = "ids", dict = CarriageDataDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageDataService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询车厢数据信息", notes = "根据ID获取车厢数据信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/CarriageData/{id}")
	@ResponseBody
	public Object getCarriageDataById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageData CarriageData = CarriageDataService.findOneByUuid(id);
		LogObjectHolder.me().set(CarriageData);
		return CarriageData;
	}
	
	@ApiOperation(value = "查询车厢数据列表", notes = "查询车厢数据列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<CarriageData> CarriageDataList = CarriageDataService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(CarriageDataList);
		pageResult.setRows((List<CarriageDataDto>) new CarriageDataWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询车厢数据所有列表", notes = "查询车厢数据所有列表")
	@GetMapping(value = "/CarriageDatas")
	@ResponseBody
	public Object findAll() {
		List<CarriageData> CarriageDataList = CarriageDataService.findAll();
		return  new CarriageDataWarpper(CarriageDataList).warp();
	}
}
