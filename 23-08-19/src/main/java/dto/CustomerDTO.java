package dto;

import entities.BankCustomer;

public class CustomerDTO {

    private int customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bc) {
        this.customerID = bc.getId();
        this.fullName = bc.getFirstName()+" "+bc.getLastName();
        this.accountNumber = bc.getAccountNumber();
        this.balance = bc.getBalance();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
