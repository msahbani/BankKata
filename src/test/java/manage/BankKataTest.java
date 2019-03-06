package manage;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

import bank.Account;

public class BankKataTest {

	
	/*
	 * 
	 US 1:
		In order to save money
		As a bank client
		I want to make a deposit in my account
		
		*/
	@Test
	public void testDeposit() {
		//create account
		Account account = new Account();
		//make a deposit
		BigDecimal deposit = new BigDecimal(100);
		account.makeDeposit(deposit);
		//test
		assertEquals(100 , account.getBalance().longValue());
	}
	/*
	 * US 2:
		In order to retrieve some or all of my savings
		As a bank client
		I want to make a withdrawal from my account
	 */
	@Test
	public void testWithdrawal() {
		//create account
		Account account = new Account();
		// make a deposit
		BigDecimal deposit = new BigDecimal(100);
		account.makeDeposit(deposit);
		//make a withdrawal
		BigDecimal withdrawal = new BigDecimal(50);
		account.makeWithdrawal(withdrawal);
		//test
		assertEquals(50 , account.getBalance().longValue());
	}
	
	/*
	 * US 3:
		In order to check my operations
		As a bank client
		I want to see the history (operation, date, amount, balance) of my operations
		*/
	
	@Test
	public void testHistoryDisplay() {
		
		//create account
		Account account = new Account();
		account.setAccountNum(123456);		
		account.setName("Mark Frau");
		
		//performing some operations
		BigDecimal firstdeposit = new BigDecimal(100);
		account.makeDeposit(firstdeposit);
		BigDecimal firstWithdrawal = new BigDecimal(20);
		account.makeWithdrawal(firstWithdrawal);
		BigDecimal secondDeposit = new BigDecimal(200);
		account.makeDeposit(secondDeposit);
		BigDecimal secondWithdrawal = new BigDecimal(180);
		account.makeWithdrawal(secondWithdrawal);
		
		//display History
		account.seeHistory();
		//test
		assertEquals(100 , account.getBalance().longValue());
	}

}
