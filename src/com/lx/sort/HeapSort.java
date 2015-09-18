package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 堆排序
 * @author lx
 */
public class HeapSort implements ISort{

	
	/**
	 * 获取左孩子
	 */
	private int getLiftChild(int i){
		return 2*i;
	}
	
	
	/**
	 * 获取右孩子
	 */
	private int getRightChild(int i){
		return 2*i+1;
	}
	
	
	/**
	 * 调整堆
	 * @param arr
	 * @param i
	 * @param size
	 */
	private void checkHeapify(int[] arr,int i,int size){
		int large = 0;
		int l = getLiftChild(i);
		int r = getRightChild(i);
		if((l<size)&&(arr[l]>arr[i])){
			large = l;
		}else{
			large = i;
		}
		if((r<size)&&(arr[r]>arr[large])){
			large = r;
		}
		if(large!=i){
			exchangeData(arr, i, large);
			checkHeapify(arr, large,size);
		}
	}
	
	
	/**
	 * 建立堆
	 * @param arr
	 */
	private void buildHeap(int[] arr){
		int length = arr.length;
		for(int i=length/2;i>-1;i--){
			checkHeapify(arr, i, length);
		}
	}
	
	
	/**
	 * 交换数据
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void exchangeData(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	/**
	 * 堆排序
	 * @param arr
	 * @return
	 */
	public int[] sort(int[] originArr){
		int[] arr = Arrays.copyOf(originArr, originArr.length);
		buildHeap(arr);
		for(int i=arr.length-1;i>0;i--){
			exchangeData(arr, 0, i);
			checkHeapify(arr, 0, i);
		}
		return arr;
	}
}
