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
                res += mid - i + 1;
                arr[k] = aux[j - l];
                j++;
            }
        }
        return res;
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
