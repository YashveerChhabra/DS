package bst;

public class Testtree {

	public static void main(String[] args) {

		BTree tree = new BTree();

		tree.addElement(1);
		tree.addElement(2);
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(6);
		tree.addElement(7);
		tree.addElement(8);
		tree.displayTree();
		tree.removeElement(5);
		tree.displayTree();
		tree.removeElement(2);
		tree.displayTree();
		tree.removeElement(1);
		tree.displayTree();
		System.out.println(tree.isPresent(1));
	}

}
