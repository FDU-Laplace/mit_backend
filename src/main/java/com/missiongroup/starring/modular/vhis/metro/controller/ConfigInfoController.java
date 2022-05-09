package com.missiongroup.starring.modular.vhis.metro.controller;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.LineDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.support.StrKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.ConfigInfo;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.ConfigInfoDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.ConfigInfoWrapper;
import com.missiongroup.starring.modular.vhis.metro.service.ConfigInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Api(value = "数据配置")
@Controller
@RequestMapping("/ConfigInfoCtl")
public class ConfigInfoController extends BaseController {

    @Autowired
    private ConfigInfoService configInfoService;

    @ApiOperation(value = "新增vhis数据配置", notes = "新增vhis数据配置")
    @ApiImplicitParam(name = "ConfigInfo", value = "vhis数据配置", required = true, dataType = "ConfigInfo")
//    @BussinessLog(value = "新增vhis配置", key = "", dict = )
    @ResponseBody
    @PostMapping(value = "/config")
    public Object add(@Valid @RequestBody ConfigInfo info, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        info.setCreateTime(new Date());
        info.setCreateUserId(ShiroKit.getUser().getId());
        info.setUpdateTime(new Date());
        info.setUpdateUserId(ShiroKit.getUser().getId());
        configInfoService.save(info);
        return SUCCESS_TIP;
    }

    @PutMapping(value = "/config/{id}")
    @BussinessLog(value = "修改vhis线路信息", key = "lineId,lineType,,lineColor,lineName,lineNameEn,lineNum,lineCode,isRun", dict = LineDict.class)
    @ResponseBody
    public Object edit(@PathVariable("id") String id, @Valid @RequestBody ConfigInfo info, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        info.setUuid(id);

        ConfigInfo configInfo = (ConfigInfo) LogObjectHolder.me().get();
        configInfo.setName(info.getName());
        configInfo.setNumber(info.getNumber());
        configInfo.setPort(info.getPort());
        configInfo.setField(info.getField());
        configInfo.setComment(info.getComment());
        configInfo.setUpdateTime(new Date());
        configInfo.setUpdateUserId(ShiroKit.getUser().getId());
        configInfo = configInfoService.save(configInfo);

        return SUCCESS_TIP;
    }

    @ApiOperation(value = "删除vhis配置", notes = "删除vhis配置")
    @ApiImplicitParam(name = "ids", value = "vhis线路ID列表", required = true, dataType = "String")
    @DeleteMapping(value = "/config/{ids}")
    @BussinessLog(value = "删除vhis线路信息", key = "ids", dict = LineDict.class)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (ToolUtil.validateParam(ids)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        configInfoService.delete(ids);
        return SUCCESS_TIP;
    }

