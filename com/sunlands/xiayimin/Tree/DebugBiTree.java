package com.sunlands.xiayimin.Tree;

/**
 * Created by 12754 on 2017/6/30.
 */
public class DebugBiTree {
    public BiTree createBiTree(){
        BiTreeNode d=new BiTreeNode("D");
        BiTreeNode g=new BiTreeNode("G");
        BiTreeNode h=new BiTreeNode("H");
        BiTreeNode e=new BiTreeNode("E",g,null);
        BiTreeNode b=new BiTreeNode("B",d,e);
        BiTreeNode f=new BiTreeNode("F",null,h);
        BiTreeNode c=new BiTreeNode("C",f,null);
        BiTreeNode a=new BiTreeNode("A",b,c);
        return new BiTree(a);
    }
    public static void main(String[] args)throws Exception{
        DebugBiTree debugBiTree=new DebugBiTree();
        BiTree biTree =debugBiTree.createBiTree();
        BiTreeNode root = biTree.getRoot();

        biTree.preRootTraverse();
        System.out.println();
        biTree.inRootTraverse();
        System.out.println();
        biTree.postRootTraverse();
    }



}
