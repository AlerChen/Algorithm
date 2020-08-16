package com.company.c_Array_Queue;

public class ArrayQueue <E> implements Queue <E>{

    /* Property */
    private Array array;

    /* Life Method */
    public ArrayQueue(int capacity){
        array = new Array(capacity);
    }

    public ArrayQueue(){
        array = new Array();
    }

    /* Interface */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E getFront() {
        return (E) array.getFirst();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return (E) array.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayQueue \n");
        res.append("front [ ");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append(" ] tail");
        return res.toString();
    }
}
