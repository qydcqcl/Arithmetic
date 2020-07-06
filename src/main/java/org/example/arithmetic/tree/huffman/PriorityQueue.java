package org.example.arithmetic.tree.huffman;

/**
 * 用于辅助创建霍夫曼树的优先级队列
 * @author hzq
 * @date 2020/7/3 10:03
 */
public class PriorityQueue {

    private Node first;
    private int lenght;

    public PriorityQueue() {
        lenght = 0;
        first = null;
    }

    public void insert(Node node){
        if(first == null){
            first = node;
        } else {
            Node cur = first;
            Node previous = null;
            //定位要插入位置的前一个节点和后一个节点
            while(cur.getFrequency() < node.getFrequency()){
                previous = cur;
                if(cur.getNext() == null){
                    cur = null;
                    break;
                } else {
                    cur = cur.getNext();
                }
            }

            if(previous == null){
                //插入队头
                node.setNext(cur);
                first = node;
            } else if (cur == null){
                //插入队尾
                previous.setNext(node);
            } else {
                //插入两个节点之间
                previous.setNext(node);
                node.setNext(cur);
            }
        }
        lenght++;
    }

    /**
     * 删除对头元素
     * @return
     */
    public Node delete(){
        Node temp = first;
        first = first.getNext();
        lenght--;
        return temp;
    }

    public int getLenght(){
        return lenght;
    }

    public void display(){
        Node cur = first;
        System.out.print("优先级队列：\t");
        while(cur != null){
            System.out.print(cur.getKey()+":"+cur.getFrequency()+"\t");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public HuffmanTree buildHuffmanTree(){
        while (lenght > 1){
            //取出队列的第一个节点作为新节点的左子节点
            Node left = delete();
            //取出队列的第二个节点作为新节点的右子节点
            Node right = delete();
            //新节点的权值等于左右子节点的权值之和
            Node node = new Node(left.getFrequency() + right.getFrequency());
            node.setLeft(left);
            node.setRight(right);
            insert(node);
        }
        //最后队列中只剩一个节点，即为霍夫曼树的根节点
        return new HuffmanTree(first);
    }
}
