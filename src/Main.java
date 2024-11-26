import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int EXIT_COMMAN_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_MANE = "FUNIX";
    private static final DigitalBank activeBank = new DigitalBank();

    public static void main(String[] args) {
        DigitalCustomer newCustomer = new DigitalCustomer();
        newCustomer.setName(CUSTOMER_MANE);
        newCustomer.setCustomerId(CUSTOMER_ID);
        activeBank.addCustomer(newCustomer);

        String s ="1";

        while (true){
            printfOpion();
            s = scanner.nextLine();
            try {
            if(s.equals("1")){
                // thong tin khach hang
                showCustomer();
            }else if(s.equals("2")){
                // them tai khoan ATM
                addSavingsAccount();
            }else if(s.equals("3")){
                // them tai khoan tin dung
                addLoanAccount();
            }else if(s.equals("4")){
                // rut tien
                withdraw();
            }else if(s.equals("5")){
                // lich su giao dich
                showHistory();
            }else if(s.equals("0")){
                // thoat
                break;
            }else{
                System.out.println("Lua chon cua ban ko ton tai");
            }
            }catch (Exception e){
                System.out.println("nhap sai cu phap: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void showCustomer(){
        Customer customer = activeBank.getCustomersById(CUSTOMER_ID);
        if(customer != null)
            customer.displayInformation();
    }
    public static void addSavingsAccount() throws Exception{
        SavingsAccount newAccount = new SavingsAccount();
        System.out.println("nhap ma so tai khoan gom 6 chu so:");
        String newAccountId = scanner.nextLine();
        newAccount.setAccountNumber(newAccountId);
        System.out.println("nhap so du:");
        newAccount.setBalance(Integer.parseInt(scanner.nextLine()) + 0.0);
        if(activeBank.isAccountExisted(newAccountId)){
            throw new Exception("tai khoan da ton tai");
        }
        activeBank.addAccount(CUSTOMER_ID, newAccount);
    }
    public static void addLoanAccount() throws Exception{
        LoanAccount newAccount = new LoanAccount();
        System.out.println("nhap ma so tai khoan gom 6 chu so:");
        String newAccountId = scanner.nextLine();
        newAccount.setAccountNumber(newAccountId);
        newAccount.setBalance(10000000.0);
        if(activeBank.isAccountExisted(newAccountId)){
            throw new Exception("tai khoan da ton tai");
        }
        activeBank.getCustomersById(CUSTOMER_ID).addAccount(newAccount);
    }

    public static void withdraw() throws Exception{
        System.out.println("+------------- chon tai khoan ------------+");
        List<Account> accounts = activeBank.getCustomersById(CUSTOMER_ID).getAccounts();
        int select = 0;

        for (int i = 0; i < accounts.size(); i++){
            System.out.println("so " + (i+1) + " " + accounts.get(i).toString());
        }
        System.out.print("Lua chon : ");
        select = Integer.parseInt(scanner.nextLine());

        if(select < 1 || select > accounts.size()) {
            throw new Exception(" chon so tai khoan theo thu tu ");
        }
        System.out.println("+-------------------------------+" + (select - 1));
        System.out.println("so " + (select) + " " + accounts.get(select - 1).toString());

        System.out.println("Nhap so tien can rut ");
        double amount = Double.parseDouble(scanner.nextLine());

        activeBank.withdraw(CUSTOMER_ID, accounts.get(select - 1).getAccountNumber(), amount);
    }

    private static void showHistory() {
        showCustomer();
        activeBank.showHistory(CUSTOMER_ID);
    }

    public static void printfOpion(){
        System.out.println("+--------------------------------------------+");
        System.out.println("| Ngan hang so | FX12345@v3.0.0              |");
        System.out.println("+--------------------------------------------+");
        System.out.println("1. Thong tin khach hang");
        System.out.println("2. Them tai khoan ATM");
        System.out.println("3. Them tai khoan tin dung");
        System.out.println("4. Rut tien");
        System.out.println("5. Lich su giao dich");
        System.out.println("0. Thoat");
        System.out.println("+--------------------------------------------+");
        System.out.print("Chuc nang: ");
    }
}