package com.company;
import java.io.*;
import java.util.Scanner;


 class Functions extends Account implements Serializable {
    public Functions(){}// default constructor
    // Function for logging into your account
    void Login(Account account) {

        String[] words=null;  //Intialize the word Array
        FileReader fr = null;  //Creation of File Reader object
        try {
            fr = new FileReader("LoginDetail.txt");
            BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
            String s = null;
            int count=0;   //Intialize the word to zero
            while(true)   //Reading Content from the file
            {
                try {
                    if (!((s=br.readLine())!=null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                words=s.split(" ");  //Split the word using space
                for (String word : words)
                {
                    if (word.equals(account.accountOwner))   //Search for the given word
                    {
                        count++;    //If Present increase the count by one
                    }
                    if (word.equals(account.password))   //Search for the given word
                    {
                        count++;    //If Present increase the count by one
                    }
                }
            }
            if(count!=0&&count!=1)  //Check for count not equal to zero
            {
                System.out.println("Access Granted");
            }
            else
            {
                System.out.println("Wrong Login Attempt");
                System.out.println("Automated Shutdown initiated");
                System.out.println("3");
                System.out.println("2");
                System.out.println("1");
                System.out.println("System is offline!");
                System.exit(0);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Function for Depositing money
     void deposit(int amount, Account account) {
        if (amount != 0) {
            account.currentBalance = account.currentBalance + amount;
            account.previousTransaction = amount;
            System.out.println("You account has been credit with Rs "+amount+ " successfully");
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount, Account account) {
        if (amount != 0) {
            account.currentBalance = account.currentBalance - amount;
            account.previousTransaction = amount;
            System.out.println("Your account had a cash withdrawal of Rs "+amount);
        }
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years, Account account) {
        double interestRate = .0185;
        double newBalance = (currentBalance * interestRate * years) + currentBalance;
        double interest = 100 * interestRate;
        System.out.println("The current interest rate of " +account.accountOwner+"'s account is " + interest + "%");
        double profit = interest * (account.currentBalance);
        System.out.println("After " + years + " years,"+ account.accountOwner +"'s balance will be: " +profit);
        System.out.println("Remeber: Interest is Haram");
    }
    void Register(){
        System.out.println("Enter You Name");
        Scanner h1 = new Scanner(System.in);
        String q1 = h1.next();

        System.out.println("Enter You Password");
        Scanner h2 = new Scanner(System.in);
        String q2 = h2.next();

        System.out.println("Enter You Email");
        Scanner h4 = new Scanner(System.in);
        String q4 = h4.next();

        System.out.println("Enter You Address");
        Scanner h5 = new Scanner(System.in);
        String q5 = h5.next();

        System.out.println("Enter You Phone Number");
        Scanner h6 = new Scanner(System.in);
        String q6 = h6.next();

        int min = 1;
        int max = 1000;
        int q3 =  (int)(Math.random()*(max-min+1)+min);
        Account A1 = new Account(q1, q2,q3);
        A1.setEmail(q4);
        A1.setAddress(q5);
        A1.setPhoneNumber(q6);
        File Record = new File("LoginDetail.txt");
        try {
            if (Record.exists() == false) {
                System.out.println("We had to make a new file.");
                Record.createNewFile();
            }
            FileWriter write = new FileWriter("LoginDetail.txt",true);
            write.write("NAME:         "+A1.accountOwner+"\n");
            write.write("AC#:          "+A1.accountNumber+"\n");
            write.write("PASSWORD:     "+A1.password+"\n");
            write.write("EMAIL:        "+A1.Email+"\n");
            write.write("ADDRESS:      "+A1.Address+"\n");
            write.write("PHONE NUMBER: "+A1.PhoneNumber+"\n");
            write.write("End of this account \n");
            write.close();
            System.out.println("Account Registered! ");
            System.out.println("System is exiting. Start again to login! ");
        }
        catch (IOException e){
            System.out.println("Error");
        }
        File Record2 = new File("LoginDetailObjectForm.txt");
        try {
            if (Record2.exists() == false) {
                System.out.println("We had to make a new file.");
                Record2.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream("LoginDetailObjectForm.txt",true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(A1);
            objectOut.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        System.exit(0);
    }
    // reading from file where it is written in object form
    void read(){
        Functions f1 = new Functions();
        Account A1 = (Account) f1.ReadObjectFromFile("LoginDetailObjectForm.txt");
        System.out.println(A1);
    }
    public Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



}
