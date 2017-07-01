package com.sunlands.xiayimin.List;

import java.util.Scanner;

/**
 * Created by sunlandsxym on 2017/7/1.
 */
public class LinkList implements IList{
    public Node head;
    //无参的构造函数
    public LinkList(){
        head=new Node();//只构造了一个头结点
    }
    //有参构造函数,构造一个长度为n的单链表
    public LinkList(int n,boolean order)throws Exception{
        this();
        if(order){
        }
    }
    //使用尾插法顺序建立单链表，其中n为单链表的结点个数
    public void create1(int n)throws Exception{
        Scanner scanner=new Scanner(System.in);
       for(int i=0;i<n;i++){//这样会循环n次
            insert(length(),scanner.next());
       }
    }
    //使用头插法逆位序建立单链表，其中n为单链表的结点数
    public void create2(int n)throws Exception{
         Scanner scanner=new Scanner(System.in);
        for(int i=0;i<n;i++){
            insert(0,scanner.next());
        }
    }

    @Override
    public void clear() {
        head.data=null;
        head.next=null;
    }

    @Override
    public boolean isEmpty() {
        return head.next==null;
    }

    @Override
    public int length() {
        int length=0;     //length为计数器
        Node p=head.next; //p指向首结点
        while(p!=null){   //从首结点开始向后查，直到p为空
            length++;     //长度增加1
            p=p.next;     //指向后继结点
        }
        return length;
    }

    @Override
    public Object get(int i) throws Exception {//按位序号查找，其中i的取值范围是   0<=i<=n-1,主要思想是找到指向改结点的指针。
        Node p=head.next;//p指向首结点
        int count=0;     //count为计数器
        while(p!=null||count<i){//0到i，一共有i+1数，指针初始化在0头上，想把指针移动到i头上，需要移动i次，也就是说循环i次
            p=p.next;
            count++;
        }
        if(count>i||p==null){
            throw new Exception("元素不存在");
        }
        return p;
    }

    @Override
    public void insert(int i, Object x) throws Exception {//按位序号查找，其中i的取值范围是   0<=i<=n,主要思想是找到指向该结点的前驱结点。
        Node p=head;
        int count=-1;
        while(p!=null&&count<i-1){       //从-1找到i-1，指针现在在-1头上，想把指针移动到i-1头上，需要循环i次
            count++;
            p=p.next;
        }
        if(count>i-1||p==null){
            throw new Exception("该位置不存在");
        }
        Node newDemo=new Node(x);
        newDemo.next=p.next;
        p.next=newDemo;
    }

    @Override
    public void remove(int i) throws Exception {//i的取值范围是 0<=i<=n-1,中心思想也是找到i的前驱结点
        Node p=head;
        int count=-1;
        while(p.next!=null&&count<i-1){//现在指针在-1头上，希望将指针移动到i-1头上，需要循环i次
            p=p.next;
            count++;
        }
        if(count>i-1||p.next==null){
            throw new Exception("该元素不存在");
        }
        p.next=p.next.next;
    }

    @Override
    public int indexOf(Object x) {
        Node p=head.next;
        int count=0;
        while(p!=null&&!p.data.equals(x)){//指针在0头上，希望将将指针移动到i头上，这样要循环i次
            count++;
            p=p.next;
        }
        if(p==null){
            return -1;
        }
        return count;
    }

    @Override
    public void display() {
         Node p=head.next;
        while(p!=null){
            System.out.print(p.data+" ");
        }
        System.out.println();
    }
}
