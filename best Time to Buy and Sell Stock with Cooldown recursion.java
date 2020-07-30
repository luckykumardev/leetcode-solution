class Solution {
    private int maxProfit(int i, int buyOrSell, int[] prices, HashMap<String, Integer> hm) {
        if (i >= prices.length) 
            return 0;

        String key = i + "codebix" + buyOrSell;
        if(hm.containsKey(key))
            return hm.get(key);
        int x = 0; 
        if (buyOrSell == 0) {
            int buy   =  maxProfit(i + 1, 1, prices, hm) - prices[i];
            int noBuy =  maxProfit(i + 1, 0, prices, hm); 
            x = Math.max(buy, noBuy);
         } else {
            int sell   = maxProfit(i + 2, 0, prices, hm) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices, hm);
            x = Math.max(sell, noSell);
        }
        hm.put(key, x);
        return x;
    }
    
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, hm);
    }
}