package com.company.b_A_Stack_Problem_in_Leetcode;

import com.company.a_Array_Stack.Array;
import com.company.a_Array_Stack.ArrayStack;

public class Solution {
    /*
    Leetcode 括号匹配问题
        给定一个字符串，里边可能包含“()”、"{}"、“[]”三种括号，请编写程序检查该字符串的括号是否成对出现。
    输出：
    true：代表括号成对出现并且嵌套正确，或字符串无括号字符。
    false：未正确使用括号字符。

    */
    public static boolean isValid(String str){
        // check
        if (str.length() < 1) return false;
        char[] charArr = str.toCharArray();
        ArrayStack<Character> arrayStack = new ArrayStack();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (c == '(' || c == '[' || c == '{'){
                arrayStack.push(c);
            }else {
                if (arrayStack.isEmpty())
                    return false;
                char top = arrayStack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
            }
        }
        return arrayStack.isEmpty();
    }
}
