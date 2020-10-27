package com.icecoder.leecode.everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author libing
 * @version 1.0
 * @date 2020/10/27 11:02 下午
 */
public class PreorderTraversal {

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
        TreeNode l11 = new TreeNode(3);
        root.right = r1;
        r1.left = l11;
        List<Integer> integers = new PreorderTraversal().preorderTraversal(root);
        System.out.println("v:" + integers);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode head = treeNodes.pop();
            if (head != null) {
                ret.add(head.val);
                treeNodes.push(head.right);
                treeNodes.push(head.left);
            }
        }
        return ret;
    }
}
