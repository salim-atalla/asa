package com.alma.banking;

/**
 * Représente un utilisateur du système bancaire.
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructeur pour créer un nouvel utilisateur.
     *
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Récupère le nom d'utilisateur.
     *
     * @return le nom d'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     * Récupère le mot de passe.
     *
     * @return le mot de passe
     */
    public String getPassword() {
        return password;
    }
}
