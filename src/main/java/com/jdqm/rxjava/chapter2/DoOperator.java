package com.jdqm.rxjava.chapter2;


import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class DoOperator {
    public static void main(String...args) {

        Observable.just("Hello World.")
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe:" + disposable.isDisposed());
                    }
                }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("doOnNext");
            }
        }).doAfterNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("doAfterNext");
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnComplete");
            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doFinally");
            }
        }).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnTerminate");
            }
        }).doOnEach(new Consumer<Notification<String>>() {
            @Override
            public void accept(Notification<String> stringNotification) throws Exception {
                System.out.println("doOnEach");
            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println("doOnLifecycle accept");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnLifecycle run");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doAfterTerminate");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("收到消息：" + s);
            }
        });

    }
}
