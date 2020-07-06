package org.example.arithmetic.tree.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzq
 * @date 2020/7/3 10:35
 */
public class HuffmanTree {

    private Node root;
    private Map<String, String> map = new HashMap<>();

    public HuffmanTree(Node root) {
        this.root = root;
        buildCodeSet(root, "");
    }

    /**
     * 生成编码集的私有方法，运用了迭代的思想
     * 参数currentNode表示当前节点，参数currentCode代表当前节点对应的代码
     * @param currentNode
     * @param currentCode
     */
    private void buildCodeSet(Node currentNode, String currentCode) {
        if(currentNode.getKey() != null){
            //霍夫曼树中，如果当前节点包含关键字，则该节点肯定是叶子节点，将该关键字和代码放入代码集
            map.put(currentNode.getKey(), currentCode);
        } else {
            //转向左子节点需要将当前代码追加0
            buildCodeSet(currentNode.getLeft(), currentCode+"0");
            //转向右子节点需要将当前代码追加1
            buildCodeSet(currentNode.getRight(), currentCode+"1");
        }
    }

    public Map<String, String> getMap() {
        return map;
    }
}
