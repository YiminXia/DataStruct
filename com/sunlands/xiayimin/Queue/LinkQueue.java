package com.sunlands.xiayimin.Queue;
import com.sunlands.xiayimin.List.Node;
/**
 * Created by 12754 on 2017/6/24.
 */
public class LinkQueue implements IQueue {
    private Node front;//队首指针

    private Node rear;//队尾指针

    //链队列类的
    //public LinkQueue(){
    //    front=rear=null;
    //}

    //链队列置空
    @Override
    public void clear() {
        front=rear=null;
    }

    //链队判空
    @Override
    public boolean isEmpty() {
        return front==null;
    }

    //求队列的长度
    @Override
    public int length() {
        Node p=front;
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }
    //取队首的元素
    @Override
    public Object peek() {
        if(front!=null) return front.data;
        else return null;
    }
   //队列入队的操作,入队绝大部分情况也只是涉及rear一个指针的操作，只有在空队列的时候，涉及两个指针的操作。
    @Override
    public void offer(Object x) throws Exception {
         Node p=new Node(x);
        if(front!=null){//队列非空
            rear.next=p;
            rear=p;
        }
        else{//队列为空
            front=p;
            rear=p;
        }
    }
   //出队，出队绝大部分情况只涉及front一个指针的操作，只有队列只有一个元素的时候涉及到两个指针的操作。
    @Override
    public Object poll() {
        if(front!=null){//链队列不空
            Node p=front;
            front=front.next;
            if(p==rear){
                rear=null;
            }
            return p.data;
        }
        else return null;
    }
    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }
}
