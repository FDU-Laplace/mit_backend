package com.missiongroup.starring.common.exception;

/**
 * 
 * @ClassName: BizExceptionEnum
 * @Description: 所有业务异常的枚举
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午2:26:23
 * 
 *       friendlyCode 唯一规则：7位字符串 从 "1000010"开始 前4位为分类标识 如1000 1010 1020 (10累加)
 *       后三位为数量标识 如 010 020 030 (10累加) 请从枚举的最后面依次累加
 */
public enum BizExceptionEnum {
	/**
	 * 用户角色
	 */
	USER_NO_ROLE("1000010", "用户没有分配角色,请联系管理员"), //

	/**
	 * 字典
	 */
	DICT_EXISTED("1010010", "字典已经存在"), //
	ERROR_CREATE_DICT("1010020", "创建字典失败"), //
	ERROR_WRAPPER_FIELD("1010030", "包装字典属性失败"), //

	/**
	 * 文件上传
	 */
	FILE_READING_ERROR("1020010", "FILE_READING_ERROR!"), //
	FILE_NOT_FOUND("1020020", "FILE_NOT_FOUND!"), //
	UPLOAD_ERROR("1020030", "上传图片出错"), //

	/**
	 * 权限和数据问题
	 */
	DB_RESOURCE_NULL("1030010", "数据库中没有该资源"), //
	NO_PERMITION("1030020", "权限异常"), //
	REQUEST_INVALIDATE("1030030", "请求数据格式不正确"), //
	INVALID_KAPTCHA("1030040", "验证码不正确"), //
	CANT_DELETE_ADMIN("1030050", "不能删除超级管理员"), //
	CANT_FREEZE_ADMIN("1030060", "不能冻结超级管理员"), //
	CANT_CHANGE_ADMIN("1030070", "不能修改超级管理员角色"), //

	/**
	 * 部门问题
	 */
	DEPART_ALREADY_REG("1040010", "该部门已经存在"), //
	DEPART_NOT_YOUSELF("1040020", "不能选择自己作为上级部门"), //
	DEPART_NOT_SUBTYPE("1040030", "不能选择自己的下级作为上级部门"), //

	/**
	 * 角色问题
	 */
	ROLE_ALREADY_REG("1050010", "该角色已经存在"), //
	/**
	 * 账户问题
	 */
	USER_EMAIL_REG("1060010", "该邮箱已经注册"), //
	USER_ALREADY_REG("1060020", "该用户已经注册"), //
	NO_THIS_USER("1060030", "没有此用户"), //
	USER_NOT_EXISTED("1060040", "没有此用户"), //
	ACCOUNT_FREEZED("1060050", "账号被冻结,请联系管理员"), //
	OLD_PWD_NOT_RIGHT("1060060", "原密码不正确"), //
	TWO_PWD_NOT_MATCH("1060070", "两次输入密码不一致"), //
	USER_OR_PASSWORD_ERROR("1060080", "用户名或密码错误"), //
	ACCOUNT_OR_PASSWORD_NOT_NULL("1060090", "账号密码不能为空"), //

	/**
	 * 删除问题
	 */
	DEPART_NOT_DELETE_USER("1070010", "该部门与用户关联，不能删除"), //
	HAVE_SUBDETP_NOT_DELETE("1070020", "该部门有子部门，不能被删除"), //
	ROLE_NOT_DELETE("1070030", "该角色已被引用，不能被删除"), //
	MENU_NOT_DELETE("1070040", "该菜单有子菜单，不能被删除"), //
	DEPART_NOT_DELETE_ROLE("1070050", "该部门与角色关联，不能删除"), //
	USER_NOT_DELETE_YOURSELF("1070060", "用户不能删除自己"), //
	MENU_NOT_DELETE_MUST("1070070", "系统菜单不能删除"), //
	MENU_NOT_STATE_OFF_MUST("1070080", "系统菜单不能禁用"), //

