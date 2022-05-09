package com.missiongroup.starring.modular.system.controller;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.modular.system.domain.OperationLog;
import com.missiongroup.starring.modular.system.domain.dto.OperationLogDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.LogWarpper;
import com.missiongroup.starring.modular.system.service.OperationLogService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @ClassName: LogController
 * @Description: 日志管理控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@ApiIgnore
@Controller
@RequestMapping("/logCtl")
public class LogController extends BaseController {
	@Resource
	OperationLogService operationLogService;

	@ApiOperation(value = "查询系统业务日志列表", notes = "查询系统业务日志列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<OperationLog> loginLogList = operationLogService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(loginLogList);
		pageResult.setRows((List<OperationLogDto>) new LogWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
}
