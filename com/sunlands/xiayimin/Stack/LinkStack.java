package com.sunlands.xiayimin.Stack;
import com.sunlands.xiayimin.List.Node;
/**
 * Created by sunlandsxym on 2017/6/24.
 */
public class LinkStack implements IStack{
    private Node top;

    //将栈置空
    @Override
    public void clear() {
        top=null;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }


    //求链栈的长度
    @Override
    public int length() {
        Node p=top;
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }

    @Override
    public Object peek() {
        if(!isEmpty()){
            return top.data;
        }
        else{
            return null;
        }
    }
    //入栈
    @Override
    public void push(Object x) throws Exception {
        Node p=new Node(x);
        p.next=top;
        top=p;

    }
   //出栈
    @Override
    public Object pop() {
         if(isEmpty()){
             return null;
         }
         else{
             Node p=top;
             top=top.next;
             return p.data;
         }
    }
}
