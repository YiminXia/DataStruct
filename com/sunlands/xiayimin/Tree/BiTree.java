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
            System.out.println(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    public void preRootTraverse()throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);//根节点入栈
            while(!S.isEmpty()){//栈里面的元素都是没有访问过得，所以一旦栈空了就代表便利结束了
                T=(BiTreeNode)S.pop();//栈首结点出栈，
                System.out.print(T.data+" ");//访问栈首结点
                while(T!=null){//
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
            S.push(T);//根节点入栈
            while(!S.isEmpty()){
                while(S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
                S.pop();//空节点退栈
                if(!S.isEmpty()){
                    T=(BiTreeNode)S.pop();
                    System.out.print(T.data+" ");
                    S.push(T.rchild);//右结点
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

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    public void postRootTraverse()throws Exception{
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);//根结点入栈
            Boolean flag;//访问标志
            BiTreeNode p=null;//访问结点
            while(!S.isEmpty()){
                while(S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
                S.pop();
                while(!S.isEmpty()){
                    T=(BiTreeNode)S.peek();
                    if(T.rchild==null||T.rchild==p){
                        System.out.print(T.data+" ");
                        S.pop();
                        p=T;
                        flag=true;
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


}

