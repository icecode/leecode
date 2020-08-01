package com.icecoder.leecode.tencent;

import com.icecoder.leecode.tencent.Solution13.ListNode;
/**
 * @author libing
 * @version 1.0
 * @date 2020/8/1 5:39 下午
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/x59tp7/
 */
public class Solution15 {

    public static void main(String[] args) {

        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;

        ListNode v11 = new ListNode(2);
        ListNode v22 = new ListNode(4);
        ListNode v33 = new ListNode(6);
        v11.next = v22;
        v22.next = v33;
        Solution13.printList(new Solution15().mergeTwoLists(v1, v11));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode tmp = new ListNode(l1.val);
                tmp.next = ret;
                ret = tmp;
                l1 = l1.next;
            } else {
                ListNode tmp = new ListNode(l2.val);
                tmp.next = ret;
                ret = tmp;
                l2 = l2.next;
            }
        }
        if (ret != null) {
            ListNode next;
            ListNode newRet = new ListNode(ret.val);
            while ((next = ret.next) != null) {
                ListNode tmpHead = new ListNode(next.val);
                tmpHead.next = newRet;
                newRet = tmpHead;
                ret = next;
            }
            ret = newRet;
        }

        ListNode tail;
        if (l1 != null) {
            if (ret == null) {
                return l1;
            }
            tail = ret;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = l1;
        }
        if (l2 != null) {
            if (ret == null) {
                return l2;
            }
            tail = ret;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = l2;
        }
        return ret;
    }
}
