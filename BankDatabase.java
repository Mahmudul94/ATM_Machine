package ATM_Macine;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankDatabase {

	public boolean Search(String accountNumber, String pin) {

		boolean isAuthenticated = false;
		Scanner input = new Scanner(System.in);

		String path = "D:\\Eclipse_Java_project\\NewBegining\\member.txt";

		File file = new File(path);
		String line;
		try {
			Scanner inputBuffer = new Scanner(file);
			while (inputBuffer.hasNext()) {
				line = inputBuffer.nextLine();
				String[] values = line.split("\t");
				if (values[0].trim().equals(accountNumber) && values[1].trim().equals(pin)) {

					isAuthenticated = true;
				}
			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return isAuthenticated;

	}
	// cheeking accountNumber and pin number to know balance from database

	public void lookBalance(String accountNumber, String pin, int choice) {

		Scanner input = new Scanner(System.in);
		BalanceInquiry inquiryDatabase;
		Withdrawal withdrawBalance;
		String path = "D:\\Eclipse_Java_project\\NewBegining\\member.txt";

		File file = new File(path);
		String line;
		try {
			Scanner inputBuffer = new Scanner(file);
			while (inputBuffer.hasNext()) {
				line = inputBuffer.nextLine();
				String[] values = line.split("\t");
				if (values[0].trim().equals(accountNumber) && values[1].trim().equals(pin)) {

					double availableBalance = Double.parseDouble(values[2]);

					double totalBalance = Double.parseDouble(values[3]);
					
					if(choice == 1) {
					new BalanceInquiry(availableBalance, totalBalance);
					}
					else if(choice == 2) {
						new Withdrawal(availableBalance);
					}

				}
			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	}
