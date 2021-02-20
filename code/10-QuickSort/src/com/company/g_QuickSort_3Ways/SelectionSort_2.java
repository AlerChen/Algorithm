package com.company.g_QuickSort_3Ways;

public class SelectionSort_2{

    private SelectionSort_2(){};

    /*
    * 作业:
    *      选择排序: arr[i..n) 未排序, arr[0..i)已排序
    *      作业要求: arr[i..n] 已排序, arr[0..i)未排序
    *
    * */
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = arr.length -1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0 ; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0){
                    maxIndex = j;
                }
            }
            swap(arr,i,maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] data = {10000,100000};
        for (int n : data){
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("SelectionSort_2",arr);
        }
    }
    /*
    作业:
        sortName: SelectionSort_2, n = 10000, time = 0.231346 s
        sortName: SelectionSort_2, n = 100000, time = 17.985542 s

        n*10 -> time*100
        Time complexity : O(n^2)
    */


}
