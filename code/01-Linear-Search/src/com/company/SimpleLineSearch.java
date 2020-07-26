package com.company;

/*
 * 01
 * */
public class SimpleLineSearch {

    /* 线性查找 */
    public int searchNumInArray(int[] array,int target) {
        for (int i = 0; i < array.length; i++) {
                int num = array[i];
                if (num == target){
                    return i;
                }
        }
        return -1;
    }
}
