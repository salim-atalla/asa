package com.alma.server_client;

import com.alma.component.Component;
import com.alma.component.ProvideInterface;
import com.alma.component.RequireInterface;

/**
 * Gère les connexions et l'authentification des utilisateurs.
 */
public class ConnectionManager extends Component {

    private Database db;
    private SecurityManager sm;

    public ConnectionManager(Database db, SecurityManager sm, ProvideInterface providedInterface,
            RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        this.db = db;
        this.sm = sm;
    }

    /**
     * Authentifie un utilisateur et génère un token de session.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     * @return le token de session si l'authentification réussit, null sinon
     */
    public String login(String username, String password) {
        // Logique d'authentification
        String storedPassword = db.getPassword(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            String sessionToken = sm.generateSessionToken(username);
            return sessionToken;
        }
        return null;
    }
}
