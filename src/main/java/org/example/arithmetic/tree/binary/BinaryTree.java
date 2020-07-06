package org.example.arithmetic.tree.binary;

import java.util.ArrayList;

/**
 * 二叉搜索树
 * @author hzq
 * @date 2020/7/1 10:34
 */
public class BinaryTree {
    
    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Node find(int key){
        Node cur = root;

        if(cur == null){
            return null;
        }

        while(cur.age != key){
            if(key < cur.age){
                //关键字比当前值小
                cur = cur.leftChild;
            } else {
                //关键字比当前值大
                cur = cur.rightChild;
            }
            //没有找到关键字,搜索结束
            if(cur == null){
                return null;
            }
        }
        return cur;
    }

    /**
     * 插入
     * @param node
     */
    public void insert(Node node){
        if(root == null){
            root = node;
        } else {
            Node cur = root;
            while(true){
                if(node.age < cur.age){
                    if(cur.leftChild == null){
                        cur.leftChild = node;
                        return;
                    }
                    cur = cur.leftChild;
                } else {
                    if(cur.rightChild == null){
                        cur.rightChild = node;
                        return;
                    }
                    cur = cur.rightChild;
                }
            }
        }
    }

    /**
     * 删除
     * @param node
     * @return
     */
    public boolean delete(Node node){
        if(root == null){
            return false;
        }

        //记录目标节点是否为父节点的左子节点
        boolean isLeftChild = true;

        //要删除的节点
        Node cur = root;

        //要删除节点的父节点
        Node parent = null;

        //确定要删除节点与它的父节点
        while(cur.age != node.age){
            parent = cur;
            if(node.age < cur.age){
                cur = cur.leftChild;
            } else {
                cur = cur.rightChild;
                isLeftChild = false;
            }
            if(cur == null){
                return false;
            }
        }

        if(cur.leftChild == null && cur.rightChild == null){
            //目标节点为叶子节点（无子节点）
            if(parent == null){
                //要删除的为根节点
                root = cur;
            } else if (isLeftChild){
                //要删除的不是根节点，则该节点肯定有父节点，该节点删除后，需要将父节点指向它的引用置空
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        } else if (cur.leftChild == null){
            //目标节点只有一个右节点
            if(parent == null){
                root = cur.rightChild;
            } else if (isLeftChild){
                parent.leftChild = cur.rightChild;
            } else {
                parent.rightChild = cur.rightChild;
            }

        } else if (cur.rightChild == null){
            //目标节点只有一个左节点
            if(parent == null){
                root = cur.leftChild;
            } else if (isLeftChild){
                parent.leftChild = cur.leftChild;
            } else {
                parent.rightChild = cur.leftChild;
            }

        } else {
            //目标节点有两个子节点
            //第一步要找到欲删除节点的后继节点
            Node successor = cur.rightChild;
            Node successorParent = null;
            while(successor.leftChild != null){
                successorParent = successor;
                successor = successorParent.leftChild;
            }

            if(successorParent == null){
                //欲删除节点的右子节点就是它的后继，证明该后继无左子节点，则将以后继节点为根的子树上移即可
                if(parent == null){
                    //要删除的为根节点，则将后继设置为根，且根的左子节点设置为欲删除节点的做左子节点
                    root = successor;
                    root.leftChild = cur.leftChild;
                } else if (isLeftChild){
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                } else {
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }

            } else {
                //欲删除节点的后继不是它的右子节点
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = cur.rightChild;
                if(parent == null){
                    root = successor;
                    root.leftChild = cur.leftChild;
                } else if (isLeftChild){
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                } else {
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            }
        }
        return true;
    }

    /**
     * 前序遍历
     */
    public static final int PREORDER = 1;

    /**
     * 中序遍历
     */
    public static final int INORDER = 2;

    /**
     * 后序遍历
     */
    public static final int POSTORDER = 3;

    public void traverse(int type){
        switch (type){
            case 1:
                System.out.print("前序遍历: \t");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("中序遍历: \t");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("后序遍历: \t");
                postOrder(root);
                System.out.println();
                break;
        }
    }

    public void postOrder(Node node) {
        if(node != null){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.age + "\t");
        }
    }

    public void inOrder(Node node) {
        if(node != null){
            inOrder(node.leftChild);
            System.out.println(node.age + "\t");
            inOrder(node.rightChild);
        }
    }

    public void preOrder(Node node) {
        if(node != null){
            System.out.println(node.age + "\t");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 用迭代方法来获取左子树和右子树的最大深度，返回两者最大值
     * @param node
     * @param initDeep
     * @return
     */
    private int getDepth(Node node, int initDeep){
        int deep = initDeep;
        int leftDeep = initDeep;
        int rightDeep = initDeep;
        if(node.leftChild != null){
            leftDeep = getDepth(node.leftChild, deep + 1);
        }
        if(node.rightChild != null){
            rightDeep = getDepth(node.rightChild, deep + 1);
        }
        return Math.max(leftDeep,rightDeep);
    }

    /**
     * 获取树的最大深度
     * @return
     */
    public int getTreeDepth(){
        if(root == null){
            return 0;
        }
        return getDepth(root,1);
    }

    /**
     * 获取最大值
     * @return
     */
    public Node getMax(){
        if(root == null){
            return null;
        }
        Node cur = root;
        while(cur.rightChild != null){
            cur = cur.rightChild;
        }
        return cur;
    }

    /**
     * 获取最小值
     * @return
     */
    public Node getMin(){
        if(root == null){
            return null;
        }
        Node cur = root;
        while(cur.leftChild != null){
            cur = cur.leftChild;
        }
        return cur;
    }

    public void displayTree(){
        int depth = getTreeDepth();
        ArrayList<Node> currentLayerNodes = new ArrayList<Node>();
        currentLayerNodes.add(root);

        int layerIndex = 1;
        while(layerIndex <= depth){
            //在节点之前和之后应该打印几个空位
            int nodeBlankNum = (int)Math.pow(2, depth - layerIndex) - 1;
            for (int i = 0; i < currentLayerNodes.size(); i++) {
                Node node = currentLayerNodes.get(i);
                //打印节点之前的空位
                printBlank(nodeBlankNum);
                if(node == null){
                    System.out.print("*\t");
                } else {
                    System.out.print("*  " + node.age + "\t");
                }
                printBlank(nodeBlankNum);
                System.out.print("*\t");
            }
            System.out.println();
            layerIndex++;
            //获取下一层所有的节点
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);
        }
    }

    private ArrayList<Node> getAllNodeOfThisLayer(ArrayList<Node> parentNodes) {
        ArrayList<Node> list = new ArrayList<Node>();
        Node parentNode = null;
        for (int i = 0; i < parentNodes.size(); i++) {
            parentNode = parentNodes.get(i);
            if(parentNode != null){
                if(parentNode.leftChild != null){
                    //如果上层的父节点存在左子节点，加入集合
                    list.add(parentNode.leftChild);
                } else {
                    //如果上层的父节点不存在左子节点，用null代替，一样加入集合
                    list.add(null);
                }
                if(parentNode.rightChild != null){
                    list.add(parentNode.rightChild);
                } else {
                    //如果上层父节点不存在，用两个null占位，代表左右子节点
                    list.add(null);
                }

            } else {
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }

    private void printBlank(int num) {
        for(int i = 0;i < num; i++){
            System.out.print("*\t");
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean isLeaf(Node node){
        return node.leftChild != null || node.rightChild != null;
    }

    public Node getRoot(){
        return root;
    }
}
