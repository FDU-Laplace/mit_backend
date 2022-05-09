package com.missiongroup.starring.core.util;

import java.util.ArrayList;
import java.util.List;

import com.missiongroup.starring.common.constant.Const;
import com.missiongroup.starring.config.properties.StarringProperties;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.dto.MenuDto;

/**
 * 
 * @ClassName: ApiMenuFilter
 * @Description: API接口文档显示过滤
 * @author TAIHUAYUN
 * @date 2018年4月18日 上午10:08:45
 *
 */
public class ApiMenuFilter extends Menu {
	private static final long serialVersionUID = 1L;

	public static List<MenuDto> build(List<MenuDto> nodes) {
		// 如果关闭了接口文档,则不显示接口文档菜单
		StarringProperties starringProperties = SpringContextHolder.getBean(StarringProperties.class);
		if (!starringProperties.getSwaggerOpen()) {
			List<MenuDto> menuNodesCopy = new ArrayList<>();
			for (MenuDto menuNode : nodes) {
				if (Const.API_MENU_NAME.equals(menuNode.getName())) {
					continue;
				} else {
					menuNodesCopy.add(menuNode);
				}
			}
			nodes = menuNodesCopy;
		}
		return nodes;
	}
}
