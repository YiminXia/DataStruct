package com.sunlands.xiayimin.List.Example;

import com.sunlands.xiayimin.List.LinkList;
import com.sunlands.xiayimin.List.Node;

import java.util.Scanner;

/**
 * Created by 12754 on 2017/7/3.
 * 编程实现两个有序的单链表LA跟LB合并成一个新的有序的单链表LA，LA跟LB是按照非递减排列的
 */
public class Example2_5 {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int m=0,n=0;
        System.out.println("请输入LA中的节点个数");
        m=sc.nextInt();
        System.out.println("请输入LB中的结点个数");
        n=sc.nextInt();
        System.out.println("请按非递减的方式输入"+m+"个数字");
        LinkList LA=new LinkList(m,true);
        System.out.println("请按非递减的方式输入"+n+"个数字");
        LinkList LB=new LinkList(n,true);
        System.out.println("合并之后");
        mergeList(LA,LB).display();
    }
    private static LinkList mergeList(LinkList LA,LinkList LB){
        Node pa=LA.head.next;
        Node pb=LB.head.next;
        Node p=LA.head;
        while(pa!=null&&pb!=null){
            if(Integer.valueOf((String)pa.data)<Integer.valueOf((String)pb.data)){
                p.next=pa;
                pa=pa.next;
            }
            else{
                p.next=pb;
                pb=pb.next;
            }
            p=p.next;
        }
        pa=(pa==null)?pb:pa;
        p.next=pa;
        return LA;
    }
}
