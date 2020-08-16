package com.company.c_Query_And_Update_Element;

import com.sun.org.apache.xpath.internal.operations.String;

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

    // 向数组最后添加一个元素
    public void addLast(int e){

        // old code
        //     if (size == data.length)
        //         throw new IllegalArgumentException("Add last failed. Array is full.");
        //     // add
        //     data[size] = e;
        //     size++;

        // new code
        add(size,e);
    }

    public void addFirst(int e){
        this.add(0,e);
    }

    /*
    * 添加元素
    * index : 添加元素下标
    * e : 被添加元素
    * */
    public void add(int index, int e){
        // check array
        if (data.length == size)
            throw new IllegalArgumentException("Add failed. Array is full.");
        // check index
        if (index < 0 || index > size)
            throw  new IllegalArgumentException("add failed. Require index >= 0 and index < size");

        // move origin data all element
        for (int i = size - 1; i >= index; i --) {
            data[i+1] = data[i];
        }
        // target index
        data[index] = e;
        // size
        size++;
    }

    // 获取index索引位置的元素
    public int get(int index){
        // check index
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get failed. index is full.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e){
        // check index
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        data[index] = e;
    }

    // toString
    @Override
    public java.lang.String toString(){
        StringBuilder res = new StringBuilder();
        res.append(java.lang.String.format("Array: size = %d , capacity = %d \n",size, data.length));
        res.append("[");
        for (int i = 0; i < size ; i++) {
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array arr = new Array(20);
        arr.addLast(3);
        arr.addLast(2);
        arr.addLast(1);
        arr.addLast(4);
        arr.addLast(5);
        arr.addLast(8);

        System.out.println(arr);
        // size : 6
    }







}
