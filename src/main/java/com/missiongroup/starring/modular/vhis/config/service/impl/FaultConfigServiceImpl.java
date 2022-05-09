package com.missiongroup.starring.modular.vhis.config.service.impl;

import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.config.repository.FaultConfigRepository;
import com.missiongroup.starring.modular.vhis.config.service.FaultConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("FaultConfigService")
@Transactional
public class FaultConfigServiceImpl implements FaultConfigService {
	
	@Autowired
	private FaultConfigRepository faultConfigRepository;
	@Autowired
	private ICache iCaches;

	@Override
	public <S extends FaultConfig> S save(S entity) {
		S save = faultConfigRepository.save(entity);
		List<FaultConfig> faultConfigs = faultConfigRepository.findAll();
		iCaches.put("CONSTANT","faultConfigs",faultConfigs);
		return save;
	}

	@Override
	public FaultConfig findOneByUuid(String uuid) {
		return faultConfigRepository.findOne(uuid);
	}
	
	@Override
	public List<FaultConfig> findAll() {
		return faultConfigRepository.findAll();
	}
	@Override
	public List<FaultConfig> findByFaultCode(List<String> faultCodes) {
		return faultConfigRepository.findAllByFaultCodeIn(faultCodes);
	}

	@Override
	public Page<FaultConfig> findAll(Pageable pageable, Map<String, Object> condition) {
		return faultConfigRepository.findAll((root, query, cb) -> {
			List<Predicate> list = new ArrayList<Predicate>();

			if (null != condition) {
				if (StringUtils.isNotBlank((String) condition.get("disposal"))) {
					list.add(cb.like(root.get("disposal").as(String.class), "%" + ((String) condition.get("disposal")).replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank((String) condition.get("describe"))) {
					list.add(cb.like(root.get("describe").as(String.class), "%" + ((String) condition.get("describe")).replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank((String) condition.get("faultCode"))) {
					list.add(cb.like(root.get("faultCode").as(String.class), "%" + ((String) condition.get("faultCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank((String) condition.get("faultName"))) {
					list.add(cb.like(root.get("faultName").as(String.class), "%" + ((String) condition.get("faultName")).replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank((String) condition.get("faultLevel"))) {
					list.add(cb.like(root.get("faultLevel").as(String.class), "%" + ((String) condition.get("faultLevel")).replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank((String) condition.get("beginTime"))) {
					list.add(cb.greaterThanOrEqualTo(root.get("updateTime").as(String.class), (String) condition.get("beginTime") + " 00:00:00"));
				}
				if (StringUtils.isNotBlank((String) condition.get("endTime"))) {
					list.add(cb.lessThanOrEqualTo(root.get("updateTime").as(String.class), (String) condition.get("endTime") + " 23:59:59"));
				}
			}
			Predicate[] pre = new Predicate[list.size()];
			return query.where(list.toArray(pre)).getRestriction();
		}, pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			faultConfigRepository.delete(uuid);
		}
	}
}
