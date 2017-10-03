package com.dimon.bashorg.core;

import java.util.Scanner;

/**
 * Created by mds on 02.10.17.
 */
public class MyLinkedList<T> {
    public MyLinkedList() {
    }

    Node<T> first;
    Node<T> last;

    public void add(T l) {
        if (first == null) {
            Node<T> recent = new Node<T>(l);
            first = recent;
            last = recent;
            System.out.println("добавлен первый элемент: " + l);

        } else {
            Node<T> recent = new Node<T>(l);
            last.setNext(recent);
            last = recent;
            System.out.println("добавлен новый элемент: " + l);

        }
    }

    public T get(int num) {
        if (num == 1) {
            return first.getInfo();
        } else if (num > length()) {
            System.out.println("введите значение не больше " + length());
            Scanner hello = new Scanner(System.in);
            num = hello.nextInt();
            return getNode(num).getInfo();
        } else return getNode(num).getInfo();

    }


    private Node<T> getNode(int num) {
        Node<T> search = first;

        for (int i = 0; i < num - 1; i++) {
            search = search.getNext();
        }
        return search;
    }

    public void delete(int num) {
        if (length() == 1) {
            first = null;
        } else if (num == 1) {
            first = first.getNext();
            System.out.println("удален первый элемент, новый первый элемент" + first.getInfo());
        } else {
            getNode(num - 1).setNext(getNode(num).getNext());
            System.out.println("удален " + num + " элемент, новый  " + getNode(num).getInfo());

        }

    }

    public void addToPosition(T lol, int num) {
        if (num == 1) {
            Node<T> recent = new Node<T>(lol);
            recent.setNext(first);
            first = recent;
        } else {
            Node recent = new Node(lol);
            recent.setNext(getNode(num));
            getNode(num - 1).setNext(recent);
        }

    }

    public int length() {
        if (first != null) {
            Node helper = first;
            int counter = 1;
            while (helper.getNext() != null) {
                helper = helper.getNext();
                counter++;
            }
            return counter;
        } else {
            System.out.println("массив пустой");
            return 0;
        }
    }


    public T getFirst() {
        return (T) first.getInfo();
    }

    public T getLast() {
        return last.getInfo();
    }
}
