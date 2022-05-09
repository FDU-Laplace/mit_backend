package com.missiongroup.starring.core.cache;

import java.util.List;

/**
 * 
 * @ClassName: ICache
 * @Description: 通用缓存接口
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:15:21
 *
 */

public interface ICache {
	void put(String cacheName, Object key, Object value);

	<T> T get(String cacheName, Object key);

	@SuppressWarnings("rawtypes")
	List getKeys(String cacheName);

	void remove(String cacheName, Object key);

	void removeAll(String cacheName);

	<T> T get(String cacheName, Object key, ILoader iLoader);

	<T> T get(String cacheName, Object key, Class<? extends ILoader> iLoaderClass);
}
