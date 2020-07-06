package org.example.arithmetic.link;

/**
 * @author hzq
 * @date 2020/6/28 17:09
 */
public class Link {

    public String name;
    public int value;
    public Link next;

    public Link(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void displayLink(){
        System.out.println("name: " + name + "\t" + "value: " + value);
    }
}
