package com.lx.common.main;


import com.lx.structure.tree.HuffmanTree;
import com.lx.structure.tree.Traversal;
import com.lx.structure.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 运行入口
 * @author lx
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        Map<Character,Integer> map = new HashMap(20);
        map.put('A',14);//
        map.put('B',2);//
        map.put('C',6);//                     H109
        map.put('D',24);//       H45                          A64
        map.put('E',17);//   H21     D24           A28                 E36
        map.put('F',8);//                     A14      J14         E17     I19
        map.put('G',10);//                          J6      F8         I9       G10
        map.put('H',21);//                                         I3       C6
        map.put('I',1);//                                      I1       B2
        map.put('J',6);//
        HuffmanTree tree = new HuffmanTree();
        Tree result = tree.createHuffmanTree(map);
        Traversal traversal = new Traversal();
        for(int i=0;i<3;i++){
            traversal.traversal(result,i);
            System.out.println();
        }
    }

}
