package com.sunlands.xiayimin.Tree.Exercise;

import com.sunlands.xiayimin.Stack.LinkStack;
import com.sunlands.xiayimin.Tree.BiTreeNode;

/**
 * Created by sunlandsxym on 2017/7/5.
 */
public class BiTree {
    private BiTreeNode root;

    public BiTree(){//构造一棵空树
        root = null;
    }
    public BiTree(BiTreeNode root){
        this.root = root;
    }

    /**
     * 先根遍历非递归算法
     *
     * @throws Exception 异常
     */
   public void preRootTraverse() throws Exception{
        BiTreeNode T = root;
        if (T != null) { //如果跟结点不为null
            LinkStack linkStack = new LinkStack(); //创建一个链栈
            linkStack.push(T); //根节点入栈
            while (!linkStack.isEmpty()) { //栈不空，因为栈里面的元素都是没访问过的
                T = (BiTreeNode) linkStack.pop();
                System.out.println(T.data);
                while (T != null){
                    if (T.lchild != null) {
                       System.out.println(T.lchild.data);
                    }
                    if (T.rchild != null) {
                        linkStack.push(T.rchild);
                    }
                    T = T.lchild;
                }
            }
        }
   }


}
