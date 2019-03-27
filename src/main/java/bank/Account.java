package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	
private String name;
private int accountNum;
private BigDecimal balance;
private List<Operation> operations;

public Account() {
	this.operations = new ArrayList<Operation>();
	this.balance = new BigDecimal(0);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAccountNum() {
	return accountNum;
}

public void setAccountNum(int accountNum) {
	this.accountNum = accountNum;
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

public List<Operation> getOperations() {
	return operations;
}

public void makeDeposit(BigDecimal amount) {
	//Amount must be positive
	if (amount.compareTo(BigDecimal.ZERO) >= 0) {
	//modify the balance
	balance = balance.add(amount);
	//set the operation
	Operation deposit = new Operation();
	deposit.setAmount(amount);
	deposit.setBalance(balance);
	deposit.setDate(new Date());
	deposit.setType(OperationType.DEPOSIT);
	this.operations.add(deposit);
	} else {
		throw new IllegalArgumentException("The amount of deposit must be positive");
	}
}

public void makeWithdrawal(BigDecimal amount) {
	//Amount must be positive
	if (amount.compareTo(BigDecimal.ZERO) >= 0) {
	//check if the client have enough balance for the amount 
	if (balance.compareTo(amount)>0) {
		//modify the balance
		balance = balance.subtract(amount);
		//set the operation
		Operation withdrawal = new Operation();
		withdrawal.setAmount(amount);
		withdrawal.setBalance(this.balance);
		withdrawal.setDate(new Date());
		withdrawal.setType(OperationType.WITHDRAWAL);
		this.operations.add(withdrawal);
	}else {
		System.out.print("You do not have balance for this withdrawal");
	}
	} else {
		throw new IllegalArgumentException("The amount of withdrawal must be positive");
	}
}

public void seeHistory() {
	//display account name and number
	System.out.println("Name :" + getName() + " Account Number : " + getAccountNum() + "\n Operations : ");
	//display all the operations
	for (Operation operation : this.operations) {
	 System.out.println(operation);
	}
}

}
