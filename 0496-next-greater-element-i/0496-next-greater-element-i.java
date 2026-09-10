class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Maps a number to its next greater element
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Build the map using a monotonic decreasing stack
        for (int num : nums2) {

            // the current number is the "next greater element" for the top element
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Build the result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If the element doesn't have a next greater item, default to -1
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}