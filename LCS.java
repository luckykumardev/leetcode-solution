class Solution {

    public int longestCommonSubsequence(String s, String t) {
    
         //memoization
        // int memo[][] = new int[s.length() +1][t.length() +1];
        // int ans = longestCommonSubsequence(s, t, memo);
        
           int ans = longestCommonSubsequenceDP(s, t);
        
        return ans;
         
    }

     public int longestCommonSubsequence(String s, String t, int memo[][]) {
         if(s.length() == 0  || t.length() == 0)
              return 0;
          
         if(memo[s.length()][t.length()] > 0){
             return memo[s.length()][t.length()];
         }

        if(s.charAt(0)  == t.charAt(0)){
            memo[s.length()][t.length()]  =1 + longestCommonSubsequence(s.substring(1), t.substring(1), memo); 
             return memo[s.length()][t.length()];
        }else{
            
            int op1 = longestCommonSubsequence(s, t.substring(1), memo);
            int op2 = longestCommonSubsequence(s.substring(1), t, memo);
            memo[s.length()][t.length()] = Math.max(op1, op2);
           return   memo[s.length()][t.length()];
        }

    }
    
    public int longestCommonSubsequenceDP(String s, String t)   {
        int m = s.length();
        int n = t.length();
        
        int dp[][] = new int[m+1][n+1];
         
        for(int i =1; i <=m; i++){
            for(int j =1; j <=n; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
    
}














