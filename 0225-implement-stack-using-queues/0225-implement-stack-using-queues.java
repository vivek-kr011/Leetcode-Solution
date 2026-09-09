import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element onto the stack.
    public void push(int x) {
        // Add the new element to q2
        q2.add(x);
        
        // Push all the remaining elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on the top of the stack and returns it.
    public int pop() {
        return q1.remove();
    }
    
    // Returns the element on the top of the stack.
    public int top() {
        return q1.peek();
    }
    
    // Returns true if the stack is empty, false otherwise.
    public boolean empty() {
        return q1.isEmpty();
    }
}
