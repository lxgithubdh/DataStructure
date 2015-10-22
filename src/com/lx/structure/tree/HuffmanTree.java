package com.lx.structure.tree;

import java.util.Map;
import java.util.TreeSet;

/**
 * 生成哈夫曼树
 * Created by lx on 2015/9/22.
 */
public class HuffmanTree {


    /**
     * 构造哈夫曼树
     * @param map
     * @return
     */
    public BinaryTree createHuffmanTree(Map map){
        TreeSet<HuffmanNode> set = new TreeSet();      //创建有序集合
        BinaryTree tree = new BinaryTree();
        for (Object obj : map.entrySet()) {
            Map.Entry entry = (Map.Entry)obj;
            HuffmanNode node = new HuffmanNode(        //遍历map，构造哈夫曼树结点
                    entry.getKey(),(Integer)entry.getValue());
            set.add(node);             //将结点加入集合
        }
        HuffmanNode node = null;
        while(set.size()>1){
            HuffmanNode first = set.pollFirst();        //取出权重最小的两个结点
            HuffmanNode second = set.pollFirst();
            node = new HuffmanNode(
                    first.value,first.weight+second.weight);   //合并结点
            node.leftChild = first;
            node.rightChild = second;
            set.add(node);      //加入有序集
        }
        tree.root = node;
        return tree;
    }


    /**
     * 哈夫曼树结点，包含值和权重
     * @param <T>
     */
    private class HuffmanNode<T> extends BinaryTreeNode implements Comparable{


        //权重
        public int weight;


        public HuffmanNode(T value,int weight){
            super(value);
            this.weight = weight;
        }


        @Override
        public int compareTo(Object o) {
            int minu = 0;
            if(!this.value.equals(((HuffmanNode)o).value)){
                minu = this.weight - ((HuffmanNode)o).weight;
                minu = minu==0?1:minu;
            }
            return minu;
        }
    }
}
