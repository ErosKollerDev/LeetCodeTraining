package com.concurrency_threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Virtual Threads (Project Loom, Java 21+) demo.
 *
 * This class shows three common ways to use virtual threads:
 *  1) Starting a single virtual thread with Thread.startVirtualThread(...)
 *  2) Naming and starting virtual threads via Thread.ofVirtual()
 *  3) Using a virtual-thread-per-task Executor for many short-lived tasks
 *
 * Notes:
 *  - Virtual threads are lightweight: you can create thousands without exhausting OS threads.
 *  - They are fantastic for I/O-bound and blocking APIs (e.g., JDBC, HTTP clients, sleep).
 *  - They do NOT make CPU-bound work faster by themselves; they make concurrency cheaper.
 */
public class VirtualThreadsDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("--- Virtual Threads Demo (Java 21+) ---");

//        // 1) The quickest way: start a single virtual thread
//        Thread vt1 = Thread.startVirtualThread(() -> {
//            System.out.println("[" + Thread.currentThread() + "] vt1 starting");
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            System.out.println("[" + Thread.currentThread() + "] vt1 finished");
//        });
//
//        // 2) Name virtual threads using Thread.ofVirtual()
//        Thread vt2 = Thread.ofVirtual().name("v-worker-1").start(() -> {
//            System.out.println("[" + Thread.currentThread() + "] v-worker-1 doing I/O-like work");
//            try {
//                // Simulate blocking call (e.g., DB/HTTP). Virtual threads park cheaply.
//                TimeUnit.MILLISECONDS.sleep(150);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            System.out.println("[" + Thread.currentThread() + "] v-worker-1 done");
//        });
//
//        Thread vt3 = Thread.ofVirtual().name("v-worker-3").start(() -> {
//            System.out.println("v-worker-3");
//            Object lock = new Object();
//            try {
//                synchronized (lock) {
//                    lock.wait(3000);
//                }
//            } catch (Exception e) {
//                System.out.println("Exception occurred: " + e.getMessage());
//            }
//            System.out.println("[" + Thread.currentThread() + "] vt3 finished");
//        });
//
//        // Wait for the three single tasks to complete
//        vt1.join();
//        vt2.join();
//        vt3.join();

//        System.out.println("--- Virtual Thread Per Task Executor ---\nSubmitting 10,000 short blocking tasks to show scalability...");

        // 3) Virtual-thread-per-task executor: perfect for request-per-task style work
        Instant start = Instant.now();
        List<Callable<Integer>> tasks = new ArrayList<>();
        final int taskCount = 10_000; // try increasing this number; Virtual Threads handle it well

        for (int i = 0; i < taskCount; i++) {
            int id = i;
            tasks.add(() -> {
                // Each task runs in its own virtual thread
                // Simulate some blocking I/O
                TimeUnit.MILLISECONDS.sleep(5);
                return id * id; // return something just to have a result
            });
        }

        List<Future<Integer>> results;
        // try-with-resources will close the executor and wait for tasks to finish
        try (ExecutorService vtp = Executors.newVirtualThreadPerTaskExecutor()) {
            results = vtp.invokeAll(tasks); // submit all tasks and wait
        }

        // Aggregate a couple of results to ensure tasks indeed ran
        long checksum = 0;
        int samples = 0;
        for (int i = 0; i < results.size(); i += Math.max(1, taskCount / 10)) { // sample ~10 results
            checksum += results.get(i).get();
            samples++;
        }

//        Duration took = Duration.between(start, Instant.now());
//        System.out.println("Submitted: " + taskCount + " tasks using virtual threads");
//        System.out.println("Sampled checksum from results: " + checksum + " (" + samples + " samples)");
//        System.out.println("Total time: " + took.toMillis() + " ms");

        System.out.println("--- Demo complete ---");
    }
}
