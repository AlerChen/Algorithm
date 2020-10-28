package d_TimeComplexity;

import java.util.Arrays;


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

    public static void main(String[] args) {
        //int num = 1000000;
        //Integer[] arr = ArrayGenerator.generateRandomArray(num,num);
        //SortingHelper.sortTest("MergeSort",arr);
        /**
         * sortName: MergeSort, n = 1000000, time = 0.355701 s
         * */
        
        int[] dataSize = {10000,100000};
        for (int data : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(data,data);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            Integer[] arr3 = Arrays.copyOf(arr,arr.length);
            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);
            SortingHelper.sortTest("MergeSort",arr3);
            /**
             Time Complexity :
             sortName: InsertionSort, n = 10000, time = 0.166160 s     -> O(n)
             sortName: SelectionSort, n = 10000, time = 0.095982 s     -> O(n)
             sortName: MergeSort, n = 10000, time = 0.004916 s         -> O(nlogn)

             sortName: InsertionSort, n = 100000, time = 15.379889 s    -> O(n)
             sortName: SelectionSort, n = 100000, time = 9.753761 s     -> O(n)
             sortName: MergeSort, n = 100000, time = 0.067463 s         -> O(nlogn)
             */
        }
    }
}
