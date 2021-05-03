package ATM_Macine;

public class Account {
	
		   String  accountNumber; 
		   String pin; 
		   double availableBalance; 
		   double totalBalance;
		/**
		 * @param accountNumber
		 * @param pin
		 * @param availableBalance
		 * @param totalBalance
		 */
		public Account(String accountNumber, String pin, double availableBalance, double totalBalance) {
			super();
			this.accountNumber = accountNumber;
			this.pin = pin;
			this.availableBalance = availableBalance;
			this.totalBalance = totalBalance;
		} 
		   
		 public boolean validatePIN(String userPIN)
		  {
		    if( userPIN== pin)
		      return true;
		    else
		      return false;
		  }
		  public double getAvailableBalance()
		  {
		    return availableBalance;
		  }
		  public double getTotalBalance()
		  {
		    return totalBalance;
		  }
		  public void credit(double amount )
		  {      
		    totalBalance+=amount; 
		  }
		  public void debit(double amount )
		  {
		    availableBalance -= amount; 
		    totalBalance -= amount; 
		  }
		  public String getAccountNumber()
		  {
		    return accountNumber;  
		  }

		 
		 

}
