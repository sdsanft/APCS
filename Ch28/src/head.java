
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 386, q = 581, n = 0;
		System.out.println("Hello"); //Start timing first loop when “Hello” is printed
		
		long startTime = System.currentTimeMillis();
		for(int j=0; j<2000000000; j++)
		{
			for(int k = 0; k < 10000000; k++) { //Use this extra loop for faster computers
				n = ((p * 2) + q) / 2;
			}
		}
		System.out.println(n); //When this line prints, stop timing the first loop and
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		//begin timing the second loop.
		
		startTime = System.currentTimeMillis();
		for(int j=0; j<2000000000; j++)
		{
			for (int k = 0; k < 10000000; k++) {
				n = p + (q>>1);
			}
		}
		System.out.println(n);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

}
