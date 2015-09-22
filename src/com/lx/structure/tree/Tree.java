package com.lx.structure.tree;

/**
 * 树
 * Created by lx on 2015/9/21.
 */
public class Tree {
    //根节点
    public TreeNode root = null;


    /**
     * 获取树的深度
     * @return
     */
    public int getDepth(){
        return getDepth(root);
    }


    /**
     * 获取树的结点数
     * @return
     */
    public int getNodeNum(){
        return getNodeNum(root);
    }


    /**
     * 递归获取树高度
     * @param node
     * @return
     */
    private int getDepth(TreeNode node){
        if(null==node){
            return 0;
        }else {
            int leftDepth = getDepth(node.leftChild);
            int rightDepth = getDepth(node.rightChild);
            return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
        }
    }


    /**
     * 递归获取树的结点数
     * @param node
     * @return
     */
    private int getNodeNum(TreeNode node){
        if(null==node){
            return 0;
        }else{
            return getNodeNum(node.leftChild)+getNodeNum(node.rightChild)+1;
        }
    }
}
