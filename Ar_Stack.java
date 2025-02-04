package stackqueue;

public class Ar_Stack<T> {
    public static final int MAXSIZE = 10;
    private int top;
    private T[] stackItems;

    @SuppressWarnings("unchecked")
    public Ar_Stack() {
        top = -1;
        stackItems = (T[]) new Object[MAXSIZE];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAXSIZE - 1;
    }

    public void push(T item) throws Exception {
        if (isFull()) {
            throw new Exception("Stack Overflow: Cannot push, stack is full.");
        }
        stackItems[++top] = item;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow: Cannot pop, stack is empty.");
        }
        return stackItems[top--];
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty: Cannot peek.");
        }
        return stackItems[top];
    }
}
