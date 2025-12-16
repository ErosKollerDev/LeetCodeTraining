package com.concurrency_threads;


class Counter {
    int counter = 0;

    public synchronized   void incremnet() {
        counter++;
    }

}


public class RaceContitionDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r1 = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.incremnet();
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.incremnet();

            }
        };
        var t1 = new Thread(r1);
        var t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.counter);
    }
}
