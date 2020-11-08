package h_Bottom_Up;

import sun.jvm.hotspot.memory.PlaceholderEntry;

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

    /**  MergeSort Bottom Up  */
    public static <E extends Comparable<E>> void sortBU(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        sortBU(arr,0,arr.length - 1,temp);
    }

    public static <E extends Comparable<E>> void sortBU(E[] arr, int l, int r, E[] aux){
        E[] temp = Arrays.copyOf(aux,aux.length);
        int n = arr.length;
        // 长度为1[0,1]  进行两两合并
        // 1 -> 2 -> 4 -> 8 .... 以此类推
        for (int sz = 1; sz < n; sz += sz) {
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
             sortName: MergeSort, n = 1000000, time = 0.649646 s
             sortName: MergeSortBU, n = 1000000, time = 0.678120 s
         */
    }
}
