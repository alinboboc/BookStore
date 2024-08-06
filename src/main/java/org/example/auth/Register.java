package org.example.auth;

import org.example.database.DatabaseConnection;
import org.example.tools.Tools;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Register extends Tools {

    private String registerUsername;
    private String registerEmail;
    private String registerPassword;

    public Register() {
        stringSeparator();
        System.out.println("You chose to register a new account.");
        System.out.println("Please chose your username:");
        registerStart();
    }

    private void registerStart() {
        try {
            new DatabaseConnection();
            setQuery("SELECT * FROM users");
            setStmt(conn.prepareStatement(getQuery()));
            setRs(getStmt().executeQuery());
            while (getRs().next()) {
                checkUsernameExistence();
            }
        } catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void checkUsernameExistence() throws SQLException {
        try {
            String userInput = sc.nextLine();
            String usernames = getRs().getString("username");
            if (userInput.equals(usernames)) {
                System.out.println("The username is already registered, please try another username.");
                checkUsernameExistence();
            } else {
                if (isRegisterUsernameValid(userInput)) {
                    setRegisterUsername(userInput);
                    System.out.println("Please enter your email address:");
                    checkEmailExistence();
                } else {
                    System.out.println("The username you chose is not valid, it can contain small letters, big letters, numbers, underscores and points.");
                    checkUsernameExistence();
                }
            }
        } catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void checkEmailExistence() throws SQLException {
        try {
            String userInput = sc.nextLine();
            String databaseEmails = getRs().getString("emailAddress");
            if (userInput.equals(databaseEmails)) {
                System.out.println("The email is already registered, please try another email address.");
                checkEmailExistence();
            } else {
                if (isRegisterEmailValid(userInput)) {
                    setRegisterEmail(userInput);
                    System.out.println("Please enter your desired password:");
                    checkUserPassword();
                } else {
                    System.out.println("The username you chose is not valid, it can contain small letters, big letters, numbers, underscores and points.");
                    checkUsernameExistence();
                }
            }
        } catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void checkUserPassword() throws SQLException {
        try {
            String userInput = sc.nextLine();
            if (isPasswordValid(userInput)) {
                System.out.println("Please confirm the password:");
            } else {
                System.out.println("Password is not valid, it must contain at 8 characters (small letters, big letters, signs)");
                checkUserPassword();
            }
        } catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    //TODO
    // NEED TO FINISH THE checkUserPassword function


    // GETTERS AND SETTERS
    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getRegisterUsername() {
        return registerUsername;
    }

    public void setRegisterUsername(String registerUsername) {
        this.registerUsername = registerUsername;
    }


}
