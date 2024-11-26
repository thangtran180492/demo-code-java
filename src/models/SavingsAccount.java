package models;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class SavingsAccount extends Account implements ReportService, Withdraw {
    final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    @Override
    public void log(double amount) {
        if((int)amount % 10000 != 0){
            System.out.println("So tien nhap phai la boi cua 10000");
        }else if(isPremiunAccount() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW){
            System.out.println("neu khong phai tai khoan Primedium thi khong the rut hon 5,000,000 VND");
        } else if (this.balance - amount < 0) {
            System.out.println("So tien rut lon hon so tien trong tai khoan");
        }else {
            Transaction transaction = new Transaction();
            transaction.setTime(new java.util.Date());
            transaction.setAccountNumber(this.accountNumber);
            transaction.setAmount(amount);
            transaction.setBalance(this.balance);
            this.transactions.add(transaction);
            System.out.println("+--------------------------------+");
            System.out.println("        BIEN LAI GIAO DICH SAVINGS            ");
            transaction.displayTransition();
            System.out.println("+--------------------------------+");
        }
    }

    @Override
    public boolean withdraw(double amount){
        boolean check = false;
        if((int)amount % 10000 != 0){
            log(amount);
        }else if(isPremiunAccount()){
            if(this.balance - amount >= 0) {
                this.balance = this.balance - amount;
                log(amount);
                check = true;
            }else {
                log(amount);
            }
        }else {
            if(amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW && this.balance - amount >= 0) {
                this.balance = this.balance - amount;
                log(amount);
                check = true;
            }else {
                log(amount);
            }
        }
        return check;
    }

    @Override
    public boolean isAccepted(double amount) {
        return false;
    }

    @Override
    public String toString() {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String amount = en.format((int)this.balance);
        return "| " + this.accountNumber + " |   Savings |                " + amount + " VND";
    }
}
