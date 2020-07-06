package org.example.arithmetic.queue;

/**
 * @author hzq
 * @date 2020/6/28 16:47
 */
public class PriorityQueue {

    private int[] queueArr;

    /**
     * 最大值
     */
    private int maxSize;

    /**
     * 队列长度
     */
    private int lenght;

    /**
     * 基准点
     */
    private int referencePoint;

    public PriorityQueue(int maxSize, int referencePoint) {
        this.maxSize = maxSize;
        this.referencePoint = referencePoint;
        queueArr = new int[maxSize];
        lenght = 0;
    }

    public void insert(int elem) throws Exception{
        if(isFull()){
            throw new Exception("队列已满，不能进行插入操作！");
        }

        if(lenght == 0){
            queueArr[lenght++] = elem;
        } else {
            int i ;
            for (i = lenght; i > 0; i--){
                int dis = Math.abs(elem - referencePoint);
                int curdis = Math.abs(queueArr[i - 1] - referencePoint);
                if(dis >= curdis){
                    queueArr[i] = queueArr[i - 1];
                } else {
                    break;
                }
                queueArr[i] = elem;
                lenght++;
            }
        }
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列为空，不能进行移除操作！");
        }
        int elem = queueArr[--lenght];
        return elem;
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列内没有元素！");
        }
        return queueArr[lenght - 1];
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
