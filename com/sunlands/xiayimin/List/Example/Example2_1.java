package com.sunlands.xiayimin.List.Example;

import com.sunlands.xiayimin.List.SqList;

/**
 * Created by sunlandsxym on 2017/7/2.
 * 编程实现，建立一个顺序表，查找顺序表中第一次出现值为‘z’的数据元素，返回其位置
 */
public class Example2_1 {
    public static void main(String[] args)throws Exception{
        SqList sqList=new SqList(10);
        sqList.insert(0,'a');
        sqList.insert(1,'z');
       // int index=sqList.indexOf('z');
        System.out.print(sqList.indexOf('z'));
    }
}
