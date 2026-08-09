class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];        // increase with +1
            fast = nums[nums[fast]];    // increase with +2
        } 

        while (slow != fast); 

        slow = nums[0];

        while(slow != fast){ 
            slow = nums[slow];      // increase with +1
            fast = nums[fast];      // increase with +1
        }

        return slow;
    }
}