# Accounting Ledger App

This project is a command-line Java application designed to help users track their financial transactions, such as deposits and payments. The application allows users to add transactions, view the ledger, and generate financial reports. All data is stored in a CSV file (transactions.csv) to persist between sessions.


## Features

- Add Transactions: Add deposits (positive amounts) or payments (negative amounts) with the following details: date, time, description, vendor, and amount.

- Persistent Storage: Transactions are saved to and loaded from a CSV file (transactions.csv) upon startup and exit.

- Ledger Views

- Formatted Output: Transaction lists are displayed in a clear, formatted table with box-drawing characters and color-coded amounts (green for deposits and red for payments).

- Reports: Generated reports for specific time periods such as: Month To Date, Previous Months, Year To Date, & Previous Year.


- Increased Search Functionality by allowing the user to search transactions by vendor name, as well as custom search criteria.

## Project Structure 
The project is composed of the following classes:

- Accounting Ledger App: The main application class, containing the main method, which controls the flow of the application. It manages the user interface (menus) and calls methods from other classes to add transactions, display the ledger, and generate reports.

- Transaction: Represents a single financial transaction, including properties such as date/time, description, vendor, and amount. This class includes methods for saving transactions to the CSV file and reading them from the file.

- Ledger: Manages the transaction ledger, providing methods to display all transactions, filter by deposits or payments, and generate various reports. This class also handles loading the transactions from the CSV file.
