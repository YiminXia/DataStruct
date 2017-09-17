package com.sunlands.xiayimin.Sort;

/**
 * Created by 12754 on 2017/9/17.
 */
public class RecordNode {

    private Comparable key;

    private Object element;

    public RecordNode(Comparable key){
        this.key = key;
    }

    public RecordNode(Comparable key, Object element) {
        this.key = key;
        this.element = element;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
