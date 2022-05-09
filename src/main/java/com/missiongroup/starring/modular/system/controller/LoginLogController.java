package com.missiongroup.starring.modular.system.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.modular.system.domain.LoginLog;
import com.missiongroup.starring.modular.system.domain.dto.LoginLogDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.LogWarpper;
import com.missiongroup.starring.modular.system.service.LoginLogService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: LoginLogController
 * @Description: 日志管理控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:32:38
 *
 */
@SuppressWarnings("all")
@Api(value = "日志管理接口详情", description = "日志管理接口详情")

@Controller
@RequestMapping("/loginLogCtl")
public class LoginLogController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(LoginLogController.class);

	@Autowired
	private LoginLogService loginLogService;

	@ApiOperation(value = "查询登录日志列表", notes = "查询登录日志列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<LoginLog> loginLogList = loginLogService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(loginLogList);
		pageResult.setRows((List<LoginLogDto>) new LogWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
}
