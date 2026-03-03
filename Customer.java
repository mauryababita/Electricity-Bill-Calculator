package com.example.electricitybill.model;

public class Customer {
    private String name;
    private int prevReading;
    private int currReading;
    private double billAmount;

    public Customer() {}

    public Customer(String name, int prevReading, int currReading, double billAmount) {
        this.name = name;
        this.prevReading = prevReading;
        this.currReading = currReading;
        this.billAmount = billAmount;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPrevReading() { return prevReading; }
    public void setPrevReading(int prevReading) { this.prevReading = prevReading; }
    public int getCurrReading() { return currReading; }
    public void setCurrReading(int currReading) { this.currReading = currReading; }
    public double getBillAmount() { return billAmount; }
    public void setBillAmount(double billAmount) { this.billAmount = billAmount; }
}
