package e_Basic_Optimization;

import java.util.Arrays;

/*
* 归并排序:
* 基本优化: 已排序部分,不再进行排序
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

    /**  Sort2  */
    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort(arr,0,arr.length-1);
    }

    public static <E extends Comparable<E>> void sort2(E[]arr, int left, int right){
        // basic question
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort2(arr,left,mid);
        sort2(arr,mid + 1,right);
        /** 已排序部分不再进行排序 */
        if (arr[mid].compareTo(arr[mid+1]) > 0){
            merge2(arr,left,mid,right);
        }
    }

    public static <E extends Comparable<E>> void merge2(E[]arr, int l, int mid, int r){
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

    public static void main(String[] args) {
        int num = 1000000;
        System.out.println("Random Array : ");
        Integer[] arr = ArrayGenerator.generateRandomArray(num,num);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);

        System.out.println("\nOrdered Array : ");
        Integer[] arr3 = ArrayGenerator.generateOrderArray(num);
        Integer[] arr4 = Arrays.copyOf(arr3,arr3.length);
        SortingHelper.sortTest("MergeSort",arr3);
        SortingHelper.sortTest("MergeSort2",arr4);

        /**
             Random Array :
             sortName: MergeSort, n = 1000000, time = 0.729314 s
             sortName: MergeSort2, n = 1000000, time = 0.537178 s

             Ordered Array :
             sortName: MergeSort, n = 1000000, time = 0.257509 s
             sortName: MergeSort2, n = 1000000, time = 0.110024 s

             数据是完全有序的情况下,归并排序优化十分明显(有序数据不再排序).
             归并排序时间复杂度进化到 O(n) 级别.
         */
    }
}
