
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t1 = cat(68, 108);
		System.out.println(t1);
		
		String t2 = cat(35, 59);
		System.out.println(t2);
	}
	
	public static String cat(int start, int end) {
		StringBuffer x = new StringBuffer();
		char c;
		
		for (int i = start; i <= end; i++) {
			c = (char) i;
			x.append(Character.toString(c));
		}
		
		return x.toString();
	}
}
