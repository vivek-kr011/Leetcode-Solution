class Solution {
    public List<Integer> findMissingElements(int[] nums) { 
        List<Integer> missing = new ArrayList<>();
        if (nums == null || nums.length == 0) return missing;
        
        // 1. Sort the array to easily check consecutive numbers
        Arrays.sort(nums); 
        
        // 2. Identify gaps between adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            
            // Add all numbers strictly between current and next
            for (int j = current + 1; j < next; j++) {
                missing.add(j);
            }
        }
        
        return missing; 
    } 
}