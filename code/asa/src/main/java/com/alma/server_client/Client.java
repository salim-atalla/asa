// Fichier : server_client/Client.java
package com.alma.server_client;

import com.alma.banking.BankingService;
import com.alma.component.Component;
import com.alma.component.ProvideInterface;
import com.alma.component.RequireInterface;
import com.alma.observer.Observer;

/**
 * Représente le client dans le système client-serveur.
 * Implémente l'interface Observer pour répondre aux changements d'état du
 * serveur.
 */
public class Client extends Component implements Observer {

    private BankingService bankingService; // Référence au service bancaire
    private String username;
    private String password;
    private String sessionToken; // Token de session après authentification

    public Client(ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
    }

    /**
     * Définit les informations d'identification de l'utilisateur.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     */
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Authentifie le client auprès du serveur.
     *
     * @param server le serveur pour l'authentification
     */
    public void authenticate(Server server) {
        if (username == null || password == null) {
            System.out.println("Client: Credentials not set.");
            return;
        }
        this.sessionToken = server.login(username, password);
        if (this.sessionToken != null) {
            System.out.println("Client: Authenticated successfully. Session token: " + sessionToken);
        } else {
            System.out.println("Client: Authentication failed.");
        }
    }

    /**
     * Définit le BankingService pour le client.
     *
     * @param bankingService le service bancaire à utiliser
     */
    public void setBankingService(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    /**
     * Met à jour le client en réponse à un changement d'état du serveur.
     */
    @Override
    public void update(String message) {
        System.out.println("Client: Notification from server - " + message);
        // Ajouter une logique spécifique de mise à jour ici si nécessaire.
    }

    /**
     * Crée un nouveau compte bancaire en utilisant le BankingService.
     *
     * @param accountNumber  le numéro de compte
     * @param initialBalance le solde initial
     */
    public void createAccount(String accountNumber, double initialBalance) {
        if (bankingService != null && sessionToken != null) {
            bankingService.createAccount(accountNumber, initialBalance);
        } else {
            System.out.println("Client: BankingService not available or not authenticated.");
        }
    }

    /**
     * Effectue une transaction en utilisant le BankingService.
     *
     * @param transactionId l'ID de la transaction
     * @param fromAccount   le compte source
     * @param toAccount     le compte destination
     * @param amount        le montant à transférer
     */
    public void performTransaction(String transactionId, String fromAccount, String toAccount, double amount) {
        if (bankingService != null && sessionToken != null) {
            bankingService.performTransaction(transactionId, fromAccount, toAccount, amount);
        } else {
            System.out.println("Client: BankingService not available or not authenticated.");
        }
    }

    // Ajoutez les getters pour les champs privés

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public BankingService getBankingService() {
        return bankingService;
    }

}
