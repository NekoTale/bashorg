package com.dimon.bashorg.core;

/**
 * Created by mds on 02.10.17.
 */
public class MyLinkedList {
    public MyLinkedList() {
    }
    Node searchHelp;
    Node first;
    Node last;
    public void add (String l){
        if (first == null){
            Node recent = new Node(null, l);
            first = recent;
            last = recent;

        }
        else {
            Node recent = new Node(null,l);
            last.setNext(recent);
            last = recent;

        }
        }
    public Node get (int num){
        Node search = first;
        for (int i = 0; i<num; i++){
            search = search.getNext();
        }
        return searchHelp;

    }
    public void delete (int num){
        if (num == 0){
            first = first.getNext();
        }
        else {

        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
}
