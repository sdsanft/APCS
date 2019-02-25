
public class BST {
	BstNode rootNode;
	BstNode currentNode;
	
	public BST(int i) {
		rootNode = new BstNode(i);
	}
	
	public void addNode(int i) {
		currentNode = rootNode;
		
		while (true) {
			if (i > currentNode.intData) {
				if(currentNode.rightNode == null) {
					currentNode.rightNode = new BstNode(i);
				} else {
					currentNode = currentNode.rightNode;
				}
			} else if (i < currentNode.intData) {
				if(currentNode.leftNode == null) {
					currentNode.leftNode = new BstNode(i);
				} else {
					currentNode = currentNode.leftNode;
				}
			} else {
				break;
			}
		}
	}
	
	public void traverseAndPrint(BstNode currentNode) {
		System.out.print("data = " + currentNode.intData);
		if(currentNode.leftNode == null){ 
			System.out.print(" left = null");
		} else {
			System.out.print(" left = " + (currentNode.leftNode).intData);
		}
		
		if(currentNode.rightNode == null){
			System.out.print(" right = null"); 
		} else {
			System.out.print(" right = " + (currentNode.rightNode).intData);
		}
		
		System.out.println("");
		if(currentNode.leftNode != null)
			traverseAndPrint(currentNode.leftNode);
		if(currentNode.rightNode != null)
			traverseAndPrint(currentNode.rightNode);
	}

	public boolean find(int i, BstNode currentNode) {
		if (i == currentNode.intData) {
			return true;
		} else if (i < currentNode.intData) {
			if (currentNode.leftNode == null) {
				return false;
			} else {
				return find(i, currentNode.leftNode);
			}
		} else {
			if (currentNode.rightNode == null) {
				return false;
			} else {
				return find(i, currentNode.rightNode);
			}
		}
	}
	
	public boolean find (int i) {
		return find (i, rootNode);
	}
}