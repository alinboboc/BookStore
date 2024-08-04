package org.example.pages;

import org.example.tools.Tools;
import org.example.func.*;

public class StoreMainPage extends Tools {

    public StoreMainPage() {
        setUserLoggedIn(false);
        StoreMainPageWelcomeMessage();
        userChoice();
    }

    private void StoreMainPageWelcomeMessage() {
        System.out.println("Welcome to BookStore!");
        System.out.println("Please choose a option from below:");
        System.out.println("1. Search by book title");
        System.out.println("2. Search by book author");
        System.out.println("3. Search by book genre");
        System.out.println("4. Search by book ISBN");
        System.out.println("5. List all titles");
        System.out.println("6. List all author");
        System.out.println("7. List all genre");
        System.out.println("8. Random recommendation");
        System.out.println("9. Back");
    }

    private void userChoice() {
        String userInput = sc.nextLine();
        userInput = inputClean(userInput);

        switch (userInput) {
            case "1":
                new ByBookTitle();
                break;
            case "2":
                new ByBookAuthor();
                break;
            case "3":
                new ByBookGenre();
                break;
            case "4":
                new ByBookISBN();
                break;
            case "5":
                new AllTitles();
                break;
            case "6":
                new AllAuthors();
                break;
            case "7":
                new AllGenres();
                break;
            case "8":
                new RandomRecommendation();
                break;
            case "9":
                new WelcomePage();
                break;
            default:
                System.out.println("The input you provided is not valid, please try again.");
                userChoice();
        }
    }
}
