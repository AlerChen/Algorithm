package a_BinarySearchBase;

import java.util.Arrays;

public class BinarySearch_mergeSort {


    public static void main(String[] args) {
        mergeSort();
    }

    public static void mergeSort(){
        int[] arr = {4,3,5,2,1,7,6,2,3,5,8,9};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (i != 0){
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        /**
         1,2,2,3,3,4,5,5,6,7,8,9
         */
    }

    private static void sort(int[] arr, int l, int r){
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r){
        int[] tempA = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (j > r) {
                arr[k] = tempA[i - l];
                i++;
            }else if(i > mid){
                arr[k] = tempA[j - l];
                j++;
            }else if( tempA[i - l] < tempA[j - l] ){
                arr[k] = tempA[i - l];
                i++;
            }else {
                arr[k] = tempA[j - l];
                j++;
            }
        }
    }

    /**
     1,2,2,3,3,4,5,5,6,7,8,9
     */
    private static void merge2(int[] arr, int l, int mid, int r){
        int[] tempA = Arrays.copyOf(arr,arr.length);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (j > r) {
                arr[k] = tempA[i];
                i++;
            }else if(i > mid){
                arr[k] = tempA[j];
                j++;
            }else if( tempA[i] < tempA[j] ){
                arr[k] = tempA[i];
                i++;
            }else {
                arr[k] = tempA[j];
                j++;
            }
        }
    }

}
