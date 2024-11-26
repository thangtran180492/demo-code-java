package models;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer extends User {
    List<Account> accounts = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }

    public boolean isPremiumAccount(){
        for (Account a : accounts){
            if(a.isPremiunAccount())
                return true;
        }
        return false;
    }

    public double getBalance(){
        double balance = 0;

        for(int i = 0; i < accounts.size(); i++){
            balance = balance + accounts.get(i).balance;
        }
        return balance;
    }

    public void  displayInformation(){
        String premium = isPremiumAccount() ? "Premium" : "       ";

        System.out.printf("%s |     %s | %s  | %12.2f VND \n",customerId,  name, premium, getBalance());
        for (Account accountCurrent: accounts){
            String type = (accountCurrent instanceof SavingsAccount) ? "SAVINGS" : "LOAN   " ;
            System.out.printf("| %s | %s                  | %11.2f VND \n", accountCurrent.accountNumber, type, accountCurrent.balance);
        }
        System.out.println();
    }
    public void  displayTransition(){

        System.out.println("     Account |            Amount|                   Time|         TrainsitionID");
        for (Account accountCurrent: accounts){
            for(Transaction transaction: accountCurrent.getTransactions()){
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String strDate = formatter.format(transaction.getTime());
                System.out.printf(" (GD) %-6s |  %11.2f VND |  %s  | %s\n", transaction.accountNumber, transaction.amount, strDate, transaction.ID);
            }
        }
    }
}
