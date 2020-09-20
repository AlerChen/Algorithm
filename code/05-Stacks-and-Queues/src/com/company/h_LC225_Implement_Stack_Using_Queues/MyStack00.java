package com.company.h_LC225_Implement_Stack_Using_Queues;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 作业: 使用队列实现栈
 * 修改: 使用系统队列
 * */
public class MyStack00<E> {

    /** Property */
    private Queue<E> queue;

    /** Life Circle */
    public MyStack00(){
        queue = new LinkedList();
    }

    /** Public Method */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void push(E e){
        queue.add(e);
    }

    public E pop(){
        Queue tempQueue = new LinkedList();
        E topE = null;
        while (!queue.isEmpty()){
            E e = queue.remove();
            if (queue.isEmpty()){
                topE = e;
                break;
            }
            tempQueue.add(e);
        }
        queue = tempQueue;
        return topE;
    }

    public E peek(){
        Queue tempQueue = new LinkedList();
        E topE = null;
        while (!queue.isEmpty()){
            E e = queue.remove();
            if (queue.isEmpty()){
                topE = e;
            }
            tempQueue.add(e);
        }
        queue = tempQueue;
        return topE;
    }

    @Override
    public String toString() {
        return "MyStack00{" +
                "queue=" + queue +
                '}';
    }

    public static void main(String[] args) {
        MyStack00<Integer> stack = new MyStack00<>();
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
        System.out.println("peek");
        Integer i  = stack.peek();
        System.out.println(stack);
        System.out.println("peek top element is " + i);

        /*
        stack
        MyStack00{queue=[]}
        push
        MyStack00{queue=[0]}
        push
        MyStack00{queue=[0, 1]}
        push
        MyStack00{queue=[0, 1, 2]}
        pop
        MyStack00{queue=[0, 1]}
        peek
        MyStack00{queue=[0, 1]}
        peek top element is 1
        */

    }
}
