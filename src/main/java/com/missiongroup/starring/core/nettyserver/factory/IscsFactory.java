package com.missiongroup.starring.core.nettyserver.factory;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.log.LogManager;

import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.data.domain.Iscs;
import com.missiongroup.starring.modular.vhis.data.service.IscsService;


/**
 * 日志操作任务创建工厂
 *
 * @author mission
 * @date 2016年12月6日 下午9:18:27
 */
public class IscsFactory {
	private static Logger logger = LoggerFactory.getLogger(IscsFactory.class);
	
	private static IscsService iscsService = SpringContextHolder.getBean(IscsService.class);


	/*public static TimerTask IscsData(final List<String> ExternalPortDataList,final String trainnum) {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					//------转十六进制字符串-----
					StringBuffer sb = new StringBuffer();

					for (String string : ExternalPortDataList) {
						sb.append(string.trim());
					}
					logger.info("iscs >>"+sb.toString());
					//----更新或者新增
					Iscs iscs = iscsService.findOneByTrainnum(trainnum);
					Date nowTime = new Date();
					if(null == iscs) {
						Iscs iscsNew = new Iscs();
						iscsNew.setCreateTime(nowTime);
						iscsNew.setRecordtime(nowTime);
						iscsNew.setUpdateTime(nowTime);
						iscsNew.setTrainnum(trainnum);
						iscsNew.setMvbdata(sb.toString());
						iscsService.save(iscsNew);
					}else {
						iscs.setRecordtime(nowTime);
						iscs.setUpdateTime(nowTime);
						iscs.setMvbdata(sb.toString());
						iscsService.save(iscs);
					}
				} catch (Exception e) {
					logger.error("iscs 异常!", e);
				}
			}
		};
	}*/

	public static TimerTask IscsData(final String mvbData,final String trainnum) {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					logger.info("iscs >>"+mvbData);
					//----更新或者新增
					Iscs iscs = iscsService.findOneByTrainnum(trainnum);
					Date nowTime = new Date();
					if(null == iscs) {
						Iscs iscsNew = new Iscs();
						iscsNew.setCreateTime(nowTime);
						iscsNew.setRecordtime(nowTime);
						iscsNew.setUpdateTime(nowTime);
						iscsNew.setTrainnum(trainnum);
						iscsNew.setMvbdata(mvbData);
						iscsService.save(iscsNew);
					}else {
						iscs.setRecordtime(nowTime);
						iscs.setUpdateTime(nowTime);
						iscs.setMvbdata(mvbData);
						iscsService.save(iscs);
					}
				} catch (Exception e) {
					logger.error("iscs 异常!", e);
				}
			}
		};
	}

	
}
