package com.alma.server_client;

import com.alma.banking.Account;
import com.alma.banking.BankingService;
import com.alma.banking.Transaction;
import com.alma.component.Component;
import com.alma.component.ProvideInterface;
import com.alma.component.RequireInterface;
import com.alma.observer.Observer;
import com.alma.observer.Subject;
import com.alma.server_client.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente le serveur dans le système client-serveur.
 * Implémente Subject pour notifier les observateurs des changements d'état.
 */
public class Server extends Component implements Subject, BankingService {

    private final List<Observer> observers; // Liste des observateurs (clients)
    private boolean stateChanged;

    private ConnectionManager cm;
    private SecurityManager sm;
    private Database db;

    public Server(ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        this.observers = new ArrayList<>();
        this.db = new Database(providedInterface, requiredInterface);
        this.sm = new SecurityManager(this.db, providedInterface, requiredInterface);
        this.cm = new ConnectionManager(this.db, this.sm, providedInterface, requiredInterface);
    }

    // Implémentation des méthodes de Subject

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        if (stateChanged) {
            for (Observer observer : observers) {
                observer.update(message);
            }
            stateChanged = false;
        }
    }

    // Méthode pour changer l'état et notifier les observateurs

    public void changeState() {
        System.out.println("Server: State changed, notifying observers...");
        stateChanged = true;
        notifyObservers("Server state has changed.");
    }

    // Méthodes spécifiques au serveur

    /**
     * Authentifie un utilisateur et génère un token de session.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     * @return le token de session si l'authentification réussit, null sinon
     */
    public String login(String username, String password) {
        stateChanged = true;
        notifyObservers("Attempting to authenticate user: " + username);
        String sessionToken = cm.login(username, password);
        if (sessionToken != null) {
            System.out.println(
                    "Server: User '" + username + "' authenticated successfully. Session token: " + sessionToken);
            notifyObservers("User '" + username + "' authenticated successfully.");
        } else {
            System.out.println("Server: Authentication failed for user '" + username + "'.");
            notifyObservers("Authentication failed for user '" + username + "'.");
        }
        return sessionToken;
    }

    /**
     * Vérifie si la session est valide pour un utilisateur donné.
     *
     * @param username     le nom d'utilisateur
     * @param sessionToken le token de session
     * @return true si la session est valide, false sinon
     */
    public boolean isSessionValid(String username, String sessionToken) {
        boolean valid = sm.isSessionValid(username, sessionToken);
        notifyObservers("Session validation for user '" + username + "': " + (valid ? "Valid" : "Invalid"));
        return valid;
    }

    // Implémentation des méthodes de BankingService

    @Override
    public void createAccount(String accountNumber, double initialBalance) {
        db.createAccount(accountNumber, initialBalance);
        System.out.println("Server: Account " + accountNumber + " created with initial balance " + initialBalance);
        notifyObservers("Account " + accountNumber + " created successfully.");
    }

    @Override
    public void performTransaction(String transactionId, String fromAccount, String toAccount, double amount) {
        Account sourceAccount = db.getAccount(fromAccount);
        Account destinationAccount = db.getAccount(toAccount);
        if (sourceAccount != null && destinationAccount != null) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            Transaction transaction = new Transaction(transactionId, fromAccount, toAccount, amount);
            System.out.println("Server: Transaction " + transactionId + " completed: " + transaction);
            notifyObservers("Transaction " + transactionId + " completed successfully.");
        } else {
            System.out.println("Server: Transaction failed due to invalid account information.");
            notifyObservers("Transaction " + transactionId + " failed.");
        }
    }

}
