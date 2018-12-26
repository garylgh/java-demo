package com.ghlin.leetcode.list;

public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode head = curr;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return head.next;
   }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildList(new int[]{1, 2, 4});
        ListNode l2 = ListNode.buildList(new int[]{1, 3, 4});

        ListNode l3 = mergeTwoLists(l1, l2);
        ListNode.printList(l3);
    }
}
