package com.company.d_QuickSort_Optimized;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序优化: 引入随机机制_p点
 *       问题:  第一版快速排序问题_当数组是有序数组时
 *             partition将遍历全数组, n次
 *             递归深度为: n层
 *             时间复杂度: O(n^2), 递归深度: n
 *       解决方案:
 *              在partition之前, 将index0的数与随机index数交换即可.
* */
public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] arr){

        Random random = new Random();
        sort(arr,0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random){
        if (l >= r){
            return;
        }
        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

   public static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random){
        /** 随机点 */
        int p = l + random.nextInt(r - l + 1);
        /** 随机点与原点交换 */
        swap(arr, p, l);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // < 0
            if (arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, j, i);
            }
        }
        // exchange p with origin l
        swap(arr, l, j);
        return j;
   }

   /** 使用插入排序优化 */
   public static <E extends Comparable<E>> void sort_op_insert(E[] arr){
        sort_op_insert(arr, 0, arr.length - 1);
   }

   public static <E extends Comparable<E>> void sort_op_insert(E[] arr, int l, int r){
       /** 使用插入排序优化小规模数据 */
       if (r - l <= 7){
           InsertionSort.sort(arr, l, r);
           return;
       }
       int p = partition_op_insert(arr, l, r);
       sort_op_insert(arr, l, p - 1);
       sort_op_insert(arr, p + 1, r);
   }

   private static <E extends Comparable<E>> int partition_op_insert(E[] arr, int l, int r){
       int j = l;
       for (int i = l + 1; i <= r; i++) {
           // < p
           if (arr[i].compareTo(arr[l]) < 0){
               j++;
               swap(arr, j, i);
           }
       }
       // exchange l with j -> find p
       swap(arr, l, j);
       return j;
   }

    private static <E> void swap(E[] arr, int a, int b){
        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int n = 50000;
        System.out.println("RandomArray");
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("MergeSort",arr);

        System.out.println("OrderArray");
        Integer[] arr3 = ArrayGenerator.generateOrderArray(n);
        Integer[] arr4 = Arrays.copyOf(arr3,arr3.length);
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("MergeSort",arr);

        /**
         RandomArray
         sortName: QuickSort, n = 50000, time = 0.051234 s
         sortName: MergeSort, n = 50000, time = 0.100934 s
         OrderArray
         sortName: QuickSort, n = 50000, time = 0.010635 s
         sortName: MergeSort, n = 50000, time = 0.010478 s
         */
    }

}
