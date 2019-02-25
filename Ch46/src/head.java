import java.io.*;
import java.util.*;
public class head {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean running = true;
		Scanner kb = new Scanner(System.in);
		Map<Integer, BankAccount> accounts = new TreeMap();
		
		while (running) {
			String name;
			double balance;
			BankAccount acc;
			
			System.out.print("Please enter the name of the account: ");
			name = kb.nextLine();
			if(name.toLowerCase().equals("exit")) {
				running = false;
				System.out.println("\n");
			} else {
				System.out.print("Please enter the balance of the account: ");
				balance = kb.nextDouble();
				kb.nextLine();
				System.out.println();
				
				acc = new BankAccount(name, balance);
				accounts.put(acc.AccountID, acc);
			}
		}
		
		Iterator iter = accounts.keySet().iterator();
		while(iter.hasNext()) {
			int key = (int) iter.next();
			System.out.printf("%d\t%s\n", accounts.get(key).AccountID, accounts.get(key).name);
		}
		
		int lookupID;
		System.out.print("\nPlease enter the ID of the account you would like to lookup: ");
		lookupID = kb.nextInt();
		System.out.printf("%d >>> %s\n\tBalance: $%.2f\n", accounts.get(lookupID).AccountID, accounts.get(lookupID).name, 
				accounts.get(lookupID).balance);
	}

}
