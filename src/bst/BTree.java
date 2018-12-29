package bst;

public class BTree<T extends Comparable<T>> {

	int count;
	Node root;

	private class Node {

		T data;
		Node left, right;

		Node(T data) {
			this.data = data;
			left = right = null;
		}
	}

	public boolean addElement(T value) {
		Node node = new Node(value);
		if (count == 0) {
			root = node;
			count++;
			return true;
		}
		Node temp = root;
		while (temp != null) {
			if (node.data.compareTo(temp.data)<0) {
				if (temp.left == null) {
					temp.left = node;
					count++;
					return true;
				} else {
					temp = temp.left;
				}
				// temp = temp.left;
			} else {
				if (node.data.compareTo(temp.data)>0) {

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
			// System.out.println(node.data); pre order
			display(node.left);
			System.out.println(node.data); // in order
			display(node.right);
			// System.out.println(node.data); post order
		}

	}

	public boolean removeElement(T value) {

		Node temp = root, prev = null;

		while (temp != null) {
			if (temp.data.compareTo(value)==0) {
				break;
			}
			if (temp.data.compareTo(value)<0) {
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
		node.data = null;
		node.left = node.right = null;
		node = null;
		return;
	}

	public boolean isPresent(T value) {
		Node temp = root;
		while (temp != null) {
			if (temp.data.compareTo(value)==0) {
				return true;
			}
			if (temp.data.compareTo(value)<0)
				temp = temp.right;
			else
				temp = temp.left;
		}
		//System.out.println("Element is not there in the tree.");
		return false;

	}

}
