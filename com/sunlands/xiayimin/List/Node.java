package com.sunlands.xiayimin.List;

/**
 * Created by 12754 on 2017/6/24.
 */
public class Node {
    public Object data;
    public Node next;

    public Node(){
        this(null,null);
    }
    public Node (Object data){
        this(data,null);
    }

    public Node(Object data,Node next){
        this.data=data;
        this.next=next;
    }

}
