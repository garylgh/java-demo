package com.ghlin.algorithm;

import java.util.LinkedList;

/**
 * 1、单向链表
 * 2、双向链表
 * 3、单向循环链表
 * 4、双向循环链表
 */
public class GLinkList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

    }

    private transient Node<T> head;
    private transient Node<T> tail;
    private transient int size = 0;

    public GLinkList() {
    }

    public boolean addFirst(T val) {
        final Node<T> f = head;
        Node newNode = new Node(null, val, f);
        head = newNode;
        if (f == null) {
            tail = newNode;
        } else {
            f.previous = newNode;
        }
        size++;

        return true;
    }

    public T removeFist() {
        final Node<T> f = head;
        if (f == null) {
            return null;
        }

        final T element = f.value;
        final Node<T> next = f.next;

        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.previous = null;
        }

        size--;

        return element;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        GLinkList<Integer> myLink = new GLinkList<>();
        myLink.addFirst(50);
        myLink.addFirst(40);
        myLink.addFirst(30);
        myLink.addFirst(60);
        myLink.addFirst(90);

        System.out.println(myLink.size());

        myLink.removeFist();
        myLink.removeFist();
        System.out.println(myLink.size());

        Integer fe = myLink.removeFist();
        while( fe != null) {
            System.out.println(fe);
            fe = myLink.removeFist();
        }
    }
}
