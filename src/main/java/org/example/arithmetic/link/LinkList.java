package org.example.arithmetic.link;

/**
 * 单向链表
 * @author hzq
 * @date 2020/6/28 17:12
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(Link elem){
        elem.next = first;
        first = elem;
    }

    public Link deleteFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        Link cur = first;
        while(cur != null){
            cur.displayLink();
            cur = cur.next;
        }
    }

    public Link delete(int key){
        Link link = null;
        Link cur = first;
        Link next = first.next;
        Link previous = null;
        while(cur != null){
            if(key == cur.value){
                link = cur;
                if(previous == null){
                    first = next;
                }else{
                    previous.next = next;
                }
                break;
            } else if (next == null){
                break;
            }
            cur = cur.next;
            next = next.next;
            previous = cur;
        }
        return link;
    }

    public Link find(int key){
        Link link = null;
        Link cur = first;
        Link next = cur.next;

        while(cur != null){
            if(cur.value == key){
                link = cur;
                break;
            }else if(next == null){
                break;
            }
            cur = next;
            next = next.next;
        }
        return link;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(new Link("2",2));
        linkList.insertFirst(new Link("4",4));
        linkList.insertFirst(new Link("3",3));
        linkList.insertFirst(new Link("5",5));
        linkList.insertFirst(new Link("1",1));

        linkList.displayList();
        System.out.println("=======================");

        Link link = linkList.find(2);
        link.displayLink();
        System.out.println("=======================");

        Link delete = linkList.delete(1);
        linkList.displayList();
    }
}
