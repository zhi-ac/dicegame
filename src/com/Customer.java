package com;

public class Customer {
    int id;
    String guess;
    String threeDices;
    int dicesSum;
    String dicesResult;
    String endResult;

    public Customer(int id, String guess, String threeDices, int dicesSum, String dicesResult, String endResult) {
        this.id = id;
        this.guess = guess;
        this.threeDices = threeDices;
        this.dicesSum = dicesSum;
        this.dicesResult = dicesResult;
        this.endResult = endResult;
    }

    @Override
    public String toString() {
        return String.format("%6s|", id) + String.format("%10s|", guess) + String.format("%15s|", threeDices)
                + String.format("%10s|", dicesSum) + String.format("%14s|", dicesResult) + String.format("%10s|", endResult);
    }
}
