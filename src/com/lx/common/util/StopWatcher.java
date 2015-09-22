package com.lx.common.util;


import com.lx.common.interfaces.ISort;
import com.lx.common.interfaces.IStopWatch;
import com.lx.structure.sort.MergeSort;

/**
 * 计时器
 * Created by lx on 2015/9/5.
 */
public class StopWatcher implements IStopWatch {


    //初始数组
    private int[] arr = null;
    //结果数组
    private int[] result = null;
    ISort sort = null;
    //数组元素数量
    private int number = 60000;
    //数组元素范围
    private int range = 10000;


    /**
     * 初始化
     */
    public void beforeRun(){
        arr = ArrayUtils.getIntArray(number, range);
        if(number<100000){
            ArrayUtils.printArray(arr);
        }
        //堆排序
        //sort = new HeapSort();
        //快速排序
        //sort = new QuickSort();
        //计数排序
        //sort = new CountSort(10000);
        //冒泡排序
        //sort = new BubbleSort();
        //鸡尾酒排序
        //sort = new CocktailSort();
        //插入排序
        //sort = new InsertionSort();
        //选择排序
        //sort = new SelectionSort();
        //桶排序
        //sort = new BucketSort(10000);
        //归并排序
        sort = new MergeSort();
        //原地归并排序
        //sort = new SituMergeSort();
        //鸽巢排序
        //sort = new PigeonholeSort(10000);
        //侏儒排序
        //sort = new GnomeSort();
        //希尔排序
        //sort = new ShellSort();
        //奇偶排序
        //sort = new OddEvenSort();
        //梳排序
        //sort = new CombSort();
    }


    @Override
    public void run() {
        result = sort.sort(arr);
    }


    /**
     * 处理结果
     */
    public void afterRun(){
        if(number<100000){
            ArrayUtils.printArray(result);
        }
    }
}

