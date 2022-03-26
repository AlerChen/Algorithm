package a_BinarySearchBase;

import java.util.Arrays;

public class BinarySearch {


    /**
     * 二分查找法：非递归写法
     * */
    public static <E extends Comparable<E>> int binarySearch(E[] data, E target) {

        int l = 0, r = data.length - 1;
        int resIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                resIndex = mid;
                break;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(String.format("target: %d, resIndex: %d", target, resIndex));
        return resIndex;
    }


    /**
     * 二分查找法：递归写法
     * */
    public static <E extends Comparable<E>> int binarySearchR(E[] data, E target) {
        int resIndex = binarySearchR(data,0,data.length - 1,target);
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
    public static <E extends Comparable<E>> int binarySearchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return binarySearchR(data,mid + 1, r, target);
        }
        return binarySearchR(data,l, mid - 1, target);
    }

    public static void main(String[] args) {

        int n = 10000;

        Integer[] arr = ArrayGenerator.generateOrderArray(n);
        //System.out.println("BinarySearchR");
        //SortingHelper.sortTest("BinarySearchR", arr, 123);
        System.out.println("BinarySearch");
        SortingHelper.sortTest("BinarySearch", arr, 123);
        System.out.println();
    }
}
