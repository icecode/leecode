package com.icecoder.leecode.tencent;


import com.icecoder.leecode.tencent.Solution13.ListNode;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/1 6:12 下午
 */
public class Solution16 {

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

        ListNode v111 = new ListNode(0);
        ListNode v222 = new ListNode(9);
        v111.next = v222;
        Solution13.printList(new Solution16().mergeKLists(new ListNode[]{v1, v11, v111}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        ListNode minNode = null;
        int minNodeIndex = 0;
        while (true) {
            int i;
            for (i = 0; i < lists.length; i++) {
                if (minNode == null || (lists[i] != null && lists[i].val < minNode.val)) {
                    minNode = lists[i];
                    minNodeIndex = i;
                }
            }
            if (minNode == null) {
                break;
            }
            ListNode tmp = new ListNode(minNode.val);
            tmp.next = ret;
            ret = tmp;
            lists[minNodeIndex] = minNode.next;
            minNode = null;
        }
        if (ret == null) {
            return null;
        }
        ListNode next;
        ListNode newRet = new ListNode(ret.val);
        while ((next = ret.next) != null) {
            ListNode tmpHead = new ListNode(next.val);
            tmpHead.next = newRet;
            newRet = tmpHead;
            ret = next;
        }
        return newRet;
    }
}
