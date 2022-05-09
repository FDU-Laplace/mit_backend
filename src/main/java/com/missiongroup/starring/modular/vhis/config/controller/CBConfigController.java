package com.missiongroup.starring.modular.vhis.config.controller;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.CB.CBConfigDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import com.missiongroup.starring.modular.vhis.config.domain.dto.CBConfigDto;
import com.missiongroup.starring.modular.vhis.config.domain.dto.warpper.CBConfigWarpper;
import com.missiongroup.starring.modular.vhis.config.service.CBConfigService;
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
 * @ClassName: CBConfigController
 * @Description: 断路器管理控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/CBConfigCtl")
public class CBConfigController extends BaseController {
	@Autowired
	CBConfigService CBConfigService;

    @ApiOperation(value = "新增断路器信息", notes = "新增断路器信息")
	@ApiImplicitParam(name = "CBConfig", value = "断路器信息", required = true, dataType = "CBConfig")
	@PostMapping(value = "/CBConfig")
	@BussinessLog(value = "新增断路器信息", key = "name,car,description", dict = CBConfigDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody CBConfig CBConfig, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CBConfig.setCreateTime(new Date());
		CBConfig.setCreateUserId(ShiroKit.getUser().getId());
		CBConfig.setUpdateTime(new Date());
		CBConfig.setUpdateUserId(ShiroKit.getUser().getId());
		CBConfigService.save(CBConfig);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改断路器信息", notes = "根据ID修改断路器信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "CBConfig", value = "断路器信息", required = true, dataType = "CBConfigDto")//
	})
	@PutMapping(value = "/CBConfig/{id}")
	@BussinessLog(value = "修改断路器信息", key = "name,car,description", dict = CBConfigDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody CBConfig CBConfig, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CBConfig.setUuid(id);
		CBConfig cacheCBConfig = (CBConfig) LogObjectHolder.me().get();
		
		cacheCBConfig.setName(CBConfig.getName());
		cacheCBConfig.setCar(CBConfig.getCar());
		cacheCBConfig.setDescription(CBConfig.getDescription());
		cacheCBConfig.setUpdateTime(new Date());
		cacheCBConfig.setUpdateUserId(ShiroKit.getUser().getId());
		cacheCBConfig = CBConfigService.save(cacheCBConfig);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除断路器信息", notes = "删除断路器信息")
	@ApiImplicitParam(name = "ids", value = "断路器ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/CBConfig/{ids}")
	@BussinessLog(value = "删除断路器信息", key = "ids", dict = CBConfigDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CBConfigService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询断路器信息", notes = "根据ID获取断路器信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/CBConfig/{id}")
	@ResponseBody
	public Object getCBConfigById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		CBConfig CBConfig = CBConfigService.findOneByUuid(id);
		LogObjectHolder.me().set(CBConfig);
		return CBConfig;
	}
	
	@ApiOperation(value = "查询断路器列表", notes = "查询断路器列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<CBConfig> CBConfigList = CBConfigService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(CBConfigList);
		pageResult.setRows((List<CBConfigDto>) new CBConfigWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询断路器所有列表", notes = "查询断路器所有列表")
	@GetMapping(value = "/CBConfigs")
	@ResponseBody
	public Object findAll() {
		List<CBConfig> CBConfigList = CBConfigService.findAll();
		return  new CBConfigWarpper(CBConfigList).warp();
	}
}
