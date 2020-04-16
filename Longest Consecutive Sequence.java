class Solution {
    public int longestConsecutive(int[] nums) {
       
        if(nums.length == 0) return 0;
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i = 0; i <nums.length; i++)
         hm.put(nums[i], true);
        
        for(Integer key: hm.keySet()){
            if(hm.containsKey(key - 1))
                hm.put(key, false);
        }
         
        int max_len = 1;
        
        for(Integer key : hm.keySet()){
	        int temp  = 1;
	        if(hm.get(key)){
	            while(hm.containsKey(key + temp)){
	                temp++;
	            }
	            if(temp > max_len)
	             max_len = temp;
	        }
	     }
        return max_len;        
    }
}