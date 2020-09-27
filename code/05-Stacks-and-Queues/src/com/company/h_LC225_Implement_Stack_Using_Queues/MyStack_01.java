package com.company.h_LC225_Implement_Stack_Using_Queues;
import java.util.LinkedList;
import java.util.Queue;

/*
* 作业优化: 使用队列实现栈, 要求: push() O(n),top(1) O(1).
* */
public class MyStack_01 <E> {

    /** Property */
    private Queue<E> queue;
    private E topElement;

    /** Life Circle */
    public MyStack_01(){
        queue = new LinkedList();
        topElement = null;
    }

    /** Public Method */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    // push O(n)
    public void push(E e){
        queue.add(e);
        topElement = e;
    }

    // top O(1)
    public E top(){
        return topElement;
    }

//    // pop O(n) 个人解法
//    public E pop(){
//        Queue<E> tempQueue = new LinkedList<>();
//        E topE = null;
//        while (!queue.isEmpty()){
//            E e = queue.remove();
//            if (!queue.isEmpty()){
//                tempQueue.add(e);
//                topElement = e;
//            }else {
//                topE = e;
//            }
//        }
//        queue = tempQueue;
//        return topE;
//    }

    // pop O(n) 老师解法
    public E pop(){
        Queue<E> tempQueue = new LinkedList<>();
        while (queue.size() > 1){
            // 除了队列最后一个不出队,最后一个队首元素即新的top
            topElement = queue.peek();
            tempQueue.add(queue.remove());
        }
        // 最后一个元素(队列尾)
        E topE = queue.remove();
        queue = tempQueue;
        return topE;
    }

    @Override
    public String toString() {
        return "MyStack_01{" +
                "queue=" + queue +
                ", topElement=" + topElement +
                '}';
    }

    public static void main(String[] args) {
        MyStack_01<Integer> stack = new MyStack_01<>();
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
        MyStack_01{queue=[], topElement=null}
        push
        MyStack_01{queue=[0], topElement=0}
        push
        MyStack_01{queue=[0, 1], topElement=1}
        push
        MyStack_01{queue=[0, 1, 2], topElement=2}
        pop
        MyStack_01{queue=[0, 1], topElement=1}
        top
        MyStack_01{queue=[0, 1], topElement=1}
        peek top element is 1

        */
    }
}
