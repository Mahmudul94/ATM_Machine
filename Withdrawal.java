package ATM_Macine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Withdrawal {

	Keypad keypad = new Keypad();
	boolean cashDispensed = false;
	double availableBalance;
	CashDispenser cashDispenser = new CashDispenser();
	BalanceInquiry inquiry = new BalanceInquiry();
	int amount;
	private static final int CANCELED = 6;

	public Withdrawal(double availableBalance2) {
		this.availableBalance = availableBalance2;
		cashWithdraw();
	}

	public void cashWithdraw() {
		Screen screen = new Screen();
		do {

			amount = displayMenuOfAmounts();

			if (amount != CANCELED) {

				if (amount <= availableBalance) {
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						cashDispenser.dispenseCash(amount);
						cashDispensed = true;
						screen.displayMessageLine("\nYour cash has been dispensed. Please take your cash now.");
						double newBalance = (availableBalance - amount);
						System.out.println("New Balance is  = " + newBalance);
					}
				} else {
					screen.displayMessageLine(
							"\nInsufficient funds in your account." + "\n\nPleasechoosea smaller amount.");
				}
			} else {
				screen.displayMessageLine("\nCanceling transaction...");
				return;
			}
		} while (!cashDispensed);
	}

	public int displayMenuOfAmounts() {
		Screen screen = new Screen();
		int userChoice = 0;

		int amounts[] = { 0, 20, 40, 60, 100, 200 };

		while (userChoice == 0) {

			screen.displayMessageLine("\nWithdrawal Menu:");
			screen.displayMessageLine("1 - $20");
			screen.displayMessageLine("2 - $40");
			screen.displayMessageLine("3 - $60");
			screen.displayMessageLine("4 - $100");
			screen.displayMessageLine("5 - $200");
			screen.displayMessageLine("6 - Cancel transaction");
			screen.displayMessageLine("\nChoose a withdrawal amount: ");

			int input = Integer.parseInt(keypad.getInput());

			switch (input) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				userChoice = amounts[input];
				break;
			case CANCELED:
				userChoice = CANCELED;
				break;
			default:
				screen.displayMessageLine("\nInvalid selection. Try again.");
			}
		}
		return userChoice;
	}
}
