package com.lx.javas.cache;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 缓存类
 * Created by lx on 2015/9/27.
 */
public class Cache<K,V> {

    //存储缓存信息
    private HashMap<K,ValueObject<V>> map;
    //缓存容量
    private int capactiy = 0;


    public Cache(int capacity){
        this.capactiy = (int)((capacity>16?capacity:16)*0.9);
        map = new HashMap<K,ValueObject<V>>(capacity,1);
    }


    /**
     * 添加信息
     * @param key
     * @param value
     */
    public void put(K key,V value){
        if(map.size()>capactiy){
            clean();
        }
        synchronized (map){
            map.put(key,new ValueObject<V>(value,1));
        }
    }


    /**
     * 获取值
     * @param key
     * @return
     */
    public V getValue(K key){
        ValueObject<V> obj = map.get(key);
        if(null!=obj){
            obj.flag = 1;
            return obj.value;
        }else {
            return null;
        }
    }


    /**
     * 清除数据
     */
    public void clean(){
        synchronized (map){
            Iterator<K> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                ValueObject<V> value = map.get(iterator.next());
                if(value.flag==0){
                    iterator.remove();
                }else {
                    value.flag = 0;
                }
            }
        }
    }
}


/**
 * 值对象
 * @param <T>
 */
class ValueObject<T>{
    //值
    public T value;
    //使用标记
    public int flag;


    public ValueObject(T v,int f){
        this.value = v;
        this.flag = f;
    }
}
