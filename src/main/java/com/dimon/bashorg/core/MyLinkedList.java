package com.dimon.bashorg.core;

import java.util.Scanner;

/**
 * Created by mds on 02.10.17.
 */
public class MyLinkedList<T> {
    private class Node<T> {
        Node<T> next;
        T data;

        public Node(T info) {
            this.data = info;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
    private class ListOptions{

    }

    public MyLinkedList() {
    }

    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    public void add(T l) {
        if (head == null) {
            Node<T> recent = new Node<T>(l);
            head = recent;
            last = recent;

        } else {
            Node<T> recent = new Node<T>(l);
            last.setNext(recent);
            last = recent;
        }
        size++;
    }

    public T get(int num) {
        if (num == 0) {
            return head.getData();
        } else if (num > length()) {
            System.out.println("введите значение не больше " + length());
            Scanner hello = new Scanner(System.in);
            num = hello.nextInt();
            return getNode(num).getData();
        } else return getNode(num).getData();

    }


    private Node<T> getNode(int num) {
        Node<T> search = head;

        for (int i = 0; i < num - 1; i++) {
            search = search.getNext();
        }
        return search;
    }

    public void delete(int num) {
        if (length() == 1) {
            head = null;
        } else if (num == 1) {
            head = head.getNext();
            System.out.println("удален первый элемент, новый первый элемент" + head.getData());
        } else {
            getNode(num - 1).setNext(getNode(num).getNext());
            System.out.println("удален " + num + " элемент, новый  " + getNode(num).getData());

        }
        if (num == length()) {
            getNode(length() - 1).setNext(null);
        }
        size--;

    }

    public void addToPosition(T lol, int num) {
        if (num == 1) {
            Node<T> recent = new Node<T>(lol);
            recent.setNext(head);
            head = recent;
        } else {
            Node<T> recent = new Node<T>(lol);
            recent.setNext(getNode(num));
            getNode(num - 1).setNext(recent);
        }

    }

    public int length() {
        return size;

    }

    public void reverse() {
        Node<T> pointer = head;
        Node<T> previous = null;
        Node<T> current = null;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;
            current.next = previous;
            previous = current;
            head = current;
        }
    }
    private boolean hasNext(int i){
        boolean has = false;
        if (this.getNode(i).getNext() != null) has = true;
        return has;
    }


    public T getHead() {
        return head.getData();
    }

    public T getLast() {
        return last.getData();
    }
}
