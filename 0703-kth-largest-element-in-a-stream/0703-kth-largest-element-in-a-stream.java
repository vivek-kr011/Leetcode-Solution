class KthLargest {

    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        // Create an empty Min Heap
        pq = new PriorityQueue<>();

        // Add all initial elements using the add()
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        // If heap contains fewer than k elements,
        // add the new value because we need k largest elements

        // OR if the new value is greater than the smallest element currently present in the heap, it can be among k largest/
        if (pq.size() < k || val > pq.peek()) {

            // Insert the new value into the Min Heap
            pq.offer(val);

            // If heap contains more than k elements,
            // remove the smallest element to maintain only k largest elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // The smallest element among the k largest elements is the kth largest element
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */