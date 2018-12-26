package com.ghlin.leetcode.list;

/*
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {

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



    public static void main(String[] args) {
//        ListNode l1 = buildList(new int[] {1, 2, 3});
//        ListNode l2 = buildList(new int[] {4, 5, 6});


    }
}
