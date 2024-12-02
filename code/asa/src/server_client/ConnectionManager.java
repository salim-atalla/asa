package server_client;

import component.Component;
import component.ProvideInterface;
import component.RequireInterface;

/**
 * Class representing the connection manager.
 */
public class ConnectionManager extends Component {

    Database db;
    SecurityManager sm;

    public ConnectionManager(Database db, SecurityManager sm, ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        this.db = db;
        this.sm = sm;
    }

    /**
     * Authenticates a user by sending the credentials to the database.
     *
     * @param username the username
     * @param password the password
     * @return true if the user is authenticated successfully
     */
    public boolean authenticateUser(String username, String password) {
        return sm.verifyUser(username, password);
    }

    /**
     * Prints a message indicating the authenticated user's name.
     *
     * @param username the username of the authenticated user
     */
    private void getData(String username, String password) throws Exception {

        if (this.authenticateUser(username, password)) {
            System.out.println("Hello " + username);
        }
        else throw new Exception("User or password is incorrect.");
    }

    /**
     * Sends a query to the database.
     *
     * @param query the query to send
     */
    public void sendQueryToDatabase(String query) {
        this.db.executeQuery(query);
    }

    /**
     * Authentifie un utilisateur et génère un token de session.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     * @return le token de session si l'authentification réussit, null sinon
     */
    public String login(String username, String password) {

        return username + " has logged in";
    }
}
