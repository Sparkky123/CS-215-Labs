package recursion;

public class Ar_UList {

	private static final int MAX_SIZE = 250000;
	private int[] ListItems;
    private int length;
    private int currentPos;

    
    public Ar_UList() {
        ListItems = new int[MAX_SIZE];
        length = 0;
        currentPos = 0;
    }

    public int getLength() {
        return length;
    }
    
    public boolean isFull() {
        return length == MAX_SIZE;
    }
    
    public void putItem(int pitem) {
        ListItems[length] = pitem;
        length++;
    }
    
    public void deleteItemSwap(int ditem) {
        for (int loc = 0; loc < length; loc++) {
            if (ListItems[loc] == ditem) {
                ListItems[loc] = ListItems[length - 1];
                length--;
                return;
            }
        }
    }
        
    public void deleteItemShift(int ditem) { 
    	boolean indexfound = false;
    	for (int loc = 0; loc < length; loc++) {
    		if (!indexfound && ListItems[loc] == ditem) {
                indexfound = true;
            }
            if (indexfound && loc < length - 1) {
                ListItems[loc] = ListItems[loc + 1];
            }
        }
    	length--;
    	return;
    }
    
    public void deleteItem(int ditem) {
        deleteItemSwap(ditem);
    }
    
    public void makeEmpty() {
        length = 0;
    }
    
    public void resetList() {
        currentPos = 0;
    }
    
    public int getNextItem() {
        currentPos++;
        return ListItems[currentPos - 1];
    }
    
    public int getItem(int gitem) {
    	for (int loc = 0; loc < length; loc++) {
    		if (ListItems[loc] == gitem) {
                return loc;
            }
    	}
    	return -1;
    }
    
    public void printList() {
        if (length == 0) {
            System.out.println("List is empty.");
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(ListItems[i] + " ");
        }
        System.out.println();
    }
    
    // Homework question 4 part A
    public int getMax() {
    	int max = ListItems[0];
        for (int i = 1; i < length; i++) {
            if (ListItems[i] > max) {
                max = ListItems[i];
            }
        }
        return max;
    }
    
    // Homework question 4 part B
    public int getRange() {
    	int max = ListItems[0];
        int min = ListItems[0];

        for (int i = 1; i < length; i++) {
            if (ListItems[i] > max) {
                max = ListItems[i];
            }
            if (ListItems[i] < min) {
                min = ListItems[i];
            }
        }
        return max - min;
    }
    
    // Homework question 4 part C
	public Ar_UList duplicateInRange(int lbound, int ubound) {
		Ar_UList result = new Ar_UList();
	    for (int i = 0; i < length; i++) {
	        if (ListItems[i] >= lbound && ListItems[i] <= ubound) {
	            result.putItem(ListItems[i]);
	        }
	    }
	    return result;
	}

}
