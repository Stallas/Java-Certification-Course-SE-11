/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService
S1: run both static methods using execute and simple for loop.
S2: giving second thread inside for loop , now the second thread doesnt start till first thread is done
and it runs even though program reaches last line "All done"
S3:
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Class tests SingleThreadedExecutorService with two threads
public class ExecutorExample {

    // main method
    public static void main(String[] args) throws InterruptedException {

        // Get new service using Executors class, static factory method
        ExecutorService executorService
                = Executors.newSingleThreadExecutor();

        // Fire and Forget method of execution:  ThreadOne
        executorService.execute(ExecutorExample::doSomethingThreadOne);

        // Fire and Forget method of execution: ThreadTwo
//        executorService.execute(ExecutorExample::doSomethingThreadTwo);//S1
//        executorService.submit(ExecutorExample::doSomethingThreadTwo);//S3

        var submittedThread = executorService.submit(
                ExecutorExample::doSomethingThreadTwo);

        for (int i = 1; i < 11; i++) {
            System.out.println("Main thread: iteration " + i);
//           executorService.execute(ExecutorExample::doSomethingThreadTwo);// S2
            Thread.sleep(250);
            // S1:Comment below code and test the output
          if (i == 7) {
                // Use task reference to cancel the task
                if (!submittedThread.isDone()) {
                    submittedThread.cancel(true);
                    System.out.println("Was able to cancel using " +
                            submittedThread.getClass().getName());
                }
            }


        }

        // Shutdown the service else program doesn't terminate have to manually do it.
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);// comment out S2

        System.out.println("All done!!");
    }

    // Method will run asynchronously, printing numbers 1-5
    private static void doSomethingThreadOne() {
        for (int i = 1; i <= 5; i++) {

            System.out.println("--> First Thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }

    // Method will run asynchronously, printing numbers 10-5
    private static void doSomethingThreadTwo() {
        for (int i = 10; i > 5; i--) {

            System.out.println("--> Second thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }
}