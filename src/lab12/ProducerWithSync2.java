package lab12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ProducerWithoutSync
public class ProducerWithSync2 {
    private static Buffer buffer = new Buffer();

    public static void main(String[] args) {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

//    https://www.cnblogs.com/weibanggang/p/9470718.html
    //  ProducerWithoutSync
    // A task for adding an int to the buffer
    private static class ProducerTask implements Runnable {
        public void run() {

            synchronized (this){
                try {
                    int i = 1;
                    while (true) {
//          System.out.println("Producer writes " + i);
                        System.out.println(String.format("Producer writes %d to %d", i, i + 9));
                        for (int j = 0; j < 10; j++) {
                            buffer.write(i++); // Add a value to the buffer
                            // Put the thread into sleep
                        }

//          int scale=10000;
                        int scale = 1000;
//          Thread.sleep((int)(Math.random() * 10000));
                        Thread.sleep((int) (Math.random() * scale));
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    // A task for reading and deleting an int from the buffer
    private static class ConsumerTask implements Runnable {
        public void run() {

            synchronized (this){
                try {
                    while (true) {
                        System.out.println("\t\t\tConsumer reads " + buffer.read());
                        // Put the thread into sleep
//          int scale=1000;
//          int scale=10000;
                        int scale = 500;
                        Thread.sleep((int) (Math.random() * scale));
//          Thread.sleep((int)(Math.random() * 10000));
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    // An inner class for buffer
    private static class Buffer {
        //    private static final int CAPACITY = 1; // buffer size
        private static final int CAPACITY = 25; // buffer size
        private java.util.LinkedList<Integer> queue =
                new java.util.LinkedList<Integer>();

        // Create a new lock
        private static Lock lock = new ReentrantLock();

        // Create two conditions
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int value) {
//      lock.lock(); // Acquire the lock

            queue.offer(value);
//
//      try {
////        while (queue.size() == CAPACITY) {
////          System.out.println("Wait for notFull condition");
////          notFull.await();
////        }
//
//        queue.offer(value);
////        notEmpty.signal(); // Signal notEmpty condition
//        // 提供了东西 现在不是空的
//      } catch (InterruptedException ex) {
//        ex.printStackTrace();
//      } finally {
//        lock.unlock(); // Release the lock
//      }
        }

        public int read() throws InterruptedException {


            while (queue.isEmpty()) {
                System.out.println("\t\t\tWait for notEmpty condition");
//          notEmpty.await();
              int scale = 500;
              Thread.sleep((int) (Math.random() * scale));
            }
            int value = 0;
            value = queue.remove();
            return value;
//      lock.lock(); // Acquire the lock
//      try {
//        while (queue.isEmpty()) {
//          System.out.println("\t\t\tWait for notEmpty condition");
//          notEmpty.await();
//        }
//
//        value = queue.remove();
//        notFull.signal(); // Signal notFull condition
//      } catch (InterruptedException ex) {
//        ex.printStackTrace();
//      } finally {
//        lock.unlock(); // Release the lock
//        return value;
//      }
//

        }
    }
}
