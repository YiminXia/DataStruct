package com.sunlands.xiayimin.Queue;

import com.sunlands.xiayimin.List.SqList;

public class Example3_5 {


    public boolean isPrime(int num){
        if(num==1) return false;
        Double n=Math.sqrt(num);
        for(int i=2;i<=n.intValue();i++){
           if(num%i==0)
               return false;
        }
        return true;
    }
    public SqList makePrimeRing(int n)throws Exception{
        if(n%2!=0){
            throw new Exception("素数环不存在");
        }
        SqList sqList=new SqList(n);
        sqList.insert(0,1);//初始化一个顺序表的首节点为1；
        LinkQueue linkQueue=new LinkQueue();
        for(int i=2;i<=n;i++){
            linkQueue.offer(i);
        }
        //return insertRing();
        return insertRing(sqList,linkQueue,2,n);
    }

    public  SqList insertRing(SqList sqList,LinkQueue linkQueue,int m,int n)throws NumberFormatException,Exception{
        int count =0;
        while(!linkQueue.isEmpty()&&count<=n-m){
            int p=(Integer)linkQueue.poll();
            int q=(Integer)sqList.get(sqList.length()-1);
            if(m==n){
                if(isPrime(q+p)&&isPrime(p+1)){
                    sqList.insert(sqList.length(),p);
                    return sqList;
                }
                else{
                    linkQueue.offer(p);
                }
            }
            else if(isPrime(p+q)){
                sqList.insert(sqList.length(),p);
                if(insertRing(sqList,linkQueue,m+1,n)!=null){
                    return sqList;
                }
                sqList.remove(sqList.length()-1);
                linkQueue.offer(p);
            }
            else{
                linkQueue.offer(p);
            }
            count++;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Example3_5 test=new Example3_5();
        SqList sqList=test.makePrimeRing(6);
        sqList.display();
    }
}
