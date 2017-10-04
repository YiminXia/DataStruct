package com.sunlands.xiayimin.Tree;

import com.sunlands.xiayimin.Queue.LinkQueue;
import com.sunlands.xiayimin.Stack.LinkStack;
/**
 * Created by sunlandsxym on 2017/6/24.
 */
public class BiTree {
    private BiTreeNode root; //树的根节点

    public BiTree(){     //无参的构造函数，构造一棵空树
        this.root = null;
    }
    public BiTree(BiTreeNode root){//构造一棵树
        this.root = root;
    }
    public void preRootTraverse(BiTreeNode T){
        if(T!=null){
            System.out.print(T.data+" ");
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    public void preRootTraverse()throws Exception{
        BiTreeNode T = root;
        if (T != null) {
            LinkStack S = new LinkStack();
            S.push(T);
            while (!S.isEmpty()) {
                T = (BiTreeNode) S.pop();
                System.out.print(T.data + " ");
                while (T != null) {
                    if (T.lchild != null) {
                        System.out.print(T.lchild.data + " ");
                    }
                    if (T.rchild != null) {
                        S.push(T.rchild);
                    }
                    T = T.lchild;
                }
            }
        }
    }
    public void inRootTraverse(BiTreeNode T){
        if(T!=null){
            inRootTraverse(T.lchild);
            System.out.print(T.data+" ");
            inRootTraverse(T.rchild);
        }
    }
    public void inRootTraverse() throws Exception{
        BiTreeNode T = root;
        if (T != null){
           LinkStack S =  new LinkStack();
           S.push(T);
           while (!S.isEmpty()) {
               while (S.peek() != null) {
                   S.push(((BiTreeNode) S.peek()).lchild);
               }
               S.pop();
               if (!S.isEmpty()) {
                   T = (BiTreeNode) S.pop();
                   System.out.print(T.data + " ");
                   S.push(T.rchild);
               }
           }
        }
    }

    /**
     * 二叉树遍历递归算法
     *
     * @param T 二叉树结点
     */
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.print(T.data + " ");
        }
    }
    /**
     * 后根遍历非递归算法
     *
     * @throws Exception 异常
     */
    public void postRootTraverse()throws Exception{
       BiTreeNode T = root;
       if (T != null) {
           LinkStack S = new LinkStack();
           S.push(T);
           boolean flag;
           BiTreeNode p = null;
           while (!S.isEmpty()) {
               while (S.peek() != null) {
                   S.push(((BiTreeNode) S.peek()).lchild);
               }
               S.pop();
               while (!S.isEmpty()) {
                   T = (BiTreeNode) S.peek();
                   if (T.rchild == null || T.rchild == p) {
                       System.out.print(T.data);
                       S.pop();
                       flag = true;
                       p = T;
                   } else {
                       S.push(T.rchild);
                       flag = false;
                   }
                   if (!flag){
                       break;
                   }
               }
           }
       }
    }

    /**
     * 层次遍历二叉树
     */
    public void levelBiTreeTraverse()throws Exception{
        LinkQueue linkQueue=new LinkQueue();
        BiTreeNode p=root;
        linkQueue.offer(p);
        while(!linkQueue.isEmpty()){
            p=(BiTreeNode)linkQueue.poll();
            System.out.print(p.data+" ");
            if(p.lchild!=null){
                linkQueue.offer(p.lchild);
            }
            if(p.rchild!=null){
                linkQueue.offer(p.rchild);
            }
        }
    }


    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

}

