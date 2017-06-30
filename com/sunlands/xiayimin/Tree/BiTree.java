package com.sunlands.xiayimin.Tree;
import com.sunlands.xiayimin.Queue.LinkQueue;
import com.sunlands.xiayimin.Stack.LinkStack;
/**
 * Created by sunlandsxym on 2017/6/24.
 */
public class BiTree {
    private BiTreeNode root;//树的根节点

    public BiTree(){     //无参的构造函数，构造一棵空树
        this.root=null;
    }
    public BiTree(BiTreeNode root){//构造一棵树
        this.root=root;
    }
    public void preRootTraverse(BiTreeNode T){
        if(T!=null){
            System.out.print(T.data+" ");
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    public void preRootTraverse()throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);
            while(!S.isEmpty()){
                T=(BiTreeNode)S.pop();
                System.out.print(T.data+" ");
                while(T!=null){//容易卡住的地方
                    if(T.lchild!=null){
                        System.out.print(T.lchild.data+" ");
                    }
                    if(T.rchild!=null){
                        S.push(T.rchild);
                    }
                    T=T.lchild;
                }
            }
        }
    }
    public void inRootTraverse(BiTreeNode T){
        if(T!=null){
            inRootTraverse(T.lchild);
            System.out.println(T.data);
            inRootTraverse(T.rchild);
        }
    }
    public void inRootTraverse() throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);//根结点入栈
            while(!S.isEmpty()){
                while(S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
                S.pop();
                if(!S.isEmpty()){
                    T=(BiTreeNode)S.pop();
                    System.out.print(T.data+" ");
                    S.push(T.rchild);
                }
            }
        }
    }
    public void postRootTraverse(BiTreeNode T){
        if(T!=null){
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.println(T.data);
        }
    }

    public void postRootTraverse()throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);
            boolean flag;
            BiTreeNode p=null;
            while(!S.isEmpty()){
                while(S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
                S.pop();
                while(!S.isEmpty()){
                    T=(BiTreeNode)S.peek();
                    if(T.rchild==null||T.rchild==p){
                        S.pop();
                        System.out.print(T.data+" ");
                        flag=true;
                        p=T;
                    }
                    else{
                        S.push(T.rchild);
                        flag=false;
                    }
                    if(!flag){
                        break;
                    }
                }
            }
        }
    }
    public void levelBiTreeTraverse()throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkQueue Q=new LinkQueue();
            Q.offer(T);//根节点入队
            while(!Q.isEmpty()){
                T=(BiTreeNode)Q.poll();
                System.out.print(T.data+" ");
                if(T.lchild!=null){
                    Q.offer(T.lchild);
                }
                if(T.rchild!=null){
                    Q.offer(T.rchild);
                }
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

