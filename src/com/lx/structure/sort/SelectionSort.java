package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 选择排序
 * Created by lx on 2015/9/4.
 */
public class SelectionSort implements ISort{

    public int[] sort(int[] arr){
        int[] temp = Arrays.copyOf(arr,arr.length);
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            index = i;
            for (int j = i; j < temp.length; j++) {     //选择最小元素
                if(temp[index]>temp[j]){
                    index = j;
                }
            }
            if(index!=i){
                int value = temp[index];
                temp[index] = temp[i];
                temp[i] = value;
            }
        }
        return temp;
    }
}
