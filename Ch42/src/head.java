import java.util.*;

public class head {

	public static void main(String[] args) {
		boolean running = true;
		ArrayList<BankAccount> Accounts = new ArrayList<BankAccount>();
		Scanner kb = new Scanner(System.in);
		
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
			Accounts.add(acc);
			System.out.println();
		} while(running);
		
		if(Accounts.size() > 0) {
			int greatest = 0;
			for (int i = 0; i < Accounts.size(); i++) {
				if (Accounts.get(i).balance > Accounts.get(greatest).balance) {
					greatest = i;
				}
			}
			
			System.out.printf("The account with the largest balance belongs to %s.\nThe amount is $%.2f.", 
					Accounts.get(greatest).name, Accounts.get(greatest).balance);
		}
		
		kb.close();
	}

}
