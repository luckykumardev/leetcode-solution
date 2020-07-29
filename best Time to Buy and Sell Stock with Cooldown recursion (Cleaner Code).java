class Solution {
    HashMap<String, Integer> map;  // Variable to hold the map for memoization
    int [] prices;  // Int array reference variable to refer to the prices array
    
    /*
        buyOrSell {boolean} : true means we are selling
                              false means we are buying
        currDayIndex {int}: Holds the index value for the current day in the prices array
    */
    public int helper(int currDayIndex, boolean buyOrSell) {
        if (currDayIndex > this.prices.length - 1)
            return 0;
        
        String keyValue = currDayIndex + "" + buyOrSell;
        if (map.containsKey(keyValue))
            return map.get(keyValue);
        
        int answer;
        if (buyOrSell == true) {
            int selling = helper(currDayIndex + 2, !buyOrSell) + this.prices[currDayIndex];
            int notSelling = helper(currDayIndex + 1, buyOrSell);
            answer = Math.max(selling, notSelling);     
        } else {
            int buying = helper(currDayIndex + 1, !buyOrSell) - this.prices[currDayIndex];
            int notBuying = helper(currDayIndex + 1, buyOrSell);
            answer = Math.max(buying, notBuying);     
        }
        
        this.map.put(keyValue, answer);
        return answer;
    }
    
    public int maxProfit(int[] prices) {
        this.map = new HashMap<>();
        this.prices = prices;
        
        return helper(0, false);
    }
}

