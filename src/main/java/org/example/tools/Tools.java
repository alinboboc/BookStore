package org.example.tools;

import java.util.Scanner;

public class Tools {

    private boolean isUserLoggedIn;

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    public Scanner sc = new Scanner(System.in);

    public String inputClean(String input) {
        return input.replace(" ", "");
    }
}
