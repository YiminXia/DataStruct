package com.sunlands.xiayimin.Queue;

import com.sunlands.xiayimin.List.SqList;

/**
 * Created by sunlandsxym on 2017/6/26.
 */
public class Example3_5_1 {
    public boolean isPrime(int number){
        if(number<=1)return false;
        Double a=Math.sqrt(number);
        for (int i=2;i<=a.intValue();i++){
            if(number%i==0){
                return false;
            }
        }
        return true;

    }
    public SqList makePrimeRing(int number) throws Exception{
        SqList sqList=new SqList(number);
        sqList.insert(0,1);
        LinkQueue linkQueue=new LinkQueue();
        for(int i=2;i<=number;i++){
            linkQueue.offer(i);
        }
        return insertNumberToPrimeRing(sqList,linkQueue,2,number);
    }
    public SqList insertNumberToPrimeRing(SqList sqList,LinkQueue linkQueue,int m,int n)throws Exception{
        int count=0;
        while(!linkQueue.isEmpty()&&count<=n-m){
            int p=(Integer)sqList.get(sqList.length()-1);
            int q=(Integer)linkQueue.poll();
            if(m==n){
                if(isPrime(p+q)&&isPrime(q+1)){
                    sqList.insert(sqList.length(),q);
                    return sqList;
                }
                else {
                    linkQueue.offer(q);
                    count++;
                }
            }
            else if(isPrime(p+q)){
                sqList.insert(sqList.length(),q);
                if(insertNumberToPrimeRing(sqList,linkQueue,m+1,n)!=null){
                    return sqList;
                }
                else{
                    linkQueue.offer(q);
                    sqList.remove(sqList.length()-1);
                    count++;
                }
            }
            else{
                linkQueue.offer(q);
                count++;
               // sqList.remove(sqList.length()-1);
            }
        }
        return null;
    }



    public static void main(String[] args)throws Exception{
        Example3_5_1 test=new Example3_5_1();
        /*
        for(int i=1;i<10;i++){
            if(test.isPrime(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
         */
        test.makePrimeRing(8).display();
    }
}
