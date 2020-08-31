package com.icecoder.leecode.tencent;


import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/28 8:29 下午
 */
public class Solution31 {


    public static void main(String[] args) {
        //[5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode();
        root.val = 5;

        TreeNode val3 = new TreeNode(3);
        root.left = val3;

        TreeNode val6 = new TreeNode(6);
        root.right = val6;

        TreeNode val2 = new TreeNode(2);
        val3.left = val2;

        TreeNode val1 = new TreeNode(1);
        val2.left = val1;

        TreeNode val4 = new TreeNode(4);
        val3.right = val4;



    }

    public int kthSmallest(TreeNode root, int k) {
        int[] kv = new int[k];
        List<Integer> elms = new LinkedList<>();
        recoveryOrder(root, elms);
        int i = 1;
        for (Integer elm : elms) {
            if (i == k) {
                return elm;
            }
            i++;
        }
        return -1;
    }

    public void recoveryOrder(TreeNode node, List<Integer> elms) {
        if (node == null) {
            return;
        }
        recoveryOrder(node.left, elms);
        elms.add(node.val);
        recoveryOrder(node.right, elms);
    }
}
