package com.company;

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
    public static <E extends Comparable> void srot_optimize (E[] arr){

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

    private static <E>void swap(E[] arr,int a,int b){
        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        //testSort();
        testSort2();
    }

    /*
    * 插入排序
    * */
    private static void testSort(){
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
    private static void testSort2() {
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
}
