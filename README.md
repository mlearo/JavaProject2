JavaProject2
============
MIS 515- Fall 2014

Java programming Assignment #2.  Due September 24

Objectives: User-defined classes. If-else, while and other control structures.

DELIVERABLES: 1) A hard copy of the program correctly indented.  2) A Snapshot of the program execution. 

Write a Java program to define a class for a simplified bank account and the program to test it.

At the minimum, the Account class will include the following elements

Fields (all Private) (instance variables)

account number
Customer last name, first Name
beginning balance
end balance
total withdrawal
total deposit

Feel free to add extra fields that are needed.   

Methods: 

Constructor: Will initialize account Number, Last Name, First Name 
After creating an Account object, set the beginning balance in that object using a set method 
Usual get and set methods
addDeposit(amount) method: add  deposit to the balance
subtractWithdrawa(amount): subtract  withdrawal from balance
printStatement: display the values of the fields listed above.  If the balance is negative, will display a message indicating that account is overdrawn. 


The test program will read the data for customers and invoke the needed methods.  We will assume four Accounts  (4 objects  declared in the test program).  The program will also read transactions (deposits or withdrawals) for the month

  Account number: 10000 
Customer Last name, First Name:  Norbert, Pat
Beginning balance   900
Transactions (must be entered in the order shown) (1 for Deposit, -1 for withdrawal, 0 for end of transaction for current account)
   1 250    1 200     -1 150    -1 100     -1 300     0


  Account number: 20000
Customer Last name, First Name:  Lopez, Andy
Beginning balance   700
Transactions: -1  750    0
Note: this account will be overdrawn

  Account number: 30000
Customer Last name, First Name:  Pham, Debby
Beginning balance   900
Transactions: -1 50      1 20      -1 150    1  20   0
 
 

  Account number: 40000
Customer Last name, First Name:  Crown,  Renee
Beginning balance   300
Transactions:  0  (no transactions)

Input/output:.  At your choice:  use the class System  or a GUI


**************************************************************************************************

Explanations


End of transactions for each account will be indicated by the code 0.

Test Program structure

1. An outer loop (while loop or for loop).  The code inside the outer loop  is executed 4 times, once for each account

2. An inner loop (a  while-loop nested in the for-loop).  This while loop reads the transactions for an account and performs the appropriate processing needed for the account

The following is a skeleton of the code for the test program, you need to fill-in where needed and make sure the syntax works

int transactionCode;
Account acct, acct1, acct2, acct3, acct34;

for (int i =1;    ……………)  // you can use a for-loop if you prefer.

{	prompt for and  read account number, last name, first name;

 acct = new Account( 3 arguments here for account number, last name, first name);

             prompt to read beginning balance- set beginning balance in account
                   (this was added in email of 02-15-2012)
Prompt for transaction

Read transactionCode 

While  (transactionCode. != 0) 
{  	test transaction code and process transaction
  	That is compute accrued withdrawals, deposits
  	Read transaction code
}  //end while loop

Compute, set the fields totalDeposit, totalWithdrawals, , endBalance in the
       Account object referred to by acct;

 “Save” the reference to the current  Account object.  For example:

If(i==1) acct1 = acct; //at end of first iteration of the outer loop
…………………..
} //end for-loop

At this point we have 4 Account objects, referred to by acct1, acct2, acct3, acct4

Using the printStatement() method of the class Account, display the information for each account.


******************************************************

How to develop the program in two steps:

1) start the test program with one account (one object only referred to by one reference variable),  ignoring the outer loop.   
  You can then execute the program four times, once for each account, and verify that it works properly.  This is a 9/10, A-, if you stop here and the program works properly

2) modify the test program, by adding the outer loop, declaring four reference variables (one for each account), and creating and processing the four objects for the four accounts.

REMARKS-  
DO NOT USE ARRAYS (although their use would be appropriate for this problem)
. The use of of the reference variable called “acct” avoids the duplication of the same code for each of the 4 accounts. If you do not understand how it works, please ask me for an explanation.







MIS 515.  Spring Fall 2014.  Java Programming assignment #2 – Full program Due October 22, 2014



Please, correct the errors you had in the previous program before starting this program.  

Objectives: Composition of classes.     Arrays of objects


I) Three classes: class Customer, class Account, Class Transaction

Fields of the classes (instance variables)

class Customer: Last name, first name, status (“Premier” or “Regular”)

class Transaction has  4 instance variables:
   transactionType (a String with value “D” for deposit and value “W” for Withdrawal
   transactionDay (an int between 1 and 30) 
   amount (a double)
  message (a String)

class  Account: similar to previous program with several  modifications of the fields of the class: 
    1) Customer last name, first name is replaced by a reference to the Customer who owns the account: 
          Customer owner;  (note: declaring an instance variable in the class Account to be a reference to an 
          object of the class Customer is called “composition” of classes and is explained in section 8.8, pages 
          332-334.  We will discuss it   next time.). 
     2) class Account has a new field, an array of Transaction.  
     3) You may add more fields as needed.

New methods will be needed  in the Account class.  You figure them out (based on the description below)

II)  The test program has two arrays:  an array of Customer and an array of Account.  There is no array of Transactions in the test program:  the data for each transaction are read in the test program (as described below), but each transaction is set and  processed within an Account object

To simplify, we assume one Account per Customer

Test program structure

Read number of customers and declare and dimension an array of Customer
Using a loop (while or for), for each customer read last name, first name, status, and create a Customer object referred to by the next entry in the array of Customer
Declare and dimension  array of accounts (same length as array of Customers)
Using an outer loop, read the information to create the Account objects:
read accountNumber; and create an object for this account and an entry in the array of Account
read the account owner’s  last name, first name; use this information to identify the Customer object and set in the Account object a reference to that Customer object (use a method setOwner in the class Account, with parameters last name, first name).
read beginning balance and set the appropriate instance variable in the Account object
 using a nested loop, for each account,  read each transaction type (1 for deposit, -1 for withdrawal, you can use “D”, “W” if you prefer), the day of the month,   the $ amount For each transaction, create an entry in the arrays of Transaction of the specific Account, and process the Account as in assignment #1. If a transaction causes an overdrawn account, set this information in the “message” of the Transaction, and assess a charge of $40 for Regular Customers and a charge of $10 for Premier Customers
       5. Using an enhanced  for-loop,  execute the printStatement method for each account: (compute, if needed and) print last name, first name, customer status, beginning balance, totalDeposit,  totalWithdrawal, end balance (modified  as needed by overdrawn charges).; display the transactions for each account; for each transaction that causes  an overdrawn charge,  indicate so and the amount
           
Data: same as in previous assignment , but add  the following values of status:
Norbert, Pat: Regular.      Lopez, Andy: Premier.   Pham, Debby: Premier   Crown,  Renee: Regular.

Extra data:  for each transaction of an account, make up the data for the day of the month, in ascending order, between 1 and 30

You may start the program without the array of Transaction.  If you want to stop there, it is a B+ at most.

