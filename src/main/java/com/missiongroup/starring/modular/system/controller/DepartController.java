package com.missiongroup.starring.modular.system.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.DepartDict;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Depart;
import com.missiongroup.starring.modular.system.domain.dto.DepartDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.DepartWarpper;
import com.missiongroup.starring.modular.system.service.DepartService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: DepartController
 * @Description: 部门控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午1:34:18
 *
 */
@SuppressWarnings("all")
@Api(value = "部门接口详情", description = "部门接口详情")
@Controller
@RequestMapping("/departCtl")
public class DepartController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(DepartController.class);

	@Autowired
	DepartService departService;

	@ApiOperation(value = "新增部门信息", notes = "新增部门信息")
	@ApiImplicitParam(name = "depart", value = "部门信息", required = true, dataType = "Depart")
	@BussinessLog(value = "新增部门信息", key = "name,parentId", dict = DepartDict.class)
	@RequestMapping(value = "/depart", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Valid @RequestBody Depart depart, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		// 判断部门名称是否重复
		Depart currentDepart = departService.findOneByName(depart.getName());
		if (currentDepart != null) {
			throw new BussinessException(BizExceptionEnum.DEPART_ALREADY_REG);
		}
		// 设置父级菜单编号
		departSetPids(depart);
		// 获取同级部门的最大排序号
		Integer maxSort = departService.findMaxSort(depart.getParentId());
		if (maxSort == null) {
			maxSort = 1;
		} else {
			maxSort++;
		}
		depart.setSort(maxSort);
		depart.setCreateTime(new Date());
		depart.setUpdateTime(new Date());
		depart.setCreateUserId(ShiroKit.getUser().getId());
		depart.setUpdateUserId(ShiroKit.getUser().getId());
		departService.save(depart);

		return SUCCESS_TIP;
	}

	@ApiOperation(value = "更新部门信息", notes = "根据departId更新部门信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "departId", value = "部门ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "depart", value = "部门信息", required = true, dataType = "Depart")//
	})
	@BussinessLog(value = "更新部门信息", key = "name,parentId", dict = DepartDict.class)
	@RequestMapping(value = "/depart/{departId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object update(@PathVariable("departId") String departId, @Valid @RequestBody Depart depart, BindingResult result) {
		if (result.hasErrors() || ToolUtil.isEmpty(depart) || departId == null) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		depart.setUuid(departId);
		Depart cacheDepart = (Depart) LogObjectHolder.me().get();
		// 部门名称改变了，判断部门名称是否已经存在
		if (!cacheDepart.getName().equals(depart.getName())) {
			// 判断部门名称是否重复
			Depart theDepart = departService.findOneByName(depart.getName());
			if (theDepart != null) {
				throw new BussinessException(BizExceptionEnum.DEPART_ALREADY_REG);
			}
		}
		// 判断是否将本部门作为上级部门
		if (depart.getUuid().equals(depart.getParentId())) {
			throw new BussinessException(BizExceptionEnum.DEPART_NOT_YOUSELF);
		}
		if (depart.getParentId() != null) {
			Depart parentDepart = departService.findOneByUuid(depart.getParentId());
			if (parentDepart != null && parentDepart.getParentIds() != null && parentDepart.getParentIds().contains(departId)) {
				throw new BussinessException(BizExceptionEnum.DEPART_NOT_SUBTYPE);
			}
		}
		// 获取同级部门的最大排序号
		Integer maxSort = departService.findMaxSort(depart.getParentId());
		if (maxSort == null) {
			maxSort = 1;
		} else {
			maxSort++;
		}
		cacheDepart.setSort(maxSort);
		cacheDepart.setName(depart.getName());
		cacheDepart.setParentId(depart.getParentId());

		// 设置父级菜单编号
		departSetPids(cacheDepart);
		cacheDepart.setUpdateTime(new Date());
		cacheDepart.setUpdateUserId(ShiroKit.getUser().getId());
		cacheDepart = departService.save(cacheDepart);
		// 判断是否修改成功
		if (cacheDepart == null) {
			return new ErrorTip(404, "修改失败");
		}

		return SUCCESS_TIP;
	}

	@ApiOperation(value = "删除部门信息", notes = "根据departIds删除部门信息")
	@ApiImplicitParam(name = "departIds", value = "部门ID列表", required = true, dataType = "String")
	@BussinessLog(value = "删除部门信息", key = "departIds", dict = DepartDict.class)
	@RequestMapping(value = "/depart/{departIds}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("departIds") String departIds) {
		departService.delete(departIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "查询部门信息", notes = "根据departId查询部门信息")
	@ApiImplicitParam(name = "departId", value = "部门ID", required = true, dataType = "String")
	@RequestMapping(value = "/depart/{departId}", method = RequestMethod.GET)
	@ResponseBody
	public Object findOneById(@PathVariable("departId") String departId) {
		if (ToolUtil.validateParam(departId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Depart depart = departService.findOneByUuid(departId);
		depart.setParentIds(depart.getParentIds().replace("[", "").replace("]", ""));
		LogObjectHolder.me().set(depart);
		return depart;
	}

	@ApiOperation(value = "查询部门信息树", notes = "查询部门信息树")
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ResponseBody
	public Object getTree() throws Exception {
		List<Depart> departs = departService.findAll();
		List<DepartDto> departDtos = (List<DepartDto>) new DepartWarpper(departs).warp();
		departDtos = factorTree(departDtos);
		return departDtos;
	}

	private void departSetPids(Depart depart) {
		if (ToolUtil.isEmpty(depart.getParentId()) || "0".equals(depart.getParentId())) {
			depart.setParentId("0");
			depart.setParentIds("[0],");
		} else {
			String pid = depart.getParentId();
			Depart temp = departService.findOneByUuid(pid);
			String pids = temp.getParentIds();
			depart.setParentId(pid);
			depart.setParentIds(pids + "[" + pid + "],");
		}
	}
}
