package ATM_Macine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Screen {

	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	Keypad keypad = new Keypad();
	BankDatabase bankDatabase = new BankDatabase();


	boolean userAuthenticated = false;
	String accountNumber;
	String pin;
	int exit = 0;

	public void display() {
		while (true) {
			System.out.println("Welcome !");

			System.out.print("\nPlease enter your account number:");

			accountNumber = keypad.getInput();
			System.out.print("\nEnter your PIN:");
			pin = keypad.getInput();
			// bankDatabase = new BankDatabase(accountNumber,pin);
			userAuthenticated = bankDatabase.Search(accountNumber, pin);
			if (userAuthenticated) {
				displayMainMenu();
				if (exit == EXIT) {
					break;
				}

			}

			else {
				System.out.println("Invalidaccount number or PIN.Please try again.");
			}
		}
	}

	private void displayMainMenu() {

		while (true) {

			displayMessageLine("\nMain menu:");
			displayMessageLine("1 - View my balance");
			displayMessageLine("2 - Withdraw cash");
			displayMessageLine("3 - Deposit funds");
			displayMessageLine("4 - Exit");

			displayMessage("Enter a choice:");
			String choices = keypad.getInput();
			exit = Integer.parseInt(choices);
			EnterAchoice(choices);
			if (exit == EXIT) {

				System.out.println("Good Bye! ");
				break;
			}

		}

	}

	public void EnterAchoice(String input) {
       
		int input2 = Integer.parseInt(input);

		if (BALANCE_INQUIRY == input2) {
			bankDatabase.lookBalance(accountNumber, pin, 1);
		}

		if (WITHDRAWAL == input2) {
			bankDatabase.lookBalance(accountNumber, pin, 2);
			}

	}
	
	

	public void displayMessage(String message) {
		System.out.print(message);
	}

	public void displayMessageLine(String message) {
		System.out.println(message);
	}

	public void displayDollarAmount(double amount) {
		System.out.printf("$%,.2f", amount);
	}

}
