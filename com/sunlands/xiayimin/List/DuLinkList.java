package com.sunlands.xiayimin.List;

import java.util.Scanner;

/**
 * Created by sunlandsxym on 2017/7/2.
 */
public class DuLinkList implements IList{
    public DuLNode head;//双向循环列表的头结点

    public DuLinkList(){
        head=new DuLNode();//初始化头结点
        head.prior=head;//初始化头结点的前驱跟后继
        head.next=head;
    }

    public DuLinkList(int n)throws Exception{
        this();
        Scanner sc=new Scanner(System.in);
        for(int j=0;j<n;j++){
            insert(0,sc.next());
        }
    }



    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Object get(int i) throws Exception {
        return null;
    }

    @Override
    public void insert(int i, Object x) throws Exception {//i的取值范围是 0<=i<=n,双向列表直接找到指向i的指针即可。
        DuLNode p=head.next;
        int count=0;
        while(p!=head&&count<i){//指针现在在0的头上，希望将指针移动到i的头上，循环i次
            p=p.next;
            count++;
        }
        if(count!=i&&p!=head){
            throw new Exception("该元素不存在");
        }
        DuLNode demo=new DuLNode(x);
        demo.prior=p.prior;
        demo.next=p;
        p.prior.next=demo;
        p.prior=demo;
    }

    @Override
    public void remove(int i) throws Exception {//i的取值范围是0<=i<=n-1
        DuLNode p=head.next;
        int count=0;
        while(p!=head&&count<i){
            p=p.next;
            count++;
        }
        //if(count>i||p==head){
        if(count!=i){
            throw new Exception("删除位置不合理");
        }
        p.prior.next=p.next;
        p.next.prior=p.prior;
    }

    @Override
    public int indexOf(Object x) {
        return 0;
    }

    @Override
    public void display() {
        DuLNode node =head.next;
        while(node!=head){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }
}
