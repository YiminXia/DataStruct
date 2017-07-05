package com.sunlands.xiayimin.Stack;

/**
 * Created by 12754 on 2017/7/5.
 */
public class SqStack implements IStack{
    private Object[] stackElem;//对象数组

    private int top;//在非空栈中，top始终指向栈顶元素的下一个存储位置，当栈为空时，top的值为0

    /**
     *@param maxSize
     * 构造一个存储空间容量为maxSize的存储单元
     */
    public SqStack(int maxSize){
        top =0;
        stackElem=new Object[maxSize];
    }

    /**
     * 栈置空
     */
    @Override
    public void clear() {
        top=0;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top==0;
    }

    /**
     * 求栈的长度，也可以说求栈中元素的个数
     * @return
     */
    @Override
    public int length() {
        return top;
    }

    /**
     * 取栈顶元素
     * @return
     */
    @Override
    public Object peek() {
        if(!isEmpty()){
            return stackElem[top-1];
        }
        else{
            return null;
        }
    }

    /**
     * 顺序栈的入栈操作方法
     * @param x
     * @throws Exception
     */
    @Override
    public void push(Object x) throws Exception {//思考心得：top在这里有两个作用，代表顺序栈的长度（元素个数），指向下一个存储位置
        if(top==stackElem.length){
            throw new Exception("栈已满");
        }
        else{
            stackElem[top++]=x;
        }

    }

    /**
     * 顺序栈的出栈操作方法
     * @return
     * @throws Exception
     */
    @Override
    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("栈已经空了");
        }
        else{
            return stackElem[--top];
        }
    }
}
