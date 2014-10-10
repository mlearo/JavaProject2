
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
	
	public int getTransType(){
		
		return this.transactionType;
	}
	
	public int getTransDay()
	{
		return this.transactionDay;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public String getMessage()
	{
		return this.message;
	}
}
