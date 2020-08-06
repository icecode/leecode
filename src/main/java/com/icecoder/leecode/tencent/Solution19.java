package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/6 8:31 下午
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x5ajbg/
 */
public class Solution19 {

    public static void main(String[] args) {
        //[-21,10,17,8,4,26,5,35,33,-7,-16,  27,-12,6,29,-12,5,9,20,14,14 ,2,13,-24,21, 23,-21,5]
        ListNode vf21 = new ListNode(-21);
        ListNode v10 = new ListNode(10);
        ListNode v17 = new ListNode(17);
        ListNode v8 = new ListNode(8);
        ListNode v4 = new ListNode(4);
        ListNode v26 = new ListNode(26);
        ListNode v5 = new ListNode(5);
        ListNode v35 = new ListNode(35);
        ListNode v33 = new ListNode(33);
        ListNode vf7 = new ListNode(-7);
        ListNode vf16 = new ListNode(-16);
        ListNode v27 = new ListNode(-27);
        ListNode vf12 = new ListNode(-12);
        ListNode v6 = new ListNode(6);
        ListNode v29 = new ListNode(29);
        ListNode vff12 = new ListNode(-12);
        ListNode vv5 = new ListNode(5);
        ListNode v9 = new ListNode(9);
        ListNode v20 = new ListNode(20);
        ListNode v14 = new ListNode(14);
        ListNode vv14 = new ListNode(14);
        ListNode v2 = new ListNode(2);
        ListNode v13 = new ListNode(13);
        ListNode vf24 = new ListNode(-24);
        ListNode v21 = new ListNode(21);
        ListNode v23 = new ListNode(23);
        ListNode vff21 = new ListNode(-21);
        ListNode vvv5 = new ListNode(-5);
        vf21.next = v10;
        v10.next = v17;
        v17.next = v8;
        v8.next = v4;
        v4.next = v26;
        v26.next = v5;
        v5.next = v35;
        v35.next = v33;
        v33.next = vf7;
        vf7.next = vf16;
        vf16.next = v27;
        v27.next = vf12;
        vf12.next = v6;
        v6.next = v29;
        v29.next = vff12;
        vff12.next = vv5;
        vv5.next = v9;
        v9.next = v20;
        v20.next = v14;
        v14.next = vv14;
        vv14.next = v2;
        v2.next = v13;
        v13.next = vf24;
        vf24.next = v21;
        v21.next = v23;
        v23.next = vff21;
        vff21.next = vvv5;
        vvv5.next = v21;
        System.out.println("ret:" + new Solution19().detectCycle(vf21));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode n = head;
            while (n != slow) {
                slow = slow.next;
                n = n.next;
            }
            return slow;
        }
        return null;
    }
}
