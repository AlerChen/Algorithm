package i_L203_Remove_Elements_In_Linked_List;

/**
 *  L203: remove elements in linked list
 *
* */
public class Solution_01 {

    public ListNode removeElements(ListNode head, int val){

        // 处理从头结点开始值相等的问题
        while (head != null && head.val == val){
            ListNode rmNode = head;
            head = rmNode.next;
            rmNode.next = null;
        }

        // 处理删除 值相等的头结点后 head为空问题
        if (head == null)
            return null;

        ListNode preNode = head;
        while (preNode.next != null){
            if (preNode.next.val == val){
                ListNode rmNode = preNode.next;
                preNode.next = rmNode.next;
                rmNode.next = null;
                // 不做preNode后移操作
            }else {
                preNode = preNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_01 solution_01 = new Solution_01();
        int[] arr = {1,2,3,6,5,6,7,8};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        solution_01.removeElements(head,6);
        System.out.println(head);
        /*
        1 -> 2 -> 3 -> 6 -> 5 -> 6 -> 7 -> 8 -> null
        1 -> 2 -> 3 -> 5 -> 7 -> 8 -> null
        */
    }

}
