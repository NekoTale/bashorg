package com.dimon.mangaloader.core;

import java.util.Iterator;

/**
 * Created by mds on 02.10.17.
 */
public class MyLinkedList<T> implements Iterable<T> {
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return index < length();
            }

            public T next() {
                return getNode(index++).getData();
            }
        };
    }

    private class Node<T> {
        private Node<T> next;
        private T data;

        Node(final T info) {
            this.data = info;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(final Node next) {
            this.next = next;
        }

        T getData() {
            return data;
        }

        public void setData(final T data) {
            this.data = data;
        }
    }

    private class ListOptions {

    }

    public MyLinkedList() {
    }

    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    public void add(final T l) {
        if (head == null) {
            Node<T> recent = new Node<>(l);
            head = recent;
            last = recent;

        } else {
            Node<T> recent = new Node<>(l);
            last.setNext(recent);
            last = recent;
        }
        size++;
    }

    public T get(final int num) {
        return getNode(num).getData();
    }


    private Node<T> getNode(final int num) {
        if (num >= length()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> search = head;
        int i = 0;
        while (i < num && search.getNext() != null) {
            search = search.getNext();

            i++;
        }
        return search;
    }

    public void delete(final int num) {
        Node<T> helper = new Node<T>(null);
        helper = getNode(num - 1);
        helper.setNext(getNode(num + 1));
        size--;

    }

    public T deleteFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    public void addToPosition(final T lol, final int num) {


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

    private boolean hasNext(final int i) {
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
