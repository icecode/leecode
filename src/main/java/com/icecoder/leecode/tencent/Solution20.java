package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;
import org.w3c.dom.NodeList;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/7 7:47 下午
 *
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x52ycv/
 *
 */
public class Solution20 {

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;

        v4.next = v5;
        System.out.println("ret:"  + new Solution20().getIntersectionNode(v1, v4));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA;
        ListNode tailB = headB;
        while (tailA != tailB) {
            tailA = tailA == null ? headB : tailA.next;
            tailB = tailB == null ? headA : tailB.next;
        }
        return tailA;
    }
}
