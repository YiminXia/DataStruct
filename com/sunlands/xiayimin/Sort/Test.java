package com.sunlands.xiayimin.Sort;

/**
 * Created by 12754 on 2017/9/22.
 */
public class Test {
    /**
     * 主函数
     *
     * @param args java命令行与主函数交互的参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception{
        SeqList seqList = new SeqList(10);
        seqList.curlen = 10;
        seqList.r[0] = new RecordNode(9);
        seqList.r[1] = new RecordNode(8);
        seqList.r[2] = new RecordNode(7);
        seqList.r[3] = new RecordNode(6);
        seqList.r[4] = new RecordNode(5);
        seqList.r[5] = new RecordNode(4);
        seqList.r[6] = new RecordNode(3);
        seqList.r[7] = new RecordNode(2);
        seqList.r[8] = new RecordNode(1);
        seqList.r[9] = new RecordNode(0);
        seqList.showSortArray();

      //  seqList.r[0] = new RecordNode(52);
      //  seqList.r[1] = new RecordNode(39);
      //  seqList.r[2] = new RecordNode(67);
      // seqList.r[3] = new RecordNode(95);
      //  seqList.r[4] = new RecordNode(70);
      //  seqList.r[5] = new RecordNode(8);
      //  seqList.r[6] = new RecordNode(25);
      //  seqList.r[7] = new RecordNode(52);
     //   seqList.r[8] = new RecordNode(56);
      //  seqList.r[9] = new RecordNode(5);
      //  seqList.showSortArray();

        //插入排序
    //    seqList.insertSort();
     //   seqList.showSortArray();
        //希尔排序
       // seqList.shellSort(new int[]{5, 3, 1});
       // seqList.showSortArray();

        //冒泡排序
    //    seqList.bubbleSort();
   //     seqList.showSortArray();

        //快速排序
    //    seqList.quickSort();
    //    seqList.showSortArray();

        //选择排序
        seqList.selectSort();
        seqList.showSortArray();

        //归并排序
    //    seqList.mergeSort();
    //    seqList.showSortArray();
    }

}
