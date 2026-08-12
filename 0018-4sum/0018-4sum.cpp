class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& arr, int target) {
        int n = arr.size();
        vector<vector<int>> ans;

        // Step 1: Sort array
        sort(arr.begin(), arr.end());

        // Step 2: First loop for first number
        for (int i = 0; i < n; i++) {
            // Skip duplicates for first number
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            // Step 3: Second loop for second number
            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for second number
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                // Step 4: Two pointers for remaining two numbers
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long long sum =
                        (long long)arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        ans.push_back({arr[i], arr[j], arr[left], arr[right]});

                        // Move left pointer skipping duplicates
                        while (left < right && arr[left] == arr[left + 1])
                            left++;
                        // Move right pointer skipping duplicates
                        while (left < right && arr[right] == arr[right - 1])
                            right--;

                        left++;
                        right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ans;
    }
};