package com.sunlands.xiayimin.LittleGames;

/**
 * Created by sunlandsxym on 2017/6/30.
 * 500个小孩手拉手排成一圈，从第一个小孩开始，没数三个，干死一个，问当只剩下最后一个小孩的编号是多少
 *
 */

class LittleKid{
    protected LittleKid next;
    protected LittleKid prior;
    protected int number;
    public LittleKid(int number){
        next=null;
        prior=null;
        this.number=number;
    }

    public LittleKid getNext() {
        return next;
    }

    public void setNext(LittleKid next) {
        this.next = next;
    }

    public LittleKid getPrior() {
        return prior;
    }

    public void setPrior(LittleKid prior) {
        this.prior = prior;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class Circle{
    private LittleKid head;
    private LittleKid last;
    public Circle(){
        head=null;
        last=null;
    }
    public Circle(int totle){
         this();
        for(int i=1;i<=totle;i++){
            LittleKid demo=new LittleKid(i);
            insetKid(demo);
        }
    }
    public void insetKid(LittleKid kid){//尾插法
        if(isEmpty()){
            head=kid;
            last=kid;
            kid.next=kid;
            kid.prior=kid;
        }
        else{
            kid.prior=last;
            kid.next=last.next;
            last.next.prior=kid;
            last.next=kid;
            last=kid;
        }

    }
    public boolean isEmpty(){
        return head==null;
    }
    public void remove(LittleKid kid){
        if(kid==head){
            head=kid.next;
        }
        kid.getPrior().next= kid.next;
        kid.getNext().prior=kid.prior;
    }



    public LittleKid getHead() {
        return head;
    }

    public void setHead(LittleKid head) {
        this.head = head;
    }

    public LittleKid getLast() {
        return last;
    }

    public void setLast(LittleKid last) {
        this.last = last;
    }
}

public class KillGame {
    public static void main(String[] args){
        Circle test=new Circle(500);
      //  System.out.println(test.getHead().next.number);
      //  System.out.println(test.getLast().getNumber());
        int count=1;
        int counttotle=1;
        LittleKid p=test.getHead();
        while(counttotle<500){//这样会删除操作会执行499次
            if(count==3){
                test.remove(p);
                count=0;
                counttotle++;
            }
            p=p.next;
            count++;
        }
        System.out.println(test.getHead().getNumber());
    }



}
