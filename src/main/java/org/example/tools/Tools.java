package org.example.tools;

import org.example.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools extends DatabaseConnection {

    //GENERAL VARIABLES

    public Scanner sc = new Scanner(System.in);

    private boolean isUserLoggedIn;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private String query = null;

    protected void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    // TEXT SEPARATORS
    public void stringSeparator() {
        System.out.println("----------");
    }

    //GETTERS AND SETTERS

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    //DATA VALIDATORS

    public String inputClean(String input) {
        return input.replace(" ", "");
    }

    public boolean isRegisterUsernameValid(String userInput) {
        String regex = "^[a-zA-Z._]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    public boolean isRegisterEmailValid(String userInput) {
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    public boolean isPasswordValid(String userInput) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    public boolean isNameValid(String userInput) {
        String regex = "^[a-zA-Z'-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    public boolean isPersonalIDValid(String userInput) {
        final int ROM_ID_LENGTH = 13;
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        if (userInput.length() < ROM_ID_LENGTH) {
            return false;
        } else {
            return matcher.matches();
        }
    }

    //DEFAULT MESSAGES
    public void returnSQLMessage(SQLException ex) {
        System.out.println("-----SQL_ERROR-----");
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}
