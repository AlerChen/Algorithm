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
        if (front == null) {
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

}
