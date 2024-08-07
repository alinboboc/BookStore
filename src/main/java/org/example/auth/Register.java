package org.example.auth;

import org.example.database.DatabaseConnection;
import org.example.tools.Tools;

import java.sql.SQLException;

public class Register extends Tools {

    private String registerUsername;
    private String registerEmail;
    private String registerPassword;
    private String registerFirstName;
    private String registerLastName;
    private String registerPersonalID;

    public Register() {
        stringSeparator();
        System.out.println("You chose to register a new account.");
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
            System.out.println("Please chose your username:");
            String userInput = sc.nextLine();
            String usernames = getRs().getString("username");
            if (userInput.equals(usernames)) {
                System.out.println("The username is already registered, please try another username.");
                checkUsernameExistence();
            } else {
                if (isRegisterUsernameValid(userInput)) {
                    setRegisterUsername(userInput);
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
            System.out.println("Please enter your email address:");
            String userInput = sc.nextLine();
            String databaseEmails = getRs().getString("emailAddress");
            if (userInput.equals(databaseEmails)) {
                System.out.println("The email is already registered, please try another email address.");
                checkEmailExistence();
            } else {
                if (isRegisterEmailValid(userInput)) {
                    setRegisterEmail(userInput);
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
            System.out.println("Please enter your desired password:");
            String userInput = sc.nextLine();
            if (isPasswordValid(userInput)) {
                System.out.println("Please confirm the password:");
                String passUserInputConfirmation = sc.nextLine();
                    if(passUserInputConfirmation.equals(userInput)){
                        setRegisterPassword(passUserInputConfirmation);
                        addFirstName();
                    }else{
                        System.out.println("The passwords don't match, please try again.");
                        checkUserPassword();
                    }
            } else {
                System.out.println("Password is not valid, it must contain at 8 characters (small letters, big letters, signs)");
                checkUserPassword();
            }
        } catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void addFirstName() throws SQLException{
        try{
            System.out.println("Please enter your first name:");
            String userInput = sc.nextLine();
            if(isNameValid(userInput)){
                setRegisterFirstName(userInput);
                addLastName();
            }else{
                System.out.println("The first name is not valid, please try again.");
                addFirstName();
            }
        }catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void addLastName() throws SQLException{
        try{
            System.out.println("Please enter your last name:");
            String userInput = sc.nextLine();
            if(isNameValid(userInput)){
                setRegisterLastName(userInput);
                addPersonalID();
            }else{
                System.out.println("The last name is not valid, please try again.");
                addFirstName();
            }
        }catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void addPersonalID () throws SQLException{
        try{
            System.out.println("Please enter your personal ID:");
            String userInput = sc.nextLine();
            if(isPersonalIDValid(userInput)){
                setRegisterPersonalID(userInput);
                accountCreator();
            }else{
                System.out.println("The personal ID is not valid, it must contain 13 numbers.");
                addPersonalID();
            }
        }catch (SQLException ex) {
            returnSQLMessage(ex);
        }
    }

    private void accountCreator(){
        System.out.println("Account creating process");
        System.out.println(getRegisterUsername());
        System.out.println(getRegisterEmail());
        System.out.println(getRegisterPassword());
        System.out.println(getRegisterFirstName());
        System.out.println(getRegisterLastName());
        System.out.println(getRegisterPersonalID());

    }

    //TODO
    // *create the accountCreator class


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

    public String getRegisterLastName() {
        return registerLastName;
    }

    public void setRegisterLastName(String registerLastName) {
        this.registerLastName = registerLastName;
    }

    public String getRegisterFirstName() {
        return registerFirstName;
    }

    public void setRegisterFirstName(String registerFirstName) {
        this.registerFirstName = registerFirstName;
    }

    public String getRegisterPersonalID() {
        return registerPersonalID;
    }

    public void setRegisterPersonalID(String registerPersonalID) {
        this.registerPersonalID = registerPersonalID;
    }
}
