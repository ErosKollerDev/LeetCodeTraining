package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A compact demo showing different ways to create and run threads using Runnable and Thread,
 * coordination with join(), and the difference between non-thread-safe and thread-safe counters.
 */
public class ThreadsRunnableDemo {

    // Non-thread-safe counter (race conditions will occur)
    static class UnsafeCounter {
        private int value = 0;

        public void increment() {
            // Intentional race: read-modify-write without synchronization
            value = value + 1;
        }

        public int get() {
            return value;
        }
    }

    // Thread-safe counter using AtomicInteger
    static class SafeCounter {
        private final AtomicInteger value = new AtomicInteger(0);

        public void increment() {
            value.incrementAndGet();
        }

        public int get() {
            return value.get();
        }
    }

    // Example of extending Thread
    static class MyThread extends Thread {
        private final String taskName;

        public MyThread(String taskName) {
            this.taskName = taskName;
            setName("MyThread-" + taskName);
        }

        @Override
        public void run() {
            System.out.println("[" + getName() + "] started");
            try {
                // Simulate work
                TimeUnit.MILLISECONDS.sleep(150);
            } catch (InterruptedException e) {
                // Restore interrupted status and exit
                Thread.currentThread().interrupt();
            }
            System.out.println("[" + getName() + "] finished");
        }
    }

    // Example of implementing Runnable
    static class MyRunnable implements Runnable {
        private final String taskName;

        public MyRunnable(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + threadName + "] running task: " + taskName);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[" + this.taskName + "] finished");
        }
    }

    static class MyRunnableEros implements Runnable {
        private final String taskName;
        private final Object lock = new Object();

        public MyRunnableEros(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + threadName + "] running task: " + taskName);
            try{
                synchronized(lock) {  // Synchronize on the lock
                    lock.wait(100);    // Wait on the lock object
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[" + this.taskName + "] finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Threads/Runnable Basics ---");

        // 1) Starting a thread by extending Thread
        Thread t1 = new MyThread("extend-1");
        t1.start();

        // 2) Starting a thread by passing a Runnable to a Thread
        Thread t2 = new Thread(new MyRunnable("runnable-1"), "Worker-R1");
        t2.start();

        // 3) Using a lambda Runnable
        Thread t3 = new Thread(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] lambda task starting");
            try {
                TimeUnit.MILLISECONDS.sleep(80);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[" + Thread.currentThread().getName() + "] lambda task done");
        }, "Worker-Lambda");
        t3.start();

        Thread tEros = new Thread(new MyRunnableEros("runnable-eros"), "Worker-EROS");
        tEros.start();
        // Wait for the first three threads to complete
        t1.join();
        t2.join();
        t3.join();
        tEros.join();

        System.out.println("--- Threads/Runnable Basics End---");


        System.out.println("--- Race condition demo (Unsafe vs Safe counters) ---");

        final int threads = 5;
        final int incrementsPerThread = 1000;
        final int expected = threads * incrementsPerThread;

        UnsafeCounter unsafeCounter = new UnsafeCounter();
        SafeCounter safeCounter = new SafeCounter();

        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            int workerId = i;
            Thread worker = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    unsafeCounter.increment();    // not thread-safe
                    safeCounter.increment();      // thread-safe
                    if (j % 250 == 0) {
                        // Occasionally yield/sleep to increase interleaving
                        Thread.yield();
                    }
                }
            }, "CounterWorker-" + workerId);
            workers.add(worker);
            worker.start();
        }

        // Join all worker threads
        for (Thread w : workers) {
            w.join();
        }

        System.out.println("Expected count: " + expected);
        System.out.println("UnsafeCounter result: " + unsafeCounter.get() + " (likely < expected due to lost updates)");
        System.out.println("SafeCounter result:   " + safeCounter.get() + " (matches expected)");

        System.out.println("--- Demo complete ---");
    }
}