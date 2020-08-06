package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/6 8:02 下午
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5pmxc/
 */
public class Solution17 {

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;
        Solution13.printList(new Solution17().rotateRight(v1, 6));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int c = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            c++;
        }
        k = (k % c);
        while (k-- > 0) {
            ListNode tail2 = head;
            while (tail2.next != null){
                if (tail2.next.next == null) {
                    //最后一个
                    tail2.next.next = head;
                    head = tail2.next;
                    tail2.next = null;
                } else {
                    tail2 = tail2.next;
                }
            }
        }
        return head;
    }
}
