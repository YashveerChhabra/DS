package bst;

public class Testtree {

	public static void main(String[] args) {

		BTree<String> tree = new BTree<String>();

		tree.addElement("abc");
		tree.addElement("abcd");
		tree.addElement("ab");
		tree.addElement("bb");
		tree.addElement("bbc");
		tree.addElement("aaa");
		tree.addElement("zzz");
		tree.addElement("");
		tree.displayTree();
		tree.removeElement("ab");
		tree.displayTree();
		tree.removeElement("s");
		tree.displayTree();
		tree.removeElement("aaa");
		tree.displayTree();
		System.out.println(tree.isPresent("bbc"));
	}

}
