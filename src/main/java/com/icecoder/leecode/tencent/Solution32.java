package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/31 8:05 上午
 */
public class Solution32 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left, 1);
        int right = maxDepth(root.right, 1);
        return Math.max(left, right);
    }

    public int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int left = maxDepth(node.left, depth + 1);
        int right = maxDepth(node.right, depth + 1);
        return Math.max(left, right);
    }
}
