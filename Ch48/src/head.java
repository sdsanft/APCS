
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipeline pip = new Pipeline();
		
		pip.append(0, "Pump station");
		pip.append(3050, "Hwy 35");
		pip.append(4573, "Tank farm");
		pip.print();
		
		pip.insert(4040, "Cold Creek", 2);
		pip.insert(0, "Car Wash", 0);
		pip.print();
	}
}
