package Mulitthreading;/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 02:56
 *   File: Mulitthreading.ByExtending.java
 */

public class ByExtending {
        public static void main(String[] args) {
            MyThread thread = new MyThread();
            thread.start();
            System.out.println("Thread is " );
            System.out.println(Thread.currentThread().getName());
        }

        public static class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }
}