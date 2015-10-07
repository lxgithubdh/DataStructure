package com.lx.structure.graph;

/**
 * 弧结点
 * Created by lx on 2015/9/25.
 */
public class ArcNode {

    //弧权重
    public int weight;
    //邻接结点
    public GraphNode adjNode;


    public ArcNode(int w,GraphNode node){
        this.weight = w;
        this.adjNode = node;
    }
}
