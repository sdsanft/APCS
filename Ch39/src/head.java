
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 15; i++) {
			System.out.print(fibonacci(i) + ", ");
		}
	}
	
	public static int fibonacci(int n) {
		if (n <= 0) {
			return 1;
		} if (n == 1) {
			return 2;
		} if (n >= 2) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
		return 0;
	}
}
