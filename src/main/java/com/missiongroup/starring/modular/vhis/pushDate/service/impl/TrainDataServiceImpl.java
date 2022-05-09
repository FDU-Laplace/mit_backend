package com.missiongroup.starring.modular.vhis.pushDate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.modular.vhis.pushDate.domain.TrainData;
import com.missiongroup.starring.modular.vhis.pushDate.repository.TrainDataRepository;
import com.missiongroup.starring.modular.vhis.pushDate.service.TrainDataService;

@Component("TrainDataService")
@Transactional
public class TrainDataServiceImpl implements TrainDataService {
	
	@Autowired
	private TrainDataRepository TrainDataRepository;

	@Override
	public <S extends TrainData> S save(S entity) {
		return TrainDataRepository.save(entity);
	}

	@Override
	public TrainData findOneByUuid(String uuid) {
		return TrainDataRepository.findOne(uuid);
	}
	
	@Override
	public List<TrainData> findAll() {
		return TrainDataRepository.findAll();
	}

	@Override
	public Page<TrainData> findAll(Pageable pageable, Map<String, Object> condition) {
		return TrainDataRepository.findAll(new Specification<TrainData>() {
			@Override
			public Predicate toPredicate(Root<TrainData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("ts_timestamp"))) {
						list.add(cb.like(root.get("ts_timestamp").as(String.class), "%" + ((String) condition.get("ts_timestamp")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineId"))) {
						list.add(cb.like(root.get("lineId").as(String.class), "%" + ((String) condition.get("lineId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trainId"))) {
						list.add(cb.like(root.get("trainId").as(String.class), "%" + ((String) condition.get("trainId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("status"))) {
						list.add(cb.like(root.get("status").as(String.class), "%" + ((String) condition.get("status")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("theoreticalReception"))) {
						list.add(cb.like(root.get("theoreticalReception").as(String.class), "%" + ((String) condition.get("theoreticalReception")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("ctualReception"))) {
						list.add(cb.like(root.get("ctualReception").as(String.class), "%" + ((String) condition.get("ctualReception")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("acceptanceRate"))) {
						list.add(cb.like(root.get("acceptanceRate").as(String.class), "%" + ((String) condition.get("acceptanceRate")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("location"))) {
						list.add(cb.like(root.get("location").as(String.class), "%" + ((String) condition.get("location")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_speed"))) {
						list.add(cb.like(root.get("trian_speed").as(String.class), "%" + ((String) condition.get("trian_speed")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_net_voltage"))) {
						list.add(cb.like(root.get("trian_net_voltage").as(String.class), "%" + ((String) condition.get("trian_net_voltage")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_wind_pressure"))) {
						list.add(cb.like(root.get("trian_wind_pressure").as(String.class), "%" + ((String) condition.get("trian_wind_pressure")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_brake_pressure"))) {
						list.add(cb.like(root.get("trian_brake_pressure").as(String.class), "%" + ((String) condition.get("trian_brake_pressure")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_battery_voltage"))) {
						list.add(cb.like(root.get("trian_battery_voltage").as(String.class), "%" + ((String) condition.get("trian_battery_voltage")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_broadcast_mode"))) {
						list.add(cb.like(root.get("trian_broadcast_mode").as(String.class), "%" + ((String) condition.get("trian_broadcast_mode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_run_mode"))) {
						list.add(cb.like(root.get("trian_run_mode").as(String.class), "%" + ((String) condition.get("trian_run_mode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_control_mode"))) {
						list.add(cb.like(root.get("trian_control_mode").as(String.class), "%" + ((String) condition.get("trian_control_mode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_unit_energy"))) {
						list.add(cb.like(root.get("trian_unit_energy").as(String.class), "%" + ((String) condition.get("trian_unit_energy")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_total_energy"))) {
						list.add(cb.like(root.get("trian_total_energy").as(String.class), "%" + ((String) condition.get("trian_total_energy")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_current_station"))) {
						list.add(cb.like(root.get("trian_current_station").as(String.class), "%" + ((String) condition.get("trian_current_station")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_next_station"))) {
						list.add(cb.like(root.get("trian_next_station").as(String.class), "%" + ((String) condition.get("trian_next_station")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_terminus"))) {
						list.add(cb.like(root.get("trian_terminus").as(String.class), "%" + ((String) condition.get("trian_terminus")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_RxLev"))) {
						list.add(cb.like(root.get("trian_RxLev").as(String.class), "%" + ((String) condition.get("trian_RxLev")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_delivery_channel"))) {
						list.add(cb.like(root.get("trian_delivery_channel").as(String.class), "%" + ((String) condition.get("trian_delivery_channel")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_commissioning"))) {
						list.add(cb.like(root.get("trian_commissioning").as(String.class), "%" + ((String) condition.get("trian_commissioning")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trian_main_line"))) {
						list.add(cb.like(root.get("trian_main_line").as(String.class), "%" + ((String) condition.get("trian_main_line")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			}
		}, pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			TrainDataRepository.delete(uuid);
		}
	}
}
