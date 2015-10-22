package com.lx.structure.graph;

import java.util.*;

/**
 * 最小生成树
 * Created by lx on 2015/10/10.
 */
public class MSTree {


    /**
     * 使用kruskal算法获取最小生成树
     * @param graph
     * @return
     */
    public Graph getMSTKruskal(Graph graph){
        HashSet<HashSet<GraphNode>> nodeSet = new HashSet<HashSet<GraphNode>>();  //已连通的结点集合组成的集合
        TreeSet<Arc> arcSet = new TreeSet<Arc>(); //弧集合，以升序排序
        HashSet<GraphNode> mstSet = new HashSet<GraphNode>();//最小生成树结点集合
        GraphNode[] nodeArr = new GraphNode[graph.graph.size()];//最小生成树tag和结点映射
        for(GraphNode node : graph.graph){   //初始化
            GraphNode temp = new GraphNode(node.value,node.tag); //生成新节点
            nodeArr[temp.tag] = temp;  //填充映射数组
            mstSet.add(temp);  //加入生成树结点集合
            HashSet<GraphNode> set = new HashSet<GraphNode>();
            set.add(node);   //将每个结点放入只有自己组成的集合
            nodeSet.add(set); //加入集合
            for(Object o : node.arcList){  //初始化弧集合
                ArcNode an = (ArcNode)o;
                Arc arc = new Arc();
                arc.startNode = node;
                arc.endNode = an.adjNode;
                arc.weight = an.weight;
                arcSet.add(arc);    //加入弧集合
            }
        }
        Graph mstGraph = new Graph(mstSet);  //生成新树
        while (nodeSet.size()>1){  //当nodeSet集合将所有子集合归并到一个集合中，循环结束
            Arc arc = arcSet.pollFirst();  //获取权值最小的弧
            if(null==arc){   //如果弧集合遍历结束，则退出
                break;
            }
            HashSet<GraphNode> startSet = getSet(arc.startNode,nodeSet);  //获取结点所在集合
            HashSet<GraphNode> endSet = getSet(arc.endNode,nodeSet);
            if(null==startSet||null==endSet){ //如果找不到所在集合，则退出
                break;
            }
            if(startSet.equals(endSet)){  //如果两个结点在同一集合，则进入下一次循环
                continue;
            }
            //将此边加入到图中
            mstGraph.addArc(nodeArr[arc.startNode.tag], nodeArr[arc.endNode.tag], arc.weight);
            HashSet<GraphNode> temp = new HashSet<GraphNode>(); //存放合并后的集合元素
            temp.addAll(startSet); //合并集合
            temp.addAll(endSet);  //此处不能调用某个set的addAll方法，
            // 将set加入到集合中后，如果修改set，会使其hashcode改变，导致其无法删除
            nodeSet.remove(startSet);//移除多余集合
            nodeSet.remove(endSet);
            nodeSet.add(temp);
        }
        return mstGraph;
    }


    /**
     * 获取图结点所在的集合
     * @param node
     * @return
     */
    private HashSet<GraphNode> getSet(GraphNode node,HashSet<HashSet<GraphNode>> nodeSet){
        for(HashSet<GraphNode> set : nodeSet){
            if(set.contains(node)){
                return set;
            }
        }
        return null;
    }


    /**
     * 使用Prim算法获取最小生成树
     * @param graph
     * @return
     */
    public Graph getMSTPrim(Graph graph){
        TreeSet<Arc> arcSet = new TreeSet<Arc>();  //记录当前树与剩余结点的弧信息，按权重升序排列
        HashSet<GraphNode> mstNodes = new HashSet<GraphNode>(); //已纳入MST结点集合
        Graph mstGraph = new Graph(mstNodes); //最小生成树，初始为空
        GraphNode startNode = graph.graph.iterator().next(); //随机获取一个结点作为起始结点
        GraphNode node = new GraphNode(startNode.value,startNode.tag); //实例化MST结点
        mstGraph.addNode(node);  //加入结点
        mstNodes.add(startNode);
        fillArcSet(mstNodes,arcSet);  //更新弧信息集合
        while(mstGraph.graph.size()<graph.graph.size()){ //将所有结点纳入MST，则终止循环
            if(null==arcSet){  //如果更新后弧列表为空，则退出循环
                break;
            }
            Arc arc = arcSet.first(); //取得最小权重的弧
            node = new GraphNode(arc.endNode.value,arc.endNode.tag);//将其结束结点纳入MST
            mstGraph.addNode(node);
            mstGraph.addArc(mstGraph.getNodeByTag(arc.startNode.tag),node,arc.weight);//向MST添加弧
            mstNodes.add(arc.endNode); //将终止结点纳入MST树结点集合
            fillArcSet(mstNodes,arcSet);//刷新弧信息集合
        }
        return mstGraph;
    }


    /**
     * 刷新弧集合，将已加入最小生成树的结点到其他结点的路径权重按升序加入集合
     * @param mstNodes
     * @param arcSet
     */
    private void fillArcSet(Set<GraphNode> mstNodes,TreeSet<Arc> arcSet){
        arcSet.clear();
        for(GraphNode node : mstNodes){
            ArrayList<ArcNode> arcList = node.arcList;
            for(ArcNode an : arcList){
                if(!mstNodes.contains(an.adjNode)){
                    Arc arc = new Arc();
                    arc.startNode = node;
                    arc.endNode = an.adjNode;
                    arc.weight = an.weight;
                    arcSet.add(arc);
                }
            }
        }
    }
}


