package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * Created lx Administrator on 2015/9/3.
 */
public class CocktailSort implements ISort{

    public int[] sort(int[] arr){
        int[] temp = Arrays.copyOf(arr,arr.length);
        int bottom = 0;
        int top = temp.length-1;
        boolean swap = false;
        for (int i = 0; i < temp.length; i++) {
            swap = false;
            if(i%2==0){
                for (int j = 0; j < top; j++) {        //选出最大元素
                    if(temp[j]>temp[j+1]){
                        int value = temp[j];
                        temp[j] = temp[j+1];
                        temp[j+1] = value;
                        swap = true;
                    }
                }
                --top;                              //最大元素已排好
            }else {
                for (int j = top;j > bottom; j--){  //选出最小元素
                    if(temp[j]<temp[j-1]){
                        int value = temp[j];
                        temp[j] = temp[j-1];
                        temp[j-1] = value;
                        swap = true;
                    }
                }
                ++bottom;                           //最小元素已排好
            }
            if(!swap){
                break;
            }
        }
        return temp;
    }
}
