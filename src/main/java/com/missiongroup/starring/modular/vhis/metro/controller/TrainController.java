package com.missiongroup.starring.modular.vhis.metro.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
import com.missiongroup.starring.modular.vhis.metro.service.CarriageService;
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
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.TrainDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.Train;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.TrainDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.TrainWarpper;
import com.missiongroup.starring.modular.vhis.metro.service.TrainService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: TrainController
 * @Description: 列车管理控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "列车管理接口管理")
@Controller
@RequestMapping("/TrainCtl")
public class TrainController extends BaseController {
	@Autowired
	TrainService trainService;
	@Autowired
	CarriageService carriageService;
    @ApiOperation(value = "新增vhis列车信息", notes = "新增vhis列车信息")
	@ApiImplicitParam(name = "Train", value = "vhis列车信息", required = true, dataType = "Train")
	@PostMapping(value = "/Train")
	@BussinessLog(value = "新增vhis列车信息", key = "relationLine,trainId,trainType,trainName,trainCode,remark", dict = TrainDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Train train, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		String userId = ShiroKit.getUser().getId();
		Date time = new Date();
		List<Carriage> carriages = train.getCarriages();
		if (carriages != null) {
			for (Carriage carriage : carriages) {
				carriage.setCreateTime(time);
				carriage.setCreateUserId(userId);
				carriage.setUpdateTime(time);
				carriage.setUpdateUserId(userId);
			}
		}
		train.setCreateTime(time);
		train.setCreateUserId(userId);
		train.setUpdateTime(time);
		train.setUpdateUserId(userId);
		trainService.save(train);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改vhis列车信息", notes = "根据ID修改vhis列车信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Train", value = "vhis列车信息", required = true, dataType = "TrainDto")//
	})
	@PutMapping(value = "/Train/{id}")
	@BussinessLog(value = "修改vhis列车信息", key = "relationLine,trainId,trainType,trainName,trainCode,remark", dict = TrainDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Train train, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		String userId = ShiroKit.getUser().getId();
		Train entity = trainService.findOneByUuid(id);
		Date time = new Date();
		train.setUuid(id);
		List<Carriage> carriages = train.getCarriages();
		if (carriages != null) {
			for (Carriage carriage : carriages) {
				String uuid = carriage.getUuid();
				if(uuid==null||uuid.equals("")){
					carriage.setCreateTime(time);
					carriage.setCreateUserId(userId);
					carriage.setUpdateTime(time);
					carriage.setUpdateUserId(userId);
				}else{
					 carriage = carriageService.findOneByUuid(uuid);
				}
			}
		}
		entity.setTrainId(train.getTrainId());
		entity.setTrainType(train.getTrainType());
		entity.setCarriages(carriages);
		entity.setTrainName(train.getTrainName());
		entity.setTrainCode(train.getTrainCode());
		entity.setRemark(train.getRemark());
		entity.setUpdateTime(new Date());
		entity.setUpdateUserId(ShiroKit.getUser().getId());
		 trainService.save(entity);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除vhis列车信息", notes = "删除vhis列车信息")
	@ApiImplicitParam(name = "ids", value = "vhis列车ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/Train/{ids}")
	@BussinessLog(value = "删除vhis列车信息", key = "ids", dict = TrainDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		trainService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询vhis列车信息", notes = "根据ID获取vhis列车信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Train/{id}")
	@ResponseBody
	public Object getTrainById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Train Train = trainService.findOneByUuid(id);
		LogObjectHolder.me().set(Train);
		return Train;
	}
	
	@ApiOperation(value = "查询vhis列车列表", notes = "查询vhis列车列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Train> TrainList = trainService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(TrainList);
		pageResult.setRows((List<TrainDto>) new TrainWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询vhis列车所有列表", notes = "查询vhis列车所有列表")
	@GetMapping(value = "/Trains")
	@ResponseBody
	public Object findAll() {
		List<Train> TrainList = trainService.findAll();
		return  new TrainWarpper(TrainList).warp();
	}
}
