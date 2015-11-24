package com.lx.common.main;


import com.lx.common.util.ArrayUtils;
import com.lx.javas.rpc.client.ProxyClient;
import com.lx.javas.rpc.client.RemoteService;
import com.lx.javas.rpc.server.ProxyServer;
import com.lx.structure.graph.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * 运行入口
 * @author lx
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        //startServer();
        //startClient();
        Function<String,Integer> function = Integer::valueOf;
        System.out.println(function.apply("123"));
    }

    private static void startClient(){
        RemoteService service = (RemoteService) ProxyClient.getProxy(RemoteService.class);
        System.out.println(service.call("Tom"));
    }

    private static void startServer(){
        ProxyServer server = new ProxyServer();
        server.startService();
    }



    public static void testGraph(){
        GraphNode<Integer> node0 = new GraphNode<Integer>(3,0);
        GraphNode<Integer> node1 = new GraphNode<Integer>(5,1);
        GraphNode<Integer> node2 = new GraphNode<Integer>(1,2);
        GraphNode<Integer> node3 = new GraphNode<Integer>(4,3);
        GraphNode<Integer> node4 = new GraphNode<Integer>(2,4);

        ArcNode arc0 = new ArcNode(2,node1);  //node0
        ArcNode arc1 = new ArcNode(4,node2);
        ArcNode arc2 = new ArcNode(1,node4);

        ArcNode arc3 = new ArcNode(2,node0);   //node1
        ArcNode arc4 = new ArcNode(4,node4);

        ArcNode arc5 = new ArcNode(4,node0);   //node2
        ArcNode arc6 = new ArcNode(3,node3);

        ArcNode arc7 = new ArcNode(3,node2);    //node3
        ArcNode arc10 = new ArcNode(2,node4);

        ArcNode arc8 = new ArcNode(1,node0);   //node4
        ArcNode arc9 = new ArcNode(4,node1);
        ArcNode arc11 = new ArcNode(2,node3);

        node0.arcList.add(arc0);
        node0.arcList.add(arc1);
        node0.arcList.add(arc2);

        node1.arcList.add(arc3);
        node1.arcList.add(arc4);

        node2.arcList.add(arc5);
        node2.arcList.add(arc6);

        node3.arcList.add(arc7);
        node3.arcList.add(arc10);

        node4.arcList.add(arc8);
        node4.arcList.add(arc9);
        node4.arcList.add(arc11);

        Set<GraphNode> set = new HashSet<GraphNode>();
        set.add(node0);
        set.add(node1);
        set.add(node2);
        set.add(node3);
        set.add(node4);

        Graph graph = new Graph(set);
        int[][] result = graph.getMatrix();
        ArrayUtils.printArr2D(result);

        ShortestPath path = new ShortestPath();
        Path[][] paths = path.floyd(graph);
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                System.out.println(paths[i][j]);
            }
        }
    }

}
