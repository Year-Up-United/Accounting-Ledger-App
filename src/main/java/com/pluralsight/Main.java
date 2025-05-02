package com.pluralsight;
// add scanner
import java.util.Scanner;

// import built in classes
import java.time.LocalDate;
import java.time.LocalTime;

// file + list things for saving & loading
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        while (running) {
            System.out.println(); // space in between

            // tell customer to select the following
            System.out.println("\uD81B\uDE6D SELECT FROM  THE FOLLOWING:");

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
                    addTransaction(scanner, true);
                    break;
                case "P":
                    addTransaction(scanner, false);
                    break;
                case "L":
                    Ledger.ledgerMenu(scanner);
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

    // add method to get information for deposits
    public static void addTransaction(Scanner scanner, boolean isDeposit) {
        // for description
        System.out.println(isDeposit ? "ENTER A DESCRIPTION FOR YOUR DEPOSIT: " : "ENTER A DESCRIPTION FOR YOUR PAYMENT");
        String description = scanner.nextLine();

        // for vendor
        System.out.println("ENTER A VENDOR: ");
        String vendor = scanner.nextLine();

        // for amount
        System.out.println("ENTER AN AMOUNT: ");
        double amount = scanner.nextDouble();

        // clear the new line
        scanner.nextLine();

        if (!isDeposit && amount > 0) {
            amount = -amount; // this makes payments negative
        }


        // get current date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().withNano(0);

        // create transaction object
        Transaction transaction = new Transaction(
                date.toString(),
                time.toString(),
                description,
                vendor,
                amount
        );

        // save to csv
        try {
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(transaction.toCSV() + "\n");
            writer.close();
            System.out.println("YOUR TRANSACTION WAS SAVED!");
        } catch (IOException e) {
            System.out.println("ERROR SAVING TRANSACTION: " + e.getMessage());
        }
        System.out.println("TRANSACTION RECORDED:");
        System.out.println(transaction);
    }

        }

        // statements to display for deposit information
//        System.out.println("YOU ENTERED: ");
//        System.out.println("DESCRIPTION: " + description);
//        System.out.println("VENDOR: " + vendor);
//        System.out.println("AMOUNT: " + amount);
//        System.out.println("DATE: " + date);
//        System.out.println("TIME: " + time);
//


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




