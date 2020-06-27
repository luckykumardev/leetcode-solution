class Solution {
    public int numSquares(int n) {
        return rec(n);
    }
    
    int rec(int n) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        int min = n;
        for (int i=1;i*i<=n;i++) {
            min = Math.min(rec(n-(i*i)), min);
        }
        return min+1;
    }
}