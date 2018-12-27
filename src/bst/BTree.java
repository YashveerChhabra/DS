package bst;

public class BTree {

	int count;
	Node root;

	private class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public boolean addElement(int value) {
		Node node = new Node(value);
		if (count == 0) {
			root = node;
			count++;
			return true;
		}
		Node temp = root;
		while (temp != null) {
			if (node.data < temp.data) {
				if (temp.left == null) {
					temp.left = node;
					count++;
					return true;
				} else {
					temp = temp.left;
				}
				// temp = temp.left;
			} else {
				if (node.data > temp.data) {

					if (temp.right == null) {
						temp.right = node;
						count++;
						return true;
					} else {
						temp = temp.right;
					}
					// temp = temp.right;
				}

				else {
					System.out.println("Value already exists.");
					return false;
				}

			}

		}
		return false;
	}

	public void displayTree() {

		if (root == null) {
			System.out.println("Empty tree");
		} else {
			System.out.println("Total Elements: " + count);
			display(root);
		}

	}

	private void display(Node node) {

		if (node == null)
			return;
		else {
			// System.out.println(node.data); preorder
			display(node.left);
			System.out.println(node.data); // inorder
			display(node.right);
			// System.out.println(node.data); postorder
		}

	}

	public boolean removeElement(int value) {

		Node temp = root, prev = null;

		while (temp != null) {
			if (temp.data == value) {
				break;
			}
			if (temp.data < value) {
				prev = temp;
				temp = temp.right;
			} else {
				prev = temp;
				temp = temp.left;
			}

		}
		if (temp == null) {
			System.out.println("Element '" + value + "' is not there in the tree.");
			return false;
		}

		// deleting node if only 1 or no child is there
		if (temp.left == null || temp.right == null) {
			deleteNode(prev, temp);
			return true;
		}
		// deleting node if both children are there
		else {
			// find smallest element from the right subtree.
			Node node = temp;
			prev = temp;
			temp = temp.right;
			while (temp.left != null) {
				prev = temp;
				temp = temp.left;
			}
			node.data = temp.data;
			deleteNode(prev, temp);
			return true;
		}
	}

	private void deleteNode(Node prev, Node node) {

		if (node == root) {
			if (node.left == null) {
				root = node.right;
			} else
				root = node.left;
		} else {
			if(prev.left==node) {
				if(node.left==null) {
					prev.left=node.right;
				}else
					prev.left=node.left;
			}else {
				if(node.left==null) {
					prev.right=node.right;
				}else
					prev.right=node.left;
				
			}
						
		}
		count--;
		node.data = 0;
		node.left = node.right = null;
		node = null;
		return;
	}

	public boolean isPresent(int value) {
		Node temp = root;
		while (temp != null) {
			if (temp.data == value) {
				return true;
			}
			if (temp.data < value)
				temp = temp.right;
			else
				temp = temp.left;
		}
		//System.out.println("Element is not there in the tree.");
		return false;

	}

}
