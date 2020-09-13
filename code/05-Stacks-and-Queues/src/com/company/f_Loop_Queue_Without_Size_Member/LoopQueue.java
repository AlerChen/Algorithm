package com.company.f_Loop_Queue_Without_Size_Member;

public class LoopQueue<E> implements Queue<E> {

    /*-- property --*/
    private E[] data;//数组数据
    //private int size;//元素个数 本作业不用size维护,使用data.length维护
    private int front,tail;//头尾指针

    /*-- public method --*/
    public LoopQueue(int capacity){
        // 多留一个空位,为了区别 :
        //  front == tail 为队列空,
        //  (tail + 1) % data.length == front 为队列满.
        data = (E[])new Object[capacity +1];
        //size = 0;
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

    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            // 队列满
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        //size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        //size --;
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
        for (int i = 0; i < data.length; i++) {
            // 个人写法
            // newData[i] = data[front];
            // front = (front + 1) % data.length;
            // 老师写法
            newData[i] = data[(i + front) % data.length];
        }
        // new data
        data = newData;
        front = 0;
        tail = data.length;
    }

    @Override
    public String toString() {

        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue: size = %d, capacity = %d \n",data.length,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail ; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail){
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
