package com.company.d_Loop_Queue;

public interface Queue<E> {
    
    int getSize();
    
    boolean isEmpty();
    
    void enqueue(E e);
    
    E dequeue();
    
    E getFront();
}
