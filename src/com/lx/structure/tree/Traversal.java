package com.lx.structure.tree;

import com.lx.common.interfaces.IVisitor;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 对树进行遍历
 * Created by lx on 2015/9/21.
 */
public class Traversal {

    //访问结点接口
    private IVisitor visit;


    /**
     * 对树进行遍历
     * @param tree
     * @param way 遍历方式，0：先序；1：中序；2：后序
     */
    public void traversal(Tree tree,int way,IVisitor visit){
        this.visit = visit;
        switch (way){
            case 0:preOrder(tree.root);
                break;
            case 1:inOrder(tree.root);
                break;
            case 2:postOrder(tree.root);
                break;
            case 3:preOrderNoRec(tree.root);
                break;
            case 4:inOrderNoRec(tree.root);
                break;
            case 5:postOrderNoRec(tree.root);
                break;
            case 6:levelOrder(tree.root);
                break;
            default:
                break;
        }
    }


    /**
     * 先序遍历，递归处理结点值
     * @param node
     */
    private void preOrder(TreeNode node){
        if(null!=node){
            dealNode(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }


    /**
     * 先序遍历，非递归方式
     * @param node
     */
    private void preOrderNoRec(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = node;
        while(null!=temp||!stack.empty()){
            if(null!=temp){
                dealNode(temp);        //访问结点
                stack.push(temp);      //结点入栈
                temp = temp.leftChild;
            }else {
                temp = stack.pop().rightChild;    //访问右孩子
            }
        }
    }


    /**
     * 中序递归遍历
     * @param node
     */
    private void inOrder(TreeNode node){
        if(null!=node){
            inOrder(node.leftChild);
            dealNode(node);
            inOrder(node.rightChild);
        }
    }


    /**
     * 中序遍历，无递归
     * @param node
     */
    private void inOrderNoRec(TreeNode node){
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = node;
        stack.push(temp);
        while (!stack.empty()){
            temp = stack.peek();
            while(null!=temp){     //找到最左孩子
                stack.push(temp.leftChild);
                temp = stack.peek();
            }
            stack.pop();  //空指针退栈
            if(!stack.empty()){
                temp = stack.pop();
                dealNode(temp);        //访问结点
                stack.push(temp.rightChild);    //访问右孩子
            }
        }
    }


    /**
     * 后序递归遍历
     * @param node
     */
    private void postOrder(TreeNode node){
        if(null!=node){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            dealNode(node);
        }
    }


    /**
     * 后序遍历，非递归
     * @param node
     */
    private void postOrderNoRec(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = node;        //当前访问结点
        TreeNode pre = node;        //上一个访问结点
        while(null!=cur||!stack.empty()){
            while(null!=cur){       //指向最左孩子
                stack.push(cur);
                cur = cur.leftChild;
            }
            cur = stack.peek();
            if(null==cur.rightChild||pre.equals(cur.rightChild)){  //结点无右孩子或者右孩子已访问
                cur = stack.pop();
                dealNode(cur);        //访问当前结点
                pre = cur;         //pre指向当前结点
                cur = null;        //cur置空，防止循环访问
            }else {
                cur = cur.rightChild;   //访问右孩子
            }
        }

    }


    /**
     * 层次遍历
     * @param node
     */
    private void levelOrder(TreeNode node){
        if(null!=node){
            Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(16);
            TreeNode temp = node;
            queue.offer(temp);
            while(!queue.isEmpty()){
                temp = queue.poll();
                dealNode(temp);
                if(null!=temp.leftChild){
                    queue.offer(temp.leftChild);
                }
                if(null!=temp.rightChild){
                    queue.offer(temp.rightChild);
                }
            }
        }
    }


    /**
     * 处理结点
     * @param node
     */
    private void dealNode(TreeNode node){
        visit.visit(node);
    }
}
