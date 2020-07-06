package org.example.arithmetic.link;

/**
 * 有序单链表
 * @author hzq
 * @date 2020/6/29 14:11
 */
public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    public void insert(Link elem){
        Link curr = first;
        Link previous = null;
        while(curr != null && curr.value < elem.value){
            previous = curr;
            curr = curr.next;
        }
        if(previous == null){
            first = elem;
        }else{
            previous.next = elem;
        }
        elem.next = curr;
    }

    public Link removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = first;
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
