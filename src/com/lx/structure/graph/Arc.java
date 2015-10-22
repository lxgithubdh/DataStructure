package com.lx.structure.graph;

/**
 * 存储弧信息
 * @author lx
 */
class Arc implements Comparable{
    public GraphNode startNode;
    public GraphNode endNode;
    public int weight;


    @Override
    public int compareTo(Object o) {
        Arc arc = (Arc)o;
        int minus = weight - arc.weight;
        if(minus!=0){
            return minus;
        }else {
            if((startNode.equals(arc.startNode)&&endNode.equals(arc.endNode))||
                    startNode.equals(arc.endNode)&&endNode.equals(arc.startNode)){
                return 0;
            }else {
                return -1;
            }
        }
    }

    @Override
    public String toString(){
        return String.valueOf(startNode.tag)+"--"+String.valueOf(weight)+
                "->"+String.valueOf(endNode.tag);
    }
}
