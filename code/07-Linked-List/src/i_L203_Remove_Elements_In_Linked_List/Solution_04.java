package i_L203_Remove_Elements_In_Linked_List;

/**
 * L203: remove elements in linked list
 * by recursive
 * 通过递归解决删除链表中元素的问题
 * */
public class Solution_04 {

    //    public ListNode removeElements(ListNode head, int val) {
    //
    //        if (head == null)
    //            return null;
    //
    //        ListNode res = removeElements(head.next,val);
    //        if (head.val == val){
    //            return res;
    //        }else {
    //            // 重新接上后续节点
    //            head.next = res;
    //            return head;
    //        }
    //    }

    /**
     * 代码优化
     * */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        Solution_04 solution_04 = new Solution_04();
        int[] arr = {1,2,3,6,5,6,7,8};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        solution_04.removeElements(head,6);
        System.out.println(head);

        /*
        recursive
        1 -> 2 -> 3 -> 6 -> 5 -> 6 -> 7 -> 8 -> null
        1 -> 2 -> 3 -> 5 -> 7 -> 8 -> null
        */
    }

}
