package k_L206_Reverse_Linked_List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}

    /**
     *  传入数组创建链表
     *  利用当前节点当做头结点组成链表
     * */
    ListNode(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("can not be create ListNode");
        }
        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null){
            res.append(curNode.val + " -> ");
            curNode = curNode.next;
        }
        res.append("null");
        return res.toString();
    }
}
