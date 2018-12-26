package com.ghlin.leetcode.list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

class ListNode {
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildList(int[] nums) {
        if (nums.length == 0) {
            return new ListNode(0);
        }

        ListNode head = null;
        ListNode lastNode = null;
        int i = 0;

        while (i < nums.length) {
            ListNode newNode = new ListNode(nums[i]);
            if (head == null) {
                head = lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode = newNode;
            }
            i++;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
