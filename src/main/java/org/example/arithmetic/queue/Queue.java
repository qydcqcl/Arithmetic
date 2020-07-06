package org.example.arithmetic.queue;

/**
 * @author hzq
 * @date 2020/6/28 15:32
 */
public class Queue {

    private int[] queueArr;

    private int maxSize;

    /**
     * 队头元素的下标
     */
    private int front;

    /**
     * 队尾元素的下标
     */
    private int rear;

    /**
     * 队列长度
     */
    private int lenght;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArr = new int[maxSize];
        front = 0;
        rear = -1;
        lenght = 0;
    }

    public void insert(int elem) throws Exception {
        if(isFull()){
            throw new Exception("队列已满，不能进行插入操作！");
        }
        //如果队尾指针已到达数组的末端，插入到数组的第一个位置
        if(rear == maxSize - 1){
            rear = -1;
        }
        queueArr[++rear] = elem;
        lenght++;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列为空，不能进行移除操作！");
        }
        int elem = queueArr[front++];
        //如果队头指针已到达数组末端，则移到数组第一个位置
        if(front == maxSize){
            front = 0;
        }
        lenght--;
        return elem;
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列内没有元素！");
        }
        return queueArr[front];
    }

    public int size(){
        return size();
    }

    public boolean isEmpty(){
        return lenght == 0;
    }

    public boolean isFull(){
        return lenght == maxSize;
    }
}
