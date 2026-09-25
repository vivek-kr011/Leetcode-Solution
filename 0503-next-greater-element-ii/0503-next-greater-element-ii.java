class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> s = new Stack<>();
        
        int n = nums.length;
        int nextGreater[] = new int[n];

        // Traverse the array twice because it is circular
        for(int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            while(!s.isEmpty() && nums[s.peek()] <= nums[index]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextGreater[index] = -1;
            } else {
                nextGreater[index] = nums[s.peek()];
            }

            s.push(index);
        }

        return nextGreater;
    }
}