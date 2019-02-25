import java.util.*;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unoptimized();
		optimized();
	}
	
	public static void unoptimized() {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int n = kb.nextInt();
		kb.nextLine();
		long startTime = System.nanoTime();
		
		int d = 1;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while (d <= n/2) {
			if(n % d == 0) {
				factors.add(d);
			}
			d += 1;
		} factors.add(n);
		
		/*
		Iterator<Integer> iter = factors.iterator();
		while (iter.hasNext()) {
			System.out.printf("%d ", iter.next());
		} System.out.println();
		*/
		
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.printf("The program took %.3e seconds to run.\n", (timeElapsed/1000000000.0));
	}

	public static void optimized() {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int n = kb.nextInt();
		kb.nextLine();
		long startTime = System.nanoTime();
		
		int d = 1;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while (d <= Math.sqrt(n)) {
			if(n % d == 0) {
				factors.add(d);
			}
			d += 1;
		} factors.add(n);
		
		/*
		Iterator<Integer> iter = factors.iterator();
		while (iter.hasNext()) {
			System.out.printf("%d ", iter.next());
		} System.out.println();
		*/
		
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.printf("The program took %.3e seconds to run.\n", (timeElapsed/1000000000.0));
	}

}