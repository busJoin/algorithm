package com.chang.algorithm.atguigu.hanshunping_data_structure.queue;

//使用数组来模拟一个ArrayQueue
public class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    //创建队列构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满了
    public boolean isFull(){
        return rear==maxSize-1;
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
        rear++;
        arr[rear]=n;
    }

    //获取队列的数据,出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        front++;
        return arr[front];
    }

    //显示所有的队列
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i= 0;i<maxSize;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，但是不出队列
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front+1];
    }
}
