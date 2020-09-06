package com.company;

import com.company.a_Array_Stack.ArrayStack;
import com.company.b_A_Stack_Problem_in_Leetcode.Solution;
import com.company.c_Array_Queue.ArrayQueue;

public class Main {

    public static void main(String[] args) {
        //testForArrayStack();
        //testForSolution();
        testForArrayQueue();
    }

    public static void testForArrayQueue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2 ) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }

    public static void testForArrayStack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }

    public static void testForSolution(){
        String str = "([{}])";
        boolean res = Solution.isValid(str);
        System.out.println(str + " " + res );
        /*
        ()[]{} true
        ()[]{}) false
        }()[]{} false
        ([{}]) true
        2([{}])
        */
    }




}
