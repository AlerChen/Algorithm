package com.company.e_Generic_Data_Structures;

public class Array <E> {

    // 内部数组
    private E[] data;
    // 数组内部元素个数
    private int size;

    // 有参构造函数_根据容量创建数组
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数构造函数_默认创建10容量
    public Array() {
        this(10);
    }

    // 获取数组元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 是否为空数组
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组最后添加一个元素
    public void addLast(E e) {

        // old code
        //     if (size == data.length)
        //         throw new IllegalArgumentException("Add last failed. Array is full.");
        //     // add
        //     data[size] = e;
        //     size++;

        // new code
        add(size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    /*
     * 添加元素
     * index : 添加元素下标
     * e : 被添加元素
     * */
    public void add(int index, E e) {
        // check array
        if (data.length == size)
            throw new IllegalArgumentException("Add failed. Array is full.");
        // check index
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Require index >= 0 and index < size.");

        // move origin data all element
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // target index
        data[index] = e;
        // size
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        // check index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed. Require index index < 0 || index > size.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        // check index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Require index index < 0 || index > size.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed. Require index illegal");
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = this.find(e);
        if (index != -1)
            remove(index);
    }

    // toString
    @Override
    public java.lang.String toString() {
        StringBuilder res = new StringBuilder();
        res.append(java.lang.String.format("Array: size = %d , capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }



}
