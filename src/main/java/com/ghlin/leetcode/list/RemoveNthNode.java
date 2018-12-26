package com.ghlin.leetcode.list;

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int length = 0;

        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        if (length < 0) {
            return null;
        }

        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;

        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        int i = 0;
        while (i < n+1) {
            first = first.next;
            i++;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n, head;
        head = n = new ListNode(1);
        n = n.next = new  ListNode(2);
        n = n.next = new  ListNode(3);
        n = n.next = new  ListNode(4);
        n.next = new  ListNode(5);

        ListNode.printList(removeNthFromEnd(head, 1));
//        printList(removeNthFromEnd2(head, 1));
    }
}
