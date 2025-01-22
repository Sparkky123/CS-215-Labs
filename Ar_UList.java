package ulist;

public class Ar_UList {

	private static final int MAX_SIZE = 10;
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

}
