package com.company;

import com.company.a_Array_Stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
        testForArrayStack();
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


}
