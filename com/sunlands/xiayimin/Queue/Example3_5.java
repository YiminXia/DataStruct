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
            linkQueue.offer(i);//将2-n插入到队列中
        }
        //return insertRing();
        return insertRing(sqList,linkQueue,2,n);
    }

    /**
     *
     * @param sqList
     * @param linkQueue
     * @param m(代表的是要插入第几个数，m=2代表要插入第二个数，m=n代表插入第n个数也就是最后一个数)
     * @param n
     * @return（返回一个顺序表，里面放置组成素数环的整数）
     * @throws NumberFormatException
     * @throws Exception
     */
    public  SqList insertRing(SqList sqList,LinkQueue linkQueue,int m,int n)throws NumberFormatException,Exception{
        int count =0;
        while(!linkQueue.isEmpty()&&count<=n-m){//链队列不为空，并且m小于等于n
            int p=(Integer)linkQueue.poll();//出队
            int q=(Integer)sqList.get(sqList.length()-1);//取表最后一个值，并不是remove()函数
            if(m==n){                    //如果：插入的数字是剩下的最后一个数字
                if(isPrime(q+p)&&isPrime(p+1)){//如果：最后一个数字符合素数环的条件
                    sqList.insert(sqList.length(),p);
                    return sqList;
                }
                else{                          //如果：最后一个数字不符合符合素数环的条件
                    linkQueue.offer(p);
                }
            }
            else if(isPrime(p+q)){       //如果：插入的数字不是剩下的最后一个数字，且符合素数环的条件
                sqList.insert(sqList.length(),p);
                if(insertRing(sqList,linkQueue,m+1,n)!=null){
                    return sqList;               //如果：插入的数字不是剩下的最后一个数字，且符合素数环的条件，且剩下的没插入的也符合素数环的条件
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
        SqList sqList=test.makePrimeRing(18);
        sqList.display();
    }
}
