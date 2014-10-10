import java.util.ArrayList;

public class Account {
	//declare private variables
	private String firstName;
	private String lastName;
	private int accountNumber;
	private double totalWithdrawal;
	private double totalDeposit;
	private double balance;
	private double beginningBalance;
	private Customer customerReference; 
	private static String regular = new String("regular");
	private ArrayList<Transaction> accountTransaction = new ArrayList<>();

	//constructor
	public Account(int accountNumber){
		this.accountNumber = accountNumber;
		this.balance = 0;
		this.beginningBalance = 0;
	}
	
	
	//method that receives information about a accounts transactions and places them in arrayList and processes each transaction.
	public void setTransaction(int transType, int day, double amount)
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

	protected void setName(String firstName, String lastName )
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName()
	{
		return (this.firstName + " " + this.lastName);
	}

	public int getAccNum()
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

	protected void depositOrWithdrawal(int option, double amount){
		switch(option)
		{
			case 1: deposit(amount);
				break;

			case -1: withdrawal(amount);
				break;

			default: break;		
		}
	}

	public double getBalance(){
		return this.balance;
	}
	
	public void setOwner(Customer customer)
	{
		this.customerReference = customer;
	}
	
	public Customer getOwner()
	{
		return this.customerReference;
	}
	public Double getBeginningBalance()
	{
		return this.beginningBalance;
	}
	
	//create string of transactions and return it as a string
	public String getTransactionList()
	{
		String output ="";
		for(Transaction item: this.accountTransaction)
		{
			output += "Day:    " + item.getTransDay() + "\n";
			output += "Amount: " + item.getAmount() + "\n";
			int trans = item.getTransType();
			if(trans == 1)
			{
				output += "Type:   Deposit" + "\n";
			} else {
				output += "Type:   Withdrawal" + "\n";
			}
			
			String isMessage = item.getMessage();
			if(isMessage != "")
			{
				output += "Message:" + item.getMessage() + "\n";
				output += "-----------------------------------\n";
			} else {
				output += "-----------------------------------\n";
			}
		}
		
		return output;
	}

	//create statement string and return it to caller
	public String statement(){
		String output = "";//declare string variable
		output += "Name:   " + this.customerReference.getFullName() + "\n";//get first name & last name
		output += "Status: " + this.customerReference.getStatus().toUpperCase() + "\n";//get status
		output += "Beginning Balance: " + this.beginningBalance + "\n";//get beginning balance
		output += "Total Deposits:    " + this.totalDeposit + "\n"; //get total deposit(s)
		output += "Total Withdrawals: " + this.totalWithdrawal + "\n";//get total withdrawal(s)
		output += "End Balance:       " + this.balance + "\n"; //get ending balance
		output += "Transactions:   \n " + this.getTransactionList() + "\n";//get transaction(s)
		return output;
	}
}
