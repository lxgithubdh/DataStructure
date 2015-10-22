package com.lx.structure.tree;

import java.util.ArrayList;

/**
 * 普通树结点
 * Created by lx on 2015/10/10.
 */
public class TreeNode<T> {

    //结点值
    public T value;
    //孩子列表
    private ArrayList<TreeNode<T>> list;


    public TreeNode(T v){
        this.value = v;
        list = new ArrayList<TreeNode<T>>();
    }


    /**
     * 添加孩子结点
     * @param node
     */
    public void addChild(TreeNode<T> node){
        this.list.add(node);
    }


    /**
     * 移除孩子结点
     * @param node
     */
    public void removeChild(TreeNode node){
        this.list.remove(node);
    }

}
