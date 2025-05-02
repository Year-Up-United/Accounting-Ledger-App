package com.pluralsight;
// add scanner
import java.io.*;
import java.util.Scanner;

// import built in classes
import java.time.LocalDate;
import java.time.LocalTime;

// file + list things for saving & loading
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


    // create a method to return *reader
    public List<Transaction> readAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                // skip malformed lines
                if (parts.length != 5) continue;

                String date = parts[0].trim();
                String time = parts[1].trim();
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("ERROR READING TRANSACTIONS: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ERROR PARSING AMOUNT IN TRANSACTION: " + e.getMessage());
        }

        return transactions;

    }
}