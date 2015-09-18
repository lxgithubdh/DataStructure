package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 侏儒排序
 * Created by lx on 2015/9/8.
 */
public class GnomeSort implements ISort{


    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        int index = 0;
        while (index<temp.length){
            if(index==0||temp[index-1]<=temp[index]){
                ++index;
            }else {
                swap(temp,index-1,index);        //交换后index回退
                --index;
            }
        }
        return temp;
    }


    /**
     * 交换值
     * @param arr
     * @param a
     * @param b
     */
    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
