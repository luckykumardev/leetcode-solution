public class Solution {
    public int minCost(int[][] costs) {
       
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        for(int i = 1; i < n; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}