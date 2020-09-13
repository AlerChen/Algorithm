package com.company.g_deque;


/*
    双端队列
*/
public class Deque <E> {

    /* property */
    private E[] data;// 双端队列底层数组
    private int size;// 元素个数
    private int front;// 头指针
    private int tail;// 尾指针

    /* Life Circle */
    public Deque(){
        this(10);
    }

    public Deque(int capacity){
        data = (E[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    /* Public Method */
    public int getCapacity(){
        return data.length - 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return tail >= front ? tail - front : tail - front + data.length;
    }

    /* Private Method */
    private void resize(int capacity){
        E[] newData = (E[]) new java.lang.Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
    }

    /* Operate Method */

    public void addLast(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void addFirst(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        if (front - 1 < 0){
            front = ((front - 1) + data.length) % data.length;
        }else {
            front = (front - 1) % data.length;
        }
        data[front] = e;
        size ++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return e;
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        E e = data[tail];
        data[tail] = null;
        tail = (tail - 1) % data.length;
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Queue: size = %d, capacity = %d \n",getSize(),getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>(10);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                deque.addLast(i);
            }else {
                deque.addFirst(i);
            }
            System.out.println(deque);
            if (i % 3 == 2){
                // 每入队3个,出队一个
                deque.removeLast();
                System.out.println(deque);
            }
        }

    }
}
