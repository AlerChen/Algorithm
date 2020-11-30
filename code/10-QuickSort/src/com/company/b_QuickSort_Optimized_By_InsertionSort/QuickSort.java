package com.company.b_QuickSort_Optimized_By_InsertionSort;

import java.util.Arrays;

/**
 * 快速排序优化: 小规模数据使用插入排序
 *
* */
public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

   public static <E extends Comparable<E>> int partition(E[] arr, int l, int r){
        /** j 为 [l + 1, j] 和 [j + 1, r] 的分界线 */
        int j = l;
        for (int i = l; i <= r; i++) {
            // < p
            if (arr[i].compareTo(arr[l]) < 0){
                // 先扩增空间 (避免第一个数属于<区间,不好处理+1的问题)
                j++;
                // 再交换
                swap(arr, j, i);
            }
            // > p
            // 默认继续扩充 大于 p(j) 的区间. i++;
        }
        // 交换p点与原点l
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
       for (int i = l; i <= r; i++) {
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

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("QuickSort_op_insert",arr2);
        /**
         sortName: MergeSort, n = 100000, time = 0.236228 s
         sortName: QuickSort, n = 100000, time = 0.062688 s
         */
    }

}
