
public class Test {

	public static void main(String[] args) {
		
		LList<Integer> list= new LList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(9);
		list.add(4);
		list.add(-1);
		
		/*for(int i=0;i<1;i++)
			System.out.println(list.head.data);
		*/
		
		list.displayList();
		list.remove(3);
		list.displayList();
		
	}

}
