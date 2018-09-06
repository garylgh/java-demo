package com.ghlin.leetcode;

/*
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {
    static class ListNode {

        private static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;

        public ListNode() {
            head = tail = null;
        }

        public void add(int val) {
            Node newNode = new Node(val);
            Node currHead = head;

            head = newNode;
            newNode.next = (currHead == null) ? null : currHead;
        }

        public Node getFirst() {
            return head;
        }
    }
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.add(3);
        l1.add(4);
        l1.add(2);

//
//        Node currNode = l1.getFirst();
//        while (currNode != null) {
//            System.out.println(currNode.val);
//            currNode = currNode.next;
//        }
    }
}
