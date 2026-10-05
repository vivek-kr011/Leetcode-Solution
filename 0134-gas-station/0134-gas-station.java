class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, totalCost = 0;

        // Unique solution always exist
        int start = 0, currGas = 0;

        for(int i = 0; i < gas.length; i++) {

            totalGas += gas[i];     // calculate totalGas
            totalCost += cost[i];   // calculate totalCost

            currGas += (gas[i] - cost[i]);

            if(currGas < 0) {
                start = i + 1;
                currGas = 0;  // re-initialize currGas
            }
        }

        // return start;
        
        // we use ternary Operator 
        return totalGas < totalCost ? -1 : start;   
        
    }
}