	/**
	 * 全网图问题
	 */
	NETWORK_DIAGRAM_REG("1080010", "全网图名称重复"), //
	NETWORK_DIAGRAM_REQUEST_PARAM("1080020", "请求参数错误"), //

	/**
	 * 配置问题
	 */
	ARGUMENT_REG("1090010", "参数名称已存在"), //
	AREA_REG("1090020", "区域名称已存在"), //
	GROUP_REG("1090030", "分组名称已存在"), //
	DEVICETYPE_REG("1090040", "设备类型名称或编码已存在"), //
	RESOLUTION_REG("1090050", "分辨率已存在"), //
	ARGUMENT_VHIS_CITY_EMPTY("1090060", "参数配置_当前城市(vhis_city)不存在"), //
	PROPERTY_REG("1090070", "属性名称已存在"), //
	ARGUMENT_VHIS_FTP_URL_EMPTY("1090080", "参数配置_当前FTP地址(vhis_ftp_url)不存在"), //
	ARGUMENT_VHIS_FTP_LOGIN_NAME_EMPTY("1090090", "参数配置_当前FTP登录名(vhis_ftp_loginName)不存在"), //
	ARGUMENT_VHIS_FTP_PASSWORD_EMPTY("1090100", "参数配置_当前FTP登录密码(vhis_ftp_password)不存在"), //
	DEVICETYPE_PCODE_COINCIDENCE("1090110", "设备类型编号和副编号不能一致"), //
	DEVICETYPE_NOT_YOUSELF("1090120", "不能选择自己作为上级设备类型"), //
	DEVICETYPE_NOT_SUBTYPE("1090130", "不能选择自己的下级作为上级设备类型"), //
	DEVICETYPE_NOT_DELETE("1090140", "该设备类型与类型属性关联，不能被删除"), //

	/**
	 * 周边公交问题
	 */
	BUS_ALREADY_REG("1110010", "该公交已经存在"), //

	/**
	 * 车站问题
	 */
	STATION_ALREADY_REG("1120010", "该车站已经存在"), //
	STATION_NOT_DELETE("1120020", "该车站与线路关联，不能被删除"), //

	/**
	 * 线路问题
	 */
	LINE_ALREADY_REG("1130010", "该线路已经存在"), //
	LINE_NOT_DELETE("1130020", "该线路与车站关联，不能被删除"), //
	LINE_NOT_DELETE_P("1130030", "该线路与支线或延长线关联，不能被删除"), //

	/**
	 * 流程组问题
	 */
	PROCESS_GROUP_ALREADY_REG("1140010", "该流程组已经存在"), //
	PROCESS_GROUP_NOT_DELETE("1140020", "该流程组与用户关联，不能被删除"), //

	/**
	 * 错误的请求
	 */
	MENU_PCODE_COINCIDENCE("1150010", "菜单编号和副编号不能一致"), //
	EXISTED_THE_MENU("1150020", "菜单编号重复，不能添加"), //
	DICT_MUST_BE_NUMBER("1150030", "字典的值必须为数字"), //
	REQUEST_PARAM("1150040", "请求参数错误"), //
	SESSION_TIMEOUT("1150050", "会话超时"), //
	DRAG_MENU_SORT_ERROR("1150060", "拖拉菜单参数错误"), //
	SERVER_ERROR("1150070", "服务器异常"), //
	REQUEST_NULL("1150080", "请求有错误"), //
	MENU_NOT_YOUSELF("1150090", "不能选择自己作为上级菜单"), //
	MENU_NOT_SUBTYPE("1150100", "不能选择自己的下级作为上级菜单"), //

	/**
	 * 其他
	 */
	WRITE_ERROR("1160010", "渲染界面错误"), //

	/**
	 * 资源管理问题
	 */
	RESOURCE_DIRECTORY_ALREADY_REG("1170010", "该文件夹已经存在"), //
	RESOURCE_FILE_ALREADY_REG("1170020", "该文件已经存在"), //
	RESOURCE_NOT_COPY_YOURSELF_OR_SUBDIRECTORIES("1170030", "不能将文件复制到自身或其子目录下"), //
	RESOURCE_NOT_MOVE_YOURSELF_OR_SUBDIRECTORIES("1170040", "不能将文件移动到自身或其子目录下"), //
	RESOURCE_UPLOAD_ERROR("1170050", "资源上传失败"), //

