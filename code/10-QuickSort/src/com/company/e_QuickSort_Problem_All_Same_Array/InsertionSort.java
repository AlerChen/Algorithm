package com.company.e_QuickSort_Problem_All_Same_Array;

public class InsertionSort {

    /*
     插入排序:
     从头部开始遍历数组,每次循环依次判断当前数j的前一个数j-1是否较小/大;
     符合条件则进行交换,j--继续向前遍历;
     不符合条件则进行i++,进行下一轮大循环;

     总结 : 头部开始,遍历所完成之处,皆是排序完整的.未遍历之处,亦是未排序的.
     e.g : 0,3,5,7,/2,8,1,9
 */
    private InsertionSort(){};

    /*
    * 插入排序
    * */
    public static <E extends Comparable> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0)
                swap(arr,j-1,j);
                else break;
            }
        }
    }
    /*
    * 插入排序_归并排序优化_排序数组中的部分范围
    * */
    public static <E extends  Comparable<E>> void sort(E[] arr, int l, int r){
        for (int i = l; i <= r; i++){
            E temp = arr[i];
            int j;
            // j之前的那个数大于等于左区间起始位置, 并且j-1的数 > j, 则j的值 = j-1的值
            for (j = i; j - 1 >= l && arr[j - 1].compareTo(temp) > 0; j--){
                arr[j] = arr[j - 1];
            }
            // 最后的j,即此轮最适合的位置,直接赋值
            arr[j] = temp;
        }
    }

//        public static <E extends  Comparable<E>> void sort(E[] arr, int l, int r){
//            for (int i = l; i <= r; i++) {
//                for (int j = i; j - 1 >= l ; j--) {
//                    if (arr[j - 1].compareTo(arr[j]) > 0){
//                        swap(arr,j-1,j);
//                    }else {
//                        break;
//                    }
//                }
//            }
//        }

//    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
//
//        for(int i = l; i <= r; i ++){
//
//            // 将 arr[i] 插入到合适的位置
//            E t = arr[i];
//            int j;
//            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --){
//                arr[j] = arr[j - 1];
//            }
//            arr[j] = t;
//        }
//    }

    /*

    插入排序优化:
        每次的交换 -> 直接赋值(减少程序操作的次数:swap次数:数组寻址的次数)

        1.先记录当前处理的数字
        2.符合条件则将符合条件的数字向后平移一位,覆盖原有数字
        3.内循环结束,将当前处理的数字赋值给最后一次判断位数字

        3,5,2,7,1
        i = 0
        temp = 3

        3,5,2,7,1
        i = 1
        temp = 5

        3,5,2,7,1
        i = 2
        temp = 2
        -> 3,5,5,7,1 符合条件数字向后平移一位,覆盖被判断位(arr[j] = arr[j-1]), j--
        -> 3,3,5,7,1
        -> arr[0] = temp;
        -> 2,3,5,7,1

        2,3,5,7,1
        i = 3
        temp = 7
        -> 2,3,5,7,1

        2,3,5,7,1
        i = 4
        temp = 1
        ***  if arr[j-1] - temp > 0 ***
        -> 2,3,5,7,7; j --
        -> 2,3,5,5,7; j --
        -> 2,3,3,5,7; j --
        -> 2,2,3,5,7; j --
        -> break;
        -> arr[j] = temp;
        -> 1,2,3,5,7



    */
    public static <E extends Comparable> void sort_optimize (E[] arr){

        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            for (j = i; j -1 >= 0 && temp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    /*
    InsertionSort:
    sortName: InsertionSort, n = 10000, time = 0.238406 s
    sortName: InsertionSort, n = 100000, time = 25.940432 s
    srot_optimize:
    sortName: InsertionSort_optimize, n = 10000, time = 0.194541 s
    sortName: InsertionSort_optimize, n = 100000, time = 14.518286 s
    Time complexity : O(n^2)
     */


    /*
     插入排序:
     (作业)
          倒序实现插入排序,使插入排序的循环不变量与正序插入排序的循环不变量维护方式一致
     */
    public static <E extends Comparable> void sort_reverse(E[] arr){
        for (int i = arr.length -1; i >= 0; i--) {
            E temp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && temp.compareTo(arr[j+1]) > 0 ; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }

    private static <E>void swap(E[] arr,int a,int b){
        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*-----------------------------------------------------------------*/

    public static void main(String[] args) {
        // 插入排序
        //testInsertionSort();
        // 插入排序_优化
        //testInsertionSort_optimize();
        // 插入排序_特性
        //testInsertionSort_feature();
        // 插入排序_倒序实现
        testInsertionSort_reverse();
    }

    /*
    * 插入排序
    * */
    private static void testInsertionSort(){
        int[] dataArr = {10000,100000};
        for (int data:dataArr) {
            Integer[] arr = ArrayGenerator.generateRandomArray(data,data);
            SortingHelper.sortTest( "InsertionSort",arr);
        }
    }
    /*
    sortName: InsertionSort, n = 10000, time = 0.207552 s
    sortName: InsertionSort, n = 100000, time = 29.786849 s
    */

    /*
     * 插入排序_小优化
     * */
    private static void testInsertionSort_optimize(){
        int[] dataArr = {10000, 100000};
        for (int data : dataArr) {
            Integer[] arr = ArrayGenerator.generateRandomArray(data, data);
            SortingHelper.sortTest("InsertionSort_optimize", arr);
        }
    }
    /*
    sortName: InsertionSort, n = 10000, time = 0.181293 s
    sortName: InsertionSort, n = 100000, time = 20.638732 s
    */

    /*
    * 插入排序_特性
    * 有序数组情况下 时间复杂度为: O(n)
    * 无序数组情况下 时间复杂度为: O(n^2)
    * */
    private static void testInsertionSort_feature(){
        int[] dataArr = {10000, 100000};
        for (int data : dataArr) {
            System.out.println("Ordered Array : ");
            Integer[] orderArr = ArrayGenerator.generateOrderArray(data);
            SortingHelper.sortTest("InsertionSort", orderArr);

            System.out.println("Random Array : ");
            Integer[] randomArr = ArrayGenerator.generateRandomArray(data, data);
            SortingHelper.sortTest("InsertionSort", randomArr);
        }
    }
    /*
    Ordered Array :
    sortName: InsertionSort, n = 10000, time = 0.001683 s
    Random Array :
    sortName: InsertionSort, n = 10000, time = 0.269312 s
    Ordered Array :
    sortName: InsertionSort, n = 100000, time = 0.002095 s
    Random Array :
    sortName: InsertionSort, n = 100000, time = 23.907390 s

    */

    /*
    * 插入排序_倒序实现
    * */
    private static void testInsertionSort_reverse(){
        int[] dataArr = {10000, 100000};
        for (int data : dataArr) {
            Integer[] arr = ArrayGenerator.generateRandomArray(data, data);
            SortingHelper.sortTest("InsertionSort_reverse", arr);
        }
    }
    /*
    sortName: InsertionSort_reverse, n = 10000, time = 0.526164 s
    sortName: InsertionSort_reverse, n = 100000, time = 16.942521 s
    */

}
