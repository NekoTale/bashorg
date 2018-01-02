package com.dimon.mangaloader;

import com.dimon.mangaloader.core.MyLinkedList;

public class MyQueue<T> {


    private final int maxSize;

    private final Object monitor = new Object();
    
    private final MyLinkedList<T> queue = new MyLinkedList<>();

    public MyQueue(final int maxSize) {
        this.maxSize = maxSize;
    }


    public void put(final T object) {
        synchronized (monitor) {
            while (queue.length() == maxSize) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(object);
            monitor.notifyAll();
        }
    }

    public T get() {
        synchronized (monitor) {
            while (queue.length() == 0) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            final T t = queue.deleteFirst();
            monitor.notifyAll();
            return t;
        }
    }

    public int size() {
        synchronized (monitor) {
            return queue.length();
        }
    }

}
