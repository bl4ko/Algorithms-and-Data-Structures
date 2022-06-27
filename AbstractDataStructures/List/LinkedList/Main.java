
public class Main 
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.addFirst(0);
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(1);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(8);
		list.addLast(1);

		list.removeDuplicates();
		list.write();
	}
}
