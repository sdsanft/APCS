import java.io.*; //necessary for File and IOException
import java.util.*; //necessary for Scanner

public class FileInput{
	public static void readTheFile(String fileName) throws IOException {
		File f = new File ("H:\\temp_Sam\\" + fileName);
		Scanner sf = new Scanner(f);
		int maxIndx = -1; //-1 so when we increment below, the first index is 0
		String text[] = new String[1000]; //declare more than we need
		
		while(sf.hasNext( )) {
			maxIndx++;
			text[maxIndx] = sf.nextLine( );
		}
		
		//maxIndx is now the highest index of text[], = -1 if no lines of text.
		sf.close( ); //we opened file so we must close it
		
		System.out.println("\n" + f.getPath());
		sf = new Scanner(f);
		for (int j = 0; j <= maxIndx; j++)	{
			System.out.println(sf.nextLine());
		}
	}
}