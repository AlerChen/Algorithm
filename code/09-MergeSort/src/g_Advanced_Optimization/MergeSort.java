package g_Advanced_Optimization;

import java.util.Arrays;

/*
* 归并排序:
* 优化: 内存优化
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
        E[] temp = Arrays.copyOf(arr,arr.length);
        sort2(arr,0,arr.length-1,temp);

    }

    public static <E extends Comparable<E>> void sort2(E[]arr, int left, int right, E[] temp){
        // basic question
        if (left >= right){
            return;
        }

        int mid = (left + right) / 2;
        sort2(arr,left,mid,temp);
        sort2(arr,mid + 1,right,temp);
        /** 已排序部分不再进行排序 */
        if (arr[mid].compareTo(arr[mid+1]) > 0){
            merge2(arr,left,mid,right,temp);
        }
    }

    public static <E extends Comparable<E>> void merge2(E[]arr, int l, int mid, int r, E[] temp){
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
        SortingHelper.sortTest("MergeSort2",arr2);
        /**
            sortName: MergeSort, n = 1000000, time = 0.731152 s
            sortName: MergeSort2, n = 1000000, time = 0.572224 s
         */
    }
}
