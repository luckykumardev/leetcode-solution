class Solution {
   public int maxCoins(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int n = nums.length;
    int[] arr = new int[n + 2];
    arr[0] = 1;
    arr[n + 1] = 1;
    for(int i = 0; i < n; i++){
        arr[i + 1] = nums[i];
    }
    int[][] dp = new int[n + 2][n + 2];
    return helper(1, n, arr, dp);
}

int helper(int s, int e, int[] arr, int[][] dp){
    if(dp[s][e] != 0) return dp[s][e];
    int max = 0;
    for(int i = s; i <= e; i++){
        int left = helper(s, i-1, arr, dp);
        int right = helper(i + 1, e, arr, dp);
        max = Math.max(left + right +arr[s-1]*arr[e+1] *arr[i], max);
    }
    dp[s][e] = max;
    return max;
}
}