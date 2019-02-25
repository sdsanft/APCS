
public class LinearFunction implements LinearFunctionMethods {
	private double slope;
	private double yInt;
	
	LinearFunction(double argSlope, double argYInt) {
		slope = argSlope;
		yInt = argYInt;
	}
	
	public double getSlope() {
		return slope;
	}
	
	public double getYintercept() {
		return yInt;
	}

	public double getRoot() {
		return getXvalue(0);
	}
	
	public double getYvalue (double x) {
		return (yInt + slope * x);
	}
	
	public double getXvalue (double y) {
		return ((y - yInt) / slope);
	}
}