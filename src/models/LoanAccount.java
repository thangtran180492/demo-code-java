package models;

import java.text.NumberFormat;
import java.util.Locale;

public class LoanAccount extends Account implements ReportService, Withdraw{
    final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    final double  LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    @Override
    public void log(double amount) {
        double fee = isPremiunAccount() ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE ;
        Transaction transaction = new Transaction();
        transaction.setTime(new java.util.Date());
        transaction.setAccountNumber(this.accountNumber);
        transaction.setBalance(this.balance);
        transaction.setAmount(amount);
        transaction.setFee(amount * fee);
        this.transactions.add(transaction);
        System.out.println("+--------------------------------+");
        System.out.println("        BIEN LAI GIAO DICH SAVINGS            ");
        transaction.displayTransition();
        System.out.println("+--------------------------------+");

    }

    @Override
    public boolean withdraw(double amount) {
        double fee = isPremiunAccount() ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE  ;
        int total = (int)(LOAN_ACCOUNT_MAX_BALANCE + this.balance - amount - (amount * fee));
        if(amount % 10000 != 0){
            System.out.println("So tien nhap phai la boi cua 10.000");
        }else if(total  < 50000){
            System.out.println("Loan So tien vuot qua han muc hoac han muc con du khong du 50.000 VND" );
        }else {
            this.balance = this.balance - amount - (amount * fee);
            log(amount);
        }
        return true;
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
        return "| " + this.accountNumber + " |   LOAN    |                " + amount + " VND";
    }
}
