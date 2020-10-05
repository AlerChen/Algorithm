package j_Recursive_Linked_List;


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

    /** Public Method */

    /** Add Method */

    public void addFirst(E e){
        add(e,0);
    }

    public void addLast(E e){
        add(e,size-1);
    }

    public void add(E e, int index){
        if (index < 0 ){
            throw new IllegalArgumentException("add failed, illegal index");
        }
        head = add(head,e,index);
    }

    private Node add(Node head, E e, int index){
        if (index == 0){
            return new Node(e,head.next);
        }
        head.next = add(head.next,e,index-1);
        return head;
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
    }

    public static void testAdd(){
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList);
        System.out.println("addLast");
        linkedList.addLast(1);
        System.out.println(linkedList);
        System.out.println("addLast");
        linkedList.addLast(2);
        System.out.println(linkedList);
        System.out.println("addLast");
        linkedList.addLast(3);
        System.out.println(linkedList);
        System.out.println("addLast");
        linkedList.addLast(4);
        System.out.println(linkedList);
        System.out.println("addFirst");
        linkedList.addFirst(-1);
        System.out.println(linkedList);
        System.out.println("add element at index 2");
        linkedList.add(22,2);
        System.out.println(linkedList);

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
