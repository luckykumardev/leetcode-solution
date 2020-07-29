class Solution {
    public int maxProfit(int[] prices) {
        // If there is no price list or if there is only 1 stock, then
        // there is no way we can buy and sell, so we just return 0
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        
        // max(don't buy today, buy today)
        // Note that there cannot be any previous stock to sell first before buying another, yet
        buy[1] = Math.max(-prices[0], -prices[1]);
        
        // max(don't sell today, sell what you bought on day-0)
        sell[1] = Math.max(0, prices[1] - prices[0]);

        
        for (int i = 2; i < prices.length; i++) {
            // max(Don't buy today, buy today, but first sell what you bought day before yesterday)
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);  
            // max(Don't sell today, sell today but first buy the stock from yesterday)
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        
        // Return the answer from sell[], as only selling the stock you bought can give you
        // a chance for a profit
        return sell[prices.length - 1];
    }
}
