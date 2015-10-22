package com.lx.structure.graph;

import java.util.ArrayList;

/**
 * 路径
 * Created by lx on 2015/10/17.
 */
public class Path implements Cloneable{

    //起始结点
    public ArrayList<PathNode> path;
    //路径权重
    public int weight;


    public Path(){
        path = new ArrayList<PathNode>();
        this.weight = 0;
    }


    public Path(int start,int end,int weight){
        path = new ArrayList<PathNode>();
        PathNode startNode = new PathNode(start);
        path.add(startNode);
        if(start!=end){
            startNode.weight = weight;
            PathNode endNode = new PathNode(end);
            endNode.weight = 0;
            path.add(endNode);
            this.weight = weight;
        }
    }


    /**
     * 更新路径
     * @param p
     * @param weight
     */
    public void refresh(Path p,int weight){
        PathNode end = this.path.get(this.path.size()-1);  //获取尾结点
        path = ((Path)p.clone()).path;  //克隆较短路径
        path.get(path.size()-1).weight = weight;  //对尾结点前驱赋值
        path.add(end);  //添加尾结点
        this.weight = p.weight + weight;  //更新路径权重
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(PathNode node : path){
            if(0!=node.weight){
                builder.append(node.tag);
                builder.append("---");
                builder.append(node.weight);
                builder.append("-->");
            }else {
                builder.append(node.tag);
            }
        }
        builder.append("\t");
        builder.append("Weight is : ");
        builder.append(this.weight);
        return builder.toString();
    }


    @Override
    public Object clone(){
        ArrayList<PathNode> list = new ArrayList<PathNode>();
        for(PathNode node : path){
            list.add((PathNode)node.clone());
        }
        Path p = new Path();
        p.path = list;
        p.weight = this.weight;
        return p;
    }
}
