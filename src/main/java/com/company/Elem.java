package com.company;

public class Elem {
    int key;
    Object data;

    public Elem(int key, Object data) {
        this.key = key;
        this.data = data;
    }

    public int key() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}



