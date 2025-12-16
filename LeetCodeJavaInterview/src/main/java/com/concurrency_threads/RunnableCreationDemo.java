package com.concurrency_threads;

public class RunnableCreationDemo {


    public static class WorkerThread implements Runnable {
        @Override
        public void run() {
            String taskName = Thread.currentThread().getName();
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



    public static void main(String[] args) {
        System.out.println("--- Thread Creation Demo (inner class extends Thread) ---");

        WorkerThread worker = new WorkerThread();
        Thread t = new Thread(worker);
        t.start();

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
