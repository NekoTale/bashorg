package com.dimon.bashorg.core;

/**
 * Created by mds on 02.10.17.
 */
public class Node<T> {
    Node<T> next;
    T data;

    public Node(T info) {
        this.data = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
