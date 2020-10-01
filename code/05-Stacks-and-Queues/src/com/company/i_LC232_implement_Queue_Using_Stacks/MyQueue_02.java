package com.company.i_LC232_implement_Queue_Using_Stacks;


import java.util.Stack;

/*
* 作业优化: 使用栈实现队列, enqueue O(1), dequeue O(n), getFront O(1).
* 设计思路: 定义栈顶为队列尾, 入队即push.
*         出队时使用辅助栈push入原栈pop出的元素,再将辅助栈顶元素pop出,最后辅助栈内元素push回原栈即可.
*         getFront使用属性记录,入队和出队时维护即可.
* */
public class MyQueue_02 <E>{

    /** Property */
    private Stack stack;
    E front;

    /** Life Circle */
    public MyQueue_02() {
        stack = new Stack();
        front = null;
    }

    /** Public Method */
    /*
    * enqueue O(1)
    * */
    public void enqueue(E e){
        stack.push(e);
        if (front == null){
            front = e;
        }
    }

    /*
    * dequeue O(n)
    * */
    public E dequeue(){
        if (stack.isEmpty()){
            return null;
        }
        Stack tempStack = new Stack();
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        // 维护front元素
        E targetE = (E) tempStack.pop();
        front = (E) tempStack.peek();
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return targetE;
    }

    /*
    * getFront O(1)
    * */
    public E getFront(){
        return front;
    }

    /*
    * isEmpty O(1)
    * */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue_02{" +
                "stack=" + stack +
                ", front=" + front +
                '}';
    }

    public static void main(String[] args) {
        MyQueue_02<Integer> queue = new MyQueue_02();
        System.out.println("MyQueue_02");
        System.out.println(queue);
        queue.enqueue(1);
        System.out.println("enqueue");
        System.out.println(queue);
        queue.enqueue(2);
        System.out.println("enqueue");
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println("enqueue");
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println("enqueue");
        System.out.println(queue);
        queue.dequeue();
        System.out.println("dequeue");
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println("enqueue");
        System.out.println(queue);
        Integer front = queue.getFront();
        System.out.println("getFront");
        System.out.println(queue);
        System.out.println("front element is " + front);

        /*

        MyQueue_02
        MyQueue_02{stack=[], front=null}
        enqueue
        MyQueue_02{stack=[1], front=1}
        enqueue
        MyQueue_02{stack=[1, 2], front=1}
        enqueue
        MyQueue_02{stack=[1, 2, 3], front=1}
        enqueue
        MyQueue_02{stack=[1, 2, 3, 4], front=1}
        dequeue
        MyQueue_02{stack=[2, 3, 4], front=2}
        enqueue
        MyQueue_02{stack=[2, 3, 4, 5], front=2}
        getFront
        MyQueue_02{stack=[2, 3, 4, 5], front=2}
        front element is 2

        */
    }
}
