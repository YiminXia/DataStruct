package com.sunlands.xiayimin.Stack;
import com.sunlands.xiayimin.List.Node;
/**
 * Created by sunlandsxym on 2017/6/24.
 */
public class LinkStack implements IStack{
    private Node top;//栈顶元素的引用

    /**
     * 将栈置空
     */
    @Override
    public void clear() {
        top=null;
    }

    /**
     * 判断链栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top==null;
    }

    /**
     * 求链栈的长度
     * @return
     */
    @Override
    public int length() {
        int count=0;
        Node p=top;
        while(p!=null){
            count++;
            p=p.next;//p初始化指向栈顶元素，当p被移动到指向null时候，指针p移动了整个栈的长度，也就是循环了长度的次数
        }
        return count;
    }

    /**
     * 取栈顶元素，并返回其值
     * @return
     */
    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }
        else{
            return top.data;
        }
    }

    @Override
    public void push(Object x) throws Exception {
        Node node=new Node(x);
        node.next=top;
        top=node;
    }

    @Override
    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("栈为空");
        }
        else{
            Node p=top;
            top=top.next;
            return p.data;
        }
    }
}
