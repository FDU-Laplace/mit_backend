package com.missiongroup.starring.modular.vhis.fault.controller;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.LevelConfigDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.LevelConfigDto;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.warpper.LevelConfigWarpper;
import com.missiongroup.starring.modular.vhis.fault.service.LevelConfigService;
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
import java.util.Objects;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/1
 */
@Controller
@RequestMapping("/LevelConfigCtl")
@Api(value = "故障等级配置信息")
public class LevelConfigController extends BaseController {

    @Autowired
    private LevelConfigService levelConfigService;

    @ApiOperation(value = "查询故障等级配置列表", notes = "查询故障等级配置列表")
    @ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
    @PostMapping(value = "/list")
    @ResponseBody
    public PageResult list(@RequestBody PageParam pageParam) {
        Page<LevelConfig> levelConfigs = levelConfigService.findAll(pageParam.formatPageable(), pageParam.getCondition());
        PageResult pageResult = new PageResult(levelConfigs);
        pageResult.setRows((List<LevelConfigDto>) new LevelConfigWarpper(pageResult.getRows()).warp());
        return pageResult;
    }

    @ApiOperation(value = "查询故障等级配置列表", notes = "查询故障等级配置列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public Object findAll() {
        List<LevelConfig> levelConfigs = levelConfigService.findAll();
        return new LevelConfigWarpper(levelConfigs).warp();
    }

    @ApiOperation(value = "删除故障等级配置", notes = "根据id删除故障等级配置信息")
    @ApiImplicitParam(name = "ids", value = "故障等级配置ID列表", required = true, dataType = "String")
    @BussinessLog(value = "删除故障等级配置", key = "ids", dict = LevelConfigDict.class)
    @RequestMapping(value = "/del/{confIds}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("confIds") String confIds) {
        levelConfigService.delete(confIds);
        return SUCCESS_TIP;
    }

    @ApiOperation(value = "新增故障等级配置信息", notes = "新增故障等级配置信息")
    @ApiImplicitParam(name = "levelConfig", value = "故障等级配置信息", required = true, dataType = "levelConfig")
    @BussinessLog(value = "新增故障等级配置信息", key = "color,faultLevel,levelName,twinkle,voice", dict = LevelConfigDict.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(@Valid @RequestBody LevelConfig levelConfig, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        // 判断故障图标是否存在
        List<LevelConfig> byFaultIcon = levelConfigService.findByIcon(levelConfig.getIcon());
        if (!byFaultIcon.isEmpty()) {
            throw new BussinessException(BizExceptionEnum.FAULT_ICON_ALREADY_EXISTS);
        }
        // 判断故障等级是否重复
        List<LevelConfig> byFaultLevel = levelConfigService.findByFaultLevel(levelConfig.getFaultLevel());
        if (!byFaultLevel.isEmpty()) {
            throw new BussinessException(BizExceptionEnum.FAULT_LEVEL_ALREADY_EXISTS);
        }
        levelConfig.setCreateTime(new Date());
        levelConfig.setUpdateTime(new Date());
        levelConfig.setCreateUserId(ShiroKit.getUser().getId());
        levelConfig.setUpdateUserId(ShiroKit.getUser().getId());
        levelConfigService.save(levelConfig);
        return SUCCESS_TIP;
    }

    @ApiOperation(value = "更新故障等级配置信息", notes = "根据id更新故障等级配置信息")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "id", value = "故障等级配置ID", required = true, dataType = "String"), //
            @ApiImplicitParam(name = "levelConfig", value = "故障等级配置信息", required = true, dataType = "levelConfig")//
    })
    @BussinessLog(value = "更新故障等级配置信息", key = "id,color,faultLevel,levelName,twinkle,voice", dict = LevelConfigDict.class)
    @RequestMapping(value = "/upd/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable("id") String id, @Valid @RequestBody LevelConfig levelConfig, BindingResult result) {
        if (result.hasErrors() || ToolUtil.isEmpty(levelConfig) || levelConfig == null) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        // 判断故障配置是否存在
        LevelConfig levelConf = levelConfigService.findOneByUuid(id);
        if (Objects.isNull(levelConf)) {
            throw new BussinessException(BizExceptionEnum.FAULT_LEVEL_NOT_EXISTS);
        }
        // 判断故障等级是否重复
        if(!levelConf.getFaultLevel().equals(levelConfig.getFaultLevel())){
            List<LevelConfig> byFaultLevel = levelConfigService.findByFaultLevel(levelConfig.getFaultLevel());
            if (!byFaultLevel.isEmpty()) {
                throw new BussinessException(BizExceptionEnum.FAULT_LEVEL_ALREADY_EXISTS);
            }
        }
        // 判断故障图标是否重复
        if(!levelConf.getIcon().equals(levelConfig.getIcon())){
            List<LevelConfig> byFaultIcon = levelConfigService.findByIcon(levelConfig.getIcon());
            if (!byFaultIcon.isEmpty()) {
                throw new BussinessException(BizExceptionEnum.FAULT_ICON_ALREADY_EXISTS);
            }
        }

        levelConfig.setCreateUserId(levelConf.getCreateUserId());
        levelConfig.setCreateTime(levelConf.getCreateTime());
        levelConfig.setUuid(id);
        levelConfig.setUpdateTime(new Date());
        levelConfig.setUpdateUserId(ShiroKit.getUser().getId());
        levelConfigService.save(levelConfig);
        return SUCCESS_TIP;
    }
}
