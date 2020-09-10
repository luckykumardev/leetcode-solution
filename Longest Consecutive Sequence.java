class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i =0; i <nums.length; i++)
            hm.put(nums[i], true);
      
        for(int i =0; i <nums.length; i++){
            if(hm.containsKey(nums[i] - 1)){
                hm.put(nums[i], false);
            }
        }
        
        int max = 0;
        for(Integer key : hm.keySet()){
            if(hm.get(key) == true){
                max = Math.max(max, findLength(hm, key));
             }
       }
        return max;        
    }
    
    private static int findLength(HashMap<Integer, Boolean> hm, int k){
        int ans  = 0;
        while(hm.containsKey(k)){
            ans++;
            k++;
        }
        return ans;
    }
}