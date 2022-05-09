package com.missiongroup.starring.modular.vhis.config.controller;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.vhis.fault.FaultConfigDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.config.domain.dto.warpper.FaultConfigWarpper;
import com.missiongroup.starring.modular.vhis.config.service.FaultConfigService;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: FaultConfigController
 * @Description: 故障配置控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "故障配置接口")
@Controller
@RequestMapping("/FaultConfigCtl")
public class FaultConfigController extends BaseController {
	@Autowired
	FaultConfigService faultConfigService;

    @ApiOperation(value = "新增故障配置信息", notes = "新增故障配置信息")
	@ApiImplicitParam(name = "faultConfig", value = "故障信息", required = true, dataType = "FaultConfig")
	@PostMapping(value = "/faultConfig")
	@BussinessLog(value = "新增故障配置信息", key = "faultCode,faultName,faultLevel,describe,disposal", dict = FaultConfigDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody FaultConfig faultConfig, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		faultConfig.setCreateTime(new Date());
		faultConfig.setCreateUserId(ShiroKit.getUser().getId());
		faultConfig.setUpdateTime(new Date());
		faultConfig.setUpdateUserId(ShiroKit.getUser().getId());
		faultConfigService.save(faultConfig);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改故障配置信息", notes = "根据ID修改故障配置信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "faultConfig", value = "故障配置信息", required = true, dataType = "FaultConfig")//
	})
	@PutMapping(value = "/faultConfig/{id}")
	@BussinessLog(value = "修改故障配置信息", key = "faultCode,faultName,faultLevel,describe,disposal", dict = FaultConfigDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody FaultConfig faultConfig, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		faultConfig.setUuid(id);
		FaultConfig cacheFault = (FaultConfig) LogObjectHolder.me().get();
		
		cacheFault.setFaultCode(faultConfig.getFaultCode());
		cacheFault.setFaultName(faultConfig.getFaultName());
		cacheFault.setFaultLevel(faultConfig.getFaultLevel());
		cacheFault.setUpdateTime(new Date());
		cacheFault.setUpdateUserId(ShiroKit.getUser().getId());
		cacheFault = faultConfigService.save(cacheFault);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除故障配置信息", notes = "删除故障配置信息")
	@ApiImplicitParam(name = "ids", value = "故障ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/FaultCofig/{ids}")
	@BussinessLog(value = "删除故障配置信息", key = "ids", dict = FaultConfigDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		faultConfigService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询故障配置信息", notes = "根据ID获取故障配置信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/FaultConfig/{id}")
	@ResponseBody
	public Object getFaultById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		FaultConfig faultConfig = faultConfigService.findOneByUuid(id);
		LogObjectHolder.me().set(faultConfig);
		return faultConfig;
	}
	
	@ApiOperation(value = "查询故障配置列表", notes = "查询故障配置列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<FaultConfig> faultConfigList = faultConfigService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(faultConfigList);
		pageResult.setRows((List<FaultDto>) new FaultConfigWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询故障配置所有列表", notes = "查询故障配置所有列表")
	@GetMapping(value = "/Faults")
	@ResponseBody
	public Object findAll() {
		List<FaultConfig> faultConfigList = faultConfigService.findAll();
		return  new FaultConfigWarpper(faultConfigList).warp();
	}
}
