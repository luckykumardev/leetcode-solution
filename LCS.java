class Solution {

    public int longestCommonSubsequence(String s, String t) {
    
         
        int memo[][] = new int[s.length() +1][t.length() +1];
        int ans = longestCommonSubsequence(s, t, memo);
        return ans;
         
    }
 
    
    


































     public int longestCommonSubsequence(String s, String t, int memo[][]) {
         if(s.length() == 0  || t.length() == 0)
              return 0;
          
         if(memo[s.length()][t.length()] > 0){
             return memo[s.length()][t.length()];
         }

        if(s.charAt(0)  == t.charAt(0)){
            memo[s.length()][t.length()]  =1 + longestCommonSubsequence(s.substring(1), t.substring(1)); 
             return memo[s.length()][t.length()];
        }else{
            
            int op1 = longestCommonSubsequence(s, t.substring(1));
            int op2 = longestCommonSubsequence(s.substring(1), t);
            memo[s.length()][t.length()] = Math.max(op1, op2));
           return   memo[s.length()][t.length()];
        }

    }
    
    
}
















