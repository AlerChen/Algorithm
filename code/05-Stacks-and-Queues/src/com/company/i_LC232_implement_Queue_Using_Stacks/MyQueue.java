package com.company.i_LC232_implement_Queue_Using_Stacks;
import java.util.Stack;

/*
* 作业: 使用栈实现队列
* 实现思路: 队列尾为栈底,队列头为栈顶,入队即入栈,出队时需要辅助栈把元素倒过来.
* */
public class MyQueue <E>{

    /** Property */
    private Stack stack;

    /** Life Circle */
    public MyQueue(){
        stack = new Stack();
    }

    /** Public Method */
    public void enqueue(E e){
        stack.push(e);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public E dequeue(){
        if (stack.isEmpty()) return null;
        Stack tempStack = new Stack();
        while (!stack.isEmpty()){
            E e = (E) stack.pop();
            tempStack.push(e);
        }
        E frontE = (E) tempStack.pop();
        while (!tempStack.isEmpty()){
            E e = (E) tempStack.pop();
            stack.push(e);
        }
        return frontE;
    }

    public E getFront(){
        if (stack.isEmpty()) return null;
        Stack tempStack = new Stack();
        while (!stack.isEmpty()){
            E e = (E) stack.pop();
            tempStack.push(e);
        }
        E frontE = (E) tempStack.peek();
        while (!tempStack.isEmpty()){
            E e = (E) tempStack.pop();
            stack.push(e);
        }
        return frontE;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "stack=" + stack +
                '}';
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue();
        System.out.println("queue");
        System.out.println(queue);
        System.out.println("enqueue");
        queue.enqueue(1);
        System.out.println(queue);
        System.out.println("enqueue");
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println("enqueue");
        queue.enqueue(3);
        System.out.println(queue);
        System.out.println("dequeue");
        queue.dequeue();
        System.out.println(queue);
        System.out.println("getFront");
        Integer frontE = queue.getFront();
        System.out.println("front e is " + frontE);
        System.out.println(queue);

        /*
        queue
        MyQueue{stack=[]}
        enqueue
        MyQueue{stack=[1]}
        enqueue
        MyQueue{stack=[1, 2]}
        enqueue
        MyQueue{stack=[1, 2, 3]}
        dequeue
        MyQueue{stack=[2, 3]}
        getFront
        front e is 2
        MyQueue{stack=[2, 3]}
        */

    }
}
