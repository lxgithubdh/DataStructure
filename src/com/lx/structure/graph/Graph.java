package com.lx.structure.graph;

import com.lx.common.interfaces.IVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 图
 * Created by lx on 2015/9/25.
 */
public class Graph {

    //结点集合
    public HashSet<GraphNode> graph = null;


    public Graph(Set set){
        this.graph = new HashSet<GraphNode>(set);
    }


    /**
     * 添加结点
     * @param node
     * @return
     */
    public boolean addNode(GraphNode node){
        for(Object o : node.arcList){
            ArcNode arc = (ArcNode)o;
            addArc(arc.adjNode,node,arc.weight);
        }
        return true;
    }


    /**
     * 添加边
     * @param start
     * @param end
     * @return
     */
    public boolean addArc(GraphNode start,GraphNode end,int weight){
        for(GraphNode node : graph){
            if(node.equals(start)){
                node.arcList.add(new ArcNode(weight,end));
            }
            if(node.equals(end)){
                node.arcList.add(new ArcNode(weight,start));
            }
        }
        return true;
    }


    /**
     * 删除结点
     * @param node
     * @return
     */
    public boolean removeNode(GraphNode node){
        ArrayList<ArcNode> arcList = null;
        for(GraphNode n : graph){
            arcList = n.arcList;
            for(ArcNode arc : arcList){
                if(arc.adjNode.equals(node)){
                    arcList.remove(arc);
                }
            }
        }
        return graph.remove(node);
    }


    /**
     * 移除边
     * @param start
     * @param end
     * @return
     */
    public boolean removeArc(GraphNode start,GraphNode end){
        for(GraphNode node : graph){
            if(node.equals(start)){
                ArrayList<ArcNode> list = node.arcList;
                for(ArcNode arc : list){
                    if(arc.adjNode.equals(end)){
                        list.remove(arc);
                    }
                }
            }
            if(node.equals(end)){
                ArrayList<ArcNode> list = node.arcList;
                for (ArcNode arc : list){
                    if(arc.adjNode.equals(start)){
                        list.remove(arc);
                    }
                }
            }
        }
        return true;
    }


    /**
     * 获取邻接矩阵
     * @return
     */
    public int[][] getMatrix(){
        int num = graph.size();
        int[][] result = new int[num][num];
        for(GraphNode node : graph){
            ArrayList<ArcNode> list = node.arcList;
            for(ArcNode arc : list){
                result[node.num][arc.adjNode.num] = arc.weight;
            }
        }
        return result;
    }


    /**
     * 广度优先遍历
     * @param start
     * @param visitor
     */
    public void breadthTraversal(GraphNode start , IVisitor visitor){
        Set temp = (Set)graph.clone();
        Queue<GraphNode> queue = new ArrayBlockingQueue<GraphNode>(10);
        queue.offer(start);
        while (!queue.isEmpty()){
            GraphNode node = queue.poll();
            if(temp.contains(node)){
                visitor.visit(node);
                temp.remove(node);
                for(Object o : node.arcList){
                    GraphNode adj = ((ArcNode)o).adjNode;
                    if(temp.contains(adj)){
                        queue.offer(adj);
                    }
                }
            }
        }
    }


    /**
     * 深度优先遍历
     * @param start
     * @param visitor
     */
    public void depthTraversal(GraphNode start,IVisitor visitor){
        Set temp = (Set)graph.clone();
        while (temp.iterator().hasNext()){
            GraphNode node = (GraphNode)temp.iterator().next();
            recTraversal(temp,node,visitor);
        }
    }


    /**
     * 递归访问图结点
     * @param set
     * @param node
     * @param visitor
     */
    private void recTraversal(Set set,GraphNode node,IVisitor visitor){
        if(null!=node){
            if(set.contains(node)){
                visitor.visit(node);
                set.remove(node);
                for(Object o : node.arcList){
                    GraphNode adj = ((ArcNode)o).adjNode;
                    if(set.contains(adj)){
                        recTraversal(set,adj,visitor);
                    }
                }
            }
        }
    }
}
