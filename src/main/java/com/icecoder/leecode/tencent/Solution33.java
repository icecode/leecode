package com.icecoder.leecode.tencent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/31 8:16 上午
 */
public class Solution33 {

    public int maxPathSum(TreeNode root) {
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSum(root, max);
        return max.get();
    }

    public int maxPathSum(TreeNode node, AtomicInteger max) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSum(node.left, max);
        int right = maxPathSum(node.right, max);
        int lmr = node.val + Math.max(0, left) + Math.max(0, right);
        int ret = node.val + Math.max(0, Math.max(left, right));
        max.set(Math.max(max.get(), Math.max(lmr, ret)));
        return ret;
    }
}
