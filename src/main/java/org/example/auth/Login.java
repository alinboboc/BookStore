package org.example.auth;

import org.example.database.DatabaseConnection;
import org.example.pages.StoreMainPage;
import org.example.pages.WelcomePage;
import org.example.tools.Tools;

import java.sql.SQLException;

public class Login extends Tools {

    public Login() {
        stringSeparator();
        System.out.println("You chose to login into your account.");
        System.out.println("Please enter your username:");
        String inputUser = sc.nextLine();
        try {
            new DatabaseConnection();
            setQuery("SELECT * FROM users");
            setStmt(conn.prepareStatement(getQuery()));
            setRs(getStmt().executeQuery());
            while (getRs().next()) {
                usernameCheck(inputUser);
            }
        } catch (SQLException ex) {
            System.out.println("-----SQL_ERROR-----");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    private void usernameCheck(String inputUser) throws SQLException {
        String username = getRs().getString("username");
        if (username.equals(inputUser)) {
            passwordCheck();
        } else {
            System.out.println("The username you provided is not registered, you will be redirected to the welcome page.");
            new WelcomePage();
        }
    }

    int maxPasswordInputs = 3;

    private void passwordCheck() throws SQLException {
        if (maxPasswordInputs == 0) {
            System.out.println("The maximum logins have been reached, you will be returned to the main page.");
            new WelcomePage();
        }
        System.out.println("Enter your password:");
        String inputPassword = sc.nextLine();
        if (inputPassword.equals(getRs().getString("userPassword"))) {
            setUserLoggedIn(true);
            new StoreMainPage();
        } else {
            maxPasswordInputs--;
            if (maxPasswordInputs != 0) {
                System.out.println("The password is not ok, you have " + maxPasswordInputs + " attempts.");
            }
            passwordCheck();
        }
    }
}
