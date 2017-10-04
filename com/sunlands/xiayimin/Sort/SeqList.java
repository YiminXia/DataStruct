package com.sunlands.xiayimin.Sort;


/**
 * Created by 12754 on 2017/9/19.
 */
public class SeqList {
    public RecordNode[] r; //顺序表记录结点数组
    public int curlen; //顺序表长度，即记录个数

    public SeqList(int maxSize) {
        this.r = new RecordNode[maxSize];
        this.curlen = 0;
    }

    /**
     * 在当前顺序表的第i个节点之前插入一个RecordNode类型的结点x
     *
     * @param i i的取值范围是0---curlen
     * @param x 将要插入的RecordNode类对象
     * @throws Exception 自定义异常
     */
    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) {
            throw new Exception("顺序表已满");
        }
        if (i < 0 || i > curlen) {
           throw new Exception("插入位置不合理");
        }
        for (int j = curlen; j > i; j--) { //相当于将 位置：i———curlen-1的元素 平移 i+1————curlen
            r[j] = r[j - 1];
        }
        r[i] = x;
        curlen++;
    }

    /**
     * 插入排序法
     * i从1---------curlen-1
     * j从i-1--------0
     */
    public void insertSort() {
        RecordNode temp;
        int i;
        int j;
        for (i = 1; i < curlen; i++) {
            temp = r[i];
            for (j = i - 1; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param d 距离数组
     */
    public void shellSort(int[] d) {
        RecordNode temp;
        int i;
        int j;
        int k;
        for (k = 0; k < d.length; k++) {
            int dk = d[k];
            for (i = dk; i < curlen; i = i + dk) {
                temp = r[i];
                for (j = i - dk; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j = j - dk) {
                    r[j + dk] = r[j];
                }
                r[j + dk] = temp;
            }
        }
    }

    /**
     *冒泡排序
     * i从1------curlen-1
     * j从0-------curlen-i-1
     *
     */
    public void bubbleSort() {
        RecordNode temp;
        int i;
        int j;
        boolean flag = true;
        for (i = 1; i < curlen && flag; i++) {
            for (j = 0; j < curlen - i; j++) {
                flag = false;
                if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) {
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 交换排序表r[i....j]的记录，使支点记录到位，并返回其所在位置
     * 此时，在支点之前（后）的记录关键字值均不大于（小于）它
     *
     * @param i 数组的开头
     * @param j 数组的结尾
     * @return 返回支点为值
     */
    public int partition(int i, int j) {
        RecordNode pivot = r[i];
        while (i < j) {
            while (i < j && r[j].getKey().compareTo(pivot.getKey()) > 0) {
                j--;
            }
            if (i < j){
                r[i] = r[j];
                i++;
            }
            while (i < j && r[i].getKey().compareTo(pivot.getKey()) <= 0) {
                i++;
            }
            if (i < j) {
                r[j] = r[i];
                j--;
            }
        }
        r[i] = pivot;
        return i;
    }

    /**
     * 对子表r[low...high]快速排序
     *
     * @param low  子表的开头
     * @param high 子表的结尾
     */
    public void qSort(int low, int high) {
       if (low < high) {
           int pivotloc = partition(low, high);
           qSort(low, pivotloc - 1);
           qSort(pivotloc + 1, high);
       }
    }

    /**
     * 对顺序表r[0...curlen - 1]快速排序
     */
    public void quickSort() {
        qSort(0, curlen - 1);
    }

    /**
     * 选择排序
     * i从0---------curlen-2
     * j从i+1---------curlen-1
     */
    public void selectSort() {
        RecordNode temp;
        int i;
        int j;
        for (i = 0; i < curlen - 1; i++){
            for (j = 1 + i; j < curlen; j++) {
                if (r[i].getKey().compareTo(r[j].getKey()) > 0) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
            }
        }
    }

    /**
     * 把r数组中两个相邻的有序表r[h]----r[m]和r[m+1]----r[t]归并为一个有序表order[h]----order[t]
     *
     * @param r       待归并的记录数组r
     * @param order   归并之后的数组order
     * @param h       参数
     * @param m       参数
     * @param t       参数
     */
    public void merge(RecordNode[] r, RecordNode[] order, int h, int m, int t) {
        int i = h;
        int j = m + 1;
        int k = h;
        while (i <= m && j <= t) {
            if (r[i].getKey().compareTo(r[j].getKey()) < 0) {
                order[k++] = r[i];
            } else {
                order[k++] = r[j++];
            }
        }
        while (i <= m) {
            order[k++] = r[i++];
        }
        while (j <= t) {
            order[k++] = r[j++];
        }
    }

    /**
     * 一趟归并排序算法
     *
     * @param r      参数
     * @param order  参数
     * @param s      待归并子序列的长度
     * @param n      待排序列的长度
     */
    public void mergepass(RecordNode[] r, RecordNode[] order, int s, int n) {
        int p = 0;
        while (p + 2 * s - 1  <= n - 1) {
            merge(r, order, p, p + s - 1, p + 2 * s - 1);
            p = p + 2 * s;
        }
        if (p + s - 1 <= n - 1) {
           merge(r, order, p, p + s - 1, n - 1);
        } else {
            for (int i = p; i <= n - 1; i++) {
                order[i] = r[i];
            }
        }
    }

    /**
     * 二路归并排序算法
     */
    public void mergeSort() {
        RecordNode[] temp = new RecordNode[curlen];
        int s = 1;
        while (s < curlen) {
            mergepass(r, temp, s, curlen);
            showSortArray();
            s = s * 2;
            mergepass(temp, r, s, curlen);
            showSortArray();
            s = s * 2;
        }
    }

    /**
     * 显示序列
     */
    public void showSortArray() {
        for (int i = 0; i < curlen; i++) {
            System.out.print(r[i].getKey().toString() + " ");
        }
        System.out.println();
    }
}
