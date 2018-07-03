package com.jdqm.rxjava.chapter3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Range {

    public static void main(String... args) {

        Observable.range(0, 9)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }
}
