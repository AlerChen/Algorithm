package com.company.h_LC225_Implement_Stack_Using_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
* 作业优化: 使用队列实现栈, 要求: push O(n), top O(1), pop O(1);
* */
public class MyStack_02 <E> {

    /** Property */
    private Queue<E> queue;

    /** Life Circle */
    public MyStack_02(){
        queue = new LinkedList<>();
    }

    /** Public Method */
    public void push(E e){
        Queue<E> tempQueue = new LinkedList<>();
        tempQueue.add(e);
        // the first element
        if (queue.isEmpty()){
            queue = tempQueue;
            return;
        }
        while (!queue.isEmpty()){
            E tempE = queue.remove();
            tempQueue.add(tempE);
        }
        queue = tempQueue;
    }

    public E top(){
        return queue.peek();
    }

    public E pop(){
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack_02{" +
                "queue=" + queue +
                '}';
    }

    public static void main(String[] args) {
        MyStack_02<Integer> stack = new MyStack_02<>();
        System.out.println("stack");
        System.out.println(stack);
        System.out.println("push");
        stack.push(0);
        System.out.println(stack);
        System.out.println("push");
        stack.push(1);
        System.out.println(stack);
        System.out.println("push");
        stack.push(2);
        System.out.println(stack);
        System.out.println("pop");
        stack.pop();
        System.out.println(stack);
        System.out.println("top");
        Integer i  = stack.top();
        System.out.println(stack);
        System.out.println("peek top element is " + i);

        /*

        stack
        MyStack_02{queue=[]}
        push
        MyStack_02{queue=[0]}
        push
        MyStack_02{queue=[1, 0]}
        push
        MyStack_02{queue=[2, 1, 0]}
        pop
        MyStack_02{queue=[1, 0]}
        top
        MyStack_02{queue=[1, 0]}
        peek top element is 1

        */

    }
}
