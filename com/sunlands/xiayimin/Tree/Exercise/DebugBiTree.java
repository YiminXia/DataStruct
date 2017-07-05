package com.sunlands.xiayimin.Tree.Exercise;


import com.sunlands.xiayimin.Tree.BiTreeNode;

/**
 * Created by 12754 on 2017/6/30.
 */
public class DebugBiTree {
    public com.sunlands.xiayimin.Tree.Exercise.BiTree createBiTree(){
        BiTreeNode d=new BiTreeNode("D");
        BiTreeNode g=new BiTreeNode("G");
        BiTreeNode h=new BiTreeNode("H");
        BiTreeNode e=new BiTreeNode("E",g,null);
        BiTreeNode b=new BiTreeNode("B",d,e);
        BiTreeNode f=new BiTreeNode("F",null,h);
        BiTreeNode c=new BiTreeNode("C",f,null);
        BiTreeNode a=new BiTreeNode("A",b,c);
        return new com.sunlands.xiayimin.Tree.Exercise.BiTree(a);
    }

    /**
     * @param args
     * @throws Exception
     *                                  A
     *                                 / \
     *                                B   C
     *                               / \  /
     *                              D   E F
     *                                 /   \
     *                                G     H
     */
    public static void main(String[] args)throws Exception{
        DebugBiTree debugBiTree=new DebugBiTree();
       // BiTree biTree =debugBiTree.createBiTree();
       // BiTree biTree = debugBiTree.createBiTree();
        BiTree biTree=debugBiTree.createBiTree();
        BiTreeNode root = biTree.getRoot();

        System.out.println("先根遍历：");
        biTree.preRootTraverse(biTree.getRoot());
        System.out.println();
        biTree.preRootTraverse();
        System.out.println();
        System.out.println("--------------");

        System.out.println("中根遍历：");
        biTree.inRootTraverse();
        System.out.println();
        biTree.inRootTraverse(biTree.getRoot());
        System.out.println();
        System.out.println("--------------");
 /*
        System.out.println("后根遍历：");
        biTree.postRootTraverse();
        System.out.println();
        biTree.postRootTraverse(biTree.getRoot());
        System.out.println();
        System.out.println("--------------");

        System.out.println("层次遍历：");
        biTree.levelBiTreeTraverse();
        */
    }



}