	/**
	 * 普通信息问题
	 */
	NORMAL_INFO__ALREADY_REG("1180010", "该普通信息已经存在"), //

	/**
	 * 紧急信息问题
	 */
	EMERGENCY_INFO__ALREADY_REG("1190010", "该紧急信息已经存在"), //

	/**
	 * 设备问题
	 */
	DEVICE_ALREADY_REG("1200010", "该设备已经存在"), //

	/**
	 * 策略管理问题
	 */
	POLICY_REQUEST_PARAM("1210010", "请求参数错误"), //
	POLICY_NAME_ALREADY_HAVE("1210020", "策略名已存在"), //
	POLICY_EDIT_ERROR("1210030", "策略修改失败"), //

	/**
	 * netty通信问题
	 */
	NETTY_CONNECT_ERROR("1220010", "连接错误"),

	/**
	 * 资源类型配置问题
	 */
	RESOURCETYPE_NAME_ALREADE_HAVE("1230010", "类型名称已存在"),

	/**
	 * 栏目问题
	 */
	COLUMN_REQUEST_PARAM("1240010", "请求参数错误"), //
	COLUMN_NAME_ALREADE_HAVE("1240020", "栏目名称已存在"),
	COLUMN_RESOURCES_NOT_EXIST("1240030", "资源不存在"),
	
	/**
	 * 播表问题
	 */
	PLAYLIST_REQUEST_PARAM("1250010","请求参数错误"),
	PLAYLIST_NAME_ALREADE_HAVE("1250020","播表名已存在"),
	PLAYLIST_POLICY_NOT_EXIST("1250030","策略不存在"),
	PLAYLIST_POLICY_COLUMN_IS_ERROR("1250040","策略栏目不满24小时"),
	PLAYLIST_IMPORT_EXCEL_IS_ERROR("1250050","播表EXCEL有误"),
	
	/**
	 * 播出计划问题
	 */
	PLAYPLAN_REQUEST_PARAM("1260010", "请求参数错误"),
	PLAYPLAN_NAME_ALREADY_HAVE("1260020", "计划名已存在"),
	PLAYPLAN_EDIT_ERROR("1260030", "播出计划编辑失败"),
	
	/**
	 * 直播源配置问题
	 */
	PLAYSOURCE_NAME_ALREADY_HAVE("1270010","直播源名称已存在"), //
	
	/**
	 * PA问题
	 */
	PA_LOGIN_ERROR("1280010", "登录失败"), //
	
	/**
	 * 车站广播问题
	 */
	AUDIORESOURCE_UPLOAD_ERROR("1290010", "音频上传失败"), //
	AUDIORESOURCE_DIRECTORY_ALREADY_REG("1290010", "该音频已经存在"),

	/**
	 * 故障等级配置管理
	 */
	FAULT_LEVEL_ALREADY_EXISTS("1300010", "等级信息已存在"), //
	FAULT_ICON_ALREADY_EXISTS("1300012", "等级图标已存在"), //
	FAULT_LEVEL_NOT_EXISTS("1300011", "等级信息不存在"), //
	ASSOCIATED_FAULT_CONFIGURATION_EXISTS("1300012", "存在关联故障配置信息，不能删除"); //

	BizExceptionEnum(String code, String message) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
	}

	BizExceptionEnum(String code, String message, String urlPath) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
		this.urlPath = urlPath;
	}

	private String friendlyCode;

	private String friendlyMsg;

	private String urlPath;

	public String getCode() {
		return friendlyCode;
	}

	public void setCode(String code) {
		this.friendlyCode = code;
	}

	public String getMessage() {
		return friendlyMsg;
	}

	public void setMessage(String message) {
		this.friendlyMsg = message;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
}