package com.concurrency_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadsDemoSimple {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("--- Virtual Threads Demo (Java 21+) ---");

        // Virtual-thread-per-task executor: perfect for request-per-task style work

        List<Callable<Integer>> tasks = new ArrayList<>();
        final int taskCount = 10_000; // try increasing this number; Virtual Threads handle it well

        for (int i = 0; i < taskCount; i++) {
            int id = i;
            tasks.add(() -> {
                TimeUnit.MILLISECONDS.sleep(5);
                return id * id; // return something just to have a result
            });
        }

        List<Future<Integer>> results;

        try (ExecutorService vtp = Executors.newVirtualThreadPerTaskExecutor()) {
            results = vtp.invokeAll(tasks); // submit all tasks and wait
        }
//        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            Future<Integer> f = executor.submit(tasks.get(1));
//            System.out.printf("result: %d%n", f.get());
//        }

        System.out.println("Task results:");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("Task %d result: %d%n", i, results.get(i).get());
        }

        System.out.println("--- Demo complete ---");
    }
}
