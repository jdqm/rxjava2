package com.jdqm.rxjava.chapter3;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class Create {

    public static void main(String...args) {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                try {
                    if (!emitter.isDisposed()) {
                        for (int i = 0; i < 10; i++) {
                            emitter.onNext(i);
                            if (i == 5) {
                                int temp = i / 0;
                            }
                        }
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                   // e.printStackTrace();
                    emitter.onError(e);
                }
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Next: " + integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("Error: " + throwable);
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("Sequence Complete.");
            }
        });

    }
}
