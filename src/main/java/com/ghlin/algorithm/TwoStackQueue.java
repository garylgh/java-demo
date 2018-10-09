package com.ghlin.algorithm;

import java.util.Stack;

public class TwoStackQueue<T> {
    private Stack<T> s1 = new Stack();
    private Stack<T> s2 = new Stack();

    public void add(T data) {
        this.s1.add(data);
    }

    public T pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> myq = new TwoStackQueue<>();
        myq.add(1);
        myq.add(2);
        myq.add(3);
        myq.add(4);

        System.out.println(myq.pop());
        System.out.println(myq.pop());
        myq.add(5);
        myq.add(6);
        System.out.println(myq.pop());
        System.out.println(myq.pop());
        System.out.println(myq.pop());
        System.out.println(myq.pop());
    }
}
