package models;

import java.util.List;

public class DigitalBank extends Bank {

    public void withdraw(String customerId, String AccountId, double amount) throws Exception{
        if(!isCustomerExisted(customerId)) return;
        DigitalCustomer customer = (DigitalCustomer)getCustomersById(customerId);
        customer.withdraw(AccountId, amount);
    }

    public void showHistory(String customerId) {
        Customer customer = getCustomersById(customerId);
        customer.displayTransition();
    }
}
