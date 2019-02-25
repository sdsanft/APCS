import java.io.*;
import java.util.*;

public class head {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(new File("H:\\temp_Sam\\Ch27.txt"));
		int fileLength = 0;
		
		while (sf.hasNextInt()) {
			fileLength++;
			sf.nextInt();
		}
		
		sf.close();
		
		sf = new Scanner(new File("H:\\temp_Sam\\Ch27.txt"));
		
		int data[] = new int[fileLength];
		
		for (int i = 0; i < fileLength; i++) {
			data[i] = sf.nextInt();
		}
		
		for (int i = 0; i < data.length; i++) {
			data[i] %= 256;
			System.out.println("Switch status for data value " + data[i]);
			for (int j = 0; j < 8; j++) {
				if ((data[i] & (int)Math.pow(2, j)) == (int)Math.pow(2, j)) {
					System.out.println("Switch #" + (j+1)  + " is on.");
				} else if ((data[i] & (int)Math.pow(2, j)) == 0) {
					System.out.println("Switch #" + (j+1)  + " is off.");
				}
			}
		}
		
		sf.close();
	}

}
