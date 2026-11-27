class KthLargest {

    int k;
    ArrayList<Integer> arr = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            arr.add(num);
        }
    }

    public int add(int val) {
        // for (int i = 0; i < arr.size(); i++) {
        //     arr.add(val);
        // }

        arr.add(val);

        Collections.sort(arr);

        return arr.get(arr.size() - k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */