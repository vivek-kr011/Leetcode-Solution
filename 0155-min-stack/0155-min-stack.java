class MinStack {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Stack<Pair> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int value) {

        if (s.isEmpty()) {
            s.push(new Pair(value, value));
        } else {
            int minValue = Math.min(value, s.peek().second);
            s.push(new Pair(value, minValue));
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().first;
    }

    public int getMin() {
        return s.peek().second;
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