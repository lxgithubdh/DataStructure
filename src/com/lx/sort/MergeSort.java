package com.lx.sort;

import com.lx.interfaces.ISort;

/**
 * 归并排序
 * Created by lx on 2015/9/6.
 */
public class MergeSort implements ISort{


    public int[] sort(int[] arr){
        return mergeSort(arr,0,arr.length-1);
    }


    /**
     * 合并数组
     * @param a
     * @param b
     * @return 合并结果
     */
    private int[] mergeArray(int[] a,int[] b){
        int[] temp = new int[a.length+b.length];
        int k = 0,i=0,j=0;
        while (i<a.length&&j<b.length){      //按元素大小合并
            if(a[i]<b[j]){
                temp[k++] = a[i];
                ++i;
            }else {
                temp[k++] = b[j];
                ++j;
            }
        }
        while (i<a.length){            //串联a数组
            temp[k++] = a[i++];
        }
        while (j<b.length){            //串联b数组
            temp[k++] = b[j++];
        }
        return temp;
    }


    /**
     * 递归排序
     * @param arr
     * @param start 起始索引
     * @param end  结束索引
     * @return  排序结果
     */
    private int[] mergeSort(int[] arr,int start,int end){
        if(start<end){
            int middle = (start+end)/2;
            return mergeArray(mergeSort(arr,start,middle),mergeSort(arr,middle+1,end));
        }else {
            return new int[]{arr[start]};
        }
    }
}
