class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // Avoids potential integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2; 
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        
        // If target is not found, 'left' holds the insertion index
        return left; 
    }
}