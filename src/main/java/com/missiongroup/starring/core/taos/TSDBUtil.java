package com.missiongroup.starring.core.taos;

import com.taosdata.jdbc.TSDBDriver;
import net.sf.cglib.beans.BeanMap;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xw
 */
public class TSDBUtil {
	private Connection connection;
	private boolean databaseColumnHumpToLine;

	/**
	 * 使用参数值进行传递创建链接
	 *
	 * @param url                      url 例如 ：
	 *                                 "jdbc:TAOS://127.0.0.1:6020/netuo_iot"
	 * @param username                 例如： "root"
	 * @param password                 例如： "taosdata"
	 * @param databaseColumnHumpToLine 是否需要数据库列名下划线转驼峰
	 */
	public TSDBUtil(String url, String username, String password, boolean databaseColumnHumpToLine)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.taosdata.jdbc.TSDBDriver");
		String jdbcUrl = url;
		Properties connProps = new Properties();
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_USER, username);
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_PASSWORD, password);
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_CONFIG_DIR, "/etc/taos");
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_CHARSET, "UTF-8");
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_LOCALE, "en_US.UTF-8");
		connProps.setProperty(TSDBDriver.PROPERTY_KEY_TIME_ZONE, "UTC-8");
		this.connection = DriverManager.getConnection(jdbcUrl, connProps);
		this.databaseColumnHumpToLine = databaseColumnHumpToLine;
	}

	/**
	 * 传递连接
	 *
	 * @param connection
	 * @param databaseColumnHumpToLine
	 */
	public TSDBUtil(Connection connection, boolean databaseColumnHumpToLine) {
		this.connection = connection;
		this.databaseColumnHumpToLine = databaseColumnHumpToLine;
	}
	/**
	 * 使用配置文件进行创建链接
	 * @param databaseColumnHumpToLine
	 */
	public TSDBUtil(boolean databaseColumnHumpToLine)  {
		try {
			InputStream is = TSDBUtil.class.getClassLoader().getResourceAsStream("taosdb.properties");
			Properties properties = new Properties();
			properties.load(is);

			String tsdbProtocal = properties.get("tsdbProtocal").toString();
			String tsdbDriver = properties.get("tsdbDriver").toString();
			String tsdbHost = properties.get("tsdbHost").toString();
			String tsdbUser = properties.get("tsdbUser").toString();
			String tsdbPwd = properties.get("tsdbPwd").toString();
			String tsdbDateBase="";
			tsdbDateBase = properties.get("tsdbDateBaseAnalysis").toString();
			int tsdbPort = Integer.valueOf((String) properties.get("tsdbPort"));
			String jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", tsdbProtocal, tsdbHost, tsdbPort,
					tsdbDateBase, tsdbUser, tsdbPwd);
			this.connection = DriverManager.getConnection(jdbcUrl, properties);
			this.databaseColumnHumpToLine = databaseColumnHumpToLine;
		} catch (SQLException | IOException e) {
			throw new RuntimeException("得到链接时出错了", e);
		}
	}
	/**
	 * 使用配置文件进行创建链接
	 * @param databaseColumnHumpToLine
	 */
	public TSDBUtil(boolean databaseColumnHumpToLine,int portType)  {
		try {
			InputStream is = TSDBUtil.class.getClassLoader().getResourceAsStream("taosdb.properties");
			Properties properties = new Properties();
			properties.load(is);

			String tsdbProtocal = properties.get("tsdbProtocal").toString();
			String tsdbDriver = properties.get("tsdbDriver").toString();
			String tsdbHost = properties.get("tsdbHost").toString();
			String tsdbUser = properties.get("tsdbUser").toString();
			String tsdbPwd = properties.get("tsdbPwd").toString();
			String tsdbDateBase="";
			if(portType==0){
				 tsdbDateBase = properties.get("tsdbDateBaseSlow").toString();
			}else{
				 tsdbDateBase = properties.get("tsdbDateBaseFast").toString();
			}
			int tsdbPort = Integer.valueOf((String) properties.get("tsdbPort"));
			String jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", tsdbProtocal, tsdbHost, tsdbPort,
					tsdbDateBase, tsdbUser, tsdbPwd);
			this.connection = DriverManager.getConnection(jdbcUrl, properties);
			this.databaseColumnHumpToLine = databaseColumnHumpToLine;
		} catch (SQLException | IOException e) {
			throw new RuntimeException("得到链接时出错了", e);
		}
	}
	/**
	 * 关闭数据库所有链接
	 * 
	 * @param connection Connection链接对象
	 * @param pStatement pStatement链接对象
	 * @param resultSet  resultSet对象
	 */
	protected void closeAll(Connection connection, Statement pStatement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("关闭resultSet时出错了", e);
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("关闭pStatement时出错了！", e);
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException("关闭connection链接时出错了！", e);
				}
			}
		}
	}

	/**
	 * 为Sql语句的占位符赋值
	 * 
	 * @param param      参数列表
	 * @param pStatement pStatement对象
	 * @throws SQLException
	 */
	protected void addParamters(Object[] param, PreparedStatement pStatement) throws SQLException {
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pStatement.setObject(i + 1, param[i]);
			}
		}
	}

	/**
	 * 执行sql（无论是否返回结果），将结果注入到指定的类型实例中，且返回 当查询到的数据大于一个时，取第一个
	 * <p>
	 * 对象遵从以下说明<br/>
	 * 1.对象字段为String类型，数据库类型(通过jdbc读取到的)无论什么类型，都将调用Object.toString方法注入值<br/>
	 * 2.对象字段为数据库类型(通过jdbc读取到的)一致的情况下，将会直接注入<br/>
	 * 3.对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试使用{@link Class#cast(Object)}方法转型，失败此值会是类型默认值(故实体推荐使用封装类型)<br/>
	 * 4.对象字段为{@link Date}时，数据库类型为Date才可以注入，如果为long(例如TDengine)将会被当作毫秒的时间戳注入<br/>
	 *
	 * @param sql   要执行的sql
	 * @param param 要执行的sql的条件参数
	 * @param clazz 要注入的实体类型
	 * @param <T>   要注入的实体类型
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	public <T> T getOne(String sql, Class<T> clazz, Object[] param) {

		ResultSet resultSet = null;
		PreparedStatement pStatement = null;
		try {
			Method[] setterMethods = getSetterMethods(clazz);
			pStatement = connection.prepareStatement(sql);

			addParamters(param, pStatement);
			resultSet = pStatement.executeQuery();
			// 只有一个结果直接下一个就行
			resultSet.next();
			return resultSetToObject(resultSet, setterMethods, clazz);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		} finally {
			closeAll(connection, pStatement, resultSet);
		}
	}

	/**
	 * 执行sql（无论是否返回结果），将结果注入到指定的类型实例中，且返回 当查询到的结果没有时，返回一个大小为0的list;
	 * <p>
	 * 对象遵从以下说明<br/>
	 * 1.对象字段为String类型，数据库类型(通过jdbc读取到的)无论什么类型，都将调用Object.toString方法注入值<br/>
	 * 2.对象字段为数据库类型(通过jdbc读取到的)一致的情况下，将会直接注入<br/>
	 * 3.对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试使用{@link Class#cast(Object)}方法转型，失败此值会是类型默认值(故实体推荐使用封装类型)<br/>
	 * 4.对象字段为{@link Date}时，数据库类型为Date才可以注入，如果为long(例如TDengine)将会被当作毫秒的时间戳注入<br/>
	 *
	 * @param sql   要执行的sql
	 * @param param 要执行的sql的条件参数
	 * @param clazz 要注入的实体类型
	 * @param <T>   要注入的实体类型
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	public <T> List<T> getList(String sql, Class<T> clazz, Object[] param) {
		List<T> list = new ArrayList<>();
		ResultSet resultSet = null;
		PreparedStatement pStatement = null;
		try {
			Method[] setterMethods = getSetterMethods(clazz);

			pStatement = connection.prepareStatement(sql);
			addParamters(param, pStatement);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				list.add(resultSetToObject(resultSet, setterMethods, clazz));
			}
			return list;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		} finally {
			closeAll(connection, pStatement, resultSet);
		}
	}

	/**
	 * 执行sql（无论是否返回结果），返回一个MAP
	 *
	 * @param sql   要执行的sql
	 * @param param 要执行的sql的条件参数
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getList(String sql, Object[] param) {
		List<Map<String, Object>> ls = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			pStatement = connection.prepareStatement(sql);
			addParamters(param, pStatement);
			resultSet = pStatement.executeQuery();
			// 获取结果集中的原始数据源
			ResultSetMetaData rsd = resultSet.getMetaData();
			int columnCount = rsd.getColumnCount();
			String[] columnName = new String[columnCount];
			ls = new ArrayList<Map<String, Object>>();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnName.length; i++) {
					columnName[i] = rsd.getColumnName(i + 1).toString();
					Object value = resultSet.getObject(columnName[i]);
					map.put(columnName[i], value);
				}
				ls.add(map);
			}
			return ls;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		} finally {
			closeAll(connection, pStatement, resultSet);
		}
	}

	/**
	 * 插入对象到指定的表里面
	 * 
	 * @param tableName
	 * @param o
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("all")
	public boolean insert(String tableName, Object o) throws SQLException {
		Class clazz = o.getClass();
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> map = BeanMap.create(o);
		data.putAll(map);
		data.put("time",new Date());
		String sql = createInsertSql(tableName, data);
		return connection.createStatement().execute(sql);
	}

	public  static String createTableSql(String tableName, Object o){
		Map<String, Object> map = BeanMap.create(o);
		StringBuilder buffer = new StringBuilder();
		buffer.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (time timestamp,");
		Set<Map.Entry<String, Object>> set = map.entrySet();

		StringBuilder keys = new StringBuilder("");

		for (Map.Entry<String, Object> entry : set) {
			keys.append(entry.getKey()).append(" BIGINT ,");
		}

		keys.deleteCharAt(keys.length() - 1);
		buffer.append(keys).append(")");

		return buffer.toString();
	}
	/**
	 * 生成插入sql语句
	 * 
	 * @param tableName
	 * @param map
	 * @return
	 */
	public static String createInsertSql(String tableName, Map<String, Object> map) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("INSERT INTO ").append(tableName).append(" (");

		Set<Map.Entry<String, Object>> set = map.entrySet();

		StringBuilder keys = new StringBuilder("");
		StringBuilder value = new StringBuilder("");

		for (Map.Entry<String, Object> entry : set) {
			keys.append(humpToLine(entry.getKey())).append(",");
			try {
				if (entry.getValue().getClass().equals(Date.class)) {
					Date d = (Date) entry.getValue();
					value.append(d.getTime()).append(",");
				}else if (entry.getValue().getClass().equals(Integer.class)) {
					value.append(entry.getValue()).append(",");
				}else {
					value.append("'").append(entry.getValue()).append("'").append(",");
				}
			} catch (Exception ignored) {

			}
		}

		keys.deleteCharAt(keys.length() - 1);
		value.deleteCharAt(value.length() - 1);

		buffer.append(keys).append(") VALUES(").append(value).append(")");

		return buffer.toString();
	}

	/**
	 * 将resultSet注入到指定的类型实例中，且返回 对象遵从以下说明<br/>
	 * 1.对象字段为String类型，数据库类型(通过jdbc读取到的)无论什么类型，都将调用Object.toString方法注入值<br/>
	 * 2.对象字段为数据库类型(通过jdbc读取到的)一致的情况下，将会直接注入<br/>
	 * 3.对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试使用{@link Class#cast(Object)}方法转型，失败此值会是类型默认值(故实体推荐使用封装类型)<br/>
	 * 4.对象字段为{@link Date}时，数据库类型为Date才可以注入，如果为long(例如TDengine)将会被当作毫秒的时间戳注入<br/>
	 * <p>
	 * 注意，此方法只会注入一个结果,不会循环{@link ResultSet#next()}方法，请从外部调用。<br/>
	 * 传入setterMethods的目的是为了方便外部循环使用此方法，这样方法内部不会重复调用，提高效率<br/>
	 *
	 * @param resultSet     查询结果，一定要是{@link ResultSet#next()}操作过的，不然没有数据
	 * @param setterMethods clazz对应的所有setter方法，可以使用{@link this#getSetterMethods(Class)}获取
	 * @param clazz         注入对象类型
	 * @param <T>           注入对象类型
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T> T resultSetToObject(ResultSet resultSet, Method[] setterMethods, Class<T> clazz)
			throws IllegalAccessException, InstantiationException {
		T result;
		try {
			result = clazz.newInstance();
		} catch (InstantiationException e) {
			System.out.println("请检查类" + clazz.getCanonicalName() + "是否有无参构造方法");
			throw e;
		}

		for (Method method : setterMethods) {
			try {
				String fieldName = getFieldNameBySetter(method);

				// 因为标准的setter方法只会有一个参数，所以取一个就行了
				Class getParamClass = method.getParameterTypes()[0];

				// 获得查询的结果
				Object resultObject;

				// 是否启用驼峰转下划线规则获得数据库字段名
				if (databaseColumnHumpToLine) {
					resultObject = resultSet.getObject(humpToLine(fieldName));
				} else {
					resultObject = resultSet.getObject(fieldName);
				}

				// 如果实体类的类型是String类型，那么无论x数据库类型是什么，都调用其toString方法获取值
				if (getParamClass.equals(String.class)) {
					method.invoke(result, resultObject.toString());
				} else if (getParamClass.equals(Date.class) && resultObject.getClass().equals(Long.class)) {
					method.invoke(result, new Date((Long) resultObject));
				} else {
					try {
						method.invoke(result, resultObject);
					} catch (IllegalArgumentException e) {
						// 对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试强制转型
						method.invoke(result, getParamClass.cast(resultObject));
					}
				}
			} catch (Exception ignored) {
				// 所有的转型都失败了，则使用默认值
			}
		}

		return result;
	}

	/**
	 * 通过setter method,获取到其对应的属性名
	 *
	 * @param method
	 * @return
	 */
	public static String getFieldNameBySetter(Method method) {
		return toLowerCaseFirstOne(method.getName().substring(3));
	}

	/**
	 * 获取指定类型方法的所有的setter方法 方法属性名为key，对应的方法为value
	 *
	 * @param clazz
	 * @return
	 */
	public static Map<String, Method> getSetterMethodsMap(Class clazz) {
		Method[] methods = clazz.getMethods();
		Map<String, Method> setterMethods = new HashMap<>(methods.length / 2);

		for (Method m : methods) {
			if (m.getName().startsWith("set")) {
				setterMethods.put(toLowerCaseFirstOne(m.getName().substring(3)), m);
			}
		}
		return setterMethods;
	}

	/**
	 * 获取指定类型方法的所有的setter方法
	 *
	 * @param clazz
	 * @return
	 */
	public static Method[] getSetterMethods(Class clazz) {
		Method[] methods = clazz.getMethods();
		Method[] setterMethods = new Method[methods.length / 2];

		int i = 0;
		for (Method m : methods) {
			if (m.getName().startsWith("set")) {
				setterMethods[i] = m;
				i++;
			}
		}
		return setterMethods;
	}

	/**
	 * 首字母转小写
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return Character.toLowerCase(s.charAt(0)) + s.substring(1);
		}
	}

	/**
	 * 首字母转大写
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return Character.toUpperCase(s.charAt(0)) + s.substring(1);
		}
	}

	private static Pattern linePattern = Pattern.compile("_(\\w)");

	/** 下划线转驼峰 */
	public static String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 驼峰转下划线,效率比上面高
	 */
	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb,  matcher.group(0));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 创建原始数据表
	 * @param
	 */
	public  boolean createDataTable(String sql){
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			boolean execute = preparedStatement.execute();
			return execute;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
