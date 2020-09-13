package com.company.f_Loop_Queue_Without_Size_Member;

public interface Queue<E> {
    
    int getSize();
    
    boolean isEmpty();
    
    void enqueue(E e);
    
    E dequeue();
    
    E getFront();
}
