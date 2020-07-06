package org.example.arithmetic.tree.huffman;

/**
 * @author hzq
 * @date 2020/7/3 9:57
 */
public class Node {

    /**
     * 树节点存储的关键字，如果是非叶子节点为空
     */
    private String key;

    /**
     * 关键字词频
     */
    private int frequency;

    /**
     * 左子树
     */
    private Node left;

    /**
     * 右子树
     */
    private Node right;

    /**
     * 优先级队列中指向下一个节点的引用
     */
    private Node next;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public Node(int frequency, String key) {
        this.frequency = frequency;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
