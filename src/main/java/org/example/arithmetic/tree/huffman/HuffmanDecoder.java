package org.example.arithmetic.tree.huffman;

import java.util.Iterator;
import java.util.Map;

/**
 * @author hzq
 * @date 2020/7/3 11:27
 */
public class HuffmanDecoder {

    private Map<String, String> codeSet;

    public HuffmanDecoder(Map<String, String> codeSet) {
        this.codeSet = codeSet;
    }

    public String decode(String code){
        String message = "";
        String key = "";
        char [] chars = code.toCharArray();
        for(int i = 0; i < chars.length;i++){
            key += chars[i];
            if(codeSet.containsValue(key)){
                //代码集中存在该段代码
                Iterator it = codeSet.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry entry = (Map.Entry)it.next();
                    if(entry.getValue().equals(key)){
                        //获取该段代码对应的键值，即消息字符
                        message += entry.getKey();
                    }
                }
                //代码段变量置为0
                key = "";
            }else{
                //该段代码不能解析为文本消息，继续循环
                continue;
            }
        }
        return message;
    }
}
