package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 鸽巢排序
 * Created by lx on 2015/9/8.
 */
public class PigeonholeSort implements ISort{


    //范围
    private int range;


    public PigeonholeSort(int range){
        this.range = range;
    }


    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        int[] pigeno = new int[range];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            ++pigeno[temp[i]];                  //计数
        }
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < pigeno[i]; j++) {
                temp[index++] = i;              //为输出数组放入数据
            }
        }
        return temp;
    }
}
