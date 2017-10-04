package com.sunlands.xiayimin.Sort;

/**
 * Created by 12754 on 2017/9/17.
 */
public class KeyType implements Comparable<KeyType>{

    public static final int LESSTHAN = -1;

    public static final int GREATTHAN = 1;

    public static final int EQUAL = 0;

    private int key;

    public KeyType() {

    }

    public KeyType(int key) {

    }

    /**
     * 重写toString的方法
     *
     * @return
     */
    public String toString() {
        return key + " ";
    }

    @Override
    public int compareTo(KeyType another) {
        int thisVal = this.key;
        int anotherVal = another.key;
        return (thisVal < anotherVal ? LESSTHAN : (thisVal == anotherVal ? EQUAL : GREATTHAN));
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
