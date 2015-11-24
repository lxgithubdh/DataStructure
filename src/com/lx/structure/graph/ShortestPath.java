package com.lx.structure.graph;

import com.lx.common.constant.Constant;

/**
 * 最短路径
 * Created by lx on 2015/10/17.
 */
public class ShortestPath {


    public Path[] singleSourceSP(Graph graph,int start){
        int[] nodes = new int[graph.graph.size()]; //标识结点是否纳入集合
        nodes[start] = 1;  //初始结点纳入集合
        Path[] paths = new Path[graph.graph.size()]; //路径数组
        int[][] matrix = graph.getMatrix();  //图矩阵
        int[] weights = matrix[start];  //初始结点到各个结点距离
        for(int i=0;i<weights.length;i++){ //初始化
            if(i==start){
                paths[start] = new Path(start,start,0);  //到自身权重为0
            }else {
                int weight = Constant.MAX_INT;  //默认权重无穷大
                if(weights[i]>0){
                    weight = weights[i];  //初始化邻接节点权重
                }
                paths[i] = new Path(start,i,weight);
            }
        }

        while(!isFull(nodes)){//所有结点纳入集合，则循环结束
            int index = selectShortPath(paths,nodes);//选取最短路径
            nodes[index] = 1;  //将路径终点纳入集合
            int weight = paths[index].weight;
            for(int i=0;i<paths.length;i++){
                if(0!=matrix[index][i]&&weight+matrix[index][i]<paths[i].weight){
                    paths[i].refresh(paths[index],matrix[index][i]);  //更新路径
                }
            }
        }
        return paths;
    }


    /**
     * 获取最短的路径
     * @param paths
     * @return
     */
    private int selectShortPath(Path[] paths,int[] nodes){
        int value=Constant.MAX_INT,index=-1;
        for(int i=0;i<paths.length;i++){
            if(nodes[i]==0){
                if(value>paths[i].weight){
                    index = i;
                    value = paths[i].weight;
                }
            }
        }
        return index;
    }


    /**
     * 判断结点是否全部加入集合
     * @return
     */
    private boolean isFull(int[] nodes){
        for(int i=0;i<nodes.length;i++){
            if(0==nodes[i]){
                return false;
            }
        }
        return true;
    }


    /**
     * floyd算法，求图中所有结点的最短路径
     * @param graph
     */
    public Path[][] floyd(Graph graph){
        int size = graph.graph.size();
        int[][] matrix = graph.getMatrix();    //图邻接矩阵
        Path[][] paths = new Path[size][size];   //路径矩阵
        for(int i=0;i<size;i++){    //初始化
            for (int j = 0; j < size; j++) {
                if(0==matrix[i][j]){
                    paths[i][j] = new Path(i,j,Constant.MAX_INT);
                }else {
                    paths[i][j] = new Path(i,j,matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                System.out.println(paths[i][j]);
            }
        }

        for(int k=0;k<size;k++){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(paths[i][k].weight+paths[k][j].weight<paths[i][j].weight){  //松弛
                        paths[i][j].refresh(paths[i][k],paths[k][j].weight);
                    }
                }
            }
            System.out.println("k = " + k);
            for (int i = 0; i < paths.length; i++) {
                for (int j = 0; j < paths[i].length; j++) {
                    System.out.println(paths[i][j]);
                }
            }
        }
        return paths;
    }
}
