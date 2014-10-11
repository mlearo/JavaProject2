import java.util.ArrayList;

public class Account {
	
	//declare private variables
	private int accountNumber;
	private double totalWithdrawal, totalDeposit, balance, beginningBalance;
	private Customer customerReference; 
	private static String regular = new String("regular");
	private ArrayList<Transaction> accountTransaction = new ArrayList<>();
	
	
	public String firstName,lastName;
	

	//constructor
	public Account(int accountNumber){
		this.accountNumber = accountNumber;
		this.balance = 0;
		this.beginningBalance = 0;
	}
	
	
	//method that receives information about a accounts transactions and places them in arrayList and processes each transaction.
	protected void setTransaction(int transType, int day, double amount)
	{	
		this.depositOrWithdrawal(transType, amount);//call method to make deposit or withdrawal
		
		//checks if balance is overdrawn
		if(this.getBalance() < 0)
		{
			//if balance is overdrawn, retrieve the status of the account from Customer class using Customer reference
			String checkStatus = this.getOwner().getStatus();//get account owner status
			//check what type of status the account owner is
			if(checkStatus.equalsIgnoreCase(regular))
				{
					//if account owner is overdrawn and has status of regular do this
					this.depositOrWithdrawal(-1, 40); 
					this.accountTransaction.add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
				} else {
					//if account owner is overdrawn and has status of premier do this
					this.depositOrWithdrawal(-1, 10); 
					this.accountTransaction.add(new Transaction(transType, day, amount, "Your account is overdrawn by " + this.getBalance()));
				}
		} else {
			this.accountTransaction.add(new Transaction(transType, day, amount, ""));
		}
		
		
		
	}

	protected int getAccNum()
	{
		return this.accountNumber;
	}

	protected void setBeginningBalance(double amount)
	{
		this.beginningBalance = amount;
		this.balance = amount;
	}
	
	private void deposit(double amount)
	{
		this.balance += amount;
		this.totalDeposit += amount;	
	}

	private void withdrawal(double amount)
	{
		this.balance -= amount;
		this.totalWithdrawal += amount;	
	}

	private void depositOrWithdrawal(int option, double amount){
		switch(option)
		{
			case 1: deposit(amount);
				break;

			case -1: withdrawal(amount);
				break;

			default: break;		
		}
	}

	protected double getBalance(){
		return this.balance;
	}
	
	protected void setOwner(Customer customer)
	{
		this.customerReference = customer;
	}
	
	protected Customer getOwner()
	{
		return this.customerReference;
	}
	
	protected double getBeginningBalance()
	{
		return this.beginningBalance;
	}
	
	//create string of transactions and return it as a string, needs to be re-factored using StringBuilder.

	
	public String getTransaction()
	{
		StringBuilder output = new StringBuilder(200);
		for(Transaction item: this.accountTransaction)
		{
			int day = item.getTransDay();
			double amount = item.getAmount();
			int trans = item.getTransType();
			
			output.append("Day:    " + day)
				  .append("%n")
				  .append("Amount: " + amount)
				  .append("%n");
			if(trans == 1)
			{
				output.append( "Type:   Deposit")
					  .append("%n");
			} else {
				output.append("Type:   Withdrawal")
				      .append("%n");
			}
			String isMessage = item.getMessage();
			if(isMessage != "")
			{
				output.append("Message: " + item.getMessage())
					  .append("%n");
			} else {
				output.append("-----------------------------------%n");
			}
			output.append("-----------------------------------%n");
			
		}
		
		return output.toString();
	}
	
	public String statement(){
		StringBuilder state = new StringBuilder(500);
		String name = this.customerReference.getFullName();
		String status = this.customerReference.getStatus().toUpperCase();
		double begBal = this.beginningBalance;
		double totDep = this.totalDeposit;
		double totWith = this.totalWithdrawal;
		double endBal = this.balance;
		
		state.append("Name:    " + name)
			 .append("%n")
			 .append("Status:  " + status)
			 .append("%n")
			 .append("Beginning Balance: "+ begBal)
			 .append("%n")
			 .append("Total Deposit:     " + totDep)
			 .append("%n")
			 .append("Total Withdrawals: " + totWith)
			 .append("%n")
			 .append("Ending Balance:    " + endBal)
			 .append("%n")
			 .append(this.getTransaction());
		return state.toString();
	}
}
