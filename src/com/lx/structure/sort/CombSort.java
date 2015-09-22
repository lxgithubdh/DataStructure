package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.Arrays;

/**
 * 梳排序
 * Created by lx on 2015/9/9.
 */
public class CombSort implements ISort{
    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        int step = (int)(temp.length/1.3);
        while (step>0){                                //按步长分组排序
            for(int i = step;i<temp.length;i++){
                int index = i-step;
                int value = temp[i];
                while(index>-1&&value<temp[index]){
                    temp[index+step]=temp[index];
                    index-=step;
                }
                temp[index+step] = value;
            }
            if(step>3){                        //当步长>3时，/1.3，否则减一
                step = (int)(step/1.3);
            }else {
                --step;
            }
        }
        return temp;
    }
}
