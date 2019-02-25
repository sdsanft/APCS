import java.util.*;
import java.io.*;

public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbScanner = new Scanner(System.in);
		String fileName;
		FileInput fi = new FileInput();
		
		while(true) {
			try {
				System.out.print("Please type the name of the file to be read: ");
				fileName = kbScanner.nextLine();
				if (fileName.toLowerCase().equals("exit")) {
					break;
				}
				fi.readTheFile(fileName);
				break;
			} catch (IOException e) {
				System.out.println("Please enter a valid file name.\n");
			}
		}
		
		kbScanner.close();
	}

}
