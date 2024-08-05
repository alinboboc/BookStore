package org.example.tools;

import org.example.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Tools extends DatabaseConnection {

    public Scanner sc = new Scanner(System.in);

    private boolean isUserLoggedIn;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private String query = null;

    protected void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    public String inputClean(String input) {
        return input.replace(" ", "");
    }

    public void stringSeparator() {
        System.out.println("----------");
    }

    //getters and setters

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

}
