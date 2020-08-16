package com.company;

import com.company.a_Array_Stack.ArrayStack;
import com.company.b_A_Stack_Problem_in_Leetcode.Solution;

public class Main {

    public static void main(String[] args) {
        //testForArrayStack();
        testForSolution();
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
