class Solution {
    public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || i == j) {
                    //  First and last elements of every row are always 1
                    row.add(1);
                } else {
                    // Fetch the previous row to calculate the sum
                    List<Integer> prevRow = ans.get(i - 1);
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }

            }
            ans.add(row);
        }

        return ans;
    }
}