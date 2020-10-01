package com.company.i_LC232_implement_Queue_Using_Stacks;
import java.util.Stack;


/*
* 作业优化: 使用队列实现栈, enqueue O(n), dequeue O(1), getFront O(1).
* 设计思路: 将栈顶定义为队列头, enqueue,getFront 等同于 pop,peek.
*         在enqueue时,将新元素插入栈顶即可.(使用辅助栈)
* */
public class MyQueue_01 <E>{

    /** Property */
    private Stack stack;

    /** Life Circle */
    public MyQueue_01(){
        stack = new Stack();
    }

    /** Public Method */
    /*
    * enqueue O(n)
    * */
    public void enqueue(E e){
        Stack tempStack = new Stack();
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        stack.push(e);
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    /*
    * dequeue O(1)
    * */
    public E dequeue(){
        return (E) stack.pop();
    }

    /*
    * getFront O(1)
    * */
    public E getFront(){
        return (E) stack.peek();
    }

    /*
    * isEmpty O(1)
    * */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue_01{" +
                "stack=" + stack +
                '}';
    }

    public static void main(String[] args) {

        MyQueue_01<Integer> queue = new MyQueue_01();
        System.out.println("MyQueue_01");
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
    }

}
