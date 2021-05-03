package ATM_Macine;

import java.io.Serializable;

public class BalanceInquiry  {

	String accountNumber;
	String pin;

     public double availableBalance;
	 public double totalBalance;
     
	/**
	 * 
	 */
	public BalanceInquiry() {
		super();
	}

	/**
	 * @param accountNumber
	 * @param pin
	 * @param screen
	 * @param availableBalance
	 * @param totalBalance
	 */

	public BalanceInquiry(double availableBalance, double totalBalance) {
		super();
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
		showBalance();
		
	}
	/**
	 * @param accountNumber
	 * @param pin
	 */
	public BalanceInquiry(String accountNumber, String pin) {
		super();
		this.accountNumber = accountNumber;
		this.pin = pin;
	}

	

	public double getAvailableBalance() {
		return availableBalance;
	}
 
	 
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
		
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		 this.totalBalance = totalBalance;
	}


	public void showBalance() {
		
		Screen screen = new Screen();
		screen.displayMessageLine("\nBalance Information:");
		screen.displayMessage(" - Available balance: ");
		screen.displayDollarAmount(getAvailableBalance());
		screen.displayMessage("\n - Total balance:   ");
		screen.displayDollarAmount(getTotalBalance());
		screen.displayMessageLine("");

	}

}
