package com.pluralsight;
// add scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Accounting Ledger App Capstone

    // add scanner
    Scanner scanner = new Scanner(System.in);

    // loop to keep user in app until they exit
    boolean running = true;

    // Welcome message & home-screen
    System.out.println("WELCOME TO THE DOLL BANK! \uD81B\uDE6D ");

    // run loop
    while (running){
    System.out.println(); // space in between

    // tell customer to select the following
    System.out.println("\uD81B\uDE6D SELECT FROM THE FOLLOWING:");

    // ask what the customer's need
    System.out.println("D) - ADD DEPOSIT");
    System.out.println("P) - MAKE PAYMENT (DEBIT)");
    System.out.println("L) - LEDGER");
    System.out.println("X) - EXIT");

    // ask customer to choose an option
    System.out.println("PLEASE PICK AN OPTION! \uD81B\uDE6D");

        String choice = scanner.nextLine().trim().toUpperCase();

        switch (choice) {
            case "D":
                System.out.println("LET'S ADD A DEPOSIT!");
                break;
            case "P":
                System.out.println("LET'S MAKE A PAYMENT!");
                break;
            case "L":
                System.out.println("HERE'S YOUR ACCOUNT LEDGER!");
                break;
            case "X":
                System.out.println("THANKS FOR BANKING WITH THE DOLLS!");
                running = false;
                break;
            default:
                System.out.println("NOT A VALID OPTION! LET'S TRY AGAIN.");
                break;
        }
    }

        scanner.close();
    }



    // what is needed (HomeScreen)
    //      Home Screen
    //      - The home screen should give the user the following options. The
    //        application should continue to run until the user chooses to exit.
    //
    //      Add Deposit
    //      - prompt user for the deposit information and
    //        save it to the csv file
    //
    //      Make Payment (Debit)
    //      - prompt user for the debit
    //        information and save it to the csv file
    //
    //      Ledger
    //      - display the ledger screen
    //
    //      Exit
    //      - exit the application






    }
