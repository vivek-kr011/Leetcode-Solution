class Solution {
   public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

    int[] ans = new int[n];
    int[] prefix = new int[n];
    int[] suffix = new int[n];

    // All elements are initialize with 1
    Arrays.fill(ans, 1);
    Arrays.fill(prefix, 1);
    Arrays.fill(suffix, 1);

    // prefix
    for(int i = 1; i < n; i++) {
        prefix[i] = prefix[i-1] * nums[i-1];
    }
    // suffix
    for(int i = n-2; i >= 0; i--) {
        suffix[i] = suffix[i+1] * nums[i+1];
    }

    for(int i = 0; i<n; i++) {
        ans[i] = prefix[i] * suffix[i];
    }
    return ans;

   }
}
