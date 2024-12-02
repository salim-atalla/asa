// Fichier : banking/User.java
package banking;

/**
 * Représente un utilisateur du système bancaire.
 */
public class User {
    private String username;
    private String password; // Dans un système réel, les mots de passe devraient être hachés.

    /**
     * Constructeur de la classe User.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retourne le nom d'utilisateur.
     *
     * @return le nom d'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retourne le mot de passe.
     *
     * @return le mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retourne une représentation textuelle de l'utilisateur.
     *
     * @return une chaîne de caractères représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
