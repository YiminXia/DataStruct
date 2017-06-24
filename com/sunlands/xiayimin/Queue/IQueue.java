package com.sunlands.xiayimin.Queue;

/**
 * Created by 12754 on 2017/6/24.
 */
public interface IQueue {
    public void clear();
    public boolean isEmpty();
    public int length();
    public Object peek();
    public void offer(Object x)throws Exception;
    public Object poll();

}
