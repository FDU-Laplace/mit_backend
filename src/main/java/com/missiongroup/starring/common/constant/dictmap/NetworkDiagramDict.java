package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName:  NetworkDiagramDict   
 * @Description:TODO(全网图字典)   
 * @author: gprike 
 * @date:   2018年4月24日 下午4:29:53   
 *     
 * @Copyright: 2018 www.missiongroup.com.cn Inc. All rights reserved. 
 * 注意：本内容仅限于上海鸣啸信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class NetworkDiagramDict extends AbstractDictMap {

	@Override
	public void init() {
		put("ids", "全网图ID");
		put("name", "压缩图");
		put("thumbnail", "全网图名称");
		put("fileJson", "保存文件信息");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("id", "getNetworkDiagramById");
	}

}
