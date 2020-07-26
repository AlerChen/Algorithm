package com.company;
/*
* 02
* */
public class LinearSearch {

    /*
    * 构造函数私有化, 强制使外界不能调用类构造函数生成对象
    * */
    private LinearSearch(){}

    /*
    *  static 静态方法,外界不用生成对象再调用对象方法.
    *  相当于OC的类方法
    *  */
    public static int search(int[] data, int target){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target){
                return i;
            }
        }
        return -1;
    }

    /*
     *  <E> 范型
     *  */
    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

}
