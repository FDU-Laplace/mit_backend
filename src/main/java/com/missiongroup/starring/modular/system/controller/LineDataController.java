package com.missiongroup.starring.modular.system.controller;

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("all")
@Api(value = "角色接口详情", description = "角色接口详情")
@Controller
@RequestMapping("/lineData")
public class LineDataController {
    private String lineNumber;
    @ApiOperation(value = "查询列车数据", notes = "根据lineNumber获取列车信息")
    @ApiImplicitParam(name = "lineNumber", value = "列车number", required = true, dataType = "String")
    @RequestMapping(value = "/line/{lineNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserById(@PathVariable("lineNumber") String lineNumber) {
        this.lineNumber = lineNumber;
        return null;
    }

    public String getLineNumber() {
        return lineNumber;
    }
}
