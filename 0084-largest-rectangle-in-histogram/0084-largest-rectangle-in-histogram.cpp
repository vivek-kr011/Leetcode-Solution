class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {

        int n = heights.size();
        vector<int> left(n, 0);  // left smaller nearest store
        vector<int> right(n, 0); // right smaller nearest store

        stack<int> s;

        // CALCULATE RIGHT SAMLLER VALUE
        for(int i = n-1; i >= 0; i--) {

            while( s.size() > 0 && heights[s.top()] >= heights[i] ) {  // heights[i] is curr_value
                s.pop();
            }

            right[i] = s.empty() ? n : s.top();  // n is default value
            s.push(i);
        }

        // Element Remove from Stack
        while(!s.empty()) {
            s.pop();
        }

        // CALCULATE LEFT SMALLER VAVLUE 
        for(int i = 0; i < n; i++) {

            while( s.size() > 0 && heights[s.top()] >= heights[i] ) {  // heights[i] is curr_value
                s.pop();
            }

            left[i] = s.empty() ? -1 : s.top();
            s.push(i);
        }

        // Calculate Answer
        int ans = 0;

        for(int i = 0; i < n; i++) {

            int width = right[i] - left[i]-1;

            int currArea = heights[i] * width;

            ans = max(ans, currArea);
        }

        return ans;
        
    }
};