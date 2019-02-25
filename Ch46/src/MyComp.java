import java.util.*;
public class MyComp implements Comparator<BankAccount> {
	public int compare(BankAccount a, BankAccount b) {
		if (a.AccountID > b.AccountID) {
			return 1;
		} else {
			return -1;
		}
	}
}
