class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> v;
        deque<int> dq;
        dq.push_back(0);
        for (int i = 1; i < k; i++) {
            while (dq.empty() == false and nums[i] >= nums[dq.back()]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }

        v.push_back(nums[dq.front()]);

        for (int i = k; i < n; i++) {
            if (i - dq.front() + 1 > k)
                dq.pop_front();

            while (dq.empty() == false and nums[i] >= nums[dq.back()]) {
                dq.pop_back();
            }
            dq.push_back(i);

            v.push_back(nums[dq.front()]);
        }
        return v;
    }
};
