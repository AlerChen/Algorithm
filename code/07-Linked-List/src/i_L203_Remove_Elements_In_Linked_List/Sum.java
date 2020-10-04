package i_L203_Remove_Elements_In_Linked_List;

public class Sum {

    public int sum(int[] arr){
        int res = sum(arr,0);
        return res;
    }

    private int sum(int[] arr, int left){
        if (left == arr.length -1)
            return arr[left];
        int res = sum(arr,left+1);
        return arr[left] + res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int res = (new Sum()).sum(arr);
        System.out.println("result is " + res);
        /**
        result is 36
        */
    }
}
