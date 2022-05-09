package com.missiongroup.starring.modular.vhis.fault.controller;

import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.modular.vhis.fault.domain.FaultHistory;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.warpper.FaultWarpper;
import com.missiongroup.starring.modular.vhis.fault.service.FaultHistoryService;
import com.missiongroup.starring.modular.vhis.fault.service.LevelConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/1
 */
@Controller
@RequestMapping("/FaultHistoryCtl")
@Api(value = "故障历史信息")
public class FaultHistoryController {

    @Autowired
    private FaultHistoryService faultHistoryService;

    @Autowired
    LevelConfigService levelConfigService;

    @ApiOperation(value = "查询故障历史列表", notes = "查询故障历史列表")
    @ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
    @PostMapping(value = "/list")
    @ResponseBody
    public PageResult list(@RequestBody PageParam pageParam) {
        Page<FaultHistory> faultHistoryList = faultHistoryService.findAll(pageParam.formatPageable(), pageParam.getCondition());
        PageResult pageResult = new PageResult(faultHistoryList);
        List<FaultDto> dto = (List<FaultDto>) new FaultWarpper(pageResult.getRows()).warp();
        pageResult.setRows(levelConfigService.findLevelConfigJoinFault(dto));
        return pageResult;
    }
}
