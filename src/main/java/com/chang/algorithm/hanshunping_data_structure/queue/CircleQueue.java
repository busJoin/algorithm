package com.chang.algorithm.hanshunping_data_structure.queue;

/**
 * 数组模拟环形队列
 */
public class CircleQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    //创建队列构造器
    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满了
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    //判断队列是否是空的
    public boolean isEmpty(){
        return front==rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已经满了");
            return;
        }
        arr[rear]=n;
        rear = (rear+1)%maxSize;
    }

    //获取队列的数据,出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        int value = arr[front];
        front=(front+1)%maxSize;
        return arr[value];
    }

    //显示所有的队列
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i= front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，但是不出队列
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front];
    }
}
