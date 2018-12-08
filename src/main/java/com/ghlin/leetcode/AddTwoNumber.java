package com.ghlin.leetcode;

/*
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {
    public static class ListNode {
        int val;
        ListNode next = null;

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

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int sum = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2Val = l2.getVal();
                l2 = l2.getNext();
            }
            sum += l1Val + l2Val;

            System.out.println("sum = " + sum);

            ListNode tmpNode;
            if (sum >= 10) {
                tmpNode = new ListNode(sum - 10);
                sum = 1;
            } else {
                tmpNode = new ListNode(sum);
                sum = 0;
            }

            if (head == null) {
                head = tail = tmpNode;
            } else {
                tail.setNext(tmpNode);
                tail = tmpNode;
            }
        }
        if (sum > 0) {
            tail.setNext(new ListNode(sum));
        }

        return head;
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

    public static void main(String[] args) {
//        ListNode l1 = buildList(new int[] {1, 2, 3});
//        ListNode l2 = buildList(new int[] {4, 5, 6});


    }
}
