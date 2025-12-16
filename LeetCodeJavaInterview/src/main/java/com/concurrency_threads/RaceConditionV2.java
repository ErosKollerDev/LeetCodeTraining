package com.concurrency_threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CounterPlus {

    int counter = 0;

    public synchronized void incremnet() {
        counter++;
    }

}

public class RaceConditionV2 {


    public static void main(String[] args) throws InterruptedException {
        CounterPlus counterPlus = new CounterPlus();
//        Thread vt1 =  Thread.ofVirtual().name("RaceConditionV2One").start(() -> {
//            for (int i = 0; i < 10000; i++) {
//                counterPlus.incremnet();
//            }
//        });
//        Thread vt2 =  Thread.ofVirtual().name("RaceConditionV2Twp").start(() -> {
//            for (int i = 0; i < 10000; i++) {
//                counterPlus.incremnet();
//            }
//        });
//        vt1.join();
//        vt2.join();
//        System.out.println(counterPlus.counter);

        var listCall = new ArrayList<Callable<Integer>>();
        for (int i = 0; i < 1000; i++) {
            listCall.add(() -> {
                for (int j = 0; j < 10000; j++) {
                    counterPlus.incremnet();
                }
                return counterPlus.counter;
            });
        }

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.invokeAll(listCall);
        }

        System.out.println(counterPlus.counter);


    }
}
