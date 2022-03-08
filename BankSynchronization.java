/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 03:08
 *   File: BankSynchronization.java
 */

public class BankSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Bank account1 = new Bank(1,100);
        Bank account2 = new Bank(2,200);

        MyThread[] threads = new MyThread[6];

        threads[0] = new MyThread(account1,true,50);
        threads[1] = new MyThread(account1,false,100);
        threads[2] = new MyThread(account1,true,250);

        threads[3] = new MyThread(account1,true,100);
        threads[4] = new MyThread(account1,true,350);
        threads[5] = new MyThread(account1,true,100);

        for(int i=0;i<6;i++)
            threads[i].start();

        for(int i=0;i<6;i++)
            threads[i].join();

        System.out.println("Account1 Balance " + account1.getBalance() + ", Account2 Balance " + account2.getBalance());
    }

    private static class MyThread extends  Thread {
        private Bank obj;
        boolean isDeposite;
        private int amount;

        public MyThread(Bank obj, boolean isDeposite, int amount) {
            this.obj = obj;
            this.isDeposite = isDeposite;
            this.amount = amount;
        }

        @Override
        public void run() {
            if(isDeposite)
                deposite();
            else
                withraw();
        }

        private void deposite() {
            synchronized (Bank.class) { // Bank.class at the class level and this.obj is object level synchronization
                System.out.println("I am in " + currentThread().getName());
                this.obj.setBalance(this.obj.getBalance() + this.amount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void withraw() {
            synchronized (Bank.class) {
                System.out.println("I am in " + currentThread().getName());
                this.obj.setAccountNumber(this.obj.getAccountNumber() - this.amount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}