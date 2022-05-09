package com.missiongroup.starring.core.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.missiongroup.starring.common.constant.state.ErrorType;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: GlobalController
 * @Description: 全局控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午2:55:51
 *
 */
@Controller
@RequestMapping("/globalCtl")
public class GlobalController {
	@ApiOperation(value = "跳转到错误页面", notes = "跳转到错误页面")
	@RequestMapping(path = "/error/{type}", method = RequestMethod.GET)
	public String errorPage(@PathVariable("type") String type, Model model) {
		model.addAttribute("errorMessage", ErrorType.getValue(type));
		return "/error.html";
	}

	@ApiOperation(value = "跳转到会话超时页面", notes = "跳转到会话超时页面")
	@RequestMapping(path = "/sessionError", method = RequestMethod.GET)
	public String errorPageInfo(Model model) {
		return "/login.html";
	}
}
