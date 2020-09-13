package com.company.e_Loop_Queue_Without_One_Space;

public interface Queue<E> {
    
    int getSize();
    
    boolean isEmpty();
    
    void enqueue(E e);
    
    E dequeue();
    
    E getFront();
}
