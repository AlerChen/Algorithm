package k_L206_Reverse_Linked_List;

/**
* L206: Reverse Linked List
* */
public class Solution_01 {

    /** Property Method */
    private ListNode pre;
    private ListNode cur;
    private ListNode next;

    /** Life Circle */
    public Solution_01(){
        pre = null;
        cur = null;
        next = null;
    }

    //   根据老师思路解答错误
    //    public ListNode reverseLinkedList(ListNode head){
    //        pre = null;
    //        cur = head;
    //        next = head.next;
    //        while (cur != null){
    //            cur.next = pre;
    //            pre = cur;
    //            cur = next;
    //            next = cur.next;
    //        }
    //        return cur;
    //    }

    /**
     * 个人解题思路:
     *    1.保存旧链表next节点
     *      next = cur.next;
     *    2.使新链表头节点pre成为旧链表当前头节点的next节点 (翻转步骤)
     *      cur.next = pre;
     *    3.使当前节点成为新链表头节点
     *      pre = cur;
     *    4.使旧链表next节点成为旧链表头结点
     *      cur = next;
     *    5. -> 1. while(cur != null)
     * */
    public ListNode reverseLinkedList(ListNode head){
        cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
    * 2022-03-15
    * */
    public ListNode reverseLinkedList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //    /**
    //     * Reverse Linked List Using Recursive
    //     * 解题失败
    //     * */
    //    public ListNode reverseLinkedListUsingRecursive(ListNode head){
    //        if (head.next == null){
    //            return head;
    //        }
    //        ListNode preNode = reverseLinkedListUsingRecursive(head.next);
    //        head.next = null;
    //        preNode.next = head;
    //        return head;
    //    }

    /**
     * Reverse Linked List Using Recursive
     * 老师解法: 先返回头结点, 后翻转
     * */
    public ListNode reverseLinkedListUsingRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode preNode = reverseLinkedListUsingRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return preNode;
    }

    /**
     * Reverse Linked List By Recursive
     * 个人解法: 先翻转,后返回新头结点
     * */
    public ListNode reverseLinkedListByRecursive(ListNode head){
        if (head == null){
            return pre;
        }
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
        return reverseLinkedListByRecursive(head);
    }

    /**
     * 递归反转列表
     * 2022-03-15
    * */
    public ListNode reverseLinkedListByRecursive2(ListNode head){
        // head == null 防止传入空头结点
        // head.next == null 用于定位尾结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseLinkedListByRecursive2(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        /** 翻转链表 */
        testReverseLinkedList();
        System.out.println("------------------------------");
        /** 翻转链表_递归_先翻转,再返回新头结点 */
        testReverseLinkedListByRecursive();
        System.out.println("------------------------------");
        /** 翻转链表_递归_老师解法_先返回头结点,再翻转 */
        testReverseLinkedListUsingRecursive();

        /**
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         ------------------------------
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List By Recursive
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         ------------------------------
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List Using Recursive
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         */
    }

    public static void testReverseLinkedList(){
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println("Origin Linked List");
        System.out.println(head);

        System.out.println("Reverse Linked List");
        Solution_01 solution_01 = new Solution_01();
        ListNode reverseHead = solution_01.reverseLinkedList(head);
        //ListNode reverseHead2 = solution_01.reverseLinkedList2(head);

        System.out.println(reverseHead);

        /**
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         */
    }

    public static void testReverseLinkedListByRecursive(){
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println("Origin Linked List");
        System.out.println(head);

        System.out.println("Reverse Linked List By Recursive");
        Solution_01 solution_01 = new Solution_01();
        ListNode reverseHead = solution_01.reverseLinkedListByRecursive(head);
        System.out.println(reverseHead);

        /**
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List By Recursive
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         */
    }

    public static void testReverseLinkedListUsingRecursive(){
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println("Origin Linked List");
        System.out.println(head);

        System.out.println("Reverse Linked List Using Recursive aler");
        Solution_01 solution_01 = new Solution_01();
        ListNode reverseHead = solution_01.reverseLinkedListUsingRecursive(head);
        //ListNode reverseHead = solution_01.reverseLinkedListByRecursive2(head);

        System.out.println(reverseHead);

        /**
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List Using Recursive
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         */
    }
}
