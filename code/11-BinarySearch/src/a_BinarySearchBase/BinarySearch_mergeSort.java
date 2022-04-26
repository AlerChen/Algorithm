package a_BinarySearchBase;

import java.util.Arrays;

public class BinarySearch_mergeSort {


    public static void main(String[] args) {
        mergeSort();
        mergeSort_changeScope();
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

    /**
     合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
     */
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

    /**
     * 更改循环不变量练习
     * arr[l,r) 进行排序
     * */
    public static void mergeSort_changeScope(){
        System.out.println("\nmergeSort_changeScope");
        int[] arr = {4,3,5,2,1,7,6,2,3,5,8,9};
        sort_changeScope(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i != 0){
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        /**
         mergeSort_changeScope
         1,2,2,3,3,4,5,5,6,7,8,9
         */
    }

    /**
     更改循环不变量练习
     arr[l, mid)
     */
    private static void sort_changeScope(int[] arr, int l, int r){
        if (r - l <= 1) return;/** 一个元素时不必操作 [l,r)*/
        int mid = l + (r - l) / 2;
        sort_changeScope(arr, l, mid);/** [l,mid) */
        sort_changeScope(arr, mid, r); /** [mid,r) */
        if(arr[mid-1] > arr[mid]){
            merge_changeScope(arr, l, mid, r);
        }
    }

    /**
     更改循环不变量练习
     合并两个有序的区间 arr[l, mid] 和 arr[mid, r)
     */
    private static void merge_changeScope(int[] arr, int l, int mid, int r){
        int[] tempA = Arrays.copyOfRange(arr, l, r);
        int i = l;
        int j = mid;
        for (int k = l; k < r; k++) {
            if (j >= r) {
                arr[k] = tempA[i - l];
                i++;
            }else if(i >= mid){
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

}
