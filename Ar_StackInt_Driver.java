package stackqueue;

public class Ar_StackInt_Driver {
	public static void main(String[] args) throws Exception {
		Ar_StackInt myStack = new Ar_StackInt();
		for (int i = 1; i <= 3 ; i++)
			myStack.push(i);
		//Verify peek works correctly
		System.out.println("Peeking at the Stack: " + myStack.peek());
		System.out.println("1st Pop: " + myStack.pop());
		System.out.println("2nd Pop: " + myStack.pop());
		for (int i = 4; i <= 6 ; i++)
			myStack.push(i);
		System.out.println("3rd Pop: " + myStack.pop());
		System.out.println("4th Pop: " + myStack.pop());
		//Verify we can empty the queue successfully
		while (!myStack.isEmpty()) 
			System.out.println("Emptying the rest of the stack: " + myStack.pop());
		
		
		
		try {
            Ar_Stack<Integer> intStack = new Ar_Stack<>();
            intStack.push(10);
            intStack.push(20);
            System.out.println("Integer Stack Peek: " + intStack.peek());
            System.out.println("Integer Stack Pop: " + intStack.pop());
            System.out.println("Integer Stack Peek: " + intStack.peek());

            Ar_Stack<String> stringStack = new Ar_Stack<>();
            stringStack.push("Hello");
            stringStack.push("World");
            System.out.println("String Stack Peek: " + stringStack.peek());
            System.out.println("String Stack Pop: " + stringStack.pop());
            System.out.println("String Stack Pop: " + stringStack.pop());
            System.out.println("String Stack Peek: " + stringStack.peek());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		
	}
	
}
