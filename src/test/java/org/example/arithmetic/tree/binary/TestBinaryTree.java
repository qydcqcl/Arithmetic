package org.example.arithmetic.tree.binary;

import org.junit.Test;

/**
 * @author hzq
 * @date 2020/7/2 13:45
 */
public class TestBinaryTree {

    public static BinaryTree tree;

    static {
        tree = new BinaryTree();
        tree.insert(new Node(10, "10"));
        tree.insert(new Node(7, "7"));
        tree.insert(new Node(20, "20"));
        tree.insert(new Node(6, "6"));
        tree.insert(new Node(8, "8"));
        tree.insert(new Node(12, "12"));
        tree.insert(new Node(25, "25"));
    }

    @Test
    public void testDisplayTree(){
        tree.displayTree();
    }

    @Test
    public void testInsert(){
        tree.insert(new Node(15,"15"));
        tree.displayTree();
    }

    @Test
    public void testFind(){
        Node node = tree.find(12);
        node.displayNode();
    }

    @Test
    public void testDelete(){
        tree.delete(new Node(10,"10"));
        tree.displayTree();
    }

    @Test
    public void testPreOrder(){
        tree.traverse(1);
    }

    @Test
    public void testInOrder(){
        tree.traverse(2);
    }

    @Test
    public void testPostOrder(){
        tree.traverse(3);
    }

    @Test
    public void testGetMax(){
        Node max = tree.getMax();
        max.displayNode();
    }

    @Test
    public void testGetMin(){
        Node min = tree.getMin();
        min.displayNode();
    }
}
