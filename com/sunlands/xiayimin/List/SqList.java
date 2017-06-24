package com.sunlands.xiayimin.List;

/**
 * Created by 12754 on 2017/6/24.
 */
public class SqList implements IList{
    private Object[] listElem;
    private int curlen;

    public SqList(int maxSize){
        curlen=0;
        listElem=new Object[maxSize];
    }

    @Override
    public void clear() {
        curlen=0;
    }

    @Override
    public boolean isEmpty() {
        return curlen==0;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public Object get(int i) throws Exception {
        if(i<0||i>curlen-1){//i小于0或者大于表长减一，i的有效值域为从0到curlen-1
           throw new Exception("第"+i+"个元素不存在");
        }
        return listElem[i];
    }


    //在线性表的第i个数据元素之前插入一个值为x的数据元素
    @Override
    public void insert(int i, Object x) throws Exception{//其中i的取值范围是  0<=i<=curlen
         if(curlen==listElem.length){//判断顺序表是否已经满了
             throw new Exception("顺序表已经满了无法插入数据");
         }
         if(curlen<i||0>i){
             throw new Exception("插入位置不合法");
         }
         else{
             int p=curlen;
             while(p>i){
                 listElem[p]=listElem[p-1];
                 p--;//p=i+1时候回执行,将listElem[i]赋值给listElem[i+1]
             }
             listElem[i]=x;
         }
         curlen++;
    }

    @Override
    public void remove(int i) throws Exception{//其中i的取值范围是 0<=i<=curlen-1
        if(curlen==0){//先判断线性表是否为空
            throw new Exception("表为空无法插入");
        }
        if(i<0||i>curlen-1){
            throw new Exception("移除位置不合法");
        }
        for(int j=i+1;j<curlen;j++){
            listElem[j-1]=listElem[j];
        }
        curlen--;
    }

    @Override
    public int indexOf(Object x) {
        int j=0;
        while(j<curlen&&!listElem[j].equals(x)){
            j++;
        }
        if(j<curlen)
            return j;
        else
            return -1;
    }

    @Override
    public void display() {
          for(int j=0;j<curlen;j++)
              System.out.print(listElem[j]+" ");
        System.out.println();
    }
}
