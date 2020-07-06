package org.example.arithmetic.tree.binary;

/**
 * @author hzq
 * @date 2020/6/30 16:01
 */
public class Node {

    int age;
    String name;

    /**
     * 左子节点的引用
     */
    Node leftChild;

    /**
     * 右子节点的引用
     */
    Node rightChild;

    public Node(int age,String name){
        this.age = age;
        this.name = name;
    }

    /**
     * 打印该节点的信息
     */
    public void displayNode(){
        System.out.println("name:"+name+",age:"+age);
    }
}
