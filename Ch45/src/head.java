import java.util.*;
import java.io.*;
public class head {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		//s1 = {“Bill”, “Larry”, “Adolph”, “Regina”, “Susie”}
		//s2 = {“Larry”, “Jack”, “Alice”, “June”, “Benny”, “Susie”}
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		
		s1.add("Bill");
		s1.add("Larry");
		s1.add("Adolph");
		s1.add("Regina");
		s1.add("Susie");
		
		s2.add("Larry");
		s2.add("Jack");
		s2.add("Alice");
		s2.add("Benny");
		s2.add("Susie");
		
		Set<String> intersection = new HashSet<>();
		intersection.addAll(s1);
		intersection.retainAll(s2);
		
		Set<String> union = new HashSet<>();
		union.addAll(s1);
		union.addAll(s2);
		
		//Iterator iter = intersection.iterator();
		Iterator iter = union.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		*/
		File f = new File("H:/temp_Sam/Ch45.txt");
		Scanner fr = new Scanner(f);
		
		int grades_num, discipline_num;
		grades_num = fr.nextInt();
		discipline_num = fr.nextInt();
		fr.nextLine();
		
		Set<String> grades = new TreeSet<>();
		Set<String> discipline = new TreeSet<>();
		Set<String> names = new TreeSet<>();
		
		for(int i = 0; i < grades_num; i++) {
			String[] s = fr.nextLine().split(" ");
			grades.add(s[0] + " " + s[2]);
		}
		
		for(int i = 0; i < discipline_num; i++) { 
			String[] s = fr.nextLine().split(" ");
			discipline.add(s[0]);
		}
		
		
		
		Iterator<String> gIter = grades.iterator();
		
		while(gIter.hasNext()) {
			String[] str = gIter.next().split(" ");
			names.add(str[0]);
		}
		
		gIter = grades.iterator();
		
		while(gIter.hasNext()) {
			String[] str = gIter.next().split(" ");
			if(Integer.parseInt(str[1]) < 89) {
				names.remove(str[0] + " " + str[1]);
			}
		}
		
		names.removeAll(discipline);
		
		Iterator<String> nIter = names.iterator();
		
		while(nIter.hasNext()) {
			System.out.println(nIter.next());
		}
	}
}
