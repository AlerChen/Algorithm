package a_BinarySearchBase;

import java.util.Random;

public class BinarySearch_selectK {


    public static void main(String[] args) {

        findKthLargest();
    }
    
    /**数组中的第k个最大的元素_非递归写法 */
    public static void findKthLargest(){
        int[] arr = {3,2,1,5,6,4};
        int res = findKthLargest(arr,2);
        System.out.println("findKthLargest res = " + res);
        /**
         findKthLargest res = 5
         */
    }

    private static int findKthLargest(int[] nums, int k) {
        int res = selectK(nums, 0, nums.length - 1, nums.length - k);
        return res;
    }

    private static int selectK(int[] arr, int l, int r, int k) {
        while (l <= r) {
            int p = partition(arr, l, r);
            if (p == k) {
                return arr[p];
            }
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int l, int r){

        int ran = l + new Random().nextInt(r - l) + 1;
        swap(arr, l, ran);
        int i = l + 1;
        int lt = l;
        int gt = r + 1;
        while(i < gt){
            if(arr[i] < arr[l]){
                lt ++;
                swap(arr,i,lt);
                i ++;
            }else if (arr[i] > arr[l]){
                gt --;
                swap(arr,i,gt);
            }else{
                i ++;
            }
        }
        swap(arr,l,lt);
        return lt;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
