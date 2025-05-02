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

## Screenshots


![homescreen screenshot](https://github.com/user-attachments/assets/ac0bc5f5-0e53-4cb4-812a-00f439e86bc9)


![Screenshot 2025-05-02 041722](https://github.com/user-attachments/assets/9eb84afd-26fc-4384-96f3-55ecf2475406)


![Screenshot 2025-05-02 041932](https://github.com/user-attachments/assets/202b5724-8a4d-46a9-8c86-6c0de59b98a7)


![Screenshot 2025-05-02 042826](https://github.com/user-attachments/assets/7dad43c9-fea0-4691-b435-523cd6f94d70)





