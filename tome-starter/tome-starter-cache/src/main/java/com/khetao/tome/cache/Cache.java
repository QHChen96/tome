package com.khetao.tome.cache;

import java.util.Collection;

/**
 * 缓存
 * @author chenqinhao 2022/8/1
 * @email qhchen96@gmail.com
 */
public interface Cache {

    /**
     * 获取
     * @param key
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T get(String key, Class<T> clazz);

    /**
     * 保存
     * @param key
     * @param value
     */
    void put(String key, Object value);

    /**
     * 删除
     * @param key
     * @return
     */
    boolean delete(String key);

    /**
     * 删除多个key
     * @param
     * @return 被删除的个数
     */
    long delete(Collection<String> keys);

}
