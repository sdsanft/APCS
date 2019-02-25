
public class Pipeline {
	public PipelineNode headNode, currentNode;
	public int index, length;
	
	public void append(int pos, String name) {
		PipelineNode newNode = new PipelineNode(pos, name, null);
		if (headNode == null) {
			headNode = newNode;
			currentNode = headNode;
			index = 0;
		} else {
			currentNode.next = newNode;
			currentNode = newNode;
			index++; length++;
		}
	}
	
	public void insert(int pos, String name, int loc) {
		if (loc > length || loc < 0) {
			return;
		}
		
		currentNode = headNode;
		index = 0;
		
		if (loc == 0) {
			PipelineNode newNode = new PipelineNode(pos, name, headNode);
			headNode = newNode;
			return;
		}
		
		while(index != loc - 1) {
			currentNode = currentNode.next;
			index++;
		}
		PipelineNode newNode = new PipelineNode(pos, name, currentNode.next);
		currentNode.next = newNode;
	}
	
	public void print() {
		currentNode = headNode;
		index = 0;
		System.out.printf("%d, %s\n", currentNode.pos, currentNode.name);
		do {
			currentNode = currentNode.next;
			index++;
			System.out.printf("%d, %s\n", currentNode.pos, currentNode.name);
		} while (currentNode.next != null);
		System.out.println();
	}
}
