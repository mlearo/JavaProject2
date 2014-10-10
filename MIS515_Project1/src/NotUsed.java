import java.util.Scanner;

public class NotUsed {

	
	
	public static void nopeDontUse(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter the number of customers to process: ");
		int num = input.nextInt();
		
		Customer custList[] = new Customer[num];
		
		for(int count = 0, end = custList.length; count < end;  count++){
			
			String firstName,lastName,status;
			//int accNum = 0;
			//double begBalance;
			boolean continueLoop = true;
		
			
				
					
			System.out.println("Please enter the first name: ");
			firstName = input.next();
			System.out.println("Please enter the last name: ");
			lastName = input.next();
			do
			{
				System.out.println("Please enter you status: ");
				status = input.next();
				if(status.equalsIgnoreCase("preferred") || status.equalsIgnoreCase("premium"))
				{
					continueLoop = false;
				}
			}while(continueLoop);
			
			custList[count] = new Customer(firstName, lastName, status);
		}
		
		Account accountList[] = new Account[num];
		
		for(int numAcc = 0, endAccList = accountList.length; numAcc <= endAccList; numAcc++)
		{
			int transType;
			
			
			System.out.printf("Please enter the account number: ");//get account number from user
			int accNumber = input.nextInt();// place account number into variable
			accountList[numAcc] = new Account(accNumber); //create new instance of account and place instance in array accountList
			
			System.out.println("Please enter the first name: ");//get users first name
			String firstName = input.next();//put first name into variable
			
			System.out.println("Please enter the last name: ");//get users last name
			String lastName = input.next();//put last name into variable
			
			for(Customer cust: custList)
			{
				if(cust.getFirstName().equalsIgnoreCase(firstName) && cust.getLastName().equalsIgnoreCase(lastName))
				{
					accountList[numAcc].setOwner(cust);
				}
			}
			
			
			System.out.printf("Please enter the beginning balance for this account: ");
			double amount = input.nextDouble();
			accountList[numAcc].setBeginningBalance(amount);
			
			System.out.printf("Would you like to perofmr a deposit or withdrawal? Enter a 1 for yes and a zero for no: ");
			transType = input.nextInt();
			
			while(transType != 0)
			{
				System.out.printf("Please enter a 1 for deposit, -1 for withdrawal, or a 0 to exit: %n");
				transType = input.nextInt();
				
				System.out.printf("Please enter the day of the month 1-30: %n");
				int day = input.nextInt();
				
				System.out.printf("Please enter the amount: %n");
				double howMuch = input.nextDouble();
				
				//accountList[numAcc].depositOrWithdrawal(transType, howMuch);
				
				if((accountList[numAcc]).getBalance() < 0)
				{
					accountList[numAcc].setTransaction(transType, day, howMuch);
					
					Customer checkStatus = accountList[numAcc].getOwner();
					
					switch(checkStatus.getStatus()){
						case "premium":
							//accountList[numAcc].depositOrWithdrawal(-1, 10);
							break;
						case "preferred":
							//accountList[numAcc].depositOrWithdrawal(-1, 40);
							break;
							
					}
					
				}
				else
				{
					accountList[numAcc].setTransaction(transType, day, howMuch);
				}
				
				
			}
			
	
		for(Account account: accountList)
		{
			System.out.printf("%s%n",account.statement());
		}
			
	}	
	
		input.close();
	}
}
