class MinStack {

    Stack<Long> s;
    long minValue;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int value) {

        if (s.isEmpty()) {
            
            s.push((long) value);
            minValue = value;

        } else {

            if(value < minValue) {

                s.push(2L * value - minValue);
                minValue = value;

            } else {
                s.push((long) value);
            }
        }
    }

    public void pop() {
        
        if(s.peek() < minValue) {
            minValue = 2L * minValue - s.peek();
        }

        s.pop();
    }

    public int top() {
        
        if(s.peek() < minValue) {
            return (int) minValue;
        } else {
            return s.peek().intValue();
        }
    }

    public int getMin() {
        return (int) minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */