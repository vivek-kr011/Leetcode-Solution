class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // initital prefix sum = 0 with 1 occurance

        int prefixSum = 0, ans = 0;

        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];

            //check if (prefixSum - k) exists in the map
            if(map.containsKey(prefixSum - k)) {
                ans += map.get(prefixSum - k);
            }

            // store prefix sum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}