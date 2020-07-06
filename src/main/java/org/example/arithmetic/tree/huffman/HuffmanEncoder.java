package org.example.arithmetic.tree.huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hzq
 * @date 2020/7/3 11:10
 */
public class HuffmanEncoder {

    /**
     * 助建立霍夫曼树的优先级队列
     */
    private PriorityQueue queue;

    /**
     * 霍夫曼树
     */
    private HuffmanTree tree;

    /**
     * 以数组的形式存储消息文本
     */
    private String[] message;

    /**
     * 存储字符以及词频的对应关系
     */
    private Map<String, Integer> keyMap;

    /**
     * 存储字符以及代码的对应关系
     */
    private Map<String, String> codeSet;

    public HuffmanEncoder() {
        queue = new PriorityQueue();
        keyMap = new HashMap<>();
    }

    /**
     * 编码
     * @param msg
     * @return
     */
    public String encode(String msg){
        resolveMassage(msg);
        buildCodeSet();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<message.length;i++){//将消息文本的逐个字符翻译成霍夫曼编码
            sb.append(codeSet.get(message[i]));
        }
        return sb.toString();
    }

    private void buildCodeSet() {
        Iterator it = keyMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            //用该字符和该字符的词频为参数，建立一个新的节点，插入优先级队列
            queue.insert(new Node(entry.getValue(), entry.getKey()));
        }
        queue.display();
        //利用优先级队列生成霍夫曼树
        tree = queue.buildHuffmanTree();
        //获取霍夫曼树对应的代码集
        codeSet = tree.getMap();
    }

    /**
     * 将一段字符串消息解析成单个字符与该字符词频的对应关系，存入Map
     * @param msg
     */
    private void resolveMassage(String msg) {
        //将消息转换成字符数组
        char [] chars = msg.toCharArray();
        message = new String[chars.length];
        for(int i = 0;i<chars.length;i++){
            //将当前字符转换成字符串
            String key = chars[i] + "";
            message[i] =  key;
            if(keyMap.containsKey(key)){
                //如果Map中已存在该字符，则词频加一
                keyMap.put(key, keyMap.get(key) + 1);
            } else {
                //如果Map中没有该字符，加入Map
                keyMap.put(key,1);
            }
        }
    }

    /**
     * 打印该段消息的代码集
     */
    public void printCodeSet(){
        Iterator it = codeSet.entrySet().iterator();
        System.out.println("代码集：");
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getKey()+"——>"+entry.getValue());
        }
        System.out.println();
    }

    public Map<String, String> getCodeSet() {
        return codeSet;
    }
}
