import java.util.*;

public class LLQ {
	private LinkedList lst;
	
	public LLQ() { 
		lst = new LinkedList( );
	}
	
	public void enqueue (Object obj) {
		lst.addLast(obj);
	}
	
	public Object dequeue() {
		return lst.removeFirst();
	}
	
	public Object peekFront() {
		return lst.getFirst();
	}
	
	public boolean isEmpty() {
		return lst.isEmpty();
	}
}
