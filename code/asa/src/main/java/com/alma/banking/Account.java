package com.alma.banking;

/**
 * Représente un compte bancaire.
 */
public class Account {
    private String accountNumber;
    private double balance;

    /**
     * Constructeur pour créer un nouveau compte bancaire.
     *
     * @param accountNumber  le numéro de compte
     * @param initialBalance le solde initial
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Retire un montant du compte.
     *
     * @param amount le montant à retirer
     */
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Account " + accountNumber + ": Withdrawn " + amount + ". New balance: " + balance);
        } else {
            System.out
                    .println("Account " + accountNumber + ": Withdrawal of " + amount + " failed. Insufficient funds.");
        }
    }

    /**
     * Dépose un montant sur le compte.
     *
     * @param amount le montant à déposer
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Account " + accountNumber + ": Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Account " + accountNumber + ": Deposit of " + amount + " failed. Invalid amount.");
        }
    }

    /**
     * Récupère le solde du compte.
     *
     * @return le solde
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Récupère le numéro de compte.
     *
     * @return le numéro de compte
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
