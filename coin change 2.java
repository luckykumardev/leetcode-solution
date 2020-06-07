class Solution {
    public int change(int amount, int[] coins) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        return helper(amount, coins, 0, hm);
    }

    private int helper(int amount, int[] coins, int index, HashMap<String, Integer> hm) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0 || index == coins.length) {
            return 0;
        }
        String key = amount + "codebix" + index;
        if(hm.containsKey(key))
            return hm.get(key);
        int result = 0;
        for(int i = index; i < coins.length; i++) {
            if(amount >= coins[i]) {
                result += helper(amount - coins[i], coins, i, hm);
            }
        }
        hm.put(key, result); 
        return result;
    }
}