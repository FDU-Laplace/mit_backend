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
import com.missiongroup.starring.common.constant.dictmap.vhis.alert.AlertRuleDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.alert.domain.AlertRule;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.AlertRuleDto;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.warpper.AlertRuleWarpper;
import com.missiongroup.starring.modular.vhis.alert.service.AlertRuleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: AlertRuleController
 * @Description: 预警规则控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/AlertRuleCtl")
public class AlertRuleController extends BaseController {
	@Autowired
	AlertRuleService AlertRuleService;

    @ApiOperation(value = "新增预警规则信息", notes = "新增预警规则信息")
	@ApiImplicitParam(name = "AlertRule", value = "预警规则信息", required = true, dataType = "AlertRule")
	@PostMapping(value = "/AlertRule")
	@BussinessLog(value = "新增预警规则信息", key = "ruleCode,ruleName,ruleValue", dict = AlertRuleDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody AlertRule AlertRule, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		AlertRule.setCreateTime(new Date());
		AlertRule.setCreateUserId(ShiroKit.getUser().getId());
		AlertRule.setUpdateTime(new Date());
		AlertRule.setUpdateUserId(ShiroKit.getUser().getId());
		AlertRuleService.save(AlertRule);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改预警规则信息", notes = "根据ID修改预警规则信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "AlertRule", value = "预警规则信息", required = true, dataType = "AlertRuleDto")//
	})
	@PutMapping(value = "/AlertRule/{id}")
	@BussinessLog(value = "修改预警规则信息", key = "ruleCode,ruleName,ruleValue", dict = AlertRuleDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody AlertRule AlertRule, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		AlertRule.setUuid(id);
		AlertRule cacheAlertRule = (AlertRule) LogObjectHolder.me().get();
		
		cacheAlertRule.setRuleCode(AlertRule.getRuleCode());
		cacheAlertRule.setRuleName(AlertRule.getRuleName());
		cacheAlertRule.setRuleValue(AlertRule.getRuleValue());
		cacheAlertRule.setUpdateTime(new Date());
		cacheAlertRule.setUpdateUserId(ShiroKit.getUser().getId());
		cacheAlertRule = AlertRuleService.save(cacheAlertRule);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除预警规则信息", notes = "删除预警规则信息")
	@ApiImplicitParam(name = "ids", value = "预警规则ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/AlertRule/{ids}")
	@BussinessLog(value = "删除预警规则信息", key = "ids", dict = AlertRuleDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		AlertRuleService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询预警规则信息", notes = "根据ID获取预警规则信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/AlertRule/{id}")
	@ResponseBody
	public Object getAlertRuleById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		AlertRule AlertRule = AlertRuleService.findOneByUuid(id);
		LogObjectHolder.me().set(AlertRule);
		return AlertRule;
	}
	
	@ApiOperation(value = "查询预警规则列表", notes = "查询预警规则列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<AlertRule> AlertRuleList = AlertRuleService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(AlertRuleList);
		pageResult.setRows((List<AlertRuleDto>) new AlertRuleWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询预警规则所有列表", notes = "查询预警规则所有列表")
	@GetMapping(value = "/AlertRules")
	@ResponseBody
	public Object findAll() {
		List<AlertRule> AlertRuleList = AlertRuleService.findAll();
		return  new AlertRuleWarpper(AlertRuleList).warp();
	}
}
