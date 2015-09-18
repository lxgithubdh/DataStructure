package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 * Created by lx on 2015/9/4.
 */
public class BucketSort implements ISort{


    //输入范围
    private int range;


    public BucketSort(int range){
        this.range = range;
    }


    /**
     * 排序
     * @param arr 输入数组
     * @return 结果数组
     */
    public int[] sort(int[] arr){
        int n = range/10;
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();     //初始化桶
        }
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]/10;
            list[index].add(arr[i]);          //将数组元素进行分配
        }
        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);        //对桶排序
            if(list[i].size()!=0){
                result.addAll(list[i]);       //收集元素
            }
        }
        int[] temp = new int[result.size()];
        for (int i = 0; i < temp.length; i++) {      //将列表转换为数组
            temp[i] = result.get(i);
        }
        return temp;
    }
}
