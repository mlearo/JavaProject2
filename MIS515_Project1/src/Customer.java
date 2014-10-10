
public class Customer {
	private String firstName, lastName, status;
	
	public Customer(String firstName, String lastName, String status)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status.toLowerCase();
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getFullName(){
		return (this.firstName + ", "  + this.lastName);
	}
	
	public String getStatus()
	{
		return this.status;
	}
}
