package com.company.b_QuickSort_Optimized_By_InsertionSort;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {};

    public static Integer[] generateOrderArray(int n){
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    /*
        生成随机数数组 [0,bound)
    */
    public static Integer[] generateRandomArray(int n, int bound){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
