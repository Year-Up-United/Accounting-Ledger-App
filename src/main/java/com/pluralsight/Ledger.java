package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ledger {

    public static void ledgerMenu(Scanner scanner){
        boolean inLedger = true;

        while (inLedger) {
            System.out.println();
            System.out.println("LEDGER MENU:");
            System.out.println("A) - VIEW ALL TRANSACTIONS");
            System.out.println("D) - VIEW DEPOSITS");
            System.out.println("P) - VIEW PAYMENTS");
            System.out.println("H) - RETURN HOME");
            System.out.println("CHOOSE AN OPTION: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch(choice) {
                case "A":
                    displayTransactions("ALL");
                    break;
                case "D":
                    displayTransactions("DEPOSITS");
                    break;
                case "P":
                    displayTransactions("PAYMENTS");
                    break;
                case "H":
                    inLedger = false;
                    break;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
    public static void displayTransactions(String filter) {
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);
        System.out.println("\n--- " + filter + " TRANSACTIONS ---");
        for (Transaction t : transactions) {
            if (filter.equals("ALL") ||
                    (filter.equals("DEPOSITS") && t.getAmount() > 0) ||
                    (filter.equals("PAYMENTS") && t.getAmount() < 0)) {
                System.out.println(t);
            }
        }
    }
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        File file = new File("transactions.csv");
        if (!file.exists()) {
            return transactions;
        }
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Transaction transaction = Transaction.fromCSV(line);
                transactions.add(transaction);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("ERROR READING TRANSACTIONS: " + e.getMessage());
        }
        return transactions;
    }
}

