import java.lang.reflect.Array;
import java.util.Scanner; // import scanner class


public class AccountTest {
	
	public static Scanner input = new Scanner(System.in);//create scanner object
	public static Customer customerList[];//create array that holds Customer objects
	public static Account accountList[];//create array that holds Account objects
	
	private static String regular = new String("regular");//create string for status type check
	private static String premier = new String("premier");//create string for status type check
	
	public static void main(String[] args)
	{	
		String firstName, lastName, status;//declare local string variables
		boolean continueLoop = true;//declare local boolean variable
		
		
		int numberOfCustomers = getIntegerInput("Please enter the number of customers you would like to enter: ");
		
		customerList = new Customer[numberOfCustomers];
		accountList = new Account[numberOfCustomers];
		
		for(int customerCount = 0,length = customerList.length; customerCount < length; customerCount++)
		{
			firstName = getStringInput("Please enter your first name: ");//get customer first name and place it into a variable
			lastName = getStringInput("Please enter your last name: ");//get customer last name and place it into a variable
			status = getCustomerStatus();//get customer status and place it into a variable
			setStatus(firstName, lastName, status, customerCount);//call setStatus method
		}	
		
	
		//Loop to gather account info and perform transactions
		for(int count = 0,length = accountList.length; count < length; count++)
		{
			
			int accNumber = getIntegerInput("Please enter your account number: ");// get account number from user and place it into variable
			accountList[count] = new Account(accNumber); //create new instance of account and place that account in accountList array
			
			
			boolean isTrue = true;//set boolean value for do while below
		do
		{
			String first = getStringInput("Please enter your first name: ");//get customer first name and place it into a variable
			String last = getStringInput("Please enter your last name: ");//get customer last name and place it into a variable
			
			for(Customer cust: customerList){
				
				
				if(cust.getFirstName().equalsIgnoreCase(first) && cust.getLastName().equalsIgnoreCase(last))
				{
					accountList[count].setOwner(cust);
					isTrue = false;
					break;
				} else {
					System.out.println();
					isTrue = true;
				}
			}
		}while(isTrue);
				

			
			double beginningBalance = getBeginningBalance();//get customer beginning balance and place it into variable
			accountList[count].setBeginningBalance(beginningBalance);//add beginning balance to user account
			
			do
				{
				
				System.out.printf("Please enter a 1 for deposit, -1 for withdrawal, or a 0 to exit;");//prompt user to make a transaction or exit
				int transType = input.nextInt();//get user response
				
				//check if input type is 0, if so exit immediately, else get transaction day of month and amount. 
					if(transType == 0)
					{
						continueLoop = false;//sets continueLoop to false so outer loop will exit
						
					} else {
						
						System.out.printf("Please enter the amount: ");//prompt user for amount to deposit/withdrawal
						double amount = input.nextDouble();//set amount from user to variable
						
						int dayOfMonth = getDayOfTransaction();
						
						accountList[count].setTransaction(transType, dayOfMonth, amount);
						continueLoop = true;
					}
				
				}while(continueLoop);
		}//end for loop
		
		
		for(int i = 0, l = customerList.length; i < l; i++)
		{
			String[] stuff = accountList[i].statement().split("%n");
			for(String token: stuff)
			{
				System.out.println(token);
			}
			System.out.printf("-----------------------------------%n");
		}
	}
	
	
	
	
	
	
	/*		helper methods used that are used in the above code				*/
	
	//function to get first name from user
	public static String getStringInput(String message)
	{
		System.out.printf("%s %n",message);
		String stringInput = input.next();
		return stringInput;	
	}
	
	
	//function to get status of user
	public static String getCustomerStatus()
	{
		
		String status = new String();//declare new string to hold the customers status
		boolean isTrue;//boolean variable
		//do loop that asks for user status and returns users status if and only if it matches the check, otherwise it asks again.
		do
		{
			System.out.printf("Please enter your status (premier or regular): %n");//ask user for input of status
			status = new String(input.next());//place user input into variable
			isTrue = (status.equalsIgnoreCase(regular) || status.equalsIgnoreCase(premier));//check if user input matches criteria
			
		}while(!isTrue);
		return status;//return users input status
	}
	
	//get user account number, returns account number
	public static int getIntegerInput(String message)
	{
		System.out.printf("%s %n",message);//request user input
		int integerInput = input.nextInt();//place user input into variable
		return integerInput;//return user input
	}
	
	//get double input from user, return user input
	public static double getBeginningBalance()
	{
		System.out.printf("Please enter the beginning balance: %n");//request user input
		double doubleInput = input.nextDouble();//place user input into variable
		return doubleInput;//return user input
	}
	
	//gets integer user input for day of transaction, validates date range
	public static int getDayOfTransaction()
	{
		int dayOfMonth;
		boolean isTrue;
		do
		{
			System.out.printf("Please enter the day of the month of the transaction (1-30)");//prompt user for day of transaction
			dayOfMonth = input.nextInt();//set transaction date from user to variable
			isTrue = (dayOfMonth < 30 && dayOfMonth > 0);//check if user input matches criteria
			
		}while(!isTrue);
		return dayOfMonth;//return users input status
	}
	public static void setStatus(String first, String last, String status, int custCount){
		customerList[custCount] = new Customer(first, last, status);// create customer instance and place it into accountList array
	}
	
	
}//end class TestIt
