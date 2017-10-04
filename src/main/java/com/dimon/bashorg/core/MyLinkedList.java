package com.dimon.bashorg.core;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.function.Consumer;

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

    public void forEach(final Consumer action) {

    }

    public Spliterator spliterator() {
        return null;
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
        Node<T> search = head;

        for (int i = 0; i < num - 1; i++) {
            search = search.getNext();
        }
        return search;
    }

    public void delete(final int num) {
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

    public void addToPosition(final T lol, final int num) {
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
