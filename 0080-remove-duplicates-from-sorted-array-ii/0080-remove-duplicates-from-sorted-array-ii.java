class Solution {
    public int removeDuplicates(int[] nums) {
        
        // TC = O(n) SC = O(1)
        int i = 0;

        for( int n : nums) {
            if(i < 2 || n != nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;

    }
}