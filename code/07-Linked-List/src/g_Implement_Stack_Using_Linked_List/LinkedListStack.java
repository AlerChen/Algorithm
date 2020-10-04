package g_Implement_Stack_Using_Linked_List;

public class LinkedListStack<E> implements Stack<E>{

    /** Property */
    LinkedList<E> linkedList;

    /** Life Circle */
    public LinkedListStack(){
        linkedList = new LinkedList();
    }

    /** Interface Method */
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "linkedList=" + linkedList +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack();
        for (Integer i = 0; i < 5; i++) {
            System.out.println("push");
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        System.out.println("pop");
        linkedListStack.pop();
        System.out.println(linkedListStack);

        System.out.println("peek");
        Integer peekE = linkedListStack.peek();
        System.out.println(linkedListStack);
        System.out.println("top element is " + peekE);

        System.out.println("isEmpty");
        boolean isEmpty = linkedListStack.isEmpty();
        System.out.println(linkedListStack);
        System.out.println("isEmpty ? " + isEmpty);

        System.out.println("size");
        int size = linkedListStack.size();
        System.out.println(linkedListStack);
        System.out.println("size is " + size);

        /**
        push
        LinkedListStack{linkedList=0->null}
        push
        LinkedListStack{linkedList=1->0->null}
        push
        LinkedListStack{linkedList=2->1->0->null}
        push
        LinkedListStack{linkedList=3->2->1->0->null}
        push
        LinkedListStack{linkedList=4->3->2->1->0->null}
        pop
        LinkedListStack{linkedList=3->2->1->0->null}
        peek
        LinkedListStack{linkedList=3->2->1->0->null}
        top element is 3
        isEmpty
        LinkedListStack{linkedList=3->2->1->0->null}
        isEmpty ? false
        size
        LinkedListStack{linkedList=3->2->1->0->null}
        size is 4
        */
    }
}
