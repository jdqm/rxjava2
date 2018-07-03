package com.jdqm.rxjava.chapter3;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.io.IOException;

public class Error {
    public static void main(String...args) throws IOException {
        Observable.error(new NullPointerException()).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println(throwable);
            }
        });
    }
}
