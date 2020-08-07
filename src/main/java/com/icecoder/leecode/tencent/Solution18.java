package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;
import org.w3c.dom.NodeList;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/6 8:31 下午
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5axfe/
 */
public class Solution18 {

    public static void main(String[] args) {
        ListNode v1 = new ListNode(3);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(0);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        v5.next = v3;
        System.out.println("ret:" + new Solution18().hasCycle(v1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head;
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            head = head.next;
            if (p == head) {
                System.out.println("p:" + p.val);
                return true;
            }
        }
        return false;
    }
}
