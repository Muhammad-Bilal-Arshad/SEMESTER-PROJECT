package com.company;
import java.io.Serializable;
public class Account implements Serializable {
    protected String accountOwner;
    protected String password;
    protected String Email;
    protected String Address;
    protected String PhoneNumber;
    protected float currentBalance;
    protected int accountNumber;
    protected int previousTransaction;

    public Account(){}// default constructor
    // Parameterized Constructor
    public Account(String accountOwner,String password  ) {
        this.accountOwner = accountOwner;
        this.password = password;
    }
    // Parameterized Constructor # 2
    public Account(String accountOwner,String password,int accountNumber  ) {
        this.accountOwner = accountOwner;
        this.password = password;
        this.accountNumber = accountNumber;

    }

    // setter methods
    public void setTotalBalance(float totalBalance) {
        this.currentBalance = totalBalance;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
    public void setEmail(String Email) { this.Email = Email ; }
    public void setAddress(String Address) {this.Address = Address;}
    public void setPhoneNumber(String PhoneNumber) { this.PhoneNumber = PhoneNumber; }

    // setter methods
    public String getAccountOwner() {
        return accountOwner;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return currentBalance;
    }
    public String getEmail() {return Email; }
    public String getAddress() {return Address; }
    public String getPhoneNumber() {return PhoneNumber; }

    void showAccount() {
        System.out.println("NAME:               "+accountOwner);
        System.out.println("BALANCE:            "+currentBalance);
        System.out.println("LATEST TRANSACTION: "+previousTransaction);
    }

    @Override
    public String toString() {
        return "Account" +
                "\n Name = " + accountOwner  +
                "\n password = " + password  +
                "\n currentBalance = " + currentBalance +
                "\n accountNumber = " + accountNumber +
                "\n previousTransaction = " + previousTransaction;
    }
}
