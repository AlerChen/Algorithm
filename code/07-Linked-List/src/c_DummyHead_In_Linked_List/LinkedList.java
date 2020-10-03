package c_DummyHead_In_Linked_List;

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
            if (e == null){
                return "null";
            }
            return e.toString();
        }
    }

    /** Property */
    private Node dummyHead; //虚拟头结点,不储存数据,为逻辑统一,方便统一添加操作.
    private int size;

    /** Life Circle */
    public LinkedList(){
        dummyHead = new Node();
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
        add(e,0);
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(E e, int index){
        // check
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add filed. Illegal index");
        }
        // 统一逻辑
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++)
            preNode = preNode.next;
        preNode.next = new Node(e,preNode.next);
        size++;
    }

    public void addLast(E e){
        add(e,size);
    }

    public void printSelf(){
        if (size == 0) return;
        Node curNode = dummyHead.next;
        System.out.print("dummyHead -> ");
        for (int i = 0; i < size; i++) {
            if (i != size-1){
                System.out.print(curNode + " -> ");
                curNode = curNode.next;
            }else {
                System.out.print(curNode + " -> null ");
            }
        }
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "dummyHead=" + dummyHead +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        System.out.println("LinkedList");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.addFirst(1);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.addFirst(2);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.add(66,1);
        System.out.println("add 66 at index 1");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.addFirst(3);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.add(99,1);
        System.out.println("add 99 at index 1");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.addFirst(4);
        System.out.println("addFirst");
        System.out.println(linkedList);
        linkedList.printSelf();
        linkedList.addLast(-1);
        System.out.println("addLast");
        System.out.println(linkedList);
        linkedList.printSelf();

        /*

        LinkedList
        LinkedList{dummyHead=null, size=0}
        addFirst
        LinkedList{dummyHead=null, size=1}
        dummyHead -> 1 -> null
        addFirst
        LinkedList{dummyHead=null, size=2}
        dummyHead -> 2 -> 1 -> null  
        add 66 at index 1
        LinkedList{dummyHead=null, size=3}
        dummyHead -> 2 -> 66 -> 1 -> null
        addFirst
        LinkedList{dummyHead=null, size=4}
        dummyHead -> 3 -> 2 -> 66 -> 1 -> null
        add 99 at index 1
        LinkedList{dummyHead=null, size=5}
        dummyHead -> 3 -> 99 -> 2 -> 66 -> 1 -> null
        addFirst
        LinkedList{dummyHead=null, size=6}
        dummyHead -> 4 -> 3 -> 99 -> 2 -> 66 -> 1 -> null
        addLast
        LinkedList{dummyHead=null, size=7}
        dummyHead -> 4 -> 3 -> 99 -> 2 -> 66 -> 1 -> -1 -> null

        */
    }
}

















