
public class head {

	public static void main(String[] args) {
		BST bstObj = new BST(50);
		bstObj.addNode(56);
		bstObj.addNode(52);
		bstObj.addNode(25);
		bstObj.addNode(74);
		bstObj.addNode(54);
		bstObj.traverseAndPrint(bstObj.rootNode);
		
		System.out.println(bstObj.find(73));
		System.out.println(bstObj.find(74));
	}
}
