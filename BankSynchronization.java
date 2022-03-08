/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 03:08
 *   File: BankSynchronization.java
 */

public class BankSynchronization {
    public static void main(String[] args) {
        Bank account1 = new Bank(1,100);
        Bank account2 = new Bank(2,200);
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
    }
}