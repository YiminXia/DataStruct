package com.sunlands.xiayimin.List.Example;

import com.sunlands.xiayimin.List.LinkList;
import com.sunlands.xiayimin.List.Node;

/**
 * Created by 12754 on 2017/7/3.
 * 实现一个单链表，然后删除单链表中的“重复结点”
 */
public class Example2_4 {
    public static void main(String[] args)throws Exception{
        System.out.println("请输入单链表中的10个节点值");
        LinkList list=new LinkList(10,true);
        System.out.println("删除之前各个节点值为：");
        list.display();
        removeRepeatElem(list);
        System.out.println("删除之后各个节点值为：");
        list.display();
    }
    private static void removeRepeatElem(LinkList list)throws Exception{
        Node p=list.head.next;
        while(p.next!=null){//s d s a r a e r v a
            int index=list.indexOf(p.data);
            Node iterior=p.next;
            index=index+1;
            while(iterior!=null){
                if(p.data.equals(iterior.data)){
                    list.remove(index);
                }
                else{
                    index++;
                }
                iterior=iterior.next;
            }
            p=p.next;
            if(p==null)
                break;
        }
    }
}
