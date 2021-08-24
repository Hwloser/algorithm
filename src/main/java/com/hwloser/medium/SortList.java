package com.hwloser.medium;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class SortList {
    public static void main(String[] args) {
        int[] ints = {4, 2, 1, 5};
        ListNode dummy = new ListNode();
        ListNode cursor = dummy;
        for (int anInt : ints) {
            cursor.next = new ListNode();
            cursor = cursor.next;
            cursor.val = anInt;
        }
        ListNode listNode =
            new SortList().sortList(dummy.next);
        System.out.println(listNode);
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode);
        }
    }
    public ListNode sortList1(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        PriorityQueue<ListNode> list = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (; (dummy = dummy.next) != null; ) {
            ListNode temp = new ListNode();
            temp.val = dummy.val;
            list.add(temp);
        }
        dummy = new ListNode();
        ListNode cursor = dummy;
        int len = list.size();

        for (int i = 0; i < len; i++) {
            cursor.next = new ListNode();
            cursor = cursor.next;
            cursor.val = Objects.requireNonNull(list.poll()).val;
        }

        return dummy.next;
    }
    // 归并排序
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode dummyHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeSort(left, right);
    }
    ListNode mergeSort(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        if (leftHead.val < rightHead.val) {
            leftHead.next = mergeSort(leftHead.next, rightHead);
            return leftHead;
        } else {
            rightHead.next = mergeSort(leftHead, rightHead.next);
            return rightHead;
        }
    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}