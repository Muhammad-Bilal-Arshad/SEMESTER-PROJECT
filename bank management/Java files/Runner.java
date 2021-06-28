package com.company;

import java.io.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Welcome to OOP Bank Management Project");
        System.out.println("Created by \n 1. SP20-BSE-052 MUHAMMAD ALI SHIEKH \n 2. SP20-BSE-055 MUHAMMAD BILAL ARSHAD");
        System.out.println("What would you like to do? \n 1. Register\n 2. Login");
        Scanner z1 = new Scanner(System.in);
        char z2 = z1.next().charAt(0);
        Functions f1 = new Functions();
        switch (z2){
            //The default case let's the user know that they entered an invalid character and how to enter a valid one
            default:
                System.out.println("Error: Invalid Option. Please Enter 1,2 to access services.");
                break;
            //case 1 allows user to register themselves
            case'1':
                //f1.read();
               f1.Register();
                //case 2 allows user to Login
            case'2':
                System.out.println("Enter You name");
                Scanner h4 = new Scanner(System.in);
                String q4 = h4.next();
                System.out.println("Enter You Password");
                Scanner h5 = new Scanner(System.in);
                String q5 = h5.next();
                Account A2 = new Account(q4 ,q5);
                f1.Login(A2);
                char option = '\0';
                Scanner scanner = new Scanner(System.in);
                System.out.println("What would you like to do?");
                System.out.println("\n-----------------------------------------------------------------------------------");
                System.out.println("A.Check Your Balance.");
                System.out.println("B.Make A Deposit.");
                System.out.println("C.Make A Withdrawal.");
                System.out.println("D.View Previous Transaction");
                System.out.println("E.Calculate Interest");
                System.out.println("F.Account Details");
                System.out.println("G.Exit");
                System.out.println("\n-----------------------------------------------------------------------------------");
                do {
                    System.out.println();
                    System.out.println("Enter an option: ");
                    char option1 = scanner.next().charAt(0);
                    option = Character.toUpperCase(option1);
                    System.out.println();

                    switch (option) {
                        //Case 'A' allows the user to check their account balance
                        case 'A':
                            System.out.println("====================================");
                            System.out.println("The balance is: "+A2.currentBalance);
                            System.out.println("====================================");
                            System.out.println();
                            break;
                        //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                        case 'B':
                            System.out.println("Enter An Amount To Deposit: ");
                            int amount = scanner.nextInt();
                            f1.deposit(amount, A2);
                            System.out.println();
                            break;
                        //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                        case 'C':
                            System.out.println("Enter An Amount to Withdraw: ");
                            int amount2 = scanner.nextInt();
                            f1.withdraw(amount2, A2);
                            System.out.println();
                            break;
                        //Case 'D' allows the user to view their most recent transaction
                        case 'D':
                            System.out.println("====================================");
                            System.out.println("Latest transaction: "+A2.previousTransaction);
                            System.out.println("====================================");
                            System.out.println();
                            break;
                        //Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                        case 'E':
                            System.out.println("Enter How Many Years Of Accrued Interest: ");
                            Scanner s2 = new Scanner(System.in);
                            int years = s2.nextInt();
                            f1.calculateInterest(years, A2);
                            break;
                        //Case 'F' exits the user from their account
                        case 'F':
                            System.out.println("====================================");
                            A2.showAccount();
                            System.out.println("====================================");
                            break;
                        case 'G':
                            System.out.println("====================================");

                            try {

                                FileWriter write = new FileWriter("LatestActivity.txt",true);
                                write.write("Name:               "+A2.accountOwner+"\n");
                                write.write("Balance:            "+A2.currentBalance+"\n");
                                write.write("Latest Transaction: "+A2.previousTransaction+"\n");
                                write.write("End of this activity \n");
                                write.close();
                            }
                            catch (IOException e){
                                System.out.println("Error");
                            }

                            break;
                        //The default case let's the user know that they entered an invalid character and how to enter a valid one
                        default:
                            System.out.println("Error: Invalid Option. Please Enter A, B, C, D, or E to access services.");
                            break;
                    }
                } while (option != 'G');
                System.out.println("System is Exiting in");
                System.out.println("3");
                System.out.println("2");
                System.out.println("1");
                System.out.println("Thank You For Banking With Us!");
        }
    }
}

