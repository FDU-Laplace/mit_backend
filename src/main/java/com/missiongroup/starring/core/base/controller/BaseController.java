package com.missiongroup.starring.core.base.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.missiongroup.starring.core.base.tips.ErrorTip;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.missiongroup.starring.core.base.tips.SuccessTip;
import com.missiongroup.starring.core.support.HttpKit;
import com.missiongroup.starring.core.util.FileUtil;

@SuppressWarnings("all")
public class BaseController {
	protected static String SUCCESS = "SUCCESS";
	protected static String ERROR = "ERROR";

	protected static String REDIRECT = "redirect:";
	protected static String FORWARD = "forward:";

	protected static SuccessTip SUCCESS_TIP = new SuccessTip();
	protected HttpServletRequest getHttpServletRequest() {
		return HttpKit.getRequest();
	}

	protected HttpServletResponse getHttpServletResponse() {
		return HttpKit.getResponse();
	}

	protected HttpSession getSession() {
		return HttpKit.getRequest().getSession();
	}

	protected HttpSession getSession(Boolean flag) {
		return HttpKit.getRequest().getSession(flag);
	}

	protected String getPara(String name) {
		return HttpKit.getRequest().getParameter(name);
	}

	protected void setAttr(String name, Object value) {
		HttpKit.getRequest().setAttribute(name, value);
	}

	protected Integer getSystemInvokCount() {
		return (Integer) this.getHttpServletRequest().getServletContext().getAttribute("systemCount");
	}

	/**
	 * 删除cookie
	 */
	protected void deleteCookieByName(String cookieName) {
		Cookie[] cookies = this.getHttpServletRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				Cookie temp = new Cookie(cookie.getName(), "");
				temp.setMaxAge(0);
				this.getHttpServletResponse().addCookie(temp);
			}
		}
	}

	/**
	 * 返回前台文件流
	 *
	 * @author mission
	 * @date 2017年2月28日 下午2:53:19
	 */
	protected ResponseEntity<byte[]> renderFile(String fileName, String filePath) {
		byte[] bytes = FileUtil.toByteArray(filePath);
		return renderFile(fileName, bytes);
	}

	/**
	 * 返回前台文件流
	 *
	 * @author mission
	 * @date 2017年2月28日 下午2:53:19
	 */
	protected ResponseEntity<byte[]> renderFile(String fileName, byte[] fileBytes) {
		String dfileName = null;
		try {
			dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(fileBytes, headers, HttpStatus.CREATED);
	}

	/**
	 * 根据id,parent_id,parentIds获取树型结构数据
	 * 
	 * @param tree
	 * @return
	 * @throws Exception
	 */
	public static List factorTree(List tree) throws Exception {
		if (tree != null) {
			List t_list = new ArrayList();
			Map map = new HashMap();
			for (Object o : tree) {
				Class clazz = o.getClass();
				Field uuid = clazz.getDeclaredField("id");
				Field parentIds = clazz.getDeclaredField("parentIds");
				Field parent_ids = clazz.getDeclaredField("parentIdList");
				if (parentIds != null && parent_ids != null) {
					if (!parentIds.isAccessible()) {
						parentIds.setAccessible(true);
					}
					String ids = ((String) parentIds.get(o)).replace("[", "").replace("]", "");
					parentIds.set(o, ids);
					if (!parent_ids.isAccessible()) {
						parent_ids.setAccessible(true);
					}
					parent_ids.set(o, ids.split(","));
				}
				if (!uuid.isAccessible()) {
					uuid.setAccessible(true);
				}
				String lId = (String) uuid.get(o);
				map.put(lId, o);
			}

			for (Object o : map.keySet()) {
				String cId = (String) o;
				Object obj = map.get(cId);
				Class clazz = obj.getClass();
				Field pId = clazz.getDeclaredField("parentId");
				if (!pId.isAccessible()) {
					pId.setAccessible(true);
				}
				String id = (String) pId.get(obj);
				if ("0".equals(id) || map.get(id) == null) {
					t_list.add(obj);
				} else {
					Object object = map.get(id);
					Class clazz1 = object.getClass();
					Field children = clazz1.getDeclaredField("children");
					if (!children.isAccessible()) {
						children.setAccessible(true);
					}
					List list = (List) children.get(object);
					if (CollectionUtils.isEmpty(list)) {
						list = new ArrayList();
					}
					list.add(obj);
					Collections.sort(list);
					children.set(object, list);
				}
			}
			Collections.sort(t_list);
			return t_list;
		}
		return null;
	}

	/**
	 * 根据id,parentId获取树型结构数据
	 * 
	 * @param tree
	 * @return
	 * @throws Exception
	 */
	public static List factorTree2(List tree) throws Exception {
		if (tree != null) {
			List t_list = new ArrayList();
			Map map = new HashMap();
			for (Object o : tree) {
				Class clazz = o.getClass();
				Field uuid = clazz.getDeclaredField("id");
				if (!uuid.isAccessible()) {
					uuid.setAccessible(true);
				}
				String lId = (String) uuid.get(o);
				map.put(lId, o);
			}

			for (Object o : map.keySet()) {
				String cId = (String) o;
				Object obj = map.get(cId);
				Class clazz = obj.getClass();
				Field pId = clazz.getDeclaredField("parentId");
				if (!pId.isAccessible()) {
					pId.setAccessible(true);
				}
				String id = (String) pId.get(obj);
				if ("0".equals(id) || map.get(id) == null) {
					t_list.add(obj);
				} else {
					Object object = map.get(id);
					Class clazz1 = object.getClass();
					Field children = clazz1.getDeclaredField("children");
					if (!children.isAccessible()) {
						children.setAccessible(true);
					}
					List list = (List) children.get(object);
					if (CollectionUtils.isEmpty(list)) {
						list = new ArrayList();
					}
					list.add(obj);
					Collections.sort(list);
					children.set(object, list);
				}
			}
			Collections.sort(t_list);
			return t_list;
		}
		return null;
	}
}
