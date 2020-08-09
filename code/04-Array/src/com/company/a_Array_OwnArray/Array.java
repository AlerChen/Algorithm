package com.company.a_Array_OwnArray;

public class Array {

    // 内部数组
    private int [] data;
    // 数组内部元素个数
    private int size;

    // 有参构造函数_根据容量创建数组
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 无参数构造函数_默认创建10容量
    public Array(){
        this(10);
    }

    // 获取数组元素个数
    public int getSize(){
        return size;
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 是否为空数组
    public boolean isEmpty(){
        return size == 0;
    }



}
