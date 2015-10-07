package com.lx.structure.tree;

import com.lx.common.interfaces.IVisitor;
import com.lx.common.util.Node;

/**
 * 访问树结点元素
 * Created by lx on 2015/9/25.
 */
public class TreeVisitor implements IVisitor {
    @Override
    public boolean visit(Node node) {
        System.out.print(node.value + ", ");
        return true;
    }
}
