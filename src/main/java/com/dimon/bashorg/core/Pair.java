package com.dimon.bashorg.core;

/**
 * Created by mds on 04.10.17.
 */
public class Pair<T,E> {
    
    private T hello;
    private E goodBye;

    public Pair(T hello, E goodBye) {
        this.hello = hello;
        this.goodBye = goodBye;
    }

    public T getHello() {
        return hello;
    }

    public void setHello(final T hello) {
        this.hello = hello;
    }

    public E getGoodBye() {
        return goodBye;
    }

    public void setGoodBye(final E goodBye) {
        this.goodBye = goodBye;
    }
}
