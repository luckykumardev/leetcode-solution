class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int runningSum = 0;
        int count = 0 ;
        for(int i=0;i<A.length;i++){
            runningSum += A[i];
            int remainder = runningSum % K;
            if(remainder < 0) remainder +=K;
            if(map.containsKey(remainder)) {
                count += map.get(remainder);      
            }
             map.put(remainder, map.getOrDefault(remainder,0)+1);  
        }
        
         return count;
    }            
}