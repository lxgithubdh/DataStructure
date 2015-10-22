package com.lx.structure.graph;

import com.lx.common.util.Node;

import java.util.ArrayList;

/**
 * 图结点
 * Created by lx on 2015/9/25.
 */
public class GraphNode<T> extends Node implements Comparable{


    //邻接弧链表
    public ArrayList<ArcNode> arcList = null;


    public GraphNode(T value,int tag){
        super(value);
        this.tag = tag;
        arcList = new ArrayList<ArcNode>();
    }

    @Override
    public int compareTo(Object o) {
        return this.tag-((GraphNode)o).tag;
    }
}
