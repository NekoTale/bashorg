package com.dimon.bashorg.core;

/**
 * Created by mds on 02.10.17.
 */
public class Node {
    Node next;
    String info;

    public Node(Node next, String info) {
        this.next = next;
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
