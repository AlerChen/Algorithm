package com.company.a_Array_Stack;

public interface Stack <E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
