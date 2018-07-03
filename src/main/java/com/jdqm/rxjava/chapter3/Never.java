package com.jdqm.rxjava.chapter3;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 *
 */

public class Never {
    public static void main(String... args) {
        Observable.never().subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println("onNext:" + o);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println(throwable);
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("complete");
            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println("Disposable:" + disposable);
            }
        });
    }
}
