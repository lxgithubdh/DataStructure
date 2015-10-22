package com.lx.common.util;

import com.lx.structure.tree.BinaryTree;
import com.lx.structure.tree.BinaryTreeNode;

import java.util.Random;

/**
 * 数组辅助工具
 * @author lx
 */
public class ArrayUtils {


    private static Random random = new Random();


    /**
     * 生成数组
     * @param size 数组大小
     * @param range 数组数据范围
     * @return 结果数组
     */
	public static int[] getIntArray(int size,int range){
		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = random.nextInt(range);
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


    /**
     * 打印二维数组
     * @param arr
     */
    public static void printArr2D(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
    }


    /**
     * 生成一棵二叉树，值为int
     * @param depth  树深度
     * @param range  值范围
     * @return
     */
    public static BinaryTree createIntTree(int depth,int range){
        BinaryTree tree = new BinaryTree();
        tree.root = createIntNode(depth,range);
        return tree;
    }


    /**
     * 递归生成树结点
     * @param depth
     * @param range
     * @return
     */
    private static BinaryTreeNode createIntNode(int depth,int range){
        BinaryTreeNode node = new BinaryTreeNode(random.nextInt(range));
        if(depth==1){
            node.leftChild = null;
            node.rightChild = null;
        }else{
            int curLevel = --depth;
            node.leftChild = createIntNode(curLevel,range);
            node.rightChild = createIntNode(curLevel,range);
        }
        return node;
    }
}
