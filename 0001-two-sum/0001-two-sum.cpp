class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        unordered_map<int, int> m;
        vector<int> ans; // both index return 

        for(int i = 0; i < nums.size(); i++) {
            int first = nums[i];
            int second = target - first;

            if(m.find(second) != m.end()) {  

                // if successfully found
                ans.push_back(i);
                ans.push_back(m[second]); // second value index

                break;
            }

            // store first value in the map
            m[first] = i;
        }

        return ans;
        
    }
};