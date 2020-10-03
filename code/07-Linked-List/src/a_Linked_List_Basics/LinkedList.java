package a_Linked_List_Basics;

/*
* 链表_基础_Node
* */
public class LinkedList <E>{

    /** Node */
    /*
    * 内部节点,仅供内部使用
    * */
    class Node {

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



}
