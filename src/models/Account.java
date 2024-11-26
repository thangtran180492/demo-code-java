package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Account {
    String accountNumber;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    Account(){
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double newBalance){
        this.balance = this.balance + newBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String newAccountNumber) throws Exception{
        if(newAccountNumber.length() != 6){
            throw new Exception("ma so tai khoan phai co 6 ky tu");
        }
        this.accountNumber = newAccountNumber;
    }

    @Override
    public String toString() {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String amount = en.format((int)this.balance);
        return "| " + this.accountNumber + " |                            " + amount + " VND";
    }
    public boolean isPremiunAccount(){
        return (int)this.balance >= 10000000;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
