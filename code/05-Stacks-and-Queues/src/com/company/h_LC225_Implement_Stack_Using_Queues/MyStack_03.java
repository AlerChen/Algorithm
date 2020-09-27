package com.company.h_LC225_Implement_Stack_Using_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
* 作业优化: 使用队列实现栈,要求只使用一个队列完成.
* */
public class MyStack_03 <E>{

    /** Property */
    private Queue<E> queue;
    private E topElement;

    /** Life Circle */
    public MyStack_03(){
        queue = new LinkedList<>();
        topElement = null;
    }

    /** Public Method */
    // O(n)
    public void push(E e){
        queue.add(e);
        topElement = e;
    }

    // pop O(n) 利用size判断当前出队元素是否最后一个
    public E pop(){
        if (queue.isEmpty())
            return null;
        int times = 0;
        int size = queue.size();
        E topE = null;
        while (!queue.isEmpty()){
            E tempE = queue.remove();
            times ++;
            if (times == size){
                topE = tempE;
                break;
            }else {
                queue.add(tempE);
                topElement = tempE;
            }
        }
        return topE;
    }

    // top O(1)
    public E top(){
        return topElement;
    }

    // isEmpty O(1)
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack_03{" +
                "queue=" + queue +
                ", topElement=" + topElement +
                '}';
    }

    public static void main(String[] args) {
        MyStack_03<Integer> stack = new MyStack_03<>();
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
        MyStack_03{queue=[], topElement=null}
        push
        MyStack_03{queue=[0], topElement=0}
        push
        MyStack_03{queue=[0, 1], topElement=1}
        push
        MyStack_03{queue=[0, 1, 2], topElement=2}
        pop
        MyStack_03{queue=[0, 1], topElement=1}
        top
        MyStack_03{queue=[0, 1], topElement=1}
        peek top element is 1

        */
    }
}
