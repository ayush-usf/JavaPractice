package com.company.abstractDataType;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    int size;

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    // push q1 1,2,3
    // pop 1, 2,3
    // q2 3,2 , 1 -> head = head.next

    // reqd pop - 3 2 1

    private boolean isEmpty() {
        return false;
    }

    private int pop() {
        return 0;
    }

    private void push(int i) {
    }

    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}
