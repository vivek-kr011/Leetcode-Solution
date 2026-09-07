class Solution {
public:

    /* Create a set of vector of integer to track a unique combinations */
    set<vector<int>> s;


    void getAllCombination(vector<int>& arr, int idx,  int tar, vector<vector<int>> &ans, vector<int> &combination) {

        /* Base Case */
        if(idx == arr.size() || tar < 0) {
            return;
        }

        if(tar == 0) {

            // tracking all of the unique combination
            if(s.find(combination) == s.end()) {
                ans.push_back(combination);
                s.insert(combination);
            }
                
            return;
        }

        combination.push_back(arr[idx]); // include

        /* Single Choice */
        getAllCombination(arr, idx+1, tar-arr[idx], ans, combination);

        /* Multiple choice */
        getAllCombination(arr, idx, tar-arr[idx], ans, combination);     

        combination.pop_back();

        /* Exclusion */   
        getAllCombination(arr, idx+1, tar, ans, combination);

    }

    vector<vector<int>> combinationSum(vector<int>& arr, int target) {

        vector<vector<int>> ans;
        vector<int> combination;

        getAllCombination(arr, 0, target, ans, combination);

        return ans;
    }
};