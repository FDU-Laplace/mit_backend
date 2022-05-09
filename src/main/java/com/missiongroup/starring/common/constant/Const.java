package com.missiongroup.starring.common.constant;

/**
 * 系统常量
 *
 * @author mission
 * @date 2017年2月12日 下午9:42:53
 */
public interface Const {

	/**
	 * 系统默认的管理员密码
	 */
	String DEFAULT_PWD = "111111";

	/**
	 * 管理员角色的名字
	 */
	String ADMIN_NAME = "admin";

	/**
	 * 管理员id
	 */
	String ADMIN_ID = "00000000000000000000000000000001";

	/**
	 * 超级管理员角色id
	 */
	String ADMIN_ROLE_ID = "00000000000000000000000000000001";

	/**
	 * 接口文档的菜单名
	 */
	String API_MENU_NAME = "接口文档";

	/**
	 * 当前city参数变量名称
	 */
	String VHIS_CITY = "vhis_city";
	
	/**
	 * 当前ftp地址参数变量名称
	 */
	String VHIS_FTP_URL = "vhis_ftp_url";
	
	/**
	 * 当前ftp登录名参数变量名称
	 */
	String VHIS_FTP_LOGINNAME = "vhis_ftp_loginName";
	
	/**
	 * 当前ftp登录密码参数变量名称
	 */
	String VHIS_FTP_PASSWORD = "vhis_ftp_password";

	/**
	 * 线路方向上行
	 */
	String DIRECTION_UP = "1";

	/**
	 * 线路方向下行
	 */
	String DIRECTION_DOWN = "2";
}
