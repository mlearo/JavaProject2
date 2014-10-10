
public class Transaction {

	private int transactionType;
	private int transactionDay;
	private double amount;
	private String message;
	
	public Transaction(int transType, int transDay, double amount, String message)
	{
		this.transactionType = transType;
		this.transactionDay = transDay;
		this.amount = amount; 
		this.message = message;
	}
	
	protected int getTransType(){
		
		return this.transactionType;
	}
	
	protected int getTransDay()
	{
		return this.transactionDay;
	}
	
	protected double getAmount()
	{
		return this.amount;
	}
	
	protected String getMessage()
	{
		return this.message;
	}
}
