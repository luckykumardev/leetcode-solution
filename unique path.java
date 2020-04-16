class Solution {

   public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    
    for (int i = 0; i < m; i++) dp[i][n - 1] = 1;
    for (int i = 0; i < n; i++) dp[m - 1][i] = 1;
    
    for (int i = m - 2; i >=0; i--) {
        for (int j = n - 2; j >=0; j--) {
            dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
        }
    }
    
    return dp[0][0];
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