package j_Recursive_Linked_List;

/**
 * 作业: 使用递归实现链表的基本操作函数
 * (链表实际操作中不存在,仅作练习使用)
 * */
public class LinkedList <E>{

    /** Private Class */
    private class Node <E>{

        /** Private Property */
        public E e;
        public Node next;

        /** Life Circle */
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        /**
        * create head node with array.
        * */
        public Node(E[] arr){
            if (arr == null || arr.length == 0){
                throw new IllegalArgumentException("can not create illegal ");
            }
            Node curNode = this;
            for (int i = 1; i < arr.length; i++) {
                curNode.next = new Node(arr[i]);
                curNode = curNode.next;
            }
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /** Property */
    private Node dummyHead;
    private int size;

    /** Life Circle */
    public LinkedList(){
        dummyHead = new Node(-1);
        size = 0;
    }

    /** Public Method */

    /** Add Method */

    /**
     * add first
     * */
    public void addFirst(E e){
        add(e,0);
    }

    /**
     * add last
     * */
    public void addLast(E e){
        add(e,size);
    }

    /**
     * add element at index n
     * */
    public void add(E e, int index){
        if (index < 0){
            throw new IllegalArgumentException("add filed, illegal index");
        }
        dummyHead = add(dummyHead,e,-1,index);
        size++;
    }

    /**
     * private : add recursive method
     * */
    private Node add(Node head, E e ,int curIndex, int targetIndex){
        if (curIndex + 1 == targetIndex){
            head.next = new Node(e,head.next);
            return head;
        }
        head.next = add(head.next,e,curIndex+1,targetIndex);
        return head;
    }

    /** Remove Method */

    /**
     * remove first
     * */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * remove last
     * */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * remove element at index n
     * */
    public E remove(int index){
        if (index < 0 || index > size - 1){
            throw new IllegalArgumentException("remove failed, illegal index");
        }
        E rmE = remove(dummyHead,-1,index);
        size--;
        return rmE;
    }

    /**
     * private : remove recursive method
     * */
    private E remove(Node head,int curIndex,int targetIndex){
        if (curIndex + 1 == targetIndex){
            E rmE = (E) head.next.e;
            head.next = head.next.next;
            return rmE;
        }
        E rmE = (E) remove(head.next,curIndex + 1,targetIndex);
        return rmE;
    }

    /** Set Method */

    /**
     * set first
     * */
    public void setFirst(E e){
        set(e,0);
    }

    /**
     * set last
     * */
    public void setLast(E e){
        set(e,size-1);
    }

    /**
     * set element at index n
     * */
    public void set(E e, int index){
        if (index < 0 || index > size -1 ){
            throw new IllegalArgumentException("set failed, illegal index");
        }
        set(dummyHead.next,e,0,index);
    }

    /**
     * private : set recursive method
     * */
    private void set(Node head, E e, int curIndex, int targetIndex){
        if (curIndex == targetIndex){
            head.e = e;
            return;
        }
        set(head.next,e,curIndex + 1, targetIndex);
    }

    /** Get Method */

    /**
     * get first
     * */
    public E getFirst(){
        return get(0);
    }

    /**
     * get last
     * */
    public E getLast(){
        return get(size-1);
    }

    /**
     * get element at index n
     * */
    public E get(int index){
        if (index < 0 || index > size -1){
            throw new IllegalArgumentException("get element failed, illegal index");
        }
        E getE = (E) get(dummyHead.next,0,index);
        return getE;
    }

    /**
     * private : get recursive method
     * */
    private E get(Node head, int curIndex, int targetIndex){
        if (curIndex == targetIndex){
            return (E) head.e;
        }
        E getE = (E) get(head.next,curIndex + 1, targetIndex);
        return getE;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("front ");
        for (Node curNode = dummyHead.next; curNode != null; curNode = curNode.next) {
            res.append(curNode + " -> ");
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

    public static void testGet(){
        LinkedList<Integer> linkedList = new LinkedList();
        for (Integer i = 0; i < 7; i++) {
            linkedList.addLast(i);
        }
        System.out.println("origin linked list");
        System.out.println(linkedList);

        System.out.println("get first");
        Integer firstE = linkedList.getFirst();
        System.out.println("The first element is " + firstE);

        System.out.println("get last");
        Integer lastE = linkedList.getLast();
        System.out.println("The last element is " + lastE);

        System.out.println("get element at index 2");
        Integer thirdE = linkedList.get(2);
        System.out.println("The third element is " + thirdE);

        /**
         origin linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         get first
         The first element is 0
         get last
         The last element is 6
         get element at index 2
         The third element is 2
         */
    }

    public static void testSet(){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 7; i++) {
            linkedList.addLast(i);
        }
        System.out.println("origin linked list");
        System.out.println(linkedList);

        System.out.println("set first");
        linkedList.setFirst(11);
        System.out.println(linkedList);

        System.out.println("set last");
        linkedList.setLast(99);
        System.out.println(linkedList);

        System.out.println("set element at index 3");
        linkedList.set(233,3);
        System.out.println(linkedList);

        /**
         origin linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         set first
         front 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         set last
         front 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 99 -> null tail
         set element at index 3
         front 11 -> 1 -> 2 -> 233 -> 4 -> 5 -> 99 -> null tail
         */
    }

    public static void testRemove(){

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 7; i++) {
            linkedList.addLast(i);
        }
        System.out.println("origin linked list");
        System.out.println(linkedList);

        System.out.println("removeFirst");
        linkedList.removeFirst();
        System.out.println(linkedList);

        System.out.println("removeLast");
        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println("remove element at index 2");
        linkedList.remove(2);
        System.out.println(linkedList);

        System.out.println("removeLast");
        linkedList.removeLast();
        System.out.println(linkedList);

        /**
         origin linked list
         front 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         removeFirst
         front 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null tail
         removeLast
         front 1 -> 2 -> 3 -> 4 -> 5 -> null tail
         remove element at index 2
         front 1 -> 2 -> 4 -> 5 -> null tail
         removeLast
         front 1 -> 2 -> 4 -> null tail
         */

    }

    /**
      * add method
      */
    public static void testAdd(){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 7; i++) {
            if (i == 1 || i == 3 || i == 5){
                System.out.println("addFirst");
                linkedList.addFirst(i);
            }else if (i == 0 || i == 2 || i == 4) {
                System.out.println("addLast");
                linkedList.addLast(i);
            } else {
                System.out.println("add index at 2");
                linkedList.add(99,2);
            }
            System.out.println(linkedList);
        }

        /**
         addLast
         front 0 -> null tail
         addFirst
         front 1 -> 0 -> null tail
         addLast
         front 1 -> 0 -> 2 -> null tail
         addFirst
         front 3 -> 1 -> 0 -> 2 -> null tail
         addLast
         front 3 -> 1 -> 0 -> 2 -> 4 -> null tail
         addFirst
         front 5 -> 3 -> 1 -> 0 -> 2 -> 4 -> null tail
         add index at 2
         front 5 -> 3 -> 99 -> 1 -> 0 -> 2 -> 4 -> null tail
         */
    }




}
