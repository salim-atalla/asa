package server_client;

import banking.Account;
import component.Component;
import component.ProvideInterface;
import component.RequireInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the database.
 */
public class Database extends Component {

    private Map<String, String> userCredentials;
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, String> sessionTokens = new HashMap<>();

    public Database(ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        userCredentials = new HashMap<>();
        accounts = new HashMap<>();
        sessionTokens = new HashMap<>();

        // Add some example users
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    /**
     * Retrieves the password for a given username.
     *
     * @param username the username whose password is to be retrieved
     * @return the password if the username exists, null otherwise
     */
    public String getPassword(String username) {
        return userCredentials.get(username);  // Returns null if username does not exist
    }

    /**
     * Adds a new user with a username and password to the database.
     *
     * @param username the username of the new user
     * @param password the password for the new user
     * @return true if the user was added successfully, false if the username already exists
     */
    public boolean addUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return false;  // User already exists
        }
        userCredentials.put(username, password);
        return true;
    }

    /**
     * Removes a user from the database.
     *
     * @param username the username of the user to be removed
     * @return true if the user was removed successfully, false if the user doesn't exist
     */
    public boolean removeUser(String username) {
        if (userCredentials.containsKey(username)) {
            userCredentials.remove(username);
            return true;  // User removed
        }
        return false;  // User does not exist
    }

    /**
     * Adds an account to the database.
     *
     * @param account the account to be added
     */
    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    /**
     * Removes an account from the database.
     *
     * @param accountNumber the account number of the account to be removed
     * @return true if the account was removed successfully, false if the account doesn't exist
     */
    public boolean removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true;  // Account removed
        }
        return false;  // Account does not exist
    }

    /**
     * Retrieves an account by its account number.
     *
     * @param accountNumber the account number of the account to be retrieved
     * @return the account if it exists, null otherwise
     */
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);  // Returns null if account does not exist
    }

    /**
     * Adds a session token for a user to the database.
     *
     * @param username    the username of the user
     * @param sessionToken the session token to be added
     */
    public void addSessionToken(String username, String sessionToken) {
        sessionTokens.put(username, sessionToken);
    }

    /**
     * Removes a session token for a user from the database.
     *
     * @param username the username of the user
     * @return true if the session token was removed successfully, false if the token does not exist
     */
    public boolean removeSessionToken(String username) {
        if (sessionTokens.containsKey(username)) {
            sessionTokens.remove(username);
            return true;  // Session token removed
        }
        return false;  // Session token does not exist
    }

    /**
     * Retrieves the session token for a user.
     *
     * @param username the username whose session token is to be retrieved
     * @return the session token if it exists, null otherwise
     */
    public String getSessionToken(String username) {
        return sessionTokens.get(username);  // Returns null if session token does not exist
    }

    /**
     * Executes a query in the database.
     *
     * @param query the query to execute
     */
    public void executeQuery(String query) {
        // Execute a query in the database
    }
}
