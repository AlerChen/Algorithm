package com.company.a_QuickSort;

import java.util.Arrays;

/**
 * 快速排序: 原地排序
 * 原理:
 *      使用 partition 区分出左区间[l + 1, j], 右区间[j + 1, r], 中间点j(p)点
 *      j = l;
 *      如果 arr[i] > arr[l], 则 i++
 *      如果 arr[i] < arr[l], 则 j++, arr[j]与arr[i]交换
 *      最后 交换 index 0 与 arr[j], 函数返回 j index
 *      结束当次partition.
 *      继续使用sort递归排序左区间, 使用sort递归排序右区间
 *      直到 l >= r 为止.
 *      快排结束.
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

    private static <E> void swap(E[] arr, int a, int b){
        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr2);
        /**
         sortName: MergeSort, n = 100000, time = 0.236228 s
         sortName: QuickSort, n = 100000, time = 0.062688 s
         */
    }

}