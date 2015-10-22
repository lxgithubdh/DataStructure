package com.lx.common.util;

/**
 * 结点基类
 * Created by lx on 2015/9/25.
 */
public class Node<T> {


    //结点值
    public T value;
    //结点标签
    public int tag;


    public Node(T v){
        this.value = v;
    }
}
