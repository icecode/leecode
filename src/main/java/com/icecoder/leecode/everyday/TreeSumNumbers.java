package com.icecoder.leecode.everyday;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author libing
 * @version 1.0
 * @date 2020/10/29 7:50 上午
 */
public class TreeSumNumbers {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l1 = new TreeNode(3);
        root.right = r1;
        root.left = l1;
        System.out.println("s:" + new TreeSumNumbers().sumNumbers(root));


        TreeNode root2 = new TreeNode(4);
        TreeNode r21 = new TreeNode(0);
        TreeNode l21 = new TreeNode(9);
        root2.right = r21;
        root2.left = l21;
        TreeNode l31 = new TreeNode(5);
        TreeNode l3r1 = new TreeNode(1);
        l21.left = l31;
        l21.right = l3r1;
        System.out.println("s:" + new TreeSumNumbers().sumNumbers(root2));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode node, int parentNumber) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return parentNumber * 10 + node.val;
        }
        return sumNumbers(node.left, parentNumber * 10 + node.val) + sumNumbers(node.right, parentNumber * 10 + node.val);
    }
}
