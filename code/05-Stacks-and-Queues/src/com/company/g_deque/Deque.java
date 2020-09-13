package com.company.g_deque;


/*
    双端队列_浪费一个空间
    老师解法是不浪费一个空间的
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
        // 个人解法
        // if (front - 1 < 0){
            // front = ((front - 1) + data.length) % data.length;
        // }else {
            // front = (front - 1) % data.length;
        // }
        // 老师解法
        front = front == 0 ? data.length - 1 : front - 1;
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
        // 老师解法: 补充缩容操作
        if (size == getSize()/4 && (getCapacity()/2) != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        E e = data[tail];
        data[tail] = null;
        // 个人解法: 不正确 会有负数的出现
        // tail = (tail - 1) % data.length;
        // 老师解法:
        // 计算删除掉队尾元素以后，新的 tail 位置
        tail = tail == 0 ? data.length -1 : tail - 1;
        size--;
        // 老师解法: 补充缩容操作
        if (size == getCapacity()/4 && (getCapacity()/2) != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    // 老师解法 : 补充获取队列头元素
    public E getFront(){
        if (isEmpty()){
            return null;
        }
        return data[front];
    }

    // 老师解法 : 补充获取队列尾元素
    public E getTail(){
        if (isEmpty()){
            return null;
        }
        return data[tail];
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
        // enqueue
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                deque.addLast(i);
            }else {
                deque.addFirst(i);
            }
            System.out.println(deque);
        }

        System.out.println(deque);
        // dequeue
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                deque.removeFirst();
                System.out.println(deque);
            }else {
                deque.removeLast();
                System.out.println(deque);
            }
        }

    }
}
