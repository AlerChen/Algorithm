package f_Optimized_by_InsertionSort;

import java.util.Arrays;

/*
* 归并排序:
* 优化: 小规模数据,使用插入排序法O(n^2)
* 插入排序虽然是 O(n^2) 级别,但是n常数非常小.
* 归并排序法虽然是 O(nlogn) 级别,但是n常数比较大,递归层数比较深.
* 当小规模数据进行排序时,归并排序性能是比不上插入排序的.
* 但因为各种语言底层会做不同的优化,在某些语言上,使用插入排序法来优化归并排序,可能反而性能更差.
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
        //  if (left >= right){
        //    return;
        //  }
        /** 小规模数据使用插入排序优化 */
        if (right - left <= 15){
            InsertionSort.sort(arr,left,right);
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
        Integer[] arr = ArrayGenerator.generateRandomArray(num,num);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);
        /**
         sortName: MergeSort, n = 1000000, time = 0.831836 s
         sortName: MergeSort2, n = 1000000, time = 0.710366 s
         小规模数据使用插入排序优化
         */
    }
}
