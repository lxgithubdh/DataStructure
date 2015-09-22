package com.lx.structure.sort;



import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by lx on 2015/9/3.
 */
public class BubbleSort implements ISort{

    /**
     * 排序
     * @param arr 输入数组
     * @return 输出数组
     */
    public int[] sort(int[] arr){
        int[] temp = Arrays.copyOf(arr,arr.length);
        boolean isChange = false;
        for (int i = 0; i < temp.length; i++) {
            isChange = false;
            for (int j = 0; j < temp.length-1; j++) {
                if(temp[j]>temp[j+1]){           //冒泡
                    int value = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = value;
                    isChange = true;
                }
            }
            if(!isChange)
                break;
        }
        return temp;
    }
}
