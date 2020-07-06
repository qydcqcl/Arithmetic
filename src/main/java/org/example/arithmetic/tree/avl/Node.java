package org.example.arithmetic.tree.avl;

/**
 * @author hzq
 * @date 2020/7/4 11:10
 */
public class Node {

    long value;
    Node left;
    Node right;

    public Node(long value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
