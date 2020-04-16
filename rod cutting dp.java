class Solution {

   public int rodCutting(int arr[]) {
       int dp[] = new int[arr.length];
       dp[1] = arr[1];

       for(int i =2; i <arr.length; i++){
           dp[i] = arr[i];
           
           int left = 1;
           int right = i -1;
           while(left <= right){
              
              if(dp[left] +dp[right] > dp[i])
                dp[i] = dp[left] +dp[right];
            
            left++; right--;
           }
       }

    return dp[dp.length-1];
   }







































   public int rec(int cost[], int n, int mem[]) {
	   
	     if(n == 0) return 0;
	     
	     int s = 1;
	     int e = n-1;
	     int ans = cost[n];
         if(mem[n] >0)
          return mem[n];
	     while(s<=e){
	         int left  = rec(cost, s, mem);
	         int right = rec(cost, e, mem);
	          if(left + right > ans )
	          ans = left + right;
	         s++;e--;
	     }
	     
         mem[n] = ans;
	     return ans;
	 }
























    public int uniquePaths(int m, int n) {
        
        //rec
        //int ans = rec(0,0, m-1, n-1);
        
        //memo
        // HashMap<String, Integer> mhm = new HashMap<>();
        // int ans = memo(0,0, m-1, n-1, mhm);
        
        return ans;
    }






    public static int rec(int si, int sj, int ei, int ej){
        if(si == ei && sj == ej)
             return 1;
        
        if(si >ei || sj >ej)
             return 0;
        
        int op1 = rec(si+1, sj, ei, ej);
        int op2 = rec(si, sj+1, ei, ej);
        return op1 + op2;
    }


    public static int memo(int si, int sj, int ei, int ej, HashMap<String, Integer> mhm){
        if(si == ei && sj == ej)
             return 1;
        
        if(si >ei || sj >ej) return 0;
        
        String key = si+"#"+sj;
        if(mhm.containsKey(key))
            return mhm.get(key);
        
        int op1 = memo(si+1, sj, ei, ej, mhm);
        int op2 = memo(si, sj+1, ei, ej, mhm);
        mhm.put(key, op1+op2);
        return op1 + op2;
    }

















}