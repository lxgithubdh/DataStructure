package com.lx.util;

import java.util.Random;

/**
 * 数组辅助工具
 * @author lx
 */
public class ArrayUtils {

    /**
     * 生成数组
     * @param size 数组大小
     * @param range 数组数据范围
     * @return 结果数组
     */
	public static int[] getIntArray(int size,int range){
		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = new Random().nextInt(range);
		}
		return arr;
	}


    /**
     * 打印数组
     * @param arr 输入数组
     */
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
}
