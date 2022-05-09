package com.missiongroup.starring.core.cache.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;

import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.config.repository.CBConfigRepository;
import com.missiongroup.starring.modular.vhis.config.repository.FaultConfigRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.missiongroup.starring.core.cache.ICache;

import java.util.*;


@Component
public class InitDataConfig implements InitializingBean, ServletContextAware {
	private static final Logger logger = Logger.getLogger(InitDataConfig.class);
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	ICache iCaches;
	@Autowired
	private CBConfigRepository cbConfigRepository;
	@Autowired
	private FaultConfigRepository faultConfigRepository;
	@Override
	public void setServletContext(ServletContext servletContext) {
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		sysConfig();
		tablesConfig();
	}

	private void sysConfig(){
		List<CBConfig> cbConfigs = cbConfigRepository.findAll();
		List<FaultConfig> faultConfigs = faultConfigRepository.findAll();
		iCaches.put("CONSTANT","cbConfigs",cbConfigs);
		iCaches.put("CONSTANT","faultConfigs",faultConfigs);
	}
	private  void tablesConfig()  {
		StringBuffer selectSql = new StringBuffer();
		selectSql.append("show tables");
		List<String> resultList = entityManager.createNativeQuery(selectSql.toString()).getResultList();
		Map portData=new HashMap();
		int cont=0;
		PortModel portModel = new PortModel();
		for (String tableName : resultList) {
			if (tableName.contains("port")) {
				StringBuffer portSql = new StringBuffer();
				portSql.append("select id,signalName,complexNetworkType from ").append(tableName);
				List<Object[]> pList = entityManager.createNativeQuery(portSql.toString()).getResultList();
				int size = pList.size();
				cont=cont+size;
				ArrayList<PortModel> data=new ArrayList();
				for (Object[] portVale : pList) {
					int id = (Integer)portVale[0];
					String signalName = String.valueOf(portVale[1]).trim();
					String complexNetworkType = String.valueOf(portVale[2]).trim();
					PortModel portModelClone = portModel.clone();
					portModelClone.setId(id);
					portModelClone.setSignalName(signalName);
					portModelClone.setComplexNetworkType(complexNetworkType);
					data.add(portModelClone);
				}
				portData.put(tableName,data);
			}
		}
		logger.info("共有端口数 ：" +portData.size()+"共有数据字段数：" +cont);

		iCaches.put("CONSTANT","portData",portData);	
	}
}