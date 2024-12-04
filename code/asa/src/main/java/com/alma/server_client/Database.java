package com.alma.server_client;

import com.alma.banking.Account;
import com.alma.component.Component;
import com.alma.component.ProvideInterface;
import com.alma.component.RequireInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant la base de données.
 */
public class Database extends Component {

    private Map<String, String> userCredentials;
    private Map<String, Account> accounts;

    public Database(ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        userCredentials = new HashMap<>();
        accounts = new HashMap<>();

        // Ajouter des utilisateurs d'exemple
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    /**
     * Récupère le mot de passe pour un nom d'utilisateur donné.
     *
     * @param username le nom d'utilisateur dont le mot de passe est à récupérer
     * @return le mot de passe si le nom d'utilisateur existe, null sinon
     */
    public String getPassword(String username) {
        return userCredentials.get(username); // Retourne null si l'utilisateur n'existe pas
    }

    /**
     * Ajoute un nouvel utilisateur avec un nom d'utilisateur et un mot de passe à
     * la base de données.
     *
     * @param username le nom d'utilisateur du nouvel utilisateur
     * @param password le mot de passe pour le nouvel utilisateur
     * @return true si l'utilisateur a été ajouté avec succès, false si le nom
     *         d'utilisateur existe déjà
     */
    public boolean addUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return false; // L'utilisateur existe déjà
        }
        userCredentials.put(username, password);
        return true;
    }

    /**
     * Supprime un utilisateur de la base de données.
     *
     * @param username le nom d'utilisateur de l'utilisateur à supprimer
     * @return true si l'utilisateur a été supprimé avec succès, false si
     *         l'utilisateur n'existe pas
     */
    public boolean removeUser(String username) {
        if (userCredentials.containsKey(username)) {
            userCredentials.remove(username);
            return true; // Utilisateur supprimé
        }
        return false; // L'utilisateur n'existe pas
    }

    /**
     * Crée un compte dans la base de données.
     *
     * @param accountNumber  le numéro de compte
     * @param initialBalance le solde initial
     */
    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Database: Account " + accountNumber + " created with balance " + initialBalance);
        } else {
            System.out.println("Database: Account " + accountNumber + " already exists.");
        }
    }

    /**
     * Supprime un compte de la base de données.
     *
     * @param accountNumber le numéro de compte du compte à supprimer
     * @return true si le compte a été supprimé avec succès, false si le compte
     *         n'existe pas
     */
    public boolean removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true; // Compte supprimé
        }
        return false; // Le compte n'existe pas
    }

    /**
     * Récupère un compte par son numéro de compte.
     *
     * @param accountNumber le numéro de compte du compte à récupérer
     * @return le compte s'il existe, null sinon
     */
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber); // Retourne null si le compte n'existe pas
    }

    /**
     * Exécute une requête dans la base de données.
     *
     * @param query la requête à exécuter
     */
    public void executeQuery(String query) {
        // Implémentation de l'exécution d'une requête
    }
}
