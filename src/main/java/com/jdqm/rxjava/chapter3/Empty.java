package com.jdqm.rxjava.chapter3;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Empty {
    public static void main(String...args) {

        Observable.empty().subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println(o);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("Error");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("complete");
            }
        });
    }

}
