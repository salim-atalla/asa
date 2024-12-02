// Fichier : banking/Account.java
package banking;

/**
 * Représente un compte bancaire.
 */
public class Account {
    private String accountNumber;
    private double balance;

    /**
     * Constructeur de la classe Account.
     *
     * @param accountNumber le numéro de compte
     * @param initialBalance le solde initial
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Retourne le numéro de compte.
     *
     * @return le numéro de compte
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Retourne le solde du compte.
     *
     * @return le solde du compte
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Dépose un montant sur le compte.
     *
     * @param amount le montant à déposer
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Dépôt de " + amount + " effectué. Nouveau solde : " + balance);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    /**
     * Retire un montant du compte.
     *
     * @param amount le montant à retirer
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Retrait de " + amount + " effectué. Nouveau solde : " + balance);
        } else {
            System.out.println("Montant de retrait invalide ou solde insuffisant.");
        }
    }
}
