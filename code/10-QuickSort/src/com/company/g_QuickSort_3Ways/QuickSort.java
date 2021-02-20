package com.company.g_QuickSort_3Ways;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序优化: 三路快速排序
 *       问题:  当快速排序遇见完全有序的数组时,进化成 O(n) 级别
 *       解决方案:
 *              // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
 *              维护l,lt,gt,r循环不变量
 *              [l + 1, lt]: 小于p部分
 *              [lt + 1, i - 1]: 等于p部分
 *              [gt, r]: 大于p部分
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

    public static <E extends Comparable<E>> void sort_2ways(E[] arr){
        sort_2ways(arr,0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort_2ways(E[] arr, int l, int r){
       /** 仅一个元素,立刻返回 */
       if (l >= r){
           return;
       }
       int p = partition_2ways(arr, l , r);
       sort_2ways(arr, l, p - 1);
       sort_2ways(arr, p + 1, r);
    }

    /**
    * 二路快排
     * 分别从数组前后两端开始遍历, 小的左边,大的右边, 当两边都有不符合规则的元素时停止,等待交换,交换,继续遍历
     * 直到 左游标 大于等于 右游标为止
    * */
    private static <E extends Comparable<E>> int partition_2ways(E[] arr, int l, int r){
        int random = l + (new Random()).nextInt(r - l) + 1;
        swap(arr, random, l);
        int i = l + 1;
        int j = r;
        while (true){
            /** 从左开始遍历,遇见小于标定点元素则停下,否则 i++ (向后移动) */
            while (i <= j && arr[i].compareTo(arr[l]) < 0){
                i ++;
            }
            /** 从右开始遍历,遇见大于标定点元素则停下,否则 j-- (向前移动) */
            while (i <= j && arr[j].compareTo(arr[l]) > 0){
                j --;
            }
            /** 先判断是否已经遍历完毕 */
            if (i >= j){
                break;
            }
            /** 此时左端和右端都停有一个不符合各自规则的值 */
            swap(arr, i, j);
            /** 交换后,更新各自游标值 */
            i ++;
            j --;
        }
        /** 将最后的i值与l值交换, 回归正确的位置 p */
        swap(arr, j, l);
        return j;
    }

    public static <E extends Comparable<E>> void sort_3ways(E[]arr){
        sort_3ways(arr,0,arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort_3ways(E[]arr, int l, int r){
        if (l >= r){
            return;
        }
        /** partition */
        int random = l + (new Random()).nextInt(r - l) + 1;
        swap(arr,l,random);
        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;

        while (i < gt){
            if (arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i, lt);
                i ++;
            }else if(arr[i].compareTo(arr[l]) > 0){
                gt --;
                swap(arr, i, gt);
            }else {
                i ++;
            }
        }
        swap(arr, l, lt);

        /** recursion */
        sort_3ways(arr, l, lt - 1);
        sort_3ways(arr, gt, r);
    }

//    private static <E extends Comparable<E>> int[] partition_3ways(){
//
//
//        //return [0,1];
//    }

    public static void main(String[] args) {

//        int n = 10000;
//        System.out.println("RandomArray");
//        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("QuickSort",arr);
//
//        System.out.println("OrderArray");
//        Integer[] arr2 = ArrayGenerator.generateOrderArray(n);
//        SortingHelper.sortTest("QuickSort",arr2);
//
//        System.out.println("OrderArray");
//        Integer[] arr3 = ArrayGenerator.generateRandomArray(n,1);
//        SortingHelper.sortTest("QuickSort",arr3);
//
//        System.out.println("QuickSort_2ways");
//        Integer[] arr4 = ArrayGenerator.generateRandomArray(n,1);
//        SortingHelper.sortTest("QuickSort_2ways",arr4);

        int n = 10000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort_2ways", arr2);
        SortingHelper.sortTest("QuickSort_3ways", arr3);

        System.out.println();

        arr = ArrayGenerator.generateOrderArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort_2ways", arr2);
        SortingHelper.sortTest("QuickSort_3ways", arr3);
        System.out.println();

        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort_2ways", arr2);
        SortingHelper.sortTest("QuickSort_3ways", arr3);
        System.out.println();

        /**
         Random Array
         sortName: QuickSort, n = 10000, time = 0.024874 s
         sortName: QuickSort_2ways, n = 10000, time = 0.010950 s
         sortName: QuickSort_3ways, n = 10000, time = 0.018365 s

         Ordered Array
         sortName: QuickSort, n = 10000, time = 0.001369 s
         sortName: QuickSort_2ways, n = 10000, time = 0.001357 s
         sortName: QuickSort_3ways, n = 10000, time = 0.019118 s

         Same Value Array
         sortName: QuickSort, n = 10000, time = 0.190719 s
         sortName: QuickSort_2ways, n = 10000, time = 0.003265 s
         sortName: QuickSort_3ways, n = 10000, time = 0.000063 s
        */

    }
}
