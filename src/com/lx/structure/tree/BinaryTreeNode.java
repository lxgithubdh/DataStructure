package com.lx.structure.tree;

import com.lx.common.util.Node;

/**
 * 二叉树节点
 * Created by lx on 2015/9/20.
 */
public class BinaryTreeNode<T> extends Node{


    //父节点
    public BinaryTreeNode parent;
    //左孩子
    public BinaryTreeNode leftChild;
    //右孩子
    public BinaryTreeNode rightChild;


    public BinaryTreeNode(T value){
        super(value);
    }
}
