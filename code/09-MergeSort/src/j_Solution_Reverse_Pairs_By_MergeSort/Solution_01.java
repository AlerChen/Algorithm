package j_Solution_Reverse_Pairs_By_MergeSort;

import java.util.Arrays;

public class Solution_01 {

    /** Property */
    static private int result;

    static public int reversePairs(int[] nums) {
        sort(nums,0,nums.length - 1);
        return result;
    }

    static private void sort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr,mid + 1, r);
        merge(arr,l,mid,r);
    }

    static private void merge(int[] arr, int l, int mid, int r){
        int[] aux = Arrays.copyOf(arr,arr.length);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++){
            if (i > mid){
                arr[k] = aux[j - l];
                j++;
            }else if (j > r){
                arr[k] = aux[i - l];
                i++;
            }else if (arr[i - l] <= arr[j - l]){
                arr[k] = aux[i - l];
                i++;
            }else {
                // right, 较小的这边操作,此刻的左边,都是比右边的大,即逆序对数量.
                result += mid - i + 1;
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] num = {3,1,0};
        int res = reversePairs(num);
        System.out.println("res = " + res);
        /**
         res = 3
         Time Complexity : O(nlogn)
         */
    }

}
