package com.company.e_Loop_Queue_Without_One_Space;

import com.company.d_Loop_Queue.Queue;

public class LoopQueue<E> implements Queue<E> {

    /*-- property --*/
    private E[] data;//数组数据
    private int size;//元素个数
    private int front,tail;//头尾指针

    /*-- public method --*/
    public LoopQueue(int capacity){
        // 多留一个空位,为了区别 :
        //  front == tail 为队列空,
        //  (tail + 1) % data.length == front 为队列满.
        //data = (E[])new Object[capacity +1];
        // 老师解法: 不使用多一个空间
        // 使用size和getCapacity来维护队列的元素个数
        data = (E[])new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return data.length;
    }

    //public int getCapacity(){return data.length -1;}
    // 老师解法
    public int getCapacity(){
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        // 个人解法
        // return (front == tail) && (size == 0);
        // 老师解法
        // 注意，我们不再使用front和tail之间的关系来判断队列是否为空，而直接使用size
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 个人解法
        //if ((tail + 1) % data.length == front && size != 0){
        // 老师解法
        // 注意，我们不再使用front和tail之间的关系来判断队列是否为满，而直接使用size
        // 直接使用size和getCapacity来维护队列 full 和 empty 的情况
        if(size == getCapacity()){
            // 队列满
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 缩容
        if (data.length == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    /* -- private method -- */
    private void resize(int capacity){
        // + 1 : 多留一个空位给队列内部判断使用
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            // 个人写法
            // newData[i] = data[front];
            // front = (front + 1) % data.length;
            // 老师写法
            newData[i] = data[(i + front) % data.length];
        }
        // new data
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue: size = %d, capacity = %d \n",size,getCapacity()));
        res.append("front [");
        // for (int i = front; i != tail ; i = (i + 1) % data.length) {
        //    res.append(data[i]);
        //    if ((i + 1) % data.length != tail){
        //        res.append(", ");
        //    }
        // }
        // 老师解法:
        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            // 判断是否到达倒数第二个元素,添加','符号 与多一个空间的事情没有关联
            if ((i + front + 1) % data.length != tail){
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2){
                // 每入队3个,出队一个
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
