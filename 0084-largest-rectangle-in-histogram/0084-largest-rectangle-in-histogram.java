class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] left = new int[n]; // left smaller nearest store
        int[] right = new int[n]; // right smaller nearest store

        Stack<Integer> s = new Stack<>(); // store index value

        // Calculate Right Smaller value
        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek(); // agar stack empty nahi hai to jo bhi stack ke top par hai jp bhi index hai wo hamara index ho jayega

            s.push(i); // current index push
        }

        // Reuse the stack
        while (!s.isEmpty()) {
            s.pop();
        }

        // calculate the Left Smaller value
        for (int i = 0; i < n; i++) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            left[i] = s.isEmpty() ? -1 : s.peek(); // agar stack empty nahi hai to jo bhi stack ke top par hai jp bhi index hai wo hamara index ho jayega

            s.push(i); // current index push
        }

        // Calculate Answer
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans, currArea);
        }

        return ans;
    }
}