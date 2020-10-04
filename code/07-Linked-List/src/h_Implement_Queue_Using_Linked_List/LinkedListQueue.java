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
     * 老师解法
     * */
    @Override
    public void enqueue(E e){
        if (tail == null){
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    /**
     * enqueue O(1)
     * 个人解法
     * */
    //    @Override
    //    public void enqueue(E e) {
    //        if (isEmpty()){
    //            Node newNode = new Node(e);
    //            head = newNode;
    //            tail = newNode;
    //            size++;
    //            return;
    //        }
    //        Node newNode = new Node(e);
    //        tail.next = newNode;
    //        tail = newNode;
    //        size++;
    //    }

    /**
     * dequeue O(1)
     * 老师解法
     * */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("dequeue failed. the queue is empty");
        }
        Node rmNode = head;
        head = head.next;
        rmNode.next = null;//清除引用
        size--;
        // 维护队列空情况
        if (head == null){
            tail = null;
        }
        return (E) rmNode.e;
    }

    /**
     * dequeue O(1)
     * 个人解法
     * */
    //    @Override
    //    public E dequeue() {
    //        if (head == null) return null;
    //        Node rmNode = head;
    //        head = head.next;
    //        size--;
    //        return (E) rmNode.e;
    //    }

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
        return size == 0;
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
        sb.append("Queue: front ");
        Node curNode = head;
        while (curNode != null){
            sb.append(curNode);
            sb.append(" -> ");
            curNode = curNode.next;
        }
        sb.append("null tail");
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
         Queue: front 0 -> null tail
         enqueue
         Queue: front 0 -> 1 -> null tail
         enqueue
         Queue: front 0 -> 1 -> 2 -> null tail
         dequeue
         Queue: front 1 -> 2 -> null tail
         enqueue
         Queue: front 1 -> 2 -> 4 -> null tail
         enqueue
         Queue: front 1 -> 2 -> 4 -> 5 -> null tail
         dequeue
         Queue: front 2 -> 4 -> 5 -> null tail
         isEmpty
         LinkedListQueue is empty ? false
         getSize
         LinkedListQueue size is 3

         */

    }
}
