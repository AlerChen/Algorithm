package j_Recursive_Linked_List;


import javafx.util.Pair;

/**
 *  作业更改: 使用递归实现链表的基本操作函数
 *  老师解法
 *  (链表实际操作中不存在,仅作练习使用)
 * */
public class LinkedListR <E>{

    /** Private Class Node */
    private class Node <E> {

        /** Property */
        public E e;
        public Node next;

        /** Life Circle */
        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /** Property */
    private Node head;
    private int size;

    /** Life Circle */
    public LinkedListR(){
        head = null;
        size = 0;
    }

    /** Public Method */

    /** Add Method */

    public void addFirst(E e){
        add(e,0);
    }

    public void addLast(E e){
        add(e,size);
    }

    public void add(E e, int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed, illegal index");
        }
        head = add(head,e,index);
        size++;
    }

    private Node add(Node head, E e, int index){
        if (index == 0){
            return new Node(e,head);
        }
        head.next = add(head.next,e,index-1);
        return head;
    }

    /** Remove Method */

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed, illegal index");
        }
        Pair<Node,E> res = remove(head,index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node,E> remove(Node head,int index){
        if (index == 0){
            return new Pair (head.next,head.e);
        }
        Pair<Node,E> res = remove(head.next,index - 1);
        head.next = res.getKey();
        return new Pair (head,res.getValue());
    }

    /** Set Method */

    public void setFirst(E e){
        set(e,0);
    }

    public void setLast(E e){
        set(e,size-1);
    }

    public void set(E e, int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("set failed, illegal index");
        }
        set(head,e,index);
    }

    private void set(Node head, E e, int index){
        if (index == 0){
            head.e = e;
            return;
        }
        set(head.next,e,index-1);
    }

    /** Get Method */

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get element failed, illegal index");
        }
        return get(head,index);
    }

    private E get(Node head, int index){
        if (index == 0){
            return (E) head.e;
        }
        return (E) get(head.next,index-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("front ");
        Node curNode = head;
        while (curNode != null){
            res.append(curNode + " -> ");
            curNode = curNode.next;
        }
        res.append("null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        //testAdd();
        //testRemove();
        //testSet();
        //testGet();
    }

    public static void testGet() {
        LinkedListR<Integer> linkedListR = new LinkedListR();
        for (Integer i = 0; i < 6; i++) {
            linkedListR.addLast(i);
        }
        System.out.println("Origin recursive linked list");
        System.out.println(linkedListR);

        System.out.println("getFirst");
        Integer firstE = linkedListR.getFirst();
        System.out.println("The first element is " + firstE);

        System.out.println("getLast");
        Integer lastE = linkedListR.getLast();
        System.out.println("The last element is " + lastE);

        System.out.println("get element at index 2");
        Integer thirdE = linkedListR.get(2);
        System.out.println("The third element is " + thirdE);
        /**
         Origin recursive linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null tail
         getFirst
         The first element is 0
         getLast
         The last element is 5
         get element at index 2
         The third element is 2
         */
    }

        public static void testSet(){
        LinkedListR linkedListR = new LinkedListR();
        for (Integer i = 0; i < 7; i++) {
            linkedListR.addLast(i);
        }
        System.out.println("Origin recursive linked list");
        System.out.println(linkedListR);

        System.out.println("setFirst");
        linkedListR.setFirst(11);
        System.out.println(linkedListR);

        System.out.println("setLast");
        linkedListR.setLast(99);
        System.out.println(linkedListR);

        System.out.println("set element at index 2");
        linkedListR.set(233,2);
        System.out.println(linkedListR);

        /**
         Origin recursive linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         setFirst
         front 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         setLast
         front 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 99 -> null tail
         set element at index 2
         front 11 -> 1 -> 233 -> 3 -> 4 -> 5 -> 99 -> null tail
         */
    }

    public static void testRemove(){
        LinkedListR linkedListR = new LinkedListR();
        for (Integer i = 0; i < 7; i++) {
            linkedListR.addLast(i);
        }
        System.out.println("Origin recursive linked list");
        System.out.println(linkedListR);

        System.out.println("removeLast");
        linkedListR.removeLast();
        System.out.println(linkedListR);

        System.out.println("removeLast");
        linkedListR.removeLast();
        System.out.println(linkedListR);

        System.out.println("removeFirst");
        linkedListR.removeFirst();
        System.out.println(linkedListR);

        System.out.println("remove element at index 2");
        linkedListR.remove(2);
        System.out.println(linkedListR);

        /**
         Origin recursive linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         removeLast
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null tail
         removeLast
         front 0 -> 1 -> 2 -> 3 -> 4 -> null tail
         removeFirst
         front 1 -> 2 -> 3 -> 4 -> null tail
         remove element at index 2
         front 1 -> 2 -> 4 -> null tail
         */
    }

    public static void testAdd(){
        LinkedListR linkedListR = new LinkedListR();
        System.out.println(linkedListR);
        System.out.println("addLast");
        linkedListR.addLast(1);
        System.out.println(linkedListR);
        System.out.println("addLast");
        linkedListR.addLast(2);
        System.out.println(linkedListR);
        System.out.println("addLast");
        linkedListR.addLast(3);
        System.out.println(linkedListR);
        System.out.println("addLast");
        linkedListR.addLast(4);
        System.out.println(linkedListR);
        System.out.println("addFirst");
        linkedListR.addFirst(-1);
        System.out.println(linkedListR);
        System.out.println("add element at index 2");
        linkedListR.add(22,2);
        System.out.println(linkedListR);

        /**
         front null tail
         addLast
         front 1 -> null tail
         addLast
         front 1 -> 2 -> null tail
         addLast
         front 1 -> 2 -> 3 -> null tail
         addLast
         front 1 -> 2 -> 3 -> 4 -> null tail
         addFirst
         front -1 -> 1 -> 2 -> 3 -> 4 -> null tail
         add element at index 2
         front -1 -> 1 -> 22 -> 2 -> 3 -> 4 -> null tail
         */
    }

}
