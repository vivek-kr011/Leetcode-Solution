class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Variable to store current count of consecutive 1's
        int cnt = 0;
        // Variable to store maximum consecutive 1's
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is 1, increment count
            if (nums[i] == 1) {
                cnt++;
            } else {
                // If element is 0, reset count
                cnt = 0;
            }

            // Update maximum if current count is greater
            maxi = Math.max(maxi, cnt);
        }

        // Return maximum consecutive 1's
        return maxi;
    }
    
}