package com.dimon.mangaloader;

import java.util.Random;

public class ThreadsTask {

    private class Value {

        private int value = 0;

        public synchronized int getValue() {
            return value;
        }

        public synchronized void setValue(final int value) {
            this.value = value;
        }

    }

    private boolean producerReady = false;
    private boolean listenerStarted = false;
    private boolean isRunning = true;

    private synchronized void waitForProduce() throws InterruptedException {
        while (producerReady) {
            wait();
        }
    }

    private synchronized void waitForListen() throws InterruptedException {
        while (!producerReady) {
            wait();
        }
    }

    private synchronized void producerCreatedNumber() {
        producerReady = false;
        notifyAll();
    }

    private synchronized void listenerReadNumber() {
        producerReady = true;
        notifyAll();
    }

    private class Producer implements Runnable {
        private Value internalValue;

        Producer(final Value impValue) {
            this.internalValue = impValue;
        }

        @Override
        public void run() {
            try {
                producerRun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void producerRun() throws InterruptedException {
            int i = 0;
            final int randomizer = 100;
            Random rand = new Random();
            int sum = 0;
            // дождаться того что listener thread стартанул
            while (i < randomizer) {
                // обновлять значение в value пока не кончится список
                final int value = rand.nextInt(50);
                sum += value;
                internalValue.setValue(value);
                i++;
                producerCreatedNumber();
                waitForListen();
            }
            isRunning = false;
            producerCreatedNumber();
            // вывести сумму получившуюся в этом потоке
            System.out.println("Producer sum = " + sum);
        }
    }

    private class Listener implements Runnable {
        private Value internalValue;

        Listener(final Value internalValue) {
            this.internalValue = internalValue;
        }

        @Override
        public void run() {
            try {
                listenerRun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void listenerRun() throws InterruptedException {

            int sum = 0;
            // дождаться того что продьюсер написал
            while (isRunning) {
                waitForProduce();
                if (!isRunning) {
                    break;
                }
                // обработать значение
                sum = sum + internalValue.getValue();
                // сказать что мы снова готовы слушать значение от продьюсера
                listenerReadNumber();
            }


            // вывести сумму
            System.out.println("Listener sum = " + sum);
        }
    }

    void runThreads() {
        // запускаем продьюсер и лиснер
        Value value = new Value();
        Thread producer = new Thread(new Producer(value));
        producer.start();
        Thread listener = new Thread(new Listener(value));
        listener.start();

        // запустить поток продьюсер который вызовет метод producerRun
        // запустить поток listener который вызовет метод listenerRun
        // дождаться их завершения
    }

    public static void main(final String[] args) {
        ThreadsTask threadsTask = new ThreadsTask();
        threadsTask.runThreads();

    }

}
