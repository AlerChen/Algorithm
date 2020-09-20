package com.company.h_LC225_Implement_Stack_Using_Queues;
import com.company.d_Loop_Queue.LoopQueue;


/*
* 作业: 使用队列实现栈
* */
public class MyStack <E>{

    /** Property */
    private LoopQueue queue;

    /** Life Circle */
    public MyStack(int capacity){
        queue = new LoopQueue(capacity);
    }

    public MyStack(){
        this(10);
    }

    /** Public Method */
    public void push(E e){
        queue.enqueue(e);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public E pop(){
        if (queue.isEmpty()) return null;
        LoopQueue tempQueue = new LoopQueue();
        E topE = null;
        while (!queue.isEmpty()){
            E e = (E) queue.dequeue();
            if (queue.isEmpty()){
                topE = e;
                break;
            }
            tempQueue.enqueue(e);
        }
        queue = tempQueue;
        return topE;
    }

    public E peek(){
        if (queue.isEmpty()) return null;
        LoopQueue tempQueue = new LoopQueue();
        E topE = null;
        while (!queue.isEmpty()){
            E e = (E) queue.dequeue();
            if (queue.isEmpty()){
                topE = e;
            }
            tempQueue.enqueue(e);
        }
        queue = tempQueue;
        return topE;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "queue=" + queue +
                '}';
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
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
        MyStack{queue=Queue: size = 0, capacity = 10
        front [] tail}
        push
        MyStack{queue=Queue: size = 1, capacity = 10
        front [0] tail}
        push
        MyStack{queue=Queue: size = 2, capacity = 10
        front [0, 1] tail}
        push
        MyStack{queue=Queue: size = 3, capacity = 10
        front [0, 1, 2] tail}
        pop
        MyStack{queue=Queue: size = 2, capacity = 10
        front [0, 1] tail}
        peek
        MyStack{queue=Queue: size = 2, capacity = 10
        front [0, 1] tail}
        peek top element is 1
        */
    }
}
