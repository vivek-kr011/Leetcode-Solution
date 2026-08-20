class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1 ) return nums[0];

        int st = 0, end = n-1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(mid == 0 && nums[0] != nums[1]) return nums[mid];
            if(mid == n-1 && nums[n-1] != nums[n-2]) return nums[mid];

            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];

            if(mid % 2 == 0) {  // even case
                if(nums[mid-1] == nums[mid]) {
                    end = mid - 1;  // left
                } else {
                    st = mid + 1;  // right
                }
            } else {  // odd case
                if(nums[mid-1] == nums[mid]) {
                    st = mid + 1;  // right
                    
                } else {
                    end = mid - 1; // left
                }
            }
        }

        return -1;
        
    }

}