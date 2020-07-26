package com.company;

public class SelectionSort {

    private SelectionSort(){};
    
    /*
    选择排序: 每次遍历数组,找出当前最小的
    */
    public static void sort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(Integer[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = {2, 4, 1, 3, 6, 4, 2, 7};
        SelectionSort.sort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
