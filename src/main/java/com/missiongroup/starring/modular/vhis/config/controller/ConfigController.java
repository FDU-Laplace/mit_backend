package com.missiongroup.starring.modular.vhis.config.controller;

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
import com.missiongroup.starring.common.constant.dictmap.vhis.config.ConfigDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.config.domain.Config;
import com.missiongroup.starring.modular.vhis.config.domain.dto.ConfigDto;
import com.missiongroup.starring.modular.vhis.config.domain.dto.warpper.ConfigWarpper;
import com.missiongroup.starring.modular.vhis.config.service.ConfigService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: ConfigController
 * @Description: 配置管理控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/ConfigCtl")
public class ConfigController extends BaseController {
	@Autowired
	ConfigService ConfigService;

    @ApiOperation(value = "新增vhis配置信息", notes = "新增vhis配置信息")
	@ApiImplicitParam(name = "Config", value = "vhis配置信息", required = true, dataType = "Config")
	@PostMapping(value = "/Config")
	@BussinessLog(value = "新增vhis配置信息", key = "configCode,configValue,remark,isCache", dict = ConfigDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Config Config, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Config.setCreateTime(new Date());
		Config.setCreateUserId(ShiroKit.getUser().getId());
		Config.setUpdateTime(new Date());
		Config.setUpdateUserId(ShiroKit.getUser().getId());
		ConfigService.save(Config);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改vhis配置信息", notes = "根据ID修改vhis配置信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Config", value = "vhis配置信息", required = true, dataType = "ConfigDto")//
	})
	@PutMapping(value = "/Config/{id}")
	@BussinessLog(value = "修改vhis配置信息", key = "configCode,configValue,remark,isCache", dict = ConfigDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Config Config, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Config.setUuid(id);
		Config cacheConfig = (Config) LogObjectHolder.me().get();
		
		cacheConfig.setConfigCode(Config.getConfigCode());
		cacheConfig.setConfigValue(Config.getConfigValue());
		cacheConfig.setRemark(Config.getRemark());
		cacheConfig.setIsCache(Config.getIsCache());
		cacheConfig.setUpdateTime(new Date());
		cacheConfig.setUpdateUserId(ShiroKit.getUser().getId());
		cacheConfig = ConfigService.save(cacheConfig);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除vhis配置信息", notes = "删除vhis配置信息")
	@ApiImplicitParam(name = "ids", value = "vhis配置ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/Config/{ids}")
	@BussinessLog(value = "删除vhis配置信息", key = "ids", dict = ConfigDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		ConfigService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询vhis配置信息", notes = "根据ID获取vhis配置信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Config/{id}")
	@ResponseBody
	public Object getConfigById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Config Config = ConfigService.findOneByUuid(id);
		LogObjectHolder.me().set(Config);
		return Config;
	}
	
	@ApiOperation(value = "查询vhis配置列表", notes = "查询vhis配置列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Config> ConfigList = ConfigService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(ConfigList);
		pageResult.setRows((List<ConfigDto>) new ConfigWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询vhis配置所有列表", notes = "查询vhis配置所有列表")
	@GetMapping(value = "/Configs")
	@ResponseBody
	public Object findAll() {
		List<Config> ConfigList = ConfigService.findAll();
		return  new ConfigWarpper(ConfigList).warp();
	}
}
