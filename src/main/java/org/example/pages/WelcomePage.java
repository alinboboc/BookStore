package org.example.pages;

import org.example.auth.Login;
import org.example.auth.Register;
import org.example.tools.Tools;

import java.sql.SQLException;

public class WelcomePage extends Tools {

    public WelcomePage() throws SQLException {
        welcomeMessage();
        userChoice();
    }

    private void welcomeMessage() {
        stringSeparator();
        System.out.println("Welcome to BookStore!");
        System.out.println("Please choose a option from below:");
        System.out.println("1. Continue as a guest");
        System.out.println("2. Login");
        System.out.println("3. Create a new account");
        System.out.println("4. Leave the store");
    }

    private void userChoice() throws SQLException {
        String userInput = sc.nextLine();
        userInput = inputClean(userInput);

        switch (userInput) {
            case "1":
                new StoreMainPage();
                break;
            case "2":
                new Login();
                break;
            case "3":
                new Register();
                break;
            case "4":
                break;
            default:
                System.out.println("The input you provided is not valid, please try again.");
                userChoice();
        }
    }
}
