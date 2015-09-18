package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 原地归并排序
 * Created by lx on 2015/9/7.
 */
public class SituMergeSort implements ISort{

    @Override
    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        mergeSort(temp,0,temp.length-1);
        return temp;
    }


    /**
     * 反转数组中的部分元素
     * @param arr
     * @param start  起始位置
     * @param end   结束位置
     */
    private void reverse(int[] arr,int start,int end){
        while (end>start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            --end;
            ++start;
        }
    }


    /**
     * 以pivot为界，交换两部分位置
     * @param arr
     * @param start
     * @param end
     * @param pivot
     */
    private void exchange(int[] arr,int start,int end,int pivot){
        reverse(arr,start,pivot);
        reverse(arr,pivot+1,end);
        reverse(arr,start,end);
    }


    /**
     * 原地归并
     * @param arr
     * @param start
     * @param end
     */
    private void merge(int[] arr,int start,int boundary,int end){

        int j = boundary;
        int i = start;
        int k = end;
        int temp = j;
        int step = 0;
        while(i<j&&j<=k){
            temp = j;                        //记录临界位置
            step = 0;
            while (i<j&&arr[i]<=arr[j]){     //小于arr[j]子数组
                ++i;
            }
            while (j<=k&&arr[j]<=arr[i]){    //小于arr[i]子数组
                ++j;
                ++step;              //记录步长
            }
            exchange(arr,i,j-1,temp-1);       //交换
            i+=step;
        }
    }


    /**
     * 递归归并
     * @param arr
     * @param start
     * @param end
     */
    private void mergeSort(int[] arr,int start,int end){
        if(start<end){
            int middle = (start+end)/2;
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle+1,end);
        }
    }
}
