package com.lx.structure.match;

/**
 * KMP算法字符串匹配
 * Created lx on 2015/9/10.
 */
public class StringMatch {


    //源字符串
    private char[] sourceStr;


    public StringMatch(String str){
        this.sourceStr = str.toCharArray();
    }


    /**
     * 匹配字符串，匹配成功返回第一个字符出现索引，失败返回-1
     * @param temp
     * @return
     */
    public int matchString(String temp){
        int i = 0,j = 0;
        char[] template = temp.toCharArray();
        int[] next = next(template);
        while(i<sourceStr.length&&j<template.length){
            if(j==-1||sourceStr[i]==template[j]){
                ++i;
                ++j;
            }else {
                j = next[j]-1;         //回朔
            }
        }
        if(j==template.length){
            return i-j;
        }
        return -1;
    }


    /**
     * 根据输入模板，输出对应的偏移数组
     * @param template
     * @return
     */
    private int[] next(char[] template){
        int[] temp = new int[template.length];
        int index = 0,k = 0;
        temp[index++] = k;                //初始化值
        temp[index] = ++k;
        while(index<temp.length-1){
            if(k==0||template[index]==template[k-1]){
                temp[++index] = ++k;
            }else {
                k = temp[k-1];           //回朔
            }
        }
        return temp;
    }
}
