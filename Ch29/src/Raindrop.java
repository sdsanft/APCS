import java.util.Random;

public class Raindrop {
	double x;
	double y;
	
	private Random random = new Random();
	
	Raindrop () {
		x = 2 *random.nextDouble() - 1;
		y = 2 *random.nextDouble() - 1;
	}
}
