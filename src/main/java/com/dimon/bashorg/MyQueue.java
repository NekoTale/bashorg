package com.dimon.bashorg;

import com.dimon.bashorg.core.MyLinkedList;

public class MyQueue<T> {
    public MyQueue() {
        this.queue = queue;
    }

    private int maxSize = 10;
    private final Object monitor = new Object();

    public MyQueue(final int maxSize) {
        this.maxSize = maxSize;
    }

    private MyLinkedList<T> queue = new MyLinkedList<>();

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
