package com.company.c_QuickSort_Optimized_By_Random;

import java.util.Arrays;

/*
* 归并排序_自底向上:
* 优化: 使用插入排序优化自底向上归并排序
* 理解: 自底向上归并排序,一开始就要从基础数据开始排序.
*       而小规模数据(超参数:16),使用插入排序法速度更快.
*       所以,第一次就多次循环将所有 [i,i+15] 区间的小规模数据, 全部进行插入排序.
*       当所有符合规则的小规模数据插入排序完毕时,即可进行归并排序,归并排序处理大数据更快.
* */
public class MergeSort<E>{

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }

    public static <E extends Comparable<E>> void sort(E[]arr, int left, int right){
        // basic question
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(arr,left,mid);
        sort(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }

    public static <E extends Comparable<E>> void merge(E[]arr, int l, int mid, int r){
        E[] tempArr = Arrays.copyOfRange(arr,l,r+1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid){
                arr[k] = tempArr[j - l];
                j++;
            }else if (j > r){
                arr[k] = tempArr[i - l];
                i++;
            }else if (tempArr[i - l].compareTo(tempArr[j - l]) <= 0){
                arr[k] = tempArr[i - l];
                i++;
            }else {
                arr[k] = tempArr[j - l];
                j++;
            }
        }
    }

    /**  MergeSort Bottom Up  */

    public static <E extends Comparable<E>> void sortBU(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        int n = arr.length;

        // 优化: 小规模数据使用插入排序优化,时间优化更快
        // tips: 遍历一遍，对所有 arr[i, i + 15] 的区间，使用插入排序法
        for (int i = 0; i < n; i += 16){
            InsertionSort.sort(arr, i, Math.min(n - 1, i + 15));
        }

        // 优化: sz从16开始
        // 长度为1[0,1]  进行两两合并
        // 1 -> 2 -> 4 -> 8 .... 以此类推
        for (int sz = 16; sz < n; sz += sz) {
            // [l, l + size - 1] && [l + size, l + size + size -1]
            // i + sz < n : 右区间的左边 小于 数组长度, 证明必定存在左区间&右区间
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 优化:有序情况不进行排序
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    // [l, l + size - 1] && [l + size, l + size + size -1]
                    // mergeBU(arr, i, i + sz - 1, i + sz + sz - 1, temp);
                    // Math.min(i + sz + sz - 1, n - 1):
                    // 存在i + sz + sz - 1 越界的情况, 比最小值,获取真实边界.
                    mergeBU(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }
    }

    public static <E extends Comparable<E>> void mergeBU(E[]arr, int l, int mid, int r, E[] temp){
        System.arraycopy(arr,l,temp,l,r - l + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid){
                arr[k] = temp[j];
                j++;
            }else if (j > r){
                arr[k] = temp[i];
                i++;
            }else if (temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(num,num);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSortBU",arr2);
        /**
            归并排序_自底向上_小规模数据使用插入排序优化:
            sortName: MergeSort, n = 1000000, time = 0.682911 s
            sortName: MergeSortBU, n = 1000000, time = 0.604389 s
         */
    }
}
