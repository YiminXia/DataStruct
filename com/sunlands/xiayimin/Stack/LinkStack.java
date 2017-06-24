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
        return 0;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void push(Object x) throws Exception {

    }

    @Override
    public Object pop() {
        return null;
    }
}
