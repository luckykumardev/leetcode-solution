class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        int ans = rec(n, memo);
        return ans;
    }
    
    private static int rec(int n, int memo[]){
        if(n <= 1) return 1;
        if(memo[n] > 0) return memo[n];
        int op1 = rec(n-1, memo);
        int op2 = rec(n-2, memo);
        memo[n] = op1 + op2;
        return  op1 + op2;
    }
}