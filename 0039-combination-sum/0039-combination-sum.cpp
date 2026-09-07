class Solution {
public:
   void backtrack(vector<int>& nums, int target, int start, vector<int>& curr, vector<vector<int>>& result) {
       if (target == 0) {
           result.push_back(curr);
           return;
       }


       for (int i = start; i < nums.size(); ++i) {
           if (nums[i] > target) break;


           curr.push_back(nums[i]);
           backtrack(nums, target - nums[i], i, curr, result);
           curr.pop_back();
       }
   }


   vector<vector<int>> combinationSum(vector<int>& nums, int target) {
       sort(nums.begin(), nums.end()); // Enables pruning
       vector<vector<int>> result;
       vector<int> curr;
       backtrack(nums, target, 0, curr, result);
       return result;
   }
};




