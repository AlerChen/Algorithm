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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        Solution_01 solution_01 = new Solution_01();
        ListNode reverseHead = solution_01.reverseLinkedList(head);
        System.out.println(reverseHead);

        /**
         Origin Linked List
         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         Reverse Linked List
         7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
         */
    }
}
