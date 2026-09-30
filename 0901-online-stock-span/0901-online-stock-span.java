class StockSpanner {

    private Stack<int[]> stack; // Stack stores pairs of integer array [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {

        int span = 1;

        // Pop elements while the current price is greater than or equal to the previous price
        while(!stack.isEmpty() && price >= stack.peek()[0]) {

            // Accumulate the span of the popped elements
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */