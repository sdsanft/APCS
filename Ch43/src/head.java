import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class head {

	public static void main(String[] args) {
		boolean running = true;
		ArrayList<BankAccount> Accounts = new ArrayList<BankAccount>();
		Scanner kb = new Scanner(System.in);
		ListIterator<BankAccount> iter = Accounts.listIterator();
		
		do {
			String name;
			Double balance;
			BankAccount acc;
			
			System.out.print("Please enter the name to whom the account belongs, (\"Exit\" to abort): ");
			name = kb.nextLine();
			
			running = name.toLowerCase().equals("exit") ? false : true;
			if(!running) {
				System.out.println();
				break;
			}
			
			System.out.print("Please enter the amount of the deposit: ");
			balance = kb.nextDouble();
			kb.nextLine();
			
			acc = new BankAccount(name, balance);
			iter.add(acc);
			//Accounts.add(acc);
			System.out.println();
		} while(running);
		
		while(iter.hasPrevious()) {
			iter.previous();
		}
		
		BankAccount greatest = new BankAccount("null", 0);
		while(iter.hasNext()) {
			BankAccount temp = iter.next();
			if (temp.balance > greatest.balance) {
				greatest = temp;
			}
		}
		System.out.printf("The account with the largest balance belongs to %s.\nThe amount is $%.2f.", 
				greatest.name, greatest.balance);
		
		kb.close();
	}

}