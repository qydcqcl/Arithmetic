package org.example.arithmetic.link;

/**
 * 双端链表
 * @author hzq
 * @date 2020/6/28 18:05
 */
public class DoubleEndList {

    private Link first;
    private Link last;

    public DoubleEndList() {
        first = null;
        last = null;
    }

    public void insertFirst(Link elem){
        if(isEmpty()){
            last = elem;
        }
        elem.next = first;
        first = elem;
    }

    public void insertLast(Link elem){
        if(isEmpty()){
            first = elem;
        } else {
            last.next = elem;
        }
        last = elem;
    }

    public Link removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = first;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList(){
        Link cur = first;
        //循环打印每个链结点
        while(cur != null){
            cur.displayLink();
            cur = cur.next;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }
}
