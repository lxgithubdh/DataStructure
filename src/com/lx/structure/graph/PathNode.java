package com.lx.structure.graph;

/**
 * 路径结点
 * Created by lx on 2015/10/17.
 */
public class PathNode implements Cloneable{


    public int tag;    //当前结点标识
    public int weight;  //路径权重


    public PathNode(int tag){
        this.tag = tag;
    }


    @Override
    public Object clone(){
        PathNode node = new PathNode(this.tag);
        node.weight = this.weight;
        return node;
    }
}
