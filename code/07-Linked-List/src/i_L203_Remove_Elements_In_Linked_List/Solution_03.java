package i_L203_Remove_Elements_In_Linked_List;


/**
 *  L203: remove elements in linked list using dummyHead
 *  use DummyHead : 优势: 统一删除逻辑
 * */
public class Solution_03 {

    /** Property */
    ListNode dummyHead;

    public ListNode removeElements(ListNode head, int val) {
        // define dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // search from dummyHead
        ListNode preNode = dummyHead;
        while (preNode.next != null){
            if (preNode.next.val == val){
                preNode.next = preNode.next.next;
            }else {
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution_03 solution_03 = new Solution_03();
        int[] arr = {1,2,3,6,5,6,7,8};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        solution_03.removeElements(head,6);
        System.out.println(head);

        /*
        1 -> 2 -> 3 -> 6 -> 5 -> 6 -> 7 -> 8 -> null
        1 -> 2 -> 3 -> 5 -> 7 -> 8 -> null
        */
    }
}
