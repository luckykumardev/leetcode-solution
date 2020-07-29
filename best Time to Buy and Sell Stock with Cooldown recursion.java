class Solution {
    private int maxProfit(int i, int buyOrSell, int[] prices) {
        if (i >= prices.length) 
            return 0;

        int x = 0; 
        if (buyOrSell == 0) {
            int buy   =  maxProfit(i + 1, 1, prices) - prices[i];
            int noBuy =  maxProfit(i + 1, 0, prices); 
            x = Math.max(buy, noBuy);
         } else {
            int sell   = maxProfit(i + 2, 0, prices) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices);
            x = Math.max(sell, noSell);
        }
        return x;
    }
    
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, hm);
    }
}