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
 * @Description: 车厢管理控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "车厢管理接口管理")
@Controller
@RequestMapping("/CarriageCtl")
public class CarriageController extends BaseController {
	@Autowired
	CarriageService CarriageService;

    @ApiOperation(value = "新增vhis车厢信息", notes = "新增vhis车厢信息")
	@ApiImplicitParam(name = "Carriage", value = "vhis车厢信息", required = true, dataType = "Carriage")
	@PostMapping(value = "/Carriage")
	@BussinessLog(value = "新增vhis车厢信息", key = "relationLine,relationTrain,carriageId,carriageType,carriageName,carriageCode", dict = CarriageDict.class)
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
	
	@ApiOperation(value = "修改vhis车厢信息", notes = "根据ID修改vhis车厢信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Carriage", value = "vhis车厢信息", required = true, dataType = "CarriageDto")//
	})  
	@PutMapping(value = "/Carriage/{id}")
	@BussinessLog(value = "修改vhis车厢信息", key = "relationLine,relationTrain,carriageId,carriageType,carriageName,carriageCode", dict = CarriageDict.class)
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
	
	@ApiOperation(value = "删除vhis车厢信息", notes = "删除vhis车厢信息")
	@ApiImplicitParam(name = "ids", value = "vhis车厢ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/Carriage/{ids}")
	@BussinessLog(value = "删除vhis车厢信息", key = "ids", dict = CarriageDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CarriageService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询vhis车厢信息", notes = "根据ID获取vhis车厢信息")
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
	
	@ApiOperation(value = "查询vhis车厢列表", notes = "查询vhis车厢列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Carriage> CarriageList = CarriageService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(CarriageList);
		pageResult.setRows((List<CarriageDto>) new CarriageWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询vhis车厢所有列表", notes = "查询vhis车厢所有列表")
	@GetMapping(value = "/Carriages")
	@ResponseBody
	public Object findAll() {
		List<Carriage> CarriageList = CarriageService.findAll();
		return  new CarriageWarpper(CarriageList).warp();
	}
}
