package com.sunlands.xiayimin.Tree;
import com.sunlands.xiayimin.Queue.LinkQueue;
import com.sunlands.xiayimin.Stack.LinkStack;
/**
 * Created by sunlandsxym on 2017/6/24.
 */
public class BiTree {
    private BiTreeNode root;//树的根节点

    public BiTree(){     //无参的构造函数，构造一棵空树，根节点指向null就是一颗空树
        this.root=null;
    }
    public BiTree(BiTreeNode root){//构造一棵树，只要有一个根节点就算有一棵树了
        this.root=root;
    }
    public void preRootTraverse(BiTreeNode T){
        if(T!=null){
            System.out.print(T.data+" ");
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    public void preRootTraverse()throws Exception{//先根遍历只有右孩子入栈，根节点与左孩子，都是直接访问了
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);//根节点入栈
            while(!S.isEmpty()){//栈里面的元素都是右孩子结点+根节点
                T=(BiTreeNode)S.pop();//栈首结点出栈，
                System.out.print(T.data+" ");//访问栈首结点
                while(T!=null){//这里应该将T看成是，其父亲结点的左孩子，必须保证T不为空,才能继续循环
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
            System.out.print(T.data+" ");
            inRootTraverse(T.rchild);
        }
    }
    public void inRootTraverse() throws Exception{//中根遍历，
        BiTreeNode T=root;
        if(T!=null){
            LinkStack S=new LinkStack();
            S.push(T);//根节点入栈
            while(!S.isEmpty()){
                while(S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
                S.pop();//空节点退栈
                if(!S.isEmpty()){//if的判断条件,老是卡(qia)住
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
            System.out.print(T.data+" ");
        }
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

    /**
     * 层次遍历方法
     */
    public void  levelBiTreeTraverse()throws Exception{
        BiTreeNode p=root;
        LinkQueue linkQueue=new LinkQueue();
        linkQueue.offer(p);
        while(!linkQueue.isEmpty()){//队列中的都是未被访问的元素，所以非空代表没有遍历完全
            p=(BiTreeNode)linkQueue.poll();
            if(p.lchild!=null){
                linkQueue.offer(p.lchild);
            }
            if(p.rchild!=null){
                linkQueue.offer(p.rchild);
            }
            System.out.print(p.data+" ");
        }
        System.out.println();
    }
    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

}

