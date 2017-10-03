package com.dimon.bashorg.core;

/**
 * Created by mds on 02.10.17.
 */
public class Node<T> {
    Node next;
    T info;

    public Node(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
