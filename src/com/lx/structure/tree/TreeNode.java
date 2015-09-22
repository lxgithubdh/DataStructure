package com.lx.structure.tree;

/**
 * 二叉树节点
 * Created by lx on 2015/9/20.
 */
public class TreeNode<T> {
    //值
    public T value;
    //父节点
    public TreeNode parent;
    //左孩子
    public TreeNode leftChild;
    //右孩子
    public TreeNode rightChild;


    public TreeNode(T value){
        this.value = value;
    }
}
