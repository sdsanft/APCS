import java.util.LinkedList;

public class StackCalculator {
	LinkedList<Double> ll = new LinkedList<Double>();
	int size = 0;
	
	public void push (double d) {
		ll.add(d);
		size++;
	}
	
	public double pop() {
		size--;
		return ll.removeLast();
	}
	
	public double peek() {
		return ll.getLast();
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		ll.clear();
		size = 0;
	}
	
	public double add () {
		ll.add(ll.removeLast() + ll.removeLast());
		return ll.getLast();
	}
	
	public double subtract () {
		ll.add(ll.removeLast() - ll.removeLast());
		return ll.getLast();
	}
	
	public double multiply () {
		ll.add(ll.removeLast() * ll.removeLast());
		return ll.getLast();
	}
	
	public double divide () {
		ll.add(1/(ll.removeLast() / ll.removeLast()));
		return ll.getLast();
	}
}
