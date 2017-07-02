package com.sunlands.xiayimin.List.Test;

import com.sunlands.xiayimin.List.DuLinkList;

/**
 * Created by sunlandsxym on 2017/7/2.
 * 测试双向回环链表
 */
public class TestDuLinkList {
    public static void main(String[] args)throws Exception{
        DuLinkList test=new DuLinkList(5);
        test.display();
        test.remove(4);
        test.display();
    }
}
