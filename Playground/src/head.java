import java.util.*;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"a", "b", "c"};
		String[] b = {"a", "A", "B", "C", "B", "B"};
		String[] c = concat(a, b);
		
		for(String s:c) {
			System.out.printf("%s ", s);
		}
		System.out.println();
		
		System.out.println(firstFactorial(18));
	}
	
	public static double sum() {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		boolean running = true;
		Scanner kb = new Scanner(System.in);
		String s;
		
		while (running) {
			System.out.print(">>>");
			if (kb.hasNextInt()) {
				ar.add(kb.nextInt());
				kb.nextLine();
			} else {
				running = false;
			}
		}
		
		double sum = 0;
		
		for(int i = 0; i < ar.size(); i++) {
			sum += ar.get(i);
		}
		
		return (sum/ar.size());
	}

	public static String[] concat(String[] a, String[] b) {
		int len = a.length + b.length;
		String[] c = new String[len];
		
		for(int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for(int i = a.length; i < len; i++) {
			c[i] = b[i - a.length];
		}
		
		return c;
	}

	public static String count(String[] a) {
		String[] items = new String[a.length];
		int[] votes = new int[a.length];
		int len = 0;
		
		for (int i = 0; i < a.length; i++) {
			boolean inArr = false;
			for (int j = 0; j < len; j++) {
				if(a[i].equals(items[j])) {
					inArr = true;
					votes[j]++;
				}
			}
			
			if(!inArr) {
				items[len] = a[i];
				votes[len] = 0;
				len++;
			}
		}
		
		int max = 0;
		int ind = 0;
		for (int i = 0; i < len; i++) {
			if(votes[i] >= max) {
				max = votes[i];
				ind = i;
			}
		}
		
		return items[ind];
	}

	public static long firstFactorial (long num) {
		if(num <= 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return num * firstFactorial(num - 1);
		}
	}
}