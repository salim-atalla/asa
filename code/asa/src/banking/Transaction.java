// Fichier : banking/Transaction.java
package banking;

/**
 * Représente une transaction bancaire.
 */
public class Transaction {
    private String transactionId;
    private String fromAccount;
    private String toAccount;
    private double amount;

    /**
     * Constructeur de la classe Transaction.
     *
     * @param transactionId l'ID de la transaction
     * @param fromAccount le compte source
     * @param toAccount le compte destination
     * @param amount le montant de la transaction
     */
    public Transaction(String transactionId, String fromAccount, String toAccount, double amount) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    /**
     * Retourne l'ID de la transaction.
     *
     * @return l'ID de la transaction
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Retourne le compte source.
     *
     * @return le compte source
     */
    public String getFromAccount() {
        return fromAccount;
    }

    /**
     * Retourne le compte destination.
     *
     * @return le compte destination
     */
    public String getToAccount() {
        return toAccount;
    }

    /**
     * Retourne le montant de la transaction.
     *
     * @return le montant de la transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retourne une représentation textuelle de la transaction.
     *
     * @return une chaîne de caractères représentant la transaction
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}
