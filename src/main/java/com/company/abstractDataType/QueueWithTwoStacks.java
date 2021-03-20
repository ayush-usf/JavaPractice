package com.company.abstractDataType;

import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueueConst(int elem) {
        s1.push(elem);
    }

    /* Function to deQueue an item from queue */
    public int deQueueN() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return -1;
        }

        /* Move from s1 to stack 2 only if s2 is empty */
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }

        if (s2.isEmpty()) { // we filled s2 from s1, if s2 was empty
            throw new Error("Error: Queue cannot be empty at this stage");
        }
        return s2.pop();
    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueueConst(1);
        queue.enqueueConst(2);
        System.out.println(queue.deQueueN());
        System.out.println(queue.deQueueN());
        System.out.println("isEmpty : "+ queue.isEmpty());
        System.out.println(queue.deQueueN());
        System.out.println("isEmpty : "+ queue.isEmpty());
    }
}