package vtp2022.workshop2.account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
// package to generate uuid
import java.util.UUID;

public class bankAccount {
    // bank account
    private String name ="";
    
    // this is a generated account id from the java util UUID class
    private String acctId =  UUID.randomUUID()
                                    .toString()
                                    .substring(0,8);
    // holds the bank acc balance
    private float balance = 0f;
    // list of transaction history in the event of 
    // anything done on the bankaccount object
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;
    
    // constructor with bank account name
    public bankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    // 2nd constructor with bank account name and the initial balance.
    public bankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    // Getter and setter for the rest of the properties
    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public float withdraw(String withdrawAmt){
        Float withdrawAmtF = null;
        try{
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if (withdrawAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Withdrawal amount cannot be negative or kosong");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed lah!");
            }

            this.balance = this.balance  - withdrawAmtF.floatValue();
            // Construct the transaction history event log 
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedList 
            transaction.add(txnStrbld.toString());
            // update the deposit amount
            
        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        return this.balance;
    }
    
    public void deposit(String depositAmt){
        try{
            Float depositAmtF = Float.parseFloat(depositAmt);
            if (depositAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Deposit amount cannot be negative or kosong");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed lah!");
            }

            this.balance = this.balance  + depositAmtF.floatValue();
            // Construct the transaction history event log 
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedList 
            transaction.add(txnStrbld.toString());
            // update the deposit amount
            
        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        
    }

}
