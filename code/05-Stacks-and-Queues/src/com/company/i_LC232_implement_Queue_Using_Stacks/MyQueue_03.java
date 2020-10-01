package com.company.i_LC232_implement_Queue_Using_Stacks;
import java.util.Stack;


/*
* 作业优化: 使用栈实现队列: enqueue O(1), dequeue O(n),均摊复杂度 O(1), getFront O(1).
* */
public class MyQueue_03 <E>{

    /** Property  */
    private Stack stack1;
    private Stack stack2;
    private E front;

    /** Life Circle */
    public MyQueue_03(){
        stack1 = new Stack();
        stack2 = new Stack();
        front = null;
    }

    /** Public Method */

    /*
    * enqueue O(1)
    * */
    public void enqueue(E e){
        stack1.push(e);
        //if (front == null) {
        //    front = e;
        //}
        // 防止pop空之后,不能维护front元素.
        if (stack1.isEmpty()){
            front = e;
        }
    }

    /*
    * dequeue O(n) 均摊复杂度 O(1)
    * */
    public E dequeue(){
        // 辅助栈不为空, 则pop出栈顶元素
        if (!stack2.isEmpty()){
            return (E) stack2.pop();
        }
        // 辅助栈为空, 原栈元素倒入辅助栈
        while (stack1.size() > 1){
            stack2.push(stack1.pop());
        }
        return (E) stack1.pop();
    }

    /*
    * getFront O(1)
    *  */
    public E getFront(){
        if (!stack2.isEmpty()){
            return (E) stack2.peek();
        }
        return front;
    }

    /*
    * isEmpty O(1)
    * */
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue_03{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                ", front=" + front +
                '}';
    }

    public static void main(String[] args) {
        MyQueue_03<Integer> queue = new MyQueue_03();
        System.out.println("MyQueue_03");
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

        MyQueue_03
        MyQueue_03{stack1=[], stack2=[], front=null}
        enqueue
        MyQueue_03{stack1=[1], stack2=[], front=null}
        enqueue
        MyQueue_03{stack1=[1, 2], stack2=[], front=null}
        enqueue
        MyQueue_03{stack1=[1, 2, 3], stack2=[], front=null}
        enqueue
        MyQueue_03{stack1=[1, 2, 3, 4], stack2=[], front=null}
        dequeue
        MyQueue_03{stack1=[], stack2=[4, 3, 2], front=null}
        enqueue
        MyQueue_03{stack1=[5], stack2=[4, 3, 2], front=null}
        getFront
        MyQueue_03{stack1=[5], stack2=[4, 3, 2], front=null}
        front element is 2

        */
    }
}
