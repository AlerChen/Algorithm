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
        testRemove();
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
