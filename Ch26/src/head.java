
import java.io.*; //necessary for File and IOException
import java.util.*; //necessary for StringTokenizer and Scanner
import java.text.*; //necessary for NumberFormat
public class head {
	public static void main( String args[] ) throws IOException {
		NumberFormat fmt = NumberFormat.getNumberInstance( );
		fmt.setMinimumFractionDigits(4); //may need to change value
		fmt.setMaximumFractionDigits(4); //may need to change value
		
		Scanner sf = new Scanner(new File("H:\\temp_Sam\\Ch26.txt"));
		int maxIndx = -1; //-1 so when we increment below, the first index is 0
		String text[] = new String[1000]; //To be safe, declare more than we need
		while(sf.hasNext( )) {
			maxIndx++;
			text[maxIndx] = sf.nextLine( );
			//System.out.println(text[maxIndx]); //Remove rem for testing
		}
		//maxIndx is now the highest index of text[]. Equals -1 if no text lines
		sf.close( ); //We opened a file above, so close it when finished.
		//System.exit(0); //Use this for testing… to temporarily end the program here
		
		double scores[][] = new double [maxIndx + 1][10];
		double averages[] = new double [maxIndx + 1];
		
		Formatter fmtr = new Formatter();
		
		for (int i = 0; i <= maxIndx; i++) {
			//Typically, only one of the following two will be used.
			StringTokenizer st = new StringTokenizer( text[i] );
			Scanner sc = new Scanner(text[i]);
			sc.useDelimiter(" ");
			
			for(int j = 0; j < 10; j++) {
				scores[i][j] = sc.nextDouble();
			}
			
			double max = scores[i][1], min = scores[i][0];
			int maxloc = 1, minloc = 0;
			
			for (int j = 0; j < 10; j++) {
				if(scores[i][j] > max) {
					max = scores[i][j];
					maxloc = j;
				} else if(scores[i][j] < min) {
					min = scores[i][j];
					minloc = j;
				}
			}
			
			double sum = 0;
			for (int j = 0; j < 10; j++) {
				if (j != maxloc && j != minloc) 
					sum += scores[i][j];
			}
			averages[i] = sum/8;
			//…code specific to the task…
			//System.out.println(text[j]); //Remove rem for testing\
			fmtr.format("For Competitor #%d, the average is %5s\n", i + 1, fmt.format(averages[i]));
		}
		System.out.println(fmtr.toString());
	}
}
