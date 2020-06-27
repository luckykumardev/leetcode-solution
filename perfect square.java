class Solution {
 
    public int numSquares(int n) {
        int memo[] = new int[n+1];
        return rec(n, memo);
    }
    
    int rec(int n, int memo[]) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if(memo[n] > 0) return memo[n];
        int min = n;
        for (int i=1;i*i<=n;i++) {
            min = Math.min(rec(n-(i*i), memo), min);
        }
        memo[n] = min+1;
        return min+1;
    }
}