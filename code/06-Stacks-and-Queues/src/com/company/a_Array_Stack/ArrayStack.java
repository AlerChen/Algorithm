package com.company.a_Array_Stack;

import com.sun.org.apache.xpath.internal.operations.String;

public class ArrayStack<E> implements Stack<E> {

    /* property */
    private Array<E> array;

    /* Life Method */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }

    /* Interface */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public java.lang.String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : ");
        res.append("[");
        for (int i = 0; i < this.getSize(); i++) {
            res.append(i);
            if (i != this.getSize() - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
    }

}
