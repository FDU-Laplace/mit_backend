package com.missiongroup.starring.modular.vhis.metro.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.StationDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.Station;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.StationDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.StationWarpper;
import com.missiongroup.starring.modular.vhis.metro.service.StationService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: StationController
 * @Description: ?????????????????????
 * @author xuwei
 * @date 2020???2???4??? ??????3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "????????????????????????")
@Controller
@RequestMapping("/StationCtl")
public class StationController extends BaseController {
	@Autowired
	StationService StationService;

    @ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "Station", value = "vhis????????????", required = true, dataType = "Station")
	@PostMapping(value = "/Station")
	@BussinessLog(value = "??????vhis????????????", key = "stationId,stationName,stationNameEn,stationNameSpell", dict = StationDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Station Station, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Station.setCreateTime(new Date());
		Station.setCreateUserId(ShiroKit.getUser().getId());
		Station.setUpdateTime(new Date());
		Station.setUpdateUserId(ShiroKit.getUser().getId());
		StationService.save(Station);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????ID??????vhis????????????")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Station", value = "vhis????????????", required = true, dataType = "StationDto")//
	})
	@PutMapping(value = "/Station/{id}")
	@BussinessLog(value = "??????vhis????????????", key = "stationId,stationName,stationNameEn,stationNameSpell", dict = StationDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Station Station, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Station.setUuid(id);
		Station cacheStation = (Station) LogObjectHolder.me().get();
		
		cacheStation.setStationId(Station.getStationId());
		cacheStation.setStationName(Station.getStationName());
		cacheStation.setStationNameEn(Station.getStationNameEn());
		cacheStation.setStationNameSpell(Station.getStationNameSpell());
		cacheStation.setUpdateTime(new Date());
		cacheStation.setUpdateUserId(ShiroKit.getUser().getId());
		cacheStation = StationService.save(cacheStation);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "ids", value = "vhis??????ID??????", required = true, dataType = "String")
	@DeleteMapping(value = "/Station/{ids}")
	@BussinessLog(value = "??????vhis????????????", key = "ids", dict = StationDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		StationService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????ID??????vhis????????????")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Station/{id}")
	@ResponseBody
	public Object getStationById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Station Station = StationService.findOneByUuid(id);
		LogObjectHolder.me().set(Station);
		return Station;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "pageParam", value = "??????????????????", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Station> StationList = StationService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(StationList);
		pageResult.setRows((List<StationDto>) new StationWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "??????vhis??????????????????", notes = "??????vhis??????????????????")
	@GetMapping(value = "/Stations")
	@ResponseBody
	public Object findAll() {
		List<Station> StationList = StationService.findAll();
		return  new StationWarpper(StationList).warp();
	}
}
