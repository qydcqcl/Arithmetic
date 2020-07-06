package org.example.arithmetic.tree.avl;

/**
 * @author hzq
 * @date 2020/7/4 11:11
 */
public class AVLTree {

    private Node root;

    /**
     * 插入操作的入口
     * @param value
     */
    public void insert(long value){
        root = insert(root, value);
    }

    /**
     * 插入的递归实现
     * @param subTree
     * @param value
     * @return
     */
    private Node insert(Node subTree, long value) {
        if(subTree == null){
            return new Node(value, null,null);
        }
        if(value < subTree.value){
            //插入到左子树
            subTree = insert(subTree.left, value);
            if(unbalanceTest(subTree)){
                //插入造成失衡
                if(value < subTree.left.value){
                    //LL型失衡
                    subTree = leftLeftRotation(subTree);
                } else {
                    //LR型失衡
                    subTree = leftRightRotation(subTree);
                }
            }

        } else if(value > subTree.value){
            //插入到右子树
            subTree = insert(subTree.right, value);
            if(unbalanceTest(subTree)){
                if(value > subTree.right.value){
                    //RR型失衡
                    subTree = rightRightRotation(subTree);
                } else {
                    //RL型失衡
                    subTree = rightLeftRotation(subTree);
                }
            }

        } else {
            throw new RuntimeException("duplicate value: " + value);
        }
        return subTree;
    }

    private Node rightLeftRotation(Node subTree) {
        return null;
    }

    private Node rightRightRotation(Node k1) {
        Node k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    private Node leftRightRotation(Node subTree) {
        return null;
    }

    private Node leftLeftRotation(Node k2) {
        Node k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private boolean unbalanceTest(Node subTree) {
        int leftHeight = getDepth(subTree.left, 1);
        int rightHeight = getDepth(subTree.right, 1);
        int diff = Math.abs(leftHeight - rightHeight);
        return diff > 1;
    }

    private int getDepth(Node node, int initHeight) {
        if(node == null){
            return initHeight;
        }

        int leftHeight = initHeight;
        int rightHeight = initHeight;
        if(node.left != null){
            leftHeight = getDepth(node.left, initHeight++);
        }
        if(node.right != null){
            rightHeight = getDepth(node.right, initHeight++);
        }
        return Math.max(leftHeight, rightHeight);
    }
}
