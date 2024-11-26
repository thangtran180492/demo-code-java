package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    String ID;
    Date time;
    String accountNumber;
    double balance;
    double amount;
    double fee;

    Transaction(){
        this.ID = String.valueOf(UUID.randomUUID());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void displayTransition(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = formatter.format(this.time);
        System.out.println(" NGAY G/D :         " + strDate);
        System.out.println(" ATM ID:            DIGITAL-BANK-ATM 2022");
        System.out.printf(" SO TK:                       %s\n", accountNumber);
        System.out.printf(" SO TIEN:            %11.2f VND \n" , amount);
        System.out.printf(" SO DU:              %11.2f VND \n" ,balance);
        System.out.printf(" PHI + VAT           %11.2f VND \n" ,fee);
    }
}
