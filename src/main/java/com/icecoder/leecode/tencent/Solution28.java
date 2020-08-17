package com.icecoder.leecode.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author libing
 * @version 1.0
 * @date 2020/8/13 8:44 下午
 */
public class Solution28 {

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        v1.next = v3;
        v3.next = v2;
        v2.next = v5;
        v5.next = v4;
        ListNode.printList(v1);
        System.out.println("");
        ListNode.printList(new Solution28().quickSort(v1));
    }


    public ListNode quickSort(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public void quickSort(ListNode head, ListNode end) {
        if (head == end || head == null || head.next == null) {
            return;
        }
        ListNode tail = head;
        while (tail.next != end) {
            tail = tail.next;
        }
        int pivot = tail.val;
        int tmp;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2 != end) {
            if (p2.val < pivot) {
                tmp = p2.val;
                p2.val = p1.val;
                p1.val = tmp;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        if (p2 != p1) {
            tail.val = p1.val;
            p1.val = pivot;
            quickSort(head, p1);
            quickSort(p1.next, end);
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode sortedHead = head;
        ListNode tail;
        int tmp;
        while (sortedHead != null) {
            tail = sortedHead.next;
            while (tail != null) {
                if (tail.val < sortedHead.val) {
                    tmp = tail.val;
                    tail.val = sortedHead.val;
                    sortedHead.val = tmp;
                }
                tail = tail.next;
            }
            sortedHead = sortedHead.next;
        }
        return head;
    }

    public ListNode sortList2(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            values.add(tail.val);
            tail = tail.next;
        }

        Object[] sortedValues = values.toArray();
        Arrays.sort(sortedValues);
        tail = head;
        int i = 0;
        while (tail != null) {
            tail.val = (int)sortedValues[i];
            i++;
            tail = tail.next;
        }
        return head;
    }
}
