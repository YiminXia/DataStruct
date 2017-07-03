package com.sunlands.xiayimin.List.Example;

import com.sunlands.xiayimin.List.LinkList;
import com.sunlands.xiayimin.List.Node;

import java.util.Scanner;

/**
 * Created by 12754 on 2017/7/3.
 */
public class PolynList extends LinkList {

    public PolynList(int n)throws Exception{
        head.data=new PolynNode(0,-1);//初始化头结点，头结点的data为系数是0，指数是-1
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=n;i++){//循环n次
            double coef=sc.nextDouble();
            int expn=sc.nextInt();
            insert(new PolynNode(coef,expn));
        }
    }
    public void insert(PolynNode node)throws Exception{
        int j=0;
        while(j<length()){//按照这样，最多循环length()次，如果比第i位小，就插入第i位，后面的向后移动。
            PolynNode p=(PolynNode) get(j);
            if(p.expn>node.expn){//1 2 4
                break;
            }
            j++;
        }
        insert(j,node);
    }
    public int cmp(PolynNode a,PolynNode b){
        if(a.expn<b.expn){
            return -1;
        }
        else if(a.expn>b.expn){
            return 1;
        }
        else{
            return 0;
        }
    }
    public PolynList addPolynList(PolynList LA,PolynList LB){
        Node pa=LA.head.next;
        Node pb=LB.head.next;
        Node p=LA.head;
        while(pa!=null&&pb!=null){
            PolynNode a=(PolynNode)pa.data;
            PolynNode b=(PolynNode)pb.data;
            switch(cmp(a,b)){
                case -1:
                    p.next=pa;
                    pa=pa.next;
                    p=p.next;
                    break;
                case 0:
                    double sum=((PolynNode) pa.data).coef+((PolynNode) pb.data).coef;
                    if(sum!=0.0){
                        a.coef=sum;
                        p.next=pa;
                        pa=p;
                        pa=pa.next;
                        pb=pb.next;
                    }else{
                        pa=pa.next;
                        pb=pb.next;
                    }
                    break;
                case 1:
                    p.next=pb;
                    p=pb;
                    pb=pb.next;
                    break;
            }
        }
        p.next=(pa!=null?pa:pb);
        return LA;
    }
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入A多项式的项数：");
        int m=scanner.nextInt();
        System.out.println("A的系数与指数");
        PolynList LA=new PolynList(m);
        System.out.println("请输入B多项式的项数：");
        int n=scanner.nextInt();
        System.out.println("B的系数与指数");
        PolynList LB=new PolynList(n);
        LA=LA.addPolynList(LA,LB);
        LA.display();
    }
    public void display(){
        for(int i=0;i<length();i++){
            try{
                PolynNode e=(PolynNode)get(i);
                System.out.print("系数为："+e.coef+"指数为："+e.expn);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
