package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 插入排序
 * Created by lx on 2015/9/4.
 */
public class InsertionSort implements ISort{

    public int[] sort(int[] arr){
        int[] temp = Arrays.copyOf(arr,arr.length);
        int index = 1;
        for(;index<temp.length;){
            for (int i = index; i > 0 ; --i) {      //插入
                if(temp[i]<temp[i-1]){
                    int value = temp[i];
                    temp[i] = temp[i-1];
                    temp[i-1] = value;
                }
            }
            ++index;
        }
        return temp;
    }
}
