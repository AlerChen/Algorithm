package e_Remove_In_Linked_List;

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

    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get filed. illegal index");
        }
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(E e,int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get filed. illegal index");
        }
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.e = e;
    }

    public boolean contains(E e){
        Node curNode = dummyHead.next;
        while (curNode != null){
            if (curNode.e == e){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("remove filed. illegal index");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index ; i++) {
            preNode = preNode.next;
        }
        Node rmNode = preNode.next;
        preNode.next = rmNode.next;
        rmNode.next = null;
        size--;
        return rmNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E removeElement(E e){
        Node preNode = dummyHead;
        while (preNode.next != null){
            if (preNode.next.e.equals(e))
                break;
            preNode = preNode.next;
        }

        while (preNode.next != null){
            Node rmNode = preNode.next;
            preNode.next = rmNode.next;
            rmNode.next = null;
            return rmNode.e;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node curNode = dummyHead.next; curNode != null; curNode = curNode.next) {
            sb.append(curNode + "->");
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        System.out.println("LinkedList");
        System.out.println(linkedList);

        for (Integer i = 0; i < 15; i++) {
            if (i == 3){
                System.out.println("add 11 at index 1");
                linkedList.add(11,1);
            } else if ( i == 5){
                System.out.println("add 22 at index 2");
                linkedList.set(22,2);
            } else if ( i == 6){
                System.out.println("addLast");
                linkedList.addLast(-1);
            } else if ( i == 7){
                System.out.println("get index of 3 element");
                Integer e = linkedList.get(3);
                System.out.println("get element is " + e);
            } else if ( i == 8){
                System.out.println("get first");
                Integer e = linkedList.getFirst();
                System.out.println("get thr first element is " + e);
            } else if ( i == 9){
                System.out.println("get last");
                Integer e = linkedList.getLast();
                System.out.println("get thr last element is " + e);
            } else if ( i == 10){
                System.out.println("remove first");
                Integer e = linkedList.removeFirst();
            } else if ( i == 11){
                System.out.println("remove last");
                Integer e = linkedList.removeLast();
            } else if ( i == 12){
                System.out.println("remove element at index 2");
                Integer e = linkedList.remove(2);
            } else if ( i == 13){
                System.out.println("remove element of 0");
                Integer e = linkedList.removeElement(0);
            } else if ( i == 14){
                System.out.println("contains element of 22");
                boolean isContains = linkedList.contains(22);
                System.out.println("is contains 22 ?: " + isContains);
            }  else {
                System.out.println("addFirst");
                linkedList.addFirst(i);
            }
            // log linked list
            System.out.println(linkedList);
        }

        /*
        LinkedList
        null
        addFirst
        0->null
        addFirst
        1->0->null
        addFirst
        2->1->0->null
        add 11 at index 1
        2->11->1->0->null
        addFirst
        4->2->11->1->0->null
        add 22 at index 2
        4->2->22->1->0->null
        addLast
        4->2->22->1->0->-1->null
        get index of 3 element
        get element is 1
        4->2->22->1->0->-1->null
        get first
        get thr first element is 4
        4->2->22->1->0->-1->null
        get last
        get thr last element is -1
        4->2->22->1->0->-1->null
        remove first
        2->22->1->0->-1->null
        remove last
        2->22->1->0->null
        remove element at index 2
        2->22->0->null
        remove element of 0
        2->22->null
        contains element of 22
        is contains 22 ?: true
        2->22->null
        */
    }
}

















