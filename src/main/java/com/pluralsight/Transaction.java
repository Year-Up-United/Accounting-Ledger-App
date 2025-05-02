package com.pluralsight;

public class Transaction {

    // define variables needed
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    // add constructor
    public  Transaction(String date, String time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // add getters and setters for this

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    // Print out of what is being returned
    public String toString() {
        return date + " | " + time + " | " + description + " | " + vendor + " | " + amount;

        // convert date/time into Strings
        String dateString = date.toString();
        String timeString = time.toString();

    // create Transaction object
        Transaction deposit = new Transaction(dateString, timeString, description, vendor, amount);

    // print it out to confirm it worked
        System.out.println("YOUR TRANSACTION OBJECT:");
        System.out.println(deposit);




    }
}


