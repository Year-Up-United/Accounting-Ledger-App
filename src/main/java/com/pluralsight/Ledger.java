package com.pluralsight;
import java.time.LocalDate;
import java.time.YearMonth;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Ledger {

    public static void ledgerMenu(Scanner scanner){
        boolean inLedger = true;

        while (inLedger) {
            System.out.println();
            System.out.println("LEDGER MENU:");
            System.out.println("A) - VIEW ALL TRANSACTIONS");
            System.out.println("D) - VIEW DEPOSITS");
            System.out.println("P) - VIEW PAYMENTS");
            System.out.println("R) - REPORTS");
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
                case "R":
                    reportsMenu(scanner);
                    break;
                case "H":
                    inLedger = false;
                    break;
                default:
                    System.out.println("INVALID OPTION.");
            }
        }
    }
    public static void displayTransactions(String filter) {
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);
        System.out.println("\n--- " + filter + " TRANSACTIONS ---");

        // debug output
        System.out.println("NUMBER OF TRANSACTIONS LOADED: " + transactions.size());
        for (Transaction t : transactions) {

            // checks to see of the transaction matches the filter (all. deposits, payments)
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
        System.out.println("LOOKING FOR FILE: " + file.getAbsolutePath());
        System.out.println("DOES FILE EXIST?" + file.exists());

        // if statements
        if (!file.exists()) {
            System.out.println("TRANSACTIONS.CSV FILE DOES NOT EXIST");
            return transactions;
        }
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("LINE: " + line);
                String[] parts = line.split("\\|");
                System.out.println("PARTS LENGTH: " + parts.length);
                if (parts.length !=5) continue;


                Transaction transaction = Transaction.fromCSV(line);
                System.out.println("TRANSACTION ADDED!" + transaction);
                transactions.add(transaction);
            }
            fileScanner.close();
            System.out.println("TRANSACTIONS LOADED: " + transactions.size());
        } catch (IOException e) {
            System.out.println("ERROR READING TRANSACTIONS: " + e.getMessage());
        }
        return transactions;
    }

    // NEW REPORTS MENU METHOD
    public static void reportsMenu(Scanner scanner) {
        boolean inReports = true;

        while (inReports) {
            System.out.println();
            System.out.println("REPORTS MENU:");
            System.out.println("1) - MONTH TO DATE");
            System.out.println("2) - PREVIOUS MONTH");
            System.out.println("3) - YEAR TO DATE");
            System.out.println("4) - PREVIOUS YEAR");
            System.out.println("5) - SEARCH BY VENDOR");
            System.out.println("0) - BACK");
            System.out.print("CHOOSE AN OPTION: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    filterMonthToDate();
                    break;
                case "2":
                    filterPreviousMonth();
                    break;
                case "3":
                    filterYearToDate();
                    break;
                case "4":
                    filterPreviousYear();
                    break;
                case "5":
                    searchByVendor(scanner);
                    break;
                case "0":
                    inReports = false;
                    break;
                default:
                    System.out.println("INVALID OPTION!");
            }
        }
    }

    // filter method for records
    public static void filterMonthToDate() {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(today);
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);

        System.out.println("\n--- MONTH TO DATE TRANSACTIONS ---");
        for (Transaction t : transactions) {
            LocalDate transDate = LocalDate.parse(t.getDate());
            if (YearMonth.from(transDate).equals(currentMonth)) {
                System.out.println(t);
            }
        }
    }

    public static void filterPreviousMonth() {
        LocalDate today = LocalDate.now();
        YearMonth previousMonth = YearMonth.from(today).minusMonths(1);
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);

        System.out.println("\n--- PREVIOUS MONTH TRANSACTIONS ---");
        for (Transaction t : transactions) {
            LocalDate transDate = LocalDate.parse(t.getDate());
            if (YearMonth.from(transDate).equals(previousMonth)) {
                System.out.println(t);
            }
        }
    }

    public static void filterYearToDate() {
        int currentYear = LocalDate.now().getYear();
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);

        System.out.println("\n--- YEAR TO DATE TRANSACTIONS ---");
        for (Transaction t : transactions) {
            LocalDate transDate = LocalDate.parse(t.getDate());
            if (transDate.getYear() == currentYear) {
                System.out.println(t);
            }
        }
    }

    public static void filterPreviousYear() {
        int previousYear = LocalDate.now().getYear() - 1;
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);

        System.out.println("\n--- PREVIOUS YEAR TRANSACTIONS ---");
        for (Transaction t : transactions) {
            LocalDate transDate = LocalDate.parse(t.getDate());
            if (transDate.getYear() == previousYear) {
                System.out.println(t);
            }
        }
    }

    public static void searchByVendor(Scanner scanner) {
        System.out.print("ENTER VENDOR NAME TO SEARCH: ");
        String vendorSearch = scanner.nextLine().trim().toLowerCase();
        List<Transaction> transactions = loadTransactions();
        Collections.reverse(transactions);

        System.out.println("\n--- TRANSACTIONS FOR VENDOR: " + vendorSearch.toUpperCase() + " ---");
        boolean found = false;
        for (Transaction t : transactions) {
            if (t.getVendor().trim().toLowerCase().contains(vendorSearch)) {
                System.out.println(t);
                found = true;
            }
        }
    }
}

