import java.util.*;
public class head {
	public static void main (String args[]) {
		/*
		StackLL stck = new StackLL( );
		System.out.println( stck.size( ) ); //0
		stck.push(157.3);
		stck.push(22);
		stck.push(-18);
		double j = stck.pop( );
		System.out.println(j); // -18.0
		System.out.println( stck.peek( ) ); //22.0
		System.out.println( stck.pop( ) ); //22.0
		System.out.println( stck.size( ) ); //1
		stck.clear( );
		System.out.println( stck.size( ) ); //0
		*/
		
		boolean running = true;
		StackCalculator calc = new StackCalculator();
		Scanner kb = new Scanner(System.in);
		String in;
		double x;
		
		while (running) {
			System.out.print(">>> ");
			if(kb.hasNextDouble()) {
				x = kb.nextDouble();
				kb.nextLine();
				calc.push(x);
			} else {
				in = kb.nextLine();
				if(in.equals("+")) {
					System.out.println(calc.add());
				} else if(in.equals("-")) {
					System.out.println(calc.subtract());
				} else if(in.equals("*")) {
					System.out.println(calc.multiply());
				} else if(in.equals("/")) {
					System.out.println(calc.divide());
				} else if(in.toLowerCase().equals("q")) {
					running = false;
				}
			}
		}
	}
}
