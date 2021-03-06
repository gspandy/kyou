package com.github.nuclearg.kyou.pack.matcher.pipe;

import com.github.nuclearg.kyou.dom.KyouItem;

/**
 * 父节点匹配器
 * <p>
 * 在右侧匹配器与当前报文节点相匹配的前提下，检查左侧匹配器是否与当前报文节点的父节点成功匹配
 * </p>
 * 
 * @example array>field
 *          匹配所有位于数组中的报文域
 * 
 * @author ng
 * 
 */
@PipeMatcherDescription(">")
class Parent extends PipeMatcher {

    @Override
    public boolean matches(KyouItem item) {
        if (!this.right.matches(item))
            return false;

        KyouItem parent = item.parent();
        if (parent == null || parent == item)
            return false;

        return this.left.matches(parent);
    }

    @Override
    public String toString() {
        return this.left + " " + this.right;
    }

}
