package com.sunlands.xiayimin.Tree.Exercise;

import com.sunlands.xiayimin.Stack.LinkStack;
import com.sunlands.xiayimin.Tree.BiTreeNode;
import sun.awt.image.ImageWatched;

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
                      S.push(T.rchild); //绝对不会有空节点入栈
                  }
                  T = T.lchild;
              }
          }

      }
   }

    /**
     * 二叉树先根遍历递归算法
     *
     * @param root  根节点
     * @throws Exception
     */
   public void preRootTraverse(BiTreeNode root) throws Exception {
       if (root != null) {
           System.out.print(root.data + " ");
           preRootTraverse(root.lchild);
           preRootTraverse(root.rchild);
       }
    }

   public  void inRootTraverse() throws Exception{
       BiTreeNode T = root;
       if (T != null) {
           LinkStack S = new LinkStack();
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


   public void postRootTraverse() throws Exception{
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
                      System.out.print(T.data + " ");
                      S.pop();
                      flag = true;
                      p = T;
                  } else {
                      S.push(T.rchild);
                      flag = false;
                  }

                  if (!flag) {
                      break;
                  }
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
