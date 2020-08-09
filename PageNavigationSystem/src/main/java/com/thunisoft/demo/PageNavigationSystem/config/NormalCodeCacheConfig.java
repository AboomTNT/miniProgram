/**
 * @projectName 页面导航系统
 * @package com.thunisoft.demo.PageNavigationSystem.config
 * @className com.thunisoft.demo.PageNavigationSystem.config.NormalCodeCacheConfig
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.demo.PageNavigationSystem.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;

/**
 * 
 * CacheManagerConfig
 * 
 * @description UIM-SDK种配置了Caffeine，导致ArteryCacheManager无法创建缓存，手动创建缓存
 * @author yangshengce
 * @date 2020年07月22日 15:50:57
 * @version 1.0.0
 */
@Configuration
public class NormalCodeCacheConfig {

    /**
     * cacheNameList
     */
    private List<String> cacheNameList = Lists.newArrayList("normalCode", "normalCodeType", "allNormalCodeTypes");

    /**
     * 缓存大小
     */
	private static final int MAX_CACHE_SIZE = 2000;

	/**
	 * 
	 * NormalCodeCacheConfig
	 * @description 构造函数
	 * @param cacheManager cacheManager
     * @author yangshengce
     * @date 2020年07月22日 15:50:57
     * @version 1.0.0
	 */
    NormalCodeCacheConfig(CacheManager cacheManager) {
        SimpleCacheManager simpleCacheManager = (SimpleCacheManager)cacheManager;
        Collection<String> cacheNames = simpleCacheManager.getCacheNames();
        ArrayList<Cache> caches = new ArrayList<>();
        for (String name : cacheNames) {
            caches.add(simpleCacheManager.getCache(name));
        }
        for (String cacheName : cacheNameList) {
            caches.add(new CaffeineCache(cacheName, Caffeine.newBuilder().recordStats().maximumSize(MAX_CACHE_SIZE).build()));
        }
        simpleCacheManager.setCaches(caches);
        simpleCacheManager.initializeCaches();
    }
}