class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        /* Store all elements */
        for(int x : nums) {
            heap.add(x);

            if(heap.size() > k) {
                heap.poll(); // Top most element remove from heap
            }
        }

        return heap.peek();
    }
}