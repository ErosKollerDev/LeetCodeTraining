package com.concurrency_threads;


/**
 * Simple demo of creating a Thread via an inner class, making it wait for 1 second
 * using Object.wait(...) inside a synchronized block, and then resuming execution.
 * <p>
 * Notes:
 * - This demo uses a static inner class that extends Thread.
 * - The thread prints before waiting, waits for ~1 second, and then prints after being notified by time expiration.
 * - Proper interruption handling is shown (restore the interrupt flag if interrupted).
 */
public class ThreadCreationDemo {

    /**
     * A simple worker that extends Thread. It demonstrates waiting and resuming.
     */
    public static class WorkerThread extends Thread {
        private final String taskName;

        public WorkerThread(String taskName) {
            super("worker-" + taskName);
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println("[" + Thread.currentThread().getName() + "] Starting task: " + taskName);
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] Going to wait for ~1 second...");
                // Use timed wait inside a synchronized block to pause the thread
                synchronized (this) {
                    this.wait(1000);
                }
//                Thread.sleep(1000);
                System.out.println("[" + Thread.currentThread().getName() + "] Woke up (timed wait elapsed) — resuming execution.");
            } catch (InterruptedException e) {
                // Restore interrupt status and exit gracefully
                Thread.currentThread().interrupt();
                System.out.println("[" + Thread.currentThread().getName() + "] Interrupted while waiting. Exiting.");
                return;
            }

            // Continue doing work after the wait
            System.out.println("[" + Thread.currentThread().getName() + "] Finished task: " + taskName);
        }
    }

    /**
     * Entry point: creates, starts, and joins a thread that waits for ~1 second.
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Thread Creation Demo (inner class extends Thread) ---");

        WorkerThread worker = new WorkerThread("demo");
        worker.start();
//        worker.run();
        // Wait for the worker to finish
//        worker.join();
//        worker.notify();
        try {
            synchronized (worker) {
                System.out.println( "Notifying worker thread...");
                worker.notify();
            }
        } catch (IllegalMonitorStateException e) {
            System.out.println("IllegalMonitorStateException: " + e.getMessage());
        }
        System.out.println("--- Demo complete ---");
    }
}
