package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 希尔排序
 * Created by lx on 2015/9/9.
 */
public class ShellSort implements ISort{
    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        int step = temp.length/2;          //初始步长
        while (step>0){
            for(int i = step;i<temp.length;i++){
                int index = i - step;
                int value = temp[i];
                while (index>-1&&value<temp[index]){      //插入排序
                    temp[index+step] = temp[index];
                    index-=step;
                }
                temp[index+step] = value;
            }
            step/=2;                        //步长减半
        }
        return temp;
    }
}
