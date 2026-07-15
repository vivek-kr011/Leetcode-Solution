class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        // All elements are initialize with 1
        Arrays.fill(ans, 1);

        // prefix => ans
        for (int i = 1; i < n; i++) {
            // prefix[i] = prefix[i - 1] * nums[i - 1];
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix = 1;
        // suffix
        for (int i = n - 2; i >= 0; i--) {
            // suffix[i] = suffix[i + 1] * nums[i + 1];
            suffix *= nums[i+1];
            ans[i] *= suffix;;
        }

        return ans;
    }
}