    @ApiOperation(value = "查询vhis配置", notes = "根据ID获取vhis配置")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String")
    @GetMapping(value = "/config/{id}")
    @ResponseBody
    public Object getLineById(@PathVariable("id") String id) {
        if (ToolUtil.validateParam(id)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        ConfigInfo info = configInfoService.findOneByUuid(id);
        LogObjectHolder.me().set(info);
        return info;
    }

    @ApiOperation(value = "查询vhis数据配置", notes = "查询vhis数据配置")
    @ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
    @PostMapping(value = "/list")
    @ResponseBody
    //@Cacheable(value = "configList", unless = "#result==null")
    public PageResult list(@RequestBody PageParam pageParam) {
        Page<ConfigInfo> CarriageList = configInfoService.findAll(pageParam.formatPageable(), pageParam.getCondition());
        PageResult pageResult = new PageResult(CarriageList);
        pageResult.setRows((List<ConfigInfoDto>) new ConfigInfoWrapper(pageResult.getRows()).warp());
        return pageResult;
    }

    @ApiOperation(value = "查询vhis所有配置", notes = "查询vhis所有配置")
    @GetMapping(value = "/configs")
    @ResponseBody
    public Object findAll() {
        List<ConfigInfo> configList = configInfoService.findAll();
        return new ConfigInfoWrapper(configList).warp();
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile excel, HttpSession session)
            throws Exception {
        if (excel.getSize() <= 0) {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }
        String fileName = excel.getOriginalFilename();

        Workbook workbook = null;

        if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
            workbook = new HSSFWorkbook(excel.getInputStream());
        } else {
            throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
        }

        Sheet sheet = workbook.getSheetAt(0);
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            // 名称
            String name = row.getCell(0).getStringCellValue();
            // 编号
            String number = row.getCell(1).getStringCellValue();
            // 端口
            String port = row.getCell(2).getStringCellValue();
            // 字段
            String field = row.getCell(3).getStringCellValue();
            // 备注
            String comment = row.getCell(4).getStringCellValue();

            ConfigInfo configInfo = new ConfigInfo(name, number, port, field, comment);
            configInfo.setCreateTime(new Date());
            configInfo.setCreateUserId(ShiroKit.getUser().getId());
            configInfo.setUpdateTime(new Date());
            configInfo.setUpdateUserId(ShiroKit.getUser().getId());
            configInfoService.save(configInfo);
        }
        return SUCCESS_TIP;
    }

    @GetMapping("/template")
    @ResponseBody
    public Object downloadTemplate(HttpServletResponse response) throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        String fieName = "模板.xls";
        File f = new File(path, fieName);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(fieName);

        // HEAD样式
        HSSFCellStyle headStyle = workbook.createCellStyle();
        HSSFFont headFont = workbook.createFont();
        headFont.setFontName("Aktiv Grotesk Medium");
        headFont.setFontHeightInPoints((short) 10);
        headFont.setBold(true);
        headStyle.setFont(headFont);
        headStyle.setLocked(false);

        // CELL样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont cellFont = workbook.createFont();
        cellFont.setFontName("Aktiv Grotesk Medium");
        cellFont.setFontHeightInPoints((short) 10);
        cellStyle.setFont(cellFont);
        String[] strings = Stream.of("名称", "编号", "端口", "字段", "备注").toArray(String[]::new);
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < strings.length; i++) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(strings[i]);
            headCell.setCellStyle(headStyle);
            sheet.setDefaultColumnStyle(i, cellStyle);
        }
        sheet.createFreezePane(0, 1, 0, 1);
        FileOutputStream fos = new FileOutputStream(f);
        workbook.write(fos);
        fos.close();
        workbook.close();


        long len = f.length();
        FileInputStream is = new FileInputStream(f);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + StrKit.specialCharHandler(f.getName()));
        response.addHeader("Content-Length", String.valueOf(len));
        response.setContentType("application/octet-stream");
        response.getOutputStream().write(buffer);
        is.close();

        return SUCCESS_TIP;
    }

    @PostMapping("/refresh")
    @ResponseBody
    @CacheEvict(value = "configList")
    public Object refresh(@RequestBody PageParam pageParam) {
        return this.list(pageParam);
    }

    @PostMapping("/export")
    @ResponseBody
    public Object export(@RequestBody PageParam pageParam, HttpServletResponse response) throws IOException {
        Page<ConfigInfo> CarriageList = configInfoService.findAll(pageParam.formatPageable(), pageParam.getCondition());

        String path = System.getProperty("java.io.tmpdir");
        String fieName = "export.xls";
        File f = new File(path, fieName);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(fieName);

        // HEAD样式
        HSSFCellStyle headStyle = workbook.createCellStyle();
        HSSFFont headFont = workbook.createFont();
        headFont.setFontName("Aktiv Grotesk Medium");
        headFont.setFontHeightInPoints((short) 10);
        headFont.setBold(true);
        headStyle.setFont(headFont);
        headStyle.setLocked(false);

        // CELL样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont cellFont = workbook.createFont();
        cellFont.setFontName("Aktiv Grotesk Medium");
        cellFont.setFontHeightInPoints((short) 10);
        cellStyle.setFont(cellFont);
        String[] strings = Stream.of("名称", "编号", "端口", "字段", "备注").toArray(String[]::new);
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < strings.length; i++) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(strings[i]);
            headCell.setCellStyle(headStyle);
        }

        for (int i = 1; i <= CarriageList.getSize(); i++) {
            HSSFRow row = sheet.createRow(i);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(CarriageList.getContent().get(i - 1).getName());
            cell0.setCellStyle(cellStyle);

            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(CarriageList.getContent().get(i - 1).getNumber());
            cell1.setCellStyle(cellStyle);

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(CarriageList.getContent().get(i - 1).getPort());
            cell2.setCellStyle(cellStyle);

            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(CarriageList.getContent().get(i - 1).getField());
            cell3.setCellStyle(cellStyle);

            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue(CarriageList.getContent().get(i - 1).getComment());
            cell4.setCellStyle(cellStyle);

        }

        sheet.createFreezePane(0, 1, 0, 1);
        FileOutputStream fos = new FileOutputStream(f);
        workbook.write(fos);
        fos.close();
        workbook.close();


        long len = f.length();
        FileInputStream is = new FileInputStream(f);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + StrKit.specialCharHandler(f.getName()));
        response.addHeader("Content-Length", String.valueOf(len));
        response.setContentType("application/octet-stream");
        response.getOutputStream().write(buffer);
        is.close();

        return SUCCESS_TIP;
    }

}