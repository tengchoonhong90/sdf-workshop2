package vtp2022.workshop2;

import vtp2022.workshop2.account.bankAccount;
import vtp2022.workshop2.account.fixedDepositAccount;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - Suedes Bank" );
        bankAccount bkAcc= new bankAccount("Teng's Bank Acoount");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        System.out.println("Withdraw 20 -> My new account balance >" + bkAcc.withdraw("20"));
        System.out.println("Withdraw 500 -> My new account balance >" + bkAcc.withdraw("500"));

        fixedDepositAccount fdAcc = new fixedDepositAccount("My Fixed Deposit account", 10000);

        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(5, 6);

    }
}
