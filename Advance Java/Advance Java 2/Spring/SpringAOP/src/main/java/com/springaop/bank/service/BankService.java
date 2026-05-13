package com.springaop.bank.service;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    private double balance = 10000;

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero.");
        }

        balance = balance + amount;

        System.out.println("BANK: Rs. " + amount + " deposited successfully.");
        System.out.println("BANK: Current balance is Rs. " + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Withdraw amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new RuntimeException("Insufficient balance.");
        }

        balance = balance - amount;

        System.out.println("BANK: Rs. " + amount + " withdrawn successfully.");
        System.out.println("BANK: Current balance is Rs. " + balance);
    }

    public void transferMoney(String receiverName, double amount) {

        if (receiverName == null || receiverName.isBlank()) {
            throw new RuntimeException("Receiver name cannot be empty.");
        }

        if (amount <= 0) {
            throw new RuntimeException("Transfer amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new RuntimeException("Transfer failed due to insufficient balance.");
        }

        balance = balance - amount;

        System.out.println("BANK: Rs. " + amount + " transferred to " + receiverName);
        System.out.println("BANK: Current balance is Rs. " + balance);
    }

    public double checkBalance() {

        System.out.println("BANK: Fetching current balance...");
        return balance;
    }
}