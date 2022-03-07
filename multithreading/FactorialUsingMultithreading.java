/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 02:58
 *   File: FactorialUsingMultithreading.java
 */

package multithreading;

import java.math.BigInteger;

public class FactorialUsingMultithreading {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int[] array = {1000,2000,3000,4000};

        MyThread[] myThread = new MyThread[array.length];
        for (int i = 0; i < myThread.length; i++) {
            myThread[i] = new MyThread(array[i]);
            myThread[i].start();
        }

        for (int i = 0; i < myThread.length; i++) {
            myThread[i].join();
        }

        for (int i = 0; i < myThread.length; i++) {
            System.out.println(myThread[i].result);
        }
    }

    public static class  MyThread extends Thread{

        private int num;
        private BigInteger result;

        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            calculateFactorial();
        }

        public void calculateFactorial(){
            for (int i = 2; i < num; i++) {
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}