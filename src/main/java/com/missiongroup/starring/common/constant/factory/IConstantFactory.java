package com.missiongroup.starring.common.constant.factory;

import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.nettyserver.entity.IOMessage;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.Map;

/**
 * 常量生产工厂的接口
 *
 * @author mission
 * @date 2017-06-14 21:12
 */
public interface IConstantFactory {


    /**
     * 根据分组Id获取分组名称
     *
     * @param id
     * @return name
     */
    public String getGroupNameById(String id);

    /**
     * 根据区域Id获取区域名称
     *
     * @param id
     * @return name
     */
    public String getAreaNameById(String id);

    /**
     * 根据用户id获取用户名称
     *
     * @author mission
     * @Date 2017/5/9 23:41
     */
    String getUserNameById(String userId);

    /**
     * 根据用户id获取用户账号
     *
     * @author mission
     * @date 2017年5月16日21:55:371
     */
    String getUserAccountById(String userId);

    /**
     * 通过角色ids获取角色名称
     */
    String getRoleNames(String roleIds);

    /**
     * 通过角色id获取角色名称
     */
    String getSingleRoleName(String roleId);

    /**
     * 通过角色id获取角色英文名称
     */
    String getSingleRoleTip(String roleId);

    /**
     * 获取部门名称
     */
    String getDepartName(String departId);

    /**
     * 获取菜单的名称们(多个)
     */
    String getMenuNames(String menuIds);

    /**
     * 获取菜单名称
     */
    String getMenuName(String menuId);

    /**
     * 获取菜单名称通过编号
     */
    String getMenuNameByCode(String code);

    /**
     * 获取性别名称
     */
    String getSexName(Integer sex);

    /**
     * 获取用户登录状态
     */
    String getStatusName(Integer status);

    /**
     * 获取菜单状态
     */
    String getMenuStatusName(Integer status);

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    String getCacheObject(String para);

    /**
     * 获取子部门id
     */
    List<String> getSubDepartId(String departId);

    /**
     * 获取所有父部门id
     */
    List<String> getParentDepartIds(String departId);

    /**
     * 获取日志名称
     *
     * @param logType
     * @return
     */
    String getLogTypeName(Integer logType);

    /**
     * 获取菜单类型名称
     *
     * @param logType
     * @return
     */
    String getMenuTypeName(Integer menuType);

    /**
     * 根据用户ID获取用户账号集合
     *
     * @param userIds
     * @return
     */
    String getUserAccountsByIds(String userIds);

    /**
     * 根据用户ID列表获取用户姓名集合
     *
     * @param userIds
     * @return
     */
    String getUserNamesByIds(String userIds);


    /**
     * 获取ftp配置
     *
     * @return
     */
    Map<String, String> getFtpConfig();


    /**
     * 获取审核状态
     *
     * @param processState
     * @return
     */
    String getProcessState(Integer processState);


    void sendVehicleData(IOMessage receivedMessage) throws Exception;

    void sendDisconnectData() throws Exception;

    //void saveVehicleData(String data,short trainNum,int portsType,Map<String, Map<String, PortModel>> analysisVehicleData);

}
