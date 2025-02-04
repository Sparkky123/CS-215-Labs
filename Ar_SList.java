package slist;

public class Ar_SList {
	
	private static final int MAX_SIZE = 10;
    private int[] ListItems;
    private int length;
    private int currentPos;

    public Ar_SList() {
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
    
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public void putItem(int pitem) throws Exception {
    	if (length >= MAX_SIZE) {
            throw new Exception("Cannot add item: List is full.");
        }
        int aloc = 0;
        boolean moreToSearch = aloc < length;
        
        while (moreToSearch && ListItems[aloc] < pitem) {
            aloc++;
            moreToSearch = aloc < length;
        }
        
        for (int i = length; i > aloc; i--) {
            ListItems[i] = ListItems[i - 1];
        }
        
        ListItems[aloc] = pitem;
        
        length++;
    }
    
    public void deleteItemShift(int ditem) {
    	boolean found = false;
        for (int loc = 0; loc < length; loc++) {
            if (ListItems[loc] == ditem) {
                found = true;
            }
            if (found && loc < length - 1) {
                ListItems[loc] = ListItems[loc + 1];
            }
        }

        if (found) {
            length--;
        }
    }
    
    public void deleteItem(int ditem) throws Exception{
    	int index = getItem(ditem);
        if (index == -1) {
            throw new Exception("Item not found: " + ditem);
        }
        deleteItemShift(ditem);
    }
    
    public void makeEmpty() {
        length = 0;
    }
    
    public void resetList() {
        currentPos = 0;
    }
    
    public int getItem(int gitem) {
        int first = 0;
        int last = length - 1;
        int mid = 0;
        boolean moreToSearch = first <= last;
        
        while (moreToSearch) {
            mid = (first + last) / 2;
            
            if (ListItems[mid] == gitem) {
                return mid;
            }
            else if (ListItems[mid] > gitem) {
                last = mid - 1;
            } 
            else {
                first = mid - 1;
            }
        }
        
        moreToSearch = first <= last;

        return -1;
    }
    public int getNextItem() throws Exception{
    	if (currentPos >= length) {
            throw new Exception("Cannot get next item: Already at the end of the list.");
        }
        currentPos++;
        return ListItems[currentPos - 1];
    }
    
    
    public int getMax() {
        return ListItems[length - 1];
    }
    
    public int getMin() {
        return ListItems[0];
    }
    
    public int getRange() {
        return getMax() - getMin();
    }
    
    public void printList() {
        System.out.print("(");
        for (int i = 0; i < length; i++) {
            System.out.print(ListItems[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
    
}
