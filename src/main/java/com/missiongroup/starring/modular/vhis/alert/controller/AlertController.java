package com.missiongroup.starring.modular.vhis.alert.controller;

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
import com.missiongroup.starring.common.constant.dictmap.vhis.alert.AlertDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.alert.domain.Alert;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.AlertDto;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.warpper.AlertWarpper;
import com.missiongroup.starring.modular.vhis.alert.service.AlertService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: AlertController
 * @Description: ???????????????
 * @author xuwei
 * @date 2020???2???4??? ??????3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/AlertCtl")
public class AlertController extends BaseController {
	@Autowired
	AlertService AlertService;

    @ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParam(name = "Alert", value = "????????????", required = true, dataType = "Alert")
	@PostMapping(value = "/Alert")
	@BussinessLog(value = "??????????????????", key = "alertCode,relationLin,relationTrain,alertSys,relationRule,alertName,alertLevel,isAlert,pushStatus,alertTime,remarks", dict = AlertDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Alert Alert, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Alert.setCreateTime(new Date());
		Alert.setCreateUserId(ShiroKit.getUser().getId());
		Alert.setUpdateTime(new Date());
		Alert.setUpdateUserId(ShiroKit.getUser().getId());
		AlertService.save(Alert);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????????????????", notes = "??????ID??????????????????")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Alert", value = "????????????", required = true, dataType = "AlertDto")//
	})
	@PutMapping(value = "/Alert/{id}")
	@BussinessLog(value = "??????????????????", key = "alertCode,relationLin,relationTrain,alertSys,relationRule,alertName,alertLevel,isAlert,pushStatus,alertTime,remarks", dict = AlertDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Alert Alert, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Alert.setUuid(id);
		Alert cacheAlert = (Alert) LogObjectHolder.me().get();
		
		cacheAlert.setAlertCode(Alert.getAlertCode());
		cacheAlert.setRelationLin(Alert.getRelationLin());
		cacheAlert.setRelationTrain(Alert.getRelationTrain());
		cacheAlert.setAlertSys(Alert.getAlertSys());
		cacheAlert.setRelationRule(Alert.getRelationRule());
		cacheAlert.setAlertName(Alert.getAlertName());
		cacheAlert.setAlertLevel(Alert.getAlertLevel());
		cacheAlert.setIsAlert(Alert.getIsAlert());
		cacheAlert.setPushStatus(Alert.getPushStatus());
		cacheAlert.setAlertTime(Alert.getAlertTime());
		cacheAlert.setRemarks(Alert.getRemarks());
		cacheAlert.setUpdateTime(new Date());
		cacheAlert.setUpdateUserId(ShiroKit.getUser().getId());
		cacheAlert = AlertService.save(cacheAlert);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParam(name = "ids", value = "??????ID??????", required = true, dataType = "String")
	@DeleteMapping(value = "/Alert/{ids}")
	@BussinessLog(value = "??????????????????", key = "ids", dict = AlertDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		AlertService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "??????????????????", notes = "??????ID??????????????????")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Alert/{id}")
	@ResponseBody
	public Object getAlertById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Alert Alert = AlertService.findOneByUuid(id);
		LogObjectHolder.me().set(Alert);
		return Alert;
	}
	
	@ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParam(name = "pageParam", value = "??????????????????", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Alert> AlertList = AlertService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(AlertList);
		pageResult.setRows((List<AlertDto>) new AlertWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "????????????????????????", notes = "????????????????????????")
	@GetMapping(value = "/Alerts")
	@ResponseBody
	public Object findAll() {
		List<Alert> AlertList = AlertService.findAll();
		return  new AlertWarpper(AlertList).warp();
	}
}
