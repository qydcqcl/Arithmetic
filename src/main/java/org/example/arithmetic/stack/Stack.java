package org.example.arithmetic.stack;

/**
 * @author hzq
 * @date 2020/6/28 15:18
 */
public class Stack {

    /**
     * 栈大小
     */
    private int size;

    /**
     * 栈顶元素下标
     */
    private int top;

    /**
     * 栈容器
     */
    private int[] stackArray;

    public Stack(int size) {
        stackArray = new int[size];
        this.size = size;
        //初始化栈的时候，栈内无元素，栈顶下标设为-1
        top = -1;
    }

    /**
     * 入栈
     * @param elem
     */
    public void push(int elem){
        stackArray[++top] = elem;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        return stackArray[top--];
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }
}
