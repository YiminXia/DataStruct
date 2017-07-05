package com.sunlands.xiayimin.Tree.Exercise;

import com.sunlands.xiayimin.Stack.LinkStack;
import com.sunlands.xiayimin.Tree.BiTreeNode;

/**
 * Created by sunlandsxym on 2017/7/5.
 */
public class BiTree {
    private BiTreeNode root;

    public BiTree(){//构造一棵空树
        root=null;
    }
    public BiTree(BiTreeNode root){
        this.root=root;
    }

    /**
     * 递归先根遍历
     */
     public void preRootTraverse(BiTreeNode root){
         if(root!=null){
             System.out.print(root.data+" ");
             preRootTraverse(root.lchild);
             preRootTraverse(root.rchild);
         }
     }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    /**
     * 非递归先根遍历
     */
    public void preRootTraverse()throws Exception{
        BiTreeNode p=root;
        if(p!=null){
            LinkStack linkStack=new LinkStack();
            linkStack.push(p);
            while(!linkStack.isEmpty()){
                p=(BiTreeNode)linkStack.pop();
                System.out.print(p.data+" ");
                while(p!=null){
                    if(p.lchild!=null){
                        System.out.print(p.lchild.data+" ");
                    }
                    if(p.rchild!=null){
                        linkStack.push(p.rchild);
                    }
                    p=p.lchild;
                }
                /*
                while(p.lchild!=null){//这么写是不对的，因为p的左孩子是空的，但是右孩子不空
                    System.out.print(p.lchild.data+" ");
                    if(p.rchild!=null){
                        linkStack.push(p.rchild);
                    }
                    p=p.lchild;
                }
                */
            }
        }
    }
    public void inRootTraverse(BiTreeNode root){
        if(root!=null){
            inRootTraverse(root.lchild);
            System.out.print(root.data+" ");
            inRootTraverse(root.rchild);
        }
    }
    public void inRootTraverse()throws Exception{
        BiTreeNode p=root;
        if(p!=null){
            LinkStack linkStack=new LinkStack();
            linkStack.push(p);
            while(!linkStack.isEmpty()){
                while(linkStack.peek()!=null){
                    linkStack.push(((BiTreeNode)linkStack.peek()).lchild);
                }
                linkStack.pop();
                if(!linkStack.isEmpty()){
                    p=(BiTreeNode)linkStack.pop();
                    System.out.print(p.data+" ");
                    linkStack.push(p.rchild);//右结点
                }
            }


        }
    }
}
