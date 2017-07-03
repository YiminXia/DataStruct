package com.sunlands.xiayimin.Tree.Exercise;

import com.sunlands.xiayimin.Stack.LinkStack;
import com.sunlands.xiayimin.Tree.BiTreeNode;

/**
 * Created by 12754 on 2017/7/3.
 */
public class ExcerciseBiTree {
    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    private BiTreeNode root;//树的根节点

    public ExcerciseBiTree(){                 //无参的构造函数，构造一棵空树
        this.root=null;
    }
    public ExcerciseBiTree(BiTreeNode root){  //构造一棵树，
        this.root=root;
    }


    /**
     * 递归先根遍历二叉树
     */
    public void preRootTraverse(BiTreeNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            preRootTraverse(root.lchild);
            preRootTraverse(root.rchild);
        }
    }

    /**
     * 非递归先根遍历二叉树
     */
     public void preRootTraverse()throws Exception{
         BiTreeNode p=root;
         LinkStack linkStack=new LinkStack();
         linkStack.push(p);//根节点入栈
         while(!linkStack.isEmpty()){//
             p=(BiTreeNode)linkStack.pop();//栈首结点出栈
             System.out.print(p.data+" ");
             while(p!=null){//
                 if(p.rchild!=null){
                     linkStack.push(p.rchild);
                 }
                 if(p.lchild!=null){
                     System.out.print(p.lchild.data+" ");
                 }
                 p=p.lchild;
             }
         }
     }
    /**
     * 递归中根遍历
     */
     public void inRootTraverse(BiTreeNode root){
         if(root!=null){
             inRootTraverse(root.lchild);
             System.out.print(root.data+" ");
             inRootTraverse(root.rchild);
         }
     }
    /**
     * 非递归遍历二叉树
     */
    public void inRootTraverse()throws Exception{
        BiTreeNode p=root;
        LinkStack linkStack=new LinkStack();
        linkStack.push(p);
        while(!linkStack.isEmpty()){
            while(linkStack.peek()!=null){
                linkStack.push(((BiTreeNode)linkStack.peek()).lchild);
            }
            linkStack.pop();
            if(!linkStack.isEmpty()){//if的判断条件
                p=(BiTreeNode)linkStack.pop();
                System.out.print(p.data+" ");
                linkStack.push(p.rchild);
            }
        }
    }
    /**
     *
     */
    public void postRootTraverse(BiTreeNode root){
        if(root!=null){
            postRootTraverse(root.lchild);
            postRootTraverse(root.rchild);
            System.out.print(root.data+" ");
        }
    }
    /**
     *
     */
    public void postRootTraverse()throws Exception{
        BiTreeNode p=root;
        LinkStack linkStack=new LinkStack();
        linkStack.push(p);
        boolean flag;
        BiTreeNode t=null;
        while(!linkStack.isEmpty()){
            while(linkStack.peek()!=null){
                linkStack.push(((BiTreeNode)linkStack.peek()).lchild);
            }
            linkStack.pop();
            while(!linkStack.isEmpty()){
                p=(BiTreeNode)linkStack.peek();
                if(p.rchild==null||p.rchild==t){
                    System.out.print(p.data+" ");
                    linkStack.pop();
                    t=p;
                    flag=true;
                }else{
                    linkStack.push(p.rchild);
                    flag=false;
                }
                if(!flag){
                    break;
                }
            }
        }
    }

}
