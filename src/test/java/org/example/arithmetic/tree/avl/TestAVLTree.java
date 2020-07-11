package org.example.arithmetic.tree.avl;

import org.junit.Test;

/**
 * @author hzq
 * @date 2020/7/6 11:50
 */
public class TestAVLTree {

    @Test
    public void testInsert(){
        AVLTree tree = new AVLTree();
        int[] arr = {3,2,1,4,5,6};
        for (int i : arr) {
            tree.insert(i);
        }
        System.out.println(tree.root);
        System.out.println("======================");
        tree.insert(7);
        System.out.println(tree.root);
    }
}
