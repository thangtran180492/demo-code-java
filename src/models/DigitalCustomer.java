package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DigitalCustomer extends Customer{

    public void withdraw(String accountNumber, double amount) throws Exception{
        for(Account account : getAccounts()){
            if(account.getAccountNumber().equals(accountNumber) && account instanceof SavingsAccount){
                ((SavingsAccount) account).withdraw(amount);
                return;
            }else if(account.getAccountNumber().equals(accountNumber) && account instanceof LoanAccount){
                ((LoanAccount) account).withdraw(amount);
                return;
            }
        }
    }
}
