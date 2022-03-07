/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 02:57
 *   File: ByImplementingThreadRunnable.java
 */

package multithreading;

public class ByImplementingThreadRunnable {
    public static void main(String[] args) {
        MyThread o = new MyThread();
        Thread thread = new Thread(o);
        thread.start();
        System.out.println(Thread.currentThread().getName());

    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread is " + Thread.currentThread().getName());
            printThread();
        }

        public void printThread(){
            System.out.println("Inside print");
        }
    }
}