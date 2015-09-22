package com.lx.structure.sort;

import com.lx.common.interfaces.ISort;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 归并排序
 * Created by lx on 2015/9/6.
 */
public class MergeSort implements ISort{


    public int[] sort(int[] arr){
        return mergeParallelSort(arr);
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
     * @return  排序结果
     */
    private int[] mergeSort(int[] arr){
        if(arr.length>1){
            int middle = arr.length/2-1;
            return mergeArray(mergeSort(subArray(arr, 0, middle)),
                    mergeSort(subArray(arr,middle+1,arr.length-1)));
        }else {
            return arr;
        }
    }


    /**
     * 并行归并
     * @param arr
     * @return
     */
    private int[] mergeParallelSort(int[] arr){
        FutureTask<int[]> result = new FutureTask<int[]>(new SortThread(arr));
        new Thread(result).start();
        int[] temp = new int[0];
        try {
            temp = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return temp;
    }


    /**
     * 截取部分数组
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int[] subArray(int[] arr,int start,int end){
        int[] temp = new int[end-start+1];
        for(int i=0,j=start;i<temp.length;i++,j++){
            temp[i] = arr[j];
        }
        return temp;
    }


    /**
     * 并行排序线程
     */
    private class SortThread implements Callable<int[]>{


        private int[] arr;


        public SortThread(int[] arr){
            this.arr = arr;
        }


        @Override
        public int[] call() throws Exception {
            if (arr.length > 23000) {
                int middle = arr.length / 2 - 1;
                FutureTask<int[]> firstHalf = new FutureTask<int[]>(   //前半部分排序
                        new SortThread(subArray(arr, 0, middle)));
                new Thread(firstHalf).start();
                FutureTask<int[]> afterHalf = new FutureTask<int[]>(   //后半部分排序
                        new SortThread(subArray(arr, middle + 1, arr.length - 1)));
                new Thread(afterHalf).start();
                return mergeArray(firstHalf.get(), afterHalf.get());    //合并结果
            } else if (arr.length > 1) {
                return mergeSort(arr);
            } else {
                return arr;
            }
        }
    }
}
