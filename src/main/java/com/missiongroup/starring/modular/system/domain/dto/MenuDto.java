package com.missiongroup.starring.modular.system.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.missiongroup.starring.common.constant.IsMenu;

public class MenuDto implements Serializable, Comparable<MenuDto> {
	private static final long serialVersionUID = 1L;

	private String id;

	private String code;

	private String parentId;

	private String parentIds;

	private String name;

	private String icon;

	private String url;

	private Integer num;

	private Integer level;

	private Integer type;

	private String remark;

	private Integer status;

	private Date createTime;

	private Date updateTime;

	private String createUserId;

	private String updateUserId;

	private String[] parentIdList;

	private List<MenuDto> linkedList = new ArrayList<MenuDto>();

	private List<MenuDto> children;

	private String label;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String[] getParentIdList() {
		return parentIdList;
	}

	public void setParentIdList(String[] parentIdList) {
		this.parentIdList = parentIdList;
	}

	public List<MenuDto> getLinkedList() {
		return linkedList;
	}

	public void setLinkedList(List<MenuDto> linkedList) {
		this.linkedList = linkedList;
	}

	public List<MenuDto> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 构建整个菜单树
	 *
	 * @author mission
	 */
	public void buildNodeTree(List<MenuDto> nodeList) {
		for (MenuDto treeNode : nodeList) {
			List<MenuDto> linkedList = treeNode.findChildNodes(nodeList, treeNode.getId());
			if (linkedList.size() > 0) {
				treeNode.setChildren(linkedList);
			}
		}
	}

	/**
	 * 查询子节点的集合
	 *
	 * @author mission
	 */
	public List<MenuDto> findChildNodes(List<MenuDto> nodeList, String parentId) {
		if (nodeList == null && parentId == null)
			return null;
		for (Iterator<MenuDto> iterator = nodeList.iterator(); iterator.hasNext();) {
			MenuDto node = (MenuDto) iterator.next();
			// 根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (node.getParentId() != "0" && parentId.equals(node.getParentId())) {
				recursionFn(nodeList, node, parentId);
			}
		}
		return linkedList;
	}

	/**
	 * 遍历一个节点的子节点
	 *
	 * @author mission
	 */
	public void recursionFn(List<MenuDto> nodeList, MenuDto node, String pId) {
		List<MenuDto> childList = getChildList(nodeList, node);// 得到子节点列表
		if (childList.size() > 0) {// 判断是否有子节点
			if (node.getParentId().equals(pId)) {
				linkedList.add(node);
			}
			Iterator<MenuDto> it = childList.iterator();
			while (it.hasNext()) {
				MenuDto n = (MenuDto) it.next();
				recursionFn(nodeList, n, pId);
			}
		} else {
			if (node.getParentId().equals(pId)) {
				linkedList.add(node);
			}
		}
	}

	/**
	 * 得到子节点列表
	 *
	 * @author mission
	 */
	private List<MenuDto> getChildList(List<MenuDto> list, MenuDto node) {
		List<MenuDto> nodeList = new ArrayList<MenuDto>();
		Iterator<MenuDto> it = list.iterator();
		while (it.hasNext()) {
			MenuDto n = (MenuDto) it.next();
			if (n.getParentId().equals(node.getId())) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	/**
	 * 清除掉按钮级别的资源
	 *
	 * @date 2017年2月19日 下午11:04:11
	 */
	public static List<MenuDto> clearBtn(List<MenuDto> nodes) {
		ArrayList<MenuDto> noBtns = new ArrayList<MenuDto>();
		for (MenuDto node : nodes) {
			if (node.getType() == IsMenu.YES.getCode()) {
				noBtns.add(node);
			}
		}
		return noBtns;
	}

	/**
	 * 清除所有二级菜单
	 *
	 * @date 2017年2月19日 下午11:18:19
	 */
	public static List<MenuDto> clearLevelTwo(List<MenuDto> nodes) {
		ArrayList<MenuDto> results = new ArrayList<MenuDto>();
		for (MenuDto node : nodes) {
			Integer levels = node.getLevel();
			if (levels.equals(1)) {
				results.add(node);
			}
		}
		return results;
	}

	/**
	 * 构建菜单列表
	 *
	 * @date 2017年2月19日 下午11:18:19
	 */
	public static List<MenuDto> buildTitle(List<MenuDto> nodes) {
		List<MenuDto> clearBtn = clearBtn(nodes);
		new MenuDto().buildNodeTree(clearBtn);
		List<MenuDto> menuNodes = clearLevelTwo(clearBtn);
		// 对菜单排序
		Collections.sort(menuNodes, new Comparator<MenuDto>() {
			@Override
			public int compare(MenuDto o1, MenuDto o2) {
				Integer num1 = o1.getNum();
				Integer num2 = o2.getNum();
				if (num1 == null) {
					num1 = 0;
				}
				if (num2 == null) {
					num2 = 0;
				}
				return num1.compareTo(num2);
			}
		});

		// 对菜单的子菜单进行排序
		for (MenuDto menuNode : menuNodes) {
			if (menuNode.getChildren() != null && menuNode.getChildren().size() > 0) {
				Collections.sort(menuNode.getChildren(), new Comparator<MenuDto>() {
					@Override
					public int compare(MenuDto o1, MenuDto o2) {
						Integer num1 = o1.getNum();
						Integer num2 = o2.getNum();
						if (num1 == null) {
							num1 = 0;
						}
						if (num2 == null) {
							num2 = 0;
						}
						return num1.compareTo(num2);
					}
				});
			}
		}
		return menuNodes;
	}

	@Override
	public int compareTo(MenuDto o) {
		MenuDto menu = (MenuDto) o;
		Integer num = menu.getNum();
		if (num == null) {
			num = 0;
		}
		if (this.num == null) {
			this.num = 0;
		}
		return this.num.compareTo(num);
	}
}
