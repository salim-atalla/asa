package com.alma.server_client;

import com.alma.component.Component;
import com.alma.component.ProvideInterface;
import com.alma.component.RequireInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Gère la sécurité des sessions utilisateurs.
 */
public class SecurityManager extends Component {

    private Database db;
    private Map<String, String> sessionTokens = new HashMap<>();

    public SecurityManager(Database db, ProvideInterface providedInterface, RequireInterface requiredInterface) {
        super(providedInterface, requiredInterface);
        this.db = db;
    }

    /**
     * Génère un token de session pour un utilisateur.
     *
     * @param username le nom d'utilisateur
     * @return le token de session généré
     */
    public String generateSessionToken(String username) {
        String token = username + "-TOKEN-12345"; // Pour un vrai système, utilisez un générateur de tokens sécurisé
        sessionTokens.put(username, token);
        return token;
    }

    /**
     * Vérifie si le token de session est valide pour un utilisateur donné.
     *
     * @param username     le nom d'utilisateur
     * @param sessionToken le token de session
     * @return true si la session est valide, false sinon
     */
    public boolean isSessionValid(String username, String sessionToken) {
        return sessionTokens.containsKey(username) && sessionTokens.get(username).equals(sessionToken);
    }
}
