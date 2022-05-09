package com.missiongroup.starring.modular.system.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.missiongroup.starring.common.annotion.Permission;
import com.missiongroup.starring.core.base.controller.BaseController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 路由控制类
 * 
 * @author wj
 *
 */
@Api(value = "路由控制接口详情", description = "路由控制接口详情")
@Controller
public class RouteController extends BaseController {
	@ApiOperation(value = "pages页面路由", notes = "pages页面路由")
	@ApiImplicitParam(name = "page", value = "页面地址", required = true, dataType = "String")
	@Permission
	@RequestMapping(value = "/pages/{page}", method = RequestMethod.GET)
	public String pageRoute(@PathVariable("page") String pathUrl) {
		return "/pages/" + pathUrl + ".html";
	}

	@ApiOperation(value = "pages二级页面路由", notes = "page二级页面路由")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "folder", value = "二级目录", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "page", value = "页面地址", required = true, dataType = "String")//
	})
	@Permission
	@RequestMapping(value = "/pages/{folder}/{page}", method = RequestMethod.GET)
	public String pageFolderRoute(@PathVariable("folder") String pathFolder, @PathVariable("page") String pathUrl) {
		return "/pages/" + pathFolder + "/" + pathUrl + ".html";
	}

	@ApiOperation(value = "pages三级页面路由", notes = "页面路由")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "folder", value = "二级目录", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "innerFolder", value = "三级目录", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "page", value = "页面地址", required = true, dataType = "String")//
	})
	@Permission
	@RequestMapping(value = "/pages/{folder}/{innerFolder}/{page}", method = RequestMethod.GET)
	public String pageFolderRoute(@PathVariable("folder") String pathFolder, @PathVariable("innerFolder") String innerFolder, @PathVariable("page") String pathUrl) {
		return "/pages/" + pathFolder + "/" + innerFolder + "/" + pathUrl + ".html";
	}
}
