package a_BinarySearchBase;

import java.util.Arrays;

public class BinarySearch {

    public static <E extends Comparable<E>> int binarySearch(int[] data, int target) {
        int resIndex = binarySearch(data,0,data.length + 1,target);
        System.out.println(String.format("target: %d, resIndex: %d", target, resIndex));
        return resIndex;
    }

    /**
    * 二分查找法
     * l: 左边界
     * r: 有边界
     * target: 查找目标
     * return 目标下标
    * */
    public static <E extends Comparable<E>> int binarySearch(int[] data, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid] == target) {
            return mid;
        }
        if (data[mid] < target) {
            return binarySearch(data,mid + 1, r, target);
        }
        return binarySearch(data,l, mid - 1, target);
    }

    public static void main(String[] args) {

        int n = 10000;

        int[] arr = ArrayGenerator.generateOrderArrayTypeInt(n);
        System.out.println("BinarySearch");
        //SortingHelper.sortTest("BinarySearch", arr);
        binarySearch(arr,1234);

        System.out.println();
    }
}
