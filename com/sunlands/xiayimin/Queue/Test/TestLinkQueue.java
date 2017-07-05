package com.sunlands.xiayimin.Queue.Test;

import com.sunlands.xiayimin.Queue.LinkQueue;

/**
 * Created by sunlandsxym on 2017/7/5.
 */
public class TestLinkQueue {
    public static void main(String[] args){
        LinkQueue linkQueue=new LinkQueue();
        if(linkQueue.getFront()==null&&linkQueue.getRear()==null){
            System.out.println("linkQueue.getFront()==null&&linkQueue.getRear()==null");
        }
    }
}
