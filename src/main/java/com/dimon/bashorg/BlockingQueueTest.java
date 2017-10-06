package com.dimon.bashorg;

import java.util.Random;

public class BlockingQueueTest {
    public static void main(final String[] args) {
        MyQueue<Integer> testQueue = new MyQueue<>();
        Thread test = new Thread(new Writer(testQueue));
        Thread test1 = new Thread(new Writer(testQueue));
        Thread test2 = new Thread(new Writer(testQueue));
        Thread testRead = new Thread(new Reader(testQueue));
        Thread testRead1 = new Thread(new Reader(testQueue));
        Thread testRead2 = new Thread(new Reader(testQueue));

        test.start();
        test1.start();
        test2.start();
        System.out.println(testQueue.size());
        testRead.start();
        testRead1.start();
        testRead2.start();

        try {
            test.join();
            test1.join();
            test2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(testQueue.size());


    }

    private static class Writer implements Runnable {
        private MyQueue<Integer> interQueue;

        Writer(final MyQueue<Integer> interQueue) {
            this.interQueue = interQueue;
        }

        private Random rand = new Random();
        private final int counter = rand.nextInt(100) + 50;
        private int i = 0;

        @Override
        public void run() {
            while (i < counter) {
                interQueue.put(1);
                i++;
            }
        }

    }в


    private static class Reader implements Runnable {
        private MyQueue<Integer> intQueue;

        Reader(final MyQueue<Integer> intQueue) {
            this.intQueue = intQueue;
        }

        @Override
        public void run() {
            while (true) {
                intQueue.get();
            }
        }

    }
}
