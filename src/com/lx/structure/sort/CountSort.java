package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 计数排序
 * Created by lx on 2015/9/2.
 */
public class CountSort implements ISort{


    //输入范围
    private int range;


    public CountSort(int range){
        this.range = range;
    }


    /**
     * 排序
     * @param inputArr 输入数组
     * @return 输出数组
     */
    public int[] sort(int[] inputArr){
        int[] tempArr = new int[range];
        int[] outputArr = new int[inputArr.length];
        for (int i=0;i<inputArr.length;++i){
            ++tempArr[inputArr[i]];        //计数
        }
        int[] count = Arrays.copyOf(tempArr,tempArr.length);
        tempArr[0] = 0;
        for (int i = 1; i < range ; i++) {
            tempArr[i]=count[i-1]+tempArr[i-1];      //计算元素位置
        }
        for (int i = 0; i < inputArr.length; i++) {
            outputArr[tempArr[inputArr[i]]] = inputArr[i];    //将元素放入相应位置
            ++tempArr[inputArr[i]];            //更新索引数组
        }
        return outputArr;
    }
}
