package com.company.h_LC225_Implement_Stack_Using_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
* 作业优化: 老师解法_使用一个队列实现栈,要求:push O(n), top O(1), pop O(1).
* */
public class MyStack_03fix <E> {

    /** Property */
    private Queue<E> queue;

    /** Life Circle */
    public MyStack_03fix(){
        queue = new LinkedList<>();
    }

    /** Public Method */

    /**
     * 进队后进行n-1次循环出队进队,使最后入队元素在第一位.
     * push O(n)
     * */
    public void push(E e){
        queue.add(e);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * top O(1)
     * */
    public E top(){
        return queue.peek();
    }

    /**
     * pop O(1)
     * */
    public E pop(){
        return queue.remove();
    }

    /**
     * isEmpty O(1)
     * */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack_03fix{" +
                "queue=" + queue +
                '}';
    }

    public static void main(String[] args) {
        MyStack_03fix<Integer> stack = new MyStack_03fix<>();
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
        MyStack_03fix{queue=[]}
        push
        MyStack_03fix{queue=[0]}
        push
        MyStack_03fix{queue=[1, 0]}
        push
        MyStack_03fix{queue=[2, 1, 0]}
        pop
        MyStack_03fix{queue=[1, 0]}
        top
        MyStack_03fix{queue=[1, 0]}
        peek top element is 1

        */
    }
}
