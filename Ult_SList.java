package ultlist;

public class Ult_SList {
	private class LNode
	{
		public int item;
	    public LNode next;
	    public LNode prev;

	    //--------------------------------------------------------------
	    //  Sets up the node
	    //--------------------------------------------------------------
	    public LNode(int newitem)
	    {
	    	item = newitem;
	    	next = null;
	    	prev = null;
	    }
	}
	private LNode ListEnd;
	
	public Ult_SList() {
		ListEnd = new LNode(Integer.MAX_VALUE);
		ListEnd.next = ListEnd;
		ListEnd.prev = ListEnd;
	}
	
	
	boolean isFull()  {
		return false; //Assume the size of a linked-list based implementation is UNBOUNDED for simplicity		
	}
	
	boolean isEmpty() {
		return ListEnd.next == ListEnd;
	}
	
	public int getLength() {
		if (isEmpty())
			return 0;
		else {
			LNode iterPos = ListEnd.next;
			int length=1;
			while (iterPos != ListEnd) {
				iterPos = iterPos.next;
				length++;
			}
			return length;
		}
	}
	private LNode FindItemNode(int fitem, int[] position) {
		position[0]=0;
		LNode nodeIter=ListEnd;
		   while ((nodeIter != null) && (nodeIter.next !=ListEnd ) && (nodeIter.next.item <fitem)) {
		      nodeIter=nodeIter.next;
		      position[0]++;
		   }
		   if ((nodeIter == null) || (nodeIter.next.item != fitem))
			   position[0] = -1;
		   return nodeIter;
	}

	public int getItem(int gitem) {
		int[] position = {0};
		FindItemNode(gitem,position);
		return position[0];
	}
	
	public void makeEmpty() {
		ListEnd.next = ListEnd;
		ListEnd.prev = ListEnd;
	}
	
	public void putItem(int pitem) {
	    LNode newNode = new LNode(pitem);
	    LNode current = ListEnd.next;

	    while (current != ListEnd && current.item < pitem) {
	        current = current.next;
	    }

	    newNode.prev = current.prev;
	    newNode.next = current;
	    current.prev.next = newNode;
	    current.prev = newNode;

	    if (newNode.next == ListEnd) {
	        ListEnd.prev = newNode;
	    }
	}
	
	void deleteItem(int ditem) throws Exception { //Find the item in question, and "unlink" it		
	    LNode current = ListEnd.next;

	    while (current != ListEnd && current.item != ditem) {
	        current = current.next;
	    }

	    if (current == ListEnd) {
	        throw new Exception("Item not present in list.");
	    }

	    current.prev.next = current.next;
	    current.next.prev = current.prev;

	    if (current == ListEnd.next) {
	        ListEnd.next = current.next;
	    }
	}

	void printList() { //simple function to print a list's items in stored order
	    if (isEmpty()) {
	        System.out.println("()");
	        return;
	    }

	    LNode iterPos = ListEnd.next;
	    System.out.print("(" + iterPos.item);
	    
	    iterPos = iterPos.next;
	    while (iterPos != ListEnd) {
	        System.out.print(", " + iterPos.item);
	        iterPos = iterPos.next;
	    }

	    System.out.println(")");
	}
}
