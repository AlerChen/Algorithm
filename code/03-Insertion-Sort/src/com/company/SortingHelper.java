package com.company;

public class SortingHelper {

    /*
      <范型>比较是否排序
    */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }

    /*
       排序时间测试
    */
    public static <E extends Comparable<E>> void sortTest (String sortName, E[] arr){
        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort_Pattern")){
            SelectionSort_Pattern.sort(arr);
        }
        if (sortName.equals("SelectionSort_2")){
            SelectionSort_2.sort(arr);
        }
        if (sortName.equals("InsertionSort")){
            InsertionSort.sort(arr);
        }
        if (sortName.equals("InsertionSort_optimize")){
            InsertionSort.sort_optimize(arr);
        }
        if (sortName.equals("InsertionSort_reverse")){
            InsertionSort.sort_reverse(arr);
        }

        
        long endTime = System.nanoTime();
        Double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException(sortName + "failed");
        }
        System.out.println(String.format("sortName: %s, n = %d, time = %f s",sortName,arr.length,time));
    }
}
