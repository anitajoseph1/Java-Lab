import java.util.Scanner;
public class Bank 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of customers:");
		int noOfCustomers=sc.nextInt();
		Customer[] customer=new Customer[noOfCustomers];
		for(int i=0;i<noOfCustomers;i++)
		{
			customer[i]=new Customer();
			customer[i].getDetails();
		}
		for(int i=0;i<noOfCustomers;i++)
		{
			customer[i].printDetails();
		}
		
		int choice,i,searchAccount,depositAmount,withdrawAmount;
		InvalidAmountException amountException=new InvalidAmountException("Invalid Amount");
		InsufficientFundsException fundsException=new InsufficientFundsException("Insufficient Fund");
		do 
		{
            System.out.println("1. Display Account Details");
            System.out.println("2. Search by account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            
            switch(choice)
            {
            case 1:
            	for(i=0;i<noOfCustomers;i++)
        		{
        			customer[i].printDetails();
        		}
            	break;
            case 2:
            	System.out.println("Enter Account Number:");
            	searchAccount=sc.nextInt();
            	for(i=0;i<noOfCustomers;i++)
            	{
            		if(searchAccount==customer[i].accountNumber)
            		{
            			customer[i].printDetails();
            		}
            	}
            	break;
            case 3:
            	System.out.println("Enter Account Number:");
            	searchAccount=sc.nextInt();
            	System.out.println("Enter the amount to deposit:");
            	depositAmount=sc.nextInt();
            	try 
            	{
            		for(i=0;i<noOfCustomers;i++)
                	{
            			if(searchAccount==customer[i].accountNumber)
                		{
                			if(depositAmount<=0)
                        	{
                        		throw amountException;
                        	}
                        	else
                        	{
                        		customer[i].accountBalance+=depositAmount;
                        		customer[i].printDetails();
                        	}
                		}                		
                	}
            	}
            	catch(InvalidAmountException e)
            	{
            		System.out.println(e.getMessage());
            	}
            	
            	break;
            case 4:
            	System.out.println("Enter Account Number:");
            	searchAccount=sc.nextInt();
            	System.out.println("Enter the amount to withdraw:");
            	withdrawAmount=sc.nextInt();
            	try
            	{
            		if(withdrawAmount<=0)
                	{
                		throw amountException;
                	}
                	else
                	{
                		for(i=0;i<noOfCustomers;i++)
                    	{
                    		if(searchAccount==customer[i].accountNumber)
                    		{
                    			if(withdrawAmount>customer[i].accountBalance)
                    			{
                    				throw fundsException;
                    			}
                    			else
                    			{
                    				customer[i].accountBalance-=withdrawAmount;
                            		customer[i].printDetails();
                    			}
                    		}
                    	}
                	}
            	}
            	catch(InvalidAmountException e)
            	{
            		System.out.println(e.getMessage());
            	}
            	catch(InsufficientFundsException e)
            	{
            		System.out.println(e.getMessage());
            	}
            	break;
            default:
            	System.out.println("Invalid Choice!");
            	break;
            }	
		}
		while(choice!=5);
    }
}		
class Customer
{
	int accountNumber;
    String accountType;
    String customerName;
    int accountBalance;
	Scanner sc=new Scanner(System.in);
	public void getDetails()
	{
		System.out.println("Enter Account Number:");
		accountNumber = sc.nextInt();
        System.out.println("Enter Account type:");
        accountType = sc.next();
        System.out.println("Enter Customer Name:");
        customerName = sc.next();
        System.out.println("Enter Account Balance:");
        accountBalance = sc.nextInt();
        System.out.println();
	}
	public void printDetails() 
	{
        System.out.println("The Customer Details are:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println();
	}
}

class InvalidAmountException extends Exception
{
	InvalidAmountException(String str)
	{
		super(str);
	}
}
class InsufficientFundsException extends Exception
{
	InsufficientFundsException(String str)
	{
		super(str);
	}
}
        
        
        
        
        
        
             

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	