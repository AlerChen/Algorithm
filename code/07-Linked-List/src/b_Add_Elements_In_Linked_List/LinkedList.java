package b_Add_Elements_In_Linked_List;

/*
* 链表
* */
public class LinkedList<E>{

    /** Node */
    /*
    * 内部节点,仅供内部使用
    * */
    private class Node{

        /** Property */

        public E e; // 节点数据
        public Node next; // 下个节点引用

        /** Life Circle */

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
    private Node head;
    private int size;

    /** Life Circle */
    public LinkedList(){
        head = null;
        size = 0;
    }

    /** Public Method */
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        // Node newNode = new Node(e);
        // newNode.next = head;
        // head = newNode;
        // size++;

        // optimize
        head = new Node(e,head);
        size++;
        // fix: 头结点不需要连接head.next节点
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(E e, int index){
        // check
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add filed. Illegal index");
        }
        if (index == 0){
            addFirst(e);
        }else {
            Node preNode = head;
            for (int i = 0; i < index; i++)
                preNode = preNode.next;

            // Node newNode = new Node(e);
            // newNode.next = preNode.next;
            // size++;

            // optimize code
            preNode.next = new Node(e,preNode.next);
            size++;
        }
    }

    public void addLast(E e){
        add(e,size-1);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        System.out.println("LinkedList");
        System.out.println(linkedList);
        linkedList.addFirst(1);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.addFirst(2);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.addFirst(3);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.addFirst(4);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.addFirst(5);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.add(99,1);
        System.out.println("add 99 at index 1");
        System.out.println(linkedList);
        linkedList.addFirst(6);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.addLast(-1);
        System.out.println("addLast");
        System.out.println(linkedList);

        /*

        LinkedList
        LinkedList{head=null, size=0}
        addFirst
        LinkedList{head=1, size=1}
        addFirst
        LinkedList{head=2, size=2}
        addFirst
        LinkedList{head=3, size=3}
        addFirst
        LinkedList{head=4, size=4}
        addFirst
        LinkedList{head=5, size=5}
        add 99 at index 1
        LinkedList{head=5, size=6}
        addFirst
        LinkedList{head=6, size=7}
        addLast
        LinkedList{head=6, size=8}

        */
    }
}

















