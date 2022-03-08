package syncronization;/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 08-03-2022
 *   Time: 03:06
 *   File: syncronization.Bank.java
 */

public class Bank {
    private int accountNumber;
    private int balance;

    public Bank(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}