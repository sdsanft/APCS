public class BankAccount implements Comparable<BankAccount> {
	public String name;
	public double balance;
	private static int AccountCounter = 0;
	public int AccountID;
	
	public BankAccount(String nm, double amt) {
		name = nm;
		balance = amt;
		AccountID = ++AccountCounter;
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
		balance += dp;
	}
	
	public void withdraw(double wd) {
		balance -= wd;
	}
}