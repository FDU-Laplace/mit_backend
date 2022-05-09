package com.missiongroup.starring.common.constant.factory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.nettyserver.entity.IOMessage;
import com.missiongroup.starring.core.vehicleData.*;
import com.missiongroup.starring.modular.vhis.data.websocket.DDUDataSocket;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.common.constant.cache.Cache;
import com.missiongroup.starring.common.constant.cache.CacheKey;
import com.missiongroup.starring.common.constant.state.ManagerStatus;
import com.missiongroup.starring.common.constant.state.MenuStatus;
import com.missiongroup.starring.common.constant.state.MenuType;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.support.StrKit;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Depart;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.service.DepartService;
import com.missiongroup.starring.modular.system.service.MenuService;
import com.missiongroup.starring.modular.system.service.RoleService;
import com.missiongroup.starring.modular.system.service.UserService;


/**
 * 常量的生产工厂
 *
 * @author mission
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {
    private RoleService roleService = SpringContextHolder.getBean(RoleService.class);
    private DepartService departService = SpringContextHolder.getBean(DepartService.class);
    private UserService userService = SpringContextHolder.getBean(UserService.class);
    private MenuService menuService = SpringContextHolder.getBean(MenuService.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 根据用户id获取用户名称
     *
     * @author mission
     * @Date 2017/5/9 23:41
     */
    @Override
    public String getUserNameById(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return "--";
        }
        User user = userService.findOneByUuid(userId);
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author mission
     * @date 2017年5月16日21:55:371
     */
    @Override
    public String getUserAccountById(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return "--";
        }
        User user = userService.findOneByUuid(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色ids获取角色名称
     */
    @Override
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.ROLES_NAME + "'+#roleIds")
    public String getRoleNames(String roleIds) {
        if (ToolUtil.isNotEmpty(roleIds)) {
            String[] roles = roleIds.split(",");
            StringBuilder sb = new StringBuilder();
            for (String roleId : roles) {
                Role roleObj = roleService.findOneByUuid(roleId);
                if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
                    sb.append(roleObj.getName()).append(",");
                }
            }
            return StrKit.removeSuffix(sb.toString(), ",");
        }
        return "";
    }

    /**
     * 通过角色id获取角色名称
     */
    @Override
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_NAME + "'+#roleId")
    public String getSingleRoleName(String roleId) {
        if ("0".equals(roleId)) {
            return "--";
        }
        Role roleObj = roleService.findOneByUuid(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    /**
     * 通过角色id获取角色英文名称
     */
    @Override
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_TIP + "'+#roleId")
    public String getSingleRoleTip(String roleId) {
        if ("0".equals(roleId)) {
            return "--";
        }
        Role roleObj = roleService.findOneByUuid(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    /**
     * 获取部门名称
     */
    @Override
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.DEPART_NAME + "'+#departId")
    public String getDepartName(String departId) {
        Depart depart = departService.findOneByUuid(departId);
        if (ToolUtil.isNotEmpty(depart) && ToolUtil.isNotEmpty(depart.getName())) {
            return depart.getName();
        }
        return "";
    }

    /**
     * 获取菜单的名称们(多个)
     */
    @Override
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.MENUS_NAME + "'+#menuIds")
    public String getMenuNames(String menuIds) {
        String[] menus = menuIds.split(",");
        StringBuilder sb = new StringBuilder();
        for (String menu : menus) {
            Menu menuObj = menuService.findOneByUuid(menu);
            if (ToolUtil.isNotEmpty(menuObj) && ToolUtil.isNotEmpty(menuObj.getName())) {
                sb.append(menuObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 获取菜单名称
     */
    @Override
    public String getMenuName(String menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            return "";
        } else {
            Menu menu = menuService.findOneByUuid(menuId);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取菜单名称通过编号
     */
    @Override
    public String getMenuNameByCode(String code) {
        if (ToolUtil.isEmpty(code)) {
            return "";
        } else {
            Menu menu = menuService.findOneByCode(code);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取性别名称
     */
    @Override
    public String getSexName(Integer sex) {
        if (sex == 2) {
            return "女";
        } else if (sex == 1) {
            return "男";
        }
        return "";
    }

    /**
     * 获取用户登录状态
     */
    @Override
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }

    /**
     * 获取菜单状态
     */
    @Override
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    @Override
    public String getCacheObject(String para) {
        return LogObjectHolder.me().get().toString();
    }

    /**
     * 获取子部门id
     */
    @Override
    public List<String> getSubDepartId(String departId) {
        List<Depart> departs = departService.findByParentIdsLike(departId);
        ArrayList<String> departIds = new ArrayList<String>();

        if (null != departs && departs.size() > 0) {
            for (Depart depart : departs) {
                departIds.add(depart.getUuid());
            }
        }
        return departIds;
    }

    /**
     * 获取所有父部门id
     */
    @Override
    public List<String> getParentDepartIds(String departId) {
        Depart depart = departService.findOneByUuid(departId);
        String pids = depart.getParentIds();
        String[] split = pids.split(",");
        ArrayList<String> parentDepartIds = new ArrayList<String>();
        for (String s : split) {
            parentDepartIds.add(s);
        }
        return parentDepartIds;
    }

    @Override
    public String getLogTypeName(Integer logType) {
        if (logType == 0) {
            return "登录成功日志";
        } else if (logType == 1) {
            return "登录失败日志";
        } else if (logType == 2) {
            return "退出日志";
        } else if (logType == 3) {
            return "异常日志";
        } else if (logType == 4) {
            return "业务日志";
        }
        return "";
    }

    @Override
    public String getMenuTypeName(Integer menuType) {
        return MenuType.valueOf(menuType);
    }

    @Override
    public String getUserAccountsByIds(String userIds) {
        String userAccounts = "";
        String[] ids = userIds.split(",");
        for (String id : ids) {
            User user = userService.findOneByUuid(id);
            if (user != null) {
                userAccounts = userAccounts + user.getAccount() + ",";
            } else {
                userAccounts = userAccounts + "--" + ",";
            }
        }
        return StrKit.removeSuffix(userAccounts, ",");
    }


    @Override
    public String getUserNamesByIds(String userIds) {
        String userNames = "";
        String[] ids = userIds.split(",");
        for (String id : ids) {
            User user = userService.findOneByUuid(id);
            if (user != null) {
                userNames = userNames + user.getName() + ",";
            } else {
                userNames = userNames + "--" + ",";
            }
        }
        return StrKit.removeSuffix(userNames, ",");

    }

    @Override
    public String getProcessState(Integer processState) {
        String state = "制作中";
        if (ToolUtil.isNotEmpty(processState)) {
            if (processState == 0) {
                state = "待提交";
            } else if (processState == 1) {
                state = "待审核";
            } else if (processState == 2) {
                state = "审批通过";
            } else if (processState == 3) {
                state = "审核驳回";
            }
        }
        return state;
    }


    @Override
    public String getGroupNameById(String id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String getAreaNameById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> getFtpConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 发送车载数据
     *
     * @param receivedMessage
     */
    @Override
    public void sendVehicleData(IOMessage receivedMessage) throws Exception {
        // TODO Auto-generated method stub
        Map portDatas = receivedMessage.getPortDatas();
        DatatFactory datatFactory = new DatatFactory(portDatas);
        Map data = datatFactory.createTotalData();
        DDUDataSocket.sendInfo(JSON.toJSONString(data, SerializerFeature.DisableCircularReferenceDetect));
    }

    /**
     * 车载信号断开发送数据
     * @throws Exception
     */
    @Override
    public void sendDisconnectData() throws Exception {
        Map<String, Object> totalData = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Map<String,Object> TrainState = new HashMap<>();
        TrainState.put("TrainState","DISCONNECT");
        data.put("state_Of_Train", TrainState);
        totalData.put("top", data);
        DDUDataSocket.sendInfo(JSON.toJSONString(totalData, SerializerFeature.DisableCircularReferenceDetect));

    }

    /**
     * 保存车载数据
     *//*
    @Override
    public void saveVehicleData(String data,short trainNum,int portType,Map<String, Map<String, PortModel>> analysisVehicleData) {

            String daName="";
            String tableName="d_"+trainNum;
            if(portType==0){
                daName="vhis_org_slow";

            }else if(portType==1){
                daName="vhis_org_fast";
            }
            *//*dataBaseMapper.createDatabase(daName);
            StringBuffer insetPort=new StringBuffer();
            insetPort.append("create table if not exists ").append(daName+"."+tableName).append("(ts TIMESTAMP,originalData BINARY(10000))");
            tableMapper.createSTable(insetPort.toString());*//*
            long time = new Date().getTime();
            StringBuilder originalBuffer = new StringBuilder();
            String originalData = data.replaceAll("\\s", "");
            originalBuffer.append(daName+"."+tableName+ " (ts, originalData) values (").append(time+",'"+originalData+"')");

            List ss=new ArrayList();
            StringBuilder vehicleBuffer = new StringBuilder();
            vehicleBuffer.append("INSERT INTO ");

            for (Map.Entry<String, Map<String, PortModel>> mapEntry : analysisVehicleData.entrySet()) {
                String key = mapEntry.getKey();
                String analysis_daName="vhis_analysis";
                String analysis_tableName="d_"+key;
                Map<String, PortModel> value = mapEntry.getValue();
                String insertSql = createInsertSql(analysis_daName,analysis_tableName, value,time);
                vehicleBuffer.append(insertSql);
                ss.add(insertSql);
                if(Math.floorMod(ss.size(), 10)==0){
                    DataSaveRunnable dataSaveRunnable = new DataSaveRunnable(vehicleBuffer.toString());
                    executorService.execute(dataSaveRunnable);
                    vehicleBuffer = new StringBuilder();
                    vehicleBuffer.append("INSERT INTO ");
                    ss.clear();
                }
            }
                DataSaveRunnable dataSaveRunnable = new DataSaveRunnable(vehicleBuffer.toString());
                executorService.execute(dataSaveRunnable);
                vehicleBuffer.append(originalBuffer);
            //analysisDataMapper.insertVehicleData(vehicleBuffer.toString());

    }
*/

    /**
     * 生成插入sql语句
     *
     * @param tableName
     * @param map
     * @return
     */
    public static String createInsertSql(String dbName, String tableName, Map<String, PortModel> map, long time) {
        StringBuilder buffer = new StringBuilder();
        //buffer.append(dbName+"."+tableName).append(" (");
        buffer.append(dbName + "." + tableName).append(" ");
        Set<Map.Entry<String, PortModel>> set = map.entrySet();

        StringBuilder keys = new StringBuilder("");
        StringBuilder value = new StringBuilder("");

        for (Map.Entry<String, PortModel> entry : set) {
            //keys.append(humpToLine(entry.getKey())).append(",");
            value.append(entry.getValue().getValue()).append(",");
        }

        //keys.deleteCharAt(keys.length() - 1);
        value.deleteCharAt(value.length() - 1);

        //buffer.append(keys).append(") VALUES(").append(value).append(")");

        buffer.append(keys).append(" VALUES(").append(time + "," + value).append(")");
        return buffer.toString();
    }

    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(0));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");
}
