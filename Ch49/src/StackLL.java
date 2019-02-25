import java.util.*;
public class StackLL implements StackInt{
	LinkedList<Double> ll = new LinkedList<Double>();
	int size = 0;
	
	public void push (double d) {
		ll.add(d);
		size++;
	}
	
	public double pop( ) {
		size--;
		return ll.removeLast();
	}
	
	public double peek( ) {
		return ll.getLast();
	}
	
	public int size( ) {
		return size;
	}
	
	public void clear( ) {
		ll.clear();
		size = 0;
	}
}
