package g_Implement_Stack_Using_Linked_List;

public interface Stack <E>{

    void push(E e);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
