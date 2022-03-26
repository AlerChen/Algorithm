package j_Solution_Reverse_Pairs_By_MergeSort;

import java.util.Arrays;
/**
 * 逆序对问题: 优化_函数式编程
 * */
public class Solution_02 {

    static public int reversePairs(int[] nums) {
         return sort(nums,0,nums.length - 1);
    }

    static private int sort(int[] arr, int l, int r){
        if (l >= r){
            return 0;
        }
        int mid = (l + r) / 2;
        int lRes = sort(arr, l, mid);
        int rRes = sort(arr,mid + 1, r);
        int mRes = merge(arr,l,mid,r);
        return lRes + rRes + mRes;
    }

    static private int merge(int[] arr, int l, int mid, int r){
        int[] aux = Arrays.copyOf(arr,arr.length);
        int i = l;
        int j = mid + 1;
        int res = 0;
        for (int k = l; k <= r; k++){
            if (i > mid){
                arr[k] = aux[j];
                j++;
            }else if (j > r){
                arr[k] = aux[i];
                i++;
            }else if (aux[i] <= aux[j]){
                arr[k] = aux[i];
                i++;
            }else {
                // right, 较小的这边操作,此刻的左边,都是比右边的大,即逆序对数量.
                res += mid - i + 1;
                arr[k] = aux[j];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {7,5,6,1};
        int res = reversePairs(arr);
        System.out.println("res = " + res);
        /**
         res = 5
         Time Complexity : O(nlogn)
         */
    }
}
