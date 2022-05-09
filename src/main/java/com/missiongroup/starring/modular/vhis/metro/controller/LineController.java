package com.missiongroup.starring.modular.vhis.metro.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.missiongroup.starring.modular.vhis.metro.domain.Train;
import com.missiongroup.starring.modular.vhis.metro.service.TrainService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.LineDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.Line;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.LineDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.LineWarpper;
import com.missiongroup.starring.modular.vhis.metro.service.LineService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: LineController
 * @Description: 线路管理控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Api(value = "线路管理接口管理")
@Controller
@RequestMapping("/LineCtl")
public class LineController extends BaseController {
	@Autowired
	LineService lineService;
	@Autowired
	TrainService trainService;
    @ApiOperation(value = "新增vhis线路信息", notes = "新增vhis线路信息")
	@ApiImplicitParam(name = "Line", value = "vhis线路信息", required = true, dataType = "Line")
	@PostMapping(value = "/Line")
	@BussinessLog(value = "新增vhis线路信息", key = "lineId,lineType,,lineColor,lineName,lineNameEn,lineNum,lineCode,isRun", dict = LineDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Line Line, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Line.setCreateTime(new Date());
		Line.setCreateUserId(ShiroKit.getUser().getId());
		Line.setUpdateTime(new Date());
		Line.setUpdateUserId(ShiroKit.getUser().getId());
		lineService.save(Line);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改vhis线路信息", notes = "根据ID修改vhis线路信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "Line", value = "vhis线路信息", required = true, dataType = "LineDto")//
	})
	@PutMapping(value = "/Line/{id}")
	@BussinessLog(value = "修改vhis线路信息", key = "lineId,lineType,,lineColor,lineName,lineNameEn,lineNum,lineCode,isRun", dict = LineDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Line Line, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Line.setUuid(id);
		Line cacheLine = (Line) LogObjectHolder.me().get();
		
		cacheLine.setLineId(Line.getLineId());
		cacheLine.setTrains(Line.getTrains());
		cacheLine.setLineType(Line.getLineType());
		cacheLine.setLineColor(Line.getLineColor());
		cacheLine.setLineName(Line.getLineName());
		cacheLine.setLineNameEn(Line.getLineNameEn());
		cacheLine.setLineNum(Line.getLineNum());
		cacheLine.setLineCode(Line.getLineCode());
		cacheLine.setIsRun(Line.getIsRun());
		cacheLine.setUpdateTime(new Date());
		cacheLine.setUpdateUserId(ShiroKit.getUser().getId());
		cacheLine = lineService.save(cacheLine);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除vhis线路信息", notes = "删除vhis线路信息")
	@ApiImplicitParam(name = "ids", value = "vhis线路ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/Line/{ids}")
	@BussinessLog(value = "删除vhis线路信息", key = "ids", dict = LineDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		lineService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询vhis线路信息", notes = "根据ID获取vhis线路信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/Line/{id}")
	@ResponseBody
	public Object getLineById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Line Line = lineService.findOneByUuid(id);
		LogObjectHolder.me().set(Line);
		return Line;
	}
	
	@ApiOperation(value = "查询vhis线路列表", notes = "查询vhis线路列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Line> LineList = lineService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(LineList);
		pageResult.setRows((List<LineDto>) new LineWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询vhis线路所有列表", notes = "查询vhis线路所有列表")
	@GetMapping(value = "/Lines")
	@ResponseBody
	public Object findAll() {
		List<Line> LineList = lineService.findAll();
		return  new LineWarpper(LineList).warp();
	}

	@ApiOperation(value = "线路列车配置", notes = "线路列车配置")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "lineId", value = "线路ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "trainIds", value = "列车ID", required = true, dataType = "String")//

	})
	@RequestMapping(value = "/lineTrainSet", method = RequestMethod.PUT,consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public Object lineTrainSet(@RequestParam("lineId") String lineId, @RequestParam("trainIds") String trainIds) {
		if (ToolUtil.isOneEmpty(lineId, trainIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Line line = lineService.findOneByUuid(lineId);
		String[] trainIdArr = trainIds.split(",");
		List<Train> trainList = trainService.findAll(Arrays.asList(trainIdArr));
		for (Train train : trainList) {
			List<Line> lines = train.getLines();
			lines.add(line);
		}
		line.setTrains(trainList);
		lineService.save(line);
		return SUCCESS_TIP;
	}
}
