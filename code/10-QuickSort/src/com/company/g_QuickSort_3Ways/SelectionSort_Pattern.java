package com.company.g_QuickSort_3Ways;

public class SelectionSort_Pattern {
    
    private SelectionSort_Pattern() {};
    
    /*
    选择排序-范型<支持任何类型排序>
    */
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    /*
    选择排序
        时间复杂度: O(n^2)
        外循环: n
        内循环: n, n-1, n-2, n-3 ..... 3, 2, 1  =  (1+2+3+....n)  =  (1+n)/2

        总次数: 内循环 * 外循环 = (1+n)/2 * n
                             = (1/2 + 1/2*n) * n
                             = 1/2*n + 1/2*n^2
                             = O(n^2)
    */

    /*
      交换-范型
    */
    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void main(String[] args) {
//
//        Student[] arr = {
//                new Student("bobo",100),
//                new Student("Bibi",88),
//                new Student("Alice",96),
//                new Student("Gigi",36),
//                new Student("Kom",79),
//        };
//
//        SelectionSort_Pattern.sort(arr);
//
//        for (Student s : arr){
//            System.out.println(s);
//        }
//    }

    public static void main(String[] args) {

        int[] data = {1000, 10000, 100000};
        for (int n : data) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort_Pattern", arr);
        }
        /*
        sortName: SelectionSort_Pattern, n = 1000, time = 0.010042 s
        sortName: SelectionSort_Pattern, n = 10000, time = 0.157053 s
        sortName: SelectionSort_Pattern, n = 100000, time = 12.724032 s
        
        选择排序 时间复杂度: O(n^2)
        随着数据量的增加, 执行时间呈指数上涨.
         
        */
    }
    
}
