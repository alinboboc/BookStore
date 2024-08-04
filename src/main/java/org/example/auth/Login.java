package org.example.auth;

import org.example.database.DatabaseConnection;

public class Login {

    public Login() {
        System.out.println("LOGIN");
        new DatabaseConnection();
    }
}
