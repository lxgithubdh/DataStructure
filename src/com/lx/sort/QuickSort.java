package com.lx.sort;

import com.lx.interfaces.ISort;

import java.util.Arrays;

/**
 * 快速排序
 * @author lx
 */
public class QuickSort implements ISort{

	/**
	 * 获取轴索引
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int getPivot(int[] arr,int start,int end){
		int x = arr[end];
		int i = start-1;
		for(int j=start;j<end;j++){
			if(arr[j]<=x){
				++i;
				exchageElement(arr, i, j);
			}
		}
		exchageElement(arr, i+1, end);
		return i+1;
	}
	
	
	/**
	 * 交换数据
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void exchageElement(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	/**
	 * 快速排序
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int[] sortWithIndex(int[] arr,int start,int end){
		if(start<end){
			int pivot = getPivot(arr, start, end);
			sortWithIndex(arr, start, pivot-1);
			sortWithIndex(arr, pivot+1, end);
		}
		return arr;
	}
	
	
	/**
	 * 获取排序结果
	 * @param originArr
	 * @return
	 */
	public int[] sort(int[] originArr){
		int[] arr = Arrays.copyOf(originArr, originArr.length);
		return sortWithIndex(arr, 0, arr.length-1);
	}
}
