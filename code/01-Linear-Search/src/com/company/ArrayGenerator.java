package com.company;

public class ArrayGenerator {

    private ArrayGenerator() {};

    public static Integer[] generateOrderArray(int n){
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }
}
