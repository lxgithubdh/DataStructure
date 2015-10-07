package com.lx.common.interfaces;

import com.lx.common.util.Node;

/**
 * 访问元素
 * Created by lx on 2015/9/25.
 */
public interface IVisitor {
    public boolean visit(Node node);
}
