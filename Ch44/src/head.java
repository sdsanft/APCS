import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class head {

	public static void main(String[] args) {
		BankAccount[] ba = new BankAccount[5];
		Scanner kbReader = new Scanner(System.in);
		String tempName;
		double tempBal;
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter the name to whom the account belongs: ");
			tempName = kbReader.nextLine();
			
			System.out.print("Please enter the amount of the deposit: ");
			tempBal = kbReader.nextDouble(); kbReader.nextLine(); System.out.println();
			
			ba[i] = new BankAccount(tempName, tempBal);
		}
		
		Arrays.sort(ba);
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d) %s, \t%.2f\n", i + 1, ba[i].name, ba[i].balance);
		}
	}
}