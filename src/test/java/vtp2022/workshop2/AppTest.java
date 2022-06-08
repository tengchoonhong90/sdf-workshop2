
package vtp2022.workshop2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vtp2022.workshop2.account.bankAccount;
import vtp2022.workshop2.account.fixedDepositAccount;

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        bankAccount bkAcc= new bankAccount("Teng's Bank Acoount");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("500");
        assertEquals(500, finalBalance, .1);
    }

    @Test
    public void testFixedDepositAccountChangeInterestAndDuration(){
        try{
            fixedDepositAccount fdAcc = 
                new fixedDepositAccount("My Fixed Deposit account", 10000);

            System.out.println("1. Fixed Deposit Account balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Account balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(5, 6);
        }catch(IllegalArgumentException e){
            assertTrue("Only can set duration and interest once.".contains(e.getMessage()));
        }
     }

    @Test
    public void testFixedDepositAccountchangeInterestAndDurationOnce(){
        fixedDepositAccount fdAcc = 
            new fixedDepositAccount("My Fixed Deposit account", 10000);

        System.out.println("1. Fixed Deposit Account balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("2. Fixed Deposit Account balance > " + fdAcc.getBalance());
        assertEquals(12, fdAcc.getDuration(), 0);
    }
}