package com.ghlin.algorithm.DataStructure;

public class SinglyLinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public void add(T data) {
        Node<T> f = tail;
        Node<T> newNode = new Node<>(data);
        new Node<>(data);
        if (f == null) {
            head = tail = newNode;
        } else {
            f.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node<T> h = head;
        while (h != null) {
            System.out.println(h.getData());
            h = h.next;
        }
    }

    public void revert() {
        Node<T> h = head;
        if (h == null || h.next == null)
            return;

        Node<T> hnext = h.next;
        head.next = null;
        tail = head;

        while (hnext != null) {
            Node r = hnext.next;
            hnext.next = h;
            h = hnext;
            hnext = r;
        }

        head = h;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> slink = new SinglyLinkedList<Integer>();
        slink.add(3);
        slink.add(6);
        slink.add(8);
        slink.add(9);
        slink.add(0);

        slink.print();

        slink.revert();
        System.out.println("-------------revert:");

        slink.print();
    }
}
