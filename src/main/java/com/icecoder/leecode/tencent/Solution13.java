package com.icecoder.leecode.tencent;

import org.w3c.dom.Node;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/1 3:55 下午
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * https://leetcode-cn.com/leetbook/read/tencent/x5xg2m/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution13 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "[Node:" + val + "]";
        }
    }

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        printList(new Solution13().reverseList2(v1));
    }

    public static void printList(ListNode head) {
        ListNode t = head;
        System.out.print("[");
        while (t != null) {
            System.out.print(t.val);
            if (t.next == null) {
                break;
            }
            System.out.print(",");
            t = t.next;
        }
        System.out.print("]");
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

    public ListNode reverseList2(ListNode head) {
        return reverseList2(head.next, new ListNode(head.val));
    }

    public ListNode reverseList2(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode tmpHead = new ListNode(head.val);
        tmpHead.next = newHead;
        return reverseList2(head.next, tmpHead);
    }

}
