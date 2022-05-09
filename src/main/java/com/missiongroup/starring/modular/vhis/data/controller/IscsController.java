package com.missiongroup.starring.modular.vhis.data.controller;

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
import com.missiongroup.starring.common.constant.dictmap.vhis.data.IscsDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.data.domain.Iscs;
import com.missiongroup.starring.modular.vhis.data.domain.dto.IscsDto;
import com.missiongroup.starring.modular.vhis.data.domain.dto.warpper.IscsWarpper;
import com.missiongroup.starring.modular.vhis.data.service.IscsService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: IscsController
 * @Description: iscs管理控制器
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/iscsCtl")
public class IscsController extends BaseController {
	@Autowired
	IscsService iscsService;

    @ApiOperation(value = "新增iscs数据信息", notes = "新增iscs数据信息")
	@ApiImplicitParam(name = "iscs", value = "iscs数据信息", required = true, dataType = "Iscs")
	@PostMapping(value = "/iscs")
	@BussinessLog(value = "新增iscs数据信息", key = "trainnum,mvbdata,recordtime", dict = IscsDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Iscs iscs, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		iscs.setCreateTime(new Date());
		iscs.setCreateUserId(ShiroKit.getUser().getId());
		iscs.setUpdateTime(new Date());
		iscs.setUpdateUserId(ShiroKit.getUser().getId());
		iscsService.save(iscs);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "修改iscs数据信息", notes = "根据ID修改iscs数据信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "iscs", value = "iscs数据信息", required = true, dataType = "IscsDto")//
	})
	@PutMapping(value = "/iscs/{id}")
	@BussinessLog(value = "修改iscs数据信息", key = "trainnum,mvbdata,recordtime", dict = IscsDict.class)
	@ResponseBody
	public Object edit(@PathVariable("id") String id, @Valid @RequestBody Iscs iscs, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		iscs.setUuid(id);
		Iscs cacheIscs = (Iscs) LogObjectHolder.me().get();
		
		cacheIscs.setTrainnum(iscs.getTrainnum());
		cacheIscs.setMvbdata(iscs.getMvbdata());
		cacheIscs.setRecordtime(iscs.getRecordtime());
		cacheIscs.setUpdateTime(new Date());
		cacheIscs.setUpdateUserId(ShiroKit.getUser().getId());
		cacheIscs = iscsService.save(cacheIscs);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "删除iscs数据信息", notes = "删除iscs数据信息")
	@ApiImplicitParam(name = "ids", value = "iscs数据ID列表", required = true, dataType = "String")
	@DeleteMapping(value = "/iscs/{ids}")
	@BussinessLog(value = "删除iscs数据信息", key = "ids", dict = IscsDict.class)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		if (ToolUtil.validateParam(ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		iscsService.delete(ids);
		return SUCCESS_TIP;
	}
	
	@ApiOperation(value = "查询iscs数据信息", notes = "根据ID获取iscs数据信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
	@GetMapping(value = "/iscs/{id}")
	@ResponseBody
	public Object getIscsById(@PathVariable("id") String id) {
		if (ToolUtil.validateParam(id)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Iscs iscs = iscsService.findOneByUuid(id);
		LogObjectHolder.me().set(iscs);
		return iscs;
	}
	
	@ApiOperation(value = "查询iscs数据列表", notes = "查询iscs数据列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, paramType = "PageParam")
	@PostMapping(value = "/list")
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Iscs> iscsList = iscsService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		PageResult pageResult = new PageResult(iscsList);
		pageResult.setRows((List<IscsDto>) new IscsWarpper(pageResult.getRows()).warp());
		return pageResult;
	}
	
	@ApiOperation(value = "查询iscs数据所有列表", notes = "查询iscs数据所有列表")
	@GetMapping(value = "/iscss")
	@ResponseBody
	public Object findAll() {
		List<Iscs> iscsList = iscsService.findAll();
		return  new IscsWarpper(iscsList).warp();
	}
}
