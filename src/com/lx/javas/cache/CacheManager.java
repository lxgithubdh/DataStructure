package com.lx.javas.cache;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 缓存管理
 * Created by lx on 2015/10/6.
 */
public class CacheManager <K,V>{

    //缓存map
    private Cache<K,V> cache;


    public CacheManager(int cap){
        cache = new Cache<K, V>(cap);
        new Timer().scheduleAtFixedRate(new CleanThread(),100,100);
    }


    /**
     * 添加
     * @param key
     * @param value
     */
    public void put(K key,V value){
        cache.put(key,value);
    }


    /**
     * 获取值
     * @param key
     * @return
     */
    public V getValue(K key){
        return cache.getValue(key);
    }


    /**
     * 清理线程
     */
    private class CleanThread extends TimerTask{
        public void run(){
            cache.clean();
        }
    }
}
