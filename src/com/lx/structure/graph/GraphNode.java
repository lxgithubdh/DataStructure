package com.lx.structure.graph;

import com.lx.common.util.Node;

import java.util.ArrayList;

/**
 * 图结点
 * Created by lx on 2015/9/25.
 */
public class GraphNode<T> extends Node{


    //邻接弧链表
    public ArrayList<ArcNode> arcList = null;
    //结点编号
    public int num;


    public GraphNode(T value,int n){
        super(value);
        this.num = n;
        arcList = new ArrayList<ArcNode>();
    }
}
