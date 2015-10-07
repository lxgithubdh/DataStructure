package com.lx.structure.graph;

import com.lx.common.interfaces.IVisitor;
import com.lx.common.util.Node;

/**
 * 访问图结点
 * Created by lx on 2015/9/27.
 */
public class GraphVisitor implements IVisitor{
    @Override
    public boolean visit(Node node) {
        System.out.print(node.value + ", ");
        return true;
    }
}
