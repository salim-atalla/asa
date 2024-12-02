package server_client;

import component.Component;
import component.ProvideInterface;
import component.RequireInterface;

import javax.xml.crypto.Data;

/**
 * Class representing the security manager.
 */
public class SecurityManager extends Component {

    private Database db;

    public SecurityManager(Database db, ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        this.db = db;
    }

    /**
     * Verifies the security of user credentials.
     *
     * @param username the username
     * @param password the password
     * @return true if the user passes the security check
     */
    public boolean verifyUser(String username, String password) {

        String passwordToVerify = this.db.getPassword(username);

        if (passwordToVerify == password) {
            // Optionally, perform additional security checks, such as password strength or two-factor authentication
            return true;  // If credentials are correct, return true
        }
        return false;  // If credentials are incorrect, return false
    }
}
