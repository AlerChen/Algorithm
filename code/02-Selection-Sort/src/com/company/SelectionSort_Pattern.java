package com.company;

import java.util.Comparator;

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
      交换-范型
    */
    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Student[] arr = {
                new Student("bobo",100),
                new Student("Bibi",88),
                new Student("Alice",96),
                new Student("Gigi",36),
                new Student("Kom",79),
        };

        SelectionSort_Pattern.sort(arr);

        for (Student s : arr){
            System.out.println(s);
        }

    }
    
}
