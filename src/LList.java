
public class LList<T extends Comparable<T>> {
	
	Node head=null;
	int count=0;
	LList(){
	
	}
	
	private class Node{
		
		T data;
		Node next;
		Node(T data){
			this.data=data;
			next=null;
		}
	}
		
		
		public boolean add(T n) {
			
		/*	Node node= new Node(n);
			node.next=head;
			node.data=n;
			head=node;*/
		
			Node node= new Node(n);
			if(head==null) {head=node;count++;return true;}
			Node temp=head;
			Node prev=null;
			
			while(temp!=null) {
				if((temp.data).compareTo(n) > 0) {
					if(prev==null) {
						node.next=head;
						//node.data=n;
						head=node;
						break;
					}
					prev.next=node;
					node.next=temp;
					//node.data=n;
					break;
				}				
				prev=temp;
				temp=temp.next;
			}
			if(temp==null) {
				prev.next=node;
			}
			
			temp=prev=node=null;
			count++;
			return true;
		}
		
		public void displayList() {
			Node n=head;
			System.out.println("Total Elements: "+count);
			while(n!=null) {
				System.out.println(n.data);
				n=n.next;
			}
			
		}
		
		public boolean remove(T n) {
			
			Node temp=head;
			Node node=head.next;
			while(node!=null) {
				if(node.data==n) {
					temp.next=node.next;
					node.next=null;
					count--;
					return true;
				}
				temp=node;
				node=node.next;
			}
			return false;
			
		}

	
}
