class Solution {
    //O(n) time
    public int arrangeCoins(int n) {
        int i = 1;
        int res = 0;
        while(n >= i){
            n -= i; 
            res++;
            i++;
        }
        return res;
    }

    //O(logn) time
    public int arrangeCoins(int n) {
        long le = 0, ri = n;
        while (le <= ri){
            long mid = le + (ri - le) / 2;
            if (n >= (mid * (mid + 1) / 2)) le = mid + 1;
            else ri = mid - 1;
        }
        return (int)le - 1;
    }

    //O(1) time
    public int arrangeCoins(int n) {
       return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }

}