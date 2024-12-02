// Fichier : banking/BankingService.java
package banking;

/**
 * Interface fournissant les services bancaires.
 */
public interface BankingService {
    /**
     * Crée un nouveau compte bancaire.
     *
     * @param accountNumber le numéro de compte
     * @param initialBalance le solde initial
     */
    void createAccount(String accountNumber, double initialBalance);

    /**
     * Effectue une transaction entre deux comptes.
     *
     * @param transactionId l'ID de la transaction
     * @param fromAccount le compte source
     * @param toAccount le compte destination
     * @param amount le montant à transférer
     */
    void performTransaction(String transactionId, String fromAccount, String toAccount, double amount);
}
