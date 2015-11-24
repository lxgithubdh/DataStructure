package com.lx.structure.collection;

import java.util.Iterator;

/**
 * 栈
 * Created by lx on 2015/11/20.
 */
public class Stack<T> implements Iterable<T>{

    //存储数据数组
    private T[] values;
    //数组大小
    private int size;
    //栈索引
    private int index;


    public Stack(){
        values = (T[])new Object[16];
    }


    public Stack(int size){
        size = size>16?size:16;
        this.size = size;
        values = (T[])new Object[size];
    }


    /**
     * 放入元素
     * @param value
     */
    public void push(T value){
        values[index++] = value;
        if(index+1>size){
            expand();
        }
    }


    /**
     * 获取头元素
     * @return
     */
    public T top(){
        return values[index-1];
    }


    /**
     * 弹出顶部元素
     * @return
     */
    public T pop(){
        T v = values[--index];
        values[index] = null;
        if(size>16){
            if(index<size>>2){
                shrink();
            }
        }
        return v;
    }


    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return index==0;
    }


    /**
     * 获取栈元素数量
     * @return
     */
    public int size(){
        return index;
    }


    @Override
    public Iterator iterator() {
        return new StackIterator();
    }


    /**
     * 数组长度增长
     */
    private void expand(){
        size <<= 1;
        T[] tmp = (T[])new Object[size];
        for(int i=0; i<values.length; i++){
            tmp[i] = values[i];
        }
        values = tmp;
    }


    /**
     * 数组长度收缩
     */
    private void shrink(){
        size >>= 1;
        T[] tmp = (T[])new Object[size];
        for (int i = 0; i < size; i++) {
            if(null==values[i]){
                break;
            }
            tmp[i] = values[i];
        }
        values = tmp;
    }


    /**
     * 栈枚举器
     */
    private class StackIterator implements Iterator<T>{

        //当前元素索引
        private int cur;


        @Override
        public boolean hasNext() {
            return cur<index;
        }

        @Override
        public T next() {
            return values[cur++];
        }
    }
}
