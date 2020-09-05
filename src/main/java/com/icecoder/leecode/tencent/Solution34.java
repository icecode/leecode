package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/9/4 8:01 上午
 */
public class Solution34 {


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
        System.out.println("ret:" + new Solution34().lowestCommonAncestor(v6, v2, v8).val);
        System.out.println("ret:" + new Solution34().lowestCommonAncestor(v6, v2, v4).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor2(root, q, p);
        } else {
            return lowestCommonAncestor2(root, p, q);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        } else if (root.val > p.val && root.val < q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return null;
    }
}
