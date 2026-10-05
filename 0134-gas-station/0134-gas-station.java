class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, totalCost = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
        }

        for(int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        // Unique solution always exist
        int start = 0, currGas = 0;

        for(int i = 0; i < gas.length; i++) {
            currGas += (gas[i] - cost[i]);

            if(currGas < 0) {
                start = i + 1;
                currGas = 0;  // re-initialize currGas
            }
        }

        return start;
        
    }
}