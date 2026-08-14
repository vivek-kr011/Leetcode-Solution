class Solution {
    public void merge(int[] arr, int start, int mid, int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int k = start, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public int countPairs(int[] arr, int start, int mid, int end) {
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (right <= end && (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;

            count += mergeSort(nums, start, mid);  // left half
            count += mergeSort(nums, mid + 1, end); // right half
            count += countPairs(nums, start, mid, end); 
            merge(nums, start, mid, end); // merging asorted values
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return mergeSort(nums, start, end);
    }
}
