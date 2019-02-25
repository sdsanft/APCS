import java.util.Random;

public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rndm = new Random();
		
		int[] rndmInts = new int[33];
		for (int i = 0; i < 33; i++) {
			rndmInts[i] = rndm.nextInt(18) + 71;
			//System.out.print(rndmInts[i] + ", ");
		}
		System.out.println();
		
		double[] rndmDoubles = new double[27];
		for (int i = 0; i < 27; i++) {
			rndmDoubles[i] = (/*47.44 * */rndm.nextDouble());// + 99.78;
			//System.out.printf("%.2f, ", rndmDoubles[i]);
		}
		System.out.println();
		
		int n = 40000000;
		int cirCount = 0;
		double pi;
		Raindrop[] Raindrops = new Raindrop[n];
		
		for (int i = 0; i < n; i++) {
			Raindrops[i] = new Raindrop();
			if(Math.pow(Raindrops[i].x, 2) + Math.pow(Raindrops[i].y, 2) <= 1) {
				cirCount += 1;
			}
		}
		
		pi = cirCount * 4 / (double) n;
		
		System.out.println(pi);
	}
}
