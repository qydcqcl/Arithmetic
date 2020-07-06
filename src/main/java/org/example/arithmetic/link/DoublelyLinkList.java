package org.example.arithmetic.link;

/**
 * @author hzq
 * @date 2020/6/29 15:41
 */
public class DoublelyLinkList {

    private TwoWayLink first;
    private TwoWayLink last;

    public DoublelyLinkList() {
        first = null;
        last = null;
    }

    public void insertFirst(TwoWayLink elem){
        if(isEmpty()){
            last = elem;
        } else {
            first.previous = elem;
        }
        first.next = first;
        first = elem;
    }

    public void insertLast(TwoWayLink elem){
        if(isEmpty()){
            first = elem;
        } else {
            elem.previous = last;
            last.next = elem;
        }
        last = elem;
    }

    public TwoWayLink removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        TwoWayLink temp = first;
        if(first.next == null){
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public TwoWayLink removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        TwoWayLink temp = last;
        if(last.previous == null){
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public TwoWayLink find(int key){
        TwoWayLink cur = first;
        while(cur != null && cur.value != key){
            if(cur.next == null){
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }

    public boolean insertAfter(TwoWayLink elem){
        TwoWayLink target = find(elem.value);
        boolean flag = true;
        if(target == null){
            flag = false;
        } else {
            if(target.next == null){
                insertLast(elem);
            } else {
                target.next.previous = elem;
                elem.next = target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
                target.next = elem;
                elem.previous = target;
            }
        }
        return flag;
    }

    //打印出所有的链表元素
    public void displayList(){
        TwoWayLink cur = first;
        while(cur != null){  //循环打印每个链结点
            cur.displayLink();
            cur = cur.next;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }
}
