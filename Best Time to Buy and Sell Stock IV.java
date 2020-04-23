class Solution {
    public int maxProfit(int k, int[] prices) {
        int  n = prices.length;
         if (prices.length < 2) return 0;
        if (k > prices.length/2 ) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
              if(prices[i] - prices[i - 1] > 0)
                res += prices[i] - prices[i - 1];
            }
            return res;
        }
        
        int dp[][] = new int[k+1][n];
        for(int i =1; i <= k; i++){
            for(int j = 1; j< prices.length; j++){
                
                int not_sell = dp[i][j-1];
                int sell    = 0;
                for(int m =0; m<j; m++){
                    sell = Math.max(sell,  (prices[j] - prices[m]) + dp[i-1][m] );
                }
                dp[i][j] = Math.max(sell, not_sell); 
            }
        }
    
        return dp[k][prices.length-1];
    }
}
