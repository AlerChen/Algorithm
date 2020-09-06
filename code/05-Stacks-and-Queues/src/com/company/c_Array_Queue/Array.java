package com.company.c_Array_Queue;

public class Array<E> {

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
        // check index
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Require index >= 0 and index < size.");
        // resize
        if (data.length == size)
            resize(data.length * 2);

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

    public E getLast(){
        return data[size -1];
    }

    public E getFirst(){return get(0);};

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
        // resize
        // size == data.length / 2
        //  if (size == data.length / 2){
        //  resize(data.length / 2);
        //  }
        // 缩容过急,导致 复杂度震荡.
        /*
            复杂度震荡: (极端的情况下,时间复杂度激增)
                addLast() O(n)
                removeLast() O(n)
                addLast() O(n)
                removeLast() O(n)
            解决方案:
                使用更懒惰的缩容方案.
                if size == data.leng / 4;
                   resize(data.leng / 2)
        */

        if (size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
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

    // 数组扩容/缩容
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
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

    /*

    Time complexity:

        addLast() : O(1)
        addFirst() : O(n)
        addIndex(int index, E e) : O(n/2) = O(n)

        add系列最坏情况: O(n)

        resize : O(n)
            最坏情况时间复杂度 : O(n)
            均摊时间复杂度 : O(1)
                9次addLast, 触发resize,总共17次操作.
                平均,每次addLast操作,进行2次基本操作.

                e.g
                    capacity = n , n + 1 次addLast, 触发resize,
                    总共进行2n+1次基本操作
                    平均,每次addLast操作,进行2次基本操作.
                    时间复杂度: O(1)
    */

}
