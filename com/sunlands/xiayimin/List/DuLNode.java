package com.sunlands.xiayimin.List;

/**
 * Created by sunlandsxym on 2017/7/2.
 */
public class DuLNode {
    public Object data;
    public DuLNode prior;
    public DuLNode next;

    public DuLNode(){//无参数时的构造函数
        this(null);
    }
    public DuLNode(Object data){//构造数据域值为data的新节点
        this.data=data;
        this.prior=prior;
        this.next=next;
    }
}
