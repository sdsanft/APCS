public class BankAccount implements Comparable<BankAccount> {
	public String name;
	public double balance;
	
	public BankAccount(String nm, double amt) {
		name = nm;
		balance = amt;
	}
	
	public int compareTo(BankAccount acc) {
		int i = 0;
		if (name.equals(acc.name)) {
			return 0;
		}
		while (true) {
			if (name.toLowerCase().toCharArray()[i] < acc.name.toLowerCase().toCharArray()[i]) {
				return -1;
			} else if (name.toLowerCase().toCharArray()[i] > acc.name.toLowerCase().toCharArray()[i]) {
				return 1;
			}
			
			i++;
		}
	}
	
	public void deposit(double dp) {
		
	}
	
	public void withdraw(double wd) {
		
	}
}