package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/1 4:47 下午
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x55qm1/
 *
 */
public class Solution14 {

    public static void main(String[] args) {
        ListNode v1 = new ListNode(2);
        ListNode v2 = new ListNode(4);
        ListNode v3 = new ListNode(3);
        v1.next = v2;
        v2.next = v3;

        ListNode v11 = new ListNode(5);
        ListNode v22 = new ListNode(6);
        ListNode v33 = new ListNode(4);
        v11.next = v22;
        v22.next = v33;
        Solution13.printList(new Solution14().addTwoNumbers(v1, v11));


        ListNode v111 = new ListNode(0);

        ListNode v1111 = new ListNode(1);
        v1111.next = new ListNode(8);
        Solution13.printList(new Solution14().addTwoNumbers(v1111, v111));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retHead = null;
        int v;
        int jv = 0;
        while (jv > 0 || l1 != null || l2 != null) {
            v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + jv;
            jv = v / 10;
            ListNode ret = new ListNode(v % 10);
            ret.next = retHead;
            retHead = ret;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return reverseList(retHead);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next;
        ListNode newHead = new ListNode(head.val);
        while ((next = head.next) != null) {
            ListNode tmpHead = new ListNode(next.val);
            tmpHead.next = newHead;
            newHead = tmpHead;
            head = next;
        }
        return newHead;
    }

}
