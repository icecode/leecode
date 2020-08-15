package com.icecoder.leecode.tencent;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/13 8:45 下午
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[Node:" + val + "]";
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

}
