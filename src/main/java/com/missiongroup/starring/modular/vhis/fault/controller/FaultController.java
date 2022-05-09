package com.missiongroup.starring.modular.vhis.fault.controller;

import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.modular.vhis.fault.domain.Fault;
import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.warpper.FaultWarpper;
import com.missiongroup.starring.modular.vhis.fault.service.FaultService;
import com.missiongroup.starring.modular.vhis.fault.service.LevelConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xuwei
 * @ClassName: FaultController
 * @Description: 故障控制器
 * @date 2020年2月4日 下午3:13:41
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/FaultCtl")
@Api(value = "故障信息")
public class FaultController extends BaseController {
    @Autowired
    FaultService FaultService;

    @Autowired
    LevelConfigService levelConfigService;

    @ApiOperation(value = "批量确认故障信息", notes = "根据ID确认故障信息")
    @ApiImplicitParams(@ApiImplicitParam(name = "ids", value = "IDS", required = true, paramType = "String"))
    @PutMapping(value = "/Fault/{ids}")
    @ResponseBody
    public Object confirms(@PathVariable("ids") String ids) {
        FaultService.confirm(ids);
        return SUCCESS_TIP;
    }

    @ApiOperation(value = "确认故障信息", notes = "根据ID确认故障信息")
    @ApiImplicitParams(@ApiImplicitParam(name = "param", value = "param", required = true, dataType = "Map"))
    @PutMapping(value = "/Fault")
    @ResponseBody
    public Object confirm(@RequestBody Map<String, String> param) {
        Fault fault = FaultService.findOneByUuid(param.get("id"));
        if (fault == null) {
            return new ErrorTip(999, "查无数据");
        }
        fault.setConfirmFault("1");
        fault.setIsFault(param.get("isFault"));
        fault.setRemarks(param.get("remarks"));
        Date date = new Date();
        fault.setConfirmTime(date);
        fault.setUpdateUserId(ShiroKit.getUser().getId());
        fault.setUpdateTime(date);
        FaultService.save(fault);
        return SUCCESS_TIP;
    }

    @ApiOperation(value = "查询实时故障列表", notes = "查询实时故障列表")
    @ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
    @PostMapping(value = "/list")
    @ResponseBody
    public PageResult list(@RequestBody PageParam pageParam) {
        Page<Fault> faultConfigList = FaultService.findAll(pageParam.formatPageable(), pageParam.getCondition());
        PageResult pageResult = new PageResult(faultConfigList);
        List<FaultDto> dto = (List<FaultDto>) new FaultWarpper(pageResult.getRows()).warp();
        pageResult.setRows(levelConfigService.findLevelConfigJoinFault(dto));
        return pageResult;
    }
}
