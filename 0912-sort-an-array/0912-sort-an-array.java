class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {

        if (start < end) {

            int mid = start + (end - start) / 2;

            mergeSort(nums, start, mid); // left half
            mergeSort(nums, mid+1, end); // right half

            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end) {
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        // for the left half 
        while(i <= mid ) {
            temp[k++] = nums[i++];
        }

        // for the right half
        while( j <= end) {
            temp[k++] = nums[j++];
        }

        // copy temp to original array
        for(k = 0, i = start; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }
}