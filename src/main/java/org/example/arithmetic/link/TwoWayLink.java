package org.example.arithmetic.link;

/**
 * @author hzq
 * @date 2020/6/29 15:39
 */
public class TwoWayLink {

    public String name;
    public int value;

    public TwoWayLink next;
    public TwoWayLink previous;

    public TwoWayLink(String name, int value) {
        this.name = name;
        this.value = value;
    }

    //打印该链结点的信息
    public void displayLink(){
        System.out.println("name:"+name+",value:"+value);
    }
}
