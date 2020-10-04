package i_L203_Remove_Elements_In_Linked_List;

/**
 *  L203: remove elements in linked list
 *  optimize code
 * */
public class Solution_02 {

    public ListNode removeElements(ListNode head, int val) {

        // 处理从头节点值相等的情况
        while (head != null && head.val == val){
            // 直接赋值节点,系统回收无用节点
            head = head.next;
        }
        // 头结点为空情况
        if (head == null){
            return null;
        }
        // 处理中间节点值相等情况
        ListNode preNode = head;
        while (preNode.next != null){
            if (preNode.next.val == val){
                // 直接赋值,系统回收无用节点
                preNode.next = preNode.next.next;
            }else {
                preNode = preNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_02 solution_02 = new Solution_02();
        int[] arr = {1,2,3,6,5,6,7,8};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        solution_02.removeElements(head,6);
        System.out.println(head);
        /*
        1 -> 2 -> 3 -> 6 -> 5 -> 6 -> 7 -> 8 -> null
        1 -> 2 -> 3 -> 5 -> 7 -> 8 -> null
        */
    }
}
