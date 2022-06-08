package vtp2022.workshop2;

import vtp2022.bankAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "ATM Machine - Banko" );
        bankAccount bkAcc = new bankAccount("Teng Bank Account");
        bkAcc.deposit("100");
        System.out.println("My new account balance: " + bkAcc.getBalance());
    }
}
