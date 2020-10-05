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

    public ListNode reverseLinkedList(ListNode head){
        pre = null;
        cur = head;
        next = head.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        Solution_01 solution_01 = new Solution_01();
        ListNode reverseHead = solution_01.reverseLinkedList(head);
        System.out.println(reverseHead);
    }
}
