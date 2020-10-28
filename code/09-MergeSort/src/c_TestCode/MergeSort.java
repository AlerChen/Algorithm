package c_TestCode;
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
        int num = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(num,num);
        SortingHelper.sortTest("MergeSort",arr);
        /**
         * sortName: MergeSort, n = 1000000, time = 0.355701 s
         * */
    }
}
