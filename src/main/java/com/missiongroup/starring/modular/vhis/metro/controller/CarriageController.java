package com.missiongroup.starring.modular.vhis.metro.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
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
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.CarriageDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.CarriageDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.CarriageWarpper;
import com.missiongroup.starring.modular.vhis.metro.service.CarriageService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: CarriageController
 * @Description: ?????????????????????
 * @author xuwei
 * @date 2020???2???4??? ??????3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "????????????????????????")
@Controller
@RequestMapping("/CarriageCtl")
public class CarriageController extends BaseController {
	@Autowired
	CarriageService CarriageService;

    @ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "Carriage", value = "vhis????????????", required = true, dataType = "Carriage")
	@PostMapping(value = "/Carriage")
	@BussinessLog(value = "??????vhis????????????", key = "relationLine,relationTrain,carriageId,carriageType,carriageName,carriageCode", dict = CarriageDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Carriage Carriage, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Carriage.setCreateTime(new Date());
		Carriage.setCreateUserId(ShiroKit.getUser().getId());
		Carriage.setUpdateTime(new Date());
		Carriage.setUpdateUserId(ShiroKit.getUser().getId());
		CarriageService.save(Carriage);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????ID??????vhis????????????")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Carriage", value = "vhis????????????", required = true, dataType = "CarriageDto")//
	})  
	@PutMapping(value = "/Carriage/{id}")
	@BussinessLog(value = "??????vhis????????????", key = "relationLine,relationTrain,carriageId,carriageType,carriageName,carriageCode", dict = CarriageDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Carriage Carriage, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Carriage.setUuid(id);
		Carriage cacheCarriage = (Carriage) LogObjectHolder.me().get();
		
		cacheCarriage.setRelationLine(Carriage.getRelationLine());
		cacheCarriage.setRelationTrain(Carriage.getRelationTrain());
		cacheCarriage.setCarriageId(Carriage.getCarriageId());
		cacheCarriage.setCarriageType(Carriage.getCarriageType());
		cacheCarriage.setCarriageName(Carriage.getCarriageName());
		cacheCarriage.setCarriageCode(Carriage.getCarriageCode());
		cacheCarriage.setUpdateTime(new Date());
		cacheCarriage.setUpdateUserId(ShiroKit.getUser().getId());
		cacheCarriage = CarriageService.save(cacheCarriage);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "ids", value = "vhis??????ID??????", required = true, dataType = "String")
	@DeleteMapping(value = "/Carriage/{ids}")
	@BussinessLog(value = "??????vhis????????????", key = "ids", dict = CarriageDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????ID??????vhis????????????")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Carriage/{id}")
	@ResponseBody
	public Object getCarriageById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Carriage Carriage = CarriageService.findOneByUuid(id);
		LogObjectHolder.me().set(Carriage);
		return Carriage;
	}
	
	@ApiOperation(value = "??????vhis????????????", notes = "??????vhis????????????")
	@ApiImplicitParam(name = "pageParam", value = "??????????????????", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Carriage> CarriageList = CarriageService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(CarriageList);
		pageResult.setRows((List<CarriageDto>) new CarriageWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "??????vhis??????????????????", notes = "??????vhis??????????????????")
	@GetMapping(value = "/Carriages")
	@ResponseBody
	public Object findAll() {
		List<Carriage> CarriageList = CarriageService.findAll();
		return  new CarriageWarpper(CarriageList).warp();
	}
}
