package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 奇偶排序
 * Created by lx on 2015/9/9.
 */
public class OddEvenSort implements ISort{
    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        boolean attr = temp.length%2==1;    //判断数组元素个数是否为奇数
        boolean way = true,swap = true;
        int length = 0,start = 0;
        while(swap){
            swap = false;
            if(way){                 //way为true,表奇排序,与右侧比较
                length = temp.length;
                start = 0;
                if(attr){
                    --length;            //不比较最后一个元素
                }
            }else {               //way为false，表偶排序，与左侧比较
                length = temp.length-1;
                start = 1;
                if(attr){
                    --length;
                }
            }
            for(int i=start;i<length;i+=2){
                if(temp[i]>temp[i+1]){
                    int value = temp[i];
                    temp[i] = temp[i+1];
                    temp[i+1] = value;
                    swap = true;
                }
            }
            way = !way;
        }
        return temp;
    }
}
