package com.icecoder.leecode.tencent;

import java.util.*;

/**
 * @author libing
 * @version 1.0
 * @date 2020/9/5 10:02 上午
 */
public class Solution35 {

    public static TreeNode create(int val, TreeNode left, TreeNode right) {
        TreeNode tr = new TreeNode();
        tr.val = val;
        tr.left = left;
        tr.right = right;
        return tr;
    }

    public static void main(String[] args) {
        TreeNode v5 = create(5, null, null);
        TreeNode v3 = create(3, null,  null);
        TreeNode v4 = create(4, v3, v5);
        TreeNode v0 = create(0, null, null);
        TreeNode v2 = create(2, v0, v4);
        TreeNode v7 = create(7, null, null);
        TreeNode v9 = create(9, null, null);
        TreeNode v8 = create(8, v7, v9);
        TreeNode v6 = create(6, v2, v8);
        System.out.println("ret:" + new Solution35().lowestCommonAncestor(v6, v2, v8).val);
        System.out.println("ret:" + new Solution35().lowestCommonAncestor(v6, v2, v4).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = new Stack<>();
        Stack<TreeNode> qPath = new Stack<>();
        searchPath(root, p, pPath);
        searchPath(root, q, qPath);
        TreeNode ret = null;
        while (!qPath.isEmpty() && !pPath.isEmpty()) {
            TreeNode l = pPath.pop();
            TreeNode r = qPath.pop();
            if (l == r) {
                ret = l;
            } else {
                break;
            }
        }
        return ret;
    }

    public boolean searchPath(TreeNode node, TreeNode v, Stack<TreeNode> pathNode) {
        if (node == null) {
            return false;
        }
        if (node.val == v.val) {
            pathNode.push(node);
           return true;
        } else if (searchPath(node.left, v, pathNode) || searchPath(node.right, v, pathNode)) {
            pathNode.push(node);
            return true;
        } else {
            return false;
        }
    }
}
