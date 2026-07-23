class Solution {
public:
   int largestRectangleArea(vector<int>& heights) {
       int n = heights.size();
       stack<int> indexStack;  // Stack to store indices
       int maxArea = INT_MIN;

       // Iterate through the bars
       for (int i = 0; i < n; i++) {
           // Pop elements until we find a bar shorter than the current one
           while (!indexStack.empty() && heights[i] < heights[indexStack.top()]) {
               int topIndex = indexStack.top();
               indexStack.pop();
               int height = heights[topIndex];
              
               // Calculate width for the popped element
               int width = indexStack.empty() ? i : (i - indexStack.top() - 1);
               int area = height * width;
              
               // Update maximum area
               maxArea = max(maxArea, area);
           }
          
           // Push current index to the stack
           indexStack.push(i);
       }


       // Handle remaining bars in the stack
       while (!indexStack.empty()) {
           int topIndex = indexStack.top();
           indexStack.pop();
           int height = heights[topIndex];
          
           // Calculate width for the remaining elements
           int width = indexStack.empty() ? n : (n - indexStack.top() - 1);
           int area = height * width;
          
           // Update maximum area
           maxArea = max(maxArea, area);
       }


       return maxArea;
   }
};



