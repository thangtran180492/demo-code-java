package models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String id;
    List<Customer> customers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }

    public void addAccount(String customerID, Account account){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getCustomerId().equals(customerID)){
                customers.get(i).addAccount(account);
                return;
            }
        }
    }


    public List<Customer> getCustomers(){
        return customers;
    }

    public Customer getCustomersById(String CustomerId){
        for (Customer customerCurrent : customers){
            if(customerCurrent.getCustomerId().equals(CustomerId)){
                return customerCurrent;
            }
        }
        return null;
    }

    public boolean isCustomerExisted(String customerID){
        for (Customer c : customers){
            if(c.customerId.equals(customerID)){
                return true;
            }
        }
        return false;
    }
    public boolean isAccountExisted(String accountNumber){
        for (Customer customerCurrent : customers){
            for (Account accountCurrent : customerCurrent.getAccounts()){
                if(accountCurrent.getAccountNumber().equals(accountNumber)){
                    return true;
                }
            }
        }
        return false;
    }
}
