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
