package h_Implement_Queue_Using_Linked_List;

public interface Queue <E>{

    void enqueue(E e);
    E dequeue();
    E getFront();
    boolean isEmpty();
    int getSize();
}
