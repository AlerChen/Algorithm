package com.company;

import com.company.e_Generic_Data_Structures.Array;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array(20);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.addLast(1);
        System.out.println("arr.addLast(1);");
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println("arr.addFirst(-1);");
        System.out.println(arr);

        int t = arr.get(1);
        System.out.println("arr.get(1);");
        System.out.println(arr);

        arr.set(0,9);
        System.out.println("arr.set(0,9);");
        System.out.println(arr);

        arr.removeLast();
        System.out.println("arr.removeLast();");
        System.out.println(arr);

        arr.removeFirst();
        System.out.println("arr.removeFirst();");
        System.out.println(arr);

        arr.remove(3);
        System.out.println("arr.remove(3);");
        System.out.println(arr);

        arr.removeElement(7);
        System.out.println("arr.removeElement(7);");
        System.out.println(arr);


    }
}
