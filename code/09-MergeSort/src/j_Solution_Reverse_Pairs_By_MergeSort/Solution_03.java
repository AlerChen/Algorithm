package j_Solution_Reverse_Pairs_By_MergeSort;

import java.util.Arrays;

public class Solution_03 {

    static int cnt = 0;

    /**
     * 求逆序对
     * 2022-0326
     * O(nlogn)
     * */
    public static int reversePairs(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length - 1, temp);
        return cnt;
    }

    private static void sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr,mid + 1, r, temp);
        merge(arr,l, mid, r, temp);
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp){
        //int[] arrOri = Arrays.copyOfRange(arr,l,r + 1); // 前闭后开，to指向的不包含的index 需要偏移
        //int[] arrOri = Arrays.copyOf(arr,arr.length); // 整个数组的下标，不需要偏移
        System.arraycopy(arr, l, temp, l,r - l + 1); // 只拷贝使用部分，不需要偏移

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if ( j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else  {
                // 计算逆序对
                cnt += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 暴力破解 O(n^2)
     * */
    public static int test(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

        int[] arr = {7,5,6,1};
        int res = reversePairs(arr);
        System.out.println("归并排序: 逆序对为: " + res);
        int[] arr2 = {7,5,6,1};
        int res2 = test(arr2);
        System.out.println("暴力破解: 逆序对为: " + res2);

        /*
        归并排序: 逆序对为: 5
        暴力破解: 逆序对为: 5
        */
    }
}
