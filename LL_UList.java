package ulist;

public class LL_UList {
	private class LNode {
		private int item;
	    private LNode next;
	    
	    public LNode(int newitem) {
	    	item = newitem;
	    	next = null;
	    }
	}
	
	private LNode ListStart;
	private LNode currentPos;	
	
	public LL_UList() {
		ListStart = null;
		currentPos = null;
	}
	
	
	public boolean isFull()  {
		return false;	
	}
	
	public int getLength() {
		LNode iterPos = ListStart;
		int length=0;
		while (iterPos != null) {
			iterPos = iterPos.next;
			length++;
		}
		return length;
	}
	
	public int getItem(int gitem) {
		LNode iterPos = ListStart;
		int position = 0;
		while (iterPos != null && iterPos.item != gitem) {
			iterPos = iterPos.next;
			position++;
		}
		if (iterPos == null) 
			return -1;
		else
			return position;
	}
	
	public void makeEmpty() {
		ListStart = null;
	}
	
	public void putItem(int pitem) {
		LNode node = new LNode(pitem);
		node.next = ListStart;
		ListStart = node;
	}
	
	public void deleteItem(int ditem) {	
		LNode iterPos = ListStart;
		LNode nextPos;
		if (ListStart.item == ditem) 
			ListStart = ListStart.next;
		else {
			nextPos = iterPos.next;
			while (nextPos != null && nextPos.item != ditem) {
				iterPos = nextPos;
				nextPos = nextPos.next;
			}
			if (nextPos.item == ditem) 
				iterPos.next = nextPos.next;
		}
	}
	
	public void resetList() {
		currentPos = ListStart;
	}

	
	public int getNextItem() {
		int retItem = currentPos.item;
		currentPos = currentPos.next;
		return retItem;
	}

	public void printList() {
		LNode iterPos = ListStart;
		System.out.print("(");
		while (iterPos != null) {
			System.out.print(iterPos.item);
			if (iterPos.next != null)
				System.out.print(", ");
			iterPos = iterPos.next;
		}				
		System.out.println(")");
	}
	
	// Homework question 4 part A
	public int getMax() {
		int max = ListStart.item;
	    LNode current = ListStart.next;

	    while (current != null) {
	        if (current.item > max) {
	            max = current.item;
	        }
	        current = current.next;
	    }
	    return max;
	}
	
	// Homework question 4 part B
	public int getRange() {
		int max = ListStart.item;
	    int min = ListStart.item;
	    LNode current = ListStart.next;

	    while (current != null) {
	        if (current.item > max) {
	            max = current.item;
	        }
	        if (current.item < min) {
	            min = current.item;
	        }
	        current = current.next;
	    }

	    return max - min;
	}
	
	// Homework question 4 part C
	public LL_UList duplicateInRange(int lbound, int ubound) {
		LL_UList result = new LL_UList();
	    LNode current = ListStart;

	    while (current != null) {
	        if (current.item >= lbound && current.item <= ubound) {
	            result.putItem(current.item);
	        }
	        current = current.next;
	    }

	    return result;
	}
	
	
}