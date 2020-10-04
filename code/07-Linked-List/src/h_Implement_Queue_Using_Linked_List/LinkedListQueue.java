package h_Implement_Queue_Using_Linked_List;

/**
 *  使用链表实现队列
 *  添加tail节点来实现队列
 *  head节点添加/删除元素容易
 *  tail节点添加元素容易,删除元素不容易(不能O(1)获取到pre Node)
 *  因此定义head节点为队列头(方便出队), tail节点为队列尾.
 * */
public class LinkedListQueue <E> implements Queue<E>{

    /** Private Class Node */
    private class Node <E> {

        /** Property */
        E e;
        Node next;

        /** Life Cirlce */
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /** Property */
    Node head; // 实现队列, 不需要对中间节点进行操作, 因此不需要虚拟头结点.
    Node tail;
    int size;

    /** Life Circle */
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    /** Interface Method */

    /**
     * enqueue O(1)
     * */
    @Override
    public void enqueue(E e) {
        if (isEmpty()){
            Node newNode = new Node(e);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        Node newNode = new Node(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * dequeue O(1)
     * */
    @Override
    public E dequeue() {
        if (head == null) return null;
        Node rmNode = head;
        head = head.next;
        size--;
        return (E) rmNode.e;
    }

    /**
     * getFront O(1)
     * */
    @Override
    public E getFront() {
        return (E) head.e;
    }

    /**
     * isEmpty O(1)
     * */
    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * getSize O(1)
     * */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Head [ ");
        Node curNode = head;
        while (curNode != null){
            sb.append(curNode);
            if (curNode.next != null){
                sb.append(" -> ");
            }
            curNode = curNode.next;
        }
        sb.append(" ] Tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        for (Integer i = 0; i < 7; i++) {
            if (i % 3 == 0 && i != 0){
                System.out.println("dequeue");
                linkedListQueue.dequeue();
            } else {
                System.out.println("enqueue");
                linkedListQueue.enqueue(i);
            }
            System.out.println(linkedListQueue);
        }

        System.out.println("isEmpty");
        boolean isEmpty = linkedListQueue.isEmpty();
        System.out.println("LinkedListQueue is empty ? " + isEmpty);

        System.out.println("getSize");
        int size = linkedListQueue.getSize();
        System.out.println("LinkedListQueue size is " + size);

        /**

         enqueue
         Head [ 0 ] Tail
         enqueue
         Head [ 0 -> 1 ] Tail
         enqueue
         Head [ 0 -> 1 -> 2 ] Tail
         dequeue
         Head [ 1 -> 2 ] Tail
         enqueue
         Head [ 1 -> 2 -> 4 ] Tail
         enqueue
         Head [ 1 -> 2 -> 4 -> 5 ] Tail
         dequeue
         Head [ 2 -> 4 -> 5 ] Tail
         isEmpty
         LinkedListQueue is empty ? false
         getSize
         LinkedListQueue size is 3

         */

    }
}